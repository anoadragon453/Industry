package types.building;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Building;
import types.Citizen;
import types.Player;
import types.World;

public class Hospital extends Building {
	
	// Static fields --------------------------------
	
	public static final String type = "hospital";

	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Constructor --------------------------------
	
	public Hospital(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Hospital.type;
	}
	
	@Override public int getSize_x() {
		return size_x;
	}
	
	@Override public int getSize_y() {
		return size_y;
	}
	
	@Override public Citizen[] getCitizens() {
		return citizens;
	}
	
	@Override public void produce(World world) {
		/*
		 * TODO:
		 * 
		 * for Citizen worker in this.workers:
		 *     for as many patients as a doctor can have:
		 *         pick a citizen c among all citizens living in the area
		 *         if(c.isSick() && worker.getType() == "citizen.physician")://doctors give part of the health diseases remove
		 *             c.health += ( worker.skill[index of biology skill] / maxSkill ) * c.getSickness().lethality
		 *             building.consume(1 of medicine)
		 *         else://nurses increase health by 1 regardless
		 *             c.health += 1
		 *             building.consume(1 of medicine)
		 */
	}
	
	@Override public void heal(int health) {
		// TODO
	}
	
	@Override public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// TODO
		
	}

	@Override public void writeExternal(ObjectOutput arg0) throws IOException {
		// TODO
		
	}
}