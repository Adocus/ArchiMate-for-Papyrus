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

package com.adocus.papyrus.archimate;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.uml.diagram.common.commands.ModelCreationCommandBase;
import org.eclipse.papyrus.uml.tools.utils.PackageUtil;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Creates a ArchiMate model
 *
 */
public class CreateArchiMateModelCommand extends ModelCreationCommandBase {

	public static final String COMMAND_ID = "com.adocus.papyrus.archimate.model";
	public static final String PROFILES_PATHMAP = "pathmap://ARCHIMATE_PROFILES/"; //$NON-NLS-1$
	public static final String PROFILE_URI = PROFILES_PATHMAP + "ArchiMate.profile.uml"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase#createRootElement()
	 *
	 * @return
	 */

	@Override
	protected EObject createRootElement() {
		return UMLFactory.eINSTANCE.createModel();
	}

	/**
	 * @see org.eclipse.papyrus.core.extension.commands.ModelCreationCommandBase#initializeModel(org.eclipse.emf.ecore.EObject)
	 *
	 * @param owner
	 */

	@Override
	protected void initializeModel(EObject owner) {
		super.initializeModel(owner);
		((org.eclipse.uml2.uml.Package) owner).setName(getModelName());

		org.eclipse.uml2.uml.Package profile = PackageUtil.loadPackage(URI.createURI(PROFILE_URI), owner.eResource().getResourceSet());
		if ((profile != null) && (profile instanceof Profile)) {
			PackageUtil.applyProfile(((org.eclipse.uml2.uml.Package) owner), (Profile) profile, true);
		}
	}

	/**
	 * Gets the model name.
	 *
	 * @return the model name
	 */
	protected String getModelName() {
		return "PapyrusArchiMateModel";
	}


}
