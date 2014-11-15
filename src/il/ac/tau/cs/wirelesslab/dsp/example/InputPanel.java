/*
*      _______                       _____   _____ _____  
*     |__   __|                     |  __ \ / ____|  __ \ 
*        | | __ _ _ __ ___  ___  ___| |  | | (___ | |__) |
*        | |/ _` | '__/ __|/ _ \/ __| |  | |\___ \|  ___/ 
*        | | (_| | |  \__ \ (_) \__ \ |__| |____) | |     
*        |_|\__,_|_|  |___/\___/|___/_____/|_____/|_|     
*                                                         
* -------------------------------------------------------------
*
* TarsosDSP is developed by Joren Six at IPEM, University Ghent
*  
* -------------------------------------------------------------
*
*  Info: http://0110.be/tag/TarsosDSP
*  Github: https://github.com/JorenSix/TarsosDSP
*  Releases: http://0110.be/releases/TarsosDSP/
*  
*  TarsosDSP includes modified source code by various authors,
*  for credits and info, see README.
* 
*/


package il.ac.tau.cs.wirelesslab.dsp.example;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

public class InputPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Mixer mixer = null;
	JFrame parentPanel = null;
	
	public InputPanel(JFrame parent){
		this();
		this.parentPanel = parent;
	}
	
	public InputPanel(){
		super(new BorderLayout());
		this.setBorder(new TitledBorder("1. Choose a microphone input"));
		JPanel buttonPanel = new JPanel(new GridLayout(0,1));
		ButtonGroup group = new ButtonGroup();
		for(Mixer.Info info : Shared.getMixerInfo(false, true)){
			JRadioButton button = new JRadioButton();
			button.setText(Shared.toLocalString(info));
			buttonPanel.add(button);
			group.add(button);
			button.setActionCommand(info.toString());
			button.addActionListener(setInput);
		}

		// Add button to select wave file from filesystem:
		JRadioButton btn = new JRadioButton();
		btn.setText("Wave file");
		group.add(btn);
		btn.addActionListener(setInput);
		btn.setActionCommand("Wave file change");
		buttonPanel.add(btn);
		
		this.add(new JScrollPane(buttonPanel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER),BorderLayout.CENTER);
		this.setMaximumSize(new Dimension(300,150));
		this.setPreferredSize(new Dimension(300,150));
	}
	
	private ActionListener setInput = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Spectrogram spec = (Spectrogram)InputPanel.this.parentPanel;
			for(Mixer.Info info : Shared.getMixerInfo(false, true)){
				if(arg0.getActionCommand().equals(info.toString())){
					if (spec != null)
					{
						spec.setFileName(null);
					}
					Mixer newValue = AudioSystem.getMixer(info);
					InputPanel.this.firePropertyChange("mixer", mixer, newValue);
					InputPanel.this.mixer = newValue;
					break;
				}
			}
			
			if (arg0.getActionCommand().equals("Wave file change"))
			{
				// Open popup dialog to select wave file:
				if (spec != null)
				{
					File file = Utils.GetFileFromDialog();
					if (file != null)
					{
						spec.setFileName(file.getAbsolutePath());
						try
						{
						spec.setNewMixer(spec.getCurrentMixer());
						}
						catch (LineUnavailableException | UnsupportedAudioFileException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	};

}
