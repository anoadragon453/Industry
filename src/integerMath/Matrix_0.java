package integerMath;

/**
 * A single element.
 * 
 * @author Javier
 *
 */
public class Matrix_0 {
	
	public static int select_x(int[] matrix_1, int index_x){
		return matrix_1[index_x];
	}
	
	public static long select_x(long[] matrix_1, int index_x){
		return matrix_1[index_x];
	}
	
	public static int select_xy(int[][] matrix_2, int index_x, int index_y){
		return matrix_2[index_y][index_x];
	}
	
	public static long select_xy(long[][] matrix_2, int index_x, int index_y){
		return matrix_2[index_y][index_x];
	}
	
	public static int select_xyz(int[][][] matrix_3, int index_x, int index_y, int index_z){
		return matrix_3[index_z][index_y][index_x];
	}
	
	public static long select_xyz(long[][][] matrix_3, int index_x, int index_y, int index_z){
		return matrix_3[index_z][index_y][index_x];
	}
	
	public static String plot(int matrix_0){
		return "[" + matrix_0 + "]";
	}
	
	public static String plot(long matrix_0){
		return "[" + matrix_0 + "]";
	}
	
	public static String plot(char matrix_0){
		return "[" + matrix_0 + "]";
	}
	
}
