package classes;

import java.io.Serializable;

/**
 * This class represents a certain amount of a certain resource as an (int, Resource) pair.
 * @author Javier
 *
 */
public class Amount implements Serializable {
	
	private static final long serialVersionUID = 8091085314536647783L;
	
	public int amount;
	public Resource resource;
	
	public Amount(int amount, Resource resource){
		this.amount = amount;
		this.resource = resource;
	}
	
}
