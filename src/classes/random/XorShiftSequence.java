package classes.random;

public class XorShiftSequence implements Random.Sequence {
	
	public static int[][] recommendedcoeffs = new int[][]{
		new int[]{13, 17, 5},
		new int[]{12, 25, 27},
		new int[]{11, 8, 19}
	};
	
	private int[] coeffs;
	
	public XorShiftSequence(int... coeffs) {
		this.coeffs = coeffs;
	}
	
	@Override public int getNextFrom(int x) {
		for(int i = 0; i < coeffs.length; ++i) {
			if((i & 1) == 0) {
				x = xorLeftShift(x, coeffs[i]);
			} else {
				x = xorRightShift(x, coeffs[i]);
			}
		}
		return x;
	}
	
	@Override public int getPreviousFrom(int x) {
		for(int i = coeffs.length - 1; i >= 0; --i) {
			if((i & 1) == 0) {
				x = xorLeftShiftReverse(x, coeffs[i]);
			} else {
				x = xorRightShiftReverse(x, coeffs[i]);
			}
		}
		return x;
	}
	
	public static int xorLeftShift(int x, int shift) {
		return x ^= x << shift;
	}
	
	public static int xorRightShift(int x, int shift) {
		return x ^= x >>> shift;
	}
	
	public static int xorLeftShiftReverse(int x, int shift) {
		int ret = ((1 << shift) - 1);
		ret &= x;
		for(int index = 0; index < 32 - shift; ++index) {
			if(((ret & (1 << index)) != 0) ^ ((x & (1 << (shift + index))) != 0)) {
				ret |= 1 << (shift + index);
			}
		}
	    return ret;
	}
	
	public static int xorRightShiftReverse(int x, int shift) {
		int ret = -1 - ((1 << 32 - shift) - 1);
		ret &= x;
		for(int index = 0; index < 32 - shift; ++index) {
			if(((ret & (0x80000000 >>> index)) != 0) ^ ((x & (0x80000000 >>> (shift + index))) != 0)) {
				ret |= 0x80000000 >>> (shift + index);
			}
		}
	    return ret;
	}
	
	public static int xorLeftShiftReverse(int x, int shift, int width) {
		int ret = ((1 << shift) - 1);
		ret &= x;
		for(int index = 0; index < width - shift; ++index) {
			if(((ret & (1 << index)) != 0) ^ ((x & (1 << (shift + index))) != 0)) {
				ret |= 1 << (shift + index);
			}
		}
	    return ret;
	}
	
	public static int xorRightShiftReverse(int x, int shift, int width) {
		int ret = -1 - ((1 << width - shift) - 1);
		ret &= x;
		for(int index = 0; index < width - shift; ++index) {
			if(((ret & (0x80000000 >>> index)) != 0) ^ ((x & (0x80000000 >>> (shift + index))) != 0)) {
				ret |= 0x80000000 >>> (shift + index);
			}
		}
	    return ret;
	}
	
}
