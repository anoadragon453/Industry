package types.building;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Building;
import types.Citizen;
import types.Country;
import types.Typed;

public class Plattenbau extends Building {
	
	// Static fields --------------------------------
	
	@Typed.Type public static final String type = "plattenbau";
	
	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public Plattenbau(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, country);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Plattenbau.type;
	}
	
	@Override public int getSize_x() {
		return size_x;
	}
	
	@Override public int getSize_y() {
		return size_y;
	}
	
	@Override public Citizen[] getCitizens() {
		return citizens;
	}
	
	@Override public void produce() {
		// TODO
	}

	@Override public void heal(int health) {
		// TODO plattenbaus increase the health of nearby buildings?
	}
	
	@Override public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO
		
	}
	
}