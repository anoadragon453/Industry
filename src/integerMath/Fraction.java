package integerMath;

public class Fraction{
	
	public int numerator, denominator;
	
	public static Fraction plusInfinite = new Fraction(1, 0);
	public static Fraction minusInfinite = new Fraction(-1, 0);
	
	public Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction(int numerator){
		this.numerator = numerator;
		this.denominator = 1;
	}
	
	public int getIntValue(){
		if(denominator != 0){
			return numerator/denominator;
		}else if(numerator > 0){
			return Integer.MAX_VALUE;//Closest you can get to plusInfinite
		}else if(numerator < 0){
			return Integer.MIN_VALUE;//Closest you can get to minusInfinite
		}else{
			return 0;//0/0 indetermination
		}
	}
	
	public boolean equals(Fraction f){
		return this.numerator == f.numerator && this.denominator == f.denominator;
	}
	
	public static Fraction sum(Fraction f1, Fraction f2){
		return new Fraction(f1.numerator*f2.denominator + f1.denominator*f2.numerator, f1.denominator*f2.denominator);
	}
	
	public static Fraction mult(Fraction f1, Fraction f2){
		return new Fraction(f1.numerator*f2.numerator, f1.denominator*f2.denominator);
	}
	
	public static Fraction div(Fraction f1, Fraction f2){
		return new Fraction(f1.numerator*f2.denominator, f1.denominator*f2.numerator);
	}
	
	public void invert(){
		int n = this.numerator;
		this.numerator = this.denominator;
		this.denominator = n;
	}
	
	public static Fraction pow(Fraction f, int e){
		if(e > 1){
			return new Fraction(Op.pow(f.numerator, e), Op.pow(f.denominator, e));
		}else if(e == 1){
			return f;
		}else if(e == 0){
			return new Fraction(1, 1);
		}else if(e == -1){
			return new Fraction(f.denominator, f.numerator);
		}else{
			return new Fraction(Op.pow(f.denominator, -e), Op.pow(f.numerator, -e));
		}
	}
}
