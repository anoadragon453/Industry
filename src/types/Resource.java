package types;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import integerMath.Op;
import types.Typed.Typification;

@Typed(typification = Typification.INSTANCE)
public class Resource implements Nameable {
	
	// Static fields --------------------------------
	
	/**
	 * String identifying the type of object this is for name lookups.
	 */
	public static final String supertype = "resource";
	/**
	 * Global list of all resources loaded from the resource list files.
	 */
	public static ArrayList<Resource> resources = new ArrayList<Resource>();
	/**
	 * Global list of all natural resources loaded from the natural resource list file.
	 */
	public static ArrayList<NaturalResource> naturalResources = new ArrayList<NaturalResource>();
	/**
	 * Rarity accumulator used as the maximum random number for a context sensitive roulette wheel selection without looping.
	 */
	public static int naturalResourcesRarity = 0;
	/**
	 * Maximum versatility of all natural resources, updated whenever a resource with bigger versatility is added and used for random choosing.
	 */
	public static int naturalResourcesMaxVersatility = 0;
	/**
	 * Global list of all soil resources loaded from the soil resource list file.
	 */
	public static ArrayList<SoilResource> soilResources = new ArrayList<SoilResource>();
	/**
	 * Rarity accumulator used as the maximum random number for a context sensitive roulette wheel selection without looping.
	 */
	public static int soilResourcesRarity = 0;
	/**
	 * Global list of all mineral resources loaded from the mineral resource list file.
	 */
	public static ArrayList<MineralResource> mineralResources = new ArrayList<MineralResource>();
	/**
	 * Rarity accumulator used as the maximum random number for a context sensitive roulette wheel selection without looping.
	 */
	public static int mineralResourcesRarity = 0;
	/**
	 * Global list of all manufactured resources loaded from the manufactured resource list file.
	 */
	public static ArrayList<ManufacturedResource> manufacturedResources = new ArrayList<ManufacturedResource>();
	
	static {
		try {
			String naturalresources = new String(Files.readAllBytes(Paths.get("data\\resources.natural.csv")), StandardCharsets.UTF_8);
			if(!naturalresources.isEmpty()) {
				for(String line : naturalresources.split("\n")) {
					if(line.charAt(0) != '#') {
						String[] values = line.split(",");
						newNaturalResource(
								values[0].trim(),
								Integer.parseInt(values[1].trim()),
								values[2].trim().equals("t"),
								Integer.parseInt(values[3].trim()),
								Integer.parseInt(values[4].trim()),
								Integer.parseInt(values[5].trim()),
								Integer.parseInt(values[6].trim()),
								Integer.parseInt(values[7].trim())
								);
					}
				}
			}
			String soilresources = new String(Files.readAllBytes(Paths.get("data\\resources.soil.csv")), StandardCharsets.UTF_8);
			if(!soilresources.isEmpty()) {
				for(String line : soilresources.split("\n")) {
					if(line.charAt(0) != '#') {
						String[] values = line.split(",");
						newSoilResource(
								values[0].trim(),
								Integer.parseInt(values[1].trim()),
								Integer.parseInt(values[2].trim()),
								Integer.parseInt(values[3].trim())
								);
					}
				}
			}
			String mineralresources = new String(Files.readAllBytes(Paths.get("data\\resources.mineral.csv")), StandardCharsets.UTF_8);
			if(!mineralresources.isEmpty()) {
				for(String line : mineralresources.split("\n")) {
					if(line.charAt(0) != '#') {
						String[] values = line.split(",");
						newMineralResource(
								values[0].trim(),
								Integer.parseInt(values[1].trim()),
								values[2].trim().equals("t")
								);
					}
				}
			}
			String manufacturedresources = new String(Files.readAllBytes(Paths.get("data\\resources.manufactured.csv")), StandardCharsets.UTF_8);
			if(!manufacturedresources.isEmpty()) {
				for(String line : manufacturedresources.split("\n")) {
					if(line.charAt(0) != '#') {
						String[] values = line.split(",");
						newManufacturedResource(
								values[0].trim(),
								values[2].trim().equals("t")
								);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Class fields --------------------------------
	
	public int rarity;
	
	// Constructors --------------------------------
	
	private Resource(int rarity) {
		this.rarity = rarity;
	}
	
	public static void newNaturalResource(String type, int rarity, boolean edible, int optimalTemperature, int optimalHumidity, int versatility, int yield, int pollutionImpact) {
		NaturalResource resource = new NaturalResource(type, rarity, edible, optimalTemperature, optimalHumidity, versatility, yield, pollutionImpact);
		resources.add(resource);
		naturalResources.add(resource);
		naturalResourcesRarity += rarity;
		if(naturalResourcesMaxVersatility < versatility) {
			naturalResourcesMaxVersatility = versatility;
		}
	}
	
	public static void newSoilResource(String type, int rarity, int typicalHumidity, int fertility) {
		SoilResource resource = new SoilResource(type, rarity, typicalHumidity, fertility);
		resources.add(resource);
		soilResources.add(resource);
		soilResourcesRarity += rarity;
	}
	
	public static void newMineralResource(String type, int rarity, boolean solid) {
		MineralResource resource = new MineralResource(type, rarity, solid);
		resources.add(resource);
		mineralResources.add(resource);
		mineralResourcesRarity += rarity;
	}
	
	public static void newManufacturedResource(String type, boolean luxury) {
		ManufacturedResource resource = new ManufacturedResource(type, luxury);
		resources.add(resource);
		manufacturedResources.add(resource);
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
	
	@Override public String getType() {
		return supertype;
	}
	
	// Resource types --------------------------------
	
	public static class NaturalResource extends Resource {
		// Class fields --------------------------------
		@Typed.Type String type;
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
			return supertype + "." + type;
		}
	}
	
	public static class SoilResource extends Resource {
		// Class fields --------------------------------
		@Typed.Type String type;
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
			return supertype + "." + type;
		}
	}
	
	public static class MineralResource extends Resource {
		// Class fields --------------------------------
		@Typed.Type String type;
		public boolean solid;
		// Constructors --------------------------------
		private MineralResource(String type, int rarity, boolean solid) {
			super(rarity);
			this.solid = solid;
		}
		// Methods --------------------------------
		@Override public String getType() {
			return supertype + "." + type;
		}
	}
	
	public static class ManufacturedResource extends Resource {
		// Class fields --------------------------------
		@Typed.Type String type;
		public boolean luxury;
		// Constructors --------------------------------
		private ManufacturedResource(String type, boolean luxury) {
			super(0);
			this.type = type;
			this.luxury = luxury;
		}
		// Methods --------------------------------
		@Override public String getType() {
			return supertype + "." + type;
		}
	}
	
}
