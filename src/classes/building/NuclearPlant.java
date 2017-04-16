package classes.building;

import classes.Building;
import classes.Player;

public class NuclearPlant extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -3325535227972275637L;
	
	public static final String type = "nuclearplant";
	@Override public String getType() {
		return super.getType() + "." + Shipyard.type;
	}
	
	//TODO: PUT ACTUAL SIZE IN HERE
	public static final int size_x = 1;
	@Override public int getSize_x() {
		return size_x;
	}
	
	public static final int size_y = 1;
	@Override public int getSize_y() {
		return size_y;
	}
	
	// Class fields --------------------------------
	
	// Constructor --------------------------------
	
	public NuclearPlant(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + NuclearPlant.type;
	}
	
}