package il.ac.tau.cs.wirelesslab.composites;

import java.io.InputStream;

import javax.swing.JOptionPane;

import il.ac.tau.cs.wirelesslab.Data;
import il.ac.tau.cs.wirelesslab.State;
import il.ac.tau.cs.wirelesslab.graphics.Utils;
import il.ac.tau.cs.wirelesslab.views.ViewPlayer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class FavoritesComposite extends Composite {
	private Button loadFavButton1;
	private Button loadFavButton2;
	private Button loadFavButton3;
	private Button loadFavButton4;
	private Button loadFavButton5;
	private Button saveFavButton1;
	private Button saveFavButton2;
	private Button saveFavButton3;
	private Button saveFavButton4;
	private Button saveFavButton5;

	public final static int NUM_OF_FAVORITES = 5;

	private Composite composite;

	public FavoritesComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = NUM_OF_FAVORITES;
		setLayout(gridLayout);

		loadFavButton1 = new Button(this, SWT.PUSH);
		loadFavButton2 = new Button(this, SWT.PUSH);
		loadFavButton3 = new Button(this, SWT.PUSH);
		loadFavButton4 = new Button(this, SWT.PUSH);
		loadFavButton5 = new Button(this, SWT.PUSH);
		saveFavButton1 = new Button(this, SWT.PUSH);
		saveFavButton2 = new Button(this, SWT.PUSH);
		saveFavButton3 = new Button(this, SWT.PUSH);
		saveFavButton4 = new Button(this, SWT.PUSH);
		saveFavButton5 = new Button(this, SWT.PUSH);

		loadFavButton1.addMouseListener(new LoadFavoritesMouseListener(1));
		loadFavButton2.addMouseListener(new LoadFavoritesMouseListener(2));
		loadFavButton3.addMouseListener(new LoadFavoritesMouseListener(3));
		loadFavButton4.addMouseListener(new LoadFavoritesMouseListener(4));
		loadFavButton5.addMouseListener(new LoadFavoritesMouseListener(5));
		saveFavButton1.addMouseListener(new SaveFavoritesMouseListener(1));
		saveFavButton2.addMouseListener(new SaveFavoritesMouseListener(2));
		saveFavButton3.addMouseListener(new SaveFavoritesMouseListener(3));
		saveFavButton4.addMouseListener(new SaveFavoritesMouseListener(4));
		saveFavButton5.addMouseListener(new SaveFavoritesMouseListener(5));

		loadFavButton1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		loadFavButton2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		loadFavButton3.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		loadFavButton4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));
		loadFavButton5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
				false));

		// Set Buttons Images
		String file = Utils.PACKAGE_PATH + Utils.getSkin() + "/Favorites.png";
		InputStream resource = FavoritesComposite.class.getClassLoader()
				.getResourceAsStream(file);
		final Image img = new Image(this.getDisplay(), resource);
		loadFavButton1.setImage(img);
		loadFavButton2.setImage(img);
		loadFavButton3.setImage(img);
		loadFavButton4.setImage(img);
		loadFavButton5.setImage(img);
		
		// Set Buttons Text
		loadFavButton1.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "1";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		loadFavButton2.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "2";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		loadFavButton3.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "3";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		loadFavButton4.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "4";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		loadFavButton5.addListener(SWT.Paint, new Listener() {
			public void handleEvent(Event event) {
				GC gc = event.gc;
				String text = "5";
				Point textSize = gc.textExtent(text);
				gc.drawText(text,
						img.getImageData().width / 2,
						img.getImageData().height / 2 - textSize.y, true);
			}
		});
		saveFavButton1.setText("Save");
		saveFavButton2.setText("Save");
		saveFavButton3.setText("Save");
		saveFavButton4.setText("Save");
		saveFavButton5.setText("Save");
		
		composite = new Composite(this, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true,
				NUM_OF_FAVORITES, 1));
	}

	public Composite getComposite() {
		return composite;
	}
	
	public class LoadFavoritesMouseListener implements MouseListener {

		private int station;
		
		public LoadFavoritesMouseListener(int station) {
			this.station = station;
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {

		}

		@Override
		public void mouseDown(MouseEvent e) {
			
		}

		@Override
		public void mouseUp(MouseEvent e) {
			// Load favorite station
			Data data = State.getData();
			double favorive = data.getFavorite(this.station);
			data.setFrequency(favorive);
		}

	}
	
	public class SaveFavoritesMouseListener implements MouseListener {

		private int station;
		
		public SaveFavoritesMouseListener(int station) {
			this.station = station;
		}

		@Override
		public void mouseDoubleClick(MouseEvent e) {

		}

		@Override
		public void mouseDown(MouseEvent e) {
			
		}

		@Override
		public void mouseUp(MouseEvent e) {
			// Save favorite station
			Data data = State.getData();
			double frequency = data.getFrequency();
			data.setFavorite(this.station, frequency);
			JOptionPane.showMessageDialog(null, "Frequency saved in favorite " + this.station + "!", "OK", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}