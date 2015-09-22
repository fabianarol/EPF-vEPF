/**
 * <copyright>
 * </copyright>
 *
 * $Id: ProcessPlanningTemplate.java,v 1.5 2007/05/04 22:46:43 klow Exp $
 */
package org.eclipse.epf.xml.uma;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Planning Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A special Process that is prepared for instantiation by a project planning tool.  Typically, it is created based on a Process such as a Delivery Process as a whole (e.g. in case of a waterfall-based development approach) or in parts (e.g. in case of an iterative development approach).
 * A Process Planning Template represents a partially finished plan for a concrete project.  It uses the same information structures as all other Process Types to represent templates for project plans.  However, certain planning decisions have already been applied to the template as well as information has been removed and/or reformatted to be ready for export to a specific planning tool.  Examples for such decisions are: a template has been created to represent a plan for a particular Iteration in an iterative development project, which fr example distinguishes early from late iterations in the Elaboration phase of a project; if the targeted planning tool cannot represent input and output of Task, then these have been removed from the structure; certain repetitions have been already applied, e.g. stating that a cycle of specific Task grouped in an Activity have to be repeated n-times; etc.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.ProcessPlanningTemplate#getGroup3 <em>Group3</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.ProcessPlanningTemplate#getBaseProcess <em>Base Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcessPlanningTemplate()
 * @model extendedMetaData="name='ProcessPlanningTemplate' kind='elementOnly'"
 * @generated
 */
public interface ProcessPlanningTemplate extends org.eclipse.epf.xml.uma.Process {
	/**
	 * Returns the value of the '<em><b>Group3</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.util.FeatureMap.Entry}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group3</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group3</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcessPlanningTemplate_Group3()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.EFeatureMapEntry" many="true"
	 *        extendedMetaData="kind='group' name='group:44'"
	 * @generated
	 */
	FeatureMap getGroup3();

	/**
	 * Returns the value of the '<em><b>Base Process</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Process</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Process</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcessPlanningTemplate_BaseProcess()
	 * @model type="java.lang.String" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" transient="true" volatile="true" derived="true"
	 *        extendedMetaData="kind='element' name='BaseProcess' group='#group:44'"
	 * @generated
	 */
	EList getBaseProcess();

} // ProcessPlanningTemplate