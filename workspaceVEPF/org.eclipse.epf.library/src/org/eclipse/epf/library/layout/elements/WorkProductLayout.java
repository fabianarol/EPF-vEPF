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
package org.eclipse.epf.library.layout.elements;

import java.util.List;

import org.eclipse.epf.library.configuration.ConfigurationHelper;
import org.eclipse.epf.library.layout.ElementLayoutManager;
import org.eclipse.epf.library.layout.util.XmlElement;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.WorkProduct;
import org.eclipse.epf.uma.util.AssociationHelper;


/**
 * The element layout for an Artifact.
 * 
 * @author Kelvin Low
 * @author Jinhua Xi
 * @since 1.0
 */
public class WorkProductLayout extends AbstractElementLayout {

	public WorkProductLayout() {
		super();
	}

	public void init(ElementLayoutManager layoutManager, MethodElement element) {
		super.__init(layoutManager, element);
	}

	/**
	 * @see org.eclipse.epf.library.layout.IElementLayout#getXmlElement(boolean)
	 */
	public XmlElement getXmlElement(boolean includeReferences) {
		XmlElement elementXml = super.getXmlElement(includeReferences);
		if (includeReferences) {

			// no this will lose the contributor
			// Role responsibleRole =
			// AssociationHelper.getResponsibleRole((WorkProduct)super.element);
			//multiplicity change for opposite features
			List responsibleRoles = ConfigurationHelper
					.calc0nFeatureValue(super.element,
							AssociationHelper.WorkProduct_ResponsibleRoles,
							layoutManager.getElementRealizer());
//			if (responsibleRole != null) {
//				MethodElement role = ConfigurationHelper.getCalculatedElement(
//						(MethodElement) responsibleRole, layoutManager
//								.getConfiguration());
//				if (role != null) {
//					String roleName = ((Role) role).getPresentationName();
//					if (roleName == null || roleName.length() == 0) {
//						roleName = role.getName();
//					}
//					elementXml.setAttribute("responsibleRoleName", roleName); //$NON-NLS-1$
//					addReference(AssociationHelper.WorkProduct_ResponsibleRole, elementXml, "responsibleRole", role); //$NON-NLS-1$
//				}
//			}
			addReferences(AssociationHelper.WorkProduct_ResponsibleRoles, elementXml, "responsibleRoles", responsibleRoles); //$NON-NLS-1$

			// Browsing a Configuration Includes a Relationship that is not Part of the Configuration
			// should call the configuration helper to realize the value
			// there is no opposite feature defined for this. 
			// we get the value in two steps:
			// 1. get the tasks that output this WP
			// 2. get the roles that is the responsible for the tasks
//			List modifyRoles = AssociationHelper
//					.getModifiedBy((WorkProduct) super.element);
//			modifyRoles = ConfigurationHelper.getCalculatedElements(
//					modifyRoles, layoutManager.getConfiguration());
			
//			List tasks = ConfigurationHelper.calc0nFeatureValue(
//					super.element, 
//					AssociationHelper.WorkProduct_OutputFrom_Tasks, 
//					layoutManager.getElementRealizer());
//			List modifyRoles = new ArrayList();
//			for (Iterator it = tasks.iterator(); it.hasNext(); ) {
//				Task t = (Task)it.next();
//				List roles = ConfigurationHelper.calc0nFeatureValue(
//						t, 
//						UmaPackage.eINSTANCE.getTask_PerformedBy(), 
//						layoutManager.getElementRealizer());
//				for (Iterator itr = roles.iterator(); itr.hasNext(); ) {
//					Object r = itr.next();
//					if ( !modifyRoles.contains(r) ) {
//						modifyRoles.add(r);
//					}
//				}
//			}
			
			List modifyRoles = ConfigurationHelper.calcModifyRoles(
					(WorkProduct)super.element, 
					layoutManager.getElementRealizer());
			
			// this guy does not have a defined opposite feature
			// just pass null as it's feature object, Jinhua Xi, 04/17/2006
			addReferences(null, elementXml, "modifyRoles", modifyRoles); //$NON-NLS-1$

			List domains = ConfigurationHelper.calc0nFeatureValue(
					super.element, AssociationHelper.WorkProduct_Domains,
					layoutManager.getElementRealizer());
			addReferences(AssociationHelper.WorkProduct_Domains, elementXml, "domains", domains); //$NON-NLS-1$

			List workProductTypes = ConfigurationHelper.calc0nFeatureValue(super.element,
					AssociationHelper.WorkProduct_WorkProductTypes,
					layoutManager.getElementRealizer());
			addReferences(AssociationHelper.WorkProduct_WorkProductTypes, elementXml, "workProductTypes", workProductTypes); //$NON-NLS-1$

			List mandatoryInputToTasks = ConfigurationHelper.calc0nFeatureValue(super.element,
					AssociationHelper.WorkProduct_MandatoryInputTo_Tasks,
					layoutManager.getElementRealizer());
			addReferences(AssociationHelper.WorkProduct_MandatoryInputTo_Tasks, elementXml,
					"mandatoryInputToTasks", mandatoryInputToTasks); //$NON-NLS-1$

			List optionalInputToTasks = ConfigurationHelper.calc0nFeatureValue(super.element,
					AssociationHelper.WorkProduct_OptionalInputTo_Tasks,
					layoutManager.getElementRealizer());
			addReferences(AssociationHelper.WorkProduct_OptionalInputTo_Tasks, elementXml,
					"optionalInputToTasks", optionalInputToTasks); //$NON-NLS-1$

			List outputFromTasks = ConfigurationHelper.calc0nFeatureValue(super.element,
					AssociationHelper.WorkProduct_OutputFrom_Tasks,
					layoutManager.getElementRealizer());
			addReferences(AssociationHelper.WorkProduct_OutputFrom_Tasks, 
					elementXml, "outputFromTasks", outputFromTasks); //$NON-NLS-1$
			
			// add the descriptors referencing this element
			super.processDescriptors(elementXml);

		}
		elementXml.setAttribute("ShowFullMethodContent", (layoutManager.getValidator().showExtraInfoForDescriptors()) ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		
		return elementXml;
	}


}