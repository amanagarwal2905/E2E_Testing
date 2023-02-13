package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver launchDriver() throws IOException {
		
		String browserName = properties.getBrowserName();
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			return driver;
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			
			return driver;
	}
		else if (browserName.equalsIgnoreCase("Edge")) {
			
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			
			return driver;
}
		return null;
}
}