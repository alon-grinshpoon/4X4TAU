package il.ac.tau.cs.wirelesslab.graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

import be.tarsos.dsp.example.Spectrogram;
import il.ac.tau.cs.wirelesslab.State;
import il.ac.tau.cs.wirelesslab.views.ViewSpectrogram;

public class Utils {

	public static Dimension screenSize;
	public final static int MESSAGE_WIDTH = 250;
	public final static int MESSAGE_HEIGHT = 100;
	public final static int BUTTON_WIDTH = 90;
	public final static int BUTTON_HEIGHT = 50;
	public final static String DEFAULT_FILE_NAME = "4X4TAU.dsp";
	public final static String DEFAULT_SKIN = "graphics/skins/default/";
	public final static String PACKAGE_PATH = "/il/ac/tau/cs/wirelesslab/";

	/**
	 * Returns the current skin.
	 */
	public static String getSkin(){
		return State.getData().getSkin();
	}
	
	/**
	 * Exit action listener to shutdown to program.
	 */
	public static class ExitActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				State.autoSave();
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
			System.exit(0);
		}
	}
	
	/**
	 * Exit mouse listener to shutdown to program.
	 */
	public static class ExitMouseListener implements MouseListener{

		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseUp(MouseEvent e) {
			try {
				State.autoSave();
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
			System.exit(0);
		}
	}
	
	public static class SpectrogramMouseListener implements MouseListener{
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseUp(MouseEvent e) {
			try {
				if (ViewSpectrogram.spectrogram == null)
				{
					ViewSpectrogram.spectrogram = new Spectrogram(null);
					ViewSpectrogram.spectrogram.pack();
					ViewSpectrogram.spectrogram.setSize(1024, 768);
					ViewSpectrogram.spectrogram.setVisible(true);
					ViewSpectrogram.spectrogram.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				}
				else
				{
					ViewSpectrogram.spectrogram.setVisible(true);
				}
				
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
		}
	}
}
