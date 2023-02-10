package Utility;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class properties {
	static Properties prop = new Properties();
	public static String getproperties(String input) {
		File file = new File(".\\testdata.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		} if(input=="imdburl") {return prop.getProperty("imdbUrl");
		}
		if(input=="wikiurl") { return prop.getProperty("wikiUrl");
		}
		return prop.getProperty("movie"); }}