package il.ac.tau.cs.wirelesslab.views;

import java.awt.Frame;

import javax.swing.JApplet;
import javax.swing.JFrame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import be.tarsos.dsp.example.Spectrogram;
import be.tarsos.dsp.example.SpectrogramPanel;

public class ViewSpectrogram extends ViewPart {

	public static final String ID = "4X4Plugin.viewSpectrogram";
	public static JFrame spectrogram = null;
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