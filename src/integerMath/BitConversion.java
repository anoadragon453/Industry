package integerMath;

public class BitConversion {
	
	public static int _2_3(int b){
		if(b == 0b00){
			return 0b000;
		}else if(b == 0b01){
			return 0b010;
		}else if(b == 0b10){
			return 0b101;
		}else{
			return 0b111;
		}
	}
	
	public static int _3_2(int b){
		return b >>> 1;
	}
	
	public static byte _2_4(int b){
		if(b == 0b00){
			return 0b0000;
		}else if(b == 0b01){
			return 0b0101;
		}else if(b == 0b10){
			return 0b1010;
		}else{
			return 0b1111;
		}
	}
	
	public static int _4_2(int b){
		return b >>> 2;
	}
	
	public static int _2_8(int b){
		if(b == 0b00){
			return 0b00000000;
		}else if(b == 0b01){
			return 0b01010101;
		}else if(b == 0b10){
			return 0b10101010;
		}else{
			return 0b11111111;
		}
	}
	
	public static int _8_2(int b){
		return b >>> 6;
	}
	
	public static byte compress(int b){
		return (byte)(_8_2((b & 0xFF)) |
				    _8_2((b & 0xFF00) >>>  8) << 2 |
				  _8_2((b & 0xFF0000) >>> 16) << 4 |
				_8_2((b & 0xFF000000) >>> 24) << 6 );
	}
	
	public static int expand(byte b){
		return       (_2_8((b & 0b11)) |
				    _2_8((b & 0b1100) >>> 2) <<  8 |
				  _2_8((b & 0b110000) >>> 4) << 16 |
				_2_8((b & 0b11000000) >>> 6) << 24 );
	}
}