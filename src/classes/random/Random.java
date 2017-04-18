package classes.random;

public interface Random {
	
	// 1 dimensional
	
	public interface Strip<T> {
		
		public T at(int x);
		
	}
	
	public interface IntegerStrip {
		
		public int at(int x);
		
	}
	
	// 2 dimensional
	
	public interface Grid<T> {
		
		public T at(int x, int y);
		
	}
	
	public interface IntegerGrid {
		
		public int at(int x, int y);
		
	}
	
	// 3 dimensional
	
	public interface LayeredGrid<T> {
		
		public T at(int x, int y, int z);
		
	}
	
	public interface IntegerLayeredGrid {
		
		public int at(int x, int y, int z);
		
	}
	
}
