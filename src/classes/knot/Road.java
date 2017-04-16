package classes.knot;

import classes.Knot;
import classes.Player;

public class Road extends Knot {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -8876823176706896939L;
	
	public static final String type = "road";
	@Override public String getType() {
		return super.getType() + "." + Road.type;
	}
	
	public static final int reach = 16;
	@Override public int getReach() {
		return reach;
	}
	
	// Class fields --------------------------------
	
	// Constructor --------------------------------
	
	public Road(int coordinate_tile_x, int coordinate_tile_y, int coordinate_tile_z, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, coordinate_tile_z, orientation, owner);
	}
	
	// Methods --------------------------------
	
	
	
}