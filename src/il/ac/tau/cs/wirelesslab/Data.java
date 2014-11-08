package il.ac.tau.cs.wirelesslab;

import il.ac.tau.cs.wirelesslab.composites.FavoritesComposite;
import il.ac.tau.cs.wirelesslab.graphics.Utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Data implements Serializable {

	private static final long serialVersionUID = 5814113658041942393L;
	
	// 4X4TAU parameters
	private double frequency;
	private double gain;
	private int volume;
	private String skin;
	private double[] favories;
	private List<String> skins;

	/**
	 * Construct a set of parameters
	 */
	public Data() {
		setFrequency(0);
		setGain(0);
		setVolume(0);
		setSkin(Utils.DEFAULT_SKIN); // Initialize default skin
		favories = new double[FavoritesComposite.NUM_OF_FAVORITES];
		for (int i = 0; i < FavoritesComposite.NUM_OF_FAVORITES; i++){
			favories[i] = 0;
		}
		skins = new ArrayList<>();
		skins.add(Utils.DEFAULT_SKIN);
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
	
	public void setFavorite(int i, double frequency) {
		this.favories[i-1] = frequency;
	}
	
	public double getFavorite(int i) {
		return this.favories[i-1];
	}
	
	public List<String> getSkins() {
		return skins;
	}

	public void addSkin(String skin) {
		this.skins.add(skin);
	}

}
