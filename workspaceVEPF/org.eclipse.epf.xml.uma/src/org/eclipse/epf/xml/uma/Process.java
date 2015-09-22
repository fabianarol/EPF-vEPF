/**
 * <copyright>
 * </copyright>
 *
 * $Id: Process.java,v 1.3 2007/04/05 20:50:18 klow Exp $
 */
package org.eclipse.epf.xml.uma;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A special Activity that describes a structure for particular types of development projects.  To perform such a development project a Processes would be 'instantiated' and adapted for the specific situation.  Process is an abstract class and this meta-model defines different special types of Processes for different process management applications and different situations of process reuse.  Every Process comprises of and is the top-level element of an n-level breakdown structure using the Nesting association defined on Activity.
 * Core Method Content provides step-by-step explanations, describing how very specific development goals are achieved independent of the placement of these steps within a development lifecycle.  Processes take these method elements and relate them into semi-ordered sequences that are customized to specific types of projects.  Thus, a process is a set of partially ordered work descriptions intended to reach a higher development goal, such as the release of a specific software system.  A process and the process meta-model structure defined in this specification focuses on the lifecycle and the sequencing of work in breakdown structures.  To achieve this it uses the Descriptor concept referencing method content and allowing defining time-specific customizations of the referenced content (e.g. defining a focus on different steps of the same Task and providing input Work Products in different states within the different Phases of a process lifecycle in which the same Task is performed).
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.Process#getIncludesPattern <em>Includes Pattern</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.Process#getDefaultContext <em>Default Context</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.Process#getValidContext <em>Valid Context</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.Process#getDiagramURI <em>Diagram URI</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcess()
 * @model extendedMetaData="name='Process' kind='elementOnly'"
 * @generated
 */
public interface Process extends Activity {
	/**
	 * Returns the value of the '<em><b>Includes Pattern</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Includes Pattern</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Includes Pattern</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcess_IncludesPattern()
	 * @model type="java.lang.String" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='IncludesPattern'"
	 * @generated
	 */
	EList getIncludesPattern();

	/**
	 * Returns the value of the '<em><b>Default Context</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Context</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Context</em>' attribute.
	 * @see #setDefaultContext(String)
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcess_DefaultContext()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='DefaultContext'"
	 * @generated
	 */
	String getDefaultContext();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.xml.uma.Process#getDefaultContext <em>Default Context</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Context</em>' attribute.
	 * @see #getDefaultContext()
	 * @generated
	 */
	void setDefaultContext(String value);

	/**
	 * Returns the value of the '<em><b>Valid Context</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Context</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Context</em>' attribute list.
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcess_ValidContext()
	 * @model type="java.lang.String" unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='ValidContext'"
	 * @generated
	 */
	EList getValidContext();

	/**
	 * Returns the value of the '<em><b>Diagram URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The URI of the diagram file associated with the process.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Diagram URI</em>' attribute.
	 * @see #setDiagramURI(String)
	 * @see org.eclipse.epf.xml.uma.UmaPackage#getProcess_DiagramURI()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='diagramURI'"
	 * @generated
	 */
	String getDiagramURI();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.xml.uma.Process#getDiagramURI <em>Diagram URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram URI</em>' attribute.
	 * @see #getDiagramURI()
	 * @generated
	 */
	void setDiagramURI(String value);

} // Process