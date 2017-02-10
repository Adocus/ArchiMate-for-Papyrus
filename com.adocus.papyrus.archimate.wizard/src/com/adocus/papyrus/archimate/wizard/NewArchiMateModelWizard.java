package com.adocus.papyrus.archimate.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.uml.diagram.wizards.wizards.CreateModelWizard;
import org.eclipse.ui.IWorkbench;

/**
 * Wizard to create a new ArchiMate model
 *
 */
public class NewArchiMateModelWizard extends CreateModelWizard {

	/**
	 * @see org.eclipse.papyrus.wizards.CreateModelWizard#init(org.eclipse.ui.IWorkbench,
	 *      org.eclipse.jface.viewers.IStructuredSelection)
	 *
	 * @param workbench
	 * @param selection
	 */

	/*@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(workbench, selection);
		setWindowTitle("New ArchiMate Model");
	}*/

	/**
	 * Instantiates a new new ArchiMate model wizard.
	 */
	/*public NewArchiMateModelWizard() {
		super();
	}*/

	@Override
	public String getModelKindName() {
		return "ArchiMate";
	}

	/*@Override
	protected String[] getDiagramCategoryIds() {
		return new String[] { "ArchiMate" };
	}*/

	/*@Override
	protected void applyProfile(ModelSet modelSet) {
		// TODO Auto-generated method stub
		super.applyProfile(modelSet);
	}*/
	
	
}
