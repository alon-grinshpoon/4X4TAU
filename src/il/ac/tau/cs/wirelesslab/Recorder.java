package il.ac.tau.cs.wirelesslab;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import javax.sound.sampled.*;

import java.io.File;

/**
 * Sample audio recorder
 */
public class Recorder extends Thread
{
    /**
     * The TargetDataLine that we’ll use to read data from
     */
    private TargetDataLine line;

    /**
     * The audio format type that we’ll encode the audio data with
     */
    private AudioFileFormat.Type targetType = AudioFileFormat.Type.WAVE;

    /**
     * The AudioInputStream that we’ll read the audio data from
     */
    private AudioInputStream inputStream;

    /**
     * The file that we’re going to write data out to
     */
    private File file;

    AudioFormat getAudioFormat() {
        float sampleRate = 16000;
        int sampleSizeInBits = 8;
        int channels = 2;
        boolean signed = true;
        boolean bigEndian = true;
        AudioFormat format = new AudioFormat(sampleRate, sampleSizeInBits,
                                             channels, signed, bigEndian);
        return format;
    }
    
    /**
     * Creates a new Audio Recorder
     */
    public Recorder( String outputFilename )
    {
	  try
	  {  
		  	AudioFormat audioFormat = getAudioFormat();
            // Create our TargetDataLine that will be used to read audio data by first 
            // creating a DataLine instance for our audio format type
            Mixer mixer = Utils.GetMixerFromString(il.ac.tau.cs.wirelesslab.State.getData().getMixer());
            DataLine.Info info = new DataLine.Info( TargetDataLine.class, audioFormat );
            // Next we ask the AudioSystem to retrieve a line that matches the 
            // DataLine Info
            //this.line = ( TargetDataLine )AudioSystem.getLine( info );
       
            this.line = (TargetDataLine) mixer.getLine(info);
            // Open the TargetDataLine with the specified format
            if (!mixer.isLineSupported(info)) {
                System.out.println("Line not supported");
                return;
            }

            this.line.open( audioFormat );

            // Create an AudioInputStream that we can use to read from the line
            this.inputStream = new AudioInputStream( this.line );

            // Create the output file
            this.file = new File( outputFilename );
        }
	  catch( Exception e )
	  {
	      e.printStackTrace();
	  }
    }

    public void startRecording()
    {
        // Start the TargetDataLine
        this.line.start();

        // Start our thread
        start();
    }

    public void stopRecording()
    {
        // Stop and close the TargetDataLine
        this.line.stop();
        this.line.close();
    }

    public void run()
    {
        try
        {
            // Ask the AudioSystem class to write audio data from the audio input stream
            // to our file in the specified data type (PCM 44.1Khz, 16-bit, stereo)
            AudioSystem.write( this.inputStream, this.targetType, this.file );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}