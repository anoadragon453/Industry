package types;

import java.util.Properties;

public interface Nameable {
	
	public String getType();
	
	public default String getCommonName(Properties properties) {
		String result = properties.getProperty(this.getType() + ".name");
		return result == null ? this.getType() : result;
	}
	
	public default String getCommonDescription(Properties properties) {
		String result = properties.getProperty(this.getType() + ".desc");
		return result == null ? this.getType() : result;
	}
	
}
