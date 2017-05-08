package types.building;

import types.Building;
import types.Citizen;
import types.Player;
import types.World;

public class GeothermalPlant extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 6864167820766919469L;
	
	public static final String type = "geothermalplant";

	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public GeothermalPlant(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + GeothermalPlant.type;
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
		//TODO
	}
	
}