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
package org.eclipse.epf.uma.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.epf.uma.MethodPlugin;
import org.eclipse.epf.uma.UmaFactory;
import org.eclipse.epf.uma.UmaPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.epf.uma.MethodPlugin} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MethodPluginItemProvider extends MethodUnitItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider,
		ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodPluginItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addUserChangeablePropertyDescriptor(object);
			addBasesPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the User Changeable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUserChangeablePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_MethodPlugin_userChangeable_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_MethodPlugin_userChangeable_feature", "_UI_MethodPlugin_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UmaPackage.Literals.METHOD_PLUGIN__USER_CHANGEABLE,
						true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Bases feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBasesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(
						((ComposeableAdapterFactory) adapterFactory)
								.getRootAdapterFactory(),
						getResourceLocator(),
						getString("_UI_MethodPlugin_bases_feature"), //$NON-NLS-1$
						getString(
								"_UI_PropertyDescriptor_description", "_UI_MethodPlugin_bases_feature", "_UI_MethodPlugin_type"), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
						UmaPackage.Literals.METHOD_PLUGIN__BASES, true, false,
						true, null, null, null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
					.add(UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns MethodPlugin.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage(
				"full/obj16/MethodPlugin")); //$NON-NLS-1$
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getText(Object object) {
		String label = ((MethodPlugin) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_MethodPlugin_type") : //$NON-NLS-1$
				getString("_UI_MethodPlugin_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MethodPlugin.class)) {
		case UmaPackage.METHOD_PLUGIN__USER_CHANGEABLE:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), false, true));
			return;
		case UmaPackage.METHOD_PLUGIN__METHOD_PACKAGES:
			fireNotifyChanged(new ViewerNotification(notification, notification
					.getNotifier(), true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptors(Collection newChildDescriptors,
			Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createContentPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createProcessPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createProcessComponent()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createProcessLinesPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createProcessLineComponent()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createProcessLineComponentPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createCoreProcessPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createTailoredProcessesPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createTailoredProcessComponent()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createTailoredCoreProcessPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createVariantsPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createVarPointsPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createVariationsPackage()));

		newChildDescriptors.add(createChildParameter(
				UmaPackage.Literals.METHOD_PLUGIN__METHOD_PACKAGES,
				UmaFactory.eINSTANCE.createProcessLine()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceLocator getResourceLocator() {
		return UmaEditPlugin.INSTANCE;
	}

}
