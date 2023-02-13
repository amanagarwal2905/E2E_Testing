package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
public class properties {
	
	static Properties prop = new Properties();
	
	public static String getURL(String input) throws IOException {
		
		File file = new File(".\\testdata.properties");
		FileInputStream fileInput = new FileInputStream(file);
		prop.load(fileInput);

		if(input=="imdburl")
		  {
			return prop.getProperty("imdbUrl");
		  }
		else if(input=="wikiurl") 
			{
			return prop.getProperty("wikiUrl");
			}
		
			return null; 
		}
		
	public static String getMovieName() throws IOException 
	    {
		    return prop.getProperty("movie");
	    }
	
	public static String getBrowserName() throws IOException
		{
		   	File file = new File(".\\testdata.properties");
		   	FileInputStream fileInput = new FileInputStream(file);
		   	prop.load(fileInput);
			
		   	return prop.getProperty("browser");
	     }
	
	public static void storePageDeatils(String date, String country, String pageName) throws IOException {
		
		Properties propOutput = new Properties();	
		FileOutputStream fileOutput = new FileOutputStream(".\\Outputdata\\"+pageName+".properties");
		
		propOutput.setProperty("ReleaseDate", date);
		propOutput.setProperty("ReleaseCountry", country);
		propOutput.store(fileOutput, pageName);
	
	}
}