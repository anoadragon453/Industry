package types;

import java.io.Serializable;

public class Citizen implements Nameable, Serializable {
	
	// Static fields --------------------------------
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7411150192939216900L;
	
	static final String type = "citizen";
	
	/**
	 * Array of the names of all job types for looking up the name in the properties files.
	 */
	public static String[] types = {
			"unemployed"
			//TODO: ADD ALL JOB TYPES
	};
	
	public static class Sickness {
		
		public String type;
		/**
		 * Likelihood of contagion.
		 */
		public int infectivity;
		/**
		 * Amount of damage it causes.
		 */
		public int lethality;
		
		public Sickness(String type, int infectivity, int lethality){
			this.type = type;
			this.infectivity = infectivity;
			this.lethality = lethality;
		}
		
	}
	
	/**
	 * Array of all sickness types.
	 */
	//TODO: LOAD THIS FROM A FILE INSTEAD OF HARD CODING EVERYTHING
	public static Sickness[] sicknesses = {
			null,//"healthy", 0, 0
			new Sickness("flu", 10, 1),
			new Sickness("dengue", 9, 2),
			new Sickness("tuberculosis", 10, 3),
			new Sickness("pertussis", 5, 5),
			new Sickness("diphtheria", 5, 3),
			new Sickness("rubella", 5, 3),
			new Sickness("variola", 10, 4),
			new Sickness("ebola", 6, 10),
			new Sickness("malaria", 6, 7),
			new Sickness("plague", 8, 8),
			new Sickness("brainbug", 6, 9),
	};
	
	// Class fields --------------------------------
	
	/**
	 * ID of the building where this unit lives; -1 if homeless
	 */
	public Building home;
	/**
	 * ID of the building where this unit works; -1 if unemployed
	 */
	public Building workplace;
	/**
	 * ID of the job of this citizen. 0 if unemployed.
	 */
	public int instancetype;
	/**
	 * IDs of the parents of this citizen; negative if this citizen was generated with the world.
	 */
	public Citizen father, mother;
	/**
	 * IDs of the offspring of this citizen.
	 */
	public Citizen[] offspring;
	/**
	 * Month when this citizen was born.
	 */
	public int birthDate;
	/**
	 * Month when this citizen died; -1 if it's still alive.
	 */
	public int deathDate;
	/**
	 * Indicates the physical properties of this citizen:
	 * ----0000 : sickness
	 * -000---- : pregnancy state
	 * 0------- : sex
	 */
	public byte constitution;
	/**
	 * Indicates the state of the needs of this citizen:
	 * needs[0] : health
	 * needs[1] : food
	 * needs[2] : heat
	 * needs[3] : political satisfaction
	 * needs[4] : security
	 * needs[5] : entertainment
	 */
	public byte[] needs;
	/**
	 * Religious beliefs of the citizen.
	 */
	public byte belief;
	/**
	 * Array of the value of opinions this citizen has.
	 * ideology[0] : Authoritarianism - Libertarism
	 * ideology[1] : Individualism - Collectivism
	 * ideology[2] : Nationalism - Globalism
	 * ideology[3] : Industrialism - Conservationism
	 */
	public byte[] ideology;
	/**
	 * Array of the value of different skills this citizen has.
	 * 
	 * skill[0] : strength
	 *            Affects athletic performance and combat skills.
	 * skill[1] : creativity
	 *            Affects content creation and problem solving.
	 * skill[2] : engineering
	 *            Affects machinery operation and hard science skills.
	 * skill[3] : biology
	 *            Affects breeding and healing skills.
	 * skill[4] : psychology
	 *            Affects leading and diplomacy skills.
	 */
	public byte[] skill;
	/**
	 * Shit this citizen owns
	 */
	public byte[] posessions;
	/**
	 * ID of the player whose civilization this citizen belongs to
	 */
	public Player owner;
	
	// Constructors --------------------------------
	
	/**
	 * 
	 * @param home
	 * @param father
	 * @param mother
	 * @param birthDate
	 * @param owner
	 */
	public Citizen(Building home, Citizen father, Citizen mother, int birthDate, Player owner) {
		this.home = home;
		this.workplace = null;
		(this.father = father).addChild(this);
		(this.mother = mother).addChild(this);
		this.offspring = new Citizen[0];
		this.birthDate = birthDate;
		this.deathDate = -1;
		//TODO: initialize constitution with random gender.
		//TODO: calculate happiness
		//TODO: calculate ideology
		//TODO: initialize other fields
		this.owner = owner;
	}
	
	// Object methods --------------------------------
	
	@Override public String toString() {
		return
				"[" + this.getType() +
				"F" + String.format("%11d", birthDate) +
				"@" + String.format("%11d", home) +
				"," + String.format("%11d", workplace) +
				"~" + String.format("%11d", owner) +
				"]";
	}
	
	@Override public int hashCode() {
		return birthDate + owner.hashCode()*31;
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof Citizen) {
			return
					this.father == ((Citizen)object).father &&
					this.mother == ((Citizen)object).mother &&
					this.birthDate == ((Citizen)object).birthDate &&
					this.owner == ((Citizen)object).owner;
		}
		return false;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return Citizen.type + "." + types[instancetype];
	}
	
	public void addChild(Citizen child) {
		int i = 0;
		Citizen[] temp = new Citizen[offspring.length + 1];
		while(i < offspring.length) {
			temp[i] = offspring[i++];
		}
		temp[i] = child;
		offspring = temp;
	}
	
	public boolean isSick() {
		return (constitution & 0b00001111) == 0;
	}
	
	public int getSickness() {
		return constitution & 0b00001111;
	}
	
	public String getSicknessType() {
		return isSick() ? "sickness.healthy" : "sickness." + sicknesses[getSickness()].type;
	}
	
	public void setSickness(byte sickness) {
		if(!isSick()){
			constitution += sickness;
		}
	}
	
	public void setSicknessHealthy() {
		constitution &= 0b11110000;
	}
	
	/**
	 * Returns the state of the citizen's pregnancy in months pregnant.
	 */
	public int getPregnancyState() {
		return constitution & 0b01110000;
	}
	
	/**
	 * If female and not pregnant yet, it makes the citizen 1 month pregnant.
	 */
	public void makePregnant() {
		if((constitution & 0b11110000) == 0) {//if female (0b0---) and non pregnant (0b-000)
			constitution += 0b00010000;//set to 1 month pregnant
		}
	}
	
	public boolean isFemale() {
		return constitution >= 0;
	}
	
	public boolean isMale() {
		return constitution < 0;
	}
	
	public int getOpinionOnPlayer(Player player) {
		int acum = 0;
		for(int i = 0; i < this.ideology.length; ++i) {
			/* The more similar ideology[i] and personality[i] are, the more favorable the opinion will be.
			 * Similar opinions will yield positive results (negative * negative = positive * positive = positive)
			 * Opposing opinions will yield negative results (negative * positive = positive * negative = negative)
			 * Coinciding in more extremist opinions will yield stronger levels of agreement.
			 * More moderate opinions will yield more neutral results.
			 */
			acum = acum + this.ideology[i] * player.ideology[i];
		}
		return acum;
	}
	
	public void tick() {
		if(isSick()) {
			for(Citizen citizen : home.getCitizens()) {
				/* 
				 * TODO: For every citizen, there's a likelihood equivalent to the sickness's infectivity to set them to the same sickness.
				 */
			}
			for(Citizen citizen : workplace.getCitizens()) {
				/* 
				 * TODO: For every citizen, there's a likelihood equivalent to the sickness's infectivity to set them to the same sickness.
				 */
			}
			//reduce health
			needs[0] -= sicknesses[getSickness()].lethality;
			//Sicknesses only last for a month. If a citizen is sick, the sickness is unset automatically as part of the tick.
			setSicknessHealthy();
		}
		
		/*
		 * TODO: Overwrite needs whose satisfaction has changed.
		 */
		
		//Reduce health depending on how basic needs are going.
		needs[0] = (byte) (needs[0] - needs[1] - needs[2]);
		
		if(needs[0] <= 0) {
			//TODO: kill
		}
	}
	
}
