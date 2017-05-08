package types;

import java.io.Serializable;

public class Player implements Serializable {
	
	// Static fields --------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -933680187568468527L;
	
	// Class fields --------------------------------

	/**
	 * Name of the player
	 */
	public String name;
	/**
	 * Name of the land of the player
	 */
	public String countryName;
	/**
	 * Array of the value of opinions this player has. It determines its behavior if it's an AI or analizes it if it's a human.
	 */
	public byte[] ideology;
	
	// Constructors --------------------------------
	
	public Player(String name, String countryName) {
		this.name = name;
		this.countryName = countryName;
		this.ideology = new byte[4];
	}
	
}
