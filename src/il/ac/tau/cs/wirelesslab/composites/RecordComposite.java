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
import be.tarsos.dsp.example.Spectrogram;

public class RecordComposite extends Composite {
	private Button playButton;
	private Button recordButton;
	private Button forwardButton;
	private Button backwardButton;
	private Button pauseButton;
	private Button stopButton;

	final static int NUM_OF_BUTTONS = 6;
	
	private Composite composite;

	public RecordComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = NUM_OF_BUTTONS;
		setLayout(gridLayout);

		playButton = new Button(this, SWT.PUSH);
		recordButton = new Button(this, SWT.PUSH);
		forwardButton = new Button(this, SWT.PUSH);
		backwardButton = new Button(this, SWT.PUSH);
		pauseButton = new Button(this, SWT.PUSH);
		stopButton = new Button(this, SWT.PUSH);

		playButton.addMouseListener(new Utils.ExitMouseListener());
		recordButton.addMouseListener(new Utils.ExitMouseListener());
		forwardButton.addMouseListener(new Utils.ExitMouseListener());
		backwardButton.addMouseListener(new Utils.ExitMouseListener());
		pauseButton.addMouseListener(new Utils.ExitMouseListener());
		stopButton.addMouseListener(new Utils.ExitMouseListener());

		playButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		recordButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		forwardButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		backwardButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		pauseButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		stopButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		playButton.setText("Play");
		recordButton.setText("Record");
		forwardButton.setText("Forward");
		backwardButton.setText("Backward");
		pauseButton.setText("Pause");
		stopButton.setText("Stop");

		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				NUM_OF_BUTTONS, 1));
	}

	public Composite getComposite() {
		return composite;
	}
}