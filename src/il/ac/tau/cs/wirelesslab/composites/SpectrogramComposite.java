package il.ac.tau.cs.wirelesslab.composites;

import java.io.InputStream;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

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

		// Set Button Image
		String file = Utils.PACKAGE_PATH + Utils.getSkin() + "/SoundWave.png";
		InputStream resource = FavoritesComposite.class.getClassLoader().getResourceAsStream(file);
		final Image img = new Image(this.getDisplay(), resource);
		specButton.setImage(img);
		
		// Set Button Text
		specButton.addListener(SWT.Paint, new Listener() {
	        public void handleEvent(Event event) {
	            GC gc = event.gc;
	            String text = "Start Spectrogram Screen";
				Point textSize = gc.textExtent(text);
	            gc.drawText(text, img.getImageData().width / 2 - textSize.x / 2, img.getImageData().height / 2 - textSize.y, true);
	        }
	    });

		// Set Composites
		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				1, 1));
	}
}
