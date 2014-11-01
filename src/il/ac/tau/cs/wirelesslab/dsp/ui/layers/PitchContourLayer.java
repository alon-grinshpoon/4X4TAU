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

package il.ac.tau.cs.wirelesslab.dsp.ui.layers;

import il.ac.tau.cs.wirelesslab.dsp.AudioDispatcher;
import il.ac.tau.cs.wirelesslab.dsp.AudioEvent;
import il.ac.tau.cs.wirelesslab.dsp.AudioProcessor;
import il.ac.tau.cs.wirelesslab.dsp.io.jvm.AudioDispatcherFactory;
import il.ac.tau.cs.wirelesslab.dsp.pitch.PitchDetectionHandler;
import il.ac.tau.cs.wirelesslab.dsp.pitch.PitchDetectionResult;
import il.ac.tau.cs.wirelesslab.dsp.pitch.PitchProcessor;
import il.ac.tau.cs.wirelesslab.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;
import il.ac.tau.cs.wirelesslab.dsp.ui.Axis;
import il.ac.tau.cs.wirelesslab.dsp.ui.CoordinateSystem;
import il.ac.tau.cs.wirelesslab.dsp.util.PitchConverter;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import javax.sound.sampled.UnsupportedAudioFileException;


public class PitchContourLayer implements Layer {
	
	private TreeMap<Double, float[]> features;
	private final CoordinateSystem cs; 
	private final Color color;
	private final int frameSize;
	private final int overlap;
	private final File audioFile;
	

	public PitchContourLayer(CoordinateSystem cs, File audioFile , Color color , int frameSize, int overlap) {
		this.features = new TreeMap<Double, float[]>();
		this.cs = cs;
		this.color = color;
		
		this.audioFile = audioFile;
		
		this.frameSize = frameSize;
		this.overlap = overlap;
		
		initialise();
	}

	public void draw(Graphics2D graphics) {
		graphics.setColor(color);
		int ovalWidth = Math.round(LayerUtilities.pixelsToUnits(graphics, 4,true));
		int ovalHeight = Math.round(LayerUtilities.pixelsToUnits(graphics, 4,false));
		
		
		// every second
		if(features !=null){
			Map<Double, float[]> submap = features.subMap(cs.getMin(Axis.X) / 1000.0,cs.getMax(Axis.X) / 1000.0);
			for (Map.Entry<Double, float[]> entry : submap.entrySet()) {
				double time = entry.getKey();// in seconds
				double pitch = entry.getValue()[0];// in cents
				if (pitch > cs.getMin(Axis.Y) && pitch < cs.getMax(Axis.Y)) {
					graphics.drawOval((int) (time * 1000), (int) pitch, ovalWidth,ovalHeight);
				}
			}
		}
	}

	
	public void initialise() {
		try {
			AudioDispatcher adp = AudioDispatcherFactory.fromFile(audioFile, frameSize,overlap);
			
			final double timeLag = frameSize / 44100.0;

			final TreeMap<Double, float[]> fe = new TreeMap<Double, float[]>();
			adp.addAudioProcessor(new PitchProcessor(
					PitchEstimationAlgorithm.FFT_YIN, 44100, frameSize,
					new PitchDetectionHandler() {
						
						public void handlePitch(
								PitchDetectionResult pitchDetectionResult,
								AudioEvent audioEvent) {
							if (pitchDetectionResult.isPitched()) {
								float[] pitch = new float[1];
								pitch[0] = (float) PitchConverter
										.hertzToAbsoluteCent(pitchDetectionResult
												.getPitch());
								fe.put(audioEvent.getTimeStamp() - timeLag,
										pitch);
							}
						}
					}));
			adp.addAudioProcessor(new AudioProcessor() {
				@Override
				public void processingFinished() {
					PitchContourLayer.this.features = fe;
				}
				
				@Override
				public boolean process(AudioEvent audioEvent) {
					return true;
				}
			});
			new Thread(adp).start();
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e2){
			e2.printStackTrace();
		}
	}

	@Override
	public String getName() {
		return "Pitch contour layer";
	}

}
