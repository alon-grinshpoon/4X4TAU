package il.ac.tau.cs.wirelesslab.composites;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Mixer.Info;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;

public class DevicesComposite extends Composite {
	
	public DevicesComposite(Composite parent, int style) {
		super(parent, style);
		createContents();
	}

	public void createContents() {
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		setLayout(gridLayout);

		final List list = new List(this, SWT.MULTI | SWT.BORDER);
		
		Info[] mixers = AudioSystem.getMixerInfo();
		
		for (Info info : mixers) {
			list.add(info.getName());
		}
		
		list.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e)
			{
				if (list.getSelectionCount() > 0)
				{
					System.out.println("You selected: " + list.getSelection()[0].toString());
				}
			}
		});
		final GridData listGridData = new GridData(SWT.FILL, SWT.LEFT, true, false);
		list.setLayoutData(listGridData);
		
	}
}
