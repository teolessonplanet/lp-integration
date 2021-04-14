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
        mvn test -Dbrowser=browserName
        ```

  **NOTES:**

    Mandatory flag:
      -Dbrowser={firefox,chrome}
    Optional flags:
      -Dheadless=true (to run tests in headless mode)
      -Dipwhitelisted=false (bypasses the staging username and password if the IP is not whitelisted)
      -Dffprof=true (runs with Firefox default profile (and extensions))
            Note 1: ONLY FOR DEBUGGING!!!
            Note 2: Sometimes the extensions are not active.
            For this, go to: Menu -> Addons -> Extensions -> change Enable toggle to Disable and back to Enable
      -Dserver=feature (to run on Feature server, by default Staging is set)
