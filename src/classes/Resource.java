package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		try {
			String naturalresources = new String(Files.readAllBytes(Paths.get("data\\resources.natural.csv")), StandardCharsets.UTF_8);
			for(String line : naturalresources.split("\n")) {
				String[] values = line.split(",");
				newNaturalResource(
						values[0].trim(),
						Integer.parseInt(values[1].trim()),
						values[2].trim().startsWith("t"),
						Integer.parseInt(values[3].trim()),
						Integer.parseInt(values[4].trim()),
						Integer.parseInt(values[5].trim()),
						Integer.parseInt(values[6].trim()),
						Integer.parseInt(values[7].trim())
						);
			}
			String soilresources = new String(Files.readAllBytes(Paths.get("data\\resources.soil.csv")), StandardCharsets.UTF_8);
			for(String line : soilresources.split("\n")) {
				String[] values = line.split(",");
				newSoilResource(
						values[0].trim(),
						Integer.parseInt(values[1].trim()),
						Integer.parseInt(values[2].trim()),
						Integer.parseInt(values[3].trim())
						);
			}
			String mineralresources = new String(Files.readAllBytes(Paths.get("data\\resources.mineral.csv")), StandardCharsets.UTF_8);
			for(String line : mineralresources.split("\n")) {
				String[] values = line.split(",");
				newMineralResource(
						values[0].trim(),
						Integer.parseInt(values[1].trim()),
						values[2].trim().startsWith("t")
						);
			}
			String manufacturedresources = new String(Files.readAllBytes(Paths.get("data\\resources.manufactured.csv")), StandardCharsets.UTF_8);
			for(String line : manufacturedresources.split("\n")) {
				String[] values = line.split(",");
				newManufacturedResource(
						values[0].trim(),
						values[2].trim().startsWith("t")
						);
			}
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		for(Resource r : naturalResources) {
			System.out.println(r.getType());
		}
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
