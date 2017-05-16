package types.knot;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Country;
import types.Knot;

public class Road extends Knot {
	
	// Static fields --------------------------------
	
	static final String type = "road";
	
	static final int reach = 16;
	
	// Class fields --------------------------------
	
	// Constructor --------------------------------
	
	public Road(int coordinate_tile_x, int coordinate_tile_y, int coordinate_tile_z, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, coordinate_tile_z, orientation, country);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Road.type;
	}
	
	@Override public int getReach() {
		return reach;
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