package classes;

import java.util.ArrayList;

public abstract class Building extends Element {
	
	// Static --------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5709394369261277463L;
	
	public static final String type = "building";
	public String getType() {
		return type;
	}
	
	public abstract int getSize_x();
	
	public abstract int getSize_y();
	
	// Constructors --------------------------------
	
	public Building(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}

	// Object methods --------------------------------
	
	@Override public String toString() {
		return
				"[" + this.getType() +
				"@" + String.format("%11d", coordinate_tile_x) +
				"," + String.format("%11d", coordinate_tile_y) +
				";" + String.format("%4d", orientation) +
				"~" + String.format("%11d", owner) +
				"]";
	}
	
	@Override public int hashCode() {
		return
				this.getType().hashCode() +
				coordinate_tile_x*31 +
				coordinate_tile_y*961 +
				orientation*29791 +
				owner.hashCode()*923521;
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof Building) {
			return
					this.getType() == ((Building)object).getType() &&
					coordinate_tile_x == ((Building)object).coordinate_tile_x &&
					coordinate_tile_y == ((Building)object).coordinate_tile_y &&
					orientation == ((Building)object).orientation &&
					owner == ((Building)object).owner;
		}
		return false;
	}
	
	// Methods --------------------------------
	
	/*
	 * TODO: Must be overriden such that it returns workers or users of a building implementation.
	 */
	public abstract Citizen[] getCitizens();
	
	public abstract void produce(World w);
	
}
