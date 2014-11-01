package il.ac.tau.cs.wirelesslab.graphics;

import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JButton;


public class XButton extends JButton {

	private static final long serialVersionUID = -2429303064899686058L;

	/**
	 * Construct a XButton.
	 * @param text The test shown on the button.
	 * @param actionListener The action performed when pushing the button. 
	 */
	public XButton(String text, ActionListener actionListener) {
		// Set button text
		super(text);
		// Set button action
		this.addActionListener(actionListener);
		// Set Button size
		this.setBounds(0, 0, Utils.BUTTON_WIDTH, Utils.BUTTON_HEIGHT);
	}
	
	/**
	 * Construct a XButton.
	 * @param text The test shown on the button.
	 * @param actionListener The action performed when pushing the button. 
	 * @param icon The icon on the button.
	 */
	public XButton(String text, ActionListener actionListener, Icon icon) {
		// Call default constructor
		this(text, actionListener);
		// Set icon
		this.setIcon(icon);
	}
}
