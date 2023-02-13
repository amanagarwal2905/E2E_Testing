package testNGPackage;

import java.io.IOException;
import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObject.IMDB_Page;
import PageObject.WIKI_Page;
import Utility.Driver;

@Listeners (Utility.ListenerClass.class)

public class MovieDetails{
	
	String imdbReleaseDate;
	String imdbReleaseCountry;
	String wikiReleaseDate;
	String wikiReleaseCountry;
	WebDriver driver;

	@BeforeMethod()
	public void launchingBrowser() throws IOException {
		driver = Driver.launchDriver();
	}
	
	@Test(priority=0)
	public void imdbFilmDetails() throws InterruptedException, ParseException, IOException {
		
		// ***** Fetch the movie details from the IMDB page *****
		String[] imdb = IMDB_Page.imdbPageDetails(driver);
		imdbReleaseDate=imdb[0];
		imdbReleaseCountry=imdb[1];
	}

	@Test(priority=1)
	public void wikiFilmDetails() throws ParseException, InterruptedException, IOException {
		
		// ***** Fetch the movie details from the WIKI page *****
		String[] wiki=WIKI_Page.wikiPageDetails(driver);
		wikiReleaseDate=wiki[0];
		wikiReleaseCountry=wiki[1];}

	@Test(priority=2)
	public void validate_IMDB_WIKI_FilmDetails() throws InterruptedException {
		
		// ****** Validate the details fetched from the different web pages
		Assert.assertEquals(imdbReleaseDate, wikiReleaseDate);
		Assert.assertEquals(imdbReleaseCountry,wikiReleaseCountry);
	}
	
	@AfterMethod()
	public void quitBrowser() {
		driver.quit();
	}
}
