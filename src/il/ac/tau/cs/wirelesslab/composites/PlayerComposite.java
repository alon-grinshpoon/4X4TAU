package il.ac.tau.cs.wirelesslab.composites;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class PlayerComposite extends Composite {
	private final static int MAX_FREQ = 11000;
	private final static int MIN_FREQ = 50;
	private final static int DEFAULT_FREQ = 120;
	private static Label label;
	private static Scale scale;

	private Composite composite;

	public PlayerComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		setLayout(gridLayout);


		label = new Label(this, SWT.BOLD);
		scale = new Scale(this, SWT.NONE);
        
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		scale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		scale.setMaximum(MAX_FREQ);
		scale.setMinimum(MIN_FREQ);
		scale.setSelection(DEFAULT_FREQ);
		label.setFont(new Font(null, "Segoe UI SemiBold", 20, 0));
		label.setText(String.valueOf(scale.getSelection()) + " [MHz]");
		label.setSize(100, 100);
		scale.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				label.setText(String.valueOf(scale.getSelection()) + " [MHz]");
			}
		});

		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				1, 1));
	}

	public Composite getComposite() {
		return composite;
	}

	public static double getFrequency() {
		return scale.getSelection();
	}

	public static void setFrequency(double frequency) {
		scale.setSelection((int)frequency);
		label.setText(String.valueOf(frequency) + " [MHz]");
	}
}