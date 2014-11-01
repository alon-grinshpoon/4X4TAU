package il.ac.tau.cs.wirelesslab.composites;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class SpectrogramComposite extends Composite{
	
	private Button specButton;
	private Composite composite;
	
	public SpectrogramComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}
	
	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		setLayout(gridLayout);
		
		specButton = new Button(this, SWT.NONE);
		specButton.addMouseListener(new Utils.SpectrogramMouseListener());
		specButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		specButton.setText("Spectrogram");
		
		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				1, 1));
	}
}
