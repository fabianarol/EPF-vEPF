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
package org.eclipse.epf.authoring.ui.editors;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.epf.authoring.ui.AuthoringPerspective;
import org.eclipse.epf.authoring.ui.AuthoringUIPlugin;
import org.eclipse.epf.authoring.ui.AuthoringUIResources;
import org.eclipse.epf.authoring.ui.actions.LibraryValidateAction;
import org.eclipse.epf.authoring.ui.forms.ChecklistItemsPage;
import org.eclipse.epf.authoring.ui.forms.ContentElementGuidancePage;
import org.eclipse.epf.authoring.ui.forms.ContentPackageDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.CustomCategoryAssignPage;
import org.eclipse.epf.authoring.ui.forms.CustomCategoryDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.DisciplineDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.DisciplineGroupingDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.DisciplineGroupingDisciplinesPage;
import org.eclipse.epf.authoring.ui.forms.DisciplineReferenceWorkflowPage;
import org.eclipse.epf.authoring.ui.forms.DisciplineTasksPage;
import org.eclipse.epf.authoring.ui.forms.DomainDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.DomainWorkProductsPage;
import org.eclipse.epf.authoring.ui.forms.GuidanceDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.GuidanceWithAttachmentsDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.IExtensionFormPage;
import org.eclipse.epf.authoring.ui.forms.IRefreshable;
import org.eclipse.epf.authoring.ui.forms.MethodLibraryDescriptionFormPage;
import org.eclipse.epf.authoring.ui.forms.MethodPluginDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.PracticeDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.PracticeReferencesPage;
import org.eclipse.epf.authoring.ui.forms.RoleCategoriesPage;
import org.eclipse.epf.authoring.ui.forms.RoleDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.RoleSetDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.RoleSetGroupingDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.RoleSetGroupingRoleSets;
import org.eclipse.epf.authoring.ui.forms.RoleSetRolesPage;
import org.eclipse.epf.authoring.ui.forms.RoleWorkProductsPage;
import org.eclipse.epf.authoring.ui.forms.TaskCategoriesPage;
import org.eclipse.epf.authoring.ui.forms.TaskDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.TaskRolesPage;
import org.eclipse.epf.authoring.ui.forms.TaskStepsPage;
import org.eclipse.epf.authoring.ui.forms.TaskWorkProductsPage;
import org.eclipse.epf.authoring.ui.forms.ToolDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.ToolToolMentorsPage;
import org.eclipse.epf.authoring.ui.forms.WorkProductCategoriesPage;
import org.eclipse.epf.authoring.ui.forms.WorkProductDeliverablePartsPage;
import org.eclipse.epf.authoring.ui.forms.WorkProductDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.WorkProductTypeDescriptionPage;
import org.eclipse.epf.authoring.ui.forms.WorkProductTypeWorkProductsPage;
import org.eclipse.epf.authoring.ui.internal.MethodElementEditorErrorTickUpdater;
import org.eclipse.epf.authoring.ui.providers.MethodEditorPageProvider;
import org.eclipse.epf.authoring.ui.providers.MethodElementLabelDecorator;
import org.eclipse.epf.authoring.ui.richtext.IMethodRichText;
import org.eclipse.epf.authoring.ui.util.LibraryValidationMarkerHelper;
import org.eclipse.epf.authoring.ui.views.ElementHTMLViewer;
import org.eclipse.epf.authoring.ui.views.LibraryView;
import org.eclipse.epf.authoring.ui.views.ViewHelper;
import org.eclipse.epf.common.utils.PerspectiveUtil;
import org.eclipse.epf.common.utils.StrUtil;
import org.eclipse.epf.library.ILibraryManager;
import org.eclipse.epf.library.LibraryService;
import org.eclipse.epf.library.LibraryServiceUtil;
import org.eclipse.epf.library.edit.LibraryEditResources;
import org.eclipse.epf.library.edit.TngAdapterFactory;
import org.eclipse.epf.library.edit.command.ActionManager;
import org.eclipse.epf.library.edit.command.FullyRevertibleCommandStack;
import org.eclipse.epf.library.edit.command.IActionManager;
import org.eclipse.epf.library.edit.command.IResourceAwareCommand;
import org.eclipse.epf.library.edit.ui.UserInteractionHelper;
import org.eclipse.epf.library.edit.util.TngUtil;
import org.eclipse.epf.library.persistence.ILibraryResource;
import org.eclipse.epf.library.persistence.ILibraryResourceSet;
import org.eclipse.epf.library.persistence.synch.ISynchronizationHelper;
import org.eclipse.epf.library.services.SafeUpdateController;
import org.eclipse.epf.library.util.ResourceUtil;
import org.eclipse.epf.library.xmi.XMILibraryUtil;
import org.eclipse.epf.persistence.FileManager;
import org.eclipse.epf.persistence.MultiFileXMIResourceImpl;
import org.eclipse.epf.persistence.refresh.RefreshJob;
import org.eclipse.epf.persistence.util.LibrarySchedulingRule;
import org.eclipse.epf.persistence.util.PersistenceUtil;
import org.eclipse.epf.richtext.IRichText;
import org.eclipse.epf.services.ILibraryPersister;
import org.eclipse.epf.services.Services;
import org.eclipse.epf.services.ILibraryPersister.FailSafeMethodLibraryPersister;
import org.eclipse.epf.uma.Checklist;
import org.eclipse.epf.uma.ContentPackage;
import org.eclipse.epf.uma.CustomCategory;
import org.eclipse.epf.uma.Deliverable;
import org.eclipse.epf.uma.Discipline;
import org.eclipse.epf.uma.DisciplineGrouping;
import org.eclipse.epf.uma.Domain;
import org.eclipse.epf.uma.Guidance;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.MethodLibrary;
import org.eclipse.epf.uma.MethodPlugin;
import org.eclipse.epf.uma.Practice;
import org.eclipse.epf.uma.Role;
import org.eclipse.epf.uma.RoleSet;
import org.eclipse.epf.uma.RoleSetGrouping;
import org.eclipse.epf.uma.Task;
import org.eclipse.epf.uma.Tool;
import org.eclipse.epf.uma.UmaPackage;
import org.eclipse.epf.uma.WorkProduct;
import org.eclipse.epf.uma.WorkProductType;
import org.eclipse.epf.uma.util.UmaUtil;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.ui.part.FileEditorInput;

/**
 * The Method Element editor.
 * 
 * @author Shilpa Toraskar
 * @author Kelvin Low
 * @author Phong Nguyen Le
 * @since 1.0
 */
public class MethodElementEditor extends AbstractBaseFormEditor implements
		ISelectionProvider, IGotoMarker {

	protected static class ResourceInfo {
		long modificationStamp;
		long loadStamp;		
		boolean overwrite;
		boolean adjustLocation; 
		
		private Resource resource;		
		
		ResourceInfo(Resource resource) {
			this.resource = resource;
			refresh();
		}
		
		public void refresh() {
			modificationStamp = ISynchronizationHelper.INSTANCE.getModificationStamp(resource);
			if(resource instanceof ILibraryResource) {
				loadStamp = ((ILibraryResource)resource).getLoadStamp();
			}
			else {
				loadStamp = IResource.NULL_STAMP;
			}
		}
	}
	
	/**
	 * The editor ID.
	 */
	public static final String EDITOR_ID = MethodElementEditor.class.getName();

	protected int preview_page_index = -1;

	protected ElementHTMLViewer previewer = null;

	protected MethodElement elementObj = null;

	// The rich text control or editor whose content was last modified before
	// the Save or Save All button key is selected.
	protected IMethodRichText modifiedRichText = null;

	protected Adapter nameChangedListener = new AdapterImpl() {
		public void notifyChanged(org.eclipse.emf.common.notify.Notification msg) {
			switch (msg.getFeatureID(MethodElement.class)) {
			case UmaPackage.METHOD_ELEMENT__NAME:
				nameChanged();
				break;
			}
		}
	};

	protected Collection<ISelectionChangedListener> selectionChangedListeners = new ArrayList<ISelectionChangedListener>();

	protected ISelection currentSelection = StructuredSelection.EMPTY;

	protected ActionManager actionMgr;

	private boolean dirty;

	private FailSafeMethodLibraryPersister persister;

	private Collection<Object> widgetsToRestoreValue = new HashSet<Object>();

	private long changeTime = -1;

	public Object widgetToCheck;

	private Object currentFeatureEditor;

	private EStructuralFeature currentEditedFeature;

	protected ArrayList<Resource> removedResources = new ArrayList<Resource>();

	protected ArrayList<Resource> changedResources = new ArrayList<Resource>();
	
	protected MethodElementEditorErrorTickUpdater fMethodElementEditorErrorTickUpdater = null;
	
	/**
	 * Listens for workspace changes.
	 */
	protected IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
		public void resourceChanged(IResourceChangeEvent event) {
			System.out
					.println("MethodElementEditor.resourceChanged(): event = " + event); //$NON-NLS-1$

			if (elementObj.eIsProxy()) {
				return;
			}

			IResourceDelta delta = event.getDelta();
			try {
				class ResourceDeltaVisitor implements IResourceDeltaVisitor {
					protected Map URIToUsedResourceMap = getURIToUsedResourceMap();

					protected Collection<Resource> changedResources = new ArrayList<Resource>();

					protected Collection<Resource> removedResources = new ArrayList<Resource>();

					public boolean visit(IResourceDelta delta) {
						if (delta.getFlags() != IResourceDelta.MARKERS
								&& delta.getResource().getType() == IResource.FILE) {
							if ((delta.getKind() & (IResourceDelta.CHANGED | IResourceDelta.REMOVED)) != 0) {
								Resource resource = (Resource) URIToUsedResourceMap
										.get(URI.createFileURI(delta
												.getResource().getLocation()
												.toString()));
								if (resource != null) {
									if ((delta.getKind() & IResourceDelta.REMOVED) != 0) {
										removedResources.add(resource);
									} else {
										changedResources.add(resource);
									}
								}
							}
						}

						return true;
					}

					public Collection<Resource> getChangedResources() {
						return changedResources;
					}

					public Collection<Resource> getRemovedResources() {
						return removedResources;
					}
				}

				ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
				delta.accept(visitor);

				removedResources.addAll(visitor.getRemovedResources());
				if (!visitor.getRemovedResources().isEmpty() && !isDirty()) {
					getSite().getShell().getDisplay().asyncExec(new Runnable() {
						public void run() {
							MethodElementEditor.this.dispose();
						}
					});
				}

				changedResources.addAll(visitor.getChangedResources());
			} catch (CoreException e) {
				AuthoringUIPlugin.getDefault().getLogger().logError(e);
			}
		}
	};

	class ActivationListener implements IPartListener, IWindowListener {

		/** Cache of the active workbench part. */
		private IWorkbenchPart fActivePart;

		/** Indicates whether activation handling is currently be done. */
		private boolean fIsHandlingActivation = false;

		/**
		 * The part service.
		 * 
		 * @since 3.1
		 */
		private IPartService fPartService;

		/**
		 * Creates this activation listener.
		 * 
		 * @param partService
		 *            the part service on which to add the part listener
		 * @since 3.1
		 */
		public ActivationListener(IPartService partService) {
			fPartService = partService;
			fPartService.addPartListener(this);
			PlatformUI.getWorkbench().addWindowListener(this);
		}

		/**
		 * Disposes this activation listener.
		 * 
		 * @since 3.1
		 */
		public void dispose() {
			fPartService.removePartListener(this);
			PlatformUI.getWorkbench().removeWindowListener(this);
			fPartService = null;
		}

		/*
		 * @see IPartListener#partActivated(org.eclipse.ui.IWorkbenchPart)
		 */
		public void partActivated(IWorkbenchPart part) {
			fActivePart = part;
			handleActivation();
		}

		/*
		 * @see IPartListener#partBroughtToTop(org.eclipse.ui.IWorkbenchPart)
		 */
		public void partBroughtToTop(IWorkbenchPart part) {
		}

		/*
		 * @see IPartListener#partClosed(org.eclipse.ui.IWorkbenchPart)
		 */
		public void partClosed(IWorkbenchPart part) {
		}

		/*
		 * @see IPartListener#partDeactivated(org.eclipse.ui.IWorkbenchPart)
		 */
		public void partDeactivated(IWorkbenchPart part) {
			fActivePart = null;
		}

		/*
		 * @see IPartListener#partOpened(org.eclipse.ui.IWorkbenchPart)
		 */
		public void partOpened(IWorkbenchPart part) {
			if (part == MethodElementEditor.this) {
				if (!isInputValid()) {
					AuthoringUIPlugin
							.getDefault()
							.getMsgDialog()
							.displayInfo(
									AuthoringUIResources.editors_MethodElementEditor_invalidEditorTitle, 
									AuthoringUIResources.editors_MethodElementEditor_invalidEditorMsg); 
					MethodElementEditor.this.close(false);
					return;
				}
				Collection<Resource> usedResources = getUsedResources();
				if (ResourceUtil.hasOutOfSynch(usedResources)) {
					handleFileChanged(usedResources);
					return;
				}
				setResourceInfos(usedResources);
			}
		}

		/**
		 * Handles the activation triggering a element state check in the
		 * editor.
		 */
		private void handleActivation() {
			if (fIsHandlingActivation || MethodElementEditor.this.disposed)
				return;

			if (fActivePart == MethodElementEditor.this) {
				fIsHandlingActivation = true;
				try {
					handleActivate(fActivePart);
				} finally {
					fIsHandlingActivation = false;
				}
			}
		}

		/*
		 * @see org.eclipse.ui.IWindowListener#windowActivated(org.eclipse.ui.IWorkbenchWindow)
		 * @since 3.1
		 */
		public void windowActivated(IWorkbenchWindow window) {
			if (window == getEditorSite().getWorkbenchWindow()) {
				/*
				 * Workaround for problem described in
				 * http://dev.eclipse.org/bugs/show_bug.cgi?id=11731 Will be
				 * removed when SWT has solved the problem.
				 */
				window.getShell().getDisplay().asyncExec(new Runnable() {
					public void run() {
						handleActivation();
					}
				});
			}
		}

		/*
		 * @see org.eclipse.ui.IWindowListener#windowDeactivated(org.eclipse.ui.IWorkbenchWindow)
		 * @since 3.1
		 */
		public void windowDeactivated(IWorkbenchWindow window) {
		}

		/*
		 * @see org.eclipse.ui.IWindowListener#windowClosed(org.eclipse.ui.IWorkbenchWindow)
		 * @since 3.1
		 */
		public void windowClosed(IWorkbenchWindow window) {
		}

		/*
		 * @see org.eclipse.ui.IWindowListener#windowOpened(org.eclipse.ui.IWorkbenchWindow)
		 * @since 3.1
		 */
		public void windowOpened(IWorkbenchWindow window) {
		}
	}

	private ActivationListener activationListener;

	private boolean checkFileChangedRequired = false;

	protected HashSet<Resource> lastUsedResources;

	private boolean disposed;

	protected HashMap<Resource, ResourceInfo> resourceInfoMap;

	private IFile elementFile;
	
	/**
	 * Creates a new instance.
	 */
	public MethodElementEditor() {
		super();
		
		// moved the details out so that user can override the tick updator
		// Jinhua Xi 3/15/2007
		createEditorErrorTickUpdater();
		createActionManager();
	}
	
	protected void createEditorErrorTickUpdater() {
		
		this.fMethodElementEditorErrorTickUpdater = new MethodElementEditorErrorTickUpdater(this);
	}
	
	protected void createActionManager() {
		actionMgr = new ActionManager() {

			protected FullyRevertibleCommandStack createCommandStack() {
				return new FullyRevertibleCommandStack(this) {
					public boolean doExecute(Command command) {
						// Check modify first.
						if (command instanceof IResourceAwareCommand) {
							Collection modifiedResources = ((IResourceAwareCommand) command)
									.getModifiedResources();
							if (modifiedResources != null
									&& !(modifiedResources.isEmpty())) {
								IStatus status = UserInteractionHelper
										.checkModify(modifiedResources,
												getSite().getShell());
								if (!status.isOK()) {
									MethodElementEditor.this
											.handleError(status);
									return false;
								}
							}
						} else {
							EObject owner = TngUtil.getOwner(command);
							if (owner != null) {
								IStatus status = TngUtil.checkEdit(owner,
										getSite().getShell());
								if (!status.isOK()) {
									AuthoringUIPlugin
											.getDefault()
											.getMsgDialog()
											.display(
													AuthoringUIResources.errorDialog_title, 
													AuthoringUIResources.editDialog_msgCannotEdit, 
													status);
									return false;
								}
							}
						}

						if (changeTime == -1) {
							changeTime = System.currentTimeMillis();
						}
						boolean ret = super.doExecute(command);
						if (!ret && changeTime != -1) {
							changeTime = -1;
						}
						return ret;
					}

				};
			}

			public boolean doAction(int actionType, EObject object,
					org.eclipse.emf.ecore.EStructuralFeature feature,
					Object value, int index) {
				final IStatus status = TngUtil
						.checkEdit(object, getSite().getShell());
				if (status.isOK()) {
					return super.doAction(actionType, object, feature, value,
							index);
				} else {
					// this might be called from a non-UI thread
					// so make sure the message dialog will be shown in a UI thread
					//
					SafeUpdateController.syncExec(new Runnable() {

						public void run() {
							AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
									AuthoringUIResources.editDialog_title, 
									AuthoringUIResources.editDialog_msgCannotEdit, 
									status);
						}
						
					});
					return false;
				}
			}

			protected void save(Resource resource) {
				// don't save resource that is changed outside of this editor
				//
				if (changedResources.contains(resource)) {
					return;
				}
				
				boolean canSave;
				if(resource.getURI().isFile()) {
					File file = new File(resource.getURI().toFileString());
					canSave = file.lastModified() > changeTime;
				}
				else {
					canSave = true;
				}				
				try {
					if(canSave) {
						ILibraryPersister.FailSafeMethodLibraryPersister persister = getPersister();
						try {
							persister.save(resource);
							persister.commit();
						} catch (Exception e) {
							AuthoringUIPlugin.getDefault().getLogger()
							.logError(e);
							try {
								persister.rollback();
							} catch (Exception ex) {
								ViewHelper
								.reloadCurrentLibaryOnRollbackError(getEditorSite()
										.getShell());
							}
						}
					}
				} finally {
					changeTime = -1;
				}
			}
		};

		actionMgr.getCommandStack().addCommandStackListener(
				new CommandStackListener() {
					public void commandStackChanged(EventObject event) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								firePropertyChange(IEditorPart.PROP_DIRTY);
							}
						});
					}
				});

		ILibraryManager manager = (ILibraryManager) LibraryService
				.getInstance().getCurrentLibraryManager();
		if (manager != null) {
			manager.startListeningTo(actionMgr.getCommandStack());
		}
	}

	private void nameChanged() {
		SafeUpdateController.asyncExec(new Runnable() {

			public void run() {
				setPartName();
				if (pages != null) {
					for (Iterator iter = pages.iterator(); iter.hasNext();) {
						Object page = iter.next();

						if (page instanceof IRefreshable) {
							((IRefreshable) page).refreshName(elementObj
									.getName());
						}
					}
				}
			}
			
		});
	}
	
	public IActionManager getActionManager() {
		return actionMgr;
	}

	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#init(IEditorSite,
	 *      IEditorInput)
	 */
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		setSite(site);
		if (input instanceof FileEditorInput) {
			// probably opened from Problems View
			// create a MethodElementEditorInput
			elementFile = ((FileEditorInput)input).getFile();
			MethodElement element = PersistenceUtil.getMethodElement(
					elementFile,
					LibraryService.getInstance().getCurrentLibraryManager().
						getEditingDomain().getResourceSet());
			if (element != null) {
				input = new MethodElementEditorInput(
					element);
			}
		}
		setInput(input);
		site.setSelectionProvider(this);
		activationListener = new ActivationListener(site.getWorkbenchWindow()
				.getPartService());

		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				TngAdapterFactory.INSTANCE
						.getNavigatorView_ComposedAdapterFactory());
		Image titleImage = labelProvider.getImage(elementObj);
		labelProvider.dispose();
		setTitleImage(titleImage);
	}

	/**
	 * 
	 * @see org.eclipse.ui.part.EditorPart#setInput(org.eclipse.ui.IEditorInput)
	 */
	protected void setInput(IEditorInput input) {
		super.setInput(input);

		// Get method element object from Editor input.
		//
		MethodElementEditorInput methodElementInput = (MethodElementEditorInput) input;
		elementObj = methodElementInput.getMethodElement();

		setPartName();
		elementObj.eAdapters().add(nameChangedListener);
		
		if (fMethodElementEditorErrorTickUpdater != null)
			fMethodElementEditorErrorTickUpdater.updateEditorImage(elementObj);

	}

	public void updateResourceInfos(Collection<Resource> resources) {
		if(resourceInfoMap == null) {
			resourceInfoMap = new HashMap<Resource, ResourceInfo>();
		}
		for (Iterator iter = resources.iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			ResourceInfo info = resourceInfoMap.get(resource);
			if(info == null) {
				info = new ResourceInfo(resource);
				resourceInfoMap.put(resource, info);
			}
			else {
				info.refresh();
			}
		}
		checkFileChangedRequired = true;
	}
	
	public void ovewriteResources(Collection<Resource> resources) {
		for (Iterator iter = resources.iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			ResourceInfo info = resourceInfoMap.get(resource);
			if(info != null) {
				info.overwrite = true;
			}
		}		
	}
	
	public void setResourceInfos(Collection<Resource> resources) {
		if(resourceInfoMap != null && !resourceInfoMap.isEmpty()) {
			resourceInfoMap.clear();
		}
		updateResourceInfos(resources);
	}
	
	private long getLoadStamp(Resource resource) {
		ResourceInfo info = resourceInfoMap.get(resource);
		return info != null ? info.loadStamp : IResource.NULL_STAMP;
	}

	/**
	 * Checks if there is any resource in the given <code>usedResources</code>
	 * that has been reloaded since last update of load time stamps by this
	 * editor
	 * 
	 * @param usedResource
	 * @return
	 */
	private boolean checkReloaded(Collection usedResources) {
		ResourceSet resourceSet = getResourceSet(usedResources);
		boolean xmi = resourceSet instanceof ILibraryResourceSet 
			&& ((ILibraryResourceSet)resourceSet).getPersistenceType().equals(Services.XMI_PERSISTENCE_TYPE);
		for (Iterator iter = usedResources.iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			if(resource instanceof ILibraryResource) {
				long oldStamp = getLoadStamp(resource);
				long currentStamp = ((ILibraryResource)resource).getLoadStamp();
				if (oldStamp != currentStamp) {
					if(xmi) {
						IResource wsRes = FileManager.getResourceForLocation(resource
								.getURI().toFileString());
						if (wsRes != null) {
							return true;
						}
					}
					else {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static ResourceSet getResourceSet(Collection resources) {
		ResourceSet resourceSet = null;
		for (Iterator iter = resources.iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			resourceSet = resource.getResourceSet();
			if (resourceSet != null) {
				break;
			}
		}
		return resourceSet;
	}
	
	private Collection<Resource> getOutOfSyncResources(Collection<Resource> usedResources) {
		Collection<Resource> outOfSyncResources = new ArrayList<Resource>();
		for (Resource resource : usedResources) {
			if(isOutOfSync(resource)) {
				outOfSyncResources.add(resource);
			}
		}
		return outOfSyncResources;
	}

	
	private boolean isOutOfSync(Resource resource) {
		ResourceInfo info = resourceInfoMap.get(resource);
		long stamp = ISynchronizationHelper.INSTANCE.getModificationStamp(resource);
		if(stamp != IResource.NULL_STAMP) {
			if(info == null || info.modificationStamp != stamp) {
				if(ISynchronizationHelper.INSTANCE.isSynchronized(resource)) {
					// refresh the cached stamp
					//
					if(info == null) {
						resourceInfoMap.put(resource, new ResourceInfo(resource));
					}
					else {
						info.modificationStamp = ISynchronizationHelper.INSTANCE.getModificationStamp(resource); 
					}						
					return false;
				}
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return !ISynchronizationHelper.INSTANCE.isSynchronized(resource);
		}
	}

	private boolean checkFileChanged(Collection usedResources) {
		// check resource set type and continue to check for changed file if the
		// type is XMI
		//
		ResourceSet resourceSet = getResourceSet(usedResources);
		if (resourceSet instanceof ILibraryResourceSet
				&& ((ILibraryResourceSet) resourceSet).getPersistenceType().equals(Services.XMI_PERSISTENCE_TYPE)) {
			for (Iterator iter = usedResources.iterator(); iter.hasNext();) {
				Resource resource = (Resource) iter.next();
				if(isOutOfSync(resource)) {
					return true;
				}
			}
		}
		return false;
	}

	protected boolean promptReloadFiles() {
		String title = AuthoringUIResources.editor_error_activated_outofsync_title;
		String msg = AuthoringUIResources.editor_error_activated_outofsync_message;
		return AuthoringUIPlugin.getDefault().getMsgDialog().displayPrompt(
				title, msg);
	}
	
	private boolean handleFileChanged(final Collection<Resource> usedResources) {
		boolean ret = promptReloadFiles();
		if (ret) {
			IRunnableWithProgress runnable = new IRunnableWithProgress() {

				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					monitor.beginTask("", 10); //$NON-NLS-1$
					monitor.subTask(AuthoringUIResources.refresh_text); 
					monitor.worked(1);
					try {

						Collection<Resource> removedResources = new ArrayList<Resource>();
						for (Resource resource : usedResources) {
							if (!new File(resource.getURI().toFileString())
									.exists()) {
								removedResources.add(resource);
							}
						}
						Collection<Resource> changedResources = resourceInfoMap != null ? 
								getOutOfSyncResources(usedResources) :
								ResourceUtil.getOutOfSyncResources(usedResources);
						monitor.worked(2);

						// unload the removed resources
						//
						PersistenceUtil.unload(removedResources);
						monitor.worked(2);

						// Reload the changed resources.
						ILibraryManager manager = (ILibraryManager) LibraryService
								.getInstance().getCurrentLibraryManager();
						if (manager != null) {
							Collection<Resource> reloadedResources = manager
									.reloadResources(changedResources);
							if (!reloadedResources.isEmpty()) {
								RefreshJob.getInstance()
										.getReloadedBeforeRefreshResources()
										.addAll(reloadedResources);
							}

							if (!removedResources.isEmpty()
									|| !reloadedResources.isEmpty()) {
								// save changed resources before refresh so
								// action
								// manager will not try to save these changed
								// resources
								//
								MethodElementEditor.this.changedResources
										.addAll(reloadedResources);
								MethodElementEditor.this.lastUsedResources
										.removeAll(removedResources);
								refresh(true);
								MethodElementEditor.this.changedResources
										.clear();
							}
						}
						monitor.worked(4);

						// refresh out-of-synch resources
						//
						for (Resource resource : changedResources) {
							FileManager.getInstance().refresh(resource);
						}
						monitor.worked(1);
					} finally {
						monitor.done();
					}
				}

			};

			try {
				getSite()
						.getWorkbenchWindow()
						.getWorkbench()
						.getProgressService()
						.runInUI(
								new ProgressMonitorDialog(getSite().getShell()),
								runnable, new LibrarySchedulingRule(LibraryService.getInstance().getCurrentMethodLibrary()));
			} catch (Exception e) {
				AuthoringUIPlugin.getDefault().getLogger().logError(e);
				String title = AuthoringUIResources.ProcessEditor_refreshErrorTitle; 
				AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
						title, e.toString(), e);
			}
		} else {
			checkFileChangedRequired = false;
		}
		return ret;
	}

	public void setPartName() {
		String partName = elementObj.getName();
		if (partName == null) {
			partName = ""; //$NON-NLS-1$
		}
		setPartName(partName);
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		selectionChangedListeners.add(listener);
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.ISelectionChangedListener)
	 */
	public void removeSelectionChangedListener(
			ISelectionChangedListener listener) {
		selectionChangedListeners.remove(listener);
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
	 */
	public ISelection getSelection() {
		return currentSelection;
	}

	/**
	 * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
	 */
	public void setSelection(ISelection selection) {
		currentSelection = selection;

		for (Iterator listeners = new ArrayList<ISelectionChangedListener>(selectionChangedListeners)
				.iterator(); listeners.hasNext();) {
			ISelectionChangedListener listener = (ISelectionChangedListener) listeners
					.next();
			listener
					.selectionChanged(new SelectionChangedEvent(this, selection));
		}
	}

	/**
	 * @see org.eclipse.ui.forms.editor.FormEditor#addPages()
	 */
	protected void addPages() {
		try {
			if (elementObj instanceof MethodLibrary) {
				addPage(new MethodLibraryDescriptionFormPage(this));
			} else if (elementObj instanceof MethodPlugin) {
				addPage(new MethodPluginDescriptionPage(this));
			} else if (elementObj instanceof ContentPackage) {
				addPage(new ContentPackageDescriptionPage(this));
			} else if (elementObj instanceof Role) {
				addPage(new RoleDescriptionPage(this));
				addPage(new RoleWorkProductsPage(this));
				addPage(new ContentElementGuidancePage(this));
				addPage(new RoleCategoriesPage(this));
			} else if (elementObj instanceof Task) {
				addPage(new TaskDescriptionPage(this));
				addPage(new TaskStepsPage(this));
				addPage(new TaskRolesPage(this));
				addPage(new TaskWorkProductsPage(this));
				addPage(new ContentElementGuidancePage(this));
				addPage(new TaskCategoriesPage(this));
			} else if (elementObj instanceof WorkProduct) {
				addPage(new WorkProductDescriptionPage(this));
				if (elementObj instanceof Deliverable) {
					addPage(new WorkProductDeliverablePartsPage(this));
				}
				addPage(new ContentElementGuidancePage(this));
				addPage(new WorkProductCategoriesPage(this));
			} else if (elementObj instanceof Guidance) {
				if (TngUtil.isAllowedAttachments(elementObj)) {
					addPage(new GuidanceWithAttachmentsDescriptionPage(this));
				} else if (elementObj instanceof Practice) {
					addPage(new PracticeDescriptionPage(this));
					addPage(new PracticeReferencesPage(this));
				} else if (elementObj instanceof Checklist) {
					addPage(new GuidanceDescriptionPage(this));
					addPage(new ChecklistItemsPage(this));
				} else {
					addPage(new GuidanceDescriptionPage(this));
				}
				if (!(elementObj instanceof Practice))
					addPage(new ContentElementGuidancePage(this));
			} else if (elementObj instanceof Discipline) {
				addPage(new DisciplineDescriptionPage(this));
				addPage(new DisciplineTasksPage(this));
				addPage(new DisciplineReferenceWorkflowPage(this));
				addPage(new ContentElementGuidancePage(this));
			} else if (elementObj instanceof DisciplineGrouping) {
				addPage(new DisciplineGroupingDescriptionPage(this));
				addPage(new DisciplineGroupingDisciplinesPage(this));
			} else if (elementObj instanceof Domain) {
				addPage(new DomainDescriptionPage(this));
				addPage(new DomainWorkProductsPage(this));
				addPage(new ContentElementGuidancePage(this));
			} else if (elementObj instanceof WorkProductType) {
				addPage(new WorkProductTypeDescriptionPage(this));
				addPage(new WorkProductTypeWorkProductsPage(this));
				addPage(new ContentElementGuidancePage(this));
			} else if (elementObj instanceof RoleSet) {
				addPage(new RoleSetDescriptionPage(this));
				addPage(new RoleSetRolesPage(this));
				addPage(new ContentElementGuidancePage(this));
			} else if (elementObj instanceof RoleSetGrouping) {
				addPage(new RoleSetGroupingDescriptionPage(this));
				addPage(new RoleSetGroupingRoleSets(this));
			} else if (elementObj instanceof Tool) {
				addPage(new ToolDescriptionPage(this));
				addPage(new ToolToolMentorsPage(this));
				addPage(new ContentElementGuidancePage(this));
			} else if (elementObj instanceof CustomCategory) {
				addPage(new CustomCategoryDescriptionPage(this));
				addPage(new CustomCategoryAssignPage(this));
			}

			setPartName(elementObj.getName());

			if (!(elementObj instanceof ContentPackage || elementObj instanceof MethodPlugin))
				createPreviewPage();

			if (elementObj instanceof Task) {
				// check for extenstion point and add the page if there
				List<?> pageProviders = MethodEditorPageProvider.getInstance()
						.getPageProviders();

				if (pageProviders != null && pageProviders.size() > 0) {
					try {
						for (int i = 0; i < pageProviders.size(); i++) {
							Object page = pageProviders.get(i);
							if (page instanceof IExtensionFormPage) {
								IExtensionFormPage formPage = (IExtensionFormPage) page;
								formPage.setEditor(this);
							}
						}
					} catch (Exception e) {
						AuthoringUIPlugin.getDefault().getLogger().logError(e);
					}
				}
			}
		} catch (Throwable t) {
			AuthoringUIPlugin.getDefault().getLogger().logError(t);
			dispose();
			if(t instanceof RuntimeException) {
				throw (RuntimeException)t;
			}
			if(t instanceof Error) {
				throw (Error) t;
			}
		}
	}

	/**
	 * @see org.eclipse.epf.authoring.ui.editors.AbstractBaseFormEditor#dispose()
	 */
	public void dispose() {
		try {
			// ResourcesPlugin.getWorkspace().removeResourceChangeListener(
			// resourceChangeListener);

			if (activationListener != null) {
				activationListener.dispose();
			}

			modifiedRichText = null;

			disposeEditorErrorTickUpdater();
			
			ILibraryManager manager = (ILibraryManager) LibraryService
					.getInstance().getCurrentLibraryManager();
			if (manager != null) {
				manager.stopListeningTo(actionMgr.getCommandStack());
			}

			if (isDirty()) {
				actionMgr.undoAll();
			}
			actionMgr.dispose();
			elementObj.eAdapters().remove(nameChangedListener);
			
			if(resourceInfoMap != null) {
				resourceInfoMap.clear();
				resourceInfoMap = null;				
			}
			
			if(changedResources != null) {
				changedResources.clear();
				changedResources = null;
			}
			
			if(selectionChangedListeners != null) {
				selectionChangedListeners.clear();
				selectionChangedListeners = null;
			}
			
			if(PerspectiveUtil.isActivePerspective(AuthoringPerspective.PERSPECTIVE_ID)) {
				// unload all resources of content description that are not used by 
			}
			
			if(lastUsedResources != null) {
				lastUsedResources.clear();
				lastUsedResources = null;
			}						 
		} finally {
			super.dispose();
			disposed = true;
		}
	}

	protected void disposeEditorErrorTickUpdater()
	{
		if ( fMethodElementEditorErrorTickUpdater != null ) {
			fMethodElementEditorErrorTickUpdater.dispose();
			fMethodElementEditorErrorTickUpdater = null;
		}
	}

	
	/**
	 * @see org.eclipse.epf.authoring.ui.editors.AbstractBaseFormEditor#isDirty()
	 */
	public boolean isDirty() {
		if (dirty)
			return true;
		dirty = actionMgr.isSaveNeeded();
		return dirty;
	}

	public FailSafeMethodLibraryPersister getPersister() {
		if (persister == null) {
			persister = LibraryServiceUtil.getCurrentPersister().getFailSafePersister();
		}
		return persister;
	}

	protected Collection<Resource> getModifiedResources() {
		return actionMgr.getModifiedResources();
	}

	/**
	 * Set modified rich text field
	 * @param modifiedRichText
	 */
	public void setModifiedRichText(IMethodRichText modifiedRichText) {
		this.modifiedRichText = modifiedRichText;
	}

	/**
	 * Save modified rich text 
	 * @param richText
	 */
	public void saveModifiedRichText(IMethodRichText richText) {
		if (richText != null && !richText.isDisposed()
				&& richText.getModified()) {
			EObject modalObject = richText.getModalObject();
			EStructuralFeature modalObjectFeature = richText
					.getModalObjectFeature();
			if (modalObject != null && modalObjectFeature != null) {
				Object oldContent = modalObject.eGet(modalObjectFeature);
				if (!mustRestoreValue(richText, oldContent)) {
					Object newContent = richText.getText();
					richText.setInitialText((String)newContent);
					if (!newContent.equals(oldContent)) {
						actionMgr.doAction(IActionManager.SET, modalObject,
								modalObjectFeature, newContent, -1);
					}
				}
			}
		}
	}

	/**
	 * Save last modified rich text 
	 */
	public void saveModifiedRichText() {
		saveModifiedRichText(modifiedRichText);
	}
	
	protected LibraryValidateAction createValidateResourceAction() {
		return new LibraryValidateAction(false) {
			/* (non-Javadoc)
			 * @see org.eclipse.epf.authoring.ui.actions.LibraryValidateAction#refreshViews()
			 */
			protected void refreshViews() {
				LibraryView.getView().refreshViews();
			}
		};
	}
	
	public boolean validateResources(Collection modifiedResources) {
		ArrayList<EObject> elements = new ArrayList<EObject>();
		for (Iterator iter = modifiedResources.iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			if (resource instanceof MultiFileXMIResourceImpl) {
				elements.addAll(resource.getContents());
			}
		}
		LibraryValidateAction validateAction = createValidateResourceAction();
		validateAction.updateSelection(new StructuredSelection(elements));
		validateAction.run();
		return validateAction.isSuccessful();
	}

	/**
	 * @see org.eclipse.epf.authoring.ui.editors.AbstractBaseFormEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void doSave(IProgressMonitor monitor) {
		if (DEBUG) {
			System.out
					.println("MethodElementEditor.doSave: saving changes to method library"); //$NON-NLS-1$
		}

		saveModifiedRichText(modifiedRichText);

		getPersister();
		try {
			// check for modifiable
			//
			Collection<Resource> modifiedResources = getModifiedResources();
			
			ArrayList<Resource> resourcesToSave = new ArrayList<Resource>(modifiedResources);

			// update version info in library resource if needed by adding
			// library resource to collection
			// of modified resources
			//
			HashSet<Resource> resourcesToUpdateVersionInfo = new HashSet<Resource>();
			if (!modifiedResources.isEmpty()) {
				for (Iterator iter = modifiedResources.iterator(); iter
						.hasNext();) {
					Resource resource = (Resource) iter.next();
					MethodElement me = PersistenceUtil
							.getMethodElement(resource);
					if (me != null) {
						MethodLibrary lib = UmaUtil.getMethodLibrary(me);
						if (lib != null) {
							Resource libResource = lib.eResource();
							if (libResource != null
									&& !modifiedResources.contains(libResource)
									&& !resourcesToUpdateVersionInfo
											.contains(libResource)
									&& PersistenceUtil
											.checkToolVersion(libResource) != 0) {
								resourcesToUpdateVersionInfo.add(libResource);
							}
						}
					}
				}
				resourcesToSave.addAll(resourcesToUpdateVersionInfo);
			}

			IStatus status = UserInteractionHelper.checkModify(
					resourcesToSave, getSite().getShell());
			if (!status.isOK()) {
				handleError(status);
				return;
			}

			// check for out-of-synch
			//
			if (checkFileChanged(resourcesToSave)) {
				String title = LibraryEditResources.update_outofsynch_title;
				String msg = LibraryEditResources.update_outofsynch_msg;
				if (!AuthoringUIPlugin.getDefault().getMsgDialog()
						.displayPrompt(title, msg)) {
					return;
				}
			}

			// flag the resources to update version info as modified so they
			// will be saved
			//
			if (!resourcesToUpdateVersionInfo.isEmpty()) {
				for (Iterator iter = resourcesToUpdateVersionInfo.iterator(); iter
						.hasNext();) {
					Resource resource = (Resource) iter.next();
					resource.setModified(true);
				}
			}
			
			if(isValidateResourcesBeforeSaveRequired()) {
				// validate
				//
				if(!validateResources(modifiedResources)) {
					return;
				}
			}
			else {
				// no validation before save
				// remove all validation errors markers associated with current method element
				//
				if(LibraryValidationMarkerHelper.INSTANCE.hasMarkers(elementObj)) {
					LibraryValidationMarkerHelper.INSTANCE.deleteMarkers(elementObj);
					
					// refresh library view
					//
					LibraryView view = LibraryView.getView();
					if(view != null) {
						MethodElementLabelDecorator.clearDecorationCache();
						view.getViewer().refresh();
					}
				}
			}

			
			// Save.
			//
			Object oldValue = persister.getSaveOptions().get(
					ILibraryPersister.FailSafeMethodLibraryPersister.OPTIONS_OVERWRITABLE_RESOURCES); 

			Collection<Resource> resourcesToAdjustLocation = null;
			
			try {
				persister.getSaveOptions().put(
						ILibraryPersister.FailSafeMethodLibraryPersister.OPTIONS_OVERWRITABLE_RESOURCES, 
						getOverwritableResources());
			
				for (Iterator iter = resourcesToSave.iterator(); iter.hasNext();) {
					Resource resource = (Resource) iter.next();
					try {
						persister.save(resource);
					} catch (Exception e) {
						String title = AuthoringUIResources.editors_MethodElementEditor_saveErrorTitle; 
						String msg = AuthoringUIResources.editors_MethodElementEditor_saveErrorMessage1; 
						String reason = e.getMessage() == null ? AuthoringUIResources.editors_MethodElementEditor_saveErrorReason1
								: e.getMessage(); 
						AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
								title, msg, reason, e);
						throw e;
					}
				}

				try {
					persister.commit();
					dirty = false;
					actionMgr.saveIsDone();
					changeTime = -1;
					resourcesToAdjustLocation = getResourceToAdjustLocation();	
					setResourceInfos(getUsedResources());
				} catch (Exception e) {
					String reason = e.getMessage();
					if (StrUtil.isBlank(reason)) {
						reason = AuthoringUIResources.editors_MethodElementEditor_saveErrorReason2; 
					}
					StringWriter details = new StringWriter();
					e.printStackTrace(new PrintWriter(details));
					String title = AuthoringUIResources.editors_MethodElementEditor_saveErrorTitle; 
					String message = AuthoringUIResources.editors_MethodElementEditor_saveErrorMessage2; 
					AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
							title, message, reason, details.toString(), e);
					throw e;
				}
			}
			finally {
				persister.getSaveOptions().put(
						ILibraryPersister.FailSafeMethodLibraryPersister.OPTIONS_OVERWRITABLE_RESOURCES,
						oldValue);
			}

			// Rename
			//
			//Collection<Resource> resourcesToAdjustLocation = getResourceToAdjustLocation();						
			if (resourcesToAdjustLocation != null && !resourcesToAdjustLocation.isEmpty()) {
				try {
					persister.adjustLocation(resourcesToAdjustLocation);
				} catch (Exception e) {
					String title = AuthoringUIResources.editors_MethodElementEditor_renameErrorTitle; 
					String template = AuthoringUIResources.editors_MethodElementEditor_renameErrorMessage1; 
					StringBuffer fileList = new StringBuffer();
					for (Iterator iter = resourcesToAdjustLocation.iterator(); iter
							.hasNext();) {
						Resource resource = (Resource) iter.next();
						Object obj = FileManager.toFileString(resource.getURI());
						if(obj == null) {
							obj = resource;
						}
						fileList.append(obj).append(", "); //$NON-NLS-1$
					}
					String msg = MessageFormat.format(template,
							new Object[] { fileList });
					String reason = e.getMessage() == null ? AuthoringUIResources.editors_MethodElementEditor_saveErrorReason1
							: e.getMessage(); 
					AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
							title, msg, reason, e);
					throw e;
				}

				try {
					persister.commit();
				} catch (Exception e) {
					String reason = e.getMessage();
					if (StrUtil.isBlank(reason)) {
						reason = AuthoringUIResources.editors_MethodElementEditor_saveErrorReason2; 
					}
					StringWriter details = new StringWriter();
					e.printStackTrace(new PrintWriter(details));
					String title = AuthoringUIResources.editors_MethodElementEditor_renameErrorTitle; 
					String message = AuthoringUIResources.editors_MethodElementEditor_saveErrorMessage2; 
					AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
							title, message, reason, details.toString(), e);
					throw e;
				}

				resourcesToAdjustLocation.clear();
			}
		} catch (Exception e) {
			AuthoringUIPlugin.getDefault().getLogger().logError(e);
			try {
				persister.rollback();
			} catch (Exception ex) {
				AuthoringUIPlugin.getDefault().getLogger().logError(ex);
				ViewHelper.reloadCurrentLibaryOnRollbackError(getSite()
						.getShell());
			}
		}
	}

	private Collection<Resource> getOverwritableResources() {
		if(resourceInfoMap == null) {
			return Collections.EMPTY_LIST;
		}
		ArrayList<Resource> resources = new ArrayList<Resource>();
		for (Iterator iter = resourceInfoMap.values().iterator(); iter.hasNext();) {
			ResourceInfo info = (ResourceInfo) iter.next();
			if(info.overwrite) {
				resources.add(info.resource);
			}
		}
		return resources;
	}

	private Collection<Resource> getResourceToAdjustLocation() {
		if(resourceInfoMap == null) {
			return Collections.EMPTY_LIST;
		}
		ArrayList<Resource> resources = new ArrayList<Resource>();
		for (Iterator iter = resourceInfoMap.values().iterator(); iter.hasNext();) {
			ResourceInfo info = (ResourceInfo) iter.next();
			if(info.adjustLocation) {
				resources.add(info.resource);
			}
		}
		return resources;
	}

	/**
	 * @return
	 */
	protected boolean isValidateResourcesBeforeSaveRequired() {
		return false;
	}

	protected void saveResource(Resource resource) {
		if (resource != null && resource.isModified()) {
			try {
				getPersister().save(resource);
			} catch (Exception e) {
				String title = AuthoringUIResources.editors_MethodElementEditor_saveErrorTitle; 
				String template = AuthoringUIResources.editors_MethodElementEditor_saveErrorMessage1; 
				String msg = MessageFormat.format(template,
						new Object[] { resource.getURI().toFileString() });
				String reason = e.getMessage() == null ? AuthoringUIResources.editors_MethodElementEditor_saveErrorReason1
						: e.getMessage(); 
				AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
						title, msg, reason, e);
			}
		}
	}

	protected void createPreviewPage() {
		Composite parent = getContainer();
		Composite previewComposite = new Composite(parent, SWT.NONE);
		previewComposite.setLayout(new GridLayout());

		PreviewPage page = new PreviewPage(previewComposite);
		previewer = page.getPreviewViewer();

		preview_page_index = addPage(previewComposite);
		setPageText(preview_page_index, AuthoringUIResources.previewPage_title); 
	}

	/**
	 * Override this method to listen to the tab change.
	 */
	protected void pageChange(int newPageIndex) {
		super.pageChange(newPageIndex);

		if (preview_page_index == newPageIndex && previewer != null) {
			// Use the default layout manager.
			//previewer.setLayoutManager(null);
			previewer.showElementContent(elementObj);
		}
	}

	private void setDirty() {
		dirty = true;
		firePropertyChange(PROP_DIRTY);
	}

	/**
	 * Restore value of the control
	 * @param control
	 * @param value
	 * @return
	 * 		boolean value to indicate whether control was restored or not
	 */
	public boolean mustRestoreValue(Object control, Object value) {
		if (widgetToCheck == control) {
			// the control is currently being checked for editable, but there is
			// still focus lost
			// event is being sent out even the check is not completed yet.
			// return true so the focusLost() will not make any change to the
			// control.
			//
			return true;
		}

		Object editControl = control;
		if (editControl instanceof MethodRichTextEditor) {
			editControl = ((MethodRichTextEditor) control).getRichTextControl();
		}
		boolean restore = widgetsToRestoreValue.contains(editControl);
		if (!restore) {
			synchronized (widgetsToRestoreValue) {
				restore = widgetsToRestoreValue.contains(editControl);
			}
		}
		if (restore) {
			if (editControl instanceof Text) {
				Text text = ((Text) editControl);
				text.setText((String) value);
			} else if (editControl instanceof IMethodRichText) {
				IMethodRichText richText = (IMethodRichText) editControl;
				richText.setText((String) value);
			}
			widgetsToRestoreValue.remove(editControl);
		}
		return restore;
	}

	/**
	 * Modify Listener 
	 *
	 */
	public class ModifyListener implements
			org.eclipse.swt.events.ModifyListener {

		private EObject element;

		private boolean checkContainerResource;

		private boolean disabled = false;

		/**
		 * Creates a new instance.
		 */
		public ModifyListener(EObject element, boolean checkContainer) {
			super();
			checkContainerResource = checkContainer;
			this.element = element;
		}

		private void restoreText(Object control, String txt) {
			boolean old = disabled;
			try {
				disabled = true;
				Object editControl = control;
				if (editControl instanceof MethodRichTextEditor) {
					editControl = ((MethodRichTextEditor) control)
							.getRichTextControl();
				}
				if (editControl instanceof Text) {
					Text text = ((Text) editControl);
					text.setText(txt);
				} else if (editControl instanceof IMethodRichText) {
					IMethodRichText richText = (IMethodRichText) editControl;
					richText.setText(txt);
				}
			} finally {
				disabled = old;
			}
		}

		private boolean checkEdit(EObject element, Object control,
				boolean checkContainerResource) {
			// keep a reference to the current widget so mustRestoreValue() can
			// use it to check
			// whether a focus lost event is triggered during a checkEdit.
			// mustRestoreValue() then
			// returns true so focusLost() will not try to make change to the
			// value bound to the widget
			//
			widgetToCheck = control;
			try {
				if (DEBUG) {
					System.out
							.println("MethodElementEditor.checkEdit: enter, control=" + control); //$NON-NLS-1$
				}
				IStatus status = null;
				if (widgetsToRestoreValue.contains(control)) {
					if (DEBUG) {
						System.out
								.println("MethodElementEditor.checkEdit: widget found in widgetsToRestoreValue, exit"); //$NON-NLS-1$
					}
					return false;
				}

				synchronized (widgetsToRestoreValue) {
					if (widgetsToRestoreValue.contains(control)) {
						if (DEBUG) {
							System.out
									.println("MethodElementEditor.checkEdit: widget found in widgetsToRestoreValue, exit"); //$NON-NLS-1$
						}
						return false;
					}

					status = TngUtil.checkEdit(element, getSite().getShell());

					if (!status.isOK()) {
						if (control instanceof IRichText) {
							((IRichText) control).restoreText();
						} else {
							if (control == currentFeatureEditor) {
								restoreText(control, (String) element
										.eGet(currentEditedFeature));
							} else {
								// Add the control to the list of widgets whose
								// value needs
								// to be restored to the original one..
								widgetsToRestoreValue.add(control);
								if (DEBUG) {
									System.out
											.println("MethodElementEditor.checkEdit: added widget to widgetsToRestoreValue"); //$NON-NLS-1$
								}
							}
						}
					} else if (checkContainerResource) {
						if (element.eContainer() != null
								&& element.eContainer().eResource() != element
										.eResource()) {
							status = TngUtil.checkEdit(element.eContainer(),
									getSite().getShell());
							if (!status.isOK()) {
								// // Add the control to the list of widgets
								// whose value
								// // needs to be restored to the original one.
								// if (debug) {
								// System.out
								// .println("MethodElementEditor.checkEdit:
								// added widget to widgetsToRestoreValue");
								// //$NON-NLS-1$
								// }
								if (control instanceof IRichText) {
									((IRichText) control).restoreText();
								} else {
									if (control == currentFeatureEditor) {
										restoreText(control, (String) element
												.eGet(currentEditedFeature));
									} else {
										widgetsToRestoreValue.add(control);
									}
								}
							}
						}
					}
				}

				if (status != null && !status.isOK()) {
					AuthoringUIPlugin.getDefault().getMsgDialog().displayError(
							AuthoringUIResources.editDialog_title, 
							AuthoringUIResources.editDialog_msgCannotEdit, 
							status);
					return false;
				}

				return true;
			} finally {
				// clear the reference when the check is done
				//
				widgetToCheck = null;
			}
		}

		/**
		 * @see org.eclipse.swt.events.ModifyListener#modifyText(ModifyEvent)
		 */
		public void modifyText(ModifyEvent e) {
			if (DEBUG) {
				System.out
						.println("MethodElementEditor.ModifyListener.modifyText: enter, disabled=" + disabled); //$NON-NLS-1$
			}
			if (!disabled && element != null) {
				if (e.widget == null) {
					return;
				}

				Object widget = e.widget;
				if (widget instanceof Browser) {
					widget = ((Browser) widget)
							.getData(IMethodRichText.PROPERTY_NAME);
					if (widget == null) {
						widget = e.widget;
					}
				}
				if (DEBUG) {
					System.out
							.println("MethodElementEditor.ModifyListener.modifyText: widget=" + widget); //$NON-NLS-1$
				}

				if (widgetsToRestoreValue.contains(widget)) {
					if (DEBUG) {
						System.out
								.println("MethodElementEditor.ModifyListener.modifyText: widget found in widgetsToRestoreValue, exit"); //$NON-NLS-1$
					}
					return;
				}

				if (!checkEdit(element, widget, checkContainerResource)) {
					if (DEBUG) {
						System.out
								.println("MethodElementEditor.ModifyListener.modifyText: checkEdit failed, exit"); //$NON-NLS-1$
					}
					return;
				}

				if (widget instanceof IMethodRichText) {
					IMethodRichText richText = (IMethodRichText) widget;
					setModifiedRichText(richText);
					if (DEBUG) {
						System.out
								.println("MethodElementEditor.ModifyListener.modifyText: adding to modifiedRichTexts list"); //$NON-NLS-1$
					}
				}

				if (DEBUG) {
					System.out
							.println("MethodElementEditor.ModifyListener.modifyText: marking editor as dirty"); //$NON-NLS-1$
				}
				setDirty();
			}

			if (DEBUG) {
				System.out
						.println("MethodElementEditor.ModifyListener.modifyText: exit"); //$NON-NLS-1$
			}
		}

		/**
		 * Sets the underlying model element.
		 * 
		 * @param element
		 *            A method element.
		 */
		public void setElement(EObject element) {
			this.element = element;
		}

		/**
		 * Sets the disable flag.
		 * 
		 * @param disabled
		 *            If <code>true</code>, ignore the modify events.
		 */
		public void setDisable(boolean disabled) {
			this.disabled = disabled;
		}
	}

	/**
	 * Creates an new instance of ModifyListener that supports team and CM
	 * integration Any control in the editor, if it needs a ModifyListener, must
	 * use one created by this method
	 * 
	 * @param eObj
	 * 
	 * @return
	 */
	public ModifyListener createModifyListener(EObject eObj) {
		return createModifyListener(eObj, false);
	}

	/**
	 * Creates an new instance of ModifyListener that supports team and CM
	 * integration Any control in the editor, if it needs a ModifyListener, must
	 * use one created by this method
	 * 
	 * @param eObj
	 * @param checkContainer
	 *            if true will check the container of the given object for
	 *            editable as well when checking the given object for editable
	 * 
	 * @return
	 * 		Modify Listener
	 */
	public ModifyListener createModifyListener(EObject eObj,
			boolean checkContainer) {
		return new ModifyListener(eObj, checkContainer);
	}

	/**
	 * Sets the specified control to be the current editor of the specified
	 * feature.
	 * 
	 * @param control
	 * @param feature
	 */
	public void setCurrentFeatureEditor(Object control,
			EStructuralFeature feature) {
		currentFeatureEditor = control;
		currentEditedFeature = feature;
	}

	protected void monitorChange() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint point = registry
				.getExtensionPoint("org.eclipse.core.resources.refreshProviders"); //$NON-NLS-1$
		if (point == null)
			return;
		IExtension[] extensions = point.getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IExtension extension = extensions[i];
			if (DEBUG) {
				System.out
						.println("extension: UID=" + extension.getUniqueIdentifier() + ", " + extension); //$NON-NLS-1$ //$NON-NLS-2$
			}
		}
	}
	
	private Map<Resource, ResourceInfo> getResourceInfoMap() {
		if(resourceInfoMap == null) {
			resourceInfoMap = new HashMap<Resource, ResourceInfo>();
		}
		return resourceInfoMap;
	}

	/**
	 * Add resource to adjust location
	 * @param resource
	 */
	public void addResourceToAdjustLocation(Resource resource) {
		ResourceInfo info = getResourceInfoMap().get(resource);
		if(info == null) {
			info = new ResourceInfo(resource);
			getResourceInfoMap().put(resource, info);
		}
		info.adjustLocation = true;
	}

	protected List getUsedFeatures() {
		return elementObj.eClass().getEAllStructuralFeatures();
	}

	/**
	 * Gets resources that are currently being used by this editors
	 * 
	 * @return
	 * 		list of used resources
	 */
	public Collection<Resource> getUsedResources() {
		HashSet<Resource> resources = new HashSet<Resource>();
		Resource resource = elementObj.eResource();
		if (resource != null) {
			resources.add(resource);
		}
		List allFeatures = getUsedFeatures();
		for (int i = allFeatures.size() - 1; i > -1; i--) {
			EStructuralFeature feature = (EStructuralFeature) allFeatures
					.get(i);
			if (feature.isMany()) {
				List values = (List) elementObj.eGet(feature);
				for (int j = values.size() - 1; j > -1; j--) {
					EObject value = (EObject) values.get(j);
					if (value.eResource() != null) {
						resources.add(value.eResource());
					}
				}
			} else {
				Object value = elementObj.eGet(feature);
				if (value instanceof EObject
						&& (resource = ((EObject) value).eResource()) != null) {
					resources.add(resource);
				}
			}
		}
		lastUsedResources = resources;
		return resources;
	}

	private Map getURIToUsedResourceMap() {
		HashMap<URI, Resource> map = new HashMap<URI, Resource>();
		for (Iterator iter = getUsedResources().iterator(); iter.hasNext();) {
			Resource resource = (Resource) iter.next();
			map.put(resource.getURI(), resource);
		}
		return map;
	}

	protected void handleError(IStatus status) {
		AuthoringUIPlugin.getDefault().getMsgDialog().display(
				AuthoringUIResources.errorDialog_title, 
				AuthoringUIResources.editDialog_msgCannotEdit, 
				status);
	}

	/**
	 * Handles the activation of this view.
	 */
	protected void handleActivate(IWorkbenchPart part) {
		// TODO: Review implementation.
		// Make sure that the method library open is not closed.
		XMILibraryUtil.openMethodLibraryProject(LibraryService.getInstance()
				.getCurrentMethodLibrary(), getEditorSite().getActionBars()
				.getStatusLineManager().getProgressMonitor());

		if (checkFileChangedRequired) {
			Collection<Resource> usedResources = getUsedResources();
			if (checkFileChanged(usedResources)) {
				handleFileChanged(usedResources);
			}
		}
	}

	/**
	 * Displays a dialog that asks if conflicting changes should be discarded.
	 */
	protected boolean handleDirtyConflict() {
		String title = AuthoringUIResources._UI_FileConflict_label;
		String msg = AuthoringUIResources._WARN_FileConflict;
		return AuthoringUIPlugin.getDefault().getMsgDialog().displayPrompt(
				title, msg);
	}

	/**
	 * Handles changed resources when this view is activated.
	 */
	protected void handleChangedResources() {
		if ((elementObj.eIsProxy() || !changedResources.isEmpty())
				&& (!isDirty() || handleDirtyConflict())) {
			// editingDomain.getCommandStack().flush();

			// for (Iterator i = changedResources.iterator(); i.hasNext();) {
			// Resource resource = (Resource) i.next();
			// if (resource.isLoaded()) {
			// if(resource instanceof MultiFileXMIResourceImpl) {
			// try {
			// ((MultiFileXMIResourceImpl)resource).reload(null);
			// } catch (IOException e) {
			// AuthoringUIPlugin.getDefault().getLogger().logError(e);
			// }
			// }
			// else {
			// resource.unload();
			// try {
			// resource.load(Collections.EMPTY_MAP);
			// } catch (IOException e) {
			// AuthoringUIPlugin.getDefault().getLogger().logError(e);
			// }
			// }
			// }
			// }
		}
	}

	/**
	 * Checks whether input is valid or not
	 * @return boolean value
	 */
	public boolean isInputValid() {
		if (elementObj != null && elementObj.eIsProxy()) {
			EObject e = RefreshJob.getInstance().resolve(elementObj);
			return (e instanceof MethodElement && !e.eIsProxy() && UmaUtil
					.getMethodLibrary(e) == LibraryService.getInstance()
					.getCurrentMethodLibrary());
		}
		return true;
	}

	protected void updatePages() {
		while (getPageCount() > 0) {
			removePage(0);
		}
		addPages();
	}

	protected IEditorInput createInput(MethodElement e) {
		return new MethodElementEditorInput(e);
	}

	public synchronized void refresh(final boolean force) {
		BusyIndicator.showWhile(getSite().getShell().getDisplay(),
				new Runnable() {

					public void run() {
						Collection<Resource> usedResources = lastUsedResources;
						if (!force && !elementObj.eIsProxy()
								&& !checkReloaded(usedResources)) {
							// no resource reloaded, no need to refresh
							//
							return;
						}
						int activePageIndex = getActivePage();
						modifiedRichText = null;
						if (isDirty()) {
							actionMgr.undoAll();
							dirty = false;
						}
						if (elementObj.eIsProxy()) {
							elementObj.eAdapters().remove(nameChangedListener);
							EObject e = RefreshJob.getInstance().resolve(
									elementObj);
							if (e instanceof MethodElement
									&& !e.eIsProxy()
									&& UmaUtil.getMethodLibrary(e) == LibraryService
											.getInstance()
											.getCurrentMethodLibrary()) {
								setInput(createInput((MethodElement) e));
							} else {
								// input element is invalid, close the editor
								//
								close(false);
								return;
							}
						}
						setResourceInfos(usedResources);
						updatePages();
						if (activePageIndex != -1) {
							setActivePage(activePageIndex);
						}
						firePropertyChange(IEditorPart.PROP_DIRTY);
					}

				});

	}

	/**
	 * Refreshes the editor
	 */
	public void refresh() {
		refresh(RefreshJob.getInstance().getChangedResources());
	}
	
	protected void refresh(Collection<Resource> changedResources) {
		// save changed resources before refresh so action manager will not try
		// to save these changed resources
		//
		this.changedResources.addAll(changedResources);
		refresh(false);
		this.changedResources.clear();		
	}


	/**
	 * Public method to refresh editor title image on certain action.
	 * e.g. If methodPlugin is locked, editor title image should be grey-ed out.
	 * 
	 * @param methodElement
	 */
	public void refreshTitleImage() {
		if (fMethodElementEditorErrorTickUpdater != null)
			fMethodElementEditorErrorTickUpdater.updateEditorImage(elementObj);
	}

	public void updatedTitleImage(Image image) {
		setTitleImage(image);
	}
	
	public void gotoMarker(IMarker marker) {
		if(marker.getResource() == elementFile) {
			try {
				Object val = marker.getAttribute(LibraryValidationMarkerHelper.GUID);
				if(val instanceof String) {
					String guid = (String) val;
					MethodElement e = LibraryService.getInstance().getCurrentLibraryManager().getMethodElement(guid);
					if(e != elementObj) {
						// wrong element is opened because element from the
						// marker is not the top element in its resource
						// close this editor and open the right one
						//
						close(false);
						IEditorKeeper.REFERENCE.getEditorKeeper().openEditor(e);
						return;
					}
				}
			} catch (CoreException e) {

			}
		}
		
		// open description page
		setActivePage(0);
	}

	public boolean isDisposed() {
		return disposed;
	}

}