package types;

import java.io.Externalizable;

import types.Typed.Typification;

@Typed(typification = Typification.CLASS)
public abstract class Event implements Nameable, Externalizable {
	
	// Static fields --------------------------------
	
	private static final String type = "event";
	
	// Class fields --------------------------------
	
	/**
	 * Identifies the month when this event took or will take place.
	 */
	public int date;
	
	// Constructors --------------------------------
	
	public Event(int date) {
		this.date = date;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return type;
	}
	
}
