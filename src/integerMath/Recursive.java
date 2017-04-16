package integerMath;

public class Recursive{
	
	public static int fibonacci(int p){
		int a = 0;
		int b = 1;
		int temp;
		int i = 1;
		while(i < p){
			temp = a;
			a = b;
			b = temp + b;
			++i;
		}
		if(p < 1){
			return 0;
		}else{
			return b;
		}
	}
	
	public static long fibonacci(long p){
		long a = 0;
		long b = 1;
		long temp;
		long i = 1;
		while(i < p){
			temp = a;
			a = b;
			b = temp + b;
			++i;
		}
		if(p < 1){
			return 0;
		}else{
			return b;
		}
	}
	
	public static int lucas(int p){
		int a = 2;
		int b = 1;
		int temp;
		int i = 1;
		while(i < p){
			temp = a;
			a = b;
			b = temp + b;
			++i;
		}
		if(p < 1){
			return 0;
		}else{
			return b;
		}
	}
	
	public static long lucas(long p){
		long a = 2;
		long b = 1;
		long temp;
		long i = 1;
		while(i < p){
			temp = a;
			a = b;
			b = temp + b;
			++i;
		}
		if(p < 1){
			return 0;
		}else{
			return b;
		}
	}
	
	public static int factorial(int n){
		int[] range = Matrix_1.range(n);
		range[0] = 1;
		return Statistic.product(range);
	}
	
	public static long factorial(long n){
		long[] range = Matrix_1.range(n);
		range[0] = 1;
		return Statistic.product(range);
	}
	
	public static int ackermann(int m, int n){
		return Op.hyper(m, 2, n + 3) - 3;
	}
	
	public static long ackermann(long m, long n){
		return Op.hyper(m, 2, n + 3) - 3;
	}
}
