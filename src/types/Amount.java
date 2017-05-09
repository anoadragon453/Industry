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
	
	/**
	 * Quantity of units of this resource this amount contains.
	 */
	short quantity;
	/**
	 * Index of the resource within the list.
	 */
	short index;
	
	// Constructor --------------------------------
	
	/**
	 * Creates a new, empty amount of the resource with the specified index in the global list of resources.
	 * @param index
	 */
	public Amount(short index) {
		this.quantity = 0;
		this.index = index;
	}
	
	/**
	 * Creates a new, empty amount of the specified resource.
	 * @param resource
	 */
	public Amount(Resource resource) {
		this.quantity = 0;
		int index = Resource.naturalResources.indexOf(resource);
		this.index = (short) index;
	}
	
	// Methods --------------------------------
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getIndex() {
		return index;
	}
	
	public Resource getResource() {
		return Resource.naturalResources.get(index);
	}
	
	/**
	 * Attempts to retrieve a certain amount of resource from this Amount and returns a new Amount with the retrieved amount of the resource.
	 * @param amount Amount to be retrieved.
	 * @return A new Amount containing the amount of resource retrieved from the current amount or the whole amount if attempted to retrieve more than there is.
	 */
	public Amount fork(short quantity) {
		if(this.quantity <= quantity) {
			Amount ret = new Amount(index);
			ret.quantity = this.quantity;
			this.quantity = 0;
			return ret;
		} else {
			Amount ret = new Amount(index);
			this.quantity -= quantity;
			ret.quantity = quantity;
			return ret;
		}
	}
	
	/**
	 * Attempts to move a determined quantity of resources between two amounts until the minimum or maximum non negative values are reached on either side.
	 * @param amount Amount to be piled together with this one.
	 * @param quantity Quantity that will be attempted to be moved, the sign indicates the direction of the movement (positive, towards THIS; negative, out of THIS).
	 * @return True if the operation was successful, false if there was a mismatch between resource types.
	 */
	public boolean pile(Amount amount, short quantity) {
		if(this.index == amount.index) {
			this.quantity += quantity;
			amount.quantity -= quantity;
			//If quantity results to be less than 0, we pass 
			if(this.quantity < 0) {
				if(quantity > 0) {//If positive + positive = negative, there's been an overflow
					amount.quantity = (short) (amount.quantity + this.quantity - 0x7FFF);
					this.quantity = 0x7FFF;//Maximum positive value for signed short, change if the type of primitive changes.
				} else {//If there isn't an overflow, we just return the amount necessary for neither to be negative
					amount.quantity = (short) (amount.quantity + this.quantity);
					this.quantity = 0;
				}
			}
			
			if(amount.quantity < 0) {
				if(quantity < 0) {//If positive + positive = negative, there's been an overflow
					this.quantity = (short) (this.quantity + amount.quantity - 0x7FFF);
					amount.quantity = 0x7FFF;//Maximum positive value for signed short, change if the type of primitive changes.
				} else {//If there isn't an overflow, we just return the amount necessary for neither to be negative
					this.quantity = (short) (this.quantity + amount.quantity);
					amount.quantity = 0;
				}
			}
			
			return true;
		}
		return false;
	}
	
	public void setQuantity_TEST(short q) {
		this.quantity = q;
	}
	
}
