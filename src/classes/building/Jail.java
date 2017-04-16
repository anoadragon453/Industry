package classes.building;

import classes.Building;
import classes.Player;

public class Jail extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 5981480885368253338L;
	
	public static final String type = "jail";
	@Override public String getType() {
		return super.getType() + "." + Jail.type;
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
	
	public Jail(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	
	
}