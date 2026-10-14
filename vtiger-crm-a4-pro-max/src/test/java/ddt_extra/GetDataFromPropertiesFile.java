package ddt_extra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
//		1> create the JRO of the physical file
		FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
		
//		2> load all the keys by using load()
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		3> get the value by passing key in getProperty()
		String browser = pObj.getProperty("bro");
		String username = pObj.getProperty("un");
		String password = pObj.getProperty("pwd");
		System.out.println(browser);
		System.out.println(username);
		System.out.println(password);
	}
}
