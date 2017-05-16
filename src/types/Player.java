package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Player implements ProperlyNameable, Externalizable {
	
	// Static fields --------------------------------
	
	public static final String type = "player";
	
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
	
	// Methods --------------------------------
	
	public String getType() {
		return type;
	}
	
	public String getProperName() {
		return name;
	}
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO
		
	}
	
}
