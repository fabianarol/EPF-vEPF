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
package org.eclipse.epf.uma.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.epf.uma.Activity;
import org.eclipse.epf.uma.ContentElement;
import org.eclipse.epf.uma.Practice;
import org.eclipse.epf.uma.UmaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Practice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epf.uma.impl.PracticeImpl#getSubPractices <em>Sub Practices</em>}</li>
 *   <li>{@link org.eclipse.epf.uma.impl.PracticeImpl#getContentReferences <em>Content References</em>}</li>
 *   <li>{@link org.eclipse.epf.uma.impl.PracticeImpl#getActivityReferences <em>Activity References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PracticeImpl extends GuidanceImpl implements Practice {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The cached value of the '{@link #getSubPractices() <em>Sub Practices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubPractices()
	 * @generated
	 * @ordered
	 */
	protected EList subPractices = null;

	/**
	 * The cached value of the '{@link #getContentReferences() <em>Content References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentReferences()
	 * @generated
	 * @ordered
	 */
	protected EList contentReferences = null;

	/**
	 * The cached value of the '{@link #getActivityReferences() <em>Activity References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActivityReferences()
	 * @generated
	 * @ordered
	 */
	protected EList activityReferences = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PracticeImpl() {
		super();

		//UMA-->
		reassignDefaultValues();
		//UMA<--
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmaPackage.Literals.PRACTICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getSubPractices() {
		if (subPractices == null) {
			subPractices = new EObjectContainmentEList.Resolving(
					Practice.class, this, UmaPackage.PRACTICE__SUB_PRACTICES);
		}
		return subPractices;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getContentReferences() {
		if (contentReferences == null) {
			contentReferences = new EObjectResolvingEList(ContentElement.class,
					this, UmaPackage.PRACTICE__CONTENT_REFERENCES);
		}
		return contentReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getActivityReferences() {
		if (activityReferences == null) {
			activityReferences = new EObjectResolvingEList(Activity.class,
					this, UmaPackage.PRACTICE__ACTIVITY_REFERENCES);
		}
		return activityReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case UmaPackage.PRACTICE__SUB_PRACTICES:
			return ((InternalEList) getSubPractices()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UmaPackage.PRACTICE__SUB_PRACTICES:
			return getSubPractices();
		case UmaPackage.PRACTICE__CONTENT_REFERENCES:
			return getContentReferences();
		case UmaPackage.PRACTICE__ACTIVITY_REFERENCES:
			return getActivityReferences();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case UmaPackage.PRACTICE__SUB_PRACTICES:
			getSubPractices().clear();
			getSubPractices().addAll((Collection) newValue);
			return;
		case UmaPackage.PRACTICE__CONTENT_REFERENCES:
			getContentReferences().clear();
			getContentReferences().addAll((Collection) newValue);
			return;
		case UmaPackage.PRACTICE__ACTIVITY_REFERENCES:
			getActivityReferences().clear();
			getActivityReferences().addAll((Collection) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
		case UmaPackage.PRACTICE__SUB_PRACTICES:
			getSubPractices().clear();
			return;
		case UmaPackage.PRACTICE__CONTENT_REFERENCES:
			getContentReferences().clear();
			return;
		case UmaPackage.PRACTICE__ACTIVITY_REFERENCES:
			getActivityReferences().clear();
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		//UMA-->
		EStructuralFeature feature = getFeatureWithOverridenDefaultValue(featureID);
		if (feature != null) {
			return isFeatureWithOverridenDefaultValueSet(feature);
		}
		//UMA<--		
		switch (featureID) {
		case UmaPackage.PRACTICE__SUB_PRACTICES:
			return subPractices != null && !subPractices.isEmpty();
		case UmaPackage.PRACTICE__CONTENT_REFERENCES:
			return contentReferences != null && !contentReferences.isEmpty();
		case UmaPackage.PRACTICE__ACTIVITY_REFERENCES:
			return activityReferences != null && !activityReferences.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PracticeImpl