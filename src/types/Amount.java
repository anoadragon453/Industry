package types;

import java.io.Serializable;

/**
 * This class represents a certain amount of a certain resource as an (int, Resource) pair.
 * @author Javier
 *
 */
public class Amount implements Serializable {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = 8091085314536647783L;
	
	// Class fields --------------------------------
	
	int amount;
	byte type;
	byte index;
	
	// Constructor --------------------------------
	
	public Amount(int amount, byte type, byte index) {
		this.amount = amount;
		this.type = type;
		this.index = index;
	}
	
	public Amount(int amount, Resource resource) {
		this.amount = amount;
		int index = Resource.naturalResources.indexOf(resource);
		int type;
		if(index < 0) {
			index = Resource.soilResources.indexOf(resource);
			if(index < 0) {
				index = Resource.mineralResources.indexOf(resource);
				if(index < 0) {
					index = Resource.manufacturedResources.indexOf(resource);
					if(index < 0) {
						type = -1;
					} else {
						type = 3;
					}
				} else {
					type = 2;
				}
			} else {
				type = 1;
			}
		} else {
			type = 0;
		}
		this.type = (byte) type;
		this.index = (byte) index;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public Resource getResource() {
		if(type == 0) {
			return Resource.naturalResources.get(index);
		}
		if(type == 1) {
			return Resource.soilResources.get(index);
		}
		if(type == 2) {
			return Resource.mineralResources.get(index);
		}
		if(type == 3) {
			return Resource.manufacturedResources.get(index);
		}
		return null;
	}
	
}
