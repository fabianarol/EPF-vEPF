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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epf.library.configuration.ConfigurationHelper;
import org.eclipse.epf.library.edit.util.Suppression;
import org.eclipse.epf.library.layout.ElementLayoutManager;
import org.eclipse.epf.library.layout.IElementLayout;
import org.eclipse.epf.uma.Descriptor;
import org.eclipse.epf.uma.DescriptorDescription;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.RoleDescriptor;
import org.eclipse.epf.uma.TaskDescriptor;
import org.eclipse.epf.uma.UmaPackage;
import org.eclipse.epf.uma.WorkProductDescriptor;
import org.eclipse.epf.uma.ecore.util.OppositeFeature;
import org.eclipse.epf.uma.util.AssociationHelper;

/**
 * base layout class for descriptors
 * 
 * @author Jinhua Xi
 * @author Phong Nguyen Le
 * @since 1.0
 */
public abstract class DescriptorLayout extends AbstractProcessElementLayout {

	public static final Collection<EStructuralFeature> extraFeaturesFromContentElement = Arrays.asList(new EStructuralFeature[] {
			UmaPackage.eINSTANCE.getContentElement_Assets(),
			UmaPackage.eINSTANCE.getContentElement_Checklists(),
			UmaPackage.eINSTANCE.getContentElement_ConceptsAndPapers(),
			UmaPackage.eINSTANCE.getContentElement_Examples(),
			UmaPackage.eINSTANCE.getContentElement_Guidelines(),
			UmaPackage.eINSTANCE.getContentElement_SupportingMaterials()	
	});

	MethodElement linkedElement = null;

	AbstractElementLayout elementLayout = null;
	
	protected void __init(ElementLayoutManager layoutManager,
			MethodElement element) {
		super.__init(layoutManager, element);

		// 196094 - Task descriptor page should show the realized content of the linked element
		if (element instanceof TaskDescriptor) {
			linkedElement = ((TaskDescriptor) element).getTask();
			linkedElement = ConfigurationHelper.getCalculatedElement(linkedElement, layoutManager.getElementRealizer());
			if (linkedElement != null) {
				elementLayout = new TaskLayout();
			}
		} else if (element instanceof RoleDescriptor) {
			linkedElement = ((RoleDescriptor) element).getRole();
			linkedElement = ConfigurationHelper.getCalculatedElement(linkedElement, layoutManager.getElementRealizer());
			if (linkedElement != null) {
				elementLayout = new RoleLayout();
			}
		} else if (element instanceof WorkProductDescriptor) {
			linkedElement = ((WorkProductDescriptor) element).getWorkProduct();
			linkedElement = ConfigurationHelper.getCalculatedElement(linkedElement, layoutManager.getElementRealizer());
			if (linkedElement != null) {
				elementLayout = new WorkProductLayout();
			}
		}

		if (elementLayout != null) {
			elementLayout.init(layoutManager, linkedElement);
			elementLayout.setContentTarget(element);
		}	
		
		// make sure the linked element is loaded
		if ( linkedElement != null ) {
			for (Iterator<EObject> iter = linkedElement.eAllContents(); iter.hasNext();) {
				iter.next();
			}
		}
	}

	/**
	 * for descriptors, if the attribute is not defined, get from the libed
	 * element
	 * 
	 * @param feature EStructuralFeature
	 * @return Object
	 */
	public Object getAttributeFeatureValue(EStructuralFeature feature) {
		Object value = super.getAttributeFeatureValue(feature);
		if ((elementLayout == null) || (value != null)
				&& (value.toString().length() > 0)) {
			return value;
		}

		// if the attribute is not defined, grab the attribute value from the
		// linked element
		// specified attributes only. Add more feature here if needed
		if (feature == UmaPackage.eINSTANCE.getMethodElement_BriefDescription()) {
			return elementLayout.getAttributeFeatureValue(feature);
		}

		return value;
	}

	/**
	 * get the layout for a child element of this element
	 * ActivityElementLayout should override this method to create layout with node path
	 * @param child
	 * @return IElementLayout
	 */
	protected IElementLayout getChildLayout(MethodElement child)
	{
		if ( layoutManager.getValidator().showExtraInfoForDescriptors() 
				&& (child instanceof DescriptorDescription) ) {
			DescriptorDescriptionLayout l = new DescriptorDescriptionLayout(this.element);
			l.init(layoutManager, child);
			return l;
		} else {
			return layoutManager.getLayout(child, true);
		}
	}
	
	protected Collection<EStructuralFeature> getExtraFeaturesFromContentElement() {
		return extraFeaturesFromContentElement;
	}

	protected boolean acceptFeatureValue(EStructuralFeature feature,
			Object value) {
		
		Suppression sup = super.getSuppression(super.owningProcess);
		if ( sup != null ) {
			// check suppression
			if ( value instanceof List ) {
				List items = (List)value;
				int i = 0;
				while ( i < items.size() ) {
					Object v = items.get(i);
					if ( isSuppressed(sup, feature, v) ) {
						items.remove(i);
					} else {
						i++;
					}
				}
				
				if ( items.size() == 0 ) {
					return false;
				}
			} else {
				if ( isSuppressed(sup, feature, value) ) {
					return false;
				}
			}
		}
		
		return super.acceptFeatureValue(feature, value);
	}
	
	protected boolean isSuppressed(Suppression sup, EStructuralFeature feature, Object element) {
		if ( element instanceof Descriptor ) {
			return sup.isSuppressed(element);
		}
		
		return false;
	}
	
	protected boolean isTaskOppositeFeature(OppositeFeature feature) {
		return (feature == AssociationHelper.RoleDescriptor_PrimaryTaskDescriptors)
		|| ( feature == AssociationHelper.RoleDescriptor_AdditionalTaskDescriptors)
		|| ( feature == AssociationHelper.RoleDescriptor_AssistsIn_TaskDescriptors)
		|| ( feature == AssociationHelper.WorkProductDescriptor_ExternalInputTo_TaskDescriptors)
		|| ( feature == AssociationHelper.WorkProductDescriptor_MandatoryInputTo_TaskDescriptors)
		|| ( feature == AssociationHelper.WorkProductDescriptor_OptionalInputTo_TaskDescriptors)
		|| ( feature == AssociationHelper.WorkProductDescriptor_OutputFrom_TaskDescriptors);
		
	}
}