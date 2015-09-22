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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.epf.uma.RoleDescription;
import org.eclipse.epf.uma.UmaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epf.uma.impl.RoleDescriptionImpl#getSkills <em>Skills</em>}</li>
 *   <li>{@link org.eclipse.epf.uma.impl.RoleDescriptionImpl#getAssignmentApproaches <em>Assignment Approaches</em>}</li>
 *   <li>{@link org.eclipse.epf.uma.impl.RoleDescriptionImpl#getSynonyms <em>Synonyms</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleDescriptionImpl extends ContentDescriptionImpl implements
		RoleDescription {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The default value of the '{@link #getSkills() <em>Skills</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkills()
	 * @generated
	 * @ordered
	 */
	protected static final String SKILLS_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSkills() <em>Skills</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSkills()
	 * @generated
	 * @ordered
	 */
	protected String skills = SKILLS_EDEFAULT;

	/**
	 * The default value of the '{@link #getAssignmentApproaches() <em>Assignment Approaches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignmentApproaches()
	 * @generated
	 * @ordered
	 */
	protected static final String ASSIGNMENT_APPROACHES_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getAssignmentApproaches() <em>Assignment Approaches</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssignmentApproaches()
	 * @generated
	 * @ordered
	 */
	protected String assignmentApproaches = ASSIGNMENT_APPROACHES_EDEFAULT;

	/**
	 * The default value of the '{@link #getSynonyms() <em>Synonyms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynonyms()
	 * @generated
	 * @ordered
	 */
	protected static final String SYNONYMS_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getSynonyms() <em>Synonyms</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSynonyms()
	 * @generated
	 * @ordered
	 */
	protected String synonyms = SYNONYMS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RoleDescriptionImpl() {
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
		return UmaPackage.Literals.ROLE_DESCRIPTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSkills() {
		return skills;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSkills(String newSkills) {
		String oldSkills = skills;
		skills = newSkills;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					UmaPackage.ROLE_DESCRIPTION__SKILLS, oldSkills, skills));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAssignmentApproaches() {
		return assignmentApproaches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssignmentApproaches(String newAssignmentApproaches) {
		String oldAssignmentApproaches = assignmentApproaches;
		assignmentApproaches = newAssignmentApproaches;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					UmaPackage.ROLE_DESCRIPTION__ASSIGNMENT_APPROACHES,
					oldAssignmentApproaches, assignmentApproaches));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSynonyms() {
		return synonyms;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSynonyms(String newSynonyms) {
		String oldSynonyms = synonyms;
		synonyms = newSynonyms;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					UmaPackage.ROLE_DESCRIPTION__SYNONYMS, oldSynonyms,
					synonyms));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UmaPackage.ROLE_DESCRIPTION__SKILLS:
			return getSkills();
		case UmaPackage.ROLE_DESCRIPTION__ASSIGNMENT_APPROACHES:
			return getAssignmentApproaches();
		case UmaPackage.ROLE_DESCRIPTION__SYNONYMS:
			return getSynonyms();
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
		case UmaPackage.ROLE_DESCRIPTION__SKILLS:
			setSkills((String) newValue);
			return;
		case UmaPackage.ROLE_DESCRIPTION__ASSIGNMENT_APPROACHES:
			setAssignmentApproaches((String) newValue);
			return;
		case UmaPackage.ROLE_DESCRIPTION__SYNONYMS:
			setSynonyms((String) newValue);
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
		case UmaPackage.ROLE_DESCRIPTION__SKILLS:
			setSkills(SKILLS_EDEFAULT);
			return;
		case UmaPackage.ROLE_DESCRIPTION__ASSIGNMENT_APPROACHES:
			setAssignmentApproaches(ASSIGNMENT_APPROACHES_EDEFAULT);
			return;
		case UmaPackage.ROLE_DESCRIPTION__SYNONYMS:
			setSynonyms(SYNONYMS_EDEFAULT);
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
		case UmaPackage.ROLE_DESCRIPTION__SKILLS:
			return SKILLS_EDEFAULT == null ? skills != null : !SKILLS_EDEFAULT
					.equals(skills);
		case UmaPackage.ROLE_DESCRIPTION__ASSIGNMENT_APPROACHES:
			return ASSIGNMENT_APPROACHES_EDEFAULT == null ? assignmentApproaches != null
					: !ASSIGNMENT_APPROACHES_EDEFAULT
							.equals(assignmentApproaches);
		case UmaPackage.ROLE_DESCRIPTION__SYNONYMS:
			return SYNONYMS_EDEFAULT == null ? synonyms != null
					: !SYNONYMS_EDEFAULT.equals(synonyms);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (skills: "); //$NON-NLS-1$
		result.append(skills);
		result.append(", assignmentApproaches: "); //$NON-NLS-1$
		result.append(assignmentApproaches);
		result.append(", synonyms: "); //$NON-NLS-1$
		result.append(synonyms);
		result.append(')');
		return result.toString();
	}

} //RoleDescriptionImpl