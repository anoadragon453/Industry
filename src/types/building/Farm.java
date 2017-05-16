package types.building;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import types.Building;
import types.Citizen;
import types.Country;
import types.Resource;
import types.World;

public class Farm extends Building {
	
	// Static fields --------------------------------
	
	public static final String type = "farm";

	static final int size_x = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	static final int size_y = 1;//TODO: PUT ACTUAL SIZE IN HERE
	
	// Class fields --------------------------------
	
	Citizen[] citizens;
	
	// Upgrades --------------------------------
	
	public boolean irrigation;//humidity will always be optimal, but consumes water
	public boolean greenhouses;//temperature will always be optimal, produces constantly instead of just at harvest months
	public boolean fertilizer;//soil quality will always be optimal and reduces pollution but consumes fertilizer
	
	// Class fields --------------------------------
	
	public byte crop;
	/**
	 * Genetic profile of the crop:
	 * -------1 : Frost resistance: can still produce under the accepted temperature level, but with low productivity.
	 * ------1- : Heat resistance: can still produce over the accepted temperature level, but with low productivity.
	 * -----1-- : Drought resistance: can still produce under the accepted humidity level, but with low productivity.
	 * ----1--- : Flood resistance: can still produce over the accepted humidity level, but with low productivity.
	 * ---1---- : Pest resistance: resists pests.
	 * --1----- : Hyperadaptability: doesn't pollute.
	 * 11------ : Extra production
	 */
	public byte genetic;
	public byte growth;
	
	// Constructor --------------------------------
	
	public Farm(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Country country) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, country);
		this.crop = -1;
		this.growth = -1;
	}
	
	// Methods --------------------------------
	
	@Override public String getType() {
		return super.getType() + "." + Farm.type;
	}
	
	@Override public int getSize_x() {
		return size_x;
	}
	
	@Override public int getSize_y() {
		return size_y;
	}
	
	@Override public Citizen[] getCitizens() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* TODO:
	 *     restriction: farms can only hire farmers when their growth is 0
	 *     (Otherwise, you could keep the farm at 0 workers and hire a bunch of people at growth 11)
	 *     (No, farmers have to work from where plants can start growing and continue until they harvest)
	 */
	
	@Override public void produce(World world) {
		if(growth > 0) {
			++growth;
			//payWages();
		} else if(true) {
			/* TODO: CHECK IF THIS MONTH AT THIS PLACE IS WARM ENOUGH FOR THE CROP TO START GROWING
			 * THEN THE CROP MAY START GROWING, ELSE IT STAYS AT 0 UNTIL WARM ENOUGH
			 */
			++growth;
			//payWages();
		}
		if(growth >= 12) {//Shouldn't really ever be higher than 12, but just in case.
			if(greenhouses) {
				growth = 11;
			} else {
				growth = 0;
			}
			
			/*	for every tile in a certain radius, up to the amount of tiles the amount of farmers can work with their tools and experience
				produce the following amount of crop:
				
				base production per tile
				+ versatility of resource
				- absolute difference between temperature and optimal temperature, or 0 if greenhouses is on
				- absolute difference between humidity and optimal humidity, or 0 if irrigation is on and there's water to maintain the crop
				+ fertility of soil resource, optimal if fertilizer is on
				
				divide by 12 and add one if greenhouses is on
			*/
		}
		
	}
	
	//choosing a crop requires consuming a unit of that resource, the seeds to plant it don't magically pop into existence after all
	public void chooseCrop(byte resource) {
		this.crop = resource;
		this.growth = 0;
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