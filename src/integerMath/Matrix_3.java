package integerMath;

/**
 * A matrix representing a xyz-space
 * 
 *   1     4     7  
 *    2     5     8 
 *     3     6     9
 *  10    13    16  
 *   11    14    17 
 *    12    15    18
 *  19    22    25  
 *   20    23    26 
 *    21    24    27
 * 
 * @author Javier
 *
 */
public class Matrix_3 {

	public static int[][][] create_int(int length_x, int length_y, int length_z){
		return new int[length_z][length_y][length_x];
	}
	
	public static long[][][] create_long(int length_x, int length_y, int length_z){
		return new long[length_z][length_y][length_x];
	}
	
	public static char[][][] create_char(int length_x, int length_y, int length_z){
		return new char[length_z][length_y][length_x];
	}
	
	/**
	 * Selects a xyz-space from a xyzt-hyperspace.
	 * 
	 * @param issss
	 * @param index_t
	 * @return
	 */
	public static int[][][] select_xyz(int[][][][] matrix_4, int index_t){
		int[][][] result = new int[matrix_4[0].length][matrix_4[0][0].length][matrix_4[0][0][0].length];
		for(int k = 0; k < matrix_4[0].length; ++k){
		for(int j = 0; j < matrix_4[0][0].length; ++j){
		for(int i = 0; i < matrix_4[0][0][0].length; ++i){
			result[k][j][i] = matrix_4[index_t][k][j][i];
		}}}
		return result;
	}
	
	public static long[][][] select_xyz(long[][][][] matrix_4, int index_t){
		long[][][] result = new long[matrix_4[0].length][matrix_4[0][0].length][matrix_4[0][0][0].length];
		for(int k = 0; k < matrix_4[0].length; ++k){
		for(int j = 0; j < matrix_4[0][0].length; ++j){
		for(int i = 0; i < matrix_4[0][0][0].length; ++i){
			result[k][j][i] = matrix_4[index_t][k][j][i];
		}}}
		return result;
	}
	
	public static int[][][] select_xyt(int[][][][] matrix_4, int index_z){
		int[][][] result = new int[matrix_4.length][matrix_4[0][0].length][matrix_4[0][0][0].length];
		for(int l = 0; l < matrix_4.length; ++l){
		for(int j = 0; j < matrix_4[0][0].length; ++j){
		for(int i = 0; i < matrix_4[0][0][0].length; ++i){
			result[l][j][i] = matrix_4[l][index_z][j][i];
		}}}
		return result;
	}
	
	public static long[][][] select_xyt(long[][][][] matrix_4, int index_z){
		long[][][] result = new long[matrix_4.length][matrix_4[0][0].length][matrix_4[0][0][0].length];
		for(int l = 0; l < matrix_4.length; ++l){
		for(int j = 0; j < matrix_4[0][0].length; ++j){
		for(int i = 0; i < matrix_4[0][0][0].length; ++i){
			result[l][j][i] = matrix_4[l][index_z][j][i];
		}}}
		return result;
	}
	
	public static int[][][] select_xzt(int[][][][] matrix_4, int index_y){
		int[][][] result = new int[matrix_4.length][matrix_4[0].length][matrix_4[0][0][0].length];
		for(int l = 0; l < matrix_4.length; ++l){
		for(int k = 0; k < matrix_4[0].length; ++k){
		for(int i = 0; i < matrix_4[0][0][0].length; ++i){
			result[l][k][i] = matrix_4[l][k][index_y][i];
		}}}
		return result;
	}
	
	public static long[][][] select_xzt(long[][][][] matrix_4, int index_y){
		long[][][] result = new long[matrix_4.length][matrix_4[0].length][matrix_4[0][0][0].length];
		for(int l = 0; l < matrix_4.length; ++l){
		for(int k = 0; k < matrix_4[0].length; ++k){
		for(int i = 0; i < matrix_4[0][0][0].length; ++i){
			result[l][k][i] = matrix_4[l][k][index_y][i];
		}}}
		return result;
	}
	
	public static int[][][] select_yzt(int[][][][] matrix_4, int index_x){
		int[][][] result = new int[matrix_4.length][matrix_4[0].length][matrix_4[0][0].length];
		for(int l = 0; l < matrix_4.length; ++l){
		for(int k = 0; k < matrix_4[0].length; ++k){
		for(int j = 0; j < matrix_4[0][0].length; ++j){
			result[l][k][j] = matrix_4[l][k][j][index_x];
		}}}
		return result;
	}
	
	public static long[][][] select_yzt(long[][][][] matrix_4, int index_x){
		long[][][] result = new long[matrix_4.length][matrix_4[0].length][matrix_4[0][0].length];
		for(int l = 0; l < matrix_4.length; ++l){
		for(int k = 0; k < matrix_4[0].length; ++k){
		for(int j = 0; j < matrix_4[0][0].length; ++j){
			result[l][k][j] = matrix_4[l][k][j][index_x];
		}}}
		return result;
	}
	
	public static int[][][] shift_x(int[][][] matrix_3, int shift){
		int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length];
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][j][Op.trueModulus(i + shift, matrix_3[0][0].length)] = matrix_3[k][j][i];
		}}}
		return result;
	}
	
	public static long[][][] shift_x(long[][][] matrix_3, int shift){
		long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length];
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][j][Op.trueModulus(i + shift, matrix_3[0][0].length)] = matrix_3[k][j][i];
		}}}
		return result;
	}
	
	public static int[][][] shift_y(int[][][] matrix_3, int shift){
		int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length];
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][Op.trueModulus(j + shift, matrix_3[0].length)][i] = matrix_3[k][j][i];
		}}}
		return result;
	}
	
	public static long[][][] shift_y(long[][][] matrix_3, int shift){
		long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length];
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][Op.trueModulus(j + shift, matrix_3[0].length)][i] = matrix_3[k][j][i];
		}}}
		return result;
	}
	
	public static int[][][] shift_z(int[][][] matrix_3, int shift){
		int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length];
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[Op.trueModulus(k + shift, matrix_3.length)][j][i] = matrix_3[k][j][i];
		}}}
		return result;
	}
	
	public static long[][][] shift_z(long[][][] matrix_3, int shift){
		long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length];
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[Op.trueModulus(k + shift, matrix_3.length)][j][i] = matrix_3[k][j][i];
		}}}
		return result;
	}
	
	public static int[][][] expand_x(int[][][] matrix_3, int add){
		if(matrix_3[0][0].length + add > 0){
			int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + add];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expand_x(matrix_3[k], add);
			}
			return result;
		}else{
			return new int[0][0][0];
		}
	}
	
	public static long[][][] expand_x(long[][][] matrix_3, int add){
		if(matrix_3[0][0].length + add > 0){
			long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + add];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expand_x(matrix_3[k], add);
			}
			return result;
		}else{
			return new long[0][0][0];
		}
	}
	
	public static int[][][] expandShift_x(int[][][] matrix_3, int shift){
		if(matrix_3[0][0].length + shift > 0){
			int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + shift];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expandShift_x(matrix_3[k], shift);
			}
			return result;
		}else{
			return new int[0][0][0];
		}
	}
	
	public static long[][][] expandShift_x(long[][][] matrix_3, int shift){
		if(matrix_3[0][0].length + shift > 0){
			long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + shift];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expandShift_x(matrix_3[k], shift);
			}
			return result;
		}else{
			return new long[0][0][0];
		}
	}
	
	public static int[][][] expand_y(int[][][] matrix_3, int add){
		if(matrix_3[0].length + add > 0){
			int[][][] result = new int[matrix_3.length][matrix_3[0].length + add][matrix_3[0][0].length];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expand_y(matrix_3[k], add);
			}
			return result;
		}else{
			return new int[0][0][0];
		}
	}
	
	public static long[][][] expand_y(long[][][] matrix_3, int add){
		if(matrix_3[0].length + add > 0){
			long[][][] result = new long[matrix_3.length][matrix_3[0].length + add][matrix_3[0][0].length];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expand_y(matrix_3[k], add);
			}
			return result;
		}else{
			return new long[0][0][0];
		}
	}
	
	public static int[][][] expandShift_y(int[][][] matrix_3, int shift){
		if(matrix_3[0].length + shift > 0){
			int[][][] result = new int[matrix_3.length][matrix_3[0].length + shift][matrix_3[0][0].length];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expandShift_y(matrix_3[k], shift);
			}
			return result;
		}else{
			return new int[0][0][0];
		}
	}
	
	public static long[][][] expandShift_y(long[][][] matrix_3, int shift){
		if(matrix_3[0].length + shift > 0){
			long[][][] result = new long[matrix_3.length][matrix_3[0].length + shift][matrix_3[0][0].length];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = Matrix_2.expandShift_y(matrix_3[k], shift);
			}
			return result;
		}else{
			return new long[0][0][0];
		}
	}
	
	public static int[][][] expand_z(int[][][] matrix_3, int add){
		if(add >= 0){
			int[][][] result = new int[matrix_3.length + add][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = matrix_3[k];
			}
			return result;
		}else if(-add < matrix_3.length){
			int[][][] result = new int[matrix_3.length + add][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0; k < result.length; ++k){
				result[k] = matrix_3[k];
			}
			return result;
		}else{
			return new int[0][0][0];
		}
	}
	
	public static long[][][] expand_z(long[][][] matrix_3, int add){
		if(add >= 0){
			long[][][] result = new long[matrix_3.length + add][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0; k < matrix_3.length; ++k){
				result[k] = matrix_3[k];
			}
			return result;
		}else if(-add < matrix_3.length){
			long[][][] result = new long[matrix_3.length + add][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0; k < result.length; ++k){
				result[k] = matrix_3[k];
			}
			return result;
		}else{
			return new long[0][0][0];
		}
	}
	
	public static int[][][] expandShift_z(int[][][] matrix_3, int shift){
		if(shift >= 0){
			int[][][] result = new int[matrix_3.length + shift][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0, s = shift; k < matrix_3.length; ++k, ++s){
				result[s] = matrix_3[k];
			}
			return result;
		}else if(-shift < matrix_3.length){
			int[][][] result = new int[matrix_3.length + shift][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0, s = -shift; k < result.length; ++k, ++s){
				result[k] = matrix_3[s];
			}
			return result;
		}else{
			return new int[0][0][0];
		}
	}
	
	public static long[][][] expandShift_z(long[][][] matrix_3, int shift){
		if(shift >= 0){
			long[][][] result = new long[matrix_3.length + shift][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0, s = shift; k < matrix_3.length; ++k, ++s){
				result[s] = matrix_3[k];
			}
			return result;
		}else if(-shift < matrix_3.length){
			long[][][] result = new long[matrix_3.length + shift][matrix_3[0].length][matrix_3[0][0].length];
			for(int k = 0, s = -shift; k < result.length; ++k, ++s){
				result[k] = matrix_3[s];
			}
			return result;
		}else{
			return new long[0][0][0];
		}
	}
	
	public static int[][][] insert_x(int[][][] matrix_3, int[][][] insert){
		if(matrix_3.length != insert.length || matrix_3[0].length != insert[0].length){
			return null;
		}
		int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + insert[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_x(matrix_3[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static long[][][] insert_x(long[][][] matrix_3, long[][][] insert){
		if(matrix_3.length != insert.length || matrix_3[0].length != insert[0].length){
			return null;
		}
		long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + insert[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_x(matrix_3[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static int[][][] insert_x(int[][][] matrix_3, int[][][] insert, int index){
		if(matrix_3.length != insert.length || matrix_3[0].length != insert[0].length){
			return null;
		}
		int[][][] result = new int[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + insert[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_x(matrix_3[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static long[][][] insert_x(long[][][] matrix_3, long[][][] insert, int index){
		if(matrix_3.length != insert.length || matrix_3[0].length != insert[0].length){
			return null;
		}
		long[][][] result = new long[matrix_3.length][matrix_3[0].length][matrix_3[0][0].length + insert[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_x(matrix_3[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static int[][][] insert_y(int[][][] matrix_3, int[][][] insert){
		if(matrix_3.length != insert.length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		int[][][] result = new int[matrix_3.length][matrix_3[0].length + insert[0].length][matrix_3[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_y(matrix_3[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static long[][][] insert_y(long[][][] matrix_3, long[][][] insert){
		if(matrix_3.length != insert.length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		long[][][] result = new long[matrix_3.length][matrix_3[0].length + insert[0].length][matrix_3[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_y(matrix_3[len], insert[len]);
			++len;
		}
		return result;
	}
	
	public static int[][][] insert_y(int[][][] matrix_3, int[][][] insert, int index){
		if(matrix_3.length != insert.length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		int[][][] result = new int[matrix_3.length][matrix_3[0].length + insert[0].length][matrix_3[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_y(matrix_3[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static long[][][] insert_y(long[][][] matrix_3, long[][][] insert, int index){
		if(matrix_3.length != insert.length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		long[][][] result = new long[matrix_3.length][matrix_3[0].length + insert[0].length][matrix_3[0][0].length];
		int len = 0;
		while(len < result.length){
			result[len] = Matrix_2.insert_y(matrix_3[len], insert[len], index);
			++len;
		}
		return result;
	}
	
	public static int[][][] insert_z(int[][][] matrix_3, int[][][] insert){
		if(matrix_3[0].length != insert[0].length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		int[][][] result = new int[matrix_3.length + insert.length][matrix_3[0].length][matrix_3[0][0].length];
		int len = 0;
		for(int[][] matrix_2 : matrix_3){
			result[len++] = matrix_2;
		}
		for(int[][] matrix_2 : insert){
			result[len++] = matrix_2;
		}
		return result;
	}
	
	public static long[][][] insert_z(long[][][] matrix_3, long[][][] insert){
		if(matrix_3[0].length != insert[0].length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		long[][][] result = new long[matrix_3.length + insert.length][matrix_3[0].length][matrix_3[0][0].length];
		int len = 0;
		for(long[][] matrix_2 : matrix_3){
			result[len++] = matrix_2;
		}
		for(long[][] matrix_2 : insert){
			result[len++] = matrix_2;
		}
		return result;
	}
	
	public static int[][][] insert_z(int[][][] matrix_3, int[][][] insert, int index){
		if(matrix_3[0].length != insert[0].length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		int[][][] result = new int[matrix_3.length + insert.length][matrix_3[0].length][matrix_3[0][0].length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_3[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_3[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static long[][][] insert_z(long[][][] matrix_3, long[][][] insert, int index){
		if(matrix_3[0].length != insert[0].length || matrix_3[0][0].length != insert[0][0].length){
			return null;
		}
		long[][][] result = new long[matrix_3.length + insert.length][matrix_3[0].length][matrix_3[0][0].length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_3[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_3[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static int[][][] assign_x(int[][][] matrix_3, int[][] p, int index_x){
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
			matrix_3[k][j][index_x] = p[k][j];
		}}
		return matrix_3;
	}
	
	public static long[][][] assign_x(long[][][] matrix_3, long[][] p, int index_x){
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
			matrix_3[k][j][index_x] = p[k][j];
		}}
		return matrix_3;
	}
	
	public static char[][][] assign_x(char[][][] matrix_3, char[][] p, int index_x){
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
			matrix_3[k][j][index_x] = p[k][j];
		}}
		return matrix_3;
	}
	
	public static int[][][] assign_y(int[][][] matrix_3, int[][] p, int index_y){
		for(int k = 0; k < matrix_3.length; ++k){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			matrix_3[k][index_y][i] = p[k][i];
		}}
		return matrix_3;
	}
	
	public static long[][][] assign_y(long[][][] matrix_3, long[][] p, int index_y){
		for(int k = 0; k < matrix_3.length; ++k){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			matrix_3[k][index_y][i] = p[k][i];
		}}
		return matrix_3;
	}
	
	public static char[][][] assign_y(char[][][] matrix_3, char[][] p, int index_y){
		for(int k = 0; k < matrix_3.length; ++k){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			matrix_3[k][index_y][i] = p[k][i];
		}}
		return matrix_3;
	}
	
	public static int[][][] assign_z(int[][][] matrix_3, int[][] p, int index_z){
		matrix_3[index_z] = p;
		return matrix_3;
	}
	
	public static long[][][] assign_z(long[][][] matrix_3, long[][] p, int index_z){
		matrix_3[index_z] = p;
		return matrix_3;
	}
	
	public static char[][][] assign_z(char[][][] matrix_3, char[][] p, int index_z){
		matrix_3[index_z] = p;
		return matrix_3;
	}
	
	public static int[][][] assign_xy(int[][][] matrix_3, int[] p, int index_x, int index_y){
		for(int k = 0; k < matrix_3.length; ++k){
			matrix_3[k][index_y][index_x] = p[k];
		}
		return matrix_3;
	}
	
	public static long[][][] assign_xy(long[][][] matrix_3, long[] p, int index_x, int index_y){
		for(int k = 0; k < matrix_3.length; ++k){
			matrix_3[k][index_y][index_x] = p[k];
		}
		return matrix_3;
	}
	
	public static char[][][] assign_xy(char[][][] matrix_3, char[] p, int index_x, int index_y){
		for(int k = 0; k < matrix_3.length; ++k){
			matrix_3[k][index_y][index_x] = p[k];
		}
		return matrix_3;
	}
	
	public static int[][][] assign_xz(int[][][] matrix_3, int[] p, int index_x, int index_z){
		for(int j = 0; j < matrix_3[0].length; ++j){
			matrix_3[index_z][j][index_x] = p[j];
		}
		return matrix_3;
	}
	
	public static long[][][] assign_xz(long[][][] matrix_3, long[] p, int index_x, int index_z){
		for(int j = 0; j < matrix_3[0].length; ++j){
			matrix_3[index_z][j][index_x] = p[j];
		}
		return matrix_3;
	}
	
	public static char[][][] assign_xz(char[][][] matrix_3, char[] p, int index_x, int index_z){
		for(int j = 0; j < matrix_3[0].length; ++j){
			matrix_3[index_z][j][index_x] = p[j];
		}
		return matrix_3;
	}
	
	public static int[][][] assign_yz(int[][][] matrix_3, int[] p, int index_y, int index_z){
		matrix_3[index_z][index_y] = p;
		return matrix_3;
	}
	
	public static long[][][] assign_yz(long[][][] matrix_3, long[] p, int index_y, int index_z){
		matrix_3[index_z][index_y] = p;
		return matrix_3;
	}
	
	public static char[][][] assign_yz(char[][][] matrix_3, char[] p, int index_y, int index_z){
		matrix_3[index_z][index_y] = p;
		return matrix_3;
	}
	
	public static int[][][] assign_xyz(int[][][] matrix_3, int p, int index_x, int index_y, int index_z){
		matrix_3[index_z][index_y][index_x] = p;
		return matrix_3;
	}
	
	public static long[][][] assign_xyz(long[][][] matrix_3, long p, int index_x, int index_y, int index_z){
		matrix_3[index_z][index_y][index_x] = p;
		return matrix_3;
	}
	
	public static char[][][] assign_xyz(char[][][] matrix_3, char p, int index_x, int index_y, int index_z){
		matrix_3[index_z][index_y][index_x] = p;
		return matrix_3;
	}
	
	public static int[][][] fill(int[][][] matrix_3, int p){
		int[][][] result = matrix_3;
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][j][i] = p;
		}}}
		return result;
	}
	
	public static long[][][] fill(long[][][] matrix_3, long p){
		long[][][] result = matrix_3;
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][j][i] = p;
		}}}
		return result;
	}
	
	public static char[][][] fill(char[][][] matrix_3, char p){
		char[][][] result = matrix_3;
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			result[k][j][i] = p;
		}}}
		return result;
	}
	
	public static int[][][] substitute(int[][][] matrix_3, int from, int to){
		int[][][] result = matrix_3;
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			if(result[k][j][i] == from){
				result[k][j][i] = to;
			}
		}}}
		return result;
	}
	
	public static long[][][] substitute(long[][][] matrix_3, long from, long to){
		long[][][] result = matrix_3;
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			if(result[k][j][i] == from){
				result[k][j][i] = to;
			}
		}}}
		return result;
	}
	
	public static char[][][] substitute(char[][][] matrix_3, char from, char to){
		char[][][] result = matrix_3;
		for(int k = 0; k < matrix_3.length; ++k){
		for(int j = 0; j < matrix_3[0].length; ++j){
		for(int i = 0; i < matrix_3[0][0].length; ++i){
			if(result[k][j][i] == from){
				result[k][j][i] = to;
			}
		}}}
		return result;
	}
	
	/**
	 * Selection sort of the elements in each x-row by natural order ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static int[][][] sort_x(int[][][] matrix_3){
		int[][][] sorted = matrix_3;
		for(int k = 0; k < sorted.length; ++k){
			sorted[k] = Matrix_2.sort_x(sorted[k]);
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the elements in each x-row by natural order ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static long[][][] sort_x(long[][][] matrix_3){
		long[][][] sorted = matrix_3;
		for(int k = 0; k < sorted.length; ++k){
			sorted[k] = Matrix_2.sort_x(sorted[k]);
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the x-rows in each xy-plane by natural order of their sums ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static int[][][] sort_y(int[][][] matrix_3){
		int[][][] sorted = matrix_3;
		for(int k = 0; k < sorted.length; ++k){
			sorted[k] = Matrix_2.sort_y(sorted[k]);
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the x-rows in each xy-plane by natural order of their sums ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static long[][][] sort_y(long[][][] matrix_3){
		long[][][] sorted = matrix_3;
		for(int k = 0; k < sorted.length; ++k){
			sorted[k] = Matrix_2.sort_y(sorted[k]);
		}
		return sorted;
	}
	
	/**
	 * Selection sort of the xy-planes by natural order of their sums ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static int[][][] sort_z(int[][][] matrix_3){
		int index = 0;
		int[][][] sorted = matrix_3;
		int compsum;
		int compindex = 0;
		int[][] comp;
		while(index < sorted.length){
			compsum = Integer.MAX_VALUE;
			for(int k = 0; k < sorted.length; ++k){
				int s = Statistic.sum(sorted[k]);
				if(s < compsum){
					compsum = s;
					compindex = k;
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
	 * Selection sort of the xy-planes by natural order of their sums ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static long[][][] sort_z(long[][][] matrix_3){
		int index = 0;
		long[][][] sorted = matrix_3;
		long compsum;
		int compindex = 0;
		long[][] comp;
		while(index < sorted.length){
			compsum = Integer.MAX_VALUE;
			for(int k = 0; k < sorted.length; ++k){
				long s = Statistic.sum(sorted[k]);
				if(s < compsum){
					compsum = s;
					compindex = k;
				}
			}
			comp = sorted[compindex];
			sorted[compindex] = sorted[index];
			sorted[index] = comp;
			++index;
		}
		return sorted;
	}
	
	public static String plot(int[][][] matrix_3){
		int[] max_min = Statistic.min_max(matrix_3);
		int maxlen = Statistic.max(Integer.toString(max_min[0]).length(), Integer.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String result = "";
		for(int[][] matrix_2 : matrix_3){
		for(int[] matrix_1 : matrix_2){
		for(int i : matrix_1){
			result += "[" + String.format(format, i) + "]";
		}
		result += '\n';
		}
		result += '\n';
		}
		return result;
	}
	
	public static String plot(long[][][] matrix_3){
		long[] max_min = Statistic.min_max(matrix_3);
		int maxlen = Statistic.max(Long.toString(max_min[0]).length(), Long.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String result = "";
		for(long[][] matrix_2 : matrix_3){
		for(long[] matrix_1 : matrix_2){
		for(long i : matrix_1){
			result += "[" + String.format(format, i) + "]";
		}
		result += '\n';
		}
		result += '\n';
		}
		return result;
	}
	
	public static String plot(char[][][] matrix_3){
		String result = "";
		for(char[][] matrix_2 : matrix_3){
		for(char[] matrix_1 : matrix_2){
		for(char c : matrix_1){
			result += "[" + c + "]";
		}
		result += '\n';
		}
		result += '\n';
		}
		return result;
	}
	
}
