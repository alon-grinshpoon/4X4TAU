package il.ac.tau.cs.wirelesslab;

import java.awt.Toolkit;
import il.ac.tau.cs.wirelesslab.graphics.Utils;
import il.ac.tau.cs.wirelesslab.graphics.XDialog;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

/**
 * This class controls all aspects of the application's execution
 */
public class Application implements IApplication {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#start(org.eclipse.equinox.app.
	 * IApplicationContext)
	 */
	public Object start(IApplicationContext context) throws Exception {
		Display display = PlatformUI.createDisplay();
		try {
			// Initialize the program
			initialize();
			// Show splash screen
			final Splash splash = new Splash();
			splash.setVisible(true);
			// Wait
			Thread.sleep(1500);
			// Close splash screen
			splash.dispose();
			// Start the program
			int returnCode = PlatformUI.createAndRunWorkbench(display,
					new ApplicationWorkbenchAdvisor());
			if (returnCode == PlatformUI.RETURN_RESTART) {
				return IApplication.EXIT_RESTART;
			}
			return IApplication.EXIT_OK;
		} catch (Exception e) {
			new XDialog("Error", e.getMessage(), new Utils.ExitListener());
			// TODO Add logging here
			return null;
		} finally {
			// Save
			try {
				State.autoSave();
			} catch (Exception e) {
				new XDialog("Error", e.getMessage(), new Utils.ExitListener());
			}
			// Exit
			display.dispose();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.equinox.app.IApplication#stop()
	 */
	public void stop() {
		if (!PlatformUI.isWorkbenchRunning())
			return;
		final IWorkbench workbench = PlatformUI.getWorkbench();
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			public void run() {
				if (!display.isDisposed())
					workbench.close();
			}
		});
	}

	/**
	 * Initialize the program parameters and load its state.
	 * 
	 * @throws Exception
	 */
	private static void initialize() {
		// Get the user's screen size
		Utils.screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		// Load earlier state
		try {
			State.autoLoad();
		} catch (Exception e) {
			new XDialog("Error", e.getMessage());
		}
	}
}
