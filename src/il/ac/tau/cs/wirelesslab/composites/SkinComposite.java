package il.ac.tau.cs.wirelesslab.composites;

import javax.swing.JOptionPane;

import il.ac.tau.cs.wirelesslab.State;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

public class SkinComposite extends Composite {

	private Button addButton;
	
	public SkinComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		setLayout(gridLayout);

		final List list = new List(this, SWT.MULTI | SWT.BORDER);
		addButton = new Button(this, SWT.PUSH);
		
		for (String skin : State.getData().getSkins()) {
			list.add(skin);
		}
		
		addButton.setText("Add skin");
		addButton.addMouseListener(new AddSkinMouseListener(list));
		
		list.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e)
			{
				if (list.getSelectionCount() > 0)
				{
					System.out.println("You selected this skin: " + list.getSelection()[0].toString());
					// Set Skin
					State.getData().setSkin(list.getSelection()[0].toString() );
				}
			}
		});
		final GridData listGridData = new GridData(SWT.FILL, SWT.LEFT, true, false);
		list.setLayoutData(listGridData);
	}
	
	public class AddSkinMouseListener implements MouseListener {

		private List list;
		public AddSkinMouseListener(List list) {
			this.list = list;
		}

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
			String newSkin = JOptionPane.showInputDialog(null, "Enter new skin path:", "");
			// Add Skin
			State.getData().addSkin(newSkin);
			//SkinComposite.refreshList(this.list);
			list.add(newSkin);
			list.update();
			list.redraw();
		}

	}

	public static void refreshList(List list) {
		list.removeAll();
		for (String skin : State.getData().getSkins()) {
			list.add(skin);
		}
		list.update();
		list.redraw();
	}
}