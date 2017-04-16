package classes;

import java.io.Serializable;

public class Trade implements Serializable {
	
	// Static fields --------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6139817619125355722L;
	
	// Class fields --------------------------------
	
	public Player seller;
	public Player buyer;
	public Amount[] amounts;
	public int monthsRemaining;
	
	// Constructors --------------------------------
	
	public Trade(Player seller, Player buyer, Amount[] amounts, int duration) {
		this.seller = seller;
		this.buyer = buyer;
		this.amounts = amounts;
		this.monthsRemaining = duration;
	}
	
}
