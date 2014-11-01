package il.ac.tau.cs.wirelesslab.composites;

import java.io.InputStream;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

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

		// Set Buttons Images
		String file = Utils.PACKAGE_PATH + Utils.getSkin() + "/Favorites.png";
		InputStream resource = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(file);
		final Image img = new Image(this.getDisplay(), resource);
		favButton1.setImage(img);
		favButton2.setImage(img);
		favButton3.setImage(img);
		favButton4.setImage(img);
		favButton5.setImage(img);

		// Set Buttons Text
		favButton1.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "1";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2 - textSize.x / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		
		// Set Buttons Text
		favButton1.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "1";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2 - textSize.x / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		favButton2.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "2";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2 - textSize.x / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		favButton3.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "3";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2 - textSize.x / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		favButton4.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "4";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2 - textSize.x / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		favButton5.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "5";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2 - textSize.x / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});

		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				NUM_OF_FAVORITES, 1));
	}

	public Composite getComposite() {
		return composite;
	}
}