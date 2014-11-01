package il.ac.tau.cs.wirelesslab;

import il.ac.tau.cs.wirelesslab.graphics.Utils;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = 5814113658041942393L;
	
	// 4X4TAU parameters
	private double frequency;
	private double gain;
	private int volume;
	private String skin;

	/**
	 * Construct a set of parameters
	 */
	public Data() {
		setFrequency(0);
		setGain(0);
		setVolume(0);
		setSkin(Utils.DEFAULT_SKIN); // Initialize default skin
	}
		
	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public double getGain() {
		return gain;
	}
	
	public void setGain(double gain) {
		this.gain = gain;
	}
	
	public String getSkin() {
		return skin;
	}
	
	public void setSkin(String skin) {
		this.skin = skin;
	}

}
