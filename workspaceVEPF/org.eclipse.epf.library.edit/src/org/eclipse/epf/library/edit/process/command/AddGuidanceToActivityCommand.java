//------------------------------------------------------------------------------
// Copyright (c) 2004, 2005 IBM Corporation.  All Rights Reserved.
//------------------------------------------------------------------------------
package org.eclipse.epf.library.edit.process.command;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epf.library.edit.LibraryEditPlugin;
import org.eclipse.epf.library.edit.util.TngUtil;
import org.eclipse.epf.uma.Activity;
import org.eclipse.epf.uma.Checklist;
import org.eclipse.epf.uma.Concept;
import org.eclipse.epf.uma.Example;
import org.eclipse.epf.uma.Guidance;
import org.eclipse.epf.uma.Guideline;
import org.eclipse.epf.uma.ReusableAsset;
import org.eclipse.epf.uma.Roadmap;
import org.eclipse.epf.uma.SupportingMaterial;


/**
 * Command to add guidance to activity
 *  
 * @author Shilpa Toraskar
 * @since 1.0
 */
public class AddGuidanceToActivityCommand extends AddMethodElementCommand {

	private List guidances;

	private Activity activity;

	private Collection modifiedResources;

	public AddGuidanceToActivityCommand(Activity activity, List guidances) {

		super(TngUtil.getOwningProcess(activity));

		this.guidances = guidances;
		this.activity = activity;

		this.modifiedResources = new HashSet();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {

		// add to default configuration if not there already
		if (!super.addToDefaultConfiguration(guidances))
			return;

		redo();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#redo()
	 */
	public void redo() {

		if (!guidances.isEmpty()) {
			for (Iterator it = guidances.iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj instanceof Guidance) {
					Guidance item = (Guidance) obj;

					// guidances for content element
					if (item instanceof Checklist) {
						activity.getChecklists().add(item);
					} else if (item instanceof Concept) {
						activity.getConcepts().add(item);
					} else if (item instanceof Example) {
						activity.getExamples().add(item);
					} else if (item instanceof SupportingMaterial) {
						activity.getSupportingMaterials().add(item);
					} else if (item instanceof Guideline) {
						activity.getGuidelines().add(item);
					} else if (item instanceof ReusableAsset) {
						activity.getReusableAssets().add(item);
					} else if (item instanceof Roadmap) {
						activity.getRoadmaps().add(item);
					} else {
						LibraryEditPlugin.getDefault().getLogger()
								.logError("Cant set guidance " + item.getType().getName() + ":" + item.getName()); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#undo()
	 */
	public void undo() {
		if (!guidances.isEmpty()) {
			// basically remove from configuration if anything was added
			super.undo();

			for (Iterator it = guidances.iterator(); it.hasNext();) {
				Object obj = it.next();
				if (obj instanceof Guidance) {
					Guidance item = (Guidance) obj;

					// guidances for content element
					if (item instanceof Checklist) {
						activity.getChecklists().remove(item);
					} else if (item instanceof Concept) {
						activity.getConcepts().remove(item);
					} else if (item instanceof Example) {
						activity.getExamples().remove(item);
					} else if (item instanceof SupportingMaterial) {
						activity.getSupportingMaterials().remove(item);
					} else if (item instanceof Guideline) {
						activity.getGuidelines().remove(item);
					} else if (item instanceof ReusableAsset) {
						activity.getReusableAssets().remove(item);
					} else if (item instanceof Roadmap) {
						activity.getRoadmaps().remove(item);
					} else {
						LibraryEditPlugin.getDefault().getLogger()
								.logError("Cant set guidance " + item.getType().getName() + ":" + item.getName()); //$NON-NLS-1$ //$NON-NLS-2$
					}
				}
			}
		}
	}

	protected boolean prepare() {
		return true;
	}

	public Collection getModifiedResources() {
		if (!guidances.isEmpty() ) {
			if (activity.eResource() != null) {
				modifiedResources.add(activity.eResource());
			}
		}
		return modifiedResources;
	}

	public Collection getAffectedObjects() {
		if (activity != null) {
			return Arrays.asList(new Object[] { activity });
		}
		return super.getAffectedObjects();
	}
}