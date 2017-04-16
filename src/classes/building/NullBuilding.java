package classes.building;

import classes.Amount;
import classes.Building;
import classes.Citizen;
import classes.Player;
import classes.World;

public class NullBuilding extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 436807201313575283L;
	
	public static final String type = "null";
	@Override public String getType() {
		return super.getType() + "." + NullBuilding.type;
	}
	
	// Class fields --------------------------------
	
	public final int size_x;
	@Override public int getSize_x() {
		return size_x;
	}
	
	public final int size_y;
	@Override public int getSize_y() {
		return size_y;
	}
	
	public Citizen[] citizens;
	
	public Amount[] amounts;
	
	// Constructor --------------------------------
	
	public NullBuilding(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner, int size_x, int size_y) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
		this.size_x = size_x;
		this.size_y = size_y;
		this.citizens = new Citizen[0];
	}
	
	public NullBuilding(Building building) {
		super(building.coordinate_tile_x, building.coordinate_tile_y, building.orientation, building.owner);
		this.size_x = building.getSize_x();
		this.size_y = building.getSize_y();
		this.citizens = building.getCitizens();
		//add the resource costs of that building type to "amounts"
	}
	
	// Methods --------------------------------
	
	@Override public Citizen[] getCitizens() {
		return citizens;
	}

	@Override public void produce(World w) {
	}
	
}