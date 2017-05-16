package types.building;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Building;
import types.Citizen;
import types.Country;
import types.World;

public class WaterPump extends Building {
	
	// Static fields --------------------------------
	
	public static final String type = "waterpump";

	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public WaterPump(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, country);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + WaterPump.type;
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
	
	@Override public void produce(World world) {
		// TODO
	}

	@Override public void heal(int health) {
		// TODO
	}
	
	@Override public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO
		
	}
	
}