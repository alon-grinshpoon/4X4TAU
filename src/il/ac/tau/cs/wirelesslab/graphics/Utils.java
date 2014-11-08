package il.ac.tau.cs.wirelesslab.graphics;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.Mixer.Info;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

import il.ac.tau.cs.wirelesslab.SoundRecorder;
import il.ac.tau.cs.wirelesslab.State;
import il.ac.tau.cs.wirelesslab.composites.RecordComposite;
import il.ac.tau.cs.wirelesslab.dsp.example.OscilloscopePanel;
import il.ac.tau.cs.wirelesslab.dsp.example.Spectrogram;
import il.ac.tau.cs.wirelesslab.views.ViewSpectrogram;

public class Utils {

	public static Dimension screenSize;
	public final static int MESSAGE_WIDTH = 250;
	public final static int MESSAGE_HEIGHT = 100;
	public final static int BUTTON_WIDTH = 90;
	public final static int BUTTON_HEIGHT = 50;
	public final static String DEFAULT_FILE_NAME = "4X4TAU.dsp";
	public final static String DEFAULT_SKIN = "graphics/skins/default/";
	public final static String PACKAGE_PATH = "/il/ac/tau/cs/wirelesslab/";

	/**
	 * Returns the current skin.
	 */
	public static String getSkin(){
		return State.getData().getSkin();
	}
	
	/**
	 * Exit action listener to shutdown to program.
	 */
	public static class ExitActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			try {
				State.autoSave();
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
			System.exit(0);
		}
	}
	
	public static File GetFileFromDialog()
	{
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		  return fileChooser.getSelectedFile();
		}
		else
		{
			return null;
		}
	}
	
	public static Mixer GetMixerFromString(String mixerName)
	{
		Info[] mixersInfos = AudioSystem.getMixerInfo();
		for (Info info : mixersInfos) {
			if (info.getName().equals(mixerName))
			{
				return AudioSystem.getMixer(info);
			}
		}
		return null;
	}
	
	/**
	 * Exit mouse listener to shutdown to program.
	 */
	public static class ExitMouseListener implements MouseListener{

		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseUp(MouseEvent e) {
			try {
				State.autoSave();
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
			System.exit(0);
		}
	}
	
	public static class SpectrogramMouseListener implements MouseListener{
		public void mouseDoubleClick(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		public void mouseUp(MouseEvent e) {
			try {
				if (ViewSpectrogram.spectrogram == null)
				{
					ViewSpectrogram.spectrogram = new Spectrogram(null);
					ViewSpectrogram.spectrogram.pack();
					ViewSpectrogram.spectrogram.setSize(1024, 768);
					ViewSpectrogram.spectrogram.setVisible(true);
					ViewSpectrogram.spectrogram.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				}
				else
				{
					ViewSpectrogram.spectrogram.setVisible(true);
				}
				
			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
		}
	}
	
	public static class RecordButtonMouseListener implements MouseListener
	{

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
			JFileChooser fileChooser = new JFileChooser();
			File file = null;
			if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
			}
			if (file != null)
			{
				if (State.getData().getMixer() != null)
				{
					Mixer mixer = GetMixerFromString(State.getData().getMixer());
					final SoundRecorder recorder = new SoundRecorder(file, mixer);
			        // creates a new thread that waits for a specified
			        // of time before stopping
			        Thread stopper = new Thread(new Runnable() {
			            public void run() {
			                try {
			                    Thread.sleep(SoundRecorder.RECORD_TIME);
			                } catch (InterruptedException ex) {
			                    ex.printStackTrace();
			                }
			                recorder.Finish();
			            }
			        });
			 
			        stopper.start();
			 
			        // start recording
			        recorder.Start();
			    }
				}
				else
				{
					AudioFormat format = new AudioFormat(8000.0f, 16, 1, true, true);
				    try {
						TargetDataLine microphone = AudioSystem.getTargetDataLine(format);
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
	
	public static class StopButtonMouseListener implements MouseListener{

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
			RecordComposite.setRecording(false);
		}
	}
	
	public static class OscilloscopeButtonMouseListener implements MouseListener
	{

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
			try {
				if (ViewSpectrogram.oscilloscope == null)
				{
					ViewSpectrogram.oscilloscope = new OscilloscopePanel();
					ViewSpectrogram.oscilloscope.pack();
					ViewSpectrogram.oscilloscope.setSize(1024, 768);
					ViewSpectrogram.oscilloscope.setVisible(true);
					ViewSpectrogram.oscilloscope
							.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
				} 
				else 
				{
					ViewSpectrogram.oscilloscope.setVisible(true);
				}

			} catch (Exception exception) {
				new XDialog("Error", exception.getMessage());
			}
		}
		
	}
}


