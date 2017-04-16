package integerMath;

/**
 * A matrix representing a x-row
 * 
 * @author Javier
 *
 */
public class Matrix_1 {

	public static int[] create_int(int length_x){
		return new int[length_x];
	}
	
	public static long[] create_long(int length_x){
		return new long[length_x];
	}
	
	public static char[] create_char(int length_x){
		return new char[length_x];
	}
	
	public static int[] range(int end){
		int[] result = new int[Op.abs(end) + 1];
		if(end > 0){
			for(int i = 0; i <= end; ++i){
				result[i] = i;
			}
		}else{
			for(int i = 0; i >= end; --i){
				result[-i] = i;
			}
		}
		return result;
	}
	
	public static long[] range(long end){
		long[] result = new long[(int)(Op.abs(end) + 1)];
		if(end > 0){
			for(int i = 0; i <= end; ++i){
				result[i] = i;
			}
		}else{
			for(int i = 0; i >= end; --i){
				result[-i] = i;
			}
		}
		return result;
	}
	
	public static int[] range(int start, int end){
		int[] result = new int[Op.abs(end - start) + 1];
		if(end > start){
			for(int i = start, j = 0; i <= end; ++i, ++j){
				result[j] = i;
			}
		}else{
			for(int i = start, j = 0; i >= end; --i, ++j){
				result[j] = i;
			}
		}
		return result;
	}
	
	public static long[] range(long start, long end){
		long[] result = new long[(int)(Op.abs(end - start) + 1)];
		if(end > start){
			for(long i = start, j = 0; i <= end; ++i, ++j){
				result[(int)j] = i;
			}
		}else{
			for(long i = start, j = 0; i >= end; --i, ++j){
				result[(int)j] = i;
			}
		}
		return result;
	}
	
	public static int[] range(int start, int end, int step){
		int[] result = new int[(Op.abs(end - start) / step) + 1];
		if(end > start){
			for(int i = start, j = 0; i <= end; i += step, ++j){
				result[j] = i;
			}
		}else{
			for(int i = start, j = 0; i >= end; i -= step, ++j){
				result[j] = i;
			}
		}
		return result;
	}
	
	public static long[] range(long start, long end, long step){
		long[] result = new long[(int)((Op.abs(end - start) / step) + 1)];
		if(end > start){
			for(long i = start, j = 0; i <= end; i += step, ++j){
				result[(int)j] = i;
			}
		}else{
			for(long i = start, j = 0; i >= end; i -= step, ++j){
				result[(int)j] = i;
			}
		}
		return result;
	}
	
	public static int[] compose_x(int... matrix_1){
		return matrix_1;
	}
	
	public static long[] compose_x(long... matrix_1){
		return matrix_1;
	}
	
	/**
	 * Selects a row (varying x, same y) from a 2-dimensional matrix.
	 * @param iss
	 * @param index
	 * @return
	 */
	public static int[] select_x(int[][] matrix_2, int index){
		return matrix_2[index];
	}
	
	/**
	 * Selects a row (varying x, same y) from a 2-dimensional matrix.
	 * @param iss
	 * @param index
	 * @return
	 */
	public static long[] select_x(long[][] matrix_2, int index){
		return matrix_2[index];
	}
	
	/**
	 * Selects a column (same x, varying y) from a 2-dimensional matrix.
	 * @param iss
	 * @param index
	 * @return
	 */
	public static int[] select_y(int[][] matrix_2, int index){
		int[] result = new int[matrix_2.length];
		for(int i = 0; i < matrix_2.length; ++i){
			result[i] = matrix_2[i][index];
		}
		return result;
	}
	
	/**
	 * Selects a column (same x, varying y) from a 2-dimensional matrix.
	 * @param iss
	 * @param index
	 * @return
	 */
	public static long[] select_y(long[][] matrix_2, int index){
		long[] result = new long[matrix_2.length];
		for(int i = 0; i < matrix_2.length; ++i){
			result[i] = matrix_2[i][index];
		}
		return result;
	}
	
	public static int[] select_x(int[][][] matrix_3, int index_y, int index_z){
		return matrix_3[index_z][index_y];
	}
	
	public static long[] select_x(long[][][] matrix_3, int index_y, int index_z){
		return matrix_3[index_z][index_y];
	}
	
	public static int[] select_y(int[][][] matrix_3, int index_x, int index_z){
		int[] result = new int[matrix_3[0].length];
		for(int j = 0; j < matrix_3[0].length; ++j){
			result[j] = matrix_3[index_z][j][index_x];
		}
		return result;
	}
	
	public static long[] select_y(long[][][] matrix_3, int index_x, int index_z){
		long[] result = new long[matrix_3[0].length];
		for(int j = 0; j < matrix_3[0].length; ++j){
			result[j] = matrix_3[index_z][j][index_x];
		}
		return result;
	}
	
	public static int[] select_z(int[][][] matrix_3, int index_x, int index_y){
		int[] result = new int[matrix_3.length];
		for(int k = 0; k < matrix_3.length; ++k){
			result[k] = matrix_3[k][index_y][index_x];
		}
		return result;
	}
	
	public static long[] select_z(long[][][] matrix_3, int index_x, int index_y){
		long[] result = new long[matrix_3.length];
		for(int k = 0; k < matrix_3.length; ++k){
			result[k] = matrix_3[k][index_y][index_x];
		}
		return result;
	}
	
	public static int[] diagonal_xy(int[][] matrix_2){
		int len = Statistic.min(matrix_2.length, matrix_2[0].length);
		int[] result = new int[len];
		for(int i = 0; i < len; ++i){
			result[i] = matrix_2[i][i];
		}
		return result;
	}
	
	public static long[] diagonal_xy(long[][] matrix_2){
		int len = Statistic.min(matrix_2.length, matrix_2[0].length);
		long[] result = new long[len];
		for(int i = 0; i < len; ++i){
			result[i] = matrix_2[i][i];
		}
		return result;
	}
	
	public static int[] diagonal_xyz(int[][][] matrix_3){
		int len = Statistic.min(matrix_3.length, matrix_3[0].length, matrix_3[0][0].length);
		int[] result = new int[len];
		for(int i = 0; i < len; ++i){
			result[i] = matrix_3[i][i][i];
		}
		return result;
	}
	
	public static long[] diagonal_xyz(long[][][] matrix_3){
		int len = Statistic.min(matrix_3.length, matrix_3[0].length, matrix_3[0][0].length);
		long[] result = new long[len];
		for(int i = 0; i < len; ++i){
			result[i] = matrix_3[i][i][i];
		}
		return result;
	}
	
	public static int[] reverse_x(int[] matrix_1){
		int[] result = new int[matrix_1.length];
		for(int i = 0, mi = matrix_1.length - 1; i < matrix_1.length; ++i, --mi){
			result[i] = matrix_1[mi];
		}
		return result;
	}
	
	public static long[] reverse_x(long[] matrix_1){
		long[] result = new long[matrix_1.length];
		for(int i = 0, mi = matrix_1.length - 1; i < matrix_1.length; ++i, --mi){
			result[i] = matrix_1[mi];
		}
		return result;
	}
	
	public static int[] shift_x(int[] matrix_1, int shift){
		int[] result = new int[matrix_1.length];
		for(int i = 0; i < matrix_1.length; ++i){
			result[Op.trueModulus(i + shift, matrix_1.length)] = matrix_1[i];
		}
		return result;
	}
	
	public static long[] shift_x(long[] matrix_1, int shift){
		long[] result = new long[matrix_1.length];
		for(int i = 0; i < matrix_1.length; ++i){
			result[Op.trueModulus(i + shift, matrix_1.length)] = matrix_1[i];
		}
		return result;
	}
	
	public static int[] expand_x(int[] matrix_1, int add){
		if(add >= 0){
			int[] result = new int[matrix_1.length + add];
			for(int i = 0; i < matrix_1.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else if(-add < matrix_1.length){
			int[] result = new int[matrix_1.length + add];
			for(int i = 0; i < result.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else{
			return new int[0];
		}
	}
	
	public static long[] expand_x(long[] matrix_1, int add){
		if(add >= 0){
			long[] result = new long[matrix_1.length + add];
			for(int i = 0; i < matrix_1.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else if(-add < matrix_1.length){
			long[] result = new long[matrix_1.length + add];
			for(int i = 0; i < result.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else{
			return new long[0];
		}
	}
	
	public static boolean[] expand_x(boolean[] matrix_1, int add){
		if(add >= 0){
			boolean[] result = new boolean[matrix_1.length + add];
			for(int i = 0; i < matrix_1.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else if(-add < matrix_1.length){
			boolean[] result = new boolean[matrix_1.length + add];
			for(int i = 0; i < result.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else{
			return new boolean[0];
		}
	}
	
	public static Object[] expand_x(Object[] matrix_1, int add){
		if(add >= 0){
			Object[] result = new Object[matrix_1.length + add];
			for(int i = 0; i < matrix_1.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else if(-add < matrix_1.length){
			Object[] result = new Object[matrix_1.length + add];
			for(int i = 0; i < result.length; ++i){
				result[i] = matrix_1[i];
			}
			return result;
		}else{
			return new Object[0];
		}
	}
	
	public static int[] expandShift_x(int[] matrix_1, int shift){
		if(shift >= 0){
			int[] result = new int[matrix_1.length + shift];
			for(int i = 0, s = shift; i < matrix_1.length; ++i, ++s){
				result[s] = matrix_1[i];
			}
			return result;
		}else if(-shift < matrix_1.length){
			int[] result = new int[matrix_1.length + shift];
			for(int i = 0, s = -shift; i < result.length; ++i, ++s){
				result[i] = matrix_1[s];
			}
			return result;
		}else{
			return new int[0];
		}
	}
	
	public static long[] expandShift_x(long[] matrix_1, int shift){
		if(shift >= 0){
			long[] result = new long[matrix_1.length + shift];
			for(int i = 0, s = shift; i < matrix_1.length; ++i, ++s){
				result[s] = matrix_1[i];
			}
			return result;
		}else if(-shift < matrix_1.length){
			long[] result = new long[matrix_1.length + shift];
			for(int i = 0, s = -shift; i < result.length; ++i, ++s){
				result[i] = matrix_1[s];
			}
			return result;
		}else{
			return new long[0];
		}
	}
	
	public static boolean[] expandShift_x(boolean[] matrix_1, int shift){
		if(shift >= 0){
			boolean[] result = new boolean[matrix_1.length + shift];
			for(int i = 0, s = shift; i < matrix_1.length; ++i, ++s){
				result[s] = matrix_1[i];
			}
			return result;
		}else if(-shift < matrix_1.length){
			boolean[] result = new boolean[matrix_1.length + shift];
			for(int i = 0, s = -shift; i < result.length; ++i, ++s){
				result[i] = matrix_1[s];
			}
			return result;
		}else{
			return new boolean[0];
		}
	}
	
	public static Object[] expandShift_x(Object[] matrix_1, int shift){
		if(shift >= 0){
			Object[] result = new Object[matrix_1.length + shift];
			for(int i = 0, s = shift; i < matrix_1.length; ++i, ++s){
				result[s] = matrix_1[i];
			}
			return result;
		}else if(-shift < matrix_1.length){
			Object[] result = new Object[matrix_1.length + shift];
			for(int i = 0, s = -shift; i < result.length; ++i, ++s){
				result[i] = matrix_1[s];
			}
			return result;
		}else{
			return new Object[0];
		}
	}
	
	public static int[] insert_x(int[] matrix_1, int[] insert){
		int[] result = new int[matrix_1.length + insert.length];
		int len = 0;
		for(int i : matrix_1){
			result[len++] = i;
		}
		for(int i : insert){
			result[len++] = i;
		}
		return result;
	}
	
	public static long[] insert_x(long[] matrix_1, long[] insert){
		long[] result = new long[matrix_1.length + insert.length];
		int len = 0;
		for(long i : matrix_1){
			result[len++] = i;
		}
		for(long i : insert){
			result[len++] = i;
		}
		return result;
	}
	
	public static boolean[] insert_x(boolean[] matrix_1, boolean[] insert){
		boolean[] result = new boolean[matrix_1.length + insert.length];
		int len = 0;
		for(boolean i : matrix_1){
			result[len++] = i;
		}
		for(boolean i : insert){
			result[len++] = i;
		}
		return result;
	}
	
	public static Object[] insert_x(Object[] matrix_1, Object[] insert){
		Object[] result = new Object[matrix_1.length + insert.length];
		int len = 0;
		for(Object i : matrix_1){
			result[len++] = i;
		}
		for(Object i : insert){
			result[len++] = i;
		}
		return result;
	}
	
	public static int[] insert_x(int[] matrix_1, int[] insert, int index){
		int[] result = new int[matrix_1.length + insert.length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static long[] insert_x(long[] matrix_1, long[] insert, int index){
		long[] result = new long[matrix_1.length + insert.length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static boolean[] insert_x(boolean[] matrix_1, boolean[] insert, int index){
		boolean[] result = new boolean[matrix_1.length + insert.length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static Object[] insert_x(Object[] matrix_1, Object[] insert, int index){
		Object[] result = new Object[matrix_1.length + insert.length];
		int len = 0;
		int len_ints = 0;
		int len_ins = 0;
		while(len < index){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		while(len < index + insert.length){
			result[len] = insert[len_ins];
			++len;
			++len_ins;
		}
		while(len < result.length){
			result[len] = matrix_1[len_ints];
			++len;
			++len_ints;
		}
		return result;
	}
	
	public static int[] assign_x(int[] matrix_1, int p, int index_x){
		matrix_1[index_x] = p;
		return matrix_1;
	}
	
	public static long[] assign_x(long[] matrix_1, long p, int index_x){
		matrix_1[index_x] = p;
		return matrix_1;
	}
	
	public static char[] assign_x(char[] matrix_1, char p, int index_x){
		matrix_1[index_x] = p;
		return matrix_1;
	}
	
	public static int[] fill(int[] matrix_1, int p){
		int[] result = matrix_1;
		for(int i = 0; i < matrix_1.length; ++i){
			result[i] = p;
		}
		return result;
	}
	
	public static long[] fill(long[] matrix_1, long p){
		long[] result = matrix_1;
		for(int i = 0; i < matrix_1.length; ++i){
			result[i] = p;
		}
		return result;
	}
	
	public static char[] fill(char[] matrix_1, char p){
		char[] result = matrix_1;
		for(int i = 0; i < matrix_1.length; ++i){
			result[i] = p;
		}
		return result;
	}
	
	public static int[] substitute(int[] matrix_1, int from, int to){
		int[] result = matrix_1;
		for(int i = 0; i < matrix_1.length; ++i){
			if(result[i] == from){
				result[i] = to;
			}
		}
		return result;
	}
	
	public static long[] substitute(long[] matrix_1, long from, long to){
		long[] result = matrix_1;
		for(int i = 0; i < matrix_1.length; ++i){
			if(result[i] == from){
				result[i] = to;
			}
		}
		return result;
	}
	
	public static char[] substitute(char[] matrix_1, char from, char to){
		char[] result = matrix_1;
		for(int i = 0; i < matrix_1.length; ++i){
			if(result[i] == from){
				result[i] = to;
			}
		}
		return result;
	}
	
	/**
	 * Selection sort by natural order ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static int[] sort_x(int[] matrix_1){
		int index = 0;
		int[] sorted = matrix_1;
		int comp;
		int compindex = 0;;
		while(index < sorted.length){
			comp = Integer.MAX_VALUE;
			for(int i = index; i < sorted.length; ++i){
				if(sorted[i] < comp){
					comp = sorted[i];
					compindex = i;
				}
			}
			sorted[compindex] = sorted[index];
			sorted[index] = comp;
			++index;
		}
		return sorted;
	}
	
	/**
	 * Selection sort by natural order ( < ).
	 * 
	 * @param is
	 * @return
	 */
	public static long[] sort_x(long[] matrix_1){
		int index = 0;
		long[] sorted = matrix_1;
		long comp;
		int compindex = 0;;
		while(index < sorted.length){
			comp = Integer.MAX_VALUE;
			for(int i = index; i < sorted.length; ++i){
				if(sorted[i] < comp){
					comp = sorted[i];
					compindex = i;
				}
			}
			sorted[compindex] = sorted[index];
			sorted[index] = comp;
			++index;
		}
		return sorted;
	}
	
	public static String plot(int[] matrix_1){
		int[] max_min = Statistic.min_max(matrix_1);
		int maxlen = Statistic.max(Integer.toString(max_min[0]).length(), Integer.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String res = "";
		for(int i : matrix_1){
			res += "[" + String.format(format, i) + "]";
		}
		return res;
	}
	
	public static String plot(long[] matrix_1){
		long[] max_min = Statistic.min_max(matrix_1);
		int maxlen = Statistic.max(Long.toString(max_min[0]).length(), Long.toString(max_min[1]).length());
		String format = "%" + Integer.toString(maxlen) + "d";
		String res = "";
		for(long i : matrix_1){
			res += "[" + String.format(format, i) + "]";
		}
		return res;
	}
	
	public static String plot(char[] matrix_1){
		String result = "";
		for(char c : matrix_1){
			result += "[" + c + "]";
		}
		return result;
	}
	
}
