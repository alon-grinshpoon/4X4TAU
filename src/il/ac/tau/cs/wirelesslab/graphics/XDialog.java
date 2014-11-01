package il.ac.tau.cs.wirelesslab.graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class XDialog extends JDialog {

	private static final long serialVersionUID = -4772219636114193514L;

	/**
	 * Construct a XDialog.
	 * 
	 * @param Title
	 *            The dialog's title.
	 * @param Message
	 *            Title The message shown in the dialog.
	 * @param actionListener
	 *            The action performed by clicking the dialogs button.
	 */
	public XDialog(String title, String message, ActionListener actionListener) {
		JPanel dialongPanel = new JPanel();
		// Define the dialog's message
		JLabel dialogMessage = new JLabel(message);
		dialongPanel.add(dialogMessage, BorderLayout.CENTER);
		// Define the dialog's attributes
		this.setLocation(Utils.screenSize.width / 2,
				Utils.screenSize.height / 2);
		this.setSize(Utils.MESSAGE_WIDTH, Utils.MESSAGE_HEIGHT);
		this.setAlwaysOnTop(true);
		this.setTitle(title);
		// Define dialog button
		if (actionListener != null) {
			JButton dialogButton = new JButton();
			dialogButton.addActionListener(actionListener);
			dialogButton.setText("OK");
			dialongPanel.add(dialogButton, BorderLayout.SOUTH);
		}
		// Show dialog
		this.add(dialongPanel);
		this.setVisible(true);
	}

	/**
	 * Construct a XDialog.
	 * 
	 * @param Title
	 *            The dialog's title.
	 * @param Message
	 *            Title The message shown in the dialog.
	 */
	public XDialog(String title, String message) {
		this(title, message, null);
	}
}
