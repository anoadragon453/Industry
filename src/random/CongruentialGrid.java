package random;

public class CongruentialGrid implements Random.IntegerGrid {
	
	int[][] cache;
	boolean[][] generated;
	int offset_x, offset_y;
	
	public CongruentialGrid(int seed, int offset_x, int offset_y) {
		this.cache = new int[][]{{seed}};
		this.generated = new boolean[][]{{true}};
		this.offset_x = offset_x;
		this.offset_y = offset_y;
	}
	
	@Override public int at(int x, int y) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private void generate(int x, int y) {
		
	}
	
}
