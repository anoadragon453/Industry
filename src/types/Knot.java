package types;

public abstract class Knot extends Element {
	
	// Static fields --------------------------------
	
	static final String supertype = "knot";
	
	static final int reach = 1;
	
	// Class fields --------------------------------
	
	/**
	 * Height of the knot in the map.
	 */
	public int coordinate_tile_z;
	/**
	 * If it's false, this knot cannot be traversed.
	 */
	public boolean unlocked;
	/**
	 * Array of knots that connect to this knot.
	 */
	public Knot[] connections;
	
	// Constructors --------------------------------
	
	public Knot(int coordinate_tile_x, int coordinate_tile_y, int coordinate_tile_z, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, country);
		this.coordinate_tile_z = coordinate_tile_z;
		this.health = 1;
		this.unlocked = true;
		this.connections = new Knot[0];
	}
	
	// Object methods --------------------------------
	
	@Override public String toString() {
		return
				"[" + this.getType() +
				"@" + String.format("%11d", coordinate_tile_x) +
				"," + String.format("%11d", coordinate_tile_y) +
				"," + String.format("%11d", coordinate_tile_z) +
				";" + String.format("%4d", orientation) +
				"~" + String.format("%11d", country) +
				"]";
	}
	
	@Override public int hashCode() {
		return
				this.getType().hashCode() +
				coordinate_tile_x*31 +
				coordinate_tile_y*961 +
				coordinate_tile_z*29791 +
				country.hashCode()*923521;
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof Knot) {
			return
					this.getType() == ((Knot)object).getType() &&
					coordinate_tile_x == ((Knot)object).coordinate_tile_x &&
					coordinate_tile_y == ((Knot)object).coordinate_tile_y &&
					coordinate_tile_z == ((Knot)object).coordinate_tile_z &&
					country == ((Knot)object).country;
		}
		return false;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return supertype;
	}
	
	public int getReach() {
		return reach;
	}
	
	/**
	 * Increases the size of the connections array by one and adds the int passed as a parameter in the gap.
	 * Note this only adds the connection to this knot, it's not a mutual connection.
	 * 
	 * @param to The ID of the knot we want to connect to this one.
	 */
	public void connect(Knot to) {
		int i = 0;
		Knot[] temp = new Knot[connections.length + 1];
		while(i < connections.length) {
			temp[i] = connections[i++];
		}
		temp[i] = to;
		connections = temp;
	}
	
	/**
	 * Iterates over the connections array and copies all the remaining ints one position to the left after the first coincidence with the parameter passed and shrinks the array size by one. If there are no coincidences, it changes nothing.
	 * Note this only removes the connection from this knot, it's not a mutual disconnection.
	 * 
	 * @param from The ID of the knot we want to disconnect from this one.
	 */
	public void disconnect(Knot from) {
		if(connections.length > 0) {
			int i = 0;
			Knot[] temp = new Knot[connections.length - 1];
			while(i < connections.length) {
				if(connections[i] != from) {
					if(i < temp.length) {
						temp[i] = connections[i++];
					} else {
						i++;
					}
				} else {
					while(i < temp.length) {
						temp[i] = connections[++i];
					}
					++i;
					connections = temp;
				}
			}
		}
	}
	
	public void lock() {
		this.unlocked = false;
	}
	
	public void unlock() {
		this.unlocked = true;
	}
	
}