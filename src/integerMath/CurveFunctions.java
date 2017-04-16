package integerMath;

public class CurveFunctions{
	
	public static long none(long... longs){
		return 0;
	}
	
	public static long delta(long x, long width, long height){
		if(x == 0){
			return height;
		}else{
			return 0;
		}
	}
	
	public static long delta(long x, long y, long width, long height){
		if(x == 0 && y==0){
			return height;
		}else{
			return 0;
		}
	}
	
	public static long rectangle(long x, long width, long height){
		if(x < -width){
			return 0;
		}else if(width < x){
			return 0;
		}else{
			return height;
		}
	}
	
	public static long rectangle(long x, long y, long width, long height){
		if(x < -width || width < x || y < -width || width < y){
			return 0;
		}else{
			return height;
		}
	}
	
	public static long pyramid(long x, long width, long height){
		if(x < -width){
			return 0;
		}else if(width < x){
			return 0;
		}else if (x < 0){
			return -x * height / width;
		}else{
			return x * height / width;
		}
	}
	
	public static long pyramid(long x, long y, long width, long height){
		if(x < -width || width < x || y < -width || width < y){
			return 0;
		}else if(-x*x < -y*y){
			if (y < 0){
				return -y * height / width;
			}else{
				return y * height / width;
			}
		}else{
			if (x < 0){
				return -x * height / width;
			}else{
				return x * height / width;
			}
		}
	}
	
	/**
	 * Returns the result of the function f(x) = x^4 - x^2 in the interval [-sqrt(2), sqrt(2)], stretched so the interval has a width of width*2 and its values range between 0 and height
	 * @param x The position of a point in a line over which the function is mapped
	 * @param width The width of half of the curve in the interval
	 * @param height The height of the curve in the interval
	 * @returns The height of the curve between [-a, a] with height between [0, h], at the point x
	*/
	public static long tesseractSquare(long x, long width, long height){
		if(x < -width){
			return 0;
		}else if(width < x){
			return 0;
		}else{
			return height + ((2*Op.square(x) * (2*Op.square(x) - Op.square(width*2)) * height * 4) / Op.square(Op.square(width*2)));
		}
	}
	
	public static long tesseractSquare(long x, long y, long width, long height){
		return tesseractSquare(x, width, tesseractSquare(y, width, height));
	}
	
	//- 2x^3 + 3x^2
	public static long smoothStep(long x, long width, long height){
		if(x < -width){
			return 0;
		}else if(width < x){
			return 0;
		}else if(x < 0){
			return (3*height*Op.square(x + width) - 2*height*Op.cube(x + width)/width)/(width*width);
		}else if(0 < x){
			return (3*height*Op.square(x - width) + 2*height*Op.cube(x - width)/width)/(width*width);
		}else{
			return height;
		}
	}
	
	public static long smoothStep(long x, long y, long width, long height){
		return smoothStep(x, width, smoothStep(y, width, height));
	}
	
	//6x^5 - 15x^4 + 10x^3
	//private static long smootherStep(long x, long width, long height)
	
	//- 20x^7 + 70x^6 - 84x^5 + 35x^4
	//private static long smoothestStep(long x, long width, long height)
	
}
