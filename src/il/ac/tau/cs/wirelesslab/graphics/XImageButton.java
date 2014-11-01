package il.ac.tau.cs.wirelesslab.graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLayeredPane;

public class XImageButton extends JLayeredPane {
	
	private static final long serialVersionUID = 7137270811725979770L;
	private Image image;
	
	/**
	 * ImagePanel Constructor
	 */
	public XImageButton(Image image, ActionListener actionListener) {
		this.image = image;
		this.addMouseListener(new MouseActionListner(actionListener));
	}

	private class MouseActionListner implements MouseListener{

		private  ActionListener actionListener;
		
		public MouseActionListner(ActionListener actionListener) {
			this.actionListener = actionListener;
		}
		
		
		public void mouseClicked(MouseEvent arg0) {
						
		}
		
		public void mouseEntered(MouseEvent arg0) {
			// TODO make button fuzzy for hover
		}
		
		public void mouseExited(MouseEvent arg0) {
			// TODO return button to it's regular form
		}

		public void mousePressed(MouseEvent arg0) {

		}

		public void mouseReleased(MouseEvent arg0) {
			this.actionListener.actionPerformed(null);
		}
		
	}
	
	protected void paintComponent(Graphics graphics) {
		graphics.drawImage(image, 0, 0, null);
	}

}
