/**
 * <copyright>
 * </copyright>
 *
 * $Id: AvailabilityPeriod.java,v 1.2 2006/04/11 15:29:55 jthario Exp $
 */
package org.eclipse.epf.msproject;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Availability Period</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableFrom <em>Available From</em>}</li>
 *   <li>{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableTo <em>Available To</em>}</li>
 *   <li>{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableUnits <em>Available Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.epf.msproject.MsprojectPackage#getAvailabilityPeriod()
 * @model extendedMetaData="name='AvailabilityPeriod_._type' kind='elementOnly'"
 * @generated
 */
public interface AvailabilityPeriod extends EObject {
	/**
	 * Returns the value of the '<em><b>Available From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date that the resource becomes available for the specified period.
	 *                                                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available From</em>' attribute.
	 * @see #setAvailableFrom(Object)
	 * @see org.eclipse.epf.msproject.MsprojectPackage#getAvailabilityPeriod_AvailableFrom()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='element' name='AvailableFrom' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getAvailableFrom();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableFrom <em>Available From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available From</em>' attribute.
	 * @see #getAvailableFrom()
	 * @generated
	 */
	void setAvailableFrom(Object value);

	/**
	 * Returns the value of the '<em><b>Available To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The last date that the resource is available for the specified period.
	 *                                                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available To</em>' attribute.
	 * @see #setAvailableTo(Object)
	 * @see org.eclipse.epf.msproject.MsprojectPackage#getAvailabilityPeriod_AvailableTo()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.DateTime"
	 *        extendedMetaData="kind='element' name='AvailableTo' namespace='##targetNamespace'"
	 * @generated
	 */
	Object getAvailableTo();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableTo <em>Available To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available To</em>' attribute.
	 * @see #getAvailableTo()
	 * @generated
	 */
	void setAvailableTo(Object value);

	/**
	 * Returns the value of the '<em><b>Available Units</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The percentage that the resource is available during the specified period.
	 *                                                         
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Available Units</em>' attribute.
	 * @see #isSetAvailableUnits()
	 * @see #unsetAvailableUnits()
	 * @see #setAvailableUnits(float)
	 * @see org.eclipse.epf.msproject.MsprojectPackage#getAvailabilityPeriod_AvailableUnits()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Float"
	 *        extendedMetaData="kind='element' name='AvailableUnits' namespace='##targetNamespace'"
	 * @generated
	 */
	float getAvailableUnits();

	/**
	 * Sets the value of the '{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableUnits <em>Available Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Units</em>' attribute.
	 * @see #isSetAvailableUnits()
	 * @see #unsetAvailableUnits()
	 * @see #getAvailableUnits()
	 * @generated
	 */
	void setAvailableUnits(float value);

	/**
	 * Unsets the value of the '{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableUnits <em>Available Units</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetAvailableUnits()
	 * @see #getAvailableUnits()
	 * @see #setAvailableUnits(float)
	 * @generated
	 */
	void unsetAvailableUnits();

	/**
	 * Returns whether the value of the '{@link org.eclipse.epf.msproject.AvailabilityPeriod#getAvailableUnits <em>Available Units</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Available Units</em>' attribute is set.
	 * @see #unsetAvailableUnits()
	 * @see #getAvailableUnits()
	 * @see #setAvailableUnits(float)
	 * @generated
	 */
	boolean isSetAvailableUnits();

} // AvailabilityPeriod