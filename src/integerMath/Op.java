package integerMath;

public class Op {

	public static boolean equal(int... is){
		boolean acum = is[0] == is[1];
		for(int i = 2; i < is.length; ++i){
			acum = acum && is[0] == is[i];
		}
		return acum;
	}
	
	public static boolean equal(long... is){
		boolean acum = is[0] == is[1];
		for(int i = 2; i < is.length; ++i){
			acum = acum && is[0] == is[i];
		}
		return acum;
	}
	
	public static boolean equal(int[] is1, int[] is2){
		if(is1.length != is2.length){
			return false;
		}
		boolean acum = is1[0] == is2[0];
		for(int i = 1; i < is1.length; ++i){
			acum = acum && is1[i] == is2[i];
		}
		return acum;
	}
	
	public static boolean equal(long[] is1, long[] is2){
		if(is1.length != is2.length){
			return false;
		}
		boolean acum = is1[0] == is2[0];
		for(int i = 1; i < is1.length; ++i){
			acum = acum && is1[i] == is2[i];
		}
		return acum;
	}
	
	public static boolean equal(int[][] iss1, int[][] iss2){
		if(iss1.length != iss2.length){
			return false;
		}
		boolean acum = equal(iss1[0], iss2[0]);
		for(int i = 1; i < iss1.length; ++i){
			acum = acum && equal(iss1[i], iss2[i]);
		}
		return acum;
	}
	
	public static boolean equal(long[][] iss1, long[][] iss2){
		if(iss1.length != iss2.length){
			return false;
		}
		boolean acum = equal(iss1[0], iss2[0]);
		for(int i = 1; i < iss1.length; ++i){
			acum = acum && equal(iss1[i], iss2[i]);
		}
		return acum;
	}
	
	public static boolean different(int... is){
		return !equal(is);
	}
	
	public static boolean different(long... is){
		return !equal(is);
	}
	
	public static int abs(int i){
		return i > 0 ? i : -i;
	}
	
	public static long abs(long i){
		return i > 0 ? i : -i;
	}
	
	public static int trueModulus(int base, int mod){
		if(mod == 0){
			return 0;
		}else if(base >= 0){
			return base % mod;
		}else{
			return (mod + base % mod) % mod;
		}
	}
	
	public static long trueModulus(long base, long mod){
		if(mod == 0){
			return 0;
		}else if(base >= 0){
			return base % mod;
		}else{
			return (mod + base % mod) % mod;
		}
	}
	
	public static int[] toInt(long... is){
		int[] ints = new int[is.length];
		for(int i = 0; i < is.length; ++i){
			ints[i] = (int)is[i];
		}
		return ints;
	}
	
	public static long[] toLong(int... is){
		long[] longs = new long[is.length];
		for(int i = 0; i < is.length; ++i){
			longs[i] = is[i];
		}
		return longs;
	}
	
	public static int square(int i){
		return i*i;
	}
	
	public static long square(long i){
		return i*i;
	}
	
	public static int cube(int i){
		return i*i*i;
	}
	
	public static long cube(long i){
		return i*i*i;
	}
	
	public static int pow(int base, int power){
		if(power > 1){
			if(power % 2 == 0){
				return pow(base*base, power >>> 1);
			}else{
				return base*pow(base*base, power >>> 1);
			}
		}else if(power == 1){
			return base;
		}else if(power == 0){
			return 1;
		}else{
			return 0;
		}
	}
	
	public static long pow(long base, long power){
		if(power > 1){
			if(power % 2 == 0){
				return pow(base*base, power >>> 1);
			}else{
				return base*pow(base*base, power >>> 1);
			}
		}else if(power == 1){
			return base;
		}else if(power == 0){
			return 1L;
		}else{
			return 0L;
		}
	}
	
	//Untested for negative inputs
	public static int log(int base, int op){
		int i = 0;
		int pow = 0;
		while(pow <= op){
			if(pow < 0){
				break;
			}
			++i;
			pow = pow(base, i);
		}
		return i - 1;
	}
	
	//Untested for negative inputs
	public static long log(long base, long op){
		long i = 0;
		long pow = 0;
		while(pow <= op){
			if(pow < 0){
				break;
			}
			++i;
			pow = pow(base, i);
		}
		return i - 1;
	}
	
	public static int sqrt(int radicand){
		int op = abs(radicand);
		int res = 0;
		int bit = 1 << 30;
		while(bit > op){
			bit >>>= 2;
		}
		while(bit != 0){
			if(op >= res + bit){
				op = op - (res + bit);
				res = res +  2*bit;
			}
			res >>>= 1;
			bit >>>= 2;
		}
		if (op > res){
			++res;
		}
		return res;
	}
	
	public static long sqrt(long radicand){
		long op = abs(radicand);
		long res = 0;
		long bit = 1 << 62;
		while(bit > op){
			bit >>>= 2;
		}
		while(bit != 0){
			if(op >= res + bit){
				op = op - (res + bit);
				res = res +  2*bit;
			}
			res >>>= 1;
			bit >>>= 2;
		}
		if (op > res){
			++res;
		}
		return res;
	}
	
	public static int root(int radicand, int exponent){
		if(exponent < 1){
			return 0;
		}else{
			int op = abs(radicand);
			int i = 0;
			int pow = 0;
			while(pow <= op){
				if(pow < 0){
					break;
				}
				++i;
				pow = pow(i, exponent);
			}
			if(radicand > 0 || exponent % 2 == 0){
				return i - 1;
			}else{
				return 1 - i;
			}
		}
	}
	
	public static long root(long radicand, long exponent){
		if(exponent < 1){
			return 0;
		}else if(exponent == 1){
			return radicand;
		}else{
			long op = abs(radicand);
			long i = 0;
			long pow = 0;
			while(pow <= op){
				if(pow < 0){
					break;
				}
				++i;
				pow = pow(i, exponent);
			}
			if(radicand > 0 || exponent % 2 == 0){
				return i - 1;
			}else{
				return 1 - i;
			}
		}
	}
	
	public static int hypotenuse(int x, int y){
		return sqrt(square(x) + square(y));
	}
	
	public static long hypotenuse(long x, long y){
		return sqrt(square(x) + square(y));
	}
	
	public static int hyper(int f, int a, int b){
		if(f > 3){
			int res = a;
			for(int i = 1; i < b; ++i){
				res = hyper(f - 1, a, res);
			}
			return res;
		}else if(f == 3){
			return pow(a, b);
		}else if(f == 2){
			return a*b;
		}else if(f == 1){
			return a + b;
		}else if(f == 0){
			return 1 + b;
		}else{
			return 0;
		}
	}
	
	/**
	 * Applies an hyperoperation a^^...^^b with rank f.
	 * @param f The rank of the hyperoperation (number of arrows in Knuth's up-arrow notation plus two).
	 * @param a The base of the hyperoperation.
	 * @param b The hyperexponent of the hyperoperation.
	 * @return The result of applying the hyperoperation with rank f to the base a and hyperexponent b.
	 */
	public static long hyper(long f, long a, long b){
		if(f > 3){
			long res = a;
			for(long i = 1; i < b; ++i){
				res = hyper(f - 1, a, res);
			}
			return res;
		}else if(f == 3){
			return pow(a, b);
		}else if(f == 2){
			return a*b;
		}else if(f == 1){
			return a + b;
		}else if(f == 0){
			return 1 + b;
		}else{
			return 0;
		}
	}
}
