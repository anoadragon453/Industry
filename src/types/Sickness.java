package types;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import types.Typed.Typification;

@Typed(typification = Typification.INSTANCE)
public class Sickness {
	
	// Static fields --------------------------------
	
	public static final String supertype = "sickness";
	
	/**
	 * Global list of all sicknesses loaded from the sickness list file.
	 */
	public static ArrayList<Sickness> sicknesses = new ArrayList<Sickness>();
	
	static {
		try {
			String sicknesses = new String(Files.readAllBytes(Paths.get("data\\sicknesses.csv")), StandardCharsets.UTF_8);
			if(!sicknesses.isEmpty()) {
				for(String line : sicknesses.split("\n")) {
					if(line.charAt(0) != '#') {
						String[] values = line.split(",");
						newSickness(
								values[0].trim(),
								Integer.parseInt(values[1].trim()),
								Integer.parseInt(values[2].trim())
								);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// Class fields --------------------------------
	
	public final String type;
	/**
	 * Likelihood of contagion.
	 */
	public int infectivity;
	/**
	 * Amount of damage it causes.
	 */
	public int lethality;
	
	// Constructors --------------------------------
	
	private Sickness(String type, int infectivity, int lethality){
		this.type = type;
		this.infectivity = infectivity;
		this.lethality = lethality;
	}
	
	public static void newSickness(String type, int infectivity, int lethality) {
		sicknesses.add(new Sickness(type, infectivity, lethality));
	}
	
	// Functions --------------------------------
	
	public static Sickness getSickness(int index) {
		if(index < 0) {
			return null;
		} else {
			return sicknesses.get(index);
		}
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return Sickness.supertype + "." + this.type;
	}
	
}