package integerMath;

public class Quaternion{
	
	public int integer, i, j, k;
	
	public static Quaternion plusi = new Quaternion(0, 1, 0, 0);
	public static Quaternion minusi = new Quaternion(0, -1, 0, 0);
	public static Quaternion plusj = new Quaternion(0, 0, 1, 0);
	public static Quaternion minusj = new Quaternion(0, 0, -1, 0);
	public static Quaternion plusk = new Quaternion(0, 0, 0, 1);
	public static Quaternion minusk = new Quaternion(0, 0, 0, -1);
	
	public Quaternion(int integer, int i, int j, int k){
		this.integer = integer;
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	public boolean equals(Quaternion q){
		return this.integer == q.integer && this.i == q.i && this.j == q.j && this.k == q.k;
	}
	
	public static Quaternion add(Quaternion q1, Quaternion q2){
		return new Quaternion(q1.integer + q2.integer, q1.i + q2.i, q1.j + q2.j, q1.k + q2.k);
	}
	
	public static Quaternion mult(Quaternion q1, Quaternion q2){
		return new Quaternion(
				q1.integer*q2.integer - q1.i*q2.i - q1.j*q2.j - q1.k*q2.k,
				q1.integer*q2.i + q1.i*q2.integer + q1.j*q2.k - q1.k*q2.j,
				q1.integer*q2.j - q1.i*q2.k + q1.j*q2.integer + q1.k*q2.i,
				q1.integer*q2.k + q1.i*q2.j - q1.j*q2.i + q1.k*q2.integer
				);
	}
	
	public static Quaternion conjugate(Quaternion q){
		return new Quaternion(q.integer, -q.i, -q.j, -q.k);
	}
	
}
