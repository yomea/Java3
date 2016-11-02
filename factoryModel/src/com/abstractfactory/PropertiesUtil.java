package com.abstractfactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesUtil {

	private static Properties props = null;

	static {

		props = new Properties();

		try {
			props.load(PropertiesUtil.class.getResourceAsStream("/FactoryList.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String name) {

		return props.getProperty(name);
	}

	public static void getFactoryList() {

		BufferedReader in;
		try {
			in = new BufferedReader(new InputStreamReader(
					PropertiesUtil.class.getResourceAsStream("/FactoryList.properties"), "utf-8"));

			String line = in.readLine();
			
			while (line != null) {
				line = line.substring(0, line.indexOf("="));
				System.out.println(line);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
