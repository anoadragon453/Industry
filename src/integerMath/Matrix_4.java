package integerMath;

public class Matrix_4 {

	public static int[][][][] select_0123(int[][][][][] matrix_5, int index_4){
		int[][][][] result =
							new int
							[matrix_5[0].length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result         [     i3][     i2][     i1][     i0]=
			matrix_5[index_4][     i3][     i2][     i1][     i0];
		}}}}
		return result;
	}
	
	public static long[][][][] select_0123(long[][][][][] matrix_5, int index_4){
		long[][][][] result =
							new long
							[matrix_5[0].length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result         [     i3][     i2][     i1][     i0]=
			matrix_5[index_4][     i3][     i2][     i1][     i0];
		}}}}
		return result;
	}
	
	public static int[][][][] select_0124(int[][][][][] matrix_5, int index_3){
		int[][][][] result =
							new int
							[matrix_5.length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result[     i4]         [     i2][     i1][     i0]=
			matrix_5[     i4][index_3][     i2][     i1][     i0];
		}}}}
		return result;
	}
	
	public static long[][][][] select_0124(long[][][][][] matrix_5, int index_3){
		long[][][][] result =
							new long
							[matrix_5.length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result[     i4]         [     i2][     i1][     i0]=
			matrix_5[     i4][index_3][     i2][     i1][     i0];
		}}}}
		return result;
	}
	
	public static int[][][][] select_0134(int[][][][][] matrix_5, int index_2){
		int[][][][] result =
							new int
							[matrix_5.length]
							[matrix_5[0].length]
							[matrix_5[0][0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result[     i4][     i3]         [     i1][     i0]=
			matrix_5[     i4][     i3][index_2][     i1][     i0];
		}}}}
		return result;
	}
	
	public static long[][][][] select_0134(long[][][][][] matrix_5, int index_2){
		long[][][][] result =
							new long
							[matrix_5.length]
							[matrix_5[0].length]
							[matrix_5[0][0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result[     i4][     i3]         [     i1][     i0]=
			matrix_5[     i4][     i3][index_2][     i1][     i0];
		}}}}
		return result;
	}
	
	public static int[][][][] select_0234(int[][][][][] matrix_5, int index_1){
		int[][][][] result =
							new int
							[matrix_5.length]
							[matrix_5[0].length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result[     i4][     i3][     i2]         [     i0]=
			matrix_5[     i4][     i3][     i2][index_1][     i0];
		}}}}
		return result;
	}
	
	public static long[][][][] select_0234(long[][][][][] matrix_5, int index_1){
		long[][][][] result =
							new long
							[matrix_5.length]
							[matrix_5[0].length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i0 = 0; i0 < matrix_5[0][0][0][0].length; ++i0){
			  result[     i4][     i3][     i2]         [     i0]=
			matrix_5[     i4][     i3][     i2][index_1][     i0];
		}}}}
		return result;
	}
	
	public static int[][][][] select_1234(int[][][][][] matrix_5, int index_0){
		int[][][][] result =
							new int
							[matrix_5.length]
							[matrix_5[0].length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
			  result[     i4][     i3][     i2][     i1]         =
			matrix_5[     i4][     i3][     i2][     i1][index_0];
		}}}}
		return result;
	}
	
	public static long[][][][] select_1234(long[][][][][] matrix_5, int index_0){
		long[][][][] result =
							new long
							[matrix_5.length]
							[matrix_5[0].length]
							[matrix_5[0][0].length]
							[matrix_5[0][0][0].length];
		for(int i4 = 0; i4 < matrix_5.length; ++i4){
		for(int i3 = 0; i3 < matrix_5[0].length; ++i3){
		for(int i2 = 0; i2 < matrix_5[0][0].length; ++i2){
		for(int i1 = 0; i1 < matrix_5[0][0][0].length; ++i1){
			  result[     i4][     i3][     i2][     i1]         =
			matrix_5[     i4][     i3][     i2][     i1][index_0];
		}}}}
		return result;
	}
	
	public static int[][][][] shift_0(int[][][][] matrix_4, int shift){
		int[][][][] result =
							new int
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s0 = Op.trueModulus(
						i0 + shift,
							 matrix_4[0][0][0].length);
			  result[i3][i2][i1][s0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static long[][][][] shift_0(long[][][][] matrix_4, int shift){
		long[][][][] result =
							new long
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s0 = Op.trueModulus(
						i0 + shift,
							 matrix_4[0][0][0].length);
			  result[i3][i2][i1][s0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static int[][][][] shift_1(int[][][][] matrix_4, int shift){
		int[][][][] result =
							new int
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s1 = Op.trueModulus(
						i1 + shift,
							 matrix_4[0][0].length);
			  result[i3][i2][s1][i0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static long[][][][] shift_1(long[][][][] matrix_4, int shift){
		long[][][][] result =
							new long
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s1 = Op.trueModulus(
						i1 + shift,
							 matrix_4[0][0].length);
			  result[i3][i2][s1][i0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static int[][][][] shift_2(int[][][][] matrix_4, int shift){
		int[][][][] result =
							new int
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s2 = Op.trueModulus(
						i2 + shift,
							 matrix_4[0].length);
			  result[i3][s2][i1][i0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static long[][][][] shift_2(long[][][][] matrix_4, int shift){
		long[][][][] result =
							new long
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s2 = Op.trueModulus(
						i2 + shift,
							 matrix_4[0].length);
			  result[i3][s2][i1][i0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static int[][][][] shift_3(int[][][][] matrix_4, int shift){
		int[][][][] result =
							new int
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s3 = Op.trueModulus(
						i3 + shift,
							 matrix_4.length);
			  result[s3][i2][i1][i0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static long[][][][] shift_3(long[][][][] matrix_4, int shift){
		long[][][][] result =
							new long
							[matrix_4.length]
							[matrix_4[0].length]
							[matrix_4[0][0].length]
							[matrix_4[0][0][0].length];
		for(int i3 = 0; i3 < matrix_4.length; ++i3){
		for(int i2 = 0; i2 < matrix_4[0].length; ++i2){
		for(int i1 = 0; i1 < matrix_4[0][0].length; ++i1){
		for(int i0 = 0; i0 < matrix_4[0][0][0].length; ++i0){
			int s3 = Op.trueModulus(
						i3 + shift,
							 matrix_4.length);
			  result[s3][i2][i1][i0]=
			matrix_4[i3][i2][i1][i0];
		}}}}
		return result;
	}
	
	public static int[][][][] expand_0(int[][][][] matrix_4, int add){
		if(matrix_4[0][0][0].length + add > 0){
			int[][][][] result =
								new int  [matrix_4.length]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length + add];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = Matrix_3.expand_x(matrix_4[i3], add);
			}
			return result;
		}else{
			return new int[0][0][0][0];
		}
	}
	
	public static long[][][][] expand_0(long[][][][] matrix_4, int add){
		if(matrix_4[0][0][0].length + add > 0){
			long[][][][] result =
								new long [matrix_4.length]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length + add];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = Matrix_3.expand_x(matrix_4[i3], add);
			}
			return result;
		}else{
			return new long[0][0][0][0];
		}
	}
	
	public static int[][][][] expand_1(int[][][][] matrix_4, int add){
		if(matrix_4[0][0].length + add > 0){
			int[][][][] result =
								new int  [matrix_4.length]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length + add]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = Matrix_3.expand_y(matrix_4[i3], add);
			}
			return result;
		}else{
			return new int[0][0][0][0];
		}
	}
	
	public static long[][][][] expand_1(long[][][][] matrix_4, int add){
		if(matrix_4[0][0].length + add > 0){
			long[][][][] result =
								new long [matrix_4.length]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length + add]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = Matrix_3.expand_y(matrix_4[i3], add);
			}
			return result;
		}else{
			return new long[0][0][0][0];
		}
	}
	
	public static int[][][][] expand_2(int[][][][] matrix_4, int add){
		if(matrix_4[0].length + add > 0){
			int[][][][] result =
								new int  [matrix_4.length]
								      [matrix_4[0].length + add]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = Matrix_3.expand_z(matrix_4[i3], add);
			}
			return result;
		}else{
			return new int[0][0][0][0];
		}
	}
	
	public static long[][][][] expand_2(long[][][][] matrix_4, int add){
		if(matrix_4[0].length + add > 0){
			long[][][][] result =
								new long [matrix_4.length]
								      [matrix_4[0].length + add]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = Matrix_3.expand_z(matrix_4[i3], add);
			}
			return result;
		}else{
			return new long[0][0][0][0];
		}
	}
	
	public static int[][][][] expand_3(int[][][][] matrix_4, int add){
		if(add >= 0){
			int[][][][] result =
								new int  [matrix_4.length + add]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = matrix_4[i3];
			}
			return result;
		}else if(-add < matrix_4.length){
			int[][][][] result =
								new int  [matrix_4.length + add]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < result.length; ++i3){
				result[i3] = matrix_4[i3];
			}
			return result;
		}else{
			return new int[0][0][0][0];
		}
	}
	
	public static long[][][][] expand_3(long[][][][] matrix_4, int add){
		if(add >= 0){
			long[][][][] result =
								new long [matrix_4.length + add]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < matrix_4.length; ++i3){
				result[i3] = matrix_4[i3];
			}
			return result;
		}else if(-add < matrix_4.length){
			long[][][][] result =
								new long [matrix_4.length + add]
								      [matrix_4[0].length]
								   [matrix_4[0][0].length]
								[matrix_4[0][0][0].length];
			for(int i3 = 0; i3 < result.length; ++i3){
				result[i3] = matrix_4[i3];
			}
			return result;
		}else{
			return new long[0][0][0][0];
		}
	}
	
}
