package test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import classes.World;

public class TestDriver_1 {
	
	public static void main(String[] args) {
		test2();
	}
	
	public static void test1() {
		World w = new World(
				"0.0",//version
				(int)System.currentTimeMillis(),//seed
				8,//tectonicPlateSize
				1,//maxTectonicPlateInfluence
				0,//minTectonicPlateInfluence
				0,//crustThickness
				false, false,
				4, 4,//Starting plates
				64, 64, 8,//x, y, z
				16, 16, (byte) 4,//mid_x, mid_y, mid_z
				32,//temperatureAtEquator
				-64,//temperatureDifference
				4,//temperatureVariationByHeight
				1,//humanPlayerAmount
				3,//AIPlayerAmount
				100,//startingPopulation
				100//averagePopulationAge
				);
		
		printCardinals();
		printHeightMap(w);
		printInclinationMap(w, 0, 4, 0, 4);
		
	}
	
	public static void test2() {
		World w = new World(
				"0.0",//version
				(int)System.currentTimeMillis(),//seed
				16,//tectonicPlateSize
				6,//maxTectonicPlateInfluence, "continent size level"
				1,//minTectonicPlateInfluence, "continental cohesion level"
				16,//crustThickness
				false, false,//cycle
				32, 32,//Starting plates
				32, 32, 100,//x, y, z
				16, 16, (byte) 10,//mid_x, mid_y, mid_z
				32,//temperatureAtEquator
				-64,//temperatureDifference
				4,//temperatureVariationByHeight
				1,//humanPlayerAmount
				3,//AIPlayerAmount
				100,//startingPopulation
				100//averagePopulationAge
				);
		
		BufferedImage bi = new BufferedImage(
				w.tectonicPlates[0].length*w.tectonicPlateSize,
				w.tectonicPlates.length*w.tectonicPlateSize,
				BufferedImage.TYPE_INT_ARGB);
		
		for(int y = w.tectonicPlates.length - 1; y >= 0; --y) {//From most northern to most southern
			for(int j = w.tectonicPlateSize - 1; j >= 0 ; --j) {
				for(int x = 0; x < w.tectonicPlates[0].length; ++x) {//From most western to most eastern
					for(int i = 0; i < w.tectonicPlateSize; ++i) {
						if(w.tectonicPlates[y][x].height[j][i] < w.mid_tile_z) {
							
							int col = (0xFF << 24) |
									  (0 << 16) |
									  (0 << 8) |
									  ((0xFF - (w.mid_tile_z - w.tectonicPlates[y][x].height[j][i])*8));
							//max: 8*16 + 127 = 255
							//min: 0*16 + 127 = 127
							
							bi.setRGB(
									x*w.tectonicPlateSize + i,
									y*w.tectonicPlateSize + j,
									col
									);
						
						} else {
							
							int col = (0xFF << 24) |
									  (0 << 16) |
									  ((0xFF - (w.tectonicPlates[y][x].height[j][i] - w.mid_tile_z)*8) << 8) |
									  0;
							//absolute max_z: max_z*4
							//max: (16*4)*4
							
							bi.setRGB(
									x*w.tectonicPlateSize + i,
									y*w.tectonicPlateSize + j,
									col
									);
							
						}
						
						if(w.tectonicPlates[y][x].magma[j][i] >= w.tectonicPlates[y][x].height[j][i] + w.crustThickness) {
							
							int col = (0xFF << 24) |
									  ((w.tectonicPlates[y][x].magma[j][i]*8) << 16) |
									  (0 << 8) |
									  0;
							
							bi.setRGB(
									x*w.tectonicPlateSize + i,
									y*w.tectonicPlateSize + j,
									col
									);
							
						}
						
						if(j == 0 || j == w.tectonicPlateSize - 1 || i == 0 || i == w.tectonicPlateSize - 1) {
							
							bi.setRGB(
									x*w.tectonicPlateSize + i,
									y*w.tectonicPlateSize + j,
									(bi.getRGB(x*w.tectonicPlateSize + i, y*w.tectonicPlateSize + j) & 0x00FF0000 >>> 1) & 0x00FF0000 |
									(bi.getRGB(x*w.tectonicPlateSize + i, y*w.tectonicPlateSize + j) & 0x0000FF00 >>> 1) & 0x0000FF00 |
									(bi.getRGB(x*w.tectonicPlateSize + i, y*w.tectonicPlateSize + j) & 0x000000FF >>> 1) & 0x000000FF |
									0xFF000000
									);
							
						}
						
						
					}
				}
			}
		}
		
		File file = new File("C:\\Users\\Javier\\Desktop\\aa.png");
		try {
			ImageIO.write(bi, "PNG", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void printCardinals() {
		System.out.println(" N ");
		System.out.println("W E");
		System.out.println(" S ");
	}
	
	public static void printTectonicMap(World w) {
		for(int y = w.tectonicPlates.length - 1; y >= 0; --y) {//From most northern to most southern
			for(int x = 0; x < w.tectonicPlates[0].length; ++x) {//From most western to most eastern
				int greewichdistance = x*w.tectonicPlateSize - w.mid_tile_x;
				int equatordistance = y*w.tectonicPlateSize - w.mid_tile_y;
				if(w.tectonicPlates[y][x] == null){
					System.out.print("[n]");//"null"
				} else if(0 < greewichdistance && greewichdistance < w.tectonicPlateSize) {
					if(0 < equatordistance && equatordistance < w.tectonicPlateSize) {
						System.out.print("[c]");//"center"
					} else {
						System.out.print("[g]");//"greenwich"
					}
				} else if(0 < equatordistance && equatordistance < w.tectonicPlateSize) {
					System.out.print("[e]");//"equator"
				} else {
					System.out.print("[p]");//"plate"
				}
			}
			System.out.println("");
		}
	}
	
	public static void printHeightMap(World w){
		for(int y = w.tectonicPlates.length - 1; y >= 0; --y) {//From most northern to most southern
			for(int j = w.tectonicPlateSize - 1; j >= 0 ; --j) {
				for(int x = 0; x < w.tectonicPlates[0].length; ++x) {//From most western to most eastern
					for(int i = 0; i < w.tectonicPlateSize; ++i) {
						if(w.tectonicPlates[y][x] == null) {
							System.out.print("[nul]");
						} else if(w.tectonicPlates[y][x].height[j][i] <= w.tectonicPlates[y][x].water[j][i]) {
							System.out.print(
									"[u" +
									String.format("%02d", w.mid_tile_z - w.tectonicPlates[y][x].height[j][i]) +
									"]"
							);
						} else {
							System.out.print(
									"[" +
									String.format("%03d", w.tectonicPlates[y][x].height[j][i] - w.mid_tile_z) +
									"]"
							);
						}
					}
				}
				System.out.println("");
			}
		}
	}
	
	public static void printInclinationMap(World w, int x_initial, int x_end, int y_initial, int y_end) {
		for(int y = y_initial; y < y_end; ++y) {//From most northern to most southern
			for(int j = 0; j < w.tectonicPlateSize; ++j) {
				for(int x = x_initial; x < x_end; ++x) {//From most western to most eastern
					for(int i = 0; i < w.tectonicPlateSize; ++i) {
						/*
						 * TODO: GET OTHER SHIT DYNAMICALLY BY COORDINATES INSTEAD OF INDICES
						 * OTHERWISE, THE MAP MAY EXPAND BEFORE THE LOOP IS OVER AND FUCK IT UP
						 */
						if(w.getTectonicPlate(x, y) == null) {
							System.out.print("[nul]");
						} else {
							System.out.print(
									"[" +
									w.getInclinationFromCoordinate(
											w.getTileXCoordinateFromTileIndex(x*w.tectonicPlateSize + i),
											w.getTileYCoordinateFromTileIndex(y*w.tectonicPlateSize + j)
											) +
									"]"
							);
						}
					}
				}
				System.out.println("");
			}
		}
	}
	
	public static void printWaterMap(World w) {
		for(int y = w.tectonicPlates.length - 1; y >= 0; --y) {//From most northern to most southern
			for(int j = w.tectonicPlateSize - 1; j >= 0 ; --j) {
				for(int x = 0; x < w.tectonicPlates[0].length; ++x) {//From most western to most eastern
					for(int i = 0; i < w.tectonicPlateSize; ++i) {
						if(w.tectonicPlates[y][x] == null) {
							System.out.print("[nul]");
						} else if(w.tectonicPlates[y][x].water[j][i] >= w.tectonicPlates[y][x].height[j][i]) {
							System.out.print(
									"[w" +
									String.format("%02d", w.tectonicPlates[y][x].water[j][i]) +
									"]"
							);
						} else {
							System.out.print(
									"[h" +
									String.format("%02d", w.tectonicPlates[y][x].water[j][i]) +
									"]"
							);
						}
					}
				}
				System.out.println("");
			}
		}
	}
	
	public static void printMagmaMap(World w) {
		for(int y = w.tectonicPlates.length - 1; y >= 0; --y) {//From most northern to most southern
			for(int j = w.tectonicPlateSize - 1; j >= 0 ; --j) {
				for(int x = 0; x < w.tectonicPlates[0].length; ++x) {//From most western to most eastern
					for(int i = 0; i < w.tectonicPlateSize; ++i) {
						if(w.tectonicPlates[y][x] == null) {
							System.out.print("[nul]");
						} else {
							System.out.print(
									"[" +
									String.format("%03d", w.tectonicPlates[y][x].magma[j][i]) +
									"]"
									);
						}
					}
				}
				System.out.println("");
			}
		}
	}
	
	public static void printTemperatureMap(World w) {
		for(int y = w.tectonicPlates.length - 1; y >= 0; --y) {//From most northern to most southern
			for(int j = w.tectonicPlateSize - 1; j >= 0 ; --j) {
				for(int x = 0; x < w.tectonicPlates[0].length; ++x) {//From most western to most eastern
					for(int i = 0; i < w.tectonicPlateSize; ++i) {
						if(w.tectonicPlates[y][x] == null) {
							System.out.print("[nul]");
						} else {
							System.out.print("[" +
									//String.format("%03d", w.tectonicPlates[y][x].temperature[j][i]) +
									"]"
									);
						}
					}
				}
				System.out.println("");
			}
		}
	}
}
