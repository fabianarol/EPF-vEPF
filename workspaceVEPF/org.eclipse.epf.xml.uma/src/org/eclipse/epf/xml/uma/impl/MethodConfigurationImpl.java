/**
 * <copyright>
 * </copyright>
 *
 * $Id: MethodConfigurationImpl.java,v 1.5 2007/06/05 21:14:59 klow Exp $
 */
package org.eclipse.epf.xml.uma.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.epf.xml.uma.MethodConfiguration;
import org.eclipse.epf.xml.uma.UmaPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getBaseConfiguration <em>Base Configuration</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getMethodPluginSelection <em>Method Plugin Selection</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getMethodPackageSelection <em>Method Package Selection</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getDefaultView <em>Default View</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getProcessView <em>Process View</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getSubtractedCategory <em>Subtracted Category</em>}</li>
 *   <li>{@link org.eclipse.epf.xml.uma.impl.MethodConfigurationImpl#getAddedCategory <em>Added Category</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MethodConfigurationImpl extends MethodUnitImpl implements MethodConfiguration {
	/**
	 * The cached value of the '{@link #getBaseConfiguration() <em>Base Configuration</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseConfiguration()
	 * @generated
	 * @ordered
	 */
	protected EList baseConfiguration;

	/**
	 * The cached value of the '{@link #getMethodPluginSelection() <em>Method Plugin Selection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodPluginSelection()
	 * @generated
	 * @ordered
	 */
	protected EList methodPluginSelection;

	/**
	 * The cached value of the '{@link #getMethodPackageSelection() <em>Method Package Selection</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodPackageSelection()
	 * @generated
	 * @ordered
	 */
	protected EList methodPackageSelection;

	/**
	 * The default value of the '{@link #getDefaultView() <em>Default View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultView()
	 * @generated
	 * @ordered
	 */
	protected static final String DEFAULT_VIEW_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDefaultView() <em>Default View</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultView()
	 * @generated
	 * @ordered
	 */
	protected String defaultView = DEFAULT_VIEW_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProcessView() <em>Process View</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessView()
	 * @generated
	 * @ordered
	 */
	protected EList processView;

	/**
	 * The cached value of the '{@link #getSubtractedCategory() <em>Subtracted Category</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubtractedCategory()
	 * @generated
	 * @ordered
	 */
	protected EList subtractedCategory;

	/**
	 * The cached value of the '{@link #getAddedCategory() <em>Added Category</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAddedCategory()
	 * @generated
	 * @ordered
	 */
	protected EList addedCategory;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return UmaPackage.Literals.METHOD_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getBaseConfiguration() {
		if (baseConfiguration == null) {
			baseConfiguration = new EDataTypeEList(String.class, this, UmaPackage.METHOD_CONFIGURATION__BASE_CONFIGURATION);
		}
		return baseConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMethodPluginSelection() {
		if (methodPluginSelection == null) {
			methodPluginSelection = new EDataTypeEList(String.class, this, UmaPackage.METHOD_CONFIGURATION__METHOD_PLUGIN_SELECTION);
		}
		return methodPluginSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getMethodPackageSelection() {
		if (methodPackageSelection == null) {
			methodPackageSelection = new EDataTypeEList(String.class, this, UmaPackage.METHOD_CONFIGURATION__METHOD_PACKAGE_SELECTION);
		}
		return methodPackageSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDefaultView() {
		return defaultView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultView(String newDefaultView) {
		String oldDefaultView = defaultView;
		defaultView = newDefaultView;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmaPackage.METHOD_CONFIGURATION__DEFAULT_VIEW, oldDefaultView, defaultView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProcessView() {
		if (processView == null) {
			processView = new EDataTypeEList(String.class, this, UmaPackage.METHOD_CONFIGURATION__PROCESS_VIEW);
		}
		return processView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getSubtractedCategory() {
		if (subtractedCategory == null) {
			subtractedCategory = new EDataTypeEList(String.class, this, UmaPackage.METHOD_CONFIGURATION__SUBTRACTED_CATEGORY);
		}
		return subtractedCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAddedCategory() {
		if (addedCategory == null) {
			addedCategory = new EDataTypeEList(String.class, this, UmaPackage.METHOD_CONFIGURATION__ADDED_CATEGORY);
		}
		return addedCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmaPackage.METHOD_CONFIGURATION__BASE_CONFIGURATION:
				return getBaseConfiguration();
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PLUGIN_SELECTION:
				return getMethodPluginSelection();
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PACKAGE_SELECTION:
				return getMethodPackageSelection();
			case UmaPackage.METHOD_CONFIGURATION__DEFAULT_VIEW:
				return getDefaultView();
			case UmaPackage.METHOD_CONFIGURATION__PROCESS_VIEW:
				return getProcessView();
			case UmaPackage.METHOD_CONFIGURATION__SUBTRACTED_CATEGORY:
				return getSubtractedCategory();
			case UmaPackage.METHOD_CONFIGURATION__ADDED_CATEGORY:
				return getAddedCategory();
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
			case UmaPackage.METHOD_CONFIGURATION__BASE_CONFIGURATION:
				getBaseConfiguration().clear();
				getBaseConfiguration().addAll((Collection)newValue);
				return;
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PLUGIN_SELECTION:
				getMethodPluginSelection().clear();
				getMethodPluginSelection().addAll((Collection)newValue);
				return;
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PACKAGE_SELECTION:
				getMethodPackageSelection().clear();
				getMethodPackageSelection().addAll((Collection)newValue);
				return;
			case UmaPackage.METHOD_CONFIGURATION__DEFAULT_VIEW:
				setDefaultView((String)newValue);
				return;
			case UmaPackage.METHOD_CONFIGURATION__PROCESS_VIEW:
				getProcessView().clear();
				getProcessView().addAll((Collection)newValue);
				return;
			case UmaPackage.METHOD_CONFIGURATION__SUBTRACTED_CATEGORY:
				getSubtractedCategory().clear();
				getSubtractedCategory().addAll((Collection)newValue);
				return;
			case UmaPackage.METHOD_CONFIGURATION__ADDED_CATEGORY:
				getAddedCategory().clear();
				getAddedCategory().addAll((Collection)newValue);
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
			case UmaPackage.METHOD_CONFIGURATION__BASE_CONFIGURATION:
				getBaseConfiguration().clear();
				return;
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PLUGIN_SELECTION:
				getMethodPluginSelection().clear();
				return;
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PACKAGE_SELECTION:
				getMethodPackageSelection().clear();
				return;
			case UmaPackage.METHOD_CONFIGURATION__DEFAULT_VIEW:
				setDefaultView(DEFAULT_VIEW_EDEFAULT);
				return;
			case UmaPackage.METHOD_CONFIGURATION__PROCESS_VIEW:
				getProcessView().clear();
				return;
			case UmaPackage.METHOD_CONFIGURATION__SUBTRACTED_CATEGORY:
				getSubtractedCategory().clear();
				return;
			case UmaPackage.METHOD_CONFIGURATION__ADDED_CATEGORY:
				getAddedCategory().clear();
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
			case UmaPackage.METHOD_CONFIGURATION__BASE_CONFIGURATION:
				return baseConfiguration != null && !baseConfiguration.isEmpty();
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PLUGIN_SELECTION:
				return methodPluginSelection != null && !methodPluginSelection.isEmpty();
			case UmaPackage.METHOD_CONFIGURATION__METHOD_PACKAGE_SELECTION:
				return methodPackageSelection != null && !methodPackageSelection.isEmpty();
			case UmaPackage.METHOD_CONFIGURATION__DEFAULT_VIEW:
				return DEFAULT_VIEW_EDEFAULT == null ? defaultView != null : !DEFAULT_VIEW_EDEFAULT.equals(defaultView);
			case UmaPackage.METHOD_CONFIGURATION__PROCESS_VIEW:
				return processView != null && !processView.isEmpty();
			case UmaPackage.METHOD_CONFIGURATION__SUBTRACTED_CATEGORY:
				return subtractedCategory != null && !subtractedCategory.isEmpty();
			case UmaPackage.METHOD_CONFIGURATION__ADDED_CATEGORY:
				return addedCategory != null && !addedCategory.isEmpty();
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
		result.append(" (baseConfiguration: ");
		result.append(baseConfiguration);
		result.append(", methodPluginSelection: ");
		result.append(methodPluginSelection);
		result.append(", methodPackageSelection: ");
		result.append(methodPackageSelection);
		result.append(", defaultView: ");
		result.append(defaultView);
		result.append(", processView: ");
		result.append(processView);
		result.append(", subtractedCategory: ");
		result.append(subtractedCategory);
		result.append(", addedCategory: ");
		result.append(addedCategory);
		result.append(')');
		return result.toString();
	}

} //MethodConfigurationImpl