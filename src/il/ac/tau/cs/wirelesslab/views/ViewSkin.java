package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.SkinComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ViewSkin extends ViewPart {

	public static final String ID = "4X4Plugin.viewSkin";
			
	public ViewSkin() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		SkinComposite sc = new SkinComposite(parent, SWT.None);
	}

	public void setFocus() {
		// TODO Auto-generated method stub
	}

}
