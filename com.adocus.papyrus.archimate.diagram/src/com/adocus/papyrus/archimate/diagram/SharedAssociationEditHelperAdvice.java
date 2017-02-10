/*****************************************************************************
 * Copyright (c) 2017 Adocus AB (www.adocus.com)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Adocus- Initial contributor
 *
 *****************************************************************************/

package com.adocus.papyrus.archimate.diagram;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;

public class SharedAssociationEditHelperAdvice extends AbstractEditHelperAdvice {
	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getBeforeConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 *
	 * @param request
	 * @return
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		final Association association = (Association) request.getElementToConfigure();
		
		return new ConfigureElementCommand(request) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				// FIXME 483804: this kind of thing is probably possible with an element type configuration model
				association.getMemberEnds().get(0).setAggregation(AggregationKind.SHARED_LITERAL);
				//association.getMemberEnds().get(0).setIsNavigable(false);
				
				return CommandResult.newOKCommandResult(association);
			}
		};
	}
}
