package il.ac.tau.cs.wirelesslab.views;

import il.ac.tau.cs.wirelesslab.composites.FavoritesComposite;
import il.ac.tau.cs.wirelesslab.graphics.Utils;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;
public class ViewFavorites extends ViewPart {

	public static final String ID = "4X4Plugin.viewFavorites";
			
	public ViewFavorites() {
		// TODO Auto-generated constructor stub
	}

	public void createPartControl(Composite parent) {
		FavoritesComposite fc = new FavoritesComposite(parent, SWT.None);
	}

	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
