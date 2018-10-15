package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		InputStream inStream=PropertiesTest.class.getClassLoader().getResourceAsStream("test/mConnectionProperty.properties");
		Properties properties=new Properties();
		try {
			properties.load(inStream);//parameter's type is InputStream or Reader
			String serviceIP=properties.getProperty("mServiceIP");
			System.out.println("mServiceIP="+serviceIP);
			String serivcePort=properties.getProperty("mServicePort", "80");
			System.out.println("mServicePort="+serivcePort);

			String serivceError=properties.getProperty("mServiceError", "404");
			System.out.println("mServiceError="+serivceError);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
