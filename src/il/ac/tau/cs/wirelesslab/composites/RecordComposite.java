package il.ac.tau.cs.wirelesslab.composites;

import il.ac.tau.cs.wirelesslab.graphics.Utils;
import il.ac.tau.cs.wirelesslab.Recorder;
import il.ac.tau.cs.wirelesslab.State;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;
import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class RecordComposite extends Composite {
	private Button playButton;
	private Button recordButton;
	private Button forwardButton;
	private Button backwardButton;
	private Button pauseButton;
	private Button stopButton;
	public static boolean isRecording = false;
	public static Recorder rec = null;
	private Button volumeButton;
	
	final static int NUM_OF_BUTTONS = 7;

	private Composite composite;

	public RecordComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = NUM_OF_BUTTONS;
		setLayout(gridLayout);

		backwardButton = new Button(this, SWT.PUSH);
		stopButton = new Button(this, SWT.PUSH);
		pauseButton = new Button(this, SWT.PUSH);
		playButton = new Button(this, SWT.PUSH);
		recordButton = new Button(this, SWT.TOGGLE);
		forwardButton = new Button(this, SWT.PUSH);
        volumeButton = new Button(this, SWT.PUSH);
		
		playButton.addMouseListener(new Utils.ExitMouseListener());
		recordButton.addMouseListener(new RecordComposite.RecordButtonMouseListener());
		forwardButton.addMouseListener(new Utils.ExitMouseListener());
		backwardButton.addMouseListener(new Utils.ExitMouseListener());
		pauseButton.addMouseListener(new Utils.ExitMouseListener());
		stopButton.addMouseListener(new RecordComposite.StopButtonMouseListener());

		backwardButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		stopButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		playButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		recordButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		pauseButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		forwardButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		volumeButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
						false));

		// Set Buttons Images
		String filePlay = Utils.PACKAGE_PATH + Utils.getSkin() + "/Play.png";
		InputStream resourcePlay = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(filePlay);
		final Image imgPlay = new Image(this.getDisplay(), resourcePlay);
		playButton.setImage(imgPlay);

		String fileStop = Utils.PACKAGE_PATH + Utils.getSkin() + "/Stop.png";
		InputStream resourceStop = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(fileStop);
		final Image imgStop = new Image(this.getDisplay(), resourceStop);
		stopButton.setImage(imgStop);

		String fileRecord = Utils.PACKAGE_PATH + Utils.getSkin()
				+ "/Record.png";
		InputStream resourceRecord = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(fileRecord);
		final Image imgRecord = new Image(this.getDisplay(), resourceRecord);
		recordButton.setImage(imgRecord);

		String fileForward = Utils.PACKAGE_PATH + Utils.getSkin()
				+ "/Forward.png";
		InputStream resourceForward = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(fileForward);
		final Image imgForward = new Image(this.getDisplay(), resourceForward);
		forwardButton.setImage(imgForward);

		String fileBackwards = Utils.PACKAGE_PATH + Utils.getSkin()
				+ "/Backwards.png";
		InputStream resourceBackwards = FavoritesComposite.class
				.getClassLoader().getResourceAsStream(fileBackwards);
		final Image imgBackwards = new Image(this.getDisplay(),
				resourceBackwards);
		backwardButton.setImage(imgBackwards);

		String filePause = Utils.PACKAGE_PATH + Utils.getSkin() + "/Pause.png";
		InputStream resourcePause = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(filePause);
		final Image imgPause = new Image(this.getDisplay(), resourcePause);
		pauseButton.setImage(imgPause);
		
		String fileVolume = Utils.PACKAGE_PATH + Utils.getSkin() + "/Volume.png";
		InputStream resourceVolume = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(fileVolume);
		final Image imgVolume = new Image(this.getDisplay(), resourceVolume);
		volumeButton.setImage(imgVolume);

		playButton.setText("Play");
		recordButton.setText("Record");
		forwardButton.setText("Forward");
		backwardButton.setText("Backward");
		pauseButton.setText("Pause");
		stopButton.setText("Stop");
		volumeButton.setText("Volume");

		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				NUM_OF_BUTTONS, 1));
	}

	public Composite getComposite() {
		return composite;
	}

	public static boolean isRecording() {
		return isRecording;
	}

	public static void setRecording(boolean isRecording) {
		RecordComposite.isRecording = isRecording;
	}
	
	public static class RecordButtonMouseListener implements MouseListener
	{

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseUp(MouseEvent e) {
			// TODO Auto-generated method stub
			if (RecordComposite.isRecording)
			{
				RecordComposite.rec.stopRecording();
				RecordComposite.setRecording(false);
				return;
			}
			JFileChooser fileChooser = new JFileChooser();
			File file = null;
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
			{
				file = fileChooser.getSelectedFile();
			}
			if (file != null)
			{
				if (State.getData().getMixer() != null)
				{
					try {
						RecordComposite.rec = new Recorder(file.getCanonicalPath());
						RecordComposite.isRecording = true;
						RecordComposite.rec.startRecording();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			    }
			}
				else
				{
					AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
				    try {
						TargetDataLine microphone = AudioSystem.getTargetDataLine(format);
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
		}
		
	}
	
	public static class StopButtonMouseListener implements MouseListener{		

		@Override
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseUp(MouseEvent e) {
			if (RecordComposite.isRecording())
			{
				RecordComposite.rec.stopRecording();
				RecordComposite.setRecording(false);
			}
		}
	}

}