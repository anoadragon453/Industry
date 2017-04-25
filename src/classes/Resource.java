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
		newNaturalResource("wheat"     ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("corn"      ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("rice"      ,   0,true ,   0,   0,   0,   0,   1);//Humidity of 0: it may generate on shallow water or swampy land
		newNaturalResource("legumes"   ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("soy"       ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("palm"      ,   0,true ,   0,   0,   0,   0,  -6);
		newNaturalResource("ananas"    ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("banana"    ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("canes"     ,   0,false,   0,   0,   0,   0,  -1);//Humidity of 0: it may generate on shallow water or swampy land
		newNaturalResource("oak"       ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("rubbertree",   0,false,   0,   0,   0,   0,  -6);
		newNaturalResource("mahogany"  ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("birch"     ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("eucalypt"  ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("beech"     ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("ash"       ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("maple"     ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("fir"       ,   0,false,   0,   0,   0,   0,  -8);
		newNaturalResource("tea"       ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("coffee"    ,   0,false,   0,   0,   0,   0,  -2);
		newNaturalResource("cocoa"     ,   0,false,   0,   0,   0,   0,  -4);
		newNaturalResource("berries"   ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("cacti"     ,   0,true ,   0,   0,   0,   0,  -1);
		newNaturalResource("cabbage"   ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("tubers"    ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("tobacco"   ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("coca"      ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("cotton"    ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("flax"      ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("hemp"      ,   0,false,   0,   0,   0,   0,   1);
		newNaturalResource("algae"     ,   0,true ,   0,  -8,   0,   0,  -3);//Negative landLevel - waterLevel means the water level is over land
		newNaturalResource("cow"       ,   0,true ,   0,   0,   0,   0,   1);//Per tile, of course. Take into account that you need 100 tiles to maintain a cow.
		newNaturalResource("sheep"     ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("goat"      ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("llama"     ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("pig"       ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("chicken"   ,   0,true ,   0,   0,   0,   0,   1);
		newNaturalResource("tuna"      ,   0,true ,   0,  -8,   0,   0,   1);//Negative landLevel - waterLevel means the water level is over land
		newNaturalResource("salmon"    ,   0,true ,   0,  -8,   0,   0,   1);//Negative landLevel - waterLevel means the water level is over land
		newNaturalResource("carp"      ,   0,true ,   0,  -8,   0,   0,   1);//Negative landLevel - waterLevel means the water level is over land
		newNaturalResource("bass"      ,   0,true ,   0,  -8,   0,   0,   1);//Negative landLevel - waterLevel means the water level is over land
		newSoilResource("limestone",   0,   0,  -8);
		newSoilResource("sand"     ,   0,   4,  -4);
		newSoilResource("silt"     ,   0,   8,   2);
		newSoilResource("clay"     ,   0,  16,   0);
		newSoilResource("peat"     ,   0,  32,   4);
	}
	
	// Class fields --------------------------------
	
	public int rarity;
	
	// Constructors --------------------------------
	
	private Resource(int rarity) {
		this.rarity = rarity;
	}
	
	public static void newNaturalResource(String type, int rarity, boolean edible, int optimalTemperature, int optimalHumidity, int versatility, int yield, int pollutionImpact) {
		naturalResources.add(new NaturalResource(type, rarity, edible, optimalTemperature, optimalHumidity, versatility, yield, pollutionImpact));
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
		public boolean edible;
		public int optimalTemperature;
		public int optimalHumidity;
		/**
		 * How resistant this resource is to different temperatures and humidities.
		 */
		public int versatility;
		public int yield;
		/**
		 * Variation of pollution the presence of this resource causes.
		 */
		public int pollutionImpact;
		// Constructors --------------------------------
		private NaturalResource(String type, int rarity, boolean edible, int optimalTemperature, int optimalHumidity, int versatility, int yield, int pollutionImpact) {
			super(rarity);
			this.type = type;
			this.edible = edible;
			this.optimalTemperature = optimalTemperature;
			this.optimalHumidity = optimalHumidity;
			this.versatility = versatility;
			this.yield = yield;
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
		public int typicalHumidity;
		/**
		 * How fertile this resource makes the soil.
		 */
		public int fertility;
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
		public boolean solid;
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
		public boolean luxury;
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
