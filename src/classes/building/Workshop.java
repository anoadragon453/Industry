package classes.building;

import classes.Building;
import classes.Player;

public class Workshop extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 5345796376709576100L;
	
	public static final String type = "workshop";
	@Override public String getType() {
		return super.getType() + "." + Workshop.type;
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
	
	public Workshop(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	
	
}