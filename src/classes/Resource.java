package classes;

import java.util.ArrayList;

import integerMath.Op;

/**
 * Resource is a "type" class, that is, its types are represented as instances and its getType method calls non-static fields.
 * @author Javier
 *
 */
public class Resource implements Nameable {
	
	// Static fields --------------------------------
	
	/**
	 * 
	 */
	public static final String type = "resource";
	public static ArrayList<NaturalResource> naturalResources = new ArrayList<NaturalResource>();
	public static int naturalResourcesRarity = 0;
	public static int naturalResourcesMaxVersatility = 0;
	public static ArrayList<SoilResource> soilResources = new ArrayList<SoilResource>();
	public static int soilResourcesRarity = 0;
	public static ArrayList<MineralResource> mineralResources = new ArrayList<MineralResource>();
	public static int mineralResourcesRarity = 0;
	public static ArrayList<ManufacturedResource> manufacturedResources = new ArrayList<ManufacturedResource>();
	
	static {
		newNaturalResource("wheat"     ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("corn"      ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("rice"      ,   0,   0,   0,   0,   1,   0,true );//Humidity of 0: it may generate on shallow water or swampy land
		newNaturalResource("legumes"   ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("soy"       ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("palm"      ,   0,   0,   0,   0,  -6,   0,true );
		newNaturalResource("ananas"    ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("banana"    ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("canes"     ,   0,   0,   0,   0,  -1,   0,false);//Humidity of 0: it may generate on shallow water or swampy land
		newNaturalResource("oak"       ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("rubbertree",   0,   0,   0,   0,  -6,   0,false);
		newNaturalResource("birch"     ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("eucalypt"  ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("beech"     ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("ash"       ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("maple"     ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("fir"       ,   0,   0,   0,   0,  -8,   0,false);
		newNaturalResource("flowers"   ,   0,   0,   0,   0,  -1,   0,false);
		newNaturalResource("tea"       ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("coffee"    ,   0,   0,   0,   0,  -2,   0,false);
		newNaturalResource("cocoa"     ,   0,   0,   0,   0,  -4,   0,false);
		newNaturalResource("berries"   ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("cacti"     ,   0,   0,   0,   0,  -1,   0,true );
		newNaturalResource("cabbage"   ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("tubers"    ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("tobacco"   ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("coca"      ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("cotton"    ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("flax"      ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("hemp"      ,   0,   0,   0,   0,   1,   0,false);
		newNaturalResource("algae"     ,   0,   0,  -8,   0,  -3,   0,true );//Negative landLevel - waterLevel means the water level is over land
		newNaturalResource("cow"       ,   0,   0,   0,   0,   1,   0,true );//Per tile, of course. Take into account that you need 100 tiles to maintain a cow.
		newNaturalResource("sheep"     ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("goat"      ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("llama"     ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("pig"       ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("chicken"   ,   0,   0,   0,   0,   1,   0,true );
		newNaturalResource("fish"      ,   0,   0,  -8,   0,   1,   0,true );//Negative landLevel - waterLevel means the water level is over land
		newSoilResource("limestone",   0,   0,   0);
		newSoilResource("sand"     ,   0,   4,   1);
		newSoilResource("silt"     ,   0,   8,   3);
		newSoilResource("clay"     ,   0,  16,   2);
		newSoilResource("peat"     ,   0,  32,   3);
	}
	
	// Class fields --------------------------------
	
	public int rarity;
	
	// Constructors --------------------------------
	
	private Resource(int rarity) {
		this.rarity = rarity;
	}
	
	public static void newNaturalResource(String type, int rarity, int optimalTemperature, int optimalHumidity, int versatility, int pollutionImpact, int harvest, boolean edible) {
		naturalResources.add(new NaturalResource(type, rarity, optimalTemperature, optimalHumidity, versatility, pollutionImpact, harvest, edible));
		naturalResourcesRarity += rarity;
		if(naturalResourcesMaxVersatility < versatility) {
			naturalResourcesMaxVersatility = versatility;
		}
	}
	
	public static void newSoilResource(String type, int rarity, int typicalHumidity, int fertility) {
		soilResources.add(new SoilResource(type, rarity, typicalHumidity, fertility));
		soilResourcesRarity += rarity;
	}
	
	public static void newMineralResource(String type, int rarity, boolean solid) {
		mineralResources.add(new MineralResource(type, rarity, solid));
		mineralResourcesRarity += rarity;
	}
	
	public static void newManufacturedResource(String type, boolean luxury) {
		manufacturedResources.add(new ManufacturedResource(type, luxury));
	}
	
	// Object methods --------------------------------
	
	@Override public String toString() {
		return
				"[" + this.getType() +
				"]";
	}
	
	@Override public int hashCode(){
		return this.getType().hashCode();
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof Resource) {
			return this.getType() == ((Resource)object).getType();
		}
		return false;
	}
	
	// Resource getter --------------------------------
	
	public static NaturalResource chooseNaturalResource(int randomInt, int temperature, int humidity) {
		randomInt = Op.trueModulus(randomInt, naturalResourcesRarity*naturalResourcesMaxVersatility*2);
		int index = 0;
		NaturalResource resource = null;
		int temperatureDifference;
		int humidityDifference;
		while(randomInt > 0) {
			resource = naturalResources.get(index++);
			if(index == naturalResources.size()) {
				index = 0;
			}
			temperatureDifference = Op.abs(resource.optimalTemperature - temperature);
			humidityDifference = Op.abs(resource.optimalHumidity - humidity);
			if(temperatureDifference < resource.versatility && humidityDifference < resource.versatility) {
				randomInt -= resource.rarity*(resource.versatility - temperatureDifference + resource.versatility - humidityDifference);
			}
		}
		return resource;
	}
	
	public static SoilResource chooseSoilResource(int humidity) {
		SoilResource resource = null;
		int index = 0;
		while(soilResources.get(index).typicalHumidity < humidity) {
			resource = soilResources.get(index++);
		}
		return resource;
	}
	
	public static MineralResource chooseMineralResource(int randomInt) {
		randomInt = Op.trueModulus(randomInt, mineralResourcesRarity);
		int index = 0;
		MineralResource resource = null;
		while(randomInt > 0) {
			resource = mineralResources.get(index++);
			randomInt -= resource.rarity;
		}
		return resource;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return type;
	}
	
	// Resource types --------------------------------
	
	public static class NaturalResource extends Resource {
		// Class fields --------------------------------
		String type;
		boolean edible;
		/**
		 * Month of harvest. -1 if none.
		 */
		int harvest;
		int optimalTemperature;
		int optimalHumidity;
		/**
		 * How resistant this resource is to different temperatures and humidities.
		 */
		int versatility;
		/**
		 * Variation of pollution the presence of this resource causes.
		 */
		int pollutionImpact;
		// Constructors --------------------------------
		private NaturalResource(String type, int rarity, int optimalTemperature, int optimalHumidity, int versatility, int pollutionImpact, int harvest, boolean edible) {
			super(rarity);
			this.type = type;
			this.edible = true;
			this.harvest = harvest;
			this.optimalTemperature = optimalTemperature;
			this.optimalHumidity = optimalHumidity;
			this.versatility = versatility;
			this.pollutionImpact = pollutionImpact;
		}
		// Methods --------------------------------
		@Override public String getType() {
			return Resource.type + "." + this.type;
		}
	}
	
	public static class SoilResource extends Resource {
		// Class fields --------------------------------
		String type;
		int typicalHumidity;
		/**
		 * How fertile this resource makes the soil.
		 */
		int fertility;
		// Constructors --------------------------------
		private SoilResource(String type, int rarity, int typicalHumidity, int fertility) {
			super(rarity);
			this.type = type;
			this.typicalHumidity = typicalHumidity;
			this.fertility = fertility;
		}
		// Methods --------------------------------
		@Override public String getType() {
			return Resource.type + "." + this.type;
		}
	}
	
	public static class MineralResource extends Resource {
		// Class fields --------------------------------
		String type;
		boolean solid;
		// Constructors --------------------------------
		private MineralResource(String type, int rarity, boolean solid) {
			super(rarity);
			this.solid = solid;
		}
		// Methods --------------------------------
		@Override public String getType() {
			return Resource.type + "." + this.type;
		}
	}
	
	public static class ManufacturedResource extends Resource {
		// Class fields --------------------------------
		String type;
		boolean luxury;
		// Constructors --------------------------------
		private ManufacturedResource(String type, boolean luxury) {
			super(0);
			this.type = type;
			this.luxury = luxury;
		}
		// Methods --------------------------------
		@Override public String getType() {
			return Resource.type + "." + this.type;
		}
	}
	
}
