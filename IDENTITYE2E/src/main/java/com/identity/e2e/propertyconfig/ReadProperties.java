package com.identity.e2e.propertyconfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	private static Properties properties = null;

	public static Properties getConfigProperties() {

		if (properties == null) {
			try {
				String propertiesFilePath = new File("").getAbsolutePath() +"//src//test//resources//"+ "applicationProperties.properties";
				InputStream inputStream = new FileInputStream(propertiesFilePath);
				properties = new Properties();
				properties.load(inputStream);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return properties;
	}

	public static String getValueFromProperties(String property) {
		String specifiedProperty = null;
		try {
			Properties prop = getConfigProperties();
			specifiedProperty = prop.getProperty(property);

		} catch (Exception e) {
			specifiedProperty = null;
		}

		return specifiedProperty;
	}

	public static String getBaseUrl() {
		String baseUrl = null;
		try {
			Properties prop = getConfigProperties();
			baseUrl = prop.getProperty("baseurl");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return baseUrl;
	}

}
