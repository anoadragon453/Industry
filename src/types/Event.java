package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Event implements Externalizable {
	
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

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	//TODO: CONSIDER MAKING THIS CLASS ABSTRACT AND MAKING SUBCLASSES FOR EACH TYPE OF EVENT?
}
