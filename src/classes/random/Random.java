package classes.random;

public interface Random {
	
	// sequence
	
	public interface Sequence {
		
		public int getNextFrom(int x);
		
		public int getPreviousFrom(int x);
		
	}
	
	// 1 dimensional
	
	public interface Strip<T> {
		
		public T at(int x);
		
	}
	
	public interface ByteStrip {
		
		public byte at(int x);
		
	}
	
	public interface ShortStrip {
		
		public short at(int x);
		
	}
	
	public interface IntStrip {
		
		public int at(int x);
		
	}
	
	public interface LongStrip {
		
		public long at(int x);
		
	}
	
	public interface BooleanStrip {
		
		public boolean at(int x);
		
	}
	
	public interface CharStrip {
		
		public char at(int x);
		
	}
	
	public interface FloatStrip {
		
		public float at(int x);
		
	}
	
	public interface DoubleStrip {
		
		public double at(int x);
		
	}
	
	// 2 dimensional
	
	public interface Grid<T> {
		
		public T at(int x, int y);
		
	}
	
	public interface ByteGrid {
		
		public byte at(int x, int y);
		
	}
	
	public interface ShortGrid {
		
		public short at(int x, int y);
		
	}
	
	public interface IntGrid {
		
		public int at(int x, int y);
		
	}
	
	public interface LongGrid {
		
		public long at(int x, int y);
		
	}
	
	public interface BooleanGrid {
		
		public boolean at(int x, int y);
		
	}
	
	public interface CharGrid {
		
		public char at(int x, int y);
		
	}
	
	public interface FloatGrid {
		
		public float at(int x, int y);
		
	}
	
	public interface DoubleGrid {
		
		public double at(int x, int y);
		
	}
	
	// 3 dimensional
	
	public interface LayeredGrid<T> {
		
		public T at(int x, int y, int z);
		
	}
	
	public interface ByteLayeredGrid {
		
		public byte at(int x, int y, int z);
		
	}
	
	public interface ShortLayeredGrid {
		
		public short at(int x, int y, int z);
		
	}
	
	public interface IntLayeredGrid {
		
		public int at(int x, int y, int z);
		
	}
	
	public interface LongLayeredGrid {
		
		public long at(int x, int y, int z);
		
	}
	
	public interface BooleanLayeredGrid {
		
		public boolean at(int x, int y, int z);
		
	}
	
	public interface CharLayeredGrid {
		
		public char at(int x, int y, int z);
		
	}
	
	public interface FloatLayeredGrid {
		
		public float at(int x, int y, int z);
		
	}
	
	public interface DoubleLayeredGrid {
		
		public double at(int x, int y, int z);
		
	}
	
}
