package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.CustomComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class ViewDevices extends ViewPart {

	public static final String ID = "4X4Plugin.viewDevices";
			
	public ViewDevices() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		Label label = new Label(parent, SWT.None); //new up a Label widget
		label.setText("This is the Devices view.");
		
		CustomComposite cc = new CustomComposite(parent, SWT.None);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
