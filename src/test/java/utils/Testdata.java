package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testdata {
	
	public static String getData(String key) {
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
		
	}
	
	

}
