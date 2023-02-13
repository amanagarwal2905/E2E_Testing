package PageObject;

import java.io.IOException;
import java.text.*;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.*;

public class IMDB_Page {

	 
	public static void main(String[] args) throws InterruptedException, ParseException, IOException {
		
		// **** Launching the WebDriver ****
		WebDriver driver = Driver.launchDriver();
		imdbPageDetails(driver);
		driver.quit();
		
	}

	public static String[] imdbPageDetails(WebDriver driver) throws InterruptedException, ParseException, IOException {
		
		
		// ****Launching the IMDB page *****
		driver.get(properties.getURL("imdburl"));
		driver.manage().window().maximize();

		// ****Entering the movie name in the TextField ****
		WebElement searchField = driver.findElement(Utils.imdb_searchTxt);
		searchField.sendKeys(properties.getMovieName());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		// *****Search with the entered movie and verify the page title***
		driver.findElement(Utils.imdb_resultSearch).click();
		System.out.println("Page Title: " + driver.getTitle());
		
		
		// **** Locating the WebElement by scrolling through the page and wait until the result is visible ****
		WebElement releaseDateTab = driver.findElement(Utils.imdb_releaseDateTab);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", releaseDateTab);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(releaseDateTab));
		
		// **** Capturing Screenshot ****
		
		Thread.sleep(4000);
		Screenshot.captureScreenshot(driver, "imdbPageScreenshot");
		
		// ****Fetching the Release date and country **** 
		String releaseCountry = driver.findElement(Utils.imdb_countryTab).getText();
		String releasedate = driver.findElement(Utils.imdb_releaseDateTab).getText();
		System.out.println("IMDB movie country name : " + releaseCountry);
		System.out.println("IMDB movie release date : " + releasedate);
		
		properties.storePageDeatils(releasedate, releaseCountry, "IMDBPAGE");
		
		// **** Returning the details for assertion with the other page and closing the browser***
		String date = FormatDate.formatDate(releasedate);
		Date formattedReleaseDate = new SimpleDateFormat("MMM dd, yyyy").parse(date);
		String[] details = new String[2];
		details[0] = releaseCountry;
		details[1] = formattedReleaseDate.toString();

		return details;
	}

}
