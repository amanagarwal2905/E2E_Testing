package PageObject;

import java.io.FileNotFoundException;
import java.text.*;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class IMDB_Page {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		imdbPageDetails();
	}

	@SuppressWarnings("deprecation")
	public static String[] imdbPageDetails() throws InterruptedException, FileNotFoundException, ParseException {
		
		// ***Opening the WebDriver *****
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// ****Launching the IMDB page *****
		driver.get(properties.getproperties("imdburl"));
		driver.manage().window().maximize();

		// ****Entering the movie name in the TextField ****
		WebElement searchField = driver.findElement(Utils.imdb_searchTxt);
		searchField.sendKeys(properties.getproperties("movie"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		// *****Search with the entered movie and verify the page title***
		driver.findElement(Utils.imdb_resultSearch).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Page Title: " + driver.getTitle());
		
		
		// **** Locating the WebElement by scrolling through the page and wait until the result is visible ****
		WebElement releaseDateTab = driver.findElement(Utils.imdb_releaseDateTab);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(releaseDateTab));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", releaseDateTab);
		
		// ****Fetching the Release date and country **** 
		String releaseCountry = driver.findElement(Utils.imdb_countryTab).getText();
		String releasedate = driver.findElement(Utils.imdb_releaseDateTab).getText();
		System.out.println("IMDB movie country name : " + releaseCountry);
		System.out.println("IMDB movie release date : " + releasedate);
		
		// **** Returning the details for assertion with the other page and closing the browser***
		String date = FormatDate.formatDate(releasedate);

		Date formattedReleaseDate = new SimpleDateFormat("MMM dd, yyyy").parse(date);
		String[] details = new String[2];
		details[0] = releaseCountry;
		details[1] = formattedReleaseDate.toString();
		driver.quit();
		return details;
	}

}
