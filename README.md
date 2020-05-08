# lp-integration

This project runs the automated tests for the LP website.

 ### Prerequisites 
 
 - [JDK](https://www.oracle.com/technetwork/java/javase/downloads/index.html) 
 - [Maven](https://maven.apache.org/download.cgi)
 - All tools need to be added as environment variables, a simple example can be found [here](https://www.mkyong.com/maven/how-to-install-maven-in-windows/). 
 
 ### Running the tests
 
 The tests can be ran using:
 - an IDE, preferably [IntelliJ IDEA](https://www.jetbrains.com/idea/download), **browserName** needs to be given as parameter, example https://www.screencast.com/t/CGYCEL6bc3U
 - the command line:
    * navigate to the lp-integration directory
    * start the tests using the command: 
        ```
        mvn test -ea -Dbrowser=browserName
        ```
 - to run a specific test suite:
        ```
        mvn test -ea -Dbrowser=browserName -Dsuite=SuiteName
        ```

  Where **browserName** is **firefox** or **chrome**

  NOTE: Add **-Dwfh=true** flag if you IP is not whitelisted