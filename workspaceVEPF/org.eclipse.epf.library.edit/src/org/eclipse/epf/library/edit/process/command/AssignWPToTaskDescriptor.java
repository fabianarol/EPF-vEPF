//------------------------------------------------------------------------------
// Copyright (c) 2005, 2006 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.epf.library.edit.process.command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.epf.library.edit.TngAdapterFactory;
import org.eclipse.epf.library.edit.ui.UserInteractionHelper;
import org.eclipse.epf.library.edit.util.ProcessUtil;
import org.eclipse.epf.library.edit.util.TngUtil;
import org.eclipse.epf.uma.Activity;
import org.eclipse.epf.uma.MethodConfiguration;
import org.eclipse.epf.uma.TaskDescriptor;
import org.eclipse.epf.uma.WorkProduct;
import org.eclipse.epf.uma.WorkProductDescriptor;


/**
 * Command to assign work products to task descriptor. It will set external
 * inputs, mandatory inputs, optional inputs and outputs.
 * 
 * @author Shilpa Toraskar
 * @since 1.0
 */
public class AssignWPToTaskDescriptor extends AddMethodElementCommand {

	private List workProducts;

	private Activity activity;

	private TaskDescriptor taskDesc;

	private Collection modifiedResources;

	private int action;

	private HashMap map = new HashMap();

	List existingWPDescList = new ArrayList();

	List newWPDescList = new ArrayList();

	private MethodConfiguration config;

	/**
	 * 
	 */
	public AssignWPToTaskDescriptor(TaskDescriptor taskDesc, List workProducts,
			int action, MethodConfiguration config) {
		super(TngUtil.getOwningProcess(taskDesc));

		this.workProducts = workProducts;
		this.taskDesc = taskDesc;
		this.action = action;
		this.config = config;

		AdapterFactory aFactory = TngAdapterFactory.INSTANCE
				.getWBS_ComposedAdapterFactory();
		ItemProviderAdapter adapter = (ItemProviderAdapter) aFactory.adapt(
				taskDesc, ITreeItemContentProvider.class);
		Object parent = adapter.getParent(taskDesc);
		if (parent instanceof Activity) {
			this.activity = (Activity) parent;
		}
		this.modifiedResources = new HashSet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		// add to default configuration if not there already
		if (!super.addToDefaultConfiguration(workProducts))
			return;

		for (Iterator it = workProducts.iterator(); it.hasNext();) {
			WorkProduct wp = (WorkProduct) it.next();
			WorkProductDescriptor newWpDesc = null;

			boolean isNewDescriptor = false;
			// check for local descriptor
			newWpDesc = (WorkProductDescriptor) ProcessCommandUtil
					.getDescriptor(wp, activity, config);
			if (newWpDesc == null) {
				// check for inherited descriptor
				newWpDesc = (WorkProductDescriptor) ProcessCommandUtil
						.getInheritedDescriptor(wp, activity, config);
				if (newWpDesc == null) {
					newWpDesc = ProcessUtil.createWorkProductDescriptor(wp);
					isNewDescriptor = true;

				}
			}
			if (isNewDescriptor)
				newWPDescList.add(newWpDesc);
			else
				existingWPDescList.add(newWpDesc);

			// get deliverable
			WorkProductDescriptor deliverable = UserInteractionHelper
					.getDeliverable(activity, wp);
			if (deliverable != null) {
				map.put(newWpDesc, deliverable);
			}
		}

		redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {

		if (action == IActionTypeConstants.ADD_EXTERNAL_INPUT) {
			taskDesc.getExternalInput().addAll(existingWPDescList);
			taskDesc.getExternalInput().addAll(newWPDescList);
		} else if (action == IActionTypeConstants.ADD_MANDATORY_INPUT) {
			taskDesc.getMandatoryInput().addAll(existingWPDescList);
			taskDesc.getMandatoryInput().addAll(newWPDescList);
		} else if (action == IActionTypeConstants.ADD_OPTIONAL_INPUT) {
			taskDesc.getOptionalInput().addAll(existingWPDescList);
			taskDesc.getOptionalInput().addAll(newWPDescList);
		} else if (action == IActionTypeConstants.ADD_OUTPUT) {
			taskDesc.getOutput().addAll(existingWPDescList);
			taskDesc.getOutput().addAll(newWPDescList);
		}

		activity.getBreakdownElements().addAll(newWPDescList);

		if (map != null) {
			Set keyset = map.keySet();
			for (Iterator itor = keyset.iterator(); itor.hasNext();) {
				Object key = itor.next();
				WorkProductDescriptor wpDesc = (WorkProductDescriptor) map
						.get(key);

				// add to deliverable
				wpDesc.getDeliverableParts().add((WorkProductDescriptor) key);
			}
		}
	}

	public void undo() {

		// remove from configuration if anything was added
		super.undo();

		if (action == IActionTypeConstants.ADD_EXTERNAL_INPUT) {
			taskDesc.getExternalInput().removeAll(existingWPDescList);
			taskDesc.getExternalInput().removeAll(newWPDescList);
		} else if (action == IActionTypeConstants.ADD_MANDATORY_INPUT) {
			taskDesc.getMandatoryInput().removeAll(existingWPDescList);
			taskDesc.getMandatoryInput().removeAll(newWPDescList);
		} else if (action == IActionTypeConstants.ADD_OPTIONAL_INPUT) {
			taskDesc.getOptionalInput().removeAll(existingWPDescList);
			taskDesc.getOptionalInput().removeAll(newWPDescList);
		} else if (action == IActionTypeConstants.ADD_OUTPUT) {
			taskDesc.getOutput().removeAll(existingWPDescList);
			taskDesc.getOutput().removeAll(newWPDescList);
		}
		activity.getBreakdownElements().removeAll(newWPDescList);

		if (map != null) {
			Set keyset = map.keySet();
			for (Iterator itor = keyset.iterator(); itor.hasNext();) {
				Object key = itor.next();
				WorkProductDescriptor wpDesc = (WorkProductDescriptor) map
						.get(key);

				// remove it from deliverable
				wpDesc.getDeliverableParts()
						.remove((WorkProductDescriptor) key);
			}
		}
	}

	protected boolean prepare() {
		return true;
	}

	public Collection getModifiedResources() {
		if (workProducts != null &&  !workProducts.isEmpty()) {
			if (activity.eResource() != null) {
				modifiedResources.add(activity.eResource());
			}
			if (taskDesc.eResource() != null) {
				modifiedResources.add(taskDesc.eResource());
			}
		}
		return modifiedResources;
	}
}
