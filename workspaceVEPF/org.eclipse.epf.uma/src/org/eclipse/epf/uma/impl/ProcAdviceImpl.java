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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.epf.uma.ProcAdvice;
import org.eclipse.epf.uma.ProcPointcut;
import org.eclipse.epf.uma.UmaPackage;

import org.eclipse.epf.uma.ecore.impl.MultiResourceEObject;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Proc Advice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epf.uma.impl.ProcAdviceImpl#getRunsBy <em>Runs By</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcAdviceImpl extends MultiResourceEObject implements ProcAdvice {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The cached value of the '{@link #getRunsBy() <em>Runs By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRunsBy()
	 * @generated
	 * @ordered
	 */
	protected EList runsBy = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcAdviceImpl() {
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
		return UmaPackage.Literals.PROC_ADVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getRunsBy() {
		if (runsBy == null) {
			runsBy = new EObjectResolvingEList(ProcPointcut.class, this,
					UmaPackage.PROC_ADVICE__RUNS_BY);
		}
		return runsBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UmaPackage.PROC_ADVICE__RUNS_BY:
			return getRunsBy();
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
		case UmaPackage.PROC_ADVICE__RUNS_BY:
			getRunsBy().clear();
			getRunsBy().addAll((Collection) newValue);
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
		case UmaPackage.PROC_ADVICE__RUNS_BY:
			getRunsBy().clear();
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
		case UmaPackage.PROC_ADVICE__RUNS_BY:
			return runsBy != null && !runsBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcAdviceImpl