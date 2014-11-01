package il.ac.tau.cs.wirelesslab.composites;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import be.tarsos.dsp.example.Spectrogram;

public class FavoritesComposite extends Composite {
	private Button favButton1;
	private Button favButton2;
	private Button favButton3;
	private Button favButton4;
	private Button favButton5;

	final static int NUM_OF_FAVORITES = 5;

	private Composite composite;

	public FavoritesComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = NUM_OF_FAVORITES;
		setLayout(gridLayout);

		favButton1 = new Button(this, SWT.PUSH);
		favButton2 = new Button(this, SWT.PUSH);
		favButton3 = new Button(this, SWT.PUSH);
		favButton4 = new Button(this, SWT.PUSH);
		favButton5 = new Button(this, SWT.PUSH);

		favButton1.addMouseListener(new Utils.ExitMouseListener());
		favButton2.addMouseListener(new Utils.ExitMouseListener());
		favButton3.addMouseListener(new Utils.ExitMouseListener());
		favButton4.addMouseListener(new Utils.ExitMouseListener());
		favButton5.addMouseListener(new Utils.ExitMouseListener());

		favButton1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		favButton2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		favButton3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		favButton4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		favButton5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		favButton1.setText("Fav 1");
		favButton2.setText("Fav 2");
		favButton3.setText("Fav 3");
		favButton4.setText("Fav 4");
		favButton5.setText("Fav 5");

		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				NUM_OF_FAVORITES, 1));
	}

	public Composite getComposite() {
		return composite;
	}
}