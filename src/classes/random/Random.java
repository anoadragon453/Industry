package classes.random;

public interface Random {
	
	// sequence
	
	public interface CharacterSequence {
		
		public char next();
		
	}
	
	public interface IntegerSequence {
		
		public int next();
		
	}
	
	// 1 dimensional
	
	public interface IntegerStrip {
		
		public int at(int x);
		
	}
	
	// 2 dimensional
	
	public interface IntegerGrid {
		
		public int at(int x, int y);
		
	}
	
	// 3 dimensional
	
	public interface IntegerLayeredGrid {
		
		public int at(int x, int y, int z);
		
	}
	
}
