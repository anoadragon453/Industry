package classes.building;

import classes.Building;
import classes.Player;

public class BiomassPlant extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -7876677463647706905L;
	
	public static final String type = "biomassplant";
	@Override public String getType() {
		return super.getType() + "." + BiomassPlant.type;
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
	
	public BiomassPlant(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	
	
}