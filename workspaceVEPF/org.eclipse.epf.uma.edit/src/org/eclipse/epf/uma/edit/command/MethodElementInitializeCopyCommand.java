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
package org.eclipse.epf.uma.edit.command;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.command.InitializeCopyCommand;
import org.eclipse.emf.edit.command.CopyCommand.Helper;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.epf.uma.ContentDescription;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.ecore.util.OppositeFeature;
import org.eclipse.epf.uma.provider.UmaEditPlugin;
import org.eclipse.epf.uma.util.UmaUtil;

/**
 * A command that takes an uninitialized copy of a method element and sets a new
 * GUID. If the original element is a <code>ContentElement</code> with a valid
 * <code>ContentDescription</code>, a copy of the
 * <code>ContentDescription</code> is also created.
 * 
 * @author Phong Nguyen Le
 * @since 1.0
 */
public class MethodElementInitializeCopyCommand extends InitializeCopyCommand {

	/**
	 * Creates a new instance.
	 * 
	 * @param domain
	 *            the editing domain
	 * @param owner
	 *            the object being copied
	 * @param copyHelper
	 *            a helper class that is used to keep track of copied objects
	 *            and their associated copies
	 */
	public MethodElementInitializeCopyCommand(EditingDomain domain,
			EObject owner, Helper copyHelper) {
		super(domain, owner, copyHelper);
	}

	/**
	 * @see org.eclipse.emf.edit.command.InitializeCopyCommand#doExecute()
	 */
	public void doExecute() {
		super.doExecute();

		// generate new GUID for the copy
		//
		if (copy instanceof MethodElement) {
			MethodElement e = ((MethodElement) copy);
			if (e instanceof ContentDescription) {
				EObject eContainer = e.eContainer();
				if (eContainer instanceof MethodElement) {
					e.setGuid(UmaUtil.generateGUID(((MethodElement) eContainer)
							.getGuid()));
				} else {
					e.setGuid(UmaUtil.generateGUID());
					UmaEditPlugin.INSTANCE
							.log("MethodElementInitializeCopyCommand: eContainer not initialized for " + e); //$NON-NLS-1$
				}
			} else {
				e.setGuid(UmaUtil.generateGUID());
			}
		}
	}

	/**
	 * Iterates over the references of the owner object and sets them
	 * accordingly in the copy. Includes coping of opposite features.
	 */
	private void doCopyReferences() {
		if (owner instanceof ContentDescription) {
			super.copyReferences();
			return;
		}
		for (Iterator references = getReferencesToCopy().iterator(); references
				.hasNext();) {
			EReference reference = (EReference) references.next();
			if (!reference.isChangeable() || reference.isDerived()) {
				continue;
			}

			EReference reverseReference = reference.getEOpposite();

			Object value = owner.eGet(reference);
			if (value == null) {
				continue;
			}

			OppositeFeature oppositeFeature = OppositeFeature
					.getOppositeFeature(reference);
			boolean copiedTargetRequired = reverseReference != null
					|| reference.isContainment()
					|| (oppositeFeature != null && !oppositeFeature.isMany());
			// "many" opposite feature does not require copied target, it is
			// treated as a regular non-containment reference
			// TODO: bidirectional relationships are not automatically copied in
			// EMF implementation
			if (reference.isMany()) {
				List valueList = (List) value;
				if (!valueList.isEmpty()) {
					EList copyList = (EList) copy.eGet(reference);
					int index = 0;
					for (Iterator valueIter = valueList.iterator(); valueIter
							.hasNext(); ++index) {
						EObject object = null;
						try {
							object = (EObject) valueIter.next();
						} catch (Exception e) {
							UmaEditPlugin.INSTANCE.log(e);
						}
						EObject target = copyHelper.getCopyTarget(object,
								copiedTargetRequired);
						if (target == null)
							break; // if one is null, they'll all be null
						if (reverseReference != null) {
							int position = copyList.indexOf(target);
							if (position == -1) {
								copyList.add(index, target);
							} else {
								copyList.move(index, target);
							}
						} else {
							copyList.add(target);
						}
					}
				}
			} else {
				EObject target = copyHelper.getCopyTarget((EObject) value,
						copiedTargetRequired);
				if (target != null) {
					copy.eSet(reference, target);
				}
			}
		}
	}

	protected void copyReferences() {
		doCopyReferences();
	}

}