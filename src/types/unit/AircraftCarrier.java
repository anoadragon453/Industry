package types.unit;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Citizen;
import types.Player;
import types.Unit;

public class AircraftCarrier extends Unit {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -5795306635112866479L;
	
	static final String type = "aircraftcarrier";
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	Unit[] unitsCarried;
	
	// Constructor --------------------------------
	
	public AircraftCarrier(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
		this.citizens = new Citizen[0];
		this.unitsCarried = new Unit[0];
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + AircraftCarrier.type;
	}
	
	public Citizen[] getCitizens() {
		return citizens;
	}
	
	public Unit[] getUnitsCarried() {
		return unitsCarried;
	}
	
	@Override public void heal(int health) {
		// TODO
		
	}
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO
		
	}
	
	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO
		
	}
	
}