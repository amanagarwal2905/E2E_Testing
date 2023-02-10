package testNGPackage;

import java.io.FileNotFoundException;
import java.text.ParseException;
import org.testng.Assert;
import org.testng.annotations.*;
import PageObject.IMDB_Page;
import PageObject.WIKI_Page;

@Listeners (Utility.ListenerClass.class)
public class MovieDetails{
	String imdbReleaseDate;
	String imdbReleaseCountry;
	String wikiReleaseDate;
	String wikiReleaseCountry;

	@Test(priority=0)
	public void imdbFilmDetails() throws InterruptedException, FileNotFoundException, ParseException {
		
		// ***** Fetch the movie details from the IMDB page *****
		String[] imdb = IMDB_Page.imdbPageDetails();
		imdbReleaseDate=imdb[0];
		imdbReleaseCountry=imdb[1];
	}

	@Test(priority=1)
	public void wikiFilmDetails() throws FileNotFoundException, ParseException, InterruptedException {
		
		// ***** Fetch the movie details from the WIKI page *****
		String[] wiki=WIKI_Page.wikiPageDetails();
		wikiReleaseDate=wiki[0];
		wikiReleaseCountry=wiki[1];}

	@Test(priority=2)
	public void validate_IMDB_WIKI_FilmDetails() throws InterruptedException {
		
		// ****** Validate the details fetched from the different web pages
		Assert.assertEquals(imdbReleaseDate, wikiReleaseDate);
		Assert.assertEquals(imdbReleaseCountry,wikiReleaseCountry);
	}
}
