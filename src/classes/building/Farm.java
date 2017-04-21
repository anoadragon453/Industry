package classes.building;

import classes.Building;
import classes.Citizen;
import classes.Player;
import classes.Resource;
import classes.World;

public class Farm extends Building {
	
	// Static fields --------------------------------
	
	private static final long serialVersionUID = -98985404371723838L;
	
	public static final String type = "farm";
	@Override public String getType() {
		return super.getType() + "." + Farm.type;
	}
	
	//TODO: PUT ACTUAL SIZE IN HERE
	public static final int size_x = 1;
	@Override public int getSize_x() {
		return size_x;
	}
	
	public static final int size_y = 1;
	@Override public int getSize_y() {
		return size_y;
	}
	
	// Upgrades --------------------------------
	
	public boolean irrigation;//humidity will always be optimal, but consumes water
	public boolean greenhouses;//temperature will always be optimal, produces constantly instead of just at harvest months
	public boolean fertilizer;//consumes fertilizer, reduces pollution and increases production
	
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
	
	public Farm(int coordinate_tile_x, int coordinate_tile_y, byte orientation, Player owner) {
		super(coordinate_tile_x, coordinate_tile_y, orientation, owner);
		this.crop = -1;
		this.growth = -1;
	}
	
	// Methods --------------------------------
	
	@Override public Citizen[] getCitizens() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* TODO:
	 *     restriction: farms can only hire farmers when their growth is 0
	 *     (Otherwise, you could keep the farm at 0 workers and hire a bunch of people at growth 11)
	 *     (No, farmers have to work from where plants can start growing and continue until they harvest)
	 */
	
	@Override public void produce(World w) {
		if(growth > 0) {
			++growth;
			//payWages();
		} else if(((w.date - Resource.naturalResources.get(crop).harvest - 1) % 12) == 0) {
			/* That is, if it's the month after harvest month for this crop,
			 * it can start increasing from 0 because the growth cycle started.
			 * If growth equals 0 and it's not such month, it can only increase again at that month
			 * because growth should start at that month only and end at harvest month.
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
				+ fertility of soil resource
				
				divide by 12 and add one if greenhouses is on
			*/
		}
		
	}
	
	//choosing a crop requires consuming a unit of that resource, the seeds to plant it don't magically pop into existence after all
	public void chooseCrop(byte resource) {
		this.crop = resource;
		this.growth = 0;
	}
	
}