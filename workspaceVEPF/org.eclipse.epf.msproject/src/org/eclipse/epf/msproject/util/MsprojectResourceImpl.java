/**
 * <copyright>
 * </copyright>
 *
 * $Id: MsprojectResourceImpl.java,v 1.2 2006/04/11 15:29:55 jthario Exp $
 */
package org.eclipse.epf.msproject.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.epf.msproject.util.MsprojectResourceFactoryImpl
 * @generated
 */
public class MsprojectResourceImpl extends XMLResourceImpl {
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public MsprojectResourceImpl(URI uri) {
		super(uri);
	}

	protected XMLHelper createXMLHelper(){
	    return new MsprojectXMLHelperImpl(this);
	}
} //MsprojectResourceImpl