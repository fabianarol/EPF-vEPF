//------------------------------------------------------------------------------
// Copyright (c) 2005, 2007 IBM Corporation and others.
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
//
// Contributors:
// IBM Corporation - initial implementation
//------------------------------------------------------------------------------
package org.eclipse.epf.library.edit.command;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JFrame;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.epf.library.edit.navigator.VariantsPackageItemProvider;
import org.eclipse.epf.library.edit.navigator.ItemProviderAdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage.Literals;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.epf.common.serviceability.MsgBox;
import org.eclipse.epf.common.utils.StrUtil;
import org.eclipse.epf.library.edit.LibraryEditPlugin;
import org.eclipse.epf.library.edit.LibraryEditResources;
import org.eclipse.epf.library.edit.ui.UserInteractionHelper;
import org.eclipse.epf.library.edit.ui.vepf.dialogs.VarPointDialog;
import org.eclipse.epf.library.edit.ui.vepf.dialogs.VariantDialog;
import org.eclipse.epf.library.edit.util.ExtensionManager;
import org.eclipse.epf.library.edit.util.ITextReferenceReplacer;
import org.eclipse.epf.library.edit.util.Messenger;
import org.eclipse.epf.library.edit.util.Misc;
import org.eclipse.epf.library.edit.util.ModelStructure;
import org.eclipse.epf.library.edit.util.TngUtil;
import org.eclipse.epf.library.edit.validation.IValidator;
import org.eclipse.epf.library.edit.validation.IValidatorFactory;
import org.eclipse.epf.library.edit.validation.NameChecker;
import org.eclipse.epf.library.edit.validation.internal.ContentElementNameValidator;
import org.eclipse.epf.library.edit.validation.internal.UniquenessValidator;
import org.eclipse.epf.library.edit.validation.internal.ValidatorFactory;
import org.eclipse.epf.services.IFileBasedLibraryPersister;
import org.eclipse.epf.services.ILibraryPersister;
import org.eclipse.epf.services.Services;
import org.eclipse.epf.uma.Activity;
import org.eclipse.epf.uma.BreakdownElement;
import org.eclipse.epf.uma.ContentDescription;
import org.eclipse.epf.uma.ContentElement;
import org.eclipse.epf.uma.ContentPackage;
import org.eclipse.epf.uma.Descriptor;
import org.eclipse.epf.uma.MethodConfiguration;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.MethodLibrary;
import org.eclipse.epf.uma.MethodPlugin;
import org.eclipse.epf.uma.MethodUnit;
import org.eclipse.epf.uma.NamedElement;
import org.eclipse.epf.uma.ProcessComponent;
import org.eclipse.epf.uma.ProcessElement;
import org.eclipse.epf.uma.ProcessPackage;
import org.eclipse.epf.uma.ProcessPlanningTemplate;
import org.eclipse.epf.uma.UmaFactory;
import org.eclipse.epf.uma.UmaPackage;
import org.eclipse.epf.uma.VarActivity;
import org.eclipse.epf.uma.VarElement;
import org.eclipse.epf.uma.VarIteration;
import org.eclipse.epf.uma.VarMilestone;
import org.eclipse.epf.uma.VarPhase;
import org.eclipse.epf.uma.VarPoint;
import org.eclipse.epf.uma.VarPointsPackage;
import org.eclipse.epf.uma.VarRoleDescriptor;
import org.eclipse.epf.uma.VarTaskDescriptor;
import org.eclipse.epf.uma.VarTeamProfile;
import org.eclipse.epf.uma.VarWorkProductDescriptor;
import org.eclipse.epf.uma.VariabilityType;
import org.eclipse.epf.uma.Variant;
import org.eclipse.epf.uma.VariantsPackage;
import org.eclipse.epf.uma.varP2varP;
import org.eclipse.epf.uma.variant2varP;
import org.eclipse.epf.uma.variant2variant;
import org.eclipse.epf.uma.varp2variant;
import org.eclipse.epf.uma.vpActivity;
import org.eclipse.epf.uma.vpIteration;
import org.eclipse.epf.uma.vpMilestone;
import org.eclipse.epf.uma.vpPhase;
import org.eclipse.epf.uma.vpRoleDescriptor;
import org.eclipse.epf.uma.vpTaskDescriptor;
import org.eclipse.epf.uma.vpTeamProfile;
import org.eclipse.epf.uma.vpWorkProductDescriptor;
import org.eclipse.epf.uma.edit.domain.TraceableAdapterFactoryEditingDomain;
import org.eclipse.epf.uma.impl.variant2variantImpl;
import org.eclipse.epf.uma.util.AssociationHelper;
import org.eclipse.epf.uma.util.ContentDescriptionFactory;
import org.eclipse.epf.uma.util.MessageException;
import org.eclipse.epf.uma.util.UmaUtil;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * This command is used to add a method element to a containing method element.
 * 
 * @author Phong Nguyen Le
 * @author Shilpa Toraskar
 * @since 1.0
 */
public class MethodElementAddCommand extends CommandWrapper implements
		IResourceAwareCommand {
	public static final Map<EClass, Collection<EStructuralFeature>> typeToExcludedFeaturesFromCheck = new HashMap<EClass, Collection<EStructuralFeature>>();
	
	public static void excludeFromCheck(EClass type, EStructuralFeature feature) {
		Collection<EStructuralFeature> features = typeToExcludedFeaturesFromCheck.get(type);
		if(features == null) {
			features = new HashSet<EStructuralFeature>();
		}
		features.add(feature);
	}

	protected boolean canUndo = true;

	protected AddCommand addCommand;

	// protected Map elementToNewNameMap;
	protected Map elementToOldPluginMap;

	protected boolean removeXRefRequired;

	protected MethodPlugin ownerPlugin;

	protected ArrayList addList;

	protected MultiStatus status = new MultiStatus(LibraryEditPlugin.INSTANCE
			.getSymbolicName(), IStatus.OK, "", null); //$NON-NLS-1$

	protected boolean runWithProgress;

	protected ArrayList<EStructuralFeature> featuresToCheck;

	private ArrayList nestedCommands;

	private HashSet modifiedResources;

	public MethodElementAddCommand(Command command) {
		this(command, true);
	}

	public MethodElementAddCommand(Command command, boolean runWithProgress) {
		super(command);
		addCommand = (AddCommand) TngUtil.unwrap(command);
		setRunWithProgress(runWithProgress);
	}

	public void setRunWithProgress(boolean runWithProgress) {
		this.runWithProgress = runWithProgress;
	}

	public boolean canUndo() {
		return canUndo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.CommandWrapper#getResult()
	 */
	public Collection getResult() {
		if (status.isOK()) {
			return super.getResult();
		}
		return Collections.EMPTY_LIST;
	}

	private void handleError(IStatus errorStatus) {
		Messenger.INSTANCE.showError(getLabel(), LibraryEditResources.createElementError_msg, errorStatus);
		status.add(errorStatus);
		status.addAll(errorStatus);
		return;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.common.command.CommandWrapper#dispose()
	 */
	public void dispose() {	
		// dispose the nested commands
		if (nestedCommands != null && !nestedCommands.isEmpty()) {
			for (int i = nestedCommands.size() - 1; i > -1; i--) {
				Command cmd = (Command) nestedCommands.get(i);
				try {
					cmd.dispose();
				} catch (Exception e) {
				}
			}
		}
		super.dispose();
	}
	
	
	public void execute() {
		Shell shell = MsgBox.getDefaultShell();
		// Check whether the owner resource can be modified.
		//
		Collection resourcesToChange = getModifiedResources();
		IStatus execStatus = UserInteractionHelper.checkModify(
				resourcesToChange, shell);
		if (!execStatus.isOK()) {
			handleError(execStatus);
			return;
		}
		execStatus = UserInteractionHelper.checkConfigurationsToUpdate(
				addCommand, shell);
		if (!execStatus.isOK()) {
			handleError(execStatus);
			return;
		}
		if (willSaveModifiedResources()
				&& !UserInteractionHelper.checkOutOfSynch(resourcesToChange)) {
			status.add(Status.CANCEL_STATUS);
			return;
		}

		// if(!checkFolder(shell)) {
		// return;
		// }

		doAdd();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.CommandWrapper#undo()
	 */
	public void undo() {
		undoNestedCommands();
		super.undo();
	}

	/**
	 * 
	 */
	private void undoNestedCommands() {
		if (nestedCommands != null && !nestedCommands.isEmpty()) {
			for (int i = nestedCommands.size() - 1; i > -1; i--) {
				Command cmd = (Command) nestedCommands.get(i);
				try {
					if (cmd.canUndo()) {
						cmd.undo();
					}
				} catch (Exception e) {
					LibraryEditPlugin.getDefault().getLogger().logError(e);
				} finally {
					try {
						cmd.dispose();
					} catch (Exception e) {
					}
				}
			}
		}
	}

	/**
	 * @return
	 */
	private boolean checkFolder(Shell shell) {
		// if any of the elements to be added will be saved in its own file
		// check if the folder to save the file to can be modified
		//
		IFileBasedLibraryPersister persister = (IFileBasedLibraryPersister) Services.getLibraryPersister(Services.XMI_PERSISTENCE_TYPE);
		ArrayList foldersToCheck = new ArrayList();
		for (Iterator iter = addCommand.getCollection().iterator(); iter
				.hasNext();) {
			Object element = TngUtil.unwrap(iter.next());
			if (element instanceof MethodElement
					&& persister.hasOwnResource(element)) {
				String folder = persister.getFolderRelativePath(
								(MethodElement) element);
				MethodPlugin plugin = UmaUtil.getMethodPlugin(addCommand
						.getOwner());
				String baseFolder = null;
				if (plugin == null) {
					MethodLibrary lib = UmaUtil.getMethodLibrary(addCommand
							.getOwner());
					baseFolder = new File(lib.eResource().getURI()
							.toFileString()).getParent();
				} else {
					baseFolder = new File(plugin.eResource().getURI()
							.toFileString()).getParent();
				}
				foldersToCheck.add(baseFolder + File.separator + folder);
			}
		}
		if (!foldersToCheck.isEmpty()) {
			String[] folders = new String[foldersToCheck.size()];
			foldersToCheck.toArray(folders);
			IStatus status = Services.getFileManager()
					.checkModify(folders, shell);
			if (!status.isOK()) {
				handleError(status);
				return false;
			}
		}

		return true;
	}

	public IStatus getStatus() {
		return status;
	}

	/**
	 * @return
	 */
	private boolean isMove() {
		Command cmd = TngUtil.unwrap(command);
		if (cmd instanceof AddCommand) {
			for (Iterator iter = ((AddCommand) cmd).getCollection().iterator(); iter
					.hasNext();) {
				EObject element = (EObject) iter.next();
				if (UmaUtil.getMethodPlugin(element) == null) {
					return false;
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param ownerPlugin
	 * @param e
	 * @return List of Reference objects that keeps the info of illegal outgoing
	 *         references
	 * @see Reference
	 */
	public static Collection<Reference> getIllegalOutgoingReferences(
			MethodPlugin ownerPlugin, EObject e, Collection<Reference> illegalReferences) {
		if (illegalReferences == null) {
			illegalReferences = new ArrayList<Reference>();
		}
		for (EContentsEList.FeatureIterator<EObject> featureIterator = (EContentsEList.FeatureIterator<EObject>) e
				.eCrossReferences().iterator(); featureIterator.hasNext();) {
			EObject eObject = (EObject) featureIterator.next();
			EStructuralFeature feature = featureIterator.feature();
			if (!feature.isDerived()) {
				MethodPlugin plugin = UmaUtil.getMethodPlugin(eObject);
				if (plugin != null && plugin != ownerPlugin
						&& !Misc.isBaseOf(plugin, ownerPlugin)) {
					// illegal reference to be removed
					//
					illegalReferences
							.add(new Reference(e, feature, eObject, -1));
					if (feature == UmaPackage.eINSTANCE
							.getVariabilityElement_VariabilityBasedOnElement()) {
						feature = UmaPackage.eINSTANCE.getVariabilityElement_VariabilityType();
						illegalReferences
							.add(new Reference(e, feature, e.eGet(feature), -1));
					}
				}
			}
		}
		return illegalReferences;
	}

	private static void removeReferences(Collection<Reference> references) {
		for (Reference ref: references) {
			if (ref.feature.isMany()) {
				List<?> list = ((List<?>) ref.owner.eGet(ref.feature));
				list.remove(ref.value);
			} else {
				ref.owner.eSet(ref.feature, null);
			}
		}
	}

	/**
	 * @param element
	 * @return List of Reference objects
	 */
	public static Collection<Reference> removeIllegalReferences(MethodPlugin ownerPlugin,
			EObject e) {
		Collection<Reference> removeRefs = getIllegalOutgoingReferences(ownerPlugin, e,
				null);

		// remove illegal references
		//
		removeReferences(removeRefs);

		return removeRefs;
	}

	private static boolean hasNext(Iterator iter) {
		try {
			return iter.hasNext();
		} catch (RuntimeException ex) {
			throw ex;
		}
	}

	public static boolean hasIllegalReference(MethodPlugin ownerPlugin,
			EObject e, Collection moveList) {
		for (EContentsEList.FeatureIterator featureIterator = (EContentsEList.FeatureIterator) e
				.eCrossReferences().iterator(); hasNext(featureIterator);) {
			EObject eObject = (EObject) featureIterator.next();

			// check if the x-ref object is in the move list
			//
			if (!moveList.contains(eObject)) {
				MethodPlugin plugin = UmaUtil.getMethodPlugin(eObject);
				if (plugin != null && plugin != ownerPlugin
						&& !Misc.isBaseOf(plugin, ownerPlugin)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if the given MethodElement is referenced illegally after the move.
	 * 
	 * @param ownerPlugin
	 * @param e
	 * @param moveList
	 * @return
	 */
	public static boolean isReferencedIllegally(MethodPlugin ownerPlugin,
			MethodElement e, Collection moveList) {
		Collection references = AssociationHelper.getReferences(e);
		for (Iterator iter = references.iterator(); iter.hasNext();) {
			MethodElement element = (MethodElement) iter.next();

			if (isExcludedFromOutgoingReferenceCheck(element)) {
				continue;
			}

			if (!moveList.contains(element)) {
				MethodPlugin plugin = UmaUtil.getMethodPlugin(element);
				if (plugin != null && plugin != ownerPlugin
						&& !Misc.isBaseOf(ownerPlugin, plugin)) {
					return true;
				}
			}
		}
		return false;
	}

	private static void checkModify(EObject element) {
		IStatus status = TngUtil.checkEdit(element, null);
		if (!status.isOK()) {
			throw new MessageException(TngUtil.getMessage(status));
		}
	}

	public static Collection removeIllegalReferencesTo(
			MethodPlugin ownerPlugin, MethodElement e, Collection moveList) {
		ArrayList affectedReferencers = new ArrayList();
		Collection references = AssociationHelper.getReferences(e);
		for (Iterator iter = references.iterator(); iter.hasNext();) {
			MethodElement element = (MethodElement) iter.next();
			if (!moveList.contains(element)) {
				MethodPlugin plugin = UmaUtil.getMethodPlugin(element);
				if (plugin != null && plugin != ownerPlugin
						&& !Misc.isBaseOf(ownerPlugin, plugin)) {
					checkModify(element);
					removeReferences(element, e);
					affectedReferencers.add(element);
				}
			}
		}
		return affectedReferencers;
	}

	/**
	 * Gets all cross references of <code>referencer</code> to
	 * <code>referenced</code>
	 * 
	 * @param referencer
	 * @param referenced
	 * @param xReferences
	 *            output collection of EStructuralFeature objects
	 * @return collection of EStructuralFeature objects
	 */
	private static Collection getXReferences(EObject referencer,
			EObject referenced, Collection xReferences) {
		if (xReferences == null) {
			xReferences = new ArrayList();
		}
		for (EContentsEList.FeatureIterator featureIterator = (EContentsEList.FeatureIterator) referencer
				.eCrossReferences().iterator(); featureIterator.hasNext();) {
			EObject eObject = (EObject) featureIterator.next();
			EStructuralFeature feature = featureIterator.feature();
			// if(feature.isMany()) {
			// if(((List)referencer.eGet(feature)).contains(referenced)) {
			// xReferences.add(feature);
			// }
			// }
			// else
			if (eObject == referenced) {
				xReferences.add(feature);
			}
		}
		return xReferences;
	}

	/**
	 * Remove all references to <code>referenced</code> from
	 * <code>referencer</code>
	 * 
	 * @param referencer
	 * @param referenced
	 * @return Collection of references to the <code>referenced</code>
	 */
	public static Collection removeReferences(EObject referencer,
			EObject referenced) {
		Collection removeRefs = getXReferences(referencer, referenced, null);

		// remove illegal references
		//
		for (Iterator iter = removeRefs.iterator(); iter.hasNext();) {
			EStructuralFeature f = (EStructuralFeature) iter.next();
			if (f.isMany()) {
				((Collection) referencer.eGet(f)).remove(referenced);
			} else {
				referencer.eSet(f, null);
			}
		}

		return removeRefs;
	}

	public static boolean hasIllegalReferenceIncludingAllChildren(
			MethodPlugin ownerPlugin, MethodElement e, Collection moveList) {
		if (ownerPlugin == UmaUtil.getMethodPlugin(e)) {
			// move within the same plugin, no further check
			//
			return false;
		}
		if (hasIllegalReference(ownerPlugin, e, moveList))
			return true;
		for (Iterator iterator = e.eAllContents(); iterator.hasNext();) {
			if (hasIllegalReference(ownerPlugin, (EObject) iterator.next(),
					moveList))
				return true;
		}
		return false;
	}

	protected void superExecute() {
		super.execute();
	}

	protected Collection getFeaturesToCheck() {
		if (featuresToCheck == null) {
			featuresToCheck = new ArrayList<EStructuralFeature>();
			featuresToCheck.add(UmaPackage.eINSTANCE.getNamedElement_Name());
			
		}
		return featuresToCheck;
	}

	protected IValidator createValidator(EObject e, EStructuralFeature feature) {
		IValidator validator = null;

		if(addCommand.getFeature() instanceof EReference){
			validator = IValidatorFactory.INSTANCE.createValidator(addCommand.getOwner(), (EReference) addCommand.getFeature(), (EClass)null, e, feature);
		}

		return validator;
	}

	/**
	 * @param e
	 * @param objectsToCheckName
	 */
	private void getOffStringToCheckName(Object e, Collection objectsToCheckName) {
		// if(addCommand.getOwner() instanceof ContentPackage &&
		// addCommand.getFeature() ==
		// UmaPackage.eINSTANCE.getMethodPackage_ChildPackages()
		// && e instanceof ContentPackage) {
		// for (Iterator iter = ((ContentPackage)e).eAllContents();
		// iter.hasNext();) {
		// Object element = iter.next();
		// if(element instanceof ContentElement) {
		// objectsToCheckName.add(element);
		// }
		// }
		// }
		// else
		if (addCommand.getOwner() instanceof ProcessPackage
				&& addCommand.getFeature() == UmaPackage.eINSTANCE
						.getMethodPackage_ChildPackages()
				&& e instanceof ProcessPackage
				&& !(e instanceof ProcessComponent)) {
			getProcessComponents((ProcessPackage) e, objectsToCheckName);
		}
	}

	/**
	 * @param e
	 * @param objectsToCheckName
	 */
	private static void getProcessComponents(ProcessPackage pkg,
			Collection objectsToCheckName) {
		for (Iterator iter = pkg.getChildPackages().iterator(); iter.hasNext();) {
			Object childPkg = iter.next();
			if (childPkg instanceof ProcessComponent) {
				objectsToCheckName.add(childPkg);
			} else if (childPkg instanceof ProcessPackage) {
				getProcessComponents((ProcessPackage) childPkg,
						objectsToCheckName);
			}
		}
	}

	private boolean checkStringValue(NamedElement e,
			EStructuralFeature feature, Collection objectsToAdd) {
		Collection excludedFeaturesToCheck = typeToExcludedFeaturesFromCheck.get(e.eClass()); 
		if(excludedFeaturesToCheck != null && excludedFeaturesToCheck.contains(feature)) {
			return true;
		}
		
		IValidator validator = createValidator(e, feature);
		if (validator != null) {
			String newName = null;
			try {
				newName = checkStringValue(e, feature, validator, objectsToAdd);
			} catch (OperationCanceledException ex) {
				return false;
			}
			if (newName != null) {
				newName = newName.trim();
				e.eSet(feature, newName);
				featureChanged(e, feature, newName);
			}
		}
		return true;
	}

	protected boolean checkStringValue(EStructuralFeature feature) {
		ArrayList objectsToCheckName = new ArrayList();
		Collection objectsToAdd = addCommand.getCollection();

		// feature value check
		//
		for (Iterator iter = objectsToAdd.iterator(); iter.hasNext();) {
			NamedElement e = (NamedElement) iter.next();
			if (!checkStringValue(e, feature, objectsToAdd)) {
				return false;
			}

			getOffStringToCheckName(e, objectsToCheckName);
		}

		for (Iterator iter = objectsToCheckName.iterator(); iter.hasNext();) {
			NamedElement e = (NamedElement) iter.next();
			EStructuralFeature f = UmaPackage.eINSTANCE.getNamedElement_Name();
			if (!checkStringValue(e, f, objectsToCheckName)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Subclass can override this method to deal with element change during add
	 * 
	 * @param feature
	 * @param newValue
	 */
	protected void featureChanged(EObject object, EStructuralFeature feature,
			Object newValue) {

	}

	private static Collection getElementsToCheckName(AddCommand addCommand) {
		ArrayList elements = new ArrayList(addCommand.getCollection());
		for (Iterator iter = addCommand.getCollection().iterator(); iter
				.hasNext();) {
			Object element = iter.next();
			if (element instanceof ProcessPackage) {
				// need to get all process components in this package to check
				// name
				//
				Iterator iterator = new AbstractTreeIterator(element, false) {

					/**
					 * Comment for <code>serialVersionUID</code>
					 */
					private static final long serialVersionUID = 1L;

					protected Iterator getChildren(Object object) {
						if (object instanceof ProcessComponent) {
							return Collections.EMPTY_LIST.iterator();
						} else if (object instanceof ProcessPackage) {
							return ((ProcessPackage) object).getChildPackages()
									.iterator();
						} else {
							return Collections.EMPTY_LIST.iterator();
						}
					}

				};
				while (iterator.hasNext()) {
					Object pkg = iterator.next();
					if (pkg instanceof ProcessComponent) {
						elements.add(pkg);
					}
				}
			}
		}
		return elements;
	}

	/**
	 * Checks the name of all elements to be added.
	 * 
	 * @param addCommand
	 * @return a element to new feature name map or <code>null</code> if user
	 *         canceled the operation.
	 */
	protected static Map checkName(AddCommand addCommand) {
		Collection elementsToCheck = getElementsToCheckName(addCommand);
		HashMap elementToNewNameMap = new HashMap();

		// feature value check
		//
		for (Iterator iter = elementsToCheck.iterator(); iter.hasNext();) {
			NamedElement e = (NamedElement) iter.next();
			IValidator validator;
			if (e instanceof ContentElement) {
				validator = new ContentElementNameValidator(addCommand
						.getOwner(), addCommand.getFeature(),
						(ContentElement) e, new ValidatorFactory.TypeFilter(e));
			} else {
				validator = IValidatorFactory.INSTANCE.createNameValidator(
						addCommand.getOwner(), e);
			}

			String newName = null;
			try {
				newName = checkStringValue(e, UmaPackage.eINSTANCE
						.getNamedElement_Name(), validator, elementsToCheck);
			} catch (OperationCanceledException ex) {
				return null;
			}
			if (newName != null) {
				// new name required, check if the element can be modified
				//
				IStatus status = UserInteractionHelper.checkModify(e, MsgBox
						.getDefaultShell());
				String title = LibraryEditResources.errorDialog_title; 
				String msg = MessageFormat.format(
						LibraryEditResources.errorDialog_cannotRename,
						new Object[] { TngUtil.getTypeText(e), e.getName(),
								newName });
				while (!status.isOK()) {
					IUserInteractionHandler uiHandler = ExtensionManager.getDefaultUserInteractionHandler();
					if (uiHandler != null) {
						if (uiHandler.selectOne(new int[] {
								IUserInteractionHandler.ACTION_OK,
								IUserInteractionHandler.ACTION_CANCEL }, title,
								msg, null) == IUserInteractionHandler.ACTION_CANCEL) {
							return null;
						}
					}
					else {
						// cancel the operation if there is no user interaction handler
						//
						return null;
					}
				}
				elementToNewNameMap.put(e, newName);
			}
		}

		return elementToNewNameMap;
	}

	/**
	 * Checks feature value
	 * 
	 * @param e
	 * @param feature
	 * @param validator
	 * @param objectsToAdd
	 * @return new feature value that user has choosen or <code>null</code> if
	 *         the feature value is valid
	 * @throws OperationCanceledException
	 */
	public static String checkStringValue(NamedElement e,
			EStructuralFeature feature, IValidator validator,
			Collection objectsToAdd) throws OperationCanceledException {
		// TODO: The validator is display an error message that is too long for
		// the dialog.
		// feature value check
		final StringValidator strValidator = getStringValidator();
		strValidator.setElements(objectsToAdd);
		strValidator.setFeature(feature);
		strValidator.setValidator(validator);

		String str = (String) e.eGet(feature);
		if (str != null && str.length() > 0) {
			String msg = strValidator.isValid(str);
			if (msg != null) {
				String featureTxt = TngUtil.getFeatureText(feature);
				String title = LibraryEditResources.resolveNameConflictDialog_title; 
				String dlgMsg = NLS.bind(
						LibraryEditResources.resolveNameConflictDialog_text,
						StrUtil.toLower(featureTxt), e.getName());
				String currentValue = (String) e.eGet(feature);

				IInputValidator inputValidator = new IInputValidator() {
					public String isValid(String newText) {
						if (strValidator != null) {
							return UserInteractionHelper
									.getSimpleErrorMessage(strValidator
											.isValid(newText));
						}
						return null;
					}
				};
				// TODO: replace with org.eclipse.epf.library.edit.command.IUserInteractionHandler.requestInput(String, String, List)
				InputDialog inputDlg = new InputDialog(
						MsgBox.getDefaultShell(), title, dlgMsg, currentValue,
						inputValidator);
				if (inputDlg.open() == Window.CANCEL) {
					throw new OperationCanceledException();
				}
				return inputDlg.getValue();
			}
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.CommandWrapper#getAffectedObjects()
	 */
	public Collection getAffectedObjects() {
		Collection affectedObjects = super.getAffectedObjects();
		if (affectedObjects == null) {
			EObject owner = addCommand.getOwner();
			affectedObjects = owner == null ? Collections.EMPTY_SET
					: Collections.singleton(owner);
		}
		return affectedObjects;
	}

	protected Collection getElementsToCheckForIllegalReferences() {
		return addCommand.getCollection();
	}

	private static boolean isExcludedFromOutgoingReferenceCheck(Object e) {
		// don't check on ProcessPackage, ProcessElement for illegal references
		// b/c process validation is based on configuration, not plugin
		// visibility
		//
		return e instanceof ProcessPackage || e instanceof ProcessElement;
	}

	protected String checkForIllegalReferences() {
		Collection elements = getElementsToCheckForIllegalReferences();
		addList = new ArrayList(elements);
		for (Iterator iter = elements.iterator(); iter.hasNext();) {
			EObject element = (EObject) iter.next();
			// String newName = (String) elementToNewNameMap.get(element);
			// if(newName != null) {
			// element.setName(newName);
			// }
			for (Iterator iterator = element.eAllContents(); iterator.hasNext();) {
				addList.add(iterator.next());
			}
		}

		// check if there is any illegal reference in the moved objects
		//		
		ownerPlugin = UmaUtil.getMethodPlugin(addCommand.getOwner());
		removeXRefRequired = false;
		find_xPluginRef: for (Iterator iter = addCommand.getCollection()
				.iterator(); iter.hasNext();) {
			Object element = iter.next();

			if (isExcludedFromOutgoingReferenceCheck(element)) {
				continue find_xPluginRef;
			}

			if (element instanceof MethodElement) {
				if (hasIllegalReferenceIncludingAllChildren(ownerPlugin,
						(MethodElement) element, addList)) {
					removeXRefRequired = true;
					break find_xPluginRef;
				}
			}
		}

		if (removeXRefRequired) {
			return LibraryEditResources.invalidReferencesError_reason; 
		}
		return null;
	}

	public Collection getModifiedResources() {
		if (modifiedResources == null) {
			modifiedResources = new HashSet();
		}
		if (addFeatureIsContainment()) {
			ILibraryPersister persister = Services.getDefaultLibraryPersister();
			boolean saveOwnerResource = false;
			for (Iterator iter = addCommand.getCollection().iterator(); iter
					.hasNext();) {
				Object e = (Object) iter.next();
				if (!persister.hasOwnResourceWithoutReferrer(e)) {
					saveOwnerResource = true;
				}
			}
			if (saveOwnerResource) {
				modifiedResources.add(addCommand.getOwner().eResource());
			}
		} else {
			modifiedResources.add(addCommand.getOwner().eResource());
		}

		if (nestedCommands != null && !nestedCommands.isEmpty()) {
			for (int i = nestedCommands.size() - 1; i > -1; i--) {
				Command cmd = (Command) nestedCommands.get(i);
				try {
					if (cmd instanceof IResourceAwareCommand) {
						Collection resources = ((IResourceAwareCommand) cmd)
								.getModifiedResources();
						if (resources != null) {
							modifiedResources.addAll(resources);
						}
					}
				} catch (Exception e) {
					LibraryEditPlugin.getDefault().getLogger().logError(e);
				} finally {
					
				}
			}
		}

		return modifiedResources;
	}

	protected boolean willSaveModifiedResources() {
		return true;
	}
	
	private ILibraryPersister.FailSafeMethodLibraryPersister getPersister() {
		return Services.getDefaultLibraryPersister().getFailSafePersister();
	}

	protected void saveModifiedResources() {
		ILibraryPersister.FailSafeMethodLibraryPersister persister = getPersister();
		try {

			// save the modified resources
			//
			for (Iterator iter = getModifiedResources().iterator(); iter
					.hasNext();) {
				Resource resource = (Resource) iter.next();
				try {
					persister.save(resource);
					canUndo = false;
				} catch (Exception e) {
					LibraryEditPlugin.getDefault().getLogger().logError(e);
					String msg = NLS.bind(
							LibraryEditResources.saveFileError_reason, 
							resource.getURI().isFile() ? resource
									.getURI().toFileString() : resource.toString());
					status.add(new SaveStatus(IStatus.ERROR,
							LibraryEditPlugin.INSTANCE.getSymbolicName(),
							SaveStatus.SAVE_ERROR, msg, e));
					return;
				}
			}

			if (resMgr != null) {
				Collection elementsToCopyRefContents = new ArrayList();
				for (Iterator iter = getAffectedObjects().iterator(); iter
						.hasNext();) {
					elementsToCopyRefContents.add(TngUtil.unwrap(iter.next()));
				}

				Collection modified = resMgr.copyReferencedContents(
						elementsToCopyRefContents, elementToOldPluginMap);
				modified
						.addAll(replaceTextReferences(elementsToCopyRefContents));
				if (modified != null && !modified.isEmpty()) {
					for (Iterator iter = modified.iterator(); iter.hasNext();) {
						Resource resource = (Resource) iter.next();
						try {
							persister.save(resource);
						} catch (Exception e) {
							LibraryEditPlugin.getDefault().getLogger()
									.logError(e);
							String msg = NLS.bind(
									LibraryEditResources.saveFileError_reason,
									resource.getURI().toFileString());
							status.add(new SaveStatus(IStatus.ERROR,
									LibraryEditPlugin.INSTANCE
											.getSymbolicName(),
									SaveStatus.SAVE_ERROR, msg, e));
							return;
						}
					}
				}
			}

			persister.commit();
		} catch (RuntimeException e) {
			StringWriter msg = new StringWriter();
			e.printStackTrace(new PrintWriter(msg));
			IStatus newStatus = new SaveStatus(IStatus.ERROR,
					LibraryEditPlugin.INSTANCE.getSymbolicName(),
					SaveStatus.SAVE_ERROR, msg.toString(), e);
			status.add(newStatus);
		} finally {
			if (status.getSeverity() == IStatus.ERROR) {
				try {
					persister.rollback();
				} catch (Exception e) {
					LibraryEditPlugin.INSTANCE.log(e);
					StringWriter msg = new StringWriter();
					e.printStackTrace(new PrintWriter(msg));
					IStatus newStatus = new SaveStatus(IStatus.ERROR,
							LibraryEditPlugin.INSTANCE.getSymbolicName(),
							SaveStatus.ROLLBACK_ERROR, msg.toString(), e);
					status.add(newStatus);
				}
			}
		}
	}

	/**
	 * If textual descriptions in the copied elements contain references (URLs)
	 * to other elements within the same copied process then replace these
	 * references with references that point to the new elements in the copied
	 * structures.
	 */
	private Collection replaceTextReferences(
			Collection elementsToCopyRefContents) {
		Collection modifiedResources = new HashSet();
		ITextReferenceReplacer txtRefReplacer = ExtensionManager
				.getTextReferenceReplacer();
		if (txtRefReplacer == null)
			return modifiedResources;

		// get map
		EditingDomain ed = addCommand.getDomain();
		if (ed instanceof TraceableAdapterFactoryEditingDomain) {
			Map copyToOriginalMap = ((TraceableAdapterFactoryEditingDomain) ed)
					.getCopyToOriginalMap();
			// the TextReferenceReplacer expects a map of old-to-new. we
			// have a map of new-to-old, so convert it
			Map oldToNewObjectMap = new HashMap();
			for (Iterator iter = copyToOriginalMap.entrySet().iterator(); iter
					.hasNext();) {
				Map.Entry entry = (Map.Entry) iter.next();
				Object key = entry.getKey();
				Object val = entry.getValue();
				if (key != null && val != null)
					oldToNewObjectMap.put(val, key);
			}
			for (Iterator iter = elementsToCopyRefContents.iterator(); iter
					.hasNext();) {
				EObject element = (EObject) iter.next();
				for (Iterator childIter = element.eAllContents(); childIter
						.hasNext();) {
					EObject child = (EObject) childIter.next();
					for (Iterator attributes = child.eClass()
							.getEAllAttributes().iterator(); attributes
							.hasNext();) {
						EAttribute attribute = (EAttribute) attributes.next();
						if (attribute.isChangeable()
								&& !attribute.isDerived()
								&& (attribute.isMany() || child
										.eIsSet(attribute))
								&& attribute.getEAttributeType()
										.getInstanceClass() == Literals.STRING
										.getInstanceClass()) {
							String text = (String) child.eGet(attribute);
							if (text != null) {
								String newtext = txtRefReplacer.replace(text,
										child, oldToNewObjectMap);
								if (!newtext.equals(text)) {
									child.eSet(attribute, newtext);
									modifiedResources.add(child.eResource());
								}
							}
						}
					}
				}
			}
		}
		return modifiedResources;
	}

	protected void doAdd() {
		try {
			// check feature values
			//
			for (Iterator iter = getFeaturesToCheck().iterator(); iter
					.hasNext();) {
				EStructuralFeature feature = (EStructuralFeature) iter.next();
				if (!checkStringValue(feature)) {
					// user canceled the operaion
					//
					return;
				}
			}

			boolean showWarning = false;
			EditingDomain ed = addCommand.getDomain();
			if (ed instanceof TraceableAdapterFactoryEditingDomain) {
				Map copyToOriginalMap = ((TraceableAdapterFactoryEditingDomain) ed)
						.getCopyToOriginalMap();

				// check first element of addCommand.getCollection()
				// if it's a key in the CopyToOriginalMap, we are pasting and
				// may need to warn the user
				// if it's not a key in the CopyToOriginalMap, then we are
				// probably adding a new element
				if (addCommand.getCollection() != null
						&& addCommand.getCollection().size() > 0
						&& copyToOriginalMap.containsKey(addCommand
								.getCollection().toArray()[0])) {
					elementToOldPluginMap = new HashMap();
					Iterator iter = copyToOriginalMap.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry entry = (Entry) iter.next();
						if (entry.getValue() instanceof MethodElement
								&& !(entry.getValue() instanceof MethodConfiguration)) {
							MethodPlugin plugin = UmaUtil
									.getMethodPlugin((MethodElement) entry
											.getValue());
							if (plugin != null) {
								elementToOldPluginMap.put(entry.getKey(),
										plugin);
							} else {
								// plugin == null, original element was probably
								// deleted
								showWarning = true;
							}
						}
					}
				}
			}

			if (showWarning) {
					Messenger.INSTANCE
						.showWarning(
								getLabel(),
								LibraryEditResources.MethodElementAddCommand_originalNotFoundWarning_msg);
			}

			final StringBuffer msgBuff = new StringBuffer();
			IRunnableWithProgress operation = new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {
					String msg = checkForIllegalReferences();
					if (msg != null) {
						msgBuff.append(msg);
					}
				}

			};

			IProgressMonitor defaultMonitor = null;
			if (!runWithProgress) {
				defaultMonitor = new NullProgressMonitor();
			}

			if (runWithProgress) {
				UserInteractionHelper.runWithProgress(operation,
						LibraryEditResources.checkingReferencesTask_name); 
			} else {
				try {
					operation.run(defaultMonitor);
				} catch (RuntimeException e) {
					LibraryEditPlugin.INSTANCE.log(e);
					throw e;
				} catch (Exception e) {
					LibraryEditPlugin.INSTANCE.log(e);
					throw new RuntimeException(e.toString());
				}
			}
			if (msgBuff.length() > 0
					&& MsgBox.prompt(Display.getCurrent().getActiveShell(),
							msgBuff.toString(), SWT.YES | SWT.NO) == SWT.NO) {
				return;
			}

			status = new MultiStatus(
					LibraryEditPlugin.INSTANCE.getSymbolicName(),
					IStatus.OK,
					LibraryEditResources.MethodElementAddCommand_errorSavingFiles,
					null); 
			operation = new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor) {
					if (removeXRefRequired) {
						monitor.subTask(""); //$NON-NLS-1$

						for (Iterator iter = addList.iterator(); iter.hasNext();) {
							EObject element = (EObject) iter.next();
							if (element instanceof MethodElement) {
								removeIllegalReferences(ownerPlugin, element);
							}
						}
					}
					//Variables semi-globales para las comprobaciones
					//
					Boolean canExecute = true;
					
					ModelStructure aux = new ModelStructure();
					ModelStructure modelStruct = aux.DEFAULT;//extraigo el modelStructure por defecto definido
					
					// Lanzamos la ventana si el elemento que nos viene es instancia de vpActivity
					//
					for (Iterator iter = addList.iterator(); iter.hasNext();) {
						EObject element = (EObject) iter.next();
						
						/*************Comprobamos Presentaci�n*******************/
						if(element instanceof VarElement){
							changePresentation(element);
						}
						
						
						/******Comprobaci�n de Puntos de Variaci�n******/
						if ((element instanceof VarPoint) && (element instanceof BreakdownElement)) { //Si es instancia de punto de variacion & actividad
									
							canExecute = false;//Cerramos la sentencia si es un punto de variaci�n
							String auxName = "";
							String auxElement = "";
							String auxIcon = "";
							Image imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/desconocido");//Lo inicializamos con el icono desconocido
							//Los 2 padres generales de los que cualquier elemento VP hereda
							VarPoint varPoint = (VarPoint) element;
							BreakdownElement activity = (BreakdownElement) element;
							
							///***Obtencion de dependencias***///
							
							//Obtenemos el nombre de la linea perteneciente desde donde se ejecuta el comando
							//
							Object objFather = addCommand.getOwner();
							
							Collection auxVariants = new ArrayList();
							Collection auxVarPoints = new ArrayList();
							
							if (objFather instanceof ProcessElement){
								ProcessElement auxFather = (ProcessElement) addCommand.getOwner();
								String processLineNameOwner = auxFather.getProcessLineName();
								
								//Obtenemos lista de puntos de variaci�n de esa linea
								//
								VarPointsPackage varPointsPkg = (VarPointsPackage) UmaUtil.findVarPointsPackage(ownerPlugin, modelStruct.varPointsPath, processLineNameOwner);
								if(varPointsPkg != null){
									auxVarPoints = varPointsPkg.getVarPoints();
								}
								//Obtenemos la lista de variantes de esa linea para el mismo tipo
								//
								VariantsPackage variantsPkg = (VariantsPackage) UmaUtil.findVariantsPackage(ownerPlugin, modelStruct.variantsPath, processLineNameOwner);
								
								////VPActividad
								if(element instanceof vpActivity){//Instancia de VarActivity
									auxName="vpActivity";
									auxElement="Activity";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vpactivity");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarActivity){
											auxVariants.add(varElement);
										}
									}
								}
								////VPPhase
								if(element instanceof vpPhase){//Instancia de VarActivity
									auxName="vpPhase";
									auxElement="Phase";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vpphase");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarPhase){
											auxVariants.add(varElement);
										}
									}
								}
								////VPIteration
								if(element instanceof vpIteration){//Instancia de VarActivity
									auxName="vpIteration";
									auxElement="Iteration";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vpiteration");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarIteration){
											auxVariants.add(varElement);
										}
									}
								}
								////VPRoleDescriptor
								if(element instanceof vpRoleDescriptor){
									auxName="vpRole Descriptor";
									auxElement="Role Descriptor";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vproledescriptor");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarRoleDescriptor){
											auxVariants.add(varElement);
										}
									}
								}
								////VPTaskDescriptor
								if(element instanceof vpTaskDescriptor){
									auxName="vpTask Descriptor";
									auxElement="Task Descriptor";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vptaskdescriptor");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarTaskDescriptor){
											auxVariants.add(varElement);
										}
									}
								}
								////VPWorkProductDescriptor
								if(element instanceof vpWorkProductDescriptor){
									auxName="vpWorkProduct Descriptor";
									auxElement="WorkProduct Descriptor";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vpworkproductdescriptor");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarWorkProductDescriptor){
											auxVariants.add(varElement);
										}
									}
								}
								////VPTeamProfile
								if(element instanceof vpTeamProfile){
									auxName="vpTeamProfile";
									auxElement="TeamProfile";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vpteamprofile");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarTeamProfile){
											auxVariants.add(varElement);
										}
									}
								}
								////VPMilestone
								if(element instanceof vpMilestone){
									auxName="vpMilestone";
									auxElement="Milestone";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vpmilestone");
									
									for(Iterator iterator = variantsPkg.getVariant().iterator(); iterator.hasNext();){
										EObject varElement = (EObject) iterator.next();
										if(varElement instanceof VarMilestone){
											auxVariants.add(varElement);
										}
									}
								}
								
								
								
							}
							///***********///
		
							///Ventana - Composicion SWT
							Display display = Display.getDefault();
							Shell shell = new Shell(display);
							VarPointDialog varPointDialog = new VarPointDialog(shell, SWT.NULL, auxName, auxElement, imgIcon, varPoint, auxVariants, auxVarPoints, false, false);
							varPointDialog.open();
							
							//Si todo se ejecuto de forma correcta entonces procedemos a guardar el elemento FIXME! Hay datos que no se tratan bien
							if(varPointDialog.execute == true){
								canExecute = true;
								//Recogo datos, varPoint es una referencia a element
								varPoint.setIsImplicit(varPointDialog.isImplicit);
								varPoint.setIsOpen(varPointDialog.isOpen);
								varPoint.setMin(varPointDialog.cardMin);//
								varPoint.setMax(varPointDialog.cardMax);//
								varPoint.setVId(varPointDialog.vpId);
								varPoint.setVpName(varPointDialog.nombre);
								varPoint.setPathIcon(varPointDialog.icono);
								varPoint.setDescription(varPointDialog.descripcion);
								
								activity.setName(varPoint.getVpName());
								activity.setPresentationName(varPoint.getVpName());
								
								
								//Dependenias - Nos las generamos dependiendo de las listas llenadas en la interfaz
								//
								
								//varPoint2varPoint (Inclusive)
								if(varPointDialog.inclusiveVarPoint2VarPointPersistence.size() > 0){
									
									Collection auxListClient = new ArrayList();
									
									
									for(Iterator iterator = varPointDialog.inclusiveVarPoint2VarPointPersistence.iterator(); iterator.hasNext();){
										Collection auxListSupplier = new ArrayList();
										
										EObject varPointSupplier = (EObject) iterator.next();
										
										varP2varP varP2varPI = UmaFactory.eINSTANCE.createvarP2varP();
										varP2varP varP2varPIForSupplier = UmaFactory.eINSTANCE.createvarP2varP();
										
										if(varPointSupplier instanceof VarPoint){
											VarPoint varPointAuxSupplier = (VarPoint) varPointSupplier;
											//Client
											varP2varPI.setClient(varPoint);//Cliente
											varP2varPI.setSupplier(varPointAuxSupplier);//Supplier
											varP2varPI.setIsInclusive(true);//Inclusivo
											//Supplier
											varP2varPIForSupplier.setClient(varPoint);//Cliente
											varP2varPIForSupplier.setSupplier(varPointAuxSupplier);//Supplier
											varP2varPIForSupplier.setIsInclusive(true);//Inclusivo
											
											auxListClient.add(varP2varPI);
											auxListSupplier.add(varP2varPIForSupplier);
											
											varPointAuxSupplier.getSupplier().addAll(auxListSupplier);
										}
									}
									varPoint.getClient().addAll(auxListClient);
								}
								//varPoint2variant (Inclusive)
								if(varPointDialog.inclusiveVarPoint2VariantPersistence.size() > 0){
									
									Collection auxListClient = new ArrayList();
									
									
									for(Iterator iterator = varPointDialog.inclusiveVarPoint2VariantPersistence.iterator(); iterator.hasNext();){
										Collection auxListSupplier = new ArrayList();
										
										EObject variantSupplier = (EObject) iterator.next();
										
										varp2variant varP2variantI = UmaFactory.eINSTANCE.createvarp2variant();
										varp2variant varP2variantIForSupplier = UmaFactory.eINSTANCE.createvarp2variant();
										
										if(variantSupplier instanceof Variant){
											Variant variantAuxSupplier = (Variant) variantSupplier;
											//Client
											varP2variantI.setClient(varPoint);//Cliente
											varP2variantI.setSupplier(variantAuxSupplier);//Supplier
											varP2variantI.setIsInclusive(true);//Inclusivo
											//Supplier
											varP2variantIForSupplier.setClient(varPoint);//Cliente
											varP2variantIForSupplier.setSupplier(variantAuxSupplier);//Supplier
											varP2variantIForSupplier.setIsInclusive(true);//Inclusivo
																						
											auxListClient.add(varP2variantI);
											auxListSupplier.add(varP2variantIForSupplier);
											
											variantAuxSupplier.getSupplier().addAll(auxListSupplier);
											
										}
									}
									varPoint.getClient().addAll(auxListClient);
								}
								//varP2varP (Exclusive)
								if(varPointDialog.exclusiveVarPoint2VarPointPersistence.size() > 0){
									
									Collection auxListClient = new ArrayList();
									
									
									for(Iterator iterator = varPointDialog.exclusiveVarPoint2VarPointPersistence.iterator(); iterator.hasNext();){
										
										Collection auxListSupplier = new ArrayList();
										
										EObject varPointSupplier = (EObject) iterator.next();
										varP2varP varP2varPE = UmaFactory.eINSTANCE.createvarP2varP();
										varP2varP varP2varPEForSupplier = UmaFactory.eINSTANCE.createvarP2varP();
										
										if(varPointSupplier instanceof VarPoint){
											VarPoint varPointAuxSupplier = (VarPoint) varPointSupplier;
											//Client
											varP2varPE.setClient(varPoint);//Cliente
											varP2varPE.setSupplier(varPointAuxSupplier);//Supplier
											varP2varPE.setIsInclusive(false);//Exclusivo
											//Supplier
											varP2varPEForSupplier.setClient(varPoint);//Cliente
											varP2varPEForSupplier.setSupplier(varPointAuxSupplier);//Supplier
											varP2varPEForSupplier.setIsInclusive(false);//Exclusivo
											
											auxListClient.add(varP2varPE);
											auxListSupplier.add(varP2varPEForSupplier);
											
											varPointAuxSupplier.getSupplier().addAll(auxListSupplier);
									
										}
									}
									varPoint.getClient().addAll(auxListClient);
								}

							}
							else{
								//Ninguna acci�n
							}
						}
						
						/******Comprobacion de Variantes******/
						if((element instanceof Variant) && (element instanceof BreakdownElement)){//Si es una instancia de variante y de actividad
							//Variables
							canExecute = false;//Cerramos la sentencia si es un punto de variaci�n
							String auxName = "";
							String auxElement = "";
							String auxIcon = "";
							Image imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/desconocido");//Lo inicializamos con el icono desconocido
							//Los 2 padres generales de los que cualquier elemento Variante hereda
							Variant variant = (Variant) element;
							BreakdownElement activity = (BreakdownElement) element;
							
							///***Obtencion de dependencias***///
							
							//Obtenemos el nombre de la linea perteneciente desde donde se ejecuta el comando
							//
							Object objFather = addCommand.getOwner();
							
							Collection auxVariants = new ArrayList();
							Collection auxVarPoints = new ArrayList();
							
							if (objFather instanceof ProcessElement){
								ProcessElement auxFather = (ProcessElement) addCommand.getOwner();
								String processLineNameOwner = auxFather.getProcessLineName();
								
								//Obtenemos lista de variantes de esa linea
								//
								VariantsPackage variantsPkg = (VariantsPackage) UmaUtil.findVariantsPackage(ownerPlugin, modelStruct.variantsPath, processLineNameOwner);
								if (variantsPkg != null){
									auxVariants = variantsPkg.getVariant();
								}
								
								//Obtenemos lista de puntos de variacion de esa linea para el mismo tipo
								//
								VarPointsPackage varPointsPkg = (VarPointsPackage) UmaUtil.findVarPointsPackage(ownerPlugin, modelStruct.varPointsPath, processLineNameOwner);
								
								////VarActivity
								if(element instanceof VarActivity){
									auxName="VarActivity";
									auxElement="Activity";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vactivity");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpActivity){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarPhase
								if(element instanceof VarPhase){
									auxName="VarPhase";
									auxElement="Phase";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/varphase");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpPhase){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarIteration
								if(element instanceof VarIteration){
									auxName="VarIteration";
									auxElement="Iteration";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/variteration");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpIteration){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarRoleDescriptor
								if(element instanceof VarRoleDescriptor){
									auxName="VarRoleDescriptor";
									auxElement="Role Descriptor";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/varroledescriptor");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpRoleDescriptor){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarTaskDescriptor
								if(element instanceof VarTaskDescriptor){
									auxName="VarTaskDescriptor";
									auxElement="Task Descriptor";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vartaskdescriptor");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpTaskDescriptor){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarWorkProductDescriptor
								if(element instanceof VarWorkProductDescriptor){
									auxName="VarWorkProductDescriptor";
									auxElement="WorkProduct Descriptor";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vworkproductdescriptor");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpWorkProductDescriptor){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarTeamProfile
								if(element instanceof VarTeamProfile){
									auxName="VarTeamProfile";
									auxElement="Team Profile";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vteamprofile");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpTeamProfile){
											auxVarPoints.add(vpElement);
										}
									}
								}
								
								////VarMilestone
								if(element instanceof VarMilestone){
									auxName="VarMilestone";
									auxElement="Milestone";
									imgIcon = LibraryEditPlugin.INSTANCE.getImage("full/vSPEM70x70/vmilestone");//Icon
									
									for(Iterator iterator = varPointsPkg.getVarPoints().iterator(); iterator.hasNext();){
										EObject vpElement = (EObject) iterator.next();
										if(vpElement instanceof vpMilestone){
											auxVarPoints.add(vpElement);
										}
									}
								}
							}
							///***********///
							

							
							///Ventana - Composicion SWT
							Display display = Display.getDefault();
							Shell shell = new Shell(display);
							
							/**
							 * @param Nombre
							 * @param Imagen Icono
							 */
							VariantDialog variantDialog = new VariantDialog(shell, SWT.NULL, auxName, auxElement, imgIcon, variant, auxVariants, auxVarPoints, false, false);
							variantDialog.open();
							
							//Si todo se ejecuto de forma correcta entonces procedemos a guardar el elemento FIXME! Hay datos que no se tratan bien
							if(variantDialog.execute == true){
								canExecute = true;
								//variant es una referencia a element - Datos
								//
								variant.setDescription(variantDialog.descripcion);//Descripcion
								variant.setVId(variantDialog.vpId);//Identificador
								variant.setVpName(variantDialog.nombre);//Nombre
								activity.setName(variantDialog.nombre);//Nombre
								activity.setPresentationName(variantDialog.nombre);//Nombre
								
								//Dependenias - Nos las generamos dependiendo de las listas llenadas en la interfaz
								//
								
								//variant2variant (Inclusive)
								if(variantDialog.inclusiveVariant2VariantPersistence.size() > 0){
									
									Collection auxListClient = new ArrayList();
									
									
									for(Iterator iterator = variantDialog.inclusiveVariant2VariantPersistence.iterator(); iterator.hasNext();){				
										Collection auxListSupplier = new ArrayList();
										
										EObject variantSupplier = (EObject) iterator.next();
										variant2variant variant2variantI = UmaFactory.eINSTANCE.createvariant2variant();
										variant2variant variant2variantIForSupplier = UmaFactory.eINSTANCE.createvariant2variant();
										
										if(variantSupplier instanceof Variant){
											Variant varAuxSupplier = (Variant) variantSupplier;
											//Client
											variant2variantI.setClient(variant);//Cliente
											variant2variantI.setSupplier(varAuxSupplier);//Supplier
											variant2variantI.setIsInclusive(true);//Inclusivo
											//Supplier
											variant2variantIForSupplier.setClient(variant);//Cliente
											variant2variantIForSupplier.setSupplier(varAuxSupplier);//Supplier
											variant2variantIForSupplier.setIsInclusive(true);//Inclusivo
											
											auxListClient.add(variant2variantI);
											auxListSupplier.add(variant2variantIForSupplier);
											
											varAuxSupplier.getSupplier().addAll(auxListSupplier);
										}
									}
									variant.getClient().addAll(auxListClient);
								}
								
								//variant2varPoint (Inclusive)
								if(variantDialog.inclusiveVariant2VarPointPersistence.size() > 0){
									
									Collection auxListClient = new ArrayList();
									
									
									for(Iterator iterator = variantDialog.inclusiveVariant2VarPointPersistence.iterator(); iterator.hasNext();){
										Collection auxListSupplier = new ArrayList();
										
										EObject varPointSupplier = (EObject) iterator.next();
										variant2varP variant2varPointI = UmaFactory.eINSTANCE.createvariant2varP();
										variant2varP variant2varPointIForSupplier = UmaFactory.eINSTANCE.createvariant2varP();
										
										if(varPointSupplier instanceof VarPoint){
											VarPoint varPointAuxSupplier = (VarPoint) varPointSupplier;
											//Client
											variant2varPointI.setClient(variant);//Cliente
											variant2varPointI.setSupplier(varPointAuxSupplier);//Supplier
											variant2varPointI.setIsInclusive(true);//Inclusivo
											//Supplier
											variant2varPointIForSupplier.setClient(variant);//Cliente
											variant2varPointIForSupplier.setSupplier(varPointAuxSupplier);//Supplier
											variant2varPointIForSupplier.setIsInclusive(true);//Inclusivo
											
											auxListClient.add(variant2varPointI);
											auxListSupplier.add(variant2varPointIForSupplier);
											
											varPointAuxSupplier.getSupplier().addAll(auxListSupplier);
										}
										
										
									}
									variant.getClient().addAll(auxListClient);
								}
								//variant2variant (Exclusive)
								if(variantDialog.exclusiveVariant2VariantPersistence.size() > 0){
									
									Collection auxListClient = new ArrayList();
									
									
									for(Iterator iterator = variantDialog.exclusiveVariant2VariantPersistence.iterator(); iterator.hasNext();){
										Collection auxListSupplier = new ArrayList();
										
										EObject variantSupplier = (EObject) iterator.next();
										variant2variant variant2variantE = UmaFactory.eINSTANCE.createvariant2variant();
										variant2variant variant2variantEForSupplier = UmaFactory.eINSTANCE.createvariant2variant();
										
										if(variantSupplier instanceof Variant){
											Variant varAuxSupplier = (Variant) variantSupplier;
											
											//Client
											variant2variantE.setClient(variant);//Cliente
											variant2variantE.setSupplier(varAuxSupplier);//Supplier
											variant2variantE.setIsInclusive(false);//Exclusivo
											//Supplier
											variant2variantEForSupplier.setClient(variant);
											variant2variantEForSupplier.setSupplier(varAuxSupplier);
											variant2variantEForSupplier.setIsInclusive(false);

											
											auxListClient.add(variant2variantE);
											auxListSupplier.add(variant2variantEForSupplier);
											
											varAuxSupplier.getSupplier().addAll(auxListSupplier);
											
										}
										
										
									}
									variant.getClient().addAll(auxListClient);
									ownerPlugin.getMethodPackages();
								}
							}
							else{
								//Ninguna acci�n
							}
						}
						/**Fin comprobacion**/
					}
					
					/****/
					
					
					
					
					if(canExecute){
						
					
						// add the elements
						//
						superExecute();
	
						executeNestedCommands();
	
						if (willSaveModifiedResources()) {
							IStatus result = saveNewElementsWithOwnResource();
							if (result.isOK()) {
								monitor
										.subTask(LibraryEditResources.savingModifiedFilesTask_name); 
								saveModifiedResources();
							} else {
								status.add(result);
							}
						}
	
						if (!status.isOK()) {
							// FIXME: this causes dead-lock at
							// LibraryProcessor.notifyListeners(). The method
							// is synchronized, this might be the cause of the
							// dead-lock
							//
							undo();
							
							if(CommandStatusChecker.hasRollbackError(status)) {
								Collection<?> createdElements = command.getResult();
								ILibraryPersister persister = Services.getDefaultLibraryPersister();
								for (Object object : createdElements) {
									if(object instanceof MethodElement) {
										try {
											persister.delete((MethodElement) object);
										}
										catch(Exception e) {
											LibraryEditPlugin.getDefault().getLogger().logError(e);
										}
									}
								}								
							}						
						}
					}
				}



			};
			if (runWithProgress) {
				UserInteractionHelper.runWithProgress(operation, ""); //$NON-NLS-1$
			} else {
				try {
					operation.run(defaultMonitor);
				} catch (RuntimeException e) {
					LibraryEditPlugin.INSTANCE.log(e);
					throw e;
				} catch (Exception e) {
					LibraryEditPlugin.INSTANCE.log(e);
					throw new RuntimeException(e.toString());
				}
			}

			if (!status.isOK()) {
				Messenger.INSTANCE.showError(getLabel(), LibraryEditResources.error_msgWithDetails, status);
				return;
			}
		} catch (RuntimeException e) {
			Messenger.INSTANCE.showError(getLabel(), LibraryEditResources.error_msg, null, e);
		}
	}

	
	/**
	 * Metodo que se encarga de setear la presentaci�n correcta en nuestros elementos VarElement
	 * @param element
	 */
	protected void changePresentation(EObject element){
		//ActivityDescription (Activity, Phase, Iteration)
		if(element instanceof Activity){
			Activity act = (Activity) element;
			act.setPresentation(UmaFactory.eINSTANCE.createActivityDescription());
			act.getPresentation();
		}
		//DescriptorDescription (RoleDescriptor, WorkProductDescriptor, TaskDescriptor)
		else if(element instanceof Descriptor){
			Descriptor desc = (Descriptor) element;
			desc.setPresentation(UmaFactory.eINSTANCE.createDescriptorDescription());
			desc.getPresentation();
		}
		//BreakdownDescriptor (TeamProfile, Milestone)
		else if(element instanceof BreakdownElement){
			BreakdownElement br = (BreakdownElement) element;
			br.setPresentation(UmaFactory.eINSTANCE.createBreakdownElementDescription());
			br.getPresentation();
		}
		
	}

	private boolean addFeatureIsContainment() {
		return addCommand.getFeature() instanceof EReference
				&& ((EReference) addCommand.getFeature()).isContainment();
	}

	/**
	 * Saves added elements that are new to the library and can have own
	 * resource that no other resource refers to (like MethodConfiguration)
	 * 
	 * @throws Exception
	 */
	protected IStatus saveNewElementsWithOwnResource() {
		if (addFeatureIsContainment()) {
			ILibraryPersister persister = Services.getDefaultLibraryPersister();
			for (Iterator iter = addList.iterator(); iter.hasNext();) {
				Object element = iter.next();
				if (element instanceof MethodElement) {
					MethodElement me = (MethodElement) element;

					if (me instanceof ContentElement ||
						me instanceof MethodPlugin || 
						me instanceof MethodConfiguration) {						
						IStatus is = checkFilePathLengthBeforeSave(me);
						if (is != null) {
							return is;
						}
					}

					if (persister.hasOwnResourceWithoutReferrer(me)) {
						try {
							persister.save(me);
						} catch (Exception e) {
							LibraryEditPlugin.getDefault().getLogger()
									.logError(e);
							String msg = e.getMessage();
							if (StrUtil.isBlank(msg)) {
								msg = e.toString();
							}
							return new SaveStatus(IStatus.ERROR,
									LibraryEditPlugin.INSTANCE
											.getSymbolicName(),
									SaveStatus.SAVE_ERROR, msg, e);
						}
					}
				}
			}
		}

		return Status.OK_STATUS;
	}

	private IStatus checkFilePathLengthBeforeSave(MethodElement element) {
		MethodElement parentElementWithResource = null;
		if (element instanceof MethodPlugin || element instanceof MethodConfiguration) {
			parentElementWithResource = UmaUtil.getMethodLibrary(element);
		} else {
			parentElementWithResource = UmaUtil.getMethodPlugin(element);
		}
		if (! NameChecker.checkFilePathLength(parentElementWithResource, element, element.getName(), 
				IValidator.MaxFilePathNameLength, null)) {
			String msg = NLS.bind(LibraryEditResources.filePathNameTooLong_msg, 
					new Object[] { new Integer(IValidator.MaxFilePathNameLength) } );
			return new SaveStatus(IStatus.ERROR,
					LibraryEditPlugin.INSTANCE
							.getSymbolicName(),
					SaveStatus.SAVE_ERROR, msg, null);
		}
		return null;
	}

	/**
	 * 
	 */
	protected void executeNestedCommands() {
		List nestedCommandProviders = ExtensionManager
				.getNestedCommandProviders();
		if (!nestedCommandProviders.isEmpty()) {
			if (!addList.isEmpty()) {
				nestedCommands = new ArrayList();
				for (Iterator iter = nestedCommandProviders.iterator(); iter
						.hasNext();) {
					INestedCommandProvider cmdProvider = (INestedCommandProvider) iter
							.next();
					try {
						Command cmd = cmdProvider.createRelatedObjects(addList,
								this);
						if (cmd != null && cmd.canExecute()) {
							cmd.execute();
							nestedCommands.add(cmd);
						}
					} catch (Exception e) {
						LibraryEditPlugin.getDefault().getLogger().logError(e);
					}
				}
			}
		}

	}

	private static class ContainmentInfo {
		EObject container;

		int index;

		ContainmentInfo(EObject container, int index) {
			this.container = container;
			this.index = index;
		}
	}

	private static class IllegalReferenceRemover {
		private MethodPlugin targetPlugin;

		private Collection elementsToMove;

		/**
		 * list of Reference objects
		 * 
		 * @see Reference
		 */
		private List illegalReferences;

		private Set affectedResources;

		private ArrayList removedReferences;

		private boolean searchOutgoingRefs;

		private boolean searchIncomingRefs;

		public IllegalReferenceRemover(MethodPlugin targetPlugin,
				Collection elementsToMove, boolean searchOutgoingRefs,
				boolean searchIncomingRefs) {
			this.targetPlugin = targetPlugin;
			this.elementsToMove = elementsToMove;
			this.searchOutgoingRefs = searchOutgoingRefs;
			this.searchIncomingRefs = searchIncomingRefs;
		}

		public Set getAffectedResources() {
			if (affectedResources == null) {
				illegalReferences = new ArrayList();
				for (Iterator iterator = elementsToMove.iterator(); iterator
						.hasNext();) {
					Object obj = iterator.next();

					if (obj instanceof MethodElement) {
						MethodElement e = (MethodElement) obj;

						// get outgoing references
						//
						if (searchOutgoingRefs
								&& !isExcludedFromOutgoingReferenceCheck(obj)) {
							getIllegalOutgoingReferences(targetPlugin, e,
									illegalReferences);
						}

						// get incoming references
						//
						if (searchIncomingRefs) {
							Collection references = AssociationHelper
									.getReferences(e);
							for (Iterator iter = references.iterator(); iter
									.hasNext();) {
								MethodElement element = (MethodElement) iter
										.next();
								if (!elementsToMove.contains(element)) {
									MethodPlugin plugin = UmaUtil
											.getMethodPlugin(element);
									if (plugin != null
											&& plugin != targetPlugin
											&& !Misc.isBaseOf(targetPlugin,
													plugin)) {
										Collection xRefs = getXReferences(
												element, e, null);
										for (Iterator iter1 = xRefs.iterator(); iter1
												.hasNext();) {
											EStructuralFeature f = (EStructuralFeature) iter1
													.next();
											illegalReferences
													.add(new Reference(element,
															f, e));
										}

									}
								}
							}
						}
					}
				}

				affectedResources = new HashSet();
				for (Iterator iter = illegalReferences.iterator(); iter
						.hasNext();) {
					Reference ref = (Reference) iter.next();
					if (ref.owner.eResource() != null) {
						affectedResources.add(ref.owner.eResource());
					}
				}
			}
			return affectedResources;
		}

		public void removeIllegalReferences() {
			removedReferences = new ArrayList();
			for (Iterator iter = illegalReferences.iterator(); iter.hasNext();) {
				Reference ref = (Reference) iter.next();
				if (ref.feature.isMany()) {
					List list = ((List) ref.owner.eGet(ref.feature));
					// TODO: needs revisit
					// This code throws
					// org.eclipse.emf.common.util.BasicEList$BasicIndexOutOfBoundsException
					// sometimes
					//
					// if(ref.index != -1) {
					// list.remove(ref.index);
					// }
					// else {
					// list.remove(ref.value);
					// }

					list.remove(ref.value);
				} else {
					if (ref.feature == UmaPackage.eINSTANCE
							.getVariabilityElement_VariabilityType()) {
						//Should query the default value if extended for any attribute feature
						ref.owner.eSet(ref.feature, VariabilityType.NA_LITERAL);
					} else {
						ref.owner.eSet(ref.feature, null);
					}
				}
				removedReferences.add(ref);
			}

		}

		public void restoreRemovedReferences() {
			if (removedReferences == null) {
				return;
			}
			for (int i = removedReferences.size() - 1; i > -1; i--) {
				Reference ref = (Reference) removedReferences.get(i);
				if (ref.feature.isMany()) {
					List list = ((List) ref.owner.eGet(ref.feature));
					if (ref.index != -1) {
						try {
							// TODO: need revisits
							//
							if (!list.contains(ref.value)) {
								if (ref.index < list.size()) {
									list.add(ref.index, ref.value);
								} else {
									list.add(ref.value);
								}
							}
						} catch (RuntimeException e) {
							throw e;
						}
					} else {
						list.add(ref.value);
					}
				} else {
					ref.owner.eSet(ref.feature, ref.value);
				}
			}
		}
	}

	public static class MoveOperation {
		/** Constants for state of the move operation */
		private static final int STATE_START = 0;

		private static final int STATE_SAVED_FILES = 80;

		private static final int STATE_MOVED_FILES = 70;

		private static final int STATE_COPIED_RESOURCES = 90;

		private static final int STATE_END = 100;

		// private Command command;
		private AddCommand addCommand;

		private Collection moveList;

		private boolean removeXRefRequired = false;

		private boolean isRefenrecedIllegally = false;

		private MethodPlugin ownerPlugin;

		private Map elementToOldPluginMap;

		private Map elementToNewNameMap;

		private IProgressMonitor monitor;

		private Shell shell;

		private HashSet movedResources;

		private MultiStatus status;

		/**
		 * Current state of the move operation, it can be one of the state
		 * constants
		 */
		private int state;

		protected Set modifiedResources;

		private IllegalReferenceRemover illegalReferenceRemover;

		private HashMap elementToOldContainerMap;

		public MoveOperation(Command command, IProgressMonitor monitor,
				Shell shell) {
			// this.command = command;
			addCommand = (AddCommand) TngUtil.unwrap(command);
			this.monitor = monitor;
			this.shell = shell;
		}

		/**
		 * @return Returns the status.
		 */
		public IStatus getStatus() {
			return status;
		}

		/**
		 * Checks if reloading library is needed in case of move failure
		 * 
		 * @return
		 * @see #getStatus()
		 */
		public boolean reloadNeeded() {
			return status != null
					&& CommandStatusChecker.hasRollbackError(status);
		}

		private void undo() {
			// undo name change
			//
			if (elementToNewNameMap != null) {
				for (Iterator iter = elementToNewNameMap.entrySet().iterator(); iter
						.hasNext();) {
					Map.Entry entry = (Map.Entry) iter.next();
					NamedElement e = (NamedElement) entry.getKey();
					e.setName((String) entry.getValue());
				}
			}

			if (elementToOldContainerMap != null) {
				for (Iterator iter = elementToOldContainerMap.entrySet()
						.iterator(); iter.hasNext();) {
					Map.Entry entry = (Map.Entry) iter.next();
					EObject e = (EObject) entry.getKey();
					ContainmentInfo containmentInfo = (ContainmentInfo) entry
							.getValue();
					EStructuralFeature f = addCommand.getFeature();
					if (f.isMany()) {
						((List) containmentInfo.container.eGet(f)).add(
								containmentInfo.index, e);
					} else {
						containmentInfo.container.eSet(f, e);
					}
				}
			}

			if (illegalReferenceRemover != null) {
				illegalReferenceRemover.restoreRemovedReferences();
			}
		}

		public void run() {
			state = STATE_START;

			status = new MultiStatus(LibraryEditPlugin.INSTANCE
					.getSymbolicName(), IStatus.OK,
					LibraryEditResources.error_reason, null); 

			if (checkName()) {
				// check if the configurations that will be updated after this
				// command can be modified
				//
				IStatus execStatus = UserInteractionHelper
						.checkConfigurationsToUpdate(addCommand, shell);
				if (!execStatus.isOK()) {
					Messenger.INSTANCE.showError(LibraryEditResources.moveDialog_title, null, execStatus);
					return;
				}

				final StringBuffer msgBuffer = new StringBuffer();
				IRunnableWithProgress runnable = new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						monitor
								.subTask(LibraryEditResources.checkingReferencesTask_name); 
						String msg = checkForIllegalReferences();
						if (msg != null) {
							msgBuffer.append(msg);
						}
					}

				};

				try {
					ModalContext.run(runnable, true, monitor, shell
							.getDisplay());
				} catch (Exception e) {
					LibraryEditPlugin.INSTANCE.log(e);
					Throwable ex;
					if (e instanceof InvocationTargetException) {
						ex = ((InvocationTargetException) e)
								.getTargetException();
					} else {
						ex = e;
					}
					String msg = TngUtil.toStackTraceString(ex);
					status.add(new Status(IStatus.ERROR,
							LibraryEditPlugin.INSTANCE.getSymbolicName(), 0,
							msg, ex));
					return;
				}

				if (msgBuffer.length() > 0
						&& MsgBox.prompt(shell, msgBuffer.toString(), SWT.YES
								| SWT.NO) == SWT.NO) {
					return;
				}

				// save reference to old resource of all elements in the
				// moveList
				//
				final Map elementToOldResourceMap = new HashMap();
				for (Iterator iter = moveList.iterator(); iter.hasNext();) {
					EObject element = (EObject) iter.next();
					if (element instanceof MethodElement) {
						// save the reference to old resource
						//
						elementToOldResourceMap.put(element, element
								.eResource());
					}
				}

				if (removeXRefRequired || isRefenrecedIllegally) {
					// get set of resources that will be modified during this
					// move
					//
					illegalReferenceRemover = new IllegalReferenceRemover(
							ownerPlugin, moveList, removeXRefRequired,
							isRefenrecedIllegally);
					runnable = new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor)
								throws InvocationTargetException,
								InterruptedException {
							monitor
									.subTask(LibraryEditResources.checkAffectedResourcesTask_name); 
							modifiedResources = illegalReferenceRemover
									.getAffectedResources();
						}

					};
					try {
						ModalContext.run(runnable, true, monitor, shell
								.getDisplay());
					} catch (Exception e) {
						LibraryEditPlugin.INSTANCE.log(e);
						Throwable ex;
						if (e instanceof InvocationTargetException) {
							ex = ((InvocationTargetException) e)
									.getTargetException();
						} else {
							ex = e;
						}
						String msg = TngUtil.toStackTraceString(ex);
						status.add(new Status(IStatus.ERROR,
								LibraryEditPlugin.INSTANCE.getSymbolicName(),
								0, msg, ex));
						return;
					}

					// check affected resources for unmodifiable
					execStatus = UserInteractionHelper.checkModify(
							modifiedResources, shell);
					if (!execStatus.isOK()) {
						Messenger.INSTANCE.showError(LibraryEditResources.moveDialog_title, null, execStatus);
						return;
					}

					try {
						monitor
								.subTask(LibraryEditResources.removingReferencestask_name); 
						illegalReferenceRemover.removeIllegalReferences();
					} catch (Exception e) {
						undo();
						String msg = TngUtil.toStackTraceString(e);
						status.add(new Status(IStatus.ERROR,
								LibraryEditPlugin.INSTANCE.getSymbolicName(),
								0, msg, e));
					}
				} else {
					modifiedResources = new HashSet();
					monitor.subTask(""); //$NON-NLS-1$
				}

				// set new name if there is any
				//
				for (Iterator iter = elementToNewNameMap.entrySet().iterator(); iter
						.hasNext();) {
					Map.Entry entry = (Map.Entry) iter.next();
					NamedElement element = (NamedElement) entry.getKey();
					element.setName((String) entry.getValue());
					modifiedResources.add(element.eResource());
					if (element instanceof MethodUnit) {
						movedResources.add(element.eResource());
						if (element instanceof ContentElement) {
							ContentElement e = (ContentElement) element;
							if (ContentDescriptionFactory.hasPresentation(e)) {
								movedResources.add(e.getPresentation());
							}
						}
					}
				}

				// move elements
				//
				runnable = new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						monitor
								.setTaskName(LibraryEditResources.movingTask_name); 
						doMove(monitor, elementToOldResourceMap,
								modifiedResources);
					}

				};
				try {
					ModalContext.run(runnable, true, monitor, shell
							.getDisplay());
				} catch (Exception e) {
					undo();
					Throwable ex;
					if (e instanceof InvocationTargetException) {
						ex = ((InvocationTargetException) e)
								.getTargetException();
					} else {
						ex = e;
					}
					String msg = TngUtil.toStackTraceString(ex);
					status.add(new Status(IStatus.ERROR,
							LibraryEditPlugin.INSTANCE.getSymbolicName(), 0,
							msg, ex));
					return;
				}

				// check moved resources that are not in modifiable resources
				// for unmodifiable
				//
				List resources = new ArrayList(movedResources);
				resources.removeAll(modifiedResources);
				execStatus = UserInteractionHelper
						.checkModify(resources, shell);
				if (!execStatus.isOK()) {
					Messenger.INSTANCE.showError(LibraryEditResources.moveDialog_title, null, execStatus);

					undo();
					return;
				}

				// save resources
				//
				runnable = new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor)
							throws InvocationTargetException,
							InterruptedException {
						try {
							IStatus saveStatus = save(monitor);
							if (!saveStatus.isOK()) {
								status.add(saveStatus);
							}
						} catch (RuntimeException e) {
							LibraryEditPlugin.INSTANCE.log(e);
							throw e;
						}
					}

				};
				try {
					ModalContext.run(runnable, true, monitor, shell
							.getDisplay());
				} catch (Exception e) {
					Throwable ex;
					if (e instanceof InvocationTargetException) {
						ex = ((InvocationTargetException) e)
								.getTargetException();
					} else {
						ex = e;
					}
					String msg = TngUtil.toStackTraceString(ex);
					status.add(new Status(IStatus.ERROR,
							LibraryEditPlugin.INSTANCE.getSymbolicName(), 0,
							msg, ex));
					return;
				}

			}

			state = STATE_END;
		}

		/**
		 * interacts with user
		 * 
		 * @return
		 */
		private boolean checkName() {
			elementToNewNameMap = MethodElementAddCommand.checkName(addCommand);
			return elementToNewNameMap != null;
		}

		/**
		 * Long running method
		 * 
		 * @return
		 */
		private String checkForIllegalReferences() {
			elementToOldPluginMap = new HashMap();

			moveList = new ArrayList(addCommand.getCollection());
			movedResources = new HashSet();

			for (Iterator iter = addCommand.getCollection().iterator(); iter
					.hasNext();) {
				EObject element = (EObject) iter.next();

				// // set new name if there is any
				// //
				// String newName = (String) elementToNewNameMap.get(element);
				// if(newName != null) {
				// ((NamedElement)element).setName(newName);
				// if(element instanceof MethodUnit) {
				// movedResources.add(element.eResource());
				// if(element instanceof ContentElement) {
				// ContentElement e = (ContentElement) element;
				// if(ContentDescriptionFactory.hasPresentation(e)) {
				// movedResources.add(e.getPresentation());
				// }
				// }
				// }
				// }

				if (element instanceof MethodElement) {
					elementToOldPluginMap.put(element, UmaUtil
							.getMethodPlugin(element));
				}
				for (Iterator iterator = element.eAllContents(); iterator
						.hasNext();) {
					moveList.add(iterator.next());
				}
			}

			// check if there is any illegal reference in the moved objects
			//			
			ownerPlugin = UmaUtil.getMethodPlugin(addCommand.getOwner());
			find_xPluginRef: for (Iterator iter = addCommand.getCollection()
					.iterator(); iter.hasNext();) {
				Object element = iter.next();

				if (isExcludedFromOutgoingReferenceCheck(element)) {
					continue find_xPluginRef;
				}

				if (element instanceof MethodElement) {
					if (hasIllegalReferenceIncludingAllChildren(ownerPlugin,
							(MethodElement) element, moveList)) {
						removeXRefRequired = true;
						break find_xPluginRef;
					}
				}
			}

			find_illegalReferencer: for (Iterator iter = moveList.iterator(); iter
					.hasNext();) {
				Object element = iter.next();
				if (element instanceof MethodElement) {
					if (isReferencedIllegally(ownerPlugin,
							(MethodElement) element, moveList)) {
						isRefenrecedIllegally = true;
						break find_illegalReferencer;
					}
				}
			}
			if (removeXRefRequired || isRefenrecedIllegally) {
				return LibraryEditResources.invalidReferencesError_reason; 
			}
			return null;
		}

		/**
		 * Long running method
		 * 
		 * @return
		 */
		private void doMove(IProgressMonitor monitor,
				Map elementToOldResourceMap, Set modifiedResources) {
			monitor.subTask(""); //$NON-NLS-1$

			elementToOldContainerMap = new HashMap();
			for (Iterator iter = addCommand.getCollection().iterator(); iter
					.hasNext();) {
				EObject element = (EObject) iter.next();
				if (element instanceof MethodElement) {
					EObject container = element.eContainer();
					EStructuralFeature feature = element.eContainingFeature();
					int index;
					if (feature.isMany()) {
						index = ((List) container.eGet(feature))
								.indexOf(element);
					} else {
						index = -1;
					}
					elementToOldContainerMap.put(element, new ContainmentInfo(
							container, index));
				}
			}

			// move the elements
			//
			addCommand.execute();

			// collect resources that had been modifed as result of this move
			//
			Resource newResource = addCommand.getOwner().eResource();
			modifiedResources.add(newResource);
			for (Iterator iter = addCommand.getAffectedObjects().iterator(); iter
					.hasNext();) {
				EObject element = (EObject) TngUtil.unwrap(iter.next());
				if (element instanceof MethodElement) {
					EObject oldContainer = ((ContainmentInfo) elementToOldContainerMap
							.get(element)).container;
					if (oldContainer.eResource() != newResource
							&& !oldContainer.eResource().getContents()
									.isEmpty()) {
						modifiedResources.add(oldContainer.eResource());
						Resource oldResource = (Resource) elementToOldResourceMap
								.get(element);
						if (oldContainer.eResource() != oldResource) {
							movedResources.add(oldResource);
						}
					}

					Object plugin = elementToOldPluginMap.get(element);
					if (ownerPlugin != plugin) {
						// it's a cross-plugin move, add the resources of those
						// children that have direct resource
						// to the moveResources list
						//						
						for (Iterator iterator = element.eAllContents(); iterator
								.hasNext();) {
							EObject e = (EObject) iterator.next();
							if (UmaUtil.hasDirectResource(e)) {
								movedResources.add(e.eResource());
								elementToOldPluginMap.put(e, plugin);
							}
						}

						// if(element instanceof DescribableElement &&
						// ContentDescriptionFactory.hasPresentation((DescribableElement)
						// element)) {
						// movedResources.add(((DescribableElement)element).getPresentation().eResource());
						// elementToOldPluginMap.put(((DescribableElement)element).getPresentation(),
						// plugin);
						// }
						// for (Iterator iterator = element.eAllContents();
						// iterator
						// .hasNext();) {
						// Object e = iterator.next();
						// if(e instanceof DescribableElement &&
						// ContentDescriptionFactory.hasPresentation((DescribableElement)
						// e)) {
						// movedResources.add(((DescribableElement)e).getPresentation().eResource());
						// elementToOldPluginMap.put(((DescribableElement)e).getPresentation(),
						// plugin);
						// }
						// }
					}
				}
			}
		}

		private IStatus save(IProgressMonitor monitor) {
			MultiStatus status = new MultiStatus(
					LibraryEditPlugin.INSTANCE.getSymbolicName(),
					IStatus.OK,
					LibraryEditResources.MethodElementAddCommand_errorSavingFiles,
					null); 

			monitor.subTask(LibraryEditResources.savingModifiedFilesTask_name); 
			ILibraryPersister.FailSafeMethodLibraryPersister persister = Services
					.getDefaultLibraryPersister().getFailSafePersister();
			save: do {
				try {

					if (!movedResources.isEmpty()) {
						monitor
								.subTask(LibraryEditResources.movingFilesTask_name); 

						// move the moved resources
						//
						persister.adjustLocation(movedResources);
					}
					state = STATE_MOVED_FILES;

					// save the modified resources
					//
					for (Iterator iter = modifiedResources.iterator(); iter
							.hasNext();) {
						Resource resource = (Resource) iter.next();
						try {
							// monitor.subTask(MessageFormat.format("Saving
							// ''{0}''", pathArgs));
							persister.save(resource);

						} catch (Exception e) {
							String msg = NLS.bind(
									LibraryEditResources.saveFileError_reason,
									resource.getURI().isFile() ? resource.getURI().toFileString() : resource.toString());
							status.add(new SaveStatus(IStatus.ERROR,
									LibraryEditPlugin.INSTANCE
											.getSymbolicName(),
									SaveStatus.SAVE_ERROR, msg, e));
							break save;
						}
					}
					persister.commit();
					state = STATE_SAVED_FILES;

					if (resMgr != null) {
						monitor
								.subTask(LibraryEditResources.copyingResourcesTask_name); 

						Collection elementsToCopyRefContents = new ArrayList();
						for (Iterator iter = movedResources.iterator(); iter
								.hasNext();) {
							Resource resource = (Resource) iter.next();
							elementsToCopyRefContents.addAll(resource
									.getContents());
						}

						elementsToCopyRefContents.addAll(addCommand
								.getAffectedObjects());

						Collection modified = resMgr.copyReferencedContents(
								elementsToCopyRefContents,
								elementToOldPluginMap);
						if (modified != null && !modified.isEmpty()) {
							for (Iterator iter = modified.iterator(); iter
									.hasNext();) {
								Resource resource = (Resource) iter.next();
								Object[] pathArgs = { resource.getURI().isFile() ? resource.getURI()
										.toFileString() : resource.toString()};
								try {
									monitor
											.subTask(MessageFormat
													.format(
															LibraryEditResources.savingFileTask_name,
															pathArgs)); 
									persister.save(resource);
								} catch (Exception e) {
									String msg = MessageFormat
											.format(
													LibraryEditResources.saveFileError_reason,
													pathArgs); 
									status.add(new SaveStatus(IStatus.ERROR,
											LibraryEditPlugin.INSTANCE
													.getSymbolicName(),
											SaveStatus.SAVE_ERROR, msg, e));
									break save;
								}
							}
						}
					}
					persister.commit();
					state = STATE_COPIED_RESOURCES;

				} catch (RuntimeException e) {
					StringWriter msg = new StringWriter();
					e.printStackTrace(new PrintWriter(msg));
					IStatus newStatus = new SaveStatus(IStatus.ERROR,
							LibraryEditPlugin.INSTANCE.getSymbolicName(),
							SaveStatus.SAVE_ERROR, msg.toString(), e);
					status.add(newStatus);
				} finally {
					if (status.getSeverity() == IStatus.ERROR) {
						try {
							persister.rollback();
						} catch (Exception e) {
							LibraryEditPlugin.INSTANCE.log(e);
							StringWriter msg = new StringWriter();
							e.printStackTrace(new PrintWriter(msg));
							IStatus newStatus = new SaveStatus(IStatus.ERROR,
									LibraryEditPlugin.INSTANCE
											.getSymbolicName(),
									SaveStatus.ROLLBACK_ERROR, msg.toString(),
									e);
							status.add(newStatus);
						}
					}
				}
			} while (false);

			monitor.subTask(LibraryEditResources.command_done); 
			return status;
		}
	}

	public static interface ResourceManager {

		/**
		 * Copies the content resources that are referenced by the content of
		 * the given elements that have been moved/copied to new location.
		 * 
		 * @param elements
		 *            Elements that are moved or copied.
		 * @return collection of modified resources as the result of this call.
		 */
		Collection<Resource> copyReferencedContents(Collection<MethodElement> elements,
				Map<MethodElement, MethodPlugin> elementToOldPluginMap);
	}

	public static class BasicResourceManager implements ResourceManager {

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.ibm.library.edit.command.MethodElementAddCommand.ResourceManager#copyReferencedContents(java.util.Collection)
		 */
		public Collection<Resource> copyReferencedContents(Collection<MethodElement> elements,
				Map<MethodElement, MethodPlugin> elementToOldPluginMap) {
			return null;
		}

	}

	public static void setResourceManager(ResourceManager resMgr) {
		MethodElementAddCommand.resMgr = resMgr;
	}

	private static StringValidator getStringValidator() {
		if (stringValidator == null) {
			stringValidator = new StringValidator();
		}
		return stringValidator;
	}

	private static ResourceManager resMgr = null;

	private static StringValidator stringValidator = null;

	private static class StringValidator implements IInputValidator {

		private Collection elements;

		private IValidator validator;

		private EStructuralFeature feature;

		/**
		 * 
		 */
		private StringValidator() {
		}

		/**
		 * @param elements
		 *            the elements to include in the check.
		 */
		public StringValidator(Collection elements, EStructuralFeature feature) {
			this.elements = elements;
			this.feature = feature;
		}

		/**
		 * Sets the elements to include in the check.
		 * 
		 * @param elements
		 *            the elements to include in the check.
		 */
		public void setElements(Collection elements) {
			this.elements = elements;
		}

		public void setFeature(EStructuralFeature feature) {
			this.feature = feature;
		}

		public void setValidator(IValidator validator) {
			this.validator = validator;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.jface.dialogs.IInputValidator#isValid(java.lang.String)
		 */
		public String isValid(String newText) {
			if (validator instanceof UniquenessValidator) {
				EObject obj = ((UniquenessValidator) validator).getEObject();
				int classID = obj.eClass().getClassifierID();
				newText = newText.trim();
				for (Iterator iter = elements.iterator(); iter.hasNext();) {
					EObject e = (EObject) iter.next();
					String str = (String) e.eGet(feature);
					if (obj != e && classID == e.eClass().getClassifierID()
							&& newText.equalsIgnoreCase(str)) {
						// return I18nUtil.formatString(RESOURCE_BUNDLE, key,
						// data);
						return NLS
								.bind(
										LibraryEditResources.duplicateElementNameError_msg,
										newText);
					}
				}
			}
			return validator.isValid(newText);
		}


	}

}