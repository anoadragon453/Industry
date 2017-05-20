package types;

import integerMath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Externalizable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author	Javier Centeno Vega <jacenve@telefonica.net>
 * @version	0.0
 * @since	0.0
 */
public class World implements Externalizable {
	/**
	 * Terms used in this code
	 * 
	 * tile                 : set of values assignated to a certain point of the arrays of values of a tectonic plate
	 * tectonic plate       : block of tiles of a specific size
	 * province             : see tectonic plate
	 * 
	 * index_plate_x        : absolute index of a plate in the x axis with respect to the [0][0] point of the array
	 * index_plate_y        : absolute index of a plate in the y axis with respect to the [0][0] point of the array
	 * index_tile_x         : absolute index of a tile in the x axis with respect to the [0][0].[0][0] point of the array
	 * index_tile_y         : absolute index of a tile in the y axis with respect to the [0][0].[0][0] point of the array
	 * index_tile_z         : absolute value of the height field of a tile
	 * subindex_tile_x      : absolute index of a tile in the x axis with respect to the point .[0][0] of the plate which contains it.
	 * subindex_tile_y      : absolute index of a tile in the y axis with respect to the point .[0][0] of the plate which contains it.
	 * relativeindex_tile_x : relative index of a tile in the x axis with respect to the point .[0][0] of a specific plate
	 * relativeindex_tile_y : relative index of a tile in the y axis with respect to the point .[0][0] of a specific plate
	 * coordinate_plate_x   : relative index of a plate in the x axis with respect to the plates containing the tiles with index [-][mid_tile_x] in the array
	 * coordinate_plate_y   : relative index of a plate in the y axis with respect to the plates containing the tiles with index [mid_tile_y][-] in the array
	 * coordinate_tile_x    : relative index of a tile in the x axis with respect to the tiles with index [-][mid_tile_x]
	 * coordinate_tile_y    : relative index of a tile in the y axis with respect to the tiles with index [mid_tile_y][-]
	 * coordinate_tile_z    : relative value of the height field of a tile with respect to the sea level
	 * max_plate_x          : maximum absolute index of a plate in the x axis
	 * max_plate_y          : maximum absolute index of a plate in the y axis
	 * max_tile_z           : maximum variation of the height value that can be caused on a tile
	 * mid_tile_x           : absolute x index of the tiles with x coordinate 0
	 * mid_tile_y           : absolute y index of the tiles with y coordinate 0
	 * mid_tile_z           : absolute height value considered to be the coordinate 0 in the z axis
	 * greenwich            : see mid_tile_x
	 * equator              : see mid_tile_y
	 * sea level            : see mid_tile_z
	 * peak                 : x, y point of a plate around which its height function is applied
	 * land plate           : plate with peak height > mid_tile_z
	 * wet plate            : plate with peak height < mid_tile_z
	 * island               : group of interconnected land plates
	 * ocean                : group of interconnected wet plates
	 * continental shelf    : wet plate adjacent to a land plate
	 * sea                  : wet plate
	 * hill                 : land plate with higher peak height than the average of its surrounding plates
	 * valley               : land plate with lower peak height than the average of its surrounding plates
	 * continent            : an island and its continental shelf
	 * isthmus              : land plate sandwiched between two land plates in one direction and two sea plates in another direction
	 */
	
	// Class fields --------------------------------
	
	/**
	 * String that uniquely identifies the version of the game.
	 */
	public final String version;
	/**
	 * Folder where this world is saved in the file system.
	 */
	public String directory;
	/**
	 * Current date in months of the map.
	 */
	public int date;
	/**
	 * Seed used by the Map for generation.
	 */
	public final int seed;
	/**
	 * Size of the tectonic plates.
	 */
	public final int tectonicPlateSize;
	/**
	 * Maximum radius of influence of a tectonic plate on geography in number of tectonic plates.
	 */
	public final int maxTectonicPlateInfluence;
	/**
	 * Minimum radius of influence of a tectonic plate on geography in number of tectonic plates.
	 */
	public final int minTectonicPlateInfluence;
	/**
	 * Thickness of the crust, difference between the same values of the magma level and land and water levels.
	 * If magma level at a tile is bigger than the sum of crust thickness and land level, magma surfaces.
	 */
	public final int crustThickness;
	/**
	 * Whether the map cycles around the array of plates.
	 */
	public boolean cycle_x;
	public boolean cycle_y;
	/**
	 * Maximum horizontal size of the map in tectonic plates. -1 if infinite.
	 */
	public int max_plate_x;
	/**
	 * Maximum vertical size of the map in tectonic plates. -1 if infinite.
	 */
	public int max_plate_y;
	/**
	 * Maximum altitude of mountains. Note that this isn't necessarily the absolute maximum altitude as mountains may overlap.
	 */
	public int max_tile_z;
	/**
	 * X axis value considered to be the middle longitude or "greenwich". Can be outside of the limits of the map.
	 */
	public int mid_tile_x;
	/**
	 * Y axis value of tiles whose tectonic plates have peak temperature, considered to be the middle latitude or equator. Can be outside of the limits of the map.
	 */
	public int mid_tile_y;
	/**
	 * Z axis value considered to be the middle altitude or sea level.
	 */
	public byte mid_tile_z;
	/**
	 * Mid_temperature: Temperature of the map at mid_y (in the equator).
	 * Edge_temperatureDifference: Temperature in the edge - temperature at the equator.
	 * Height_temperatureVariation: Difference of height that implies an increase of 1 of temperature.
	 * 
	 * Difference of temperature between months at the equator: 0
	 * Difference of temperature between months at the poles: Edge_temperatureDifference/8
	 * 
	 *                          PTM*                              PTM*
	 * Seasons:           (Jan, Feb, Mar), (Apr, May, Jun), (Jul, Aug, Sep), (Oct, Nov, Dec);
	 * (xpos > equator):  Winter           Spring           Summer           Autumn
	 * (xpos < equator):  Summer           Autumn           Winter           Spring
	 * *PTM: Peak temperature month: Febraury and August
	 */
	public int mid_temperature, edge_temperatureDiference, height_temperatureVariation;
	/**
	 * If true, non canned foods rot and radioactive materials decay, disappearing and maybe harming citizens.
	 */
	public boolean decay;
	/**
	 * If the magmaFlow of this tile has already been generated and its values.
	 */
	public int magmaFlowOffset_x, magmaFlowOffset_y;
	public boolean[][] magmaFlow_isGenerated;
	public int[][] magmaFlow_x, magmaFlow_y;
	/**
	 * Array of tectonic plates. The first dimension (number in square brackets) of the array is positive towards the north and the second is positive towards the east.
	 */
	public TectonicPlate[][] tectonicPlates;
	/**
	 * Players in this world.
	 */
	public ArrayList<Player> players;
	/**
	 * Array of the ongoing trade in this world. Each month, resources and money should be exchanged according to it and their remaining duration should go down by 1. The trade stops when duration == 0.
	 * If duration is 0, it should stop and the event of the agreement ending should be added to the stack of events.
	 * If duration is -1, that means the trade is to last eternally... until it gets cancelled by force or it underflows.
	 */
	public ArrayList<Trade> trade;
	/**
	 * Log of events that happened in this world.
	 */
	public ArrayList<Event> events;
	/**
	 * List of events that are programmed to happen in this world.
	 */
	public ArrayList<Event> futureEvents;
	
	// Tectonic plate --------------------------------
	
	public static double smoothStep(int x, int width, int height){
		if(x < -width){
			return 0;
		}else if(width < x){
			return 0;
		}else if(x < 0){
			return (3*height*Op.square(x + width) - 2*height*Op.cube(x + width)/width)/(width*width);
		}else if(0 < x){
			return (3*height*Op.square(x - width) + 2*height*Op.cube(x - width)/width)/(width*width);
		}else{
			return height;
		}
	}
	
	public static double smoothStep(int x, int y, int width, int height){
		if(height == 0) {
			return 0;
		}
		return smoothStep(x, width, height) * smoothStep(y, width, height) / height;
	}
	
	/**
	 * @param relativeindex_tile_x Position of a tile relative to the point [0][0] of a plate
	 * @param relativeindex_tile_y Position of a tile relative to the point [0][0] of a plate
	 * @param plate_direction_x Strength of movement of a tectonic plate in the x axis
	 * @param plate_direction_y Strength of movement of a tectonic plate in the y axis
	 * @return Elevation caused by the movement of this tectonic plate on the tile, not counting elevation caused by other plates.
	 */
	private double getHeightInfluenceFromPlateOnTile(int relativeindex_tile_x, int relativeindex_tile_y, int plate_direction_x, int plate_direction_y, int influence) {
		return smoothStep(
				relativeindex_tile_x - plate_direction_x,
				relativeindex_tile_y - plate_direction_y,
				tectonicPlateSize*influence,
				getPlatePeakHeight(plate_direction_x, plate_direction_y)
		);
	}
	
	/**
	 * Calculates the peak height of a specific plate from its direction.
	 * This method is simpler, not letting height become absurdly larger than expected, but yields significantly smaller results in general.
	 * @param plate_direction_x
	 * @param plate_direction_y
	 * @return
	 */
	private int getPlatePeakHeight(int plate_direction_x, int plate_direction_y) {
		return
				((Op.abs(plate_direction_x - (tectonicPlateSize / 2)) +
				Op.abs(plate_direction_y - (tectonicPlateSize / 2))) * this.max_tile_z) /
				tectonicPlateSize;
	}
	
	private void generateContinent(int coordinate_plate_x, int coordinate_plate_y) {
		int coordinate_plate_x_iter = coordinate_plate_x;
		int coordinate_plate_y_iter = coordinate_plate_y;
		boolean connected = true;
		//generateTectonicPlate()
		/* continue generating wherever height > mid_tile_z until you've successfully defined a whole continent limited by sea.
		 * That is:
		 * generate a plate
		 * if any of the tiles on each of its edges is over sea level (and connected by plates over sea level?), generate the plate that is adjacent by that edge
		 * 
		 * When generating humidity, instead of comparing whether the humidity coming from the east and north/south and choosing the biggest,
		 * we can add them together.
		 * Near the equator, since they're both coming from the north and south, add them together. You can get the humid equator effect.
		 */
		//generate the rivers
			//meanders, billabongs...
		//generate humidity
		//generate resources
		//natural resources are generated by generating a resource in a tile and expanding it along fitting tiles.
		//mineral resources are generated by generating a resource in a tile and expanding it to surrounding tiles (as long as they're part of the same plate or some restriction to avoid overlapping ores).
		//soil resources are generated for every tile, depending on how humid, flat and low terrain is. Higher and more sloped terrain has less likelihood of spawning soil resources.
		
	}
	
	/*
	 * TODO:
	 * Land humidity (water level < land level) is calculated from the presence of water plates.
	 * That humidity flows westwards and towards the equator.
	 * 
	 * [W]: Water plate (lake, sea, ocean...)
	 * [H]: Land plate with high humidity
	 * [M]: Land plate with average humidity
	 * [D]: Land plate with low humidity
	 * 
	 * [D][D][D][D][D]
	 * [D][M][H][W][D]
	 * [D][D][M][H][D]
	 * [D][D][D][M][D]
	 * [D][D][D][D][D]
	 * ----equator----
	 * [D][D][D][D][D]
	 * [D][D][D][M][D]
	 * [D][D][M][H][D]
	 * [D][M][H][W][D]
	 * [D][D][D][D][D]
	 * 
	 * TODO: THIS DOESN'T TAKE RIVERS OR ANYTHING INTO ACCOUNT
	 * but the basic idea is here
	 * Redo the code in the generateContinent() method
	 */
	public int generateHumidityFromTileCoordinate(int coordinate_tile_x, int coordinate_tile_y) {
		int index_tile_x = getTileXIndexFromTileCoordinate(coordinate_tile_x);
		int index_tile_y = getTileYIndexFromTileCoordinate(coordinate_tile_y);
		int subindex_tile_x = Op.trueModulus(index_tile_x, tectonicPlateSize);
		int subindex_tile_y = Op.trueModulus(index_tile_y, tectonicPlateSize);
		//If land is below sea level, water level is the sea level (...the Netherlands would probably disagree but eh)
		if(getTectonicPlate(
				getPlateXCoordinateFromTileIndex(index_tile_x),
				getPlateYCoordinateFromTileIndex(index_tile_y)
				).height[subindex_tile_y][subindex_tile_x] <= mid_tile_z) {
			return mid_tile_z;
		}
		int iter_x = coordinate_tile_x;
		int iter_y = coordinate_tile_y;
		int humidity_influence_x = 0;
		int humidity_influence_y = 0;
		//Search for water tiles towards the east since wind flows westwards
		while(iter_x != coordinate_tile_x + tectonicPlateSize*this.maxTectonicPlateInfluence) {
			/* TODO:
			 * If (plate == null) {break;}
			 * If (tile.height < mid_tile_z) {humidity_influence_x = mid_tile_z; break;}
			 */
			iter_x += 1;
		}
		if(humidity_influence_x != 0) {
			while(iter_x != coordinate_tile_x) {
				//TODO: If height decreases with respect to the tile of the previous iteration, decrease the humidity value accordingly
				/*
				 * The idea is, if height increases with respect to the previous tile, humidity stays the same. Else, it's decreased.
				 */
				iter_x += -1;
			}
			if(humidity_influence_x < 0) {
				humidity_influence_x = 0;
			}
		}
		//Search for water tiles away from the equator since wind flows towards the equator
		while(iter_y != (coordinate_tile_y < 0 ?
				coordinate_tile_y - tectonicPlateSize*this.maxTectonicPlateInfluence :
				coordinate_tile_y + tectonicPlateSize*this.maxTectonicPlateInfluence)) {
			/* TODO:
			 * If (plate == null) {break;}
			 * If (tile.height < mid_tile_z) {humidity_influence_x = mid_tile_z; break;}
			 */
			iter_y += coordinate_tile_y < 0 ? 1 : -1;
		}
		if(humidity_influence_y != 0) {
			while(iter_y != coordinate_tile_y) {
				//TODO: If height decreases with respect to the tile of the previous iteration, decrease the humidity value accordingly
				iter_y += coordinate_tile_y < 0 ? -1 : 1;
			}
			if(humidity_influence_y < 0) {
				humidity_influence_y = 0;
			}
		}
		return humidity_influence_x > humidity_influence_y ? humidity_influence_x : humidity_influence_y;
	}
	
	/**
	 * Generates a tectonic plate geologically: its height and magma level. Sets the water level of tiles under sea level to the sea level.
	 *  
	 * @param index_plate_x, index_plate_y Absolute position of the tectonic plate in the array.
	 */
	/*
	 * TODO:
	 * CREATE AN ARRAY OF FLOATS WHEN INVOKING THIS METHOD
	 * USE THAT ARRAY TO CALCULATE THE VALUES WITH FLOATING OPERATIONS
	 * AND THEN CAST THEM TO BYTES
	 * BECAUSE INTEGER DIVISION CAUSES BIG LOSSES OF VALUES
	 * 
	 * once done, if map generation works, delete the method that uses disparitySmooth
	 */
	private TectonicPlate generateTectonicPlate(int index_plate_x, int index_plate_y) {
		int coordinate_plate_x = getPlateXCoordinateFromPlateIndex(index_plate_x);
		int coordinate_plate_y = getPlateYCoordinateFromPlateIndex(index_plate_y);
		tectonicPlates[index_plate_y][index_plate_x] = new TectonicPlate(null, tectonicPlateSize);
		double[][] calculatedValues = new double[tectonicPlateSize][tectonicPlateSize];
		for(int subindex_tile_y = 0; subindex_tile_y < tectonicPlateSize; subindex_tile_y++) {
			for(int subindex_tile_x = 0; subindex_tile_x < tectonicPlateSize; subindex_tile_x++) {
				//Initialize height
				double influenceAcum;
				for(int influence = maxTectonicPlateInfluence; influence > minTectonicPlateInfluence; --influence) {
					influenceAcum = 0.0f;
					//Sum of the influences of all nearby tiles within the current influence level
					for(int j = -influence; j <= influence; ++j) {
						for(int i = -influence; i <= influence; ++i) {
							influenceAcum += getHeightInfluenceFromPlateOnTile(
									subindex_tile_x - i*tectonicPlateSize,
									subindex_tile_y - j*tectonicPlateSize,
									getDirection_x(coordinate_plate_x + i, coordinate_plate_y + j, index_plate_x + i, index_plate_y + j),
									getDirection_y(coordinate_plate_x + i, coordinate_plate_y + j, index_plate_x + i, index_plate_y + j),
									influence
									);
						}
					}
					//Average the influence from each plate acting with a specific radius of influence
					//this reduces the influence too much though...
					influenceAcum /= Op.square(influence*2 + 1);
					calculatedValues[subindex_tile_y][subindex_tile_x] += influenceAcum;
				}
				//Average of the influence from each radius of influence
				calculatedValues[subindex_tile_y][subindex_tile_x] /= (maxTectonicPlateInfluence - minTectonicPlateInfluence);
				
				tectonicPlates[index_plate_y][index_plate_x].height[subindex_tile_y][subindex_tile_x] = (byte) calculatedValues[subindex_tile_y][subindex_tile_x];
				
				for(int j = -1; j <= 1; ++j) {
					for(int i = -1; i <= 1; ++i) {
						tectonicPlates[index_plate_y][index_plate_x].magma[subindex_tile_y][subindex_tile_x] += getHeightInfluenceFromPlateOnTile(
								subindex_tile_x - i*tectonicPlateSize,
								subindex_tile_y - j*tectonicPlateSize,
								tectonicPlateSize - 1 - getDirection_x(coordinate_plate_x + i, coordinate_plate_y + j, index_plate_x + i, index_plate_y + j),
								tectonicPlateSize - 1 - getDirection_y(coordinate_plate_x + i, coordinate_plate_y + j, index_plate_x + i, index_plate_y + j),
								1
								)/9;
					}
				}
				
				if(tectonicPlates[index_plate_y][index_plate_x].height[subindex_tile_y][subindex_tile_x] < mid_tile_z) {
					tectonicPlates[index_plate_y][index_plate_x].water[subindex_tile_y][subindex_tile_x] = mid_tile_z;
				}
			}
		}
		return tectonicPlates[index_plate_y][index_plate_x];
	}
	
	public int getDirection_x(int coordinate_plate_x, int coordinate_plate_y, int index_plate_x, int index_plate_y) {
		//If cycle is on, the coordinate of a neighboring plate may be back on the other end of the array
		if(cycle_x) {
			if(coordinate_plate_x < -max_plate_x / 2) {
				coordinate_plate_x += max_plate_x;
			} else if(coordinate_plate_x > max_plate_x / 2) {
				coordinate_plate_x -= max_plate_x;
			}
		}
		if(cycle_y) {
			if(coordinate_plate_y < -max_plate_y / 2) {
				coordinate_plate_y += max_plate_y;
			} else if (coordinate_plate_y > max_plate_y / 2) {
				coordinate_plate_y -= max_plate_y;
			}
		}
		return getMagmaFlow_x(coordinate_plate_x, coordinate_plate_y, index_plate_x + magmaFlowOffset_x, index_plate_y + magmaFlowOffset_x);
	}
	
	public int getDirection_y(int coordinate_plate_x, int coordinate_plate_y, int index_plate_x, int index_plate_y) {
		//If cycle is on, the coordinate of a neighboring plate may be back on the other end of the array
		if(cycle_x) {
			if(coordinate_plate_x < -max_plate_x / 2) {
				coordinate_plate_x += max_plate_x;
			} else if(coordinate_plate_x > max_plate_x / 2) {
				coordinate_plate_x -= max_plate_x;
			}
		}
		if(cycle_y) {
			if(coordinate_plate_y < -max_plate_y / 2) {
				coordinate_plate_y += max_plate_y;
			} else if (coordinate_plate_y > max_plate_y / 2) {
				coordinate_plate_y -= max_plate_y;
			}
		}
		return getMagmaFlow_y(coordinate_plate_x, coordinate_plate_y, index_plate_x + magmaFlowOffset_x, index_plate_y + magmaFlowOffset_x);
	}
	
	private int getMagmaFlow_x(int coordinate_plate_x, int coordinate_plate_y, int index_cache_x, int index_cache_y) {
		if(//Just in case, there's no way this can be fulfilled as that would imply influence is larger than maxTectonicPlateInfluence at some point
				index_cache_y < 0 ||
				index_cache_y >= magmaFlow_isGenerated.length ||
				index_cache_x < 0 ||
				index_cache_x >= magmaFlow_isGenerated[0].length
				) {
			return calculateMagmaFlow_x(coordinate_plate_x, coordinate_plate_y);
		} else if(magmaFlow_isGenerated[index_cache_y][index_cache_x]) {
			return magmaFlow_x[index_cache_y][index_cache_x];
		} else {
			return cacheMagmaFlow_return_x(index_cache_x, index_cache_y, coordinate_plate_x, coordinate_plate_y);
		}
	}
	
	private int getMagmaFlow_y(int coordinate_plate_x, int coordinate_plate_y, int index_cache_x, int index_cache_y) {
		if(//Just in case, there's no way this can be fulfilled as that would imply influence is larger than maxTectonicPlateInfluence at some point
				index_cache_y < 0 ||
				index_cache_y >= magmaFlow_isGenerated.length ||
				index_cache_x < 0 ||
				index_cache_x >= magmaFlow_isGenerated[0].length
				) {
			return calculateMagmaFlow_y(coordinate_plate_x, coordinate_plate_y);
		} else if(magmaFlow_isGenerated[index_cache_y][index_cache_x]) {
			return magmaFlow_y[index_cache_y][index_cache_x];
		} else {
			return cacheMagmaFlow_return_y(index_cache_x, index_cache_y, coordinate_plate_x, coordinate_plate_y);
		}
	}
	
	private int cacheMagmaFlow_return_x(int index_cache_x, int index_cache_y, int coordinate_plate_x, int coordinate_plate_y) {
		magmaFlow_isGenerated[index_cache_y][index_cache_x] = true;
		magmaFlow_y[index_cache_y][index_cache_x] = calculateMagmaFlow_y(coordinate_plate_x, coordinate_plate_y);
		return magmaFlow_x[index_cache_y][index_cache_x] = calculateMagmaFlow_x(coordinate_plate_x, coordinate_plate_y);
	}
	
	private int cacheMagmaFlow_return_y(int index_cache_x, int index_cache_y, int coordinate_plate_x, int coordinate_plate_y) {
		magmaFlow_isGenerated[index_cache_y][index_cache_x] = true;
		magmaFlow_x[index_cache_y][index_cache_x] = calculateMagmaFlow_x(coordinate_plate_x, coordinate_plate_y);
		return magmaFlow_y[index_cache_y][index_cache_x] = calculateMagmaFlow_y(coordinate_plate_x, coordinate_plate_y);
	}
	
	private int calculateMagmaFlow_x(int coordinate_plate_x, int coordinate_plate_y) {
		return DeterministicRandom.scramble(coordinate_plate_x, coordinate_plate_x, coordinate_plate_y, coordinate_plate_y, seed)
				& 0x7FFFFFFF//Force it to be positive by forcing the sign bit to be 0
				% tectonicPlateSize;
	}
	
	private int calculateMagmaFlow_y(int coordinate_plate_x, int coordinate_plate_y) {
		return DeterministicRandom.scramble(coordinate_plate_y, coordinate_plate_x, coordinate_plate_x, coordinate_plate_y, seed)
				& 0x7FFFFFFF//Force it to be positive by forcing the sign bit to be 0
				% tectonicPlateSize;
	}
	
	// Building --------------------------------
	
	/**
	 * Checks a rectangle of terrain for anything that would avoid an action with it. Returns a byte of flags:
	 * & 0x01: off limits (into plates that don't exist)
	 * & 0x02: tiles under minimum height
	 * & 0x04: terrain too sloped
	 * & 0x08: magma exposed
	 * & 0x10: tile occupied
	 * & 0x20: plate not owned by player
	 * @return a byte of flags indicating problems encountered in terrain
	 */
	public byte checkTerrain(int coordinate_tile_x_from, int coordinate_tile_x_to, int coordinate_tile_y_from, int coordinate_tile_y_to, int minHeight, int maxSlope, Player owner){
		byte status = 0;
		int totalSlope = 0;
		int bit_x = coordinate_tile_x_from < coordinate_tile_x_to ? 1 : -1;
		int bit_y = coordinate_tile_y_from < coordinate_tile_y_to ? 1 : -1;
		for(int loop_y = coordinate_tile_y_from; loop_y != coordinate_tile_y_to; loop_y += bit_y) {
			for(int loop_x = coordinate_tile_x_from; loop_y != coordinate_tile_x_to; loop_y += bit_x) {
				int index_tile_x = getTileXIndexFromTileCoordinate(loop_x);
				int index_tile_y = getTileYIndexFromTileCoordinate(loop_y);
				int subindex_tile_x = Op.trueModulus(index_tile_x, tectonicPlateSize);
				int subindex_tile_y = Op.trueModulus(index_tile_y, tectonicPlateSize);
				TectonicPlate plate = getTectonicPlate(getPlateXCoordinateFromTileIndex(index_tile_x), getPlateYCoordinateFromTileIndex(index_tile_y));
				if(plate == null) {
					status |= 0x01;
				} else {
					if(plate.height[subindex_tile_y][subindex_tile_x] < minHeight) {
						status |= 0x02;
					}
					totalSlope = totalSlope + this.getSlope_x(loop_x, loop_y) + getSlope_y(loop_x, loop_y);
					if(plate.height[subindex_tile_y][subindex_tile_x] < plate.magma[subindex_tile_y][subindex_tile_x]) {
						status |= 0x08;
					}
					if(plate.elementsIn[subindex_tile_y][subindex_tile_x] != -1) {
						status |= 0x10;
					}
					if(plate.owner != owner) {
						status |= 0x20;
					}
				}
			}
		}
		if(maxSlope < totalSlope) {
			status |= 0x04;
		}
		return status;
	}
	
	/**
	 * Puts a building on the map unconditionally.
	 * @param building building to be placed
	 */
	public byte build(Building building){
		int bit_x = (building.orientation & 0b01) == 0 ? -1 : 1;
		int bit_y = (building.orientation & 0b10) == 0 ? -1 : 1;
		byte checkTerrain = checkTerrain(
				building.coordinate_tile_y + bit_y*building.getSize_y(),
				building.coordinate_tile_y,
				building.coordinate_tile_x + bit_x*building.getSize_x(),
				building.coordinate_tile_x,
				building.getMinHeight(),
				building.getMaxSlope(),
				building.owner
				);
		if(checkTerrain == 0) {
			TectonicPlate mainPlate = getTectonicPlate(getPlateXCoordinateFromTileIndex(getTileXIndexFromTileCoordinate(building.coordinate_tile_x)), getPlateYCoordinateFromTileIndex(getTileYIndexFromTileCoordinate(building.coordinate_tile_y)));
			for(int loop_y = building.coordinate_tile_y + bit_y*building.getSize_y(); loop_y != building.coordinate_tile_y; loop_y += bit_y) {
				for(int loop_x = building.coordinate_tile_x + bit_x*building.getSize_x(); loop_x != building.coordinate_tile_x; loop_x += bit_x) {
					int index_tile_x = getTileXIndexFromTileCoordinate(loop_x);
					int index_tile_y = getTileYIndexFromTileCoordinate(loop_y);
					int subindex_tile_x = Op.trueModulus(index_tile_x, tectonicPlateSize);
					int subindex_tile_y = Op.trueModulus(index_tile_y, tectonicPlateSize);
					TectonicPlate plate = getTectonicPlate(getPlateXCoordinateFromTileIndex(index_tile_x), getPlateYCoordinateFromTileIndex(index_tile_y));
					if(plate == mainPlate) {
						plate.addElement(subindex_tile_y, subindex_tile_x, building);
					} else {
						plate.addForeignElement(subindex_tile_y, subindex_tile_x, building);
					}
				}
			}
		}
		return checkTerrain;
	}
	
	
	public void destroy(int id) {
		//TODO: Reset the elementsIn field of the corresponding tiles to -1
		//TODO: eject the units inside the building, unemploy its workers.
	}
	
	// Knot --------------------------------
	
	private boolean breadthFirstSearch(Knot start, Knot goal, int maxdepth) {
		LinkedList<Knot> list = new LinkedList<Knot>();
		list.add(start);
		boolean hit = false;
		int i = 0;
		while(!hit && i < maxdepth && !list.isEmpty()) {
			for(Knot knot : list.getFirst().connections) {
				if(knot.unlocked && (0 < knot.health)) {
					if(knot == goal) {
						hit = true;
						break;
					}
					list.add(knot);
				}
			}
			list.remove();
			++i;
		}
		return hit;
	}
	
	// Unit --------------------------------
	
	public void spawn(Unit unit){
		
	}
	
	public void kill(Unit unit) {
		/* TODO
		 * The unit doesn't do anything anymore, it appears as dead.
		 * The cause and month of death is added.
		 * Kill the citizens inside it too?
		 */
	}
	
	/*
	 * TODO: MOVING
	 * Units can move, but only up to a certain distance from their home
	 * Citizens can access anything within reach from home, including units
	 * To move them further away, you need an airport or something so they still have access to home
	 */
	public void move(Unit unit, int coordinate_tile_x, int coordinate_tile_y) {
		//TODO: If a unit isn't in its type of terrain, it can't move from there and the civilians controlling it are ejected to land (for water units in land) or drowned (for land units in water)
		//TODO: Check whether no other element is in the tile.
		//TODO: Units may not move to a point that is unreachable from the homes of the civilians that drive it
		//TODO: Water units may or may not move through ice
		
		unit.coordinate_tile_x = coordinate_tile_x;//Set the coordinates stored in the unit to its new coordinates
		unit.coordinate_tile_y = coordinate_tile_y;
		
		
	}
	
	// Trade --------------------------------
	
		
	
	// Event --------------------------------
	
	private void triggerEvents() {
		for(int i = 0; i < futureEvents.size(); ++i) {
			if(futureEvents.get(i).date == this.date) {
				events.add(futureEvents.get(i));
				futureEvents.remove(i);
				//TODO: Execute the function associated with the event
			}
		}
	}
	
	// Constructor --------------------------------
	
	public World(
			//Note: If tectonicPlateSize is a power of two, it could be determined in which tectonic plate a tile is just based on its first bits.
			String version,
			int seed,//Default value: (int)System.currentTimeMillis(), which cycles every 0xFFFFFFFF miliseconds, that is, 50 days
			int tectonicPlateSize,
			int maxTectonicPlateInfluence,
			int minTectonicPlateInfluence,
			int crustThickness,
			boolean cycle_x,
			boolean cycle_y,
			int startingPlates_x,
			int startingPlates_y,
			int circumference,//x
			int meridian,//y
			int altitude,//z
			int greenwich,//mid_x
			int equator,//mid_y
			byte seaLevel,//mid_z
			int temperatureAtEquator,//Default 32
			int temperatureDifferenceBetweenPolesAndEquator,//Default -32
			int temperatureVariationByHeight,
			int humanPlayerAmount,
			int AIPlayerAmount,
			int startingPopulation,
			int averagePopulationAge //Can create growing or aging populations depending on how low or high it is
	) {
		this.version = version;
		this.date = 0;
		this.seed = seed;
		//assert tectonic plate size > 0
		if(tectonicPlateSize < 1) {
			this.tectonicPlateSize = 1;
		} else {
			this.tectonicPlateSize = tectonicPlateSize;
		}
		if(maxTectonicPlateInfluence < 1) {
			this.maxTectonicPlateInfluence = 1;
		} else {
			this.maxTectonicPlateInfluence = maxTectonicPlateInfluence;
		}
		if(minTectonicPlateInfluence < 0) {
			this.minTectonicPlateInfluence = 1;
		} else if(minTectonicPlateInfluence >= maxTectonicPlateInfluence) {
			this.minTectonicPlateInfluence = maxTectonicPlateInfluence - 1;
		} else {
			this.minTectonicPlateInfluence = minTectonicPlateInfluence;
		}
		this.crustThickness = crustThickness;
		this.cycle_x = cycle_x;
		this.cycle_y = cycle_y;
		//assert circumference, meridian, altitude > 0
		if(circumference < 1) {
			this.max_plate_x = 1;
		} else {
			this.max_plate_x = circumference;
		}
		if(meridian < 1) {
			this.max_plate_y = 1;
		} else {
			this.max_plate_y = meridian;
		}
		if(altitude < 1) {
			this.max_tile_z = 1;
		} else {
			this.max_tile_z = altitude;
		}
		/*
		 * assert starting number of plates is no more than the maximum of each dimension or negative
		 * with the padding needed for the cacheing arrays of the DPRNG added
		 * TODO: This assumes the world doesn't cycle. No need to pad if it doesn't
		 */
		if(
				startingPlates_x > 0 &&
				startingPlates_y > 0 &&
				startingPlates_x < this.max_plate_x &&
				startingPlates_y < this.max_plate_y
				) {
			this.tectonicPlates = new TectonicPlate[startingPlates_y][startingPlates_x];
			this.magmaFlow_isGenerated = new boolean
					[startingPlates_y + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence]
					[startingPlates_x + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence];
			this.magmaFlow_x = new int
					[startingPlates_y + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence]
					[startingPlates_x + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence];
			this.magmaFlow_y = new int
					[startingPlates_y + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence]
					[startingPlates_x + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence];
			this.magmaFlowOffset_x = this.magmaFlowOffset_y = this.maxTectonicPlateInfluence;
		} else {
			this.tectonicPlates = new TectonicPlate[this.max_plate_y][this.max_plate_x];
			this.magmaFlow_isGenerated = new boolean
					[this.max_plate_y + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence]
					[this.max_plate_x + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence];
			this.magmaFlow_x = new int
					[this.max_plate_y + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence]
					[this.max_plate_x + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence];
			this.magmaFlow_y = new int
					[this.max_plate_y + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence]
					[this.max_plate_x + this.maxTectonicPlateInfluence + this.maxTectonicPlateInfluence];
			this.magmaFlowOffset_x = this.magmaFlowOffset_y = this.maxTectonicPlateInfluence;
		}
		//assert that the distance between the furthest point in the map along the x axis and greenwich isn't bigger than half of the max x-distance in the map
		if(tectonicPlates[0].length - greenwich/tectonicPlateSize > max_plate_x/2) {
			this.mid_tile_x = (tectonicPlates[0].length - max_plate_x/2)*tectonicPlateSize;
		//assert that the distance between the nearest point in the map along the x axis and greenwich isn't bigger than half of the max x-distance in the map
		} else if(greenwich/tectonicPlateSize > max_plate_x/2) {
			this.mid_tile_x = (max_plate_x/2)*tectonicPlateSize;
		} else {
			this.mid_tile_x = greenwich;
		}
		//assert that the distance between the furthest point in the map along the y axis and the equator isn't bigger than half of the max y-distance in the map
		if(tectonicPlates.length - equator/tectonicPlateSize > max_plate_y/2) {
			this.mid_tile_y = (tectonicPlates.length - max_plate_y/2)*tectonicPlateSize;
		//assert that the distance between the nearest point in the map along the y axis and the equator isn't bigger than half of the max y-distance in the map
		} else if(equator/tectonicPlateSize > max_plate_y/2) {
			this.mid_tile_y = (max_plate_y/2)*tectonicPlateSize;
		} else {
			this.mid_tile_y = equator;
		}
		/*
		 * not asserting jack shit here
		 * If you want to put the sea level at the fucking center of the earth,
		 * I'm not going to babyproof your ass from turning the planet into a desertic wasteland
		 */
		this.mid_tile_z = seaLevel;
		this.mid_temperature = temperatureAtEquator;
		this.edge_temperatureDiference = temperatureDifferenceBetweenPolesAndEquator;
		this.height_temperatureVariation = temperatureVariationByHeight;
		this.players = new ArrayList<Player>();
		
		for(int y = 0; y < tectonicPlates.length; ++y) {
			for(int x = 0; x < tectonicPlates[0].length; ++x) {
				System.out.println("Generating tectonic plate " +
						(x + 1) + "," +
						(y + 1) + " of " +
						tectonicPlates[0].length + "," +
						tectonicPlates.length);
				generateTectonicPlate(x, y);
			}
		}
		//TODO: Insert human players in the players stack
		//TODO: Create AI players for the players stack, give them randomized personalities
		//TODO: Create native towns
		
		/*
		TODO
		Map generation algorithm
		
		Create a map with a certain number of tectonic plates.
	
		Every tile under sea level becomes water (water tiles with altitude 0 or lower are sea tiles, which are salty and bad for plants)
		Water sources, rivers, lakes... are generated.
		
		Temperature is calculated from its position in the north-south axis.
		Humidity is calculated from amount of nearby water tiles.
		
		Backshores may generate
		Oceanic dorsals may generate
		Water under freezing point appears as ice
		
		High altitude terrain or very dry terrain tends to be rocky.
		Low altitude terrain tends to be clay if humidity is high, silt is humidity is medium and sand if humidity is low.
		Low rocky terrain is a source of limestone.
		
		Events:
			Earthquake
			When it happens under sea level, it damages and pushes all nearby units in water tiles further from the tiles where the earthquake was originated.
			Because of this, it can push boats ashore.
		*/
	}
	
	// Object methods --------------------------------
	
	@Override public String toString() {
		return
				"[world\nV" + this.version +
				"\nH" + String.format("%11d", this.hashCode()) +
				"\nT" + String.format("%11d", tectonicPlateSize) +
				"\nT" + String.format("%11d", tectonicPlateSize) +
				"\n#T" + String.format("%11d", tectonicPlates[0].length) +
				"*" + String.format("%11d", tectonicPlates.length) +
				"\n#P" + String.format("%11d", players.size()) +
				"\n]";
	}
	
	@Override public int hashCode() {
		return
				version.hashCode() +
				tectonicPlateSize*31 +
				seed*961;
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof World) {
			return seed == ((World)object).seed;
		}
		return false;
	}
	
	// File and memory functions --------------------------------
	
	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}
	
	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
	//TODO: Only really needs functions above, move functions under to some other class.
	
	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(directory + "/save.world");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public void save(String directory) {
		this.directory = directory;
		try {
			FileOutputStream fos = new FileOutputStream(directory + "/save.world");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.close();
			fos.close();
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public static void load(World w, String directory) {
		try {
			FileInputStream fis = new FileInputStream(directory + "/save.world");
			ObjectInputStream ois = new ObjectInputStream(fis);
			w = (World) ois.readObject();
			ois.close();
			fis.close();
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Plate files should follow the structure:
	 * 
	 *     0  1  2  3
	 *  4 7E C7 09 1C hexspeak for tectonic
	 *  8             tectonicPlateSize field
	 * 12             owner field
	 * 16             unlocked field
	 *    .. .. .. .. contents of the arrays
	 * 
	 * 0xTectonicPlateSize
	 * 
	 * We should use a single file for every plate
	 * 
	 * We should store plates by using a byte for the value of height or magma of a corner tile and then
	 * using 3 bits to store the value of the next tiles as a variation of the previous.
	 * 
	 * 00000000,000,000,000,000...
	 * 
	 * For the water level, we can use a huffman codification since water is most of the time unchanged with respect to the previous tile.
	 * 0 ->    +0
	 * 1--- -> +whatever the three bits would stand for if they were height ones
	 */
	private void saveTectonicPlate(int coordinate_plate_x, int coordinate_plate_y) {
		int x = getPlateXIndexFromPlateCoordinate(coordinate_plate_x);
		int y = getPlateYIndexFromPlateCoordinate(coordinate_plate_y);
		try {
			FileOutputStream fos = new FileOutputStream(directory + "/" + coordinate_plate_x + "_" + coordinate_plate_y + ".plate");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.tectonicPlates[y][x]);
			oos.close();
			fos.close();
		} catch(Throwable e) {
			e.printStackTrace();
		} finally {
			tectonicPlates[y][x] = null;//We're unloading the plate, so we put a reference to null
		}
	}
	
	private TectonicPlate loadTectonicPlate(int coordinate_plate_x, int coordinate_plate_y, ObjectInputStream stream) throws Throwable {
		int x = getPlateXIndexFromPlateCoordinate(coordinate_plate_x);
		int y = getPlateYIndexFromPlateCoordinate(coordinate_plate_y);
		return tectonicPlates[x][y] = (TectonicPlate)stream.readObject();
	}
	
	/**
	 * Retuns a tectonic plate at certain coordinates, loads it from memory if it's not loaded or generates it if it doesn't exist. Returns null if it can't be generated.
	 * @param coordinate_plate_x the x coordinate of a plate
	 * @param coordinate_plate_y the y coordinate of a plate
	 * @return the tectonic plate at the coordinates taken as arguments, null if there can't be a tectonic plate at the coordinates
	 */
	public TectonicPlate getTectonicPlate(int coordinate_plate_x, int coordinate_plate_y) {
		int x = getPlateXIndexFromPlateCoordinate(coordinate_plate_x);
		if(x < 0) {
			if(this.expand(x, 0, false)) {
				return getTectonicPlate(coordinate_plate_x, coordinate_plate_y);
			}
			if(cycle_x) {
				return getTectonicPlate(coordinate_plate_x + max_plate_x, coordinate_plate_y);
			}
			return null;
		}
		if(tectonicPlates[0].length <= x) {
			if(this.expand(x - tectonicPlates[0].length + 1, 0, false)) {
				return getTectonicPlate(coordinate_plate_x, coordinate_plate_y);
			}
			if(cycle_x) {
				return getTectonicPlate(coordinate_plate_x - max_plate_x, coordinate_plate_y);
			}
			return null;
		}
		int y = getPlateYIndexFromPlateCoordinate(coordinate_plate_y);
		if(y < 0) {
			if(this.expand(0, y, false)) {
				return getTectonicPlate(coordinate_plate_x, coordinate_plate_y);
			}
			if(cycle_y) {
				return getTectonicPlate(coordinate_plate_x, coordinate_plate_y + max_plate_y);
			}
			return null;
		}
		if(tectonicPlates.length <= y) {
			if(this.expand(0, y - tectonicPlates.length + 1, false)) {
				return getTectonicPlate(coordinate_plate_x, coordinate_plate_y);
			}
			if(cycle_y) {
				return getTectonicPlate(coordinate_plate_x, coordinate_plate_y - max_plate_y);
			}
			return null;
		}
		if(tectonicPlates[y][x] == null) {
			//Location of the file where that plate would be located if it has been already generated and saved.
			String filename = directory + "/" + coordinate_plate_x + "_" + coordinate_plate_y + ".plate";
			//If it exists, load it from the file.
			if(new File(filename).exists()) {
				try {
					return loadTectonicPlate(
							coordinate_plate_x,
							coordinate_plate_y,
							new ObjectInputStream(new FileInputStream(filename))
							);
				} catch (Throwable e) {
					e.printStackTrace();
				}
				return null;
			}
			//Else, generate the plate.
			return generateTectonicPlate(coordinate_plate_x, coordinate_plate_y);
		}
		return tectonicPlates[y][x];
	}
	
	public int getHeightFromTileCoordinate(int coordinate_tile_x, int coordinate_tile_y) {
		int index_tile_x = getTileXIndexFromTileCoordinate(coordinate_tile_x);
		int index_tile_y = getTileYIndexFromTileCoordinate(coordinate_tile_y);
		int subindex_tile_x = Op.trueModulus(index_tile_x, tectonicPlateSize);
		int subindex_tile_y = Op.trueModulus(index_tile_y, tectonicPlateSize);
		return getTectonicPlate(
				getPlateXCoordinateFromTileIndex(index_tile_x),
				getPlateYCoordinateFromTileIndex(index_tile_y)
				).height[subindex_tile_y][subindex_tile_x];
	}
	
	public void setHeightFromTileCoordinate(int coordinate_tile_x, int coordinate_tile_y, byte height) {
		int index_tile_x = getTileXIndexFromTileCoordinate(coordinate_tile_x);
		int index_tile_y = getTileYIndexFromTileCoordinate(coordinate_tile_y);
		int subindex_tile_x = Op.trueModulus(index_tile_x, tectonicPlateSize);
		int subindex_tile_y = Op.trueModulus(index_tile_y, tectonicPlateSize);
		getTectonicPlate(
				getPlateXCoordinateFromTileIndex(index_tile_x),
				getPlateYCoordinateFromTileIndex(index_tile_y)
				).height[subindex_tile_y][subindex_tile_x] = height;
	}
	
	public int getTemperatureFromTileCoordinate(int coordinate_tile_x, int coordinate_tile_y) {
		int index_tile_x = getTileXIndexFromTileCoordinate(coordinate_tile_x);
		int index_tile_y = getTileYIndexFromTileCoordinate(coordinate_tile_y);
		int subindex_tile_x = Op.trueModulus(index_tile_x, tectonicPlateSize);
		int subindex_tile_y = Op.trueModulus(index_tile_y, tectonicPlateSize);
		return ((Math.abs(subindex_tile_y + coordinate_tile_y)//Distance between the tile and the equator
				* (edge_temperatureDiference) * 2 / (this.max_plate_y*tectonicPlateSize))
				+ mid_temperature
				- ((getTectonicPlate(
						getPlateXCoordinateFromTileIndex(index_tile_x),
						getPlateYCoordinateFromTileIndex(index_tile_y)
						).height[subindex_tile_y][subindex_tile_x] - mid_tile_z) / height_temperatureVariation));//The bigger the altitude over sea level, the less temperature
	}
	
	// Operation functions --------------------------------
	
	private static boolean isReachable(int index_tile_x_1, int index_tile_y_1, int index_tile_x_2, int index_tile_y_2, int reach) {
		return Op.square(index_tile_x_2 - index_tile_x_1) + Op.square(index_tile_y_2- index_tile_y_1) <= reach*reach;
	}
	
	public int getTileXIndexFromTileCoordinate(int coordinate_tile_x) {
		return coordinate_tile_x + mid_tile_x;
	}

	public int getTileYIndexFromTileCoordinate(int coordinate_tile_y) {
		return coordinate_tile_y + mid_tile_y;
	}
	
	public int getPlateXIndexFromTileCoordinate(int coordinate_tile_x) {
		if(0 <= coordinate_tile_x) {
			return coordinate_tile_x / tectonicPlateSize;
		} else {
			return ((coordinate_tile_x + 1) / tectonicPlateSize) - 1;
		}
	}
	
	public int getPlateYIndexFromTileCoordinate(int coordinate_tile_y) {
		if(0 <= coordinate_tile_y) {
			return coordinate_tile_y / tectonicPlateSize;
		} else {
			return ((coordinate_tile_y + 1) / tectonicPlateSize) - 1;
		}
	}
	
	private int getPlateXIndexFromPlateCoordinate(int coordinate_plate_x) {
		return coordinate_plate_x + getPlateXIndexFromTileCoordinate(mid_tile_x);
	}

	public int getPlateYIndexFromPlateCoordinate(int coordinate_plate_y) {
		return coordinate_plate_y + getPlateYIndexFromTileCoordinate(mid_tile_y);
	}
	
	public int getTileXCoordinateFromTileIndex(int index_tile_x) {
		return index_tile_x - mid_tile_x;
	}

	public int getTileYCoordinateFromTileIndex(int index_tile_y) {
		return index_tile_y - mid_tile_y;
	}
	
	public int getPlateXCoordinateFromTileIndex(int index_plate_x) {
		if(0 <= index_plate_x) {
			//[tectonicPlateSize*(n), tectonicPlateSize*(n + 1) - 1]
			return index_plate_x / tectonicPlateSize;
		} else {
			//[-tectonicPlateSize*(n), -tectonicPlateSize*(n - 1) - 1]
			return ((index_plate_x + 1) / tectonicPlateSize) + 1;
		}
	}
	
	public int getPlateYCoordinateFromTileIndex(int index_plate_y) {
		if(0 <= index_plate_y) {
			//[tectonicPlateSize*(n), tectonicPlateSize*(n + 1) - 1]
			return index_plate_y / tectonicPlateSize;
		} else {
			//[-tectonicPlateSize*(n), -tectonicPlateSize*(n - 1) - 1]
			return ((index_plate_y + 1) / tectonicPlateSize) + 1;
		}
	}
	
	public int getPlateXCoordinateFromPlateIndex(int index_plate_x) {
		return index_plate_x - getPlateXCoordinateFromTileIndex(mid_tile_x);
	}
	
	public int getPlateYCoordinateFromPlateIndex(int index_plate_y) {
		return index_plate_y - getPlateYCoordinateFromTileIndex(mid_tile_y);
	}
	
	/**
	 * Total slope of a tile.
	 * @param slope_x slope of the tile along the x plane
	 * @param slope_y wlope of the tile along the y plane
	 * @return the total slope of the tile
	 */
	private int getSlope(int slope_x, int slope_y) {
		return Op.abs(slope_x) + Op.abs(slope_y);
	}
	
	/**
	 * @param coordinate_tile_x x coordinate of a tile
	 * @param coordinate_tile_y y coordinate of a tile
	 * @return slope of the tile along the x plane
	 */
	private int getSlope_x(int coordinate_tile_x, int coordinate_tile_y) {
		return(
				getHeightFromTileCoordinate(coordinate_tile_x - 1, coordinate_tile_y) +
				getHeightFromTileCoordinate(coordinate_tile_x + 1, coordinate_tile_y)
				)/2;
	}
	
	/**
	 * @param coordinate_tile_x x coordinate of a tile
	 * @param coordinate_tile_y y coordinate of a tile
	 * @return slope of the tile along the y plane
	 */
	private int getSlope_y(int coordinate_tile_x, int coordinate_tile_y) {
		return(
				getHeightFromTileCoordinate(coordinate_tile_x, coordinate_tile_y - 1) +
				getHeightFromTileCoordinate(coordinate_tile_x, coordinate_tile_y + 1)
				)/2;
	}
	
	/**
	 * Inclination of a tile as an angle in degrees.
	 * Basically, it's a precalculated table for the result of arctan((slope) / 8).
	 */
	public String getInclination(int slope_x, int slope_y) {
		int sum = getSlope(slope_x, slope_y);
		if(sum <=   0){return " 0\u00B0";}if(sum ==   1){return " 7\u00B0";}if(sum ==   2){return "14\u00B0";}if(sum ==   3){return "21\u00B0";}
		if(sum ==   4){return "27\u00B0";}if(sum ==   5){return "32\u00B0";}if(sum ==   6){return "37\u00B0";}if(sum ==   7){return "41\u00B0";}
		if(sum ==   8){return "45\u00B0";}if(sum ==   9){return "48\u00B0";}if(sum ==  10){return "51\u00B0";}if(sum ==  11){return "54\u00B0";}
		if(sum ==  12){return "56\u00B0";}if(sum ==  13){return "58\u00B0";}if(sum ==  14){return "60\u00B0";}if(sum ==  15){return "62\u00B0";}
		if(sum ==  16){return "64\u00B0";}if(sum ==  17){return "65\u00B0";}if(sum ==  18){return "66\u00B0";}if(sum ==  19){return "67\u00B0";}
		if(sum ==  20){return "68\u00B0";}if(sum ==  21){return "69\u00B0";}if(sum ==  22){return "70\u00B0";}if(sum ==  23){return "71\u00B0";}
		if(sum <=  25){return "72\u00B0";}if(sum <=  27){return "73\u00B0";}if(sum <=  29){return "74\u00B0";}if(sum <=  31){return "75\u00B0";}
		if(sum <=  33){return "76\u00B0";}if(sum <=  36){return "77\u00B0";}if(sum <=  39){return "78\u00B0";}if(sum <=  43){return "79\u00B0";}
		if(sum <=  47){return "80\u00B0";}if(sum <=  53){return "81\u00B0";}if(sum <=  60){return "82\u00B0";}if(sum <=  70){return "83\u00B0";}
		if(sum <=  83){return "84\u00B0";}if(sum <= 101){return "85\u00B0";}if(sum <= 130){return "86\u00B0";}if(sum <= 183){return "87\u00B0";}
		if(sum <= 305){return "88\u00B0";}if(sum <= 916){return "89\u00B0";}               return "90\u00B0";
	}
	
	public String getInclinationFromCoordinate(int coordinate_tile_x, int coordinate_tile_y) {
		return getInclination(
				getSlope_x(coordinate_tile_x, coordinate_tile_y),
				getSlope_y(coordinate_tile_x, coordinate_tile_y)
				);
	}
	
	// Modifier methods --------------------------------
	
	/**
	 * Expands the tectonicPlates array and the arrays that cache the results of the DPRNG by a certain amount in a certain dimension (parameter) and direction (sign).
	 * x < 0: west
	 * 0 < x: east
	 * y < 0: south
	 * 0 < y: north
	 * 
	 * @param x Amount to expand the array in the x dimension. It adds more positions in the subarrays after the last index or before the first index depending on the sign.
	 * @param y Amount to expand the array in the y dimension. It adds more positions in the array after the last index or before the first index depending on the sign.
	 * @param initialize If true, it generates tectonic plates to fill up the new array indices.
	 */
	/*
	 * TODO: These methods assume the world doesn't cycle
	 * If it does, the arrays that cache the DPRNG shouldn't grow larger than max_n, with n being the specific dimension we're operating on
	 * Just like the other arrays
	 */
	public boolean expand(int x, int y, boolean initialize) {
		boolean ret = false;
		if(x < 0) {//west
			if(
					//If max_plate_x is less than 0, the map is probably not meant to expand any more than its current size
					0 < max_plate_x &&
					//No more plates if they'd shift greenwich to more than half of the max longitude of the world away from the first plate in this dimension
					//THE OLDER WAY OF DOING IT: (mid_tile_x - x*tectonicPlateSize) < (max_plate_x*tectonicPlateSize / 2)
					getPlateXCoordinateFromTileIndex(mid_tile_x) < (max_plate_x / 2)
					) {
				for(int j = 0; j < tectonicPlates.length; ++j) {
					TectonicPlate[] newArray = new TectonicPlate[tectonicPlates[j].length - x];
					for(int i = 0; i < tectonicPlates[j].length; ++i) {
						newArray[i - x] = tectonicPlates[j][i];
					}
					tectonicPlates[j] = newArray;
				}
				for(int j = 0; j < magmaFlow_isGenerated.length; ++j) {
					boolean[] new_magmaFlow_isGenerated = new boolean[magmaFlow_isGenerated[j].length - x];
					for(int i = 0; i < magmaFlow_isGenerated[j].length; ++i) {
						new_magmaFlow_isGenerated[i - x] = magmaFlow_isGenerated[j][i];
					}
					magmaFlow_isGenerated[j] = new_magmaFlow_isGenerated;
				}
				for(int j = 0; j < magmaFlow_x.length; ++j) {
					int[] new_magmaFlow_x = new int[magmaFlow_x[j].length - x];
					for(int i = 0; i < magmaFlow_x[j].length; ++i) {
						new_magmaFlow_x[i - x] = magmaFlow_x[j][i];
					}
					magmaFlow_x[j] = new_magmaFlow_x;
				}
				for(int j = 0; j < magmaFlow_y.length; ++j) {
					int[] new_magmaFlow_y = new int[magmaFlow_y[j].length - x];
					for(int i = 0; i < magmaFlow_y[j].length; ++i) {
						new_magmaFlow_y[i - x] = magmaFlow_y[j][i];
					}
					magmaFlow_y[j] = new_magmaFlow_y;
				}
				//Shift greenwich accordingly
				mid_tile_y -= tectonicPlateSize*x;
				if(initialize) {
					for(int j = 0; j < tectonicPlates.length; ++j) {
						for(int i = 0; i < -x; ++i) {
							System.out.println("Generating tectonic plate " +
									(i + 1) + "," +
									(j + 1) + " of " +
									tectonicPlates[0].length + "," +
									tectonicPlates.length);
							generateTectonicPlate(i, j);
						}
					}
				}
				ret = true;
			}
		}else if(x > 0) {//east
			if(
					//If max_plate_x is less than 0, the map is probably not meant to expand any more than its current size
					0 < max_plate_x &&
					//No more plates if they'd be more than half of the max latitude of the world away from greenwich
					//THE OLDER WAY OF DOING IT: ((tectonicPlates[0].length + x)*tectonicPlateSize - mid_tile_x) < (max_plate_x*tectonicPlateSize / 2)
					(tectonicPlates[0].length - getPlateXCoordinateFromTileIndex(mid_tile_x)) < (max_plate_x / 2)
					) {
				for(int j = 0; j < tectonicPlates.length; ++j) {
					TectonicPlate[] newArray = new TectonicPlate[tectonicPlates[j].length + x];
					for(int i = 0; i < tectonicPlates[j].length; ++i) {
						newArray[i] = tectonicPlates[j][i];
					}
					tectonicPlates[j] = newArray;
				}
				for(int j = 0; j < magmaFlow_isGenerated.length; ++j) {
					boolean[] new_magmaFlow_isGenerated = new boolean[magmaFlow_isGenerated[j].length + x];
					for(int i = 0; i < magmaFlow_isGenerated[j].length; ++i) {
						new_magmaFlow_isGenerated[i] = magmaFlow_isGenerated[j][i];
					}
					magmaFlow_isGenerated[j] = new_magmaFlow_isGenerated;
				}
				for(int j = 0; j < magmaFlow_x.length; ++j) {
					int[] new_magmaFlow_x = new int[magmaFlow_x[j].length + x];
					for(int i = 0; i < magmaFlow_x[j].length; ++i) {
						new_magmaFlow_x[i] = magmaFlow_x[j][i];
					}
					magmaFlow_x[j] = new_magmaFlow_x;
				}
				for(int j = 0; j < magmaFlow_y.length; ++j) {
					int[] new_magmaFlow_y = new int[magmaFlow_y[j].length + x];
					for(int i = 0; i < magmaFlow_y[j].length; ++i) {
						new_magmaFlow_y[i] = magmaFlow_y[j][i];
					}
					magmaFlow_y[j] = new_magmaFlow_y;
				}
				if(initialize){
					for(int j = 0; j < tectonicPlates.length; ++j) {
						for(int i = tectonicPlates[0].length - x; i < tectonicPlates[0].length; ++i) {
							System.out.println("Generating tectonic plate " +
									(i + 1) + "," +
									(j + 1) + " of " +
									tectonicPlates[0].length + "," +
									tectonicPlates.length);
							generateTectonicPlate(i, j);
						}
						
					}
				}
				ret = true;
			}
		}
		if(y < 0) {//south
			if(
					//If max_plate_y is less than 0, the map is probably not meant to expand any more than its current size
					0 < max_plate_y &&
					//No more plates if they'd shift the equator to more than half of the max latitude of the world away from the first plate in this dimension
					//THE OLDER WAY OF DOING IT: (mid_tile_y - y*tectonicPlateSize) < (max_plate_y*tectonicPlateSize / 2)
					getPlateYCoordinateFromTileIndex(mid_tile_y) < (max_plate_y / 2)
					) {
				TectonicPlate[][] newArray = new TectonicPlate[tectonicPlates.length - y][];
				boolean[][] new_magmaFlow_isGenerated = new boolean[magmaFlow_isGenerated.length - y][];
				int[][] new_magmaFlow_x = new int[magmaFlow_x.length - y][];
				int[][] new_magmaFlow_y = new int[magmaFlow_y.length - y][];
				int j = 0;
				while(j < -y) {
					newArray[j] = new TectonicPlate[tectonicPlates[0].length];
					++j;
				}
				while(j < newArray.length) {
					newArray[j] = tectonicPlates[j + y];
					++j;
				}
				j = 0;
				while(j < -y) {
					new_magmaFlow_isGenerated[j] = new boolean[magmaFlow_isGenerated[0].length];
					++j;
				}
				while(j < newArray.length) {
					new_magmaFlow_isGenerated[j] = magmaFlow_isGenerated[j + y];
					++j;
				}
				j = 0;
				while(j < -y) {
					new_magmaFlow_x[j] = new int[magmaFlow_x[0].length];
					++j;
				}
				while(j < newArray.length) {
					new_magmaFlow_x[j] = magmaFlow_x[j + y];
					++j;
				}
				j = 0;
				while(j < -y) {
					new_magmaFlow_y[j] = new int[magmaFlow_y[0].length];
					++j;
				}
				while(j < newArray.length) {
					new_magmaFlow_y[j] = magmaFlow_y[j + y];
					++j;
				}
				tectonicPlates = newArray;
				magmaFlow_isGenerated = new_magmaFlow_isGenerated;
				magmaFlow_x = new_magmaFlow_x;
				magmaFlow_y = new_magmaFlow_y;
				//Shift the equator accordingly
				mid_tile_y -= tectonicPlateSize*y;
				if(initialize) {
					for(j = 0; j < -y; ++j) {
						for(int i = 0; i < tectonicPlates[0].length; ++i) {
							System.out.println("Generating tectonic plate " +
									(i + 1) + "," +
									(j + 1) + " of " +
									tectonicPlates[0].length + "," +
									tectonicPlates.length);
							generateTectonicPlate(i, j);
						}
					}
				}
				ret = true;
			}
		}else if(y > 0) {//north
			if(
					//If max_plate_y is less than 0, the map is probably not meant to expand any more than its current size
					0 < max_plate_y &&
					//No more plates if they'd be more than half of the max latitude of the world away from the equator
					//THE OLDER WAY OF DOING IT: ((tectonicPlates.length + y)*tectonicPlateSize - mid_tile_y) < (max_plate_y*tectonicPlateSize / 2)
					(tectonicPlates.length - getPlateYCoordinateFromTileIndex(mid_tile_y)) < (max_plate_y / 2)
					) {
				TectonicPlate[][] new_tectonicPlates = new TectonicPlate[tectonicPlates.length + y][];
				boolean[][] new_magmaFlow_isGenerated = new boolean[magmaFlow_isGenerated.length + y][];
				int[][] new_magmaFlow_x = new int[magmaFlow_x.length + y][];
				int[][] new_magmaFlow_y = new int[magmaFlow_y.length + y][];
				int j = 0;
				while(j < tectonicPlates.length) {
					new_tectonicPlates[j] = tectonicPlates[j];
					++j;
				}
				while(j < new_tectonicPlates.length) {
					new_tectonicPlates[j] = new TectonicPlate[tectonicPlates[0].length];
					++j;
				}
				j = 0;
				while(j < magmaFlow_isGenerated.length) {
					new_magmaFlow_isGenerated[j] = magmaFlow_isGenerated[j];
					++j;
				}
				while(j < new_magmaFlow_isGenerated.length) {
					new_magmaFlow_isGenerated[j] = new boolean[magmaFlow_isGenerated[0].length];
					++j;
				}
				j = 0;
				while(j < magmaFlow_x.length) {
					new_magmaFlow_x[j] = magmaFlow_x[j];
					++j;
				}
				while(j < new_magmaFlow_x.length) {
					new_magmaFlow_x[j] = new int[magmaFlow_x[0].length];
					++j;
				}
				j = 0;
				while(j < magmaFlow_y.length) {
					new_magmaFlow_y[j] = magmaFlow_y[j];
					++j;
				}
				while(j < new_magmaFlow_y.length) {
					new_magmaFlow_y[j] = new int[magmaFlow_y[0].length];
					++j;
				}
				tectonicPlates = new_tectonicPlates;
				magmaFlow_isGenerated = new_magmaFlow_isGenerated;
				magmaFlow_x = new_magmaFlow_x;
				magmaFlow_y = new_magmaFlow_y;
				if(initialize) {
					for(j = tectonicPlates.length - y; j < tectonicPlates.length; ++j) {
						for(int i = 0; i < tectonicPlates[0].length; ++i) {
							System.out.println("Generating tectonic plate " +
									(i + 1) + "," +
									(j + 1) + " of " +
									tectonicPlates[0].length + "," +
									tectonicPlates.length);
							generateTectonicPlate(i, j);
						}
					}
				}
				ret = true;
			}
		}
		return ret;
	}
	
	//TODO
	public void tick() {
		
		//for(all buildings) {
			/*
			Check for resources, produce...
			*/
		//}
		
		//TODO: Function that iterates over the array of buildings and deletes resources if decay is on: non-canned food, radioactive materials...
		
		//TODO: Function that calculates the GDP of each player from activity
		
	}
	
}
