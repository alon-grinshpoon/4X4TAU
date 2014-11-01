package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.PlayerComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ViewPlayer extends ViewPart {

	public static final String ID = "4X4Plugin.viewPlayer";
			
	public ViewPlayer() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		PlayerComposite pc = new PlayerComposite(parent, SWT.None);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
