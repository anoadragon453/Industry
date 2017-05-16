package types;

import java.io.Externalizable;

/**
 * This class abstracts the idea of element that can be owned by a player, located in a map and damaged or destroyed.
 * @author Javier
 *
 */
public abstract class Element implements Nameable, Externalizable {
	
	// Class fields --------------------------------
	
	/**
	 * Position of the element in the world.
	 */
	public int coordinate_tile_x, coordinate_tile_y;
	/**
	 * Orientation of the element in the world.
	 */
	public byte orientation;
	/**
	 * Current health of the element.
	 */
	public int health;
	/**
	 * Maximum health of the element.
	 */
	public int maxHealth;
	/**
	 * Player whose civilization this element belongs to.
	 */
	public Player owner;
	
	// Constructors --------------------------------
	
	public Element(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		this.coordinate_tile_x = coordinate_tile_x;
		this.coordinate_tile_y = coordinate_tile_y;
		this.orientation = orientation;
		this.owner = owner;
	}
	
	// Methods --------------------------------
	
	/**
	 * @return the minimum height this element allows to be built in.
	 */
	public int getMinHeight() {
		return 0;
	}
	
	/**
	 * @return the maximum slope this element allows to be built in.
	 */
	public int getMaxSlope() {
		return 0;
	}
	
	/**
	 * Changes this element's health.
	 * @param health Number to be added to this element's health.
	 */
	public abstract void heal(int health);
	
}
