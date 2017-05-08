package types.building;

import types.Building;
import types.Citizen;
import types.Player;
import types.World;

public class AircraftFactory extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -4747822762785053447L;
	
	static final String type = "aircraftfactory";
	
	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public AircraftFactory(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
		this.citizens = new Citizen[0];
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + AircraftFactory.type;
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