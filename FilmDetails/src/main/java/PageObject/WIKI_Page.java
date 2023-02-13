package PageObject;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.*;

public class WIKI_Page {

	public static void main(String[] args) throws InterruptedException, ParseException, IOException 
	{
		// **** Launching the WebDriver ****
		WebDriver driver = Driver.launchDriver();
		wikiPageDetails(driver);
		driver.quit();
	}

	
	public static String[] wikiPageDetails(WebDriver driver) throws ParseException, InterruptedException, IOException {
		
		
		// ****Launching the IMDB page *****
		driver.get(properties.getURL("wikiurl"));
		driver.manage().window().maximize();
		
		
		// ****Entering the movie name in the TextField ****
		WebElement textfield = driver.findElement(Utils.wiki_searchTxt);
		textfield.sendKeys(properties.getMovieName());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		// *****Search with the entered movie and verify the page title***
		driver.findElement(Utils.wiki_resultSearch).click();
		System.out.println("Page Title: " +driver.getTitle());
		WebElement releasetag = driver.findElement(Utils.wiki_releaseDateTab);
		
		
		// **** Locating the WebElement by scrolling through the page and wait until the result is visible ****
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", releasetag);
		WebDriverWait wait = new WebDriverWait(driver,10); 
		wait.until(ExpectedConditions.visibilityOf(releasetag));
		
		// **** Capturing Screenshot ****
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Screenshot.captureScreenshot(driver, "wikiPageScreenshot");
				
		
		// ****Fetching the Release date and country ****        
		String releasedate=releasetag.getText();
		String releaseCountry=driver.findElement(Utils.wiki_countryTab).getText();
		System.out.println("WIKI movie country name : "+ releaseCountry);
		System.out.println("WIKI movie release date : "+ releasedate);
		
		properties.storePageDeatils(releasedate, releaseCountry, "WIKIPAGE");
		
		
		// **** Returning the details for assertion with the other page and closing the browser***       
		String date=FormatDate.formatDate(releasedate);
		Date formattedReleaseDate=new SimpleDateFormat("dd MMM yyyy").parse(date);
		String[] details = new String[2];
		details[0]=releaseCountry;
		details[1]=formattedReleaseDate.toString();
	
		return details;
	}
}

