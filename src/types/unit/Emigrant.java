package types.unit;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Citizen;
import types.Country;
import types.Unit;

public class Emigrant extends Unit {
	
	// Static fields --------------------------------
	
	static final String type = "emigrant";
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public Emigrant(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, country);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Emigrant.type;
	}
	
	public Citizen[] getCitizens() {
		return citizens;
	}
	
	@Override public void heal(int health) {
		// TODO
		
	}
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO
		
	}
	
	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO
		
	}
	
}