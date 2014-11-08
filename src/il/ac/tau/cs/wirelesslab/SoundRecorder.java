package il.ac.tau.cs.wirelesslab;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;

public class SoundRecorder {
    // record duration, in milliseconds
    public static final long RECORD_TIME = 10000;  // 1 minute
 
    // path of the wav file
    File wavFile = new File("E:/Test/RecordAudio.wav");
 
    // format of audio file
    AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE;
 
    // the line from which audio data is captured
    TargetDataLine line;
    Mixer mixer = null;
    
    public SoundRecorder(File file, Mixer mixer)
    {
    	this.wavFile = file;
    	this.mixer = mixer;
    }
    
    
    /**
     * Defines an audio format
     */
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
     * Captures the sound and record into a WAV file
     */
    public void Start() {
        try {
            AudioFormat format = getAudioFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, format);
 
            // checks if mixer supports the data line
            if (!mixer.isLineSupported(info)) {
                System.out.println("Line not supported");
                System.exit(0);
            }
            line = (TargetDataLine) mixer.getLine(info);
            line.open(format);
            line.start();   // start capturing
 
            System.out.println("Start capturing...");
 
            AudioInputStream ais = new AudioInputStream(line);
 
            System.out.println("Start recording...");
 
            // start recording
            AudioSystem.write(ais, fileType, wavFile);
 
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
 
    /**
     * Closes the target data line to finish capturing and recording
     */
    public void Finish() {
        line.stop();
        line.close();
        System.out.println("Finished");
    }
 
    /**
     * Entry to run the program
     */
//    public static void main(String[] args) {
//        final SoundRecorder recorder = new SoundRecorder();
// 
//        // creates a new thread that waits for a specified
//        // of time before stopping
//        Thread stopper = new Thread(new Runnable() {
//            public void run() {
//                try {
//                    Thread.sleep(RECORD_TIME);
//                } catch (InterruptedException ex) {
//                    ex.printStackTrace();
//                }
//                recorder.finish();
//            }
//        });
// 
//        stopper.start();
// 
//        // start recording
//        recorder.start();
//    }
}