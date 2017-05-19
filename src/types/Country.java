package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Typed.Typification;
import types.building.Government;

@Typed(typification = Typification.GLOBAL)
public class Country implements ProperlyNameable, Externalizable {
	
	// Static fields --------------------------------
	
	@Typed.Type public static final String type = "country";
	
	// Class fields --------------------------------
	
	public String name;
	public Government government;
	
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
	
	public Building getGovernment() {
		return government;
	}
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO
		
	}
	
}
