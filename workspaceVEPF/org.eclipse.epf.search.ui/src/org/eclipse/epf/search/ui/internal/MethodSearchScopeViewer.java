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
package org.eclipse.epf.search.ui.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

/**
 * Displays the searchable method elements, organized by types, in a tree view.
 * 
 * @author Kelvin Low
 * @since 1.0
 */
public class MethodSearchScopeViewer {

	private static final String ROOT = MethodSearchScope.ROOT;

	private static final String METHOD_CONTENT = MethodSearchScope.METHOD_CONTENT;

	private static final String ROLE = MethodSearchScope.ROLE;

	private static final String TASK = MethodSearchScope.TASK;

	private static final String WORK_PRODUCT = MethodSearchScope.WORK_PRODUCT;

	private static final String GUIDANCE = MethodSearchScope.GUIDANCE;

	private static final String CHECKLIST = MethodSearchScope.CHECKLIST;

	private static final String CONCEPT = MethodSearchScope.CONCEPT;

	private static final String ESTIMATION_CONSIDERATIONS = MethodSearchScope.ESTIMATION_CONSIDERATIONS;

	private static final String EXAMPLE = MethodSearchScope.EXAMPLE;

	private static final String GUIDELINE = MethodSearchScope.GUIDELINE;

	private static final String PRACTICE = MethodSearchScope.PRACTICE;

	private static final String REPORT = MethodSearchScope.REPORT;

	private static final String REUSABLE_ASSET = MethodSearchScope.REUSABLE_ASSET;

	private static final String ROADMAP = MethodSearchScope.ROADMAP;

	private static final String SUPPORTING_MATERIAL = MethodSearchScope.SUPPORTING_MATERIAL;

	private static final String TEMPLATE = MethodSearchScope.TEMPLATE;

	private static final String TERM_DEFINITION = MethodSearchScope.TERM_DEFINITION;

	private static final String TOOL_MENTOR = MethodSearchScope.TOOL_MENTOR;

	private static final String WHITEPAPER = MethodSearchScope.WHITEPAPER;

	private static final String STANDARD_CATEGORY = MethodSearchScope.STANDARD_CATEGORY;

	private static final String CUSTOM_CATEGORY = MethodSearchScope.CUSTOM_CATEGORY;

	private static final String PROCESS = MethodSearchScope.PROCESS;

	private static final String CAPABILITY_PATTERN = MethodSearchScope.CAPABILITY_PATTERN;

	private static final String DELIVERY_PROCESS = MethodSearchScope.DELIVERY_PROCESS;

	private static List<String> rootList = new ArrayList<String>();
	static {
		rootList.add(METHOD_CONTENT);
		rootList.add(PROCESS);
	}

	private static List<String> methodContentList = new ArrayList<String>();
	static {
		methodContentList.add(ROLE);
		methodContentList.add(TASK);
		methodContentList.add(WORK_PRODUCT);
		methodContentList.add(GUIDANCE);
		methodContentList.add(STANDARD_CATEGORY);
		methodContentList.add(CUSTOM_CATEGORY);
	}

	private static List<String> guidanceList = new ArrayList<String>();
	static {
		guidanceList.add(CHECKLIST);
		guidanceList.add(CONCEPT);
		guidanceList.add(ESTIMATION_CONSIDERATIONS);
		guidanceList.add(EXAMPLE);
		guidanceList.add(GUIDELINE);
		guidanceList.add(PRACTICE);
		guidanceList.add(REPORT);
		guidanceList.add(REUSABLE_ASSET);
		guidanceList.add(ROADMAP);
		guidanceList.add(SUPPORTING_MATERIAL);
		guidanceList.add(TEMPLATE);
		guidanceList.add(TERM_DEFINITION);
		guidanceList.add(TOOL_MENTOR);
		guidanceList.add(WHITEPAPER);
	}

	private static List<String> processList = new ArrayList<String>();
	static {
		processList.add(CAPABILITY_PATTERN);
		processList.add(DELIVERY_PROCESS);
	}

	private static List<String> hasChildrenList = new ArrayList<String>();
	static {
		hasChildrenList.add(ROOT);
		hasChildrenList.add(METHOD_CONTENT);
		hasChildrenList.add(GUIDANCE);
		hasChildrenList.add(PROCESS);
	}

	private CheckboxTreeViewer viewer;

	/**
	 * The content provider for the viewer.
	 */
	private static class ViewerContentProvider implements ITreeContentProvider {

		private final Object[] EMPTY_LIST = new Object[0];

		public Object[] getElements(Object parent) {
			if (parent == ROOT) {
				return getChildren(ROOT);
			}
			return getChildren(parent);
		}

		public Object[] getChildren(Object parent) {
			if (parent == ROOT) {
				return rootList.toArray();
			} else if (parent == METHOD_CONTENT) {
				return methodContentList.toArray();
			} else if (parent == GUIDANCE) {
				return guidanceList.toArray();
			} else if (parent == PROCESS) {
				return processList.toArray();
			}
			return EMPTY_LIST;
		}

		public Object getParent(Object child) {
			if (rootList.contains(child)) {
				return ROOT;
			}
			if (methodContentList.contains(child)) {
				return METHOD_CONTENT;
			} else if (guidanceList.contains(child)) {
				return GUIDANCE;
			} else if (processList.contains(child)) {
				return PROCESS;
			}
			return EMPTY_LIST;
		}

		public boolean hasChildren(Object parent) {
			return hasChildrenList.contains(parent);
		}

		public void inputChanged(Viewer arg0, Object arg1, Object arg2) {
		}

		public void dispose() {
		}

	}

	/**
	 * The label provider for the viewer.
	 */
	private static class ViewerLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}

		public Image getImage(Object obj) {
			return null;
		}
	}

	/**
	 * Creates a new instance.
	 */
	public MethodSearchScopeViewer(Composite parent, int style) {
		viewer = new CheckboxTreeViewer(parent, style);
		viewer.getTree().setLayout(new GridLayout(1, false));
		viewer.getTree().setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.setContentProvider(new ViewerContentProvider());
		viewer.setLabelProvider(new ViewerLabelProvider());
		viewer.setInput(ROOT);
		viewer.expandToLevel(2);
		viewer.setSubtreeChecked(METHOD_CONTENT, true);
		viewer.setSubtreeChecked(PROCESS, true);
		viewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				Object selectedElement = event.getElement();
				viewer.setSubtreeChecked(selectedElement, event.getChecked());
				if (!event.getChecked()) {
					viewer.setParentsGrayed(selectedElement, true);
					viewer.setGrayChecked(selectedElement, false);
				} else {
					viewer.setParentsGrayed(selectedElement, false);
				}
			}
		});
	}

	/**
	 * Returns the selected method element types.
	 * 
	 * @return an array of selected method element types
	 */
	public MethodSearchScope getSearchScope() {
		return new MethodSearchScope(viewer.getCheckedElements());
	}

}