/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkDefinition.java,v 1.2 2006/06/23 00:01:26 jxi Exp $
 */
package org.eclipse.epf.xml.uma;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Work Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An abstract Method Element that generalizes all descriptions of work within the Unified Method Architecture.  This package introduces two concrete types of Work Definitions: Task and Step.  Work Definitions can contain sets of pre- and post-conditions defining constraints that need to be valid before the described work can begin or before it can be declared as finished.  Note that general ownedRules can be used to define additional constraints and rules for Work Definitions.
 * Work Definitions represent behavioral descriptions for doing work.  These behavioral descriptions are not bound to one specific classifier, but represent an arbitrary definition of work.  For example, a Work Definition could represent work that is being performed by a specific Role (e.g. a Role performing a specific Task or Steps of a Task), by many Roles working in close collaboration (many Roles all working together on the same interdisciplinary Task), or complex work that is performed throughout the lifecycle (e.g. a process defining a breakdown structure for organizing larger composite units of work performed by many Roles working in collaboration).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.WorkDefinition#getPrecondition <em>Precondition</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.WorkDefinition#getPostcondition <em>Postcondition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.xml.uma.UmaPackage#getWorkDefinition()
 * @model extendedMetaData="name='WorkDefinition' kind='elementOnly'"
 * @generated
 */
public interface WorkDefinition extends MethodElement {
	/**
	 * Returns the value of the '<em><b>Precondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Precondition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Precondition</em>' attribute.
	 * @see #setPrecondition(String)
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getWorkDefinition_Precondition()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Precondition'"
	 * @generated
	 */
	String getPrecondition();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.xml.uma.WorkDefinition#getPrecondition <em>Precondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Precondition</em>' attribute.
	 * @see #getPrecondition()
	 * @generated
	 */
	void setPrecondition(String value);

	/**
	 * Returns the value of the '<em><b>Postcondition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Postcondition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Postcondition</em>' attribute.
	 * @see #setPostcondition(String)
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getWorkDefinition_Postcondition()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='Postcondition'"
	 * @generated
	 */
	String getPostcondition();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.xml.uma.WorkDefinition#getPostcondition <em>Postcondition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Postcondition</em>' attribute.
	 * @see #getPostcondition()
	 * @generated
	 */
	void setPostcondition(String value);

} // WorkDefinition