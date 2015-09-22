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
package org.eclipse.epf.common;

import org.eclipse.epf.common.plugin.AbstractPlugin;
import org.osgi.framework.BundleContext;

/**
 * The Common plug-in activator.
 */
public class CommonPlugin extends AbstractPlugin {

	// The shared plug-in instance.
	private static CommonPlugin plugin;

	/**
	 * Creates a new instance.
	 */
	public CommonPlugin() {
		super();
		plugin = this;
	}

	/**
	 * @see org.eclipse.epf.common.plugin.AbstractPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * @see org.eclipse.epf.common.plugin.AbstractPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		plugin = null;
	}

	/**
	 * Gets the shared instance.
	 * 
	 * @return the shared plug-in instance
	 */
	public static CommonPlugin getDefault() {
		return plugin;
	}

}