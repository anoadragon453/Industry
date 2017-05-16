package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Country implements ProperlyNameable, Externalizable {
	
	// Static fields --------------------------------
	
	public static final String type = "country";
	
	// Class fields --------------------------------
	
	public String name;
	
	// Constructors --------------------------------
	
	public Country(String name) {
		this.name = name;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return type;
	}
	
	public String getProperName() {
		return name;
	}
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO
		
	}
	
}
