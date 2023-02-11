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
 * Execution
 * Folder Structure


********************************************************************
Introduction:

•Film Details project can be used to find the details of the film either from the IMDB or the WIKIPEDIA page. We have used it to find out the "Release Date" and "Country" of the movie.
•Currently with the help of selenium framework with Java its fetching the details of "Pushpa : The Rise" movie. The code is generalised and provides the user to change the movie name through the properties file.
•After fetching the details, the code is validating the details from the 2 urls.

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
Execution :-

1. Code will open the required url in the chrome browser.
2. Search for the required movie.
3. Mouse hover to Details tab, and fetch the movie details and then close the browser.

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
          FormatDate.java [C]
          Listeners.java [C]
          properties [C]
          Utils.java [C]
    src/test/java [F]
    test-output [F]
      Default Suite
          Default test.html
          Default test.xml
   pom.xml [x]
   testdata.properties [F] -------> Input data
   testng.xml [x] --------> TestNG Main Runner file
  
