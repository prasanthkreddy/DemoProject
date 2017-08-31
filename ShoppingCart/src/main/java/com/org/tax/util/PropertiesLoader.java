package com.org.tax.util;

import java.util.*;
import java.io.*;

/**
 * @author prasanth
 *
 * Class represents to load the properties 
 */
public class PropertiesLoader {

	private static PropertiesLoader loader = null;
	private static final String PROP_FILE = "src/main/resources/tax.properties";
	private static Properties props = null;

	public static void load() {
		try {
			FileReader reader = new FileReader(PROP_FILE);
			props = new Properties();
			props.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static PropertiesLoader getInstance() {
		if (loader == null) {
			loader = new PropertiesLoader();
			load();
		}
		return loader;
	}

	public String getValue(String key) {
		String value = "";
		if (key != null) {
			value = props.getProperty(key);
		}
		return value;
	}
}
