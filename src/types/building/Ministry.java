package types.building;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Building;
import types.Citizen;
import types.Country;
import types.Typed;
import types.Typed.Typification;
import types.World;

@Typed(typification = Typification.FIELD)
public class Ministry extends Building {
	
	// Static fields --------------------------------
	
	@Typed.Type public static final String supertype = "ministry";

	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	public String type;
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public Ministry(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, country);
		type = "";
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Ministry.supertype + this.type;
	}
	
	@Override public int getSize_x() {
		return size_x;
	}
	
	@Override public int getSize_y() {
		return size_y;
	}
	
	public void setType(String type) {
		this.type = type;
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