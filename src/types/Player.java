package types;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Player extends Citizen {
	
	// Static fields --------------------------------
	
	
	
	// Class fields --------------------------------
	
	
	
	// Constructors --------------------------------
	
	public Player(World world, String name, String countryName, byte age, byte sex, byte belief, byte[] ideology, Country country) {
		
		super(name, country.getGovernment(), null, null, -age, sex, belief, ideology, country);
		this.setJob(GOVERNOR, country.getGovernment());
	}
	
	// Methods --------------------------------
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		super.readExternal(in);
	}
	
	@Override public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
	}
	
}
