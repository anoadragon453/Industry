package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import types.Amount;
import types.Typed.Typification;

@Typed(typification = Typification.GLOBAL)
public class TectonicPlate implements ProperlyNameable, Externalizable {
	
	// Static fields --------------------------------
	
	/*
	 * TODO: Make a tectonic plate's type its shape? Mountain, ocean, lake, plain, valley, coast, river...
	 * If I go with this, I have to change the @Typed annotation and remove the @Typed.Type annotation
	 */
	@Typed.Type public static final String type = "plate";
	
	// Class fields --------------------------------
	
	/**
	 * Proper name given to this province.
	 */
	public String name;
	/**
	 * Country this tectonic plate ("province") belongs to. -1 if it hasn't been claimed yet.
	 * Players can make territorial claims of plates that aren't owned or other players own.
	 * If no one else claims them, they belong to the player who claimed them.
	 * Upon conflict, treaties or wars can be made.
	 */
	public Country country;
	/**
	 * Can lock tectonic plates to put them in quarantine. Quarantine has to be enforced by security. It can be breached by units or civilians.
	 */
	public boolean unlocked;
	/**
	 * 
	 */
	public byte[][] magma;
	public byte[][] height;
	public byte[][] water;
	public byte[][] pollution;
	/**
	 * Map representing the natural resources of the tiles that comprise this tectonic plate.
	 */
	public byte[][] naturalResourcesIn;
	/**
	 * Map representing the soil resources of the tiles that comprise this tectonic plate.
	 */
	public byte[][] soilResourcesIn;
	/**
	 * Map indicating which of the listed amounts is present in each tile by the index or the index offset by the minimum value if its a foreign amount. -1 if no amount.
	 */
	public byte[][] amountsIn;
	public Amount[] amountsList;
	public Amount[] amountsForeignList;
	/**
	 * Map indicating which of the listed elements is present in each tile by the index or the index offset by the minimum value if its a foreign element. -1 if no element.
	 */
	public short[][] elementsIn;
	public Element[] elementsList;
	public Element[] elementsForeignList;
	/**
	 * 
	 */
	public Citizen[] citizensIn;
	
	// Constructors --------------------------------
	
	public TectonicPlate(Country country, int tectonicPlateSize) {
		this.name		= "";
		this.country	= country;
		this.unlocked	= true;
		//geology
		this.magma					= new byte		[tectonicPlateSize][tectonicPlateSize];
		this.height					= new byte		[tectonicPlateSize][tectonicPlateSize];
		this.water					= new byte		[tectonicPlateSize][tectonicPlateSize];
		this.pollution				= new byte		[tectonicPlateSize][tectonicPlateSize];
		//resources
		this.naturalResourcesIn		= new byte		[tectonicPlateSize][tectonicPlateSize];
		this.soilResourcesIn		= new byte		[tectonicPlateSize][tectonicPlateSize];
		this.amountsIn				= new byte		[tectonicPlateSize][tectonicPlateSize];
		this.amountsList			= new Amount	[0];
		this.amountsForeignList		= new Amount	[0];
		//elements
		this.elementsIn				= new short		[tectonicPlateSize][tectonicPlateSize];
		for(int j = 0; j < tectonicPlateSize; ++j) {
			for(int i = 0; i < tectonicPlateSize; ++i) {
				elementsIn[j][i] = -1;
			}
		}
		this.elementsList			= new Element	[0];
		this.elementsForeignList	= new Element	[0];
		//citizens
		this.citizensIn				= new Citizen	[0];
	}
	
	// Methods --------------------------------
	
	public String getType() {
		return type;
	}
	
	public String getProperName() {
		return name;
	}
	
	public void lock() {
		this.unlocked = false;
	}
	
	public void unlock() {
		this.unlocked = true;
	}
	
	public void addMineralResourceAmount(Amount a) {
		Amount[] update = new Amount[amountsList.length + 1];
		System.arraycopy(amountsList, 0, update, 0, amountsList.length);
		update[amountsList.length] = a;
		this.amountsList = update;
	}
	
	/**
	 * Attempts to extract a certain amount of units of the mineral underneath a specific tile. Returns the actually extracted amount.
	 * 
	 * @param subindex_tile_x
	 * @param subindex_tile_y
	 * @param extraction Amount of mineral attempted to be extracted.
	 * @return Amount successfully extracted.
	 */
	public int extractMineral(int subindex_tile_x, int subindex_tile_y, int extraction) {
		amountsList[amountsIn[subindex_tile_y][subindex_tile_x]].amount -= extraction;
		if(amountsList[amountsIn[subindex_tile_y][subindex_tile_x]].amount < 0){
			int actualExtraction = amountsList[amountsIn[subindex_tile_y][subindex_tile_x]].amount + extraction;
			//We could dereference it, but we leave it like this just in case.
			amountsList[amountsIn[subindex_tile_y][subindex_tile_x]].amount = 0;
			return actualExtraction;
		}else{
			return extraction;
		}
	}
	
	public boolean contains(Element element) {
		boolean contained = false;
		for(int index = 0; index < elementsList.length; ++index) {
			contained |= elementsList[index] == element;
		}
		return contained;
	}
	
	public void addElement(int subindex_tile_x, int subindex_tile_y, Element element) {
		if(!contains(element)) {
			Element[] update = new Element[elementsList.length + 1];
			System.arraycopy(elementsList, 0, update, 0, elementsList.length);
			update[elementsList.length] = element;
			this.elementsList = update;
		}
		elementsIn[subindex_tile_y][subindex_tile_x] = (short) (elementsList.length - 1);
	}
	
	public void addForeignElement(int subindex_tile_x, int subindex_tile_y, Element element) {
		if(!contains(element)) {
			Element[] update = new Element[elementsForeignList.length + 1];
			System.arraycopy(elementsForeignList, 0, update, 0, elementsForeignList.length);
			update[elementsForeignList.length] = element;
			this.elementsForeignList = update;
		}
		elementsIn[subindex_tile_y][subindex_tile_x] = (short) (Short.MIN_VALUE + elementsForeignList.length - 1);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}