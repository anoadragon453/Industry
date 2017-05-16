package types;

public abstract class Building extends Element {
	
	// Static --------------------------------
	
	static final String type = "building";
	
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
	
	public String getType() {
		return type;
	}
	
	/**
	 * Gets this building's depth.
	 * @return this building's depth
	 */
	public abstract int getSize_x();
	
	/**
	 * Gets this building's width.
	 * @return this building's width
	 */
	public abstract int getSize_y();
	
	/**
	 * Returns all the citizens in this building, both workers and users.
	 * @return All the citizens in this building, both workers and users.
	 */
	public abstract Citizen[] getCitizens();
	
	/**
	 * Production function, does whatever this building is suppossed to do.
	 * @param world World where this building is set.
	 */
	public abstract void produce(World world);
	
}
