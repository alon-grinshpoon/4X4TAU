package il.ac.tau.cs.wirelesslab;

import il.ac.tau.cs.wirelesslab.graphics.ImagePanel;
import il.ac.tau.cs.wirelesslab.graphics.Utils;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Splash extends JFrame {

	private static final long serialVersionUID = -4761303591922069226L;
	private ImagePanel imagePanel;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public Splash() throws IOException {
		// Set frame attributes
		setUndecorated(true);
		setLocationRelativeTo(null);
		// Set graphics
		InputStream imageStream = getClass().getResourceAsStream(
				Utils.getSkin() + "Splash.png");
		BufferedImage image = ImageIO.read(imageStream);
		int width = image.getWidth();
		int height = image.getHeight();
		setBounds((Utils.screenSize.width - width) / 2,
				(Utils.screenSize.height - height) / 2, width, height);
		imagePanel = new ImagePanel(image);
		imagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		imagePanel.setLayout(new BorderLayout(0, 0));
		setContentPane(imagePanel);
	}

}
