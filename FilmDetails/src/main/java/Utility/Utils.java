package Utility;
import org.openqa.selenium.By;

public class Utils {
	
	// **** WIKI Page WebElements *****
	public static final By wiki_searchTxt = By.xpath("//input[@type='search']");
	public static final By wiki_resultSearch = By.xpath("//div[@class='cdx-search-input__input-wrapper']/div[2]/ul/li");
	public static final By wiki_releaseDateTab =By.xpath("//div[text()='Release date']//parent::th//parent::tr/td");
	public static final By wiki_countryTab = By.xpath("//th[text()='Country']//parent::tr/td");

	// **** IMDB Page WebElements *****
	public static final By imdb_searchTxt = By.xpath("//input[@type='text']");
	public static final By imdb_resultSearch = By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']/a");
	public static final By imdb_releaseDateTab =By.xpath("//a[text()='Release date']/parent::li/div");
	public static final By imdb_countryTab = By.xpath("//a[@href='/search/title/?country_of_origin=IN&ref_=tt_dt_cn']");
}

