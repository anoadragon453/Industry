package classes.unit;

import classes.Citizen;
import classes.Player;
import classes.Unit;

public class Emigrant extends Unit {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 2866769532794117907L;
	
	public static final String type = "emigrant";
	@Override public String getType() {
		return super.getType() + "." + Emigrant.type;
	}
	
	// Class fields --------------------------------
	
	public Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public Emigrant(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	
	
}