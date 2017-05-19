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
	
	/**
	 * World this country is part of.
	 */
	public World world;
	/**
	 * Name of this country.
	 */
	public String name;
	/**
	 * Government building of this country.
	 */
	public Government government;
	/**
	 * Code of laws of this country, represented as an array of the punishment for each act in months of jail, 0 if it's legal.
	 */
	public int[] laws;
	
	// Constructors --------------------------------
	
	public Country(World world, String name) {
		this.name = name;
		/*
		 * TODO: Generate country in the world with buildings and stuff
		 * this.government = wherever the government building was created.
		 */
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
