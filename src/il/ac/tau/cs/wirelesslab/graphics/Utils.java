package il.ac.tau.cs.wirelesslab.graphics;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import il.ac.tau.cs.wirelesslab.State;

public class Utils {

	public static Dimension screenSize;
	public final static int MESSAGE_WIDTH = 250;
	public final static int MESSAGE_HEIGHT = 100;
	public final static int BUTTON_WIDTH = 90;
	public final static int BUTTON_HEIGHT = 50;
	public final static String DEFAULT_FILE_NAME = "4X4TAU.dsp";
	public final static String DEFAULT_SKIN = "graphics/skins/default/";

	/**
	 * Returns the current skin.
	 */
	public static String getSkin(){
		return State.getData().getSkin();
	}
	
	/**
	 * Exit listener to shutdown to program.
	 */
	public static class ExitListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				State.autoSave();
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
			System.exit(0);
		}
	}
}
