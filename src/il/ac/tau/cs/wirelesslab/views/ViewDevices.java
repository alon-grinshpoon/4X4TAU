package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.DevicesComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ViewDevices extends ViewPart {

	public static final String ID = "4X4Plugin.viewDevices";
			
	public ViewDevices() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		new DevicesComposite(parent, SWT.None);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
