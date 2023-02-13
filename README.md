# E2E_Testing
Testing code
------------------------------------------- FILM DETAILS -------------------------------------

CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Pre-requisites
 * Tools Used
 * Approach
 * Procedure for accessing
 * Steps to exceute
 * Configured Properties
 * Execution
 * Folder Structure


********************************************************************
Introduction:

• Film Details project can be used to find the details of the movie either from the IMDB or the WIKIPEDIA page. We have used it to find out the "Release Date" and "Country" of the "Pushpa : The Rise" movie.
• Currently with the help of selenium framework with Java and TestNG its fetching and asserting the details from the IMDB (https://www.imdb.com/) and WIKIPedia page (https://en.wikipedia.org/).
• The code allows the user to provide the browser and for which movie it needs to fetch the details through the properties file.
• After fetching the details, its capturing the screenshot and prints the details in an output file.

******************************************************************
Pre-requisites:

1.User should have Java along with any one of the IDE installed in his system.
2.TestNg should be installed to run the project as a testsuite and validate the html report.

*******************************************************
Frameworks & Tools Used:

			* Selenium Web Driver (Version 3.141)
			* Webdrivermanager (Version 5.3.1)
			* TestNG (Version 7.7.1)
			* Maven
			* Listeners 
			* Junit (Version 4.1)
			* Github
			
			
***********************************************************
Approach :- 
	    * Data Driven Framework
	    * Page Object Model
	   
***********************************************************
-------------------- Steps to Execute ------------------------

Execute --  testng.xml --> Right click --> Run as TestNG suite 
Execute --  MovieDetails.xml --> Right click --> Run as TestNG suite
Execute --  IMDB_Page.java --> Right click --> Run as JUnit Test
Execute --  WIKI_Page.java --> Right click --> Run as JUnit Test

****************************************************************** 
Configured Properties:

1. browser = Chrome
2. imdbUrl = https://www.imdb.com/
3. wikiUrl = https://en.wikipedia.org/
4. movie =  Pushpa: The Rise

****************************************************************** 

Execution :-

1. Code will open the required url in the chrome browser.
2. Search for the "Pushpa: The Rise" movie.
3. Mouse hover to Details tab, and fetch the movie details.
4. Capture the page screenshot as a testexecution evidence.
5. Genereate a output file with the movie details (i.e Releasedate, Country)
6. Compare the details from the different browsers.
7. Close the browser.

***************************************************************   
Folder Structure :-

[F]- Folder
[P]- Package
[PRO]- Project
[C]-Class
[f]-feature file
[p]- properties file
[x]- xml file


FilmDetails[PRO]
   src/main/java [F]
      PageObject [P]
          IMDB_Page.java [C] -------> Junit class
	        WIKI_Page.java [C] --------> Junit Class
      testNGPackage [P]
          MovieDetails [C] --------> TestNg class
      Utility [P]
      	  Driver.java [C]
          FormatDate.java [C]
          Listeners.java [C]
          properties [C]
	  Screenshot.java [C]
          Utils.java [C]  
    src/test/java [F]
    Outputdata [F]
          IMDBPAGE.properties [f]
	  WIKIPAGE.properties [f]
    Screenshot [F]
    	imdbPageScreenshot.png
	wikiPageScreenshot.png
    test-output [F]
      Default Suite
          Default test.html
          Default test.xml
   pom.xml [x]
   testdata.properties [f] -------> Input data
   testng.xml [x] --------> TestNG Main Runner file
  
