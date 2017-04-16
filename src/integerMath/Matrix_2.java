package integerMath;

/**
 * A matrix representing a xy-plane
 * 
 * @author Javier
 *
 */
public class Matrix_2 {

	public static boolean notJagged(int[][] matrix_2){
		boolean result = matrix_2[0].length == matrix_2[1].length;
		for(int j = 2; j < matrix_2.length; ++j){
			result = result && matrix_2[0].length != matrix_2[j].length;
		}
		return result;
	}
	
	public static boolean notJagged(long[][] matrix_2){
		boolean result = matrix_2[0].length == matrix_2[1].length;
		for(int j = 2; j < matrix_2.length; ++j){
			result = result && matrix_2[0].length != matrix_2[j].length;
		}
		return result;
	}
	
	public static int[][] create_int(int length_x, int length_y){
		return new int[length_y][length_x];
	}
	
	public static long[][] create_long(int length_x, int length_y){
		return new long[length_y][length_x];
	}
	
	public static char[][] create_char(int length_x, int length_y){
		return new char[length_y][length_x];
	}
	
	public static int[][] compose_x(int[]... matrix_2){
		return matrix_2;
	}
	
	public static long[][] compose_x(long[]... matrix_2){
		return matrix_2;
	}
	
	public static int[][] compose_y(int[]... matrix_2){
		int[][] result = new int[matrix_2[0].length][matrix_2.length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[i][j] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static long[][] compose_y(long[]... matrix_2){
		long[][] result = new long[matrix_2[0].length][matrix_2.length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[i][j] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static int[][] addDimension(int[] matrix_1){
		int[][] result = new int[matrix_1.length][matrix_1.length];
		for(int i = 0; i < matrix_1.length; ++i){
			result[i][0] = matrix_1[i];
		}
		return result;
	}
	
	public static long[][] addDimension(long[] matrix_1){
		long[][] result = new long[matrix_1.length][matrix_1.length];
		for(int i = 0; i < matrix_1.length; ++i){
			result[i][0] = matrix_1[i];
		}
		return result;
	}
	
	public static int[][] addDimension(int[] matrix_1, int width){
		int[][] result = new int[matrix_1.length][width];
		for(int i = 0; i < matrix_1.length; ++i){
			result[i][0] = matrix_1[i];
		}
		return result;
	}
	
	public static long[][] addDimension(long[] matrix_1, int width){
		long[][] result = new long[matrix_1.length][width];
		for(int i = 0; i < matrix_1.length; ++i){
			result[i][0] = matrix_1[i];
		}
		return result;
	}
	
	public static int[][] addDimension(int[] matrix_1, int width, int shift){
		int[][] result = new int[matrix_1.length][width];
		for(int i = 0; i < matrix_1.length; ++i){
			result[i][shift] = matrix_1[i];
		}
		return result;
	}
	
	public static long[][] addDimension(long[] matrix_1, int width, int shift){
		long[][] result = new long[matrix_1.length][width];
		for(int i = 0; i < matrix_1.length; ++i){
			result[i][shift] = matrix_1[i];
		}
		return result;
	}
	
	public static int[][] select_xy(int[][][] matrix_3, int index_z){
		int[][] result = new int[matrix_3[0].length][matrix_3[0][0].length];
		for(int i = 0; i < matrix_3[0][0].length; ++i){
		for(int j = 0; j < matrix_3[0].length; ++j){
			result[j][i] = matrix_3[index_z][j][i];
		}
		}
		return result;
	}
	
	public static long[][] select_xy(long[][][] matrix_3, int index_z){
		long[][] result = new long[matrix_3[0].length][matrix_3[0][0].length];
		for(int i = 0; i < matrix_3[0][0].length; ++i){
		for(int j = 0; j < matrix_3[0].length; ++j){
			result[j][i] = matrix_3[index_z][j][i];
		}
		}
		return result;
	}
	
	public static int[][] select_xz(int[][][] matrix_3, int index_y){
		int[][] result = new int[matrix_3.length][matrix_3[0][0].length];
		for(int i = 0; i < matrix_3[0][0].length; ++i){
		for(int k = 0; k < matrix_3.length; ++k){
			result[k][i] = matrix_3[k][index_y][i];
		}
		}
		return result;
	}
	
	public static long[][] select_xz(long[][][] matrix_3, int index_y){
		long[][] result = new long[matrix_3.length][matrix_3[0][0].length];
		for(int i = 0; i < matrix_3[0][0].length; ++i){
		for(int k = 0; k < matrix_3.length; ++k){
			result[k][i] = matrix_3[k][index_y][i];
		}
		}
		return result;
	}
	
	public static int[][] select_yz(int[][][] matrix_3, int index_x){
		int[][] result = new int[matrix_3.length][matrix_3[0].length];
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int k = 0; k < matrix_3.length; ++k){
			result[k][j] = matrix_3[k][j][index_x];
		}
		}
		return result;
	}
	
	public static long[][] select_yz(long[][][] matrix_3, int index_x){
		long[][] result = new long[matrix_3.length][matrix_3[0].length];
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int k = 0; k < matrix_3.length; ++k){
			result[k][j] = matrix_3[k][j][index_x];
		}
		}
		return result;
	}
	
	public static int[][] reverse_x(int[][] matrix_2){
		int[][] result = new int[matrix_2.length][matrix_2[0].length];
		for(int i = 0; i < matrix_2.length; ++i){
			result[i] = Matrix_1.reverse_x(matrix_2[i]);
		}
		return result;
	}
	
	public static long[][] reverse_x(long[][] matrix_2){
		long[][] result = new long[matrix_2.length][matrix_2[0].length];
		for(int i = 0; i < matrix_2.length; ++i){
			result[i] = Matrix_1.reverse_x(matrix_2[i]);
		}
		return result;
	}
	
	public static int[][] reverse_y(int[][] matrix_2){
		int[][] result = new int[matrix_2.length][matrix_2[0].length];
		for(int j = 0, mj = matrix_2.length - 1; j < matrix_2.length; ++j, --mj){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = matrix_2[mj][i];
		}
		}
		return result;
	}
	
	public static long[][] reverse_y(long[][] matrix_2){
		long[][] result = new long[matrix_2.length][matrix_2[0].length];
		for(int j = 0, mj = matrix_2.length - 1; j < matrix_2.length; ++j, --mj){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = matrix_2[mj][i];
		}
		}
		return result;
	}
	
	public static int[][] transpose_xy(int[][] matrix_2){
		int[][] result = new int[matrix_2[0].length][matrix_2.length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[i][j] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static long[][] transpose_xy(long[][] matrix_2){
		long[][] result = new long[matrix_2[0].length][matrix_2.length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[i][j] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static int[][] shift_x(int[][] matrix_2, int shift){
		int[][] result = new int[matrix_2.length][matrix_2[0].length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][Op.trueModulus(i + shift, matrix_2[0].length)] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static long[][] shift_x(long[][] matrix_2, int shift){
		long[][] result = new long[matrix_2.length][matrix_2[0].length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][Op.trueModulus(i + shift, matrix_2[0].length)] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static int[][] shift_y(int[][] matrix_2, int shift){
		int[][] result = new int[matrix_2.length][matrix_2[0].length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[Op.trueModulus(j + shift, matrix_2.length)][i] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static long[][] shift_y(long[][] matrix_2, int shift){
		long[][] result = new long[matrix_2.length][matrix_2[0].length];
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[Op.trueModulus(j + shift, matrix_2.length)][i] = matrix_2[j][i];
		}
		}
		return result;
	}
	
	public static int[][] expand_x(int[][] matrix_2, int add){
		if(matrix_2[0].length + add > 0){
			int[][] result = new int[matrix_2.length][matrix_2[0].length + add];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expand_x(matrix_2[j], add);
			}
			return result;
		}else{
			return new int[0][0];
		}
	}
	
	public static long[][] expand_x(long[][] matrix_2, int add){
		if(matrix_2[0].length + add > 0){
			long[][] result = new long[matrix_2.length][matrix_2[0].length + add];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expand_x(matrix_2[j], add);
			}
			return result;
		}else{
			return new long[0][0];
		}
	}
	
	public static boolean[][] expand_x(boolean[][] matrix_2, int add){
		if(matrix_2[0].length + add > 0){
			boolean[][] result = new boolean[matrix_2.length][matrix_2[0].length + add];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expand_x(matrix_2[j], add);
			}
			return result;
		}else{
			return new boolean[0][0];
		}
	}
	
	public static Object[][] expand_x(Object[][] matrix_2, int add){
		if(matrix_2[0].length + add > 0){
			Object[][] result = new Object[matrix_2.length][matrix_2[0].length + add];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expand_x(matrix_2[j], add);
			}
			return result;
		}else{
			return new Object[0][0];
		}
	}
	
	public static int[][] expandShift_x(int[][] matrix_2, int shift){
		if(matrix_2[0].length + shift > 0){
			int[][] result = new int[matrix_2.length][matrix_2[0].length + shift];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expandShift_x(matrix_2[j], shift);
			}
			return result;
		}else{
			return new int[0][0];
		}
	}
	
	public static long[][] expandShift_x(long[][] matrix_2, int shift){
		if(matrix_2[0].length + shift > 0){
			long[][] result = new long[matrix_2.length][matrix_2[0].length + shift];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expandShift_x(matrix_2[j], shift);
			}
			return result;
		}else{
			return new long[0][0];
		}
	}
	
	public static boolean[][] expandShift_x(boolean[][] matrix_2, int shift){
		if(matrix_2[0].length + shift > 0){
			boolean[][] result = new boolean[matrix_2.length][matrix_2[0].length + shift];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expandShift_x(matrix_2[j], shift);
			}
			return result;
		}else{
			return new boolean[0][0];
		}
	}
	
	public static Object[][] expandShift_x(Object[][] matrix_2, int shift){
		if(matrix_2[0].length + shift > 0){
			Object[][] result = new Object[matrix_2.length][matrix_2[0].length + shift];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = Matrix_1.expandShift_x(matrix_2[j], shift);
			}
			return result;
		}else{
			return new Object[0][0];
		}
	}
	
	public static int[][] expand_y(int[][] matrix_2, int add){
		if(add >= 0){
			int[][] result = new int[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else if(-add < matrix_2.length){
			int[][] result = new int[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < result.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else{
			return new int[0][0];
		}
	}
	
	public static long[][] expand_y(long[][] matrix_2, int add){
		if(add >= 0){
			long[][] result = new long[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else if(-add < matrix_2.length){
			long[][] result = new long[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < result.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else{
			return new long[0][0];
		}
	}
	
	public static boolean[][] expand_y(boolean[][] matrix_2, int add){
		if(add >= 0){
			boolean[][] result = new boolean[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else if(-add < matrix_2.length){
			boolean[][] result = new boolean[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < result.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else{
			return new boolean[0][0];
		}
	}
	
	public static Object[][] expand_y(Object[][] matrix_2, int add){
		if(add >= 0){
			Object[][] result = new Object[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < matrix_2.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else if(-add < matrix_2.length){
			Object[][] result = new Object[matrix_2.length + add][matrix_2[0].length];
			for(int j = 0; j < result.length; ++j){
				result[j] = matrix_2[j];
			}
			return result;
		}else{
			return new Object[0][0];
		}
	}
	
	public static int[][] expandShift_y(int[][] matrix_2, int shift){
		if(shift >= 0){
			int[][] result = new int[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = shift; j < matrix_2.length; ++j, ++s){
				result[s] = matrix_2[j];
			}
			return result;
		}else if(-shift < matrix_2.length){
			int[][] result = new int[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = -shift; j < result.length; ++j, ++s){
				result[j] = matrix_2[s];
			}
			return result;
		}else{
			return new int[0][0];
		}
	}
	
	public static long[][] expandShift_y(long[][] matrix_2, int shift){
		if(shift >= 0){
			long[][] result = new long[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = shift; j < matrix_2.length; ++j, ++s){
				result[s] = matrix_2[j];
			}
			return result;
		}else if(-shift < matrix_2.length){
			long[][] result = new long[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = -shift; j < result.length; ++j, ++s){
				result[j] = matrix_2[s];
			}
			return result;
		}else{
			return new long[0][0];
		}
	}
	
	public static boolean[][] expandShift_y(boolean[][] matrix_2, int shift){
		if(shift >= 0){
			boolean[][] result = new boolean[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = shift; j < matrix_2.length; ++j, ++s){
				result[s] = matrix_2[j];
			}
			return result;
		}else if(-shift < matrix_2.length){
			boolean[][] result = new boolean[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = -shift; j < result.length; ++j, ++s){
				result[j] = matrix_2[s];
			}
			return result;
		}else{
			return new boolean[0][0];
		}
	}
	
	public static Object[][] expandShift_y(Object[][] matrix_2, int shift){
		if(shift >= 0){
			Object[][] result = new Object[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = shift; j < matrix_2.length; ++j, ++s){
				result[s] = matrix_2[j];
			}
			return result;
		}else if(-shift < matrix_2.length){
			Object[][] result = new Object[matrix_2.length + shift][matrix_2[0].length];
			for(int j = 0, s = -shift; j < result.length; ++j, ++s){
				result[j] = matrix_2[s];
			}
			return result;
		}else{
			return new Object[0][0];
		}
	}
	
	public static int[][] insert_x(int[][] matrix_2, int[][] insert){
		if(matrix_2.length != insert.length){
			return null;
		}
		int[][] result = new int[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static long[][] insert_x(long[][] matrix_2, long[][] insert){
		if(matrix_2.length != insert.length){
			return null;
		}
		long[][] result = new long[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static boolean[][] insert_x(boolean[][] matrix_2, boolean[][] insert){
		if(matrix_2.length != insert.length){
			return null;
		}
		boolean[][] result = new boolean[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static Object[][] insert_x(Object[][] matrix_2, Object[][] insert){
		if(matrix_2.length != insert.length){
			return null;
		}
		Object[][] result = new Object[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static int[][] insert_x(int[][] matrix_2, int[][] insert, int index){
		if(matrix_2.length != insert.length){
			return null;
		}
		int[][] result = new int[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static long[][] insert_x(long[][] matrix_2, long[][] insert, int index){
		if(matrix_2.length != insert.length){
			return null;
		}
		long[][] result = new long[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static boolean[][] insert_x(boolean[][] matrix_2, boolean[][] insert, int index){
		if(matrix_2.length != insert.length){
			return null;
		}
		boolean[][] result = new boolean[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static Object[][] insert_x(Object[][] matrix_2, Object[][] insert, int index){
		if(matrix_2.length != insert.length){
			return null;
		}
		Object[][] result = new Object[matrix_2.length][matrix_2[0].length + insert[0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_1.insert_x(matrix_2[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static int[][] insert_y(int[][] matrix_2, int[][] insert){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		int[][] result = new int[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		for(int[] matrix_1 : matrix_2){
			result[len++] = matrix_1;
		}
		for(int[] matrix_1 : insert){
			result[len++] = matrix_1;
		}
		return result;
	}
	
	public static long[][] insert_y(long[][] matrix_2, long[][] insert){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		long[][] result = new long[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		for(long[] matrix_1 : matrix_2){
			result[len++] = matrix_1;
		}
		for(long[] matrix_1 : insert){
			result[len++] = matrix_1;
		}
		return result;
	}
	
	public static boolean[][] insert_y(boolean[][] matrix_2, boolean[][] insert){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		boolean[][] result = new boolean[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		for(boolean[] matrix_1 : matrix_2){
			result[len++] = matrix_1;
		}
		for(boolean[] matrix_1 : insert){
			result[len++] = matrix_1;
		}
		return result;
	}
	
	public static Object[][] insert_y(Object[][] matrix_2, Object[][] insert){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		Object[][] result = new Object[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		for(Object[] matrix_1 : matrix_2){
			result[len++] = matrix_1;
		}
		for(Object[] matrix_1 : insert){
			result[len++] = matrix_1;
		}
		return result;
	}
	
	public static int[][] insert_y(int[][] matrix_2, int[][] insert, int index){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		int[][] result = new int[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static long[][] insert_y(long[][] matrix_2, long[][] insert, int index){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		long[][] result = new long[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static boolean[][] insert_y(boolean[][] matrix_2, boolean[][] insert, int index){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		boolean[][] result = new boolean[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static Object[][] insert_y(Object[][] matrix_2, Object[][] insert, int index){
		if(matrix_2[0].length != insert[0].length){
			return null;
		}
		Object[][] result = new Object[matrix_2.length + insert.length][matrix_2[0].length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_2[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static int[][] assign_x(int[][] matrix_2, int[] p, int index_x){
		for(int j = 0; j < matrix_2.length; ++j){
			matrix_2[j][index_x] = p[j];
		}
		return matrix_2;
	}
	
	public static long[][] assign_x(long[][] matrix_2, long[] p, int index_x){
		for(int j = 0; j < matrix_2.length; ++j){
			matrix_2[j][index_x] = p[j];
		}
		return matrix_2;
	}
	
	public static char[][] assign_x(char[][] matrix_2, char[] p, int index_x){
		for(int j = 0; j < matrix_2.length; ++j){
			matrix_2[j][index_x] = p[j];
		}
		return matrix_2;
	}
	
	public static boolean[][] assign_x(boolean[][] matrix_2, boolean[] p, int index_x){
		for(int j = 0; j < matrix_2.length; ++j){
			matrix_2[j][index_x] = p[j];
		}
		return matrix_2;
	}
	
	public static Object[][] assign_x(Object[][] matrix_2, Object[] p, int index_x){
		for(int j = 0; j < matrix_2.length; ++j){
			matrix_2[j][index_x] = p[j];
		}
		return matrix_2;
	}
	
	public static int[][] assign_y(int[][] matrix_2, int[] p, int index_y){
		matrix_2[index_y] = p;
		return matrix_2;
	}
	
	public static long[][] assign_y(long[][] matrix_2, long[] p, int index_y){
		matrix_2[index_y] = p;
		return matrix_2;
	}
	
	public static char[][] assign_y(char[][] matrix_2, char[] p, int index_y){
		matrix_2[index_y] = p;
		return matrix_2;
	}
	
	public static boolean[][] assign_y(boolean[][] matrix_2, boolean[] p, int index_y){
		matrix_2[index_y] = p;
		return matrix_2;
	}
	
	public static Object[][] assign_y(Object[][] matrix_2, Object[] p, int index_y){
		matrix_2[index_y] = p;
		return matrix_2;
	}
	
	public static int[][] assign_xy(int[][] matrix_2, int p, int index_x, int index_y){
		matrix_2[index_y][index_x] = p;
		return matrix_2;
	}
	
	public static long[][] assign_xy(long[][] matrix_2, long p, int index_x, int index_y){
		matrix_2[index_y][index_x] = p;
		return matrix_2;
	}
	
	public static char[][] assign_xy(char[][] matrix_2, char p, int index_x, int index_y){
		matrix_2[index_y][index_x] = p;
		return matrix_2;
	}
	
	public static boolean[][] assign_xy(boolean[][] matrix_2, boolean p, int index_x, int index_y){
		matrix_2[index_y][index_x] = p;
		return matrix_2;
	}
	
	public static Object[][] assign_xy(Object[][] matrix_2, Object p, int index_x, int index_y){
		matrix_2[index_y][index_x] = p;
		return matrix_2;
	}
	
	public static int[][] fill(int[][] matrix_2, int p){
		int[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = p;
		}
		}
		return result;
	}
	
	public static long[][] fill(long[][] matrix_2, long p){
		long[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = p;
		}
		}
		return result;
	}
	
	public static char[][] fill(char[][] matrix_2, char p){
		char[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = p;
		}
		}
		return result;
	}
	
	public static boolean[][] fill(boolean[][] matrix_2, boolean p){
		boolean[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = p;
		}
		}
		return result;
	}
	
	public static Object[][] fill(Object[][] matrix_2, Object p){
		Object[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			result[j][i] = p;
		}
		}
		return result;
	}
	
	public static int[][] substitute(int[][] matrix_2, int from, int to){
		int[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			if(result[j][i] == from){
				result[j][i] = to;
			}
		}
		}
		return result;
	}
	
	public static long[][] substitute(long[][] matrix_2, long from, long to){
		long[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			if(result[j][i] == from){
				result[j][i] = to;
			}
		}
		}
		return result;
	}
	
	public static char[][] substitute(char[][] matrix_2, char from, char to){
		char[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			if(result[j][i] == from){
				result[j][i] = to;
			}
		}
		}
		return result;
	}
	
	public static boolean[][] substitute(boolean[][] matrix_2, boolean from, boolean to){
		boolean[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			if(result[j][i] == from){
				result[j][i] = to;
			}
		}
		}
		return result;
	}
	
	public static Object[][] substitute(Object[][] matrix_2, Object from, Object to){
		Object[][] result = matrix_2;
		for(int j = 0; j < matrix_2.length; ++j){
		for(int i = 0; i < matrix_2[0].length; ++i){
			if(result[j][i] == from){
				result[j][i] = to;
			}
		}
		}
		return result;
	}
	
	/**
	 * Selection sort of the elements in each x-row by natural order ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static int[][] sort_x(int[][] matrix_2){
		int[][] sorted = matrix_2;
		for(int j = 0; j < sorted.length; ++j){
			sorted[j] = Matrix_1.sort_x(sorted[j]);
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the elements in each x-row by natural order ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static long[][] sort_x(long[][] matrix_2){
		long[][] sorted = matrix_2;
		for(int j = 0; j < sorted.length; ++j){
			sorted[j] = Matrix_1.sort_x(sorted[j]);
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the x-rows by natural order of their sums ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static int[][] sort_y(int[][] matrix_2){
		int index = 0;
		int[][] sorted = matrix_2;
		int compsum;
		int compindex = 0;
		int[] comp;
		while(index < sorted.length){
			compsum = Integer.MAX_VALUE;
			for(int j = index; j < sorted.length; ++j){
				int s = Statistic.sum(sorted[j]);
				if(s < compsum){
					compsum = s;
					compindex = j;
				}
			}
			comp = sorted[compindex];
			sorted[compindex] = sorted[index];
			sorted[index] = comp;
			++index;
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the x-rows by natural order of their sums ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static long[][] sort_y(long[][] matrix_2){
		int index = 0;
		long[][] sorted = matrix_2;
		long compsum;
		int compindex = 0;
		long[] comp;
		while(index < sorted.length){
			compsum = Integer.MAX_VALUE;
			for(int j = index; j < sorted.length; ++j){
				long s = Statistic.sum(sorted[j]);
				if(s < compsum){
					compsum = s;
					compindex = j;
				}
			}
			comp = sorted[compindex];
			sorted[compindex] = sorted[index];
			sorted[index] = comp;
			++index;
		}
		return sorted;
	}
	
	public static String plot(int[][] matrix_2){
		int[] max_min = Statistic.min_max(matrix_2);
		int maxlen = Statistic.max(Integer.toString(max_min[0]).length(), Integer.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String result = "";
		for(int[] matrix_1 : matrix_2){
		for(int i : matrix_1){
			result += "[" + String.format(format, i) + "]";
		}
		result += '\n';
		}
		return result;
	}
	
	public static String plot(long[][] matrix_2){
		long[] max_min = Statistic.min_max(matrix_2);
		int maxlen = Statistic.max(Long.toString(max_min[0]).length(), Long.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String result = "";
		for(long[] matrix_1 : matrix_2){
		for(long i : matrix_1){
			result += "[" + String.format(format, i) + "]";
		}
		result += '\n';
		}
		return result;
	}
	
	public static String plot(char[][] matrix_2){
		String result = "";
		for(char[] matrix_1 : matrix_2){
		for(char c : matrix_1){
			result += "[" + c + "]";
		}
		result += '\n';
		}
		return result;
	}
	
	public static String plotRhombic(int[][] matrix_2){
		int[] max_min = Statistic.min_max(matrix_2);
		int maxlen = Statistic.max(Integer.toString(max_min[0]).length(), Integer.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String result = "";
		int diagonal = 0;
		while(diagonal < matrix_2.length && diagonal < matrix_2[0].length){
			for(int i = 0; i < (matrix_2[0].length - diagonal)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = 0, b = diagonal; b >= 0; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		while(diagonal < matrix_2[0].length){
			for(int i = 0; i < (matrix_2[0].length - diagonal)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = 0, b = diagonal; a < matrix_2.length; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		while(diagonal < matrix_2.length){
			for(int i = 0; i < (diagonal - matrix_2[0].length + 2)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = diagonal - matrix_2[0].length + 1, b = matrix_2[0].length - 1; b >= 0; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		while(diagonal < matrix_2.length + matrix_2[0].length){
			for(int i = 0; i < (diagonal - matrix_2[0].length + 2)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = diagonal - matrix_2[0].length + 1, b = matrix_2[0].length - 1; a < matrix_2.length; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		return result;
	}
	
	public static String plotRhombic(long[][] matrix_2){
		long[] max_min = Statistic.min_max(matrix_2);
		int maxlen = Statistic.max(Long.toString(max_min[0]).length(), Long.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String result = "";
		int diagonal = 0;
		while(diagonal < matrix_2.length && diagonal < matrix_2[0].length){
			for(int i = 0; i < (matrix_2[0].length - diagonal)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = 0, b = diagonal; b >= 0; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		while(diagonal < matrix_2[0].length){
			for(int i = 0; i < (matrix_2[0].length - diagonal)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = 0, b = diagonal; a < matrix_2.length; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		while(diagonal < matrix_2.length){
			for(int i = 0; i < (diagonal - matrix_2[0].length + 2)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = diagonal - matrix_2[0].length + 1, b = matrix_2[0].length - 1; b >= 0; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		while(diagonal < matrix_2.length + matrix_2[0].length){
			for(int i = 0; i < (diagonal - matrix_2[0].length + 2)*((maxlen + 2) / 2); ++i){
				result += ' ';
			}
			for(int a = diagonal - matrix_2[0].length + 1, b = matrix_2[0].length - 1; a < matrix_2.length; ++a, --b){
				result += "<" + String.format(format, matrix_2[a][b]) + ">";
			}
			result += '\n';
			++diagonal;
		}
		return result;
	}
	
}
