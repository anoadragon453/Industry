package integerMath;

public class Statistic {
	
	public static int min(int... is){
		int comp = Integer.MAX_VALUE;
		for(int i : is){
			if(i < comp){
				comp = i;
			}
		}
		return comp;
	}
	
	public static long min(long... is){
		long comp = Long.MAX_VALUE;
		for(long i : is){
			if(i < comp){
				comp = i;
			}
		}
		return comp;
	}
	
	public static int max(int... is){
		int comp = Integer.MIN_VALUE;
		for(int i : is){
			if(i > comp){
				comp = i;
			}
		}
		return comp;
	}
	
	public static long max(long... is){
		long comp = Long.MIN_VALUE;
		for(long i : is){
			if(i > comp){
				comp = i;
			}
		}
		return comp;
	}
	
	public static int[] min_max(int... is){
		int comp_min = Integer.MAX_VALUE;
		int comp_max = Integer.MIN_VALUE;
		for(int i : is){
			if(i < comp_min){
				comp_min = i;
			}
			if(i > comp_max){
				comp_max = i;
			}
		}
		return new int[]{comp_min, comp_max};
	}
	
	public static long[] min_max(long... is){
		long comp_min = Long.MAX_VALUE;
		long comp_max = Long.MIN_VALUE;
		for(long i : is){
			if(i < comp_min){
				comp_min = i;
			}
			if(i > comp_max){
				comp_max = i;
			}
		}
		return new long[]{comp_min, comp_max};
	}
	
	public static int[] min_max(int[]... iss){
		int comp_min = Integer.MAX_VALUE;
		int comp_max = Integer.MIN_VALUE;
		for(int[] is : iss){
			for(int i : is){
				if(i < comp_min){
					comp_min = i;
				}
				if(i > comp_max){
					comp_max = i;
				}
			}
		}
		return new int[]{comp_min, comp_max};
	}
	
	public static long[] min_max(long[]... iss){
		long comp_min = Integer.MAX_VALUE;
		long comp_max = Integer.MIN_VALUE;
		for(long[] is : iss){
			for(long i : is){
				if(i < comp_min){
					comp_min = i;
				}
				if(i > comp_max){
					comp_max = i;
				}
			}
		}
		return new long[]{comp_min, comp_max};
	}
	
	public static int[] min_max(int[][]... isss){
		int comp_min = Integer.MAX_VALUE;
		int comp_max = Integer.MIN_VALUE;
		for(int[][] iss : isss){
			for(int[] is : iss){
				for(int i : is){
					if(i < comp_min){
						comp_min = i;
					}
					if(i > comp_max){
						comp_max = i;
					}
				}
			}
		}
		return new int[]{comp_min, comp_max};
	}
	
	public static long[] min_max(long[][]... isss){
		long comp_min = Integer.MAX_VALUE;
		long comp_max = Integer.MIN_VALUE;
		for(long[][] iss : isss){
			for(long[] is : iss){
				for(long i : is){
					if(i < comp_min){
						comp_min = i;
					}
					if(i > comp_max){
						comp_max = i;
					}
				}
			}
		}
		return new long[]{comp_min, comp_max};
	}
	
	public static int range(int... is){
		int comp_min = Integer.MAX_VALUE;
		int comp_max = Integer.MIN_VALUE;
		for(int i : is){
			if(i < comp_min){
				comp_min = i;
			}
			if(i > comp_max){
				comp_max = i;
			}
		}
		return comp_max - comp_min;
	}
	
	public static long range(long... is){
		long comp_min = Long.MAX_VALUE;
		long comp_max = Long.MIN_VALUE;
		for(long i : is){
			if(i < comp_min){
				comp_min = i;
			}
			if(i > comp_max){
				comp_max = i;
			}
		}
		return comp_max - comp_min;
	}
	
	public static int sum(int... is){
		int res = 0;
		for(int i : is){
			res += i;
		}
		return res;
	}
	
	public static long sum(long... is){
		long res = 0;
		for(long i : is){
			res += i;
		}
		return res;
	}
	
	public static int sum(int[]... iss){
		int res = 0;
		for(int[] is : iss){
			for(int i : is){
				res += i;
			}
		}
		return res;
	}
	
	public static long sum(long[]... iss){
		long res = 0;
		for(long[] is : iss){
			for(long i : is){
				res += i;
			}
		}
		return res;
	}
	
	public static int product(int[]... iss){
		int res = 1;
		for(int[] is : iss){
			for(int i : is){
				res *= i;
			}
		}
		return res;
	}
	
	public static long product(long[]... iss){
		long res = 1;
		for(long[] is : iss){
			for(long i : is){
				res *= i;
			}
		}
		return res;
	}
	
	public static int product(int... is){
		int res = 1;
		for(int i : is){
			res *= i;
		}
		return res;
	}
	
	public static long product(long... is){
		long res = 1;
		for(long i : is){
			res *= i;
		}
		return res;
	}
	
	public static int mean_arithmetic(int... is){
		return sum(is) / is.length;
	}
	
	public static long mean_arithmetic(long... is){
		return sum(is) / is.length;
	}
	
	public static int mean_geometric(int... is){
		return Op.root(product(is), is.length);
	}
	
	public static long mean_geometric(long... is){
		return Op.root(product(is), is.length);
	}
	
	public static int stdev(int... is){
		int mean = mean_arithmetic(is);
		int res = 0;
		for(int i : is){
			res += Op.abs(i - mean);
		}
		return res / is.length;
	}
	
	public static long stdev(long... is){
		long mean = mean_arithmetic(is);
		long res = 0;
		for(long i : is){
			res += Op.abs(i - mean);
		}
		return res / is.length;
	}
	
}
