package testUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties pro;
	public ReadConfig() {
		File src =new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getWebApplicationUrl() {
		String url=pro.getProperty("baseUrl");
		return url;
	}
	
	public String getUserEmail() {
		String useremail=pro.getProperty("userEmail");
		return useremail;
	}
	
	public String getUserPassword() {
		String userpass=pro.getProperty("userPassword");
		return userpass;
	}
	
	public int implicitDurationcount() {
	    String durationString = pro.getProperty("Duration");
	    
	    // Handle the case where the property value is not a valid integer
	    try {
	        int waits = Integer.parseInt(durationString);
	        return waits;
	    } catch (NumberFormatException e) {
	       
	        e.printStackTrace(); 
	        return 0; 
	    }
	}

}
