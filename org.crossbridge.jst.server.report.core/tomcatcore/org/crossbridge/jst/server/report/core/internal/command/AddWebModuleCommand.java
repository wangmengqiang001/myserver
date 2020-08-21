/*******************************************************************************
 * Copyright (c) 2003, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.crossbridge.jst.server.report.core.internal.command;

import org.crossbridge.jst.server.report.core.internal.ITomcatConfigurationWorkingCopy;
import org.crossbridge.jst.server.report.core.internal.Messages;
import org.crossbridge.jst.server.report.core.internal.WebModule;
/**
 * Command to add a web module.
 */
public class AddWebModuleCommand extends ConfigurationCommand {
	protected WebModule module;
	protected int modules = -1;

	/**
	 * AddWebModuleCommand constructor comment.
	 * 
	 * @param configuration a tomcat configuration
	 * @param module a web module
	 */
	public AddWebModuleCommand(ITomcatConfigurationWorkingCopy configuration, WebModule module) {
		super(configuration, Messages.configurationEditorActionAddWebModule);
		this.module = module;
	}

	/**
	 * Execute the command.
	 */
	public void execute() {
		modules = configuration.getWebModules().size();
		configuration.addWebModule(-1, module);
	}

	/**
	 * Undo the command.
	 */
	public void undo() {
		configuration.removeWebModule(modules);
	}
}
