/**
 * <copyright>
 * </copyright>
 *
 * $Id: RoleSet.java,v 1.4 2007/05/04 22:46:43 klow Exp $
 */
package org.eclipse.epf.xml.uma;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role Set</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Organizes Roles into categories.  It is used to group roles together that have certain commonalities.  For example, the "Analysts" Role Set could group the "Business Process Analyst", "System Analyst", as well as "Requirements Specifier" roles.  All of these work with similar techniques and have overlapping skills, but are required as distinct roles for a method (e.g. the method the IBM Rational Unified Process is based on).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.RoleSet#getGroup2 <em>Group2</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.RoleSet#getRole <em>Role</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.xml.uma.UmaPackage#getRoleSet()
 * @model extendedMetaData="name='RoleSet' kind='elementOnly'"
 * @generated
 */
public interface RoleSet extends ContentCategory {
	/**
	 * Returns the value of the '<em><b>Group2</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group2</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group2</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getRoleSet_Group2()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:22'"
	 * @generated
	 */
	FeatureMap getGroup2();

	/**
	 * Returns the value of the '<em><b>Role</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getRoleSet_Role()
	 * @model type="java.lang.String" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Role' group='#group:22'"
	 * @generated
	 */
	EList getRole();

} // RoleSet