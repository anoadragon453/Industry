package integerMath;

public class Plot {

	public static String plot(int[] f, int pos_steps, int neg_steps, int stepsize, char pos_padding, char pos_filler, char baseline_padding, char baseline_filler, char neg_padding, char neg_filler){
		if(pos_steps < 0 || neg_steps < 0 || stepsize < 0){
			return "Error at plotting function: Negative plotting variables.";
		}
		String s = "";
		String format;
		if(pos_steps/10 > neg_steps){
			format = "%" + Integer.toString(Integer.toString(pos_steps*stepsize).length()) + "d";
		}else{
			format = "%" + Integer.toString(Integer.toString(neg_steps*stepsize).length() + 1) + "d";
		}
		for(int j = pos_steps*stepsize; j >= stepsize; j -= stepsize){
			s += String.format(format, j) + " ";
			for(int i : f){
				if(i >= j){
					s += pos_filler;
				}else{
					s += pos_padding;
				}
			}
			s += "\n";
		}
		s += String.format(format, 0) + " ";
		for(int i : f){
			if(i == 0){
				s += baseline_filler;
			}else{
				s += baseline_padding;
			}
		}
		s += "\n";
		for(int j = -stepsize; j >= -neg_steps*stepsize; j -= stepsize){
			s += String.format(format, j) + " ";
			for(int i : f){
				if(i <= j){
					s += neg_filler;
				}else{
					s += neg_padding;
				}
			}
			s += "\n";
		}
		return s;
	}
	
	public static String plot(long[] f, long pos_steps, long neg_steps, long stepsize, char pos_padding, char pos_filler, char baseline_padding, char baseline_filler, char neg_padding, char neg_filler){
		if(pos_steps < 0 || neg_steps < 0 || stepsize < 0){
			return "Error at plotting function: Negative plotting variables.";
		}
		String s = "";
		String format;
		if(pos_steps/10 > neg_steps){
			format = "%" + Integer.toString(Long.toString(pos_steps*stepsize).length()) + "d";
		}else{
			format = "%" + Integer.toString(Long.toString(neg_steps*stepsize).length() + 1) + "d";
		}
		for(long j = pos_steps*stepsize; j >= stepsize; j -= stepsize){
			s += String.format(format, j) + " ";
			for(long i : f){
				if(i >= j){
					s += pos_filler;
				}else{
					s += pos_padding;
				}
			}
			s += "\n";
		}
		s += String.format(format, 0) + " ";
		for(long i : f){
			if(i == 0){
				s += baseline_filler;
			}else{
				s += baseline_padding;
			}
		}
		s += "\n";
		for(long j = -stepsize; j >= -neg_steps*stepsize; j -= stepsize){
			s += String.format(format, j) + " ";
			for(long i : f){
				if(i <= j){
					s += neg_filler;
				}else{
					s += neg_padding;
				}
			}
			s += "\n";
		}
		return s;
	}
	
}
