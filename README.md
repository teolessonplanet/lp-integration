# lp-integration

This project runs the automated tests for the LP website.

 ### Prerequisites 
 
 - [JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
 - [Maven](https://maven.apache.org/download.cgi)
 - [Geckodriver](https://github.com/mozilla/geckodriver/releases) - for Mozilla Firefox browser
 - [ChromeDriver](http://chromedriver.chromium.org/downloads) - for Google Chrome browser
 - All tools need to be added as environment variables, a simple example can be found [here](https://www.mkyong.com/maven/how-to-install-maven-in-windows/). 
 
 ### Running the tests
 
 The tests can be ran using:
 - an IDE, preferably [IntelliJ IDEA](https://www.jetbrains.com/idea/download)
 - the command line:
    * navigate to the lp-integration directory
    * start the tests using the command: 
        ```
        mvn test
        ```