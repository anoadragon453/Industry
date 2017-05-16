package types;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Trade implements Externalizable {
	
	// Class fields --------------------------------
	
	public Country seller;
	public Country buyer;
	public Amount[] amounts;
	public int monthsRemaining;
	
	// Constructors --------------------------------
	
	public Trade(Country seller, Country buyer, Amount[] amounts, int duration) {
		this.seller = seller;
		this.buyer = buyer;
		this.amounts = amounts;
		this.monthsRemaining = duration;
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
