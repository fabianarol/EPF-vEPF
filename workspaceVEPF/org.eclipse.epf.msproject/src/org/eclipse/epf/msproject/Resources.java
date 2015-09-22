/**
 * <copyright>
 * </copyright>
 *
 * $Id: Resources.java,v 1.3 2006/09/07 00:06:12 klow Exp $
 */
package org.eclipse.epf.msproject;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resources</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.msproject.Resources#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.msproject.MsprojectPackage#getResources()
 * @model extendedMetaData="name='Resources_._type' kind='elementOnly'"
 * @generated
 */
public interface Resources extends EObject {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.epf.msproject.Resource}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * There must be at least one resource in each Resources collection.
	 *                     
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Resource</em>' containment reference list.
	 * @see org.eclipse.epf.msproject.MsprojectPackage#getResources_Resource()
	 * @model type="org.eclipse.epf.msproject.Resource" containment="true" resolveProxies="false"
	 *        extendedMetaData="kind='element' name='Resource' namespace='##targetNamespace'"
	 * @generated
	 */
	EList getResource();

} // Resources
