package types.building;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Amount;
import types.Building;
import types.Citizen;
import types.Player;
import types.World;

public class Ruin extends Building {
	
	// Static fields --------------------------------
	
	static final String type = "ruin";
	
	// Class fields --------------------------------
	
	final int size_x;
	
	final int size_y;
	
	Citizen[] citizens;
	
	Amount[] amounts;
	
	// Constructor --------------------------------
	
	public Ruin(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner, int size_x, int size_y) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
		this.size_x = size_x;
		this.size_y = size_y;
		this.citizens = new Citizen[0];
	}
	
	public Ruin(Building building) {
		super(building.coordinate_tile_x, building.coordinate_tile_y, building.orientation, building.owner);
		this.size_x = building.getSize_x();
		this.size_y = building.getSize_y();
		this.citizens = building.getCitizens();
		//add the resource costs of that building type to "amounts"
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Ruin.type;
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

	@Override public void produce(World w) {
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