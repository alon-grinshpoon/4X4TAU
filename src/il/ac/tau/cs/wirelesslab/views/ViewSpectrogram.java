package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.SpectrogramComposite;

import javax.swing.JFrame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class ViewSpectrogram extends ViewPart {

	public static final String ID = "4X4Plugin.viewSpectrogram";
	public static JFrame spectrogram = null;
	public static JFrame oscilloscope = null;
	public ViewSpectrogram() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		
		//Label label = new Label(parent, SWT.None); //new up a Label widget
		//label.setText("This is the Spectrogram view.");
		//CustomComposite sc = new CustomComposite(parent, SWT.NONE);
		SpectrogramComposite sc = new SpectrogramComposite(parent, SWT.NONE);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
