package integerMath;

public class Complex{
	
	public int integer, imaginary;
	
	public static Complex plusi = new Complex(0, 1);
	public static Complex minusi = new Complex(0, -1);
	
	public Complex(int integer, int imaginary){
		this.integer = integer;
		this.imaginary = imaginary;
	}
	
	public boolean equals(Complex c){
		return this.integer == c.integer && this.imaginary == c.imaginary;
	}
	
	public static int abs(Complex c){
		return Op.sqrt(c.integer*c.integer + c.imaginary*c.imaginary);
	}
	
	public static Complex add(Complex c1, Complex c2){
		return new Complex(c1.integer + c2.integer, c1.imaginary + c2.imaginary);
	}
	
	public static Complex mult(Complex c1, Complex c2){
		return new Complex(
				c1.integer*c2.integer - c1.imaginary*c2.imaginary,//minus because i*i = -1
				c1.integer*c2.imaginary + c1.imaginary*c2.integer
				);
	}
	
	public static Complex conjugate(Complex c){
		return new Complex(c.integer, -c.imaginary);
	}
}
