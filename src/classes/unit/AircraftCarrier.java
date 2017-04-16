package classes.unit;

import classes.Citizen;
import classes.Player;
import classes.Unit;

public class AircraftCarrier extends Unit {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -5795306635112866479L;
	
	public static final String type = "aircraftcarrier";
	@Override public String getType() {
		return super.getType() + "." + AircraftCarrier.type;
	}
	
	// Class fields --------------------------------
	
	public Citizen[] citizens;
	public Unit[] unitsCarried;
	
	// Constructor --------------------------------
	
	public AircraftCarrier(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	
	
}