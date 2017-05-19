package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import types.Typed.Typification;

@Typed(typification = Typification.FIELD)
public class Citizen implements ProperlyNameable, Externalizable {
	
	// Static fields --------------------------------
	
	static final String supertype = "citizen";
	/**
	 * Array of the names of all job types for looking up the name in the properties files.
	 */
	public static ArrayList<String> types = new ArrayList<String>();
	static final int NEEDS_ARRAY_SIZE = 6;
	static final int IDEOLOGY_ARRAY_SIZE = 4;
	static final int SKILLS_ARRAY_SIZE = 5;
	static final int POSESSIONS_ARRAY_SIZE = 0;
	
	static {
		try {
			String types = new String(Files.readAllBytes(Paths.get("data\\citizen.types.csv")), StandardCharsets.UTF_8);
			if(!types.isEmpty()) {
				for(String line : types.split("\n")) {
					if(line.charAt(0) != '#') {
						Citizen.types.add(line);
					}
				}
			}
		} catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
	// Class fields --------------------------------
	
	/**
	 * This citizen's name.
	 */
	public String name;
	/**
	 * Building where this unit lives.
	 */
	public Building home;
	/**
	 * Building where this citizen works.
	 */
	public Building workplace;
	/**
	 * Type of this citizen (its current work or age or disability if can't work).
	 */
	@Typed.Type public int type;
	/**
	 * Parents of this citizen. May be null.
	 */
	public Citizen father, mother;
	/**
	 * Children of this citizen.
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
	 * Information about this citizen's sex:
	 * -0000000 : pregnancy state
	 * 0------- : sex
	 */
	public byte sex;
	/**
	 * ID of the sickness affecting this citizen, -1 if none.
	 */
	public byte sickness;
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
	public byte[] skills;
	/**
	 * Shit this citizen owns.
	 */
	public byte[] posessions;
	/**
	 * Country this citizen belongs to.
	 */
	public Country country;
	
	// Constructors --------------------------------
	
	/**
	 * 
	 * @param home
	 * @param father
	 * @param mother
	 * @param birthDate
	 * @param owner
	 */
	public Citizen(String name, Building home, Citizen father, Citizen mother, int birthDate, byte sex, byte belief, byte[] ideology, Country country) {
		this.name = name;
		this.home = home;
		this.workplace = null;
		this.type = 0;
		this.father = father;
		this.mother = mother;
		if(father != null) {
			father.addChild(this);
		}
		if(mother != null) {
			mother.addChild(this);
		}
		this.offspring = new Citizen[0];
		this.birthDate = birthDate;
		this.deathDate = -1;
		this.sex = sex;
		this.sickness = 0;
		this.needs = new byte[NEEDS_ARRAY_SIZE];
		//TODO: ADD SOME DATA TO THE NEEDS ARRAY, 0 EVERYTHING WOULD IMPLY THE NEW CITIZEN IS ABOUT TO DIE
		this.belief = belief;
		this.ideology = ideology;
		this.skills = new byte[SKILLS_ARRAY_SIZE];
		this.posessions = new byte[POSESSIONS_ARRAY_SIZE];
		this.country = country;
	}
	
	// Object methods --------------------------------
	
	@Override public String toString() {
		return
				"[" + this.getType() +
				"F" + String.format("%11d", birthDate) +
				"@" + String.format("%11d", home) +
				"," + String.format("%11d", workplace) +
				"~" + String.format("%11d", country) +
				"]";
	}
	
	@Override public int hashCode() {
		return birthDate + country.hashCode()*31;
	}
	
	@Override public boolean equals(Object object) {
		if(object instanceof Citizen) {
			return
					this.mother == ((Citizen)object).mother &&
					this.birthDate == ((Citizen)object).birthDate;
		}
		return false;
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return Citizen.supertype + "." + types.get(type);
	}
	
	public String getProperName() {
		return name;
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
	
	public Sickness getSickness() {
		return sickness < 0 ? null : Sickness.getSickness(sickness);
	}
	
	public void setSickness(byte sickness) {
		this.sickness = sickness;
	}
	
	/**
	 * Returns the state of the citizen's pregnancy in months pregnant.
	 */
	public int getPregnancyState() {
		return sex & 0b01111111;
	}
	
	/**
	 * If female and not pregnant, it makes the citizen pregnant.
	 */
	public void makePregnant() {
		if(sex == 0) {//if female and non pregnant
			sex = 1;//set to pregnant
		}
	}
	
	public boolean isFemale() {
		return sex >= 0;
	}
	
	public boolean isMale() {
		return sex < 0;
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
			acum = acum + Math.abs(this.ideology[i] - player.ideology[i]);
		}
		return acum;
	}
	
	public void tick() {
		if(sickness >= 0) {
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
			//Reduce health if citizen is sick
			if(sickness >= 0) {
				needs[0] -= Sickness.getSickness(sickness).lethality;
			}
			//Sicknesses only last for a month. If a citizen is sick, the sickness is unset automatically as part of the tick.
			setSickness((byte) -1);
		}
		
		/*
		 * TODO: Overwrite needs whose satisfaction has changed.
		 */
		
		//Reduce health depending on how basic needs are going.
		needs[0] = (byte) (needs[0] - needs[1] - needs[2]);
		
		if(needs[0] <= 0) {
			//TODO: kill
		}
		
		if(sex > 0) {//is female and pregnant
			if(sex >= 10) {//pregnancy has been going on for 10 months or more
				//TODO: BIRTH
				sex = 0;
			} else {
				++sex;
			}
		}
	}

	@Override public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
