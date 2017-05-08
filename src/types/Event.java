package types;

import java.io.Serializable;

public class Event implements Serializable {
	
	// Static fields --------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9065997946320515334L;
	/**
	 * 
	 */
	private static final String type = "event";
	/**
	 * 
	 */
	
	// Class fields --------------------------------
	
	/**
	 * Identifies the month when this event took or will take place.
	 */
	public int date;
	
	// Constructors --------------------------------
	
	public Event(int date) {
		this.date = date;
	}
	
	//TODO: SUBCLASSES FOR EACH TYPE OF EVENT
}
