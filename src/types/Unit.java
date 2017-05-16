package types;

public abstract class Unit extends Element {
	
	// Static fields --------------------------------

	public static final String type = "unit";
	
	// Constructors --------------------------------
	
	public Unit(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Getters and general methods --------------------------------
	
	@Override public String toString() {
		return
				"[" + this.getType() +
				"@" + String.format("%11d", coordinate_tile_x) +
				"," + String.format("%11d", coordinate_tile_y) +
				"~" + String.format("%11d", owner) +
				"]";
	}
	
	@Override public int hashCode() {
		return
				this.getType().hashCode() +
				maxHealth*31 +
				owner.hashCode()*961;
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof Unit) {
			return
					this.getType() == ((Unit)object).getType() &&
					maxHealth == ((Unit)object).maxHealth &&
					owner == ((Unit)object).owner;
		}
		return false;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return type;
	}
	
}
