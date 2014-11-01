package il.ac.tau.cs.wirelesslab.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
public class ViewFavorites extends ViewPart {

	public static final String ID = "4X4Plugin.viewFavorites";
			
	public ViewFavorites() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		Label label = new Label(parent, SWT.None); //new up a Label widget
		label.setText("This is the favorites view.");
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
