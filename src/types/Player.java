package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Player extends Citizen {
	
	// Static fields --------------------------------
	
	
	
	// Class fields --------------------------------
	
	
	
	// Constructors --------------------------------
	
	public Player(World world, String name, String countryName, byte sex, byte belief, byte[] ideology, Country country) {
		
		super(name, country.getGovernment(), null, null, 0, sex, belief, ideology, country);
		/*
		 * TODO:
		 * initialize a new country
		 * create its basic buildings
		 * ...
		 */
		
		/*
		 * construct a citizen with
		 * 		null, null as parents and
		 * 		the palace as house and workplace
		 * 		the new country as country
		 * 		a specified ideology as ideology
		 * 		type being whatever type stands for "chairman" or "state ruler" or whatever
		 */
		
	}
	
	// Methods --------------------------------
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO
		
	}
	
}
