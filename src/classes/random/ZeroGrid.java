package classes.random;

public class ZeroGrid implements Random.ByteGrid {
	
	@Override public byte at(int x, int y) {
		return 0;
	}
	
}