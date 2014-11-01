package il.ac.tau.cs.wirelesslab.composites;

import java.io.InputStream;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class PlayerComposite extends Composite {
	private final static int MAX_FREQ = 11000; 
	private final static int MIN_FREQ = 50; 
	private final static int DEFAULT_FREQ = 120; 
	private Label label;
	private Scale scale;

	private Composite composite;

	public PlayerComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		setLayout(gridLayout);

		label = new Label(this, SWT.NONE);
		scale = new Scale(this, SWT.NONE);

		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		scale.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		scale.setMaximum(MAX_FREQ);
		scale.setMinimum(MIN_FREQ);
		scale.setSelection(DEFAULT_FREQ);
		label.setSize(100, 100);
		label.setText(String.valueOf(scale.getSelection()));

		scale.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event event) {
                label.setText(String.valueOf(scale.getSelection()));
            }
        });

		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				1, 1));
	}

	public Composite getComposite() {
		return composite;
	}
}