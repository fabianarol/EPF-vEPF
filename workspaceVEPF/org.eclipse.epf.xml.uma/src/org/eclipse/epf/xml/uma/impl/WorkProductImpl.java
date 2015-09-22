/**
 * <copyright>
 * </copyright>
 *
 * $Id: WorkProductImpl.java,v 1.4 2007/06/05 21:14:59 klow Exp $
 */
package org.eclipse.epf.xml.uma.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.epf.xml.uma.UmaPackage;
import org.eclipse.epf.xml.uma.WorkProduct;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Work Product</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.WorkProductImpl#getGroup2 <em>Group2</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.WorkProductImpl#getEstimate <em>Estimate</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.WorkProductImpl#getEstimationConsiderations <em>Estimation Considerations</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.WorkProductImpl#getReport <em>Report</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.WorkProductImpl#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.WorkProductImpl#getToolMentor <em>Tool Mentor</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WorkProductImpl extends ContentElementImpl implements WorkProduct {
	/**
	 * The cached value of the '{@link #getGroup2() <em>Group2</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroup2()
	 * @generated
	 * @ordered
	 */
	protected FeatureMap group2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WorkProductImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmaPackage.Literals.WORK_PRODUCT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureMap getGroup2() {
		if (group2 == null) {
			group2 = new BasicFeatureMap(this, UmaPackage.WORK_PRODUCT__GROUP2);
		}
		return group2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEstimate() {
		return getGroup2().list(UmaPackage.Literals.WORK_PRODUCT__ESTIMATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getEstimationConsiderations() {
		return getGroup2().list(UmaPackage.Literals.WORK_PRODUCT__ESTIMATION_CONSIDERATIONS);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getReport() {
		return getGroup2().list(UmaPackage.Literals.WORK_PRODUCT__REPORT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTemplate() {
		return getGroup2().list(UmaPackage.Literals.WORK_PRODUCT__TEMPLATE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getToolMentor() {
		return getGroup2().list(UmaPackage.Literals.WORK_PRODUCT__TOOL_MENTOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmaPackage.WORK_PRODUCT__GROUP2:
				return ((InternalEList)getGroup2()).basicRemove(otherEnd, msgs);
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
			case UmaPackage.WORK_PRODUCT__GROUP2:
				if (coreType) return getGroup2();
				return ((FeatureMap.Internal)getGroup2()).getWrapper();
			case UmaPackage.WORK_PRODUCT__ESTIMATE:
				return getEstimate();
			case UmaPackage.WORK_PRODUCT__ESTIMATION_CONSIDERATIONS:
				return getEstimationConsiderations();
			case UmaPackage.WORK_PRODUCT__REPORT:
				return getReport();
			case UmaPackage.WORK_PRODUCT__TEMPLATE:
				return getTemplate();
			case UmaPackage.WORK_PRODUCT__TOOL_MENTOR:
				return getToolMentor();
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
			case UmaPackage.WORK_PRODUCT__GROUP2:
				((FeatureMap.Internal)getGroup2()).set(newValue);
				return;
			case UmaPackage.WORK_PRODUCT__ESTIMATE:
				getEstimate().clear();
				getEstimate().addAll((Collection)newValue);
				return;
			case UmaPackage.WORK_PRODUCT__ESTIMATION_CONSIDERATIONS:
				getEstimationConsiderations().clear();
				getEstimationConsiderations().addAll((Collection)newValue);
				return;
			case UmaPackage.WORK_PRODUCT__REPORT:
				getReport().clear();
				getReport().addAll((Collection)newValue);
				return;
			case UmaPackage.WORK_PRODUCT__TEMPLATE:
				getTemplate().clear();
				getTemplate().addAll((Collection)newValue);
				return;
			case UmaPackage.WORK_PRODUCT__TOOL_MENTOR:
				getToolMentor().clear();
				getToolMentor().addAll((Collection)newValue);
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
			case UmaPackage.WORK_PRODUCT__GROUP2:
				getGroup2().clear();
				return;
			case UmaPackage.WORK_PRODUCT__ESTIMATE:
				getEstimate().clear();
				return;
			case UmaPackage.WORK_PRODUCT__ESTIMATION_CONSIDERATIONS:
				getEstimationConsiderations().clear();
				return;
			case UmaPackage.WORK_PRODUCT__REPORT:
				getReport().clear();
				return;
			case UmaPackage.WORK_PRODUCT__TEMPLATE:
				getTemplate().clear();
				return;
			case UmaPackage.WORK_PRODUCT__TOOL_MENTOR:
				getToolMentor().clear();
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
		switch (featureID) {
			case UmaPackage.WORK_PRODUCT__GROUP2:
				return group2 != null && !group2.isEmpty();
			case UmaPackage.WORK_PRODUCT__ESTIMATE:
				return !getEstimate().isEmpty();
			case UmaPackage.WORK_PRODUCT__ESTIMATION_CONSIDERATIONS:
				return !getEstimationConsiderations().isEmpty();
			case UmaPackage.WORK_PRODUCT__REPORT:
				return !getReport().isEmpty();
			case UmaPackage.WORK_PRODUCT__TEMPLATE:
				return !getTemplate().isEmpty();
			case UmaPackage.WORK_PRODUCT__TOOL_MENTOR:
				return !getToolMentor().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (group2: ");
		result.append(group2);
		result.append(')');
		return result.toString();
	}

} //WorkProductImpl