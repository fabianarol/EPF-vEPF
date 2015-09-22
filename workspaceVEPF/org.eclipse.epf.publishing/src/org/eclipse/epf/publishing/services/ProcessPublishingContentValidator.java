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
package org.eclipse.epf.publishing.services;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.epf.library.configuration.ConfigurationHelper;
import org.eclipse.epf.library.util.LibraryUtil;
import org.eclipse.epf.publishing.PublishingPlugin;
import org.eclipse.epf.uma.BreakdownElement;
import org.eclipse.epf.uma.ContentCategory;
import org.eclipse.epf.uma.Descriptor;
import org.eclipse.epf.uma.Guidance;
import org.eclipse.epf.uma.MethodElement;
import org.eclipse.epf.uma.Practice;
import org.eclipse.epf.uma.Roadmap;
import org.eclipse.epf.uma.SupportingMaterial;
import org.eclipse.epf.uma.TermDefinition;

/**
 * This is the content validator for publishing a process closure. 
 * The validator will check elements against the process closure and determine if 
 * an element should be published or not.
 * 
 * @author Jinhua Xi
 * @since 1.0
 *
 */
public class ProcessPublishingContentValidator extends PublishingContentValidator {

	protected static final String CLOSURE_LOG_FILENAME = "processClosure.html"; //$NON-NLS-1$

	// closure elements for process publishing, null for config publishing
	List closureElements = null;
	private boolean isFinalClosure = false;
	
//	// maintain the object references generated from TaskDescriptors
//	// map of owner element to a list of referenced elements
//	Map objReferences = new HashMap();
	
	private boolean debug = PublishingPlugin.getDefault().isDebugging();
	
	protected PrintStream closureLog = null;
	
	/**
	 * constructor
	 * 
	 * @param pubDir String
	 * @param validateExternalLinks boolean
	 */
	public ProcessPublishingContentValidator(String pubDir, PublishHTMLOptions options) {
		super(pubDir, options);
		
		closureLog = getStream(CLOSURE_LOG_FILENAME);
		beginClosureLog();

	}

	/**
	 * add the elements to the process closure.
	 * @param items List
	 */
	public void addClosureElements(List items) {
		// do nothing
		if ( closureElements == null ) {
			closureElements = new ArrayList();
		}
		
		closureElements.addAll(items);
	}

	/**
	 * 	make element closure 
	 *  all the published and referenced elements are the element closure. 
	 *  since they are all the elements referenced by the processes and their related process elements. 
	 */
	public void makeElementClosure() {
		this.isFinalClosure = true;
		
		endClosureLog();
		
		// test
		if ( debug) {
			System.out.println("====================== Closure elements ======================="); //$NON-NLS-1$
			for (Iterator it = closureElements.iterator(); it.hasNext(); ) {
				System.out.println(LibraryUtil.getTypeName((MethodElement)it.next()));
			}
			System.out.println("====================== Closure elements end ======================="); //$NON-NLS-1$
		}
	}
	
	/**
	 * check if a closure is created or not.
	 * @return boolean
	 */
	public boolean hasClosure() {
		return (closureElements != null) && (closureElements.size() > 0);
	}
	
	/**
	 * determine if the element is in the process element closure or not
	 * The process element closure contains all the process elements of the selected processes, 
	 * plus all the content elements those elements referenced.
	 * 
	 * @param e MethodElement
	 * @return boolean
	 */
	public boolean inClosure(MethodElement e) {
		
		if ( e == null ) {
			return false;
		}
		
		if ( !hasClosure() ) {
			return true;
		}
		
		if ( e instanceof ContentCategory ) {
			return true;
		}
		
		// 166048 - check-items, task-steps don't appear when using the publishing type "publish the processes selected below"
		if ( ConfigurationHelper.isDescriptionElement(e) ) {
			return true;
		}
		
		if ( closureElements.contains(e) ) {
			return true;
		}
		
		if ( !(e instanceof Guidance) ) {
			return false;
		}
		
		if ( e instanceof Practice 
				|| e instanceof Roadmap 
				|| e instanceof SupportingMaterial 
				|| e instanceof TermDefinition )
		{
			return true;
		}

		return false;
			
	}
	
	/**
	 * check if the element is discarded or not
	 * discarded elements will be treated as out side the configursation
	 * 
	 * @param owner MethodElement the owner of the element
	 * @param feature Object EStructuralFeature or OppositeFeature
	 * @param e MethodElement the element to be checked
	 */
	/* (non-Javadoc)
	 * @see com.ibm.rmc.library.layout.IContentValidator#isDiscarded(org.eclipse.epf.uma.MethodElement, java.lang.Object, org.eclipse.epf.uma.MethodElement)
	 */
	public boolean isDiscarded(MethodElement owner, Object feature, MethodElement e) {
	
		if ( owner == null ) {
			owner = defaultTarget;
		} else if ( defaultTarget != null && owner != defaultTarget ) {
			
			super.logWarning("Target mismatch" + LibraryUtil.getTypeName(owner) + "<--->" + LibraryUtil.getTypeName(defaultTarget)); //$NON-NLS-1$ //$NON-NLS-2$
		}
		
		if ( super.isDiscarded(owner, feature, e) ) {
			return true;
		}
		
		boolean inCls = inClosure(e);
		if (!inCls && !isFinalClosure ) {
			// if the closure is not final, then if the owner is in closure and the element is a Guidance, 
			// this element is also in closure
			inCls = inClosure(owner) && (e instanceof Guidance);
		}
		
		if ( !inCls ) {
			return true;
		}
		
//		// special handling for Tasks
//		if ( owner instanceof Task ) {
//			if ( feature == UmaPackage.eINSTANCE.getTask_AdditionallyPerformedBy() || 
//					feature == UmaPackage.eINSTANCE.getTask_MandatoryInput() ||
//					feature == UmaPackage.eINSTANCE.getTask_OptionalInput() || 
//					feature == UmaPackage.eINSTANCE.getTask_Output() ) {
//				List refs = (List)objReferences.get(owner);
//				if ( refs != null && !refs.contains(e) ) {
//					return true;
//				}
//			}
//		}
		
		return false;
	}
	
	
	/**
	 * dispose the object
	 */
	public void dispose() {
		
		if ( closureElements != null ) {
			closureElements.clear();
		}
		
//		if ( objReferences != null ) {
//			objReferences.clear();
//		}
		
		if ( closureLog != null ) {
			closureLog.close();
			closureLog = null;
		}
		
		super.dispose();
		
	}
	
	private void beginClosureLog() {
		closureLog.println("<table>"); //$NON-NLS-1$
		addLogEntry("<b>Element</b>", "<b>Referenced By</b>"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	private void endClosureLog() {
		closureLog.println("</table>"); //$NON-NLS-1$
	}
	
	private void addLogEntry(String str1, String str2) {
		StringBuffer b = new StringBuffer();
		b.append("<tr><td>").append(str1).append("</td><td>").append(str2).append("</td></tr>"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		closureLog.println(b);
	}
	
	/**
	 * log the referenced element.
	 * 
	 * @param owner MethodElement the referencing element
	 * @param e MethodElement the referenced element
	 */
	public void logReference(MethodElement owner, MethodElement e)
	{
		super.logReference(owner, e);
		if ( e instanceof Descriptor ) {
			return;
		}
		
		if ( !isFinalClosure && closureLog != null) {
			
			StringBuffer b = new StringBuffer();
			if ( owner instanceof BreakdownElement ) {
				b.append(getBreakdownElementLabel((BreakdownElement)owner));
			} else if ( owner != null ) {
				b.append(LibraryUtil.getTypeName(owner));
			}
			
			addLogEntry(LibraryUtil.getTypeName(e), b.toString());
		}
	}
	
	private StringBuffer getBreakdownElementLabel(BreakdownElement e) {
		StringBuffer b = new StringBuffer();
		b.append(LibraryUtil.getTypeName(e));

		while ( (e=e.getSuperActivities()) != null ) {
			b.insert(0, LibraryUtil.getTypeName(e) + "/"); //$NON-NLS-1$
		}
		
		return b;
	}
		
}