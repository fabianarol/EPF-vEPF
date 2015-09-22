/**
 * <copyright>
 * </copyright>
 *
 * $Id: DisciplineGrouping.java,v 1.4 2007/05/04 22:46:43 klow Exp $
 */
package org.eclipse.epf.xml.uma;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Discipline Grouping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Used to group Disciplines.  For example, the Discipline Grouping "Software Disciplines" would be the group of all disciplines related to developing software such as "Requirements Management" or "Testing"; "IT Infrastructure Management" would be a Disciplines Grouping for disciplines such as "IT Operational Services", "IT Customer Relationships", or "IT Enabling Services".  Disciplines can be associated to more than one Discipline Grouping.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.DisciplineGrouping#getGroup2 <em>Group2</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.DisciplineGrouping#getDiscipline <em>Discipline</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.xml.uma.UmaPackage#getDisciplineGrouping()
 * @model extendedMetaData="name='DisciplineGrouping' kind='elementOnly'"
 * @generated
 */
public interface DisciplineGrouping extends ContentCategory {
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
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getDisciplineGrouping_Group2()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:22'"
	 * @generated
	 */
	FeatureMap getGroup2();

	/**
	 * Returns the value of the '<em><b>Discipline</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Discipline</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Discipline</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getDisciplineGrouping_Discipline()
	 * @model type="java.lang.String" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='Discipline' group='#group:22'"
	 * @generated
	 */
	EList getDiscipline();

} // DisciplineGrouping