package integerMath;

public class Function{
	
	public static int[] diff(int[] is){
		int[] d_is = new int[is.length];
		int max = is.length - 1;
		d_is[0] = is[1] - is[0];
		d_is[max] = is[max] - is[max - 1];
		for(int i = 1; i < max; ++i){
			d_is[i] = (is[i + 1] - is[i - 1]) / 2;
		}
		return d_is;
	}
	
	public static long[] diff(long[] is){
		long[] d_is = new long[is.length];
		d_is[0] = is[1] - is[0];
		d_is[is.length - 1] = is[is.length - 1] - is[is.length - 2];
		for(int i = 1; i < is.length - 1; ++i){
			d_is[i] = (is[i + 1] - is[i - 1]) / 2;
		}
		return d_is;
	}
	
	public static int diff_at(int[] is, int x){
		if(x < 0 || x >= is.length){
			return 0;
		}else if(x == 0){
			return is[1] - is[0];
		}else if(x == is.length - 1){
			return is[x] - is[x - 1];
		}else{
			return (is[x + 1] - is[x - 1]) / 2;
		}
	}
	
	public static long diff_at(long[] is, int x){
		if(x < 0 || x >= is.length){
			return 0;
		}else if(x == 0){
			return is[1] - is[0];
		}else if(x == is.length - 1){
			return is[x] - is[x - 1];
		}else{
			return (is[x + 1] - is[x - 1]) / 2;
		}
	}
	
	/**
	 * NON JAGGED INPUTS UNPREDICTED
	 * 
	 * @param is
	 * @return
	 */
	public static int[][] diff_x(int[][] is){
		int[][] d_is = new int[is.length][is[0].length];
		for(int j = 0; j < is.length; ++j){
			d_is[j] = diff(is[j]);
		}
		return d_is;
	}
	
	/**
	 * NON JAGGED INPUTS UNPREDICTED
	 * 
	 * @param is
	 * @return
	 */
	public static long[][] diff_x(long[][] is){
		long[][] d_is = new long[is.length][is[0].length];
		for(int j = 0; j < is.length; ++j){
			d_is[j] = diff(is[j]);
		}
		return d_is;
	}
	
	public static int diff_x_at(int[][] is, int x, int y){
		if(y < 0 || y >= is.length){
			return 0;
		}else{
			return diff_at(is[y], x);
		}
	}
	
	public static long diff_x_at(long[][] is, int x, int y){
		if(y < 0 || y >= is.length){
			return 0;
		}else{
			return diff_at(is[y], x);
		}
	}
	
	/**
	 * NON JAGGED INPUTS UNPREDICTED
	 * 
	 * @param is
	 * @return
	 */
	public static int[][] diff_y(int[][] is){
		int[][] d_is = new int[is.length][is[0].length];
		int max = is.length - 1;
		for(int i = 0; i < is.length; ++i){
			d_is[0][i] = is[1][i] - is[0][i];
		}
		for(int i = 0; i < is.length; ++i){
			d_is[max][i] = is[max][i] - is[max - 1][i];
		}
		for(int i = 0; i < is[0].length; ++i){
			for(int j = 1; j < max; ++j){
				d_is[j][i] = (is[j + 1][i] - is[j - 1][i]) / 2;
			}
		}
		return d_is;
	}
	
	/**
	 * NON JAGGED INPUTS UNPREDICTED
	 * 
	 * @param is
	 * @return
	 */
	public static long[][] diff_y(long[][] is){
		long[][] d_is = new long[is.length][is[0].length];
		int max = is.length - 1;
		for(int i = 0; i < is.length; ++i){
			d_is[0][i] = is[1][i] - is[0][i];
		}
		for(int i = 0; i < is.length; ++i){
			d_is[max][i] = is[max][i] - is[max - 1][i];
		}
		for(int i = 0; i < is[0].length; ++i){
			for(int j = 1; j < max; ++j){
				d_is[j][i] = (is[j + 1][i] - is[j - 1][i]) / 2;
			}
		}
		return d_is;
	}
	
	public static int diff_y_at(int[][] is, int x, int y){
		if(x < 0 || x >= is[0].length || y < 0 || y >= is.length){
			return 0;
		}else if(y == 0){
			return is[1][x] - is[0][x];
		}else if(y == is.length - 1){
			return is[y][x] - is[y - 1][x];
		}else{
			return (is[y + 1][x] - is[y - 1][x]) / 2;
		}
	}
	
	public static int[][] gradient(int[][] is){
		int[][] is_diff_x = diff_x(is);
		int[][] is_diff_y = diff_y(is);
		int[][] is_grad = new int[is.length][is[0].length];
		for(int j = 0; j < is.length; ++j){
			for(int i = 0; i < is[0].length; ++i){
				is_grad[j][i] = is_diff_x[j][i] * is_diff_y[j][i];
			}
		}
		return is_grad;
	}
	
	public static long[][] gradient(long[][] is){
		long[][] is_diff_x = diff_x(is);
		long[][] is_diff_y = diff_y(is);
		long[][] is_grad = new long[is.length][is[0].length];
		for(int j = 0; j < is.length; ++j){
			for(int i = 0; i < is[0].length; ++i){
				is_grad[j][i] = is_diff_x[j][i] * is_diff_y[j][i];
			}
		}
		return is_grad;
	}
	
	public static int[] integ(int[] is){
		int[] s_is = new int[is.length];
		int acum = 0;
		for(int i = 0; i < is.length; ++i){
			acum += is[i];
			s_is[i] = acum;
		}
		return s_is;
	}
	
	public static long[] integ(long[] is){
		long[] s_is = new long[is.length];
		long acum = 0;
		for(int i = 0; i < is.length; ++i){
			acum += is[i];
			s_is[i] = acum;
		}
		return s_is;
	}
	
	public static int[] integ(int[] is, int c){
		int[] s_is = new int[is.length];
		int acum = c;
		for(int i = 0; i < is.length; ++i){
			acum += is[i];
			s_is[i] = acum;
		}
		return s_is;
	}
	
	public static long[] integ(long[] is, long c){
		long[] s_is = new long[is.length];
		long acum = c;
		for(int i = 0; i < is.length; ++i){
			acum += is[i];
			s_is[i] = acum;
		}
		return s_is;
	}
	
	public static int integ(int[] is, int a, int b){
		int i; int max;
		if(a < 0){
			i = 0;
		}else{
			i = a;
		}
		if(b > is.length){
			max = is.length;
		}else{
			max = b;
		}
		int acum = 0;
		while(i < max){
			acum += is[i];
			++i;
		}
		return acum;
	}
	
	public static long integ(long[] is, int a, int b){
		int i; int max;
		if(a < 0){
			i = 0;
		}else{
			i = a;
		}
		if(b > is.length){
			max = is.length;
		}else{
			max = b;
		}
		int acum = 0;
		while(i < max){
			acum += is[i];
			++i;
		}
		return acum;
	}
	
	public static int integ(int[] is, int c, int a, int b){
		int i; int max;
		if(a < 0){
			i = 0;
		}else{
			i = a;
		}
		if(b > is.length){
			max = is.length;
		}else{
			max = b;
		}
		int acum = c;
		System.out.println("acum: " + acum);
		while(i < max){
			acum += is[i];System.out.println("plus: " + is[i]);System.out.println("acum: " + acum);
			++i;
		}
		return acum;
	}
	
	public static long integ(long[] is, long c, int a, int b){
		int i; int max;
		if(a < 0){
			i = 0;
		}else{
			i = a;
		}
		if(b > is.length){
			max = is.length;
		}else{
			max = b;
		}
		long acum = c;
		while(i < max){
			acum += is[i];
			++i;
		}
		return acum;
	}
	
	public static int[] signum(int[] is){
		int[] sg_is = new int[is.length];
		for(int i = 0; i < is.length; ++i){
			sg_is[i] = is[i] > 0 ? 1 : (is[i] < 0 ? -1 : 0);
		}
		return sg_is;
	}
	
	public static long[] signum(long[] is){
		long[] sg_is = new long[is.length];
		for(int i = 0; i < is.length; ++i){
			sg_is[i] = is[i] > 0 ? 1 : (is[i] < 0 ? -1 : 0);
		}
		return sg_is;
	}
	
	/**
	 * Disparity boosting function that returns x for x
	 */
	public static int disparityBoost(int i, int x){
		return i > 0 ?
				 Op.sqrt( x*i):
				-Op.sqrt(-x*i);
	}
	
	/**
	 * Disparity boosting function that returns x for x
	 */
	public static long disparityBoost(long i, int x){
		return i > 0 ?
				 Op.sqrt( x*i):
				-Op.sqrt(-x*i);
	}
	
	/**
	 * Disparity boosting function that returns x_out for x_in
	 */
	public static int disparityBoost(int i, int x_in, int x_out){
		return i > 0 ?
				 Op.sqrt( x_in*i)*(x_out/x_in):
				-Op.sqrt(-x_in*i)*(x_out/x_in);
	}
	
	/**
	 * Disparity boosting function that returns x_out for x_in
	 */
	public static long disparityBoost(long i, long x_in, long x_out){
		return i > 0 ?
				 Op.sqrt( x_in*i)*(x_out/x_in):
				-Op.sqrt(-x_in*i)*(x_out/x_in);
	}
	
	/**
	 * Disparity smoothing function that returns x for x
	 */
	public static int disparitySmooth(int i, int x){
		return (Op.abs(i)*i)/x;
	}
	
	/**
	 * Disparity smoothing function that returns x for x
	 */
	public static long disparitySmooth(long i, long x){
		return (Op.abs(i)*i)/x;
	}
	
	/**
	 * Disparity smoothing function that returns x_out for x_in
	 */
	public static int disparitySmooth(int i, int x_in, int x_out){
		return (Op.abs(i)*i*x_out)/(x_in*x_in);
	}
	
	/**
	 * Disparity smoothing function that returns x_out for x_in
	 */
	public static long disparitySmooth(long i, long x_in, long x_out){
		return (Op.abs(i)*i*x_out)/(x_in*x_in);
	}
	
	public static int[] minus(int[] is){
		int[] _is = new int[is.length];
		for(int i = 0; i < is.length; ++i){
			_is[i] = -is[i];
		}
		return _is;
	}
	
	public static long[] minus(long[] is){
		long[] _is = new long[is.length];
		for(int i = 0; i < is.length; ++i){
			_is[i] = -is[i];
		}
		return _is;
	}
	
	public static int[] add(int[] f_1, int[] f_2){
		if(f_1.length == f_2.length){
			int[] f = new int[f_1.length];
			for(int i = 0; i < f_1.length; ++i){
				f[i] = f_1[i] + f_2[i];
			}
			return f;
		}else{
			return new int[0];
		}
	}
	
	public static long[] add(long[] f_1, long[] f_2){
		if(f_1.length == f_2.length){
			long[] f = new long[f_1.length];
			for(int i = 0; i < f_1.length; ++i){
				f[i] = f_1[i] + f_2[i];
			}
			return f;
		}else{
			return new long[0];
		}
	}
	
	public static int[] mult(int[] f_1, int[] f_2){
		if(f_1.length == f_2.length){
			int[] f = new int[f_1.length];
			for(int i = 0; i < f_1.length; ++i){
				f[i] = f_1[i] * f_2[i];
			}
			return f;
		}else{
			return new int[0];
		}
	}
	
	public static long[] mult(long[] f_1, long[] f_2){
		if(f_1.length == f_2.length){
			long[] f = new long[f_1.length];
			for(int i = 0; i < f_1.length; ++i){
				f[i] = f_1[i] * f_2[i];
			}
			return f;
		}else{
			return new long[0];
		}
	}
	
	public static int[] div(int[] f_1, int[] f_2){
		if(f_1.length == f_2.length){
			int[] f = new int[f_1.length];
			for(int i = 0; i < f_1.length; ++i){
				f[i] = f_1[i] / f_2[i];
			}
			return f;
		}else{
			return new int[0];
		}
	}
	
	public static long[] div(long[] f_1, long[] f_2){
		if(f_1.length == f_2.length){
			long[] f = new long[f_1.length];
			for(int i = 0; i < f_1.length; ++i){
				f[i] = f_1[i] / f_2[i];
			}
			return f;
		}else{
			return new long[0];
		}
	}
	
}
