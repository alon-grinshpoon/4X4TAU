package il.ac.tau.cs.wirelesslab.composites;

import il.ac.tau.cs.wirelesslab.graphics.Utils;
import il.ac.tau.cs.wirelesslab.SoundRecorder;

import java.io.InputStream;
import org.eclipse.swt.SWT;
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
	private static boolean isRecording = false;
	public static SoundRecorder recorder = null;
	
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

		backwardButton = new Button(this, SWT.PUSH);
		stopButton = new Button(this, SWT.PUSH);
		pauseButton = new Button(this, SWT.PUSH);
		playButton = new Button(this, SWT.PUSH);
		recordButton = new Button(this, SWT.PUSH);
		forwardButton = new Button(this, SWT.PUSH);

		playButton.addMouseListener(new Utils.ExitMouseListener());
		recordButton.addMouseListener(new Utils.RecordButtonMouseListener());
		forwardButton.addMouseListener(new Utils.ExitMouseListener());
		backwardButton.addMouseListener(new Utils.ExitMouseListener());
		pauseButton.addMouseListener(new Utils.ExitMouseListener());
		stopButton.addMouseListener(new Utils.StopButtonMouseListener());

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

	public static boolean isRecording() {
		return isRecording;
	}

	public static void setRecording(boolean isRecording) {
		RecordComposite.isRecording = isRecording;
	}
}