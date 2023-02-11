package PageObject;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WIKI_Page {

	public static void main(String[] args) throws InterruptedException, FileNotFoundException, ParseException {
		// TODO Auto-generated method stub
		wikiPageDetails();}

	@SuppressWarnings("deprecation")
	public static String[] wikiPageDetails() throws FileNotFoundException, ParseException, InterruptedException {
		
		
		// ***Opening the WebDriver *****
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		
		// ****Launching the IMDB page *****
		driver.get(properties.getproperties("wikiurl"));
		driver.manage().window().maximize();
		
		
		// ****Entering the movie name in the TextField ****
		WebElement textfield = driver.findElement(Utils.wiki_searchTxt);
		textfield.sendKeys(properties.getproperties("movie"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		
		// *****Search with the entered movie and verify the page title***
		driver.findElement(Utils.wiki_resultSearch).click();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		System.out.println("Page Title: " +driver.getTitle());
		WebElement releasetag = driver.findElement(Utils.wiki_releaseDateTab);
		
		
		// **** Locating the WebElement by scrolling through the page and wait until the result is visible ****
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
		wait.until(ExpectedConditions.visibilityOf(releasetag));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", releasetag);
		
		
		// ****Fetching the Release date and country ****        
		String releasedate=releasetag.getText();
		String releaseCountry=driver.findElement(Utils.wiki_countryTab).getText();
		System.out.println("WIKI movie country name : "+ releaseCountry);
		System.out.println("WIKI movie release date : "+ releasedate);
		
		
		// **** Returning the details for assertion with the other page and closing the browser***       
		String date=FormatDate.formatDate(releasedate);
		Date formattedReleaseDate=new SimpleDateFormat("dd MMM yyyy").parse(date);
		String[] details = new String[2];
		details[0]=releaseCountry;
		details[1]=formattedReleaseDate.toString();
		driver.quit();
		return details;
	}
}

