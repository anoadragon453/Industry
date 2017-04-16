package integerMath;

import java.util.ArrayList;

public class Discreet {
	
	public static boolean multipleOf(int base, int factor){
		return base % factor == 0;
	}
	
	public static boolean multipleOf(long base, long factor){
		return base % factor == 0;
	}
	
	public static boolean prime(int n){
		int sqrt = Op.sqrt(n);
		int i = 2;
		while(i <= sqrt){
			if(!multipleOf(n, i)){
				i++;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean prime(long n){
		long sqrt = Op.sqrt(n);
		long i = 2;
		while(i <= sqrt){
			if(!multipleOf(n, i)){
				i++;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static int nextPrime(int i){
		++i;
		while(!prime(i)){
			++i;
		}
		return i;
	}
	
	public static long nextPrime(long i){
		++i;
		while(!prime(i)){
			++i;
		}
		return i;
	}
	
	public static int[] primeList(int end){
		int[] ar = new int[Op.abs(end)];
		if(end != 0){
			ar[0] = 1;
			int pointer = 1;
			while(pointer < ar.length){
				ar[pointer] = nextPrime(ar[pointer - 1]);
				++pointer;
			}
		}
		return ar;
	}
	
	public static long[] primeList(long end){
		long[] ar = new long[(int)Op.abs(end)];
		if(end != 0){
			ar[0] = 1;
			int pointer = 1;
			while(pointer < ar.length){
				ar[pointer] = nextPrime(ar[pointer - 1]);
				++pointer;
			}
		}
		return ar;
	}
	
	public static int[] factorList(int t){
		ArrayList<Integer> factors = new ArrayList<Integer>();
		int f = 2;
		while(f <= Op.sqrt(t)){
			if(t % f == 0){
				t /= f;
				factors.add(f);
			}else{
				++f;
			}
		}
		factors.add(t);
		return factors.stream().mapToInt(i -> i).toArray();
	}
	
	public static long[] factorList(long t){
		ArrayList<Long> factors = new ArrayList<Long>();
		long f = 2;
		while(f <= Op.sqrt(t)){
			if(t % f == 0){
				t /= f;
				factors.add(f);
			}else{
				++f;
			}
		}
		factors.add(t);
		return factors.stream().mapToLong(i -> i).toArray();
	}

	public static int gcd(int i, int j){
		if(j == 0){
			return i;
		}else{
			return gcd(j, i % j);
		}
	}
	
	public static long gcd(long i, long j){
		if(j == 0){
			return i;
		}else{
			return gcd(j, i % j);
		}
	}
}
