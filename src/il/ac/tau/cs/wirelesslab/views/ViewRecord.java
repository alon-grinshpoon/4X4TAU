package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.RecordComposite;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class ViewRecord extends ViewPart {

	public static final String ID = "4X4Plugin.viewRecord";
			
	public ViewRecord() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		Label label = new Label(parent, SWT.None); //new up a Label widget
		label.setText("This is the Record view.");
		
		RecordComposite cc = new RecordComposite(parent, SWT.None);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
