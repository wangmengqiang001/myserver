/*******************************************************************************
 * Copyright (c) 2003, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.crossbridge.jst.server.report.core.internal.command;

import org.crossbridge.jst.server.report.core.internal.ITomcatConfigurationWorkingCopy;
import org.crossbridge.jst.server.report.core.internal.Messages;
import org.crossbridge.jst.server.report.core.internal.WebModule;
/**
 * Command to remove a web module.
 */
public class RemoveWebModuleCommand extends ConfigurationCommand {
	protected int index;
	protected WebModule module;

	/**
	 * RemoveWebModuleCommand constructor comment.
	 * 
	 * @param configuration a tomcat configuration
	 * @param index an index
	 */
	public RemoveWebModuleCommand(ITomcatConfigurationWorkingCopy configuration, int index) {
		super(configuration, Messages.configurationEditorActionRemoveWebModule);
		this.index = index;
	}

	/**
	 * Execute the command.
	 */
	public void execute() {
		module = (WebModule) configuration.getWebModules().get(index);
		configuration.removeWebModule(index);
	}

	/**
	 * Undo the command.
	 */
	public void undo() {
		configuration.addWebModule(index, module);
	}
}