package integerMath;

//import java.util.Map;

public class DeterministicRandom{
	
	//private static Map<int[], Integer> scrambleCache;
	
	/**
	 * O(2^input.length)
	 * @param is A series of numbers to scramble. Can accept up to 30 numbers, but may be slow for such lenghts as it has O(2^n) complexity.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs.
	 */
	public static int scramble(int... is){
		int result = 0;
		for(int i = 0; i < (1 << is.length); ++i){
			int result_ = 1;
			for(int j = 0; j < is.length; ++j){
				if((i & (1 << j)) == 0){
					result_ *= Op.pow(is[j], j + 1);
				}else{
					result_ *= Op.pow(~is[j], j + 1);
				}
			}
			result ^= result_ >>> i;
		}
		return result;
	}
	
	/**
	 * O(2^input.length)
	 * @param is A series of numbers to scramble. Can accept up to 62 numbers.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs.
	 */
	public static long scramble(long... is){
		long result = 0;
		for(long i = 0; i < (1 << is.length); ++i){
			long result_ = 1;
			for(int j = 0; j < is.length; ++j){
				if((i & (1 << j)) == 0){
					result_ *= Op.pow(is[j], j + 1);
				}else{
					result_ *= Op.pow(~is[j], j + 1);
				}
			}
			result ^= result_ >>> i;
		}
		return result;
	}
	
	/**
	 * @deprecated
	 */
	public static int scramble_oldHardCodedVersion(int param_1){
		return
		(
		(( param_1) >>> 1) ^
		((~param_1))
		);
	}
	
	/**
	 * @deprecated
	 */
	public static int scramble_oldHardCodedVersion(int param_1, int param_2){
		return
		(
		(( param_1 *  param_1 *  param_2) >>> 3) ^
		(( param_1 *  param_1 * ~param_2) >>> 2) ^
		((~param_1 * ~param_1 *  param_2) >>> 1) ^
		((~param_1 * ~param_1 * ~param_2))
		);
	}
	
	/**
	 * @deprecated
	 */
	public static int scramble_oldHardCodedVersion(int param_1, int param_2, int param_3){
		return
		(
		(( param_1 *  param_1 *  param_1 *  param_2 *  param_2 *  param_3) >>> 7) ^
		(( param_1 *  param_1 *  param_1 *  param_2 *  param_2 * ~param_3) >>> 6) ^
		(( param_1 *  param_1 *  param_1 * ~param_2 * ~param_2 *  param_3) >>> 5) ^
		(( param_1 *  param_1 *  param_1 * ~param_2 * ~param_2 * ~param_3) >>> 4) ^
		((~param_1 * ~param_1 * ~param_1 *  param_2 *  param_2 *  param_3) >>> 3) ^
		((~param_1 * ~param_1 * ~param_1 *  param_2 *  param_2 * ~param_3) >>> 2) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_2 * ~param_2 *  param_3) >>> 1) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_2 * ~param_2 * ~param_3))
		);
	}
	
	/**
	 * @deprecated
	 */
	public static int scramble_oldHardCodedVersion(int param_1, int param_2, int param_3, int param_4){
		return
		(
		(( param_1 *  param_1 *  param_1 *  param_1 *  param_2 *  param_2 *  param_2 *  param_3 *  param_3 *  param_4) >>> 15) ^
		(( param_1 *  param_1 *  param_1 *  param_1 *  param_2 *  param_2 *  param_2 *  param_3 *  param_3 * ~param_4) >>> 14) ^
		(( param_1 *  param_1 *  param_1 *  param_1 *  param_2 *  param_2 *  param_2 * ~param_3 * ~param_3 *  param_4) >>> 13) ^
		(( param_1 *  param_1 *  param_1 *  param_1 *  param_2 *  param_2 *  param_2 * ~param_3 * ~param_3 * ~param_4) >>> 12) ^
		(( param_1 *  param_1 *  param_1 *  param_1 * ~param_2 * ~param_2 * ~param_2 *  param_3 *  param_3 *  param_4) >>> 11) ^
		(( param_1 *  param_1 *  param_1 *  param_1 * ~param_2 * ~param_2 * ~param_2 *  param_3 *  param_3 * ~param_4) >>> 10) ^
		(( param_1 *  param_1 *  param_1 *  param_1 * ~param_2 * ~param_2 * ~param_2 * ~param_3 * ~param_3 *  param_4) >>>  9) ^
		(( param_1 *  param_1 *  param_1 *  param_1 * ~param_2 * ~param_2 * ~param_2 * ~param_3 * ~param_3 * ~param_4) >>>  8) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 *  param_2 *  param_2 *  param_2 *  param_3 *  param_3 *  param_4) >>>  7) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 *  param_2 *  param_2 *  param_2 *  param_3 *  param_3 * ~param_4) >>>  6) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 *  param_2 *  param_2 *  param_2 * ~param_3 * ~param_3 *  param_4) >>>  5) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 *  param_2 *  param_2 *  param_2 * ~param_3 * ~param_3 * ~param_4) >>>  4) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 * ~param_2 * ~param_2 * ~param_2 *  param_3 *  param_3 *  param_4) >>>  3) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 * ~param_2 * ~param_2 * ~param_2 *  param_3 *  param_3 * ~param_4) >>>  2) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 * ~param_2 * ~param_2 * ~param_2 * ~param_3 * ~param_3 *  param_4) >>>  1) ^
		((~param_1 * ~param_1 * ~param_1 * ~param_1 * ~param_2 * ~param_2 * ~param_2 * ~param_3 * ~param_3 * ~param_4))
		);
	}
	
	/**
	 * O(input.length)
	 * @param add Amount to be added at each step. Should be nonzero.
	 * @param mod
	 * @param is A series of integers, typically a seed and indices of a sequence.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs. 
	 */
	public static int lcg(int add, int mod, int... is){
		int res = 1;
		for(int i : is){
			res *= i;
			res += add;
		}
		return res % mod;
	}
	
	/**
	 * O(input.length)
	 * @param add Amount to be added at each step. Should be nonzero.
	 * @param mod
	 * @param is A series of integers, typically a seed and indices of a sequence.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs. 
	 */
	public static long lcg(long add, long mod, long... is){
		long res = 1;
		for(long i : is){
			res *= i;
			res += add;
		}
		return res % mod;
	}
	
	/**
	 * Stands for exponential congruential generator. It's like the linear congruential generator, but instead of multiplying, the numbers are raised to an increasing prime power and summed.
	 * @param prime A starting prime number. Doesn't strictly need to be prime. It's recommended to be 5, 7, 11 or 13.
	 * @param is An array of integers.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs.
	 */
	public static int ecg(int prime, int... is){
		int res = 0;
		for(int i : is){
			res += Op.pow(i, prime);
			res += prime;
			prime = Discreet.nextPrime(prime);
		}
		return res;
	}
	
	/**
	 * Stands for exponential congruential generator. It's like the linear congruential generator, but instead of multiplying, the numbers are raised to an increasing prime power and summed.
	 * @param prime A starting prime number. Doesn't strictly need to be prime. It's recommended to be 5, 7, 11 or 13.
	 * @param is An array of integers.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs.
	 */
	public static long ecg(long prime, long... is){
		long res = 0;
		for(long i : is){
			res += Op.pow(i, prime);
			res += prime;
			prime = Discreet.nextPrime(prime);
		}
		return res;
	}
	
	/**
	 * A generalization of a modified xorshift generator to be deterministic for a determined input.
	 * @param shift What the starting shift should be for the first iteration, which will increase by one for every element of is.
	 * @param is An array of integers.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs.
	 */
	public static int xorShift(int shift, int... is){
		int res = 0;
		for(int i : is){
			if(shift % 2 == 0){
				res ^= i << shift;
			}else{
				res ^= i >>> shift;
			}
			shift++;
		}
		return res;
	}
	
	/**
	 * A generalization of a modified xorshift generator to be deterministic for a determined input.
	 * @param shift What the starting shift should be for the first iteration, which will increase by one for every element of is.
	 * @param is An array of integers.
	 * @return A deterministic pseudorandom result that will always be the same for the same inputs.
	 */
	public static long xorShift(long shift, long... is){
		long res = 0;
		for(long i : is){
			if(shift % 2 == 0){
				res ^= i << shift;
			}else{
				res ^= i >>> shift;
			}
			shift++;
		}
		return res;
	}
	
	public static boolean flipCoin(){
		return (scramble(System.currentTimeMillis()) % 2) == 0;
	}
	
	public static long rollDice(){
		return (scramble(System.currentTimeMillis()) % 6) + 1;
	}
	
	public static int[] randomDistribution(String generator, int from, int to, int seed){
		if(to > from){
			int[] res = new int[to - from];
			for(int x = from, i = 0; x < to; ++x, ++i){
				res[i] = scramble(seed, x);
			}
			return res;
		}else if(from < to){
			int[] res = new int[from - to];
			for(int x = from, i = 0; x > to; --x, ++i){
				res[i] = scramble(seed, x);
			}
			return res;
		}else{
			return new int[0];
		}
	}
	
	public static long[] randomDistribution(String generator, int from, int to, long seed){
		if(to > from){
			long[] res = new long[to - from];
			for(int x = from, i = 0; x < to; ++x, ++i){
				res[i] = scramble(seed, x);
			}
			return res;
		}else if(from < to){
			long[] res = new long[from - to];
			for(int x = from, i = 0; x > to; --x, ++i){
				res[i] = scramble(seed, x);
			}
			return res;
		}else{
			return new long[0];
		}
	}
	
	/**
	 * Gets a number of results from a generator, divides them by that number and sums them, so the result follows a gaussian distribution. Higher "iter" values create more concentrated distributions but more costly to calculate.
	 * @param generator
	 * @param iter
	 * @param from
	 * @param to
	 * @param seed
	 * @return
	 */
	public static int[] gaussDistribution(String generator, int iter, int from, int to, int seed){
		if(to > from){
			int[] res = new int[to - from];
			for(int x = from, i = 0; x < to; ++x, ++i){
				for(int it = 0; it < iter; ++it){
					res[i] += scramble(seed, ~seed^it, x)/iter;
				}
			}
			return res;
		}else if(from < to){
			int[] res = new int[from - to];
			for(int x = from, i = 0; x > to; --x, ++i){
				for(int it = 0; it < iter; ++it){
					res[i] += scramble(seed, ~seed^it, it, x)/iter;
				}
			}
			return res;
		}else{
			return new int[0];
		}
	}
	
	/**
	 * Gets a number of results from a generator, divides them by that number and sums them, so the result follows a gaussian distribution. Higher "iter" values create more concentrated distributions but more costly to calculate.
	 * @param generator
	 * @param iter
	 * @param from
	 * @param to
	 * @param seed
	 * @return
	 */
	public static long[] gaussDistribution(String generator, long iter, int from, int to, long seed){
		if(to > from){
			long[] res = new long[to - from];
			for(int x = from, i = 0; x < to; ++x, ++i){
				for(long it = 0; it < iter; ++it){
					res[i] += scramble(seed, ~seed^it, x)/iter;
				}
			}
			return res;
		}else if(from < to){
			long[] res = new long[from - to];
			for(int x = from, i = 0; x > to; --x, ++i){
				for(long it = 0; it < iter; ++it){
					res[i] += scramble(seed, ~seed^it, it, x)/iter;
				}
			}
			return res;
		}else{
			return new long[0];
		}
	}
}
