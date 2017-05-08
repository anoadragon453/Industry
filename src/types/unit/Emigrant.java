package types.unit;

import types.Citizen;
import types.Player;
import types.Unit;

public class Emigrant extends Unit {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 2866769532794117907L;
	
	static final String type = "emigrant";
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public Emigrant(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Emigrant.type;
	}
	
	public Citizen[] getCitizens() {
		return citizens;
	}
	
}