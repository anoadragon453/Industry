package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * This class represents a certain quantity of a certain resource as a value to represent each of them. It also offers methods to represent these objects as a primitive to avoid object overhead.
 * @author Javier
 *
 */
public class Amount implements Externalizable {
	
	// Class fields --------------------------------
	
	/*
	 * TODO:
	 * MAYBE CHANGE IT TO SHORT[]
	 */
	
	/**
	 * Index of the resource within the list.
	 */
	short index;
	/**
	 * Quantity of units of this resource this amount contains.
	 */
	short quantity;
	
	// Constructors --------------------------------
	
	/**
	 * Creates a new, empty amount of the resource with the specified index in the global list of resources.
	 * @param index
	 */
	public Amount(short index) {
		this.index = index;
		this.quantity = 0;
	}
	
	/**
	 * Creates a new, empty amount of the specified resource.
	 * @param resource
	 */
	public Amount(Resource resource) {
		int index = Resource.naturalResources.indexOf(resource);
		this.index = (short) index;
		this.quantity = 0;
	}
	
	// Primitive constructors --------------------------------
	
	public static int newAmount(short index) {
		return index << 16;
	}
	
	public static int newAmount(Resource resource) {
		return Resource.naturalResources.indexOf(resource) << 16;
	}
	
	// Getters --------------------------------
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getIndex() {
		return index;
	}
	
	public Resource getResource() {
		return Resource.naturalResources.get(index);
	}
	
	// Primitive getters --------------------------------
	
	public static int getQuantity(int amount) {
		return (short)amount;
	}
	
	public static int getIndex(int amount) {
		return amount >>> 16;
	}
	
	public static Resource getResource(int amount) {
		return Resource.naturalResources.get(amount >>> 16);
	}
	
	// Methods --------------------------------
	
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
			//If quantity results to be less than 0, we move amounts back so both are non negative.
			if(this.quantity < 0) {
				if(quantity > 0) {//If positive + positive = negative, there's been an overflow
					amount.quantity = (short) (amount.quantity + this.quantity - 0x7FFF);
					this.quantity = 0x7FFF;//Maximum positive value for signed short, change if the type of primitive changes.
				} else {//If there isn't an overflow, we just return the amount necessary for neither to be negative
					amount.quantity = (short) (amount.quantity + this.quantity);
					this.quantity = 0;
				}
			}
			//If quantity results to be less than 0, we move amounts back so both are non negative.
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
	
	// Primitive methods --------------------------------
	
	/**
	 */
	public static int fork(int[] from, int fromIndex, short quantity) {
		if((short)from[fromIndex] <= quantity) {
			int ret = from[fromIndex];
			from[fromIndex] &= 0xFFFF0000;
			return ret;
		} else {
			from[fromIndex] -= quantity;
			return (from[fromIndex] & 0xFFFF0000) | quantity;
		}
	}
	
	/**
	 */
	public static boolean pile(int[] from, int fromIndex, int[] to, int toIndex, short quantity) {
		short indexFrom = (short) (from[fromIndex] >>> 16);
		short quantityFrom = (short)from[fromIndex];
		short indexTo = (short) (to[toIndex] >>> 16);
		short quantityTo = (short)to[toIndex];
		if(indexTo == indexFrom) {
			quantityTo += quantity;
			quantityFrom -= quantity;
			//If quantity results to be less than 0, we move amounts back so both are non negative.
			if(quantityTo < 0) {
				if(quantity > 0) {//If positive + positive = negative, there's been an overflow
					quantityFrom = (short) (quantityFrom + quantityTo - 0x7FFF);
					quantityTo = 0x7FFF;//Maximum positive value for signed short, change if the type of primitive changes.
				} else {//If there isn't an overflow, we just return the amount necessary for neither to be negative
					quantityFrom = (short) (quantityFrom + quantityTo);
					quantityTo = 0;
				}
			}
			//If quantity results to be less than 0, we move amounts back so both are non negative.
			if(quantityFrom < 0) {
				if(quantity < 0) {//If positive + positive = negative, there's been an overflow
					quantityTo = (short) (quantityTo + quantityFrom - 0x7FFF);
					quantityFrom = 0x7FFF;//Maximum positive value for signed short, change if the type of primitive changes.
				} else {//If there isn't an overflow, we just return the amount necessary for neither to be negative
					quantityTo = (short) (quantityTo + quantityFrom);
					quantityFrom = 0;
				}
			}
			from[fromIndex] = (indexFrom << 16) | quantityFrom;
			to[toIndex] = (indexTo << 16) | quantityTo;
			return true;
		}
		return false;
	}

	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
