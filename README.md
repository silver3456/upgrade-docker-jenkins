# Testing Project

Purpose of this framework is to cover UI regression suite of Upgrade website.
Technical assignment is provided by Upgrade, Inc.


Project requirements
--------------------
[Java](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) could be downloaded here 

[Maven](https://maven.apache.org/download.cgi) of the latest version required for frontend assets generation 


[Allure](https://docs.qameta.io/allure/#_installing_a_commandline) Allure is used to generate HTML report for test build

[Selenium](https://www.seleniumhq.org/) suite of tools to automate web browsers across many platforms

[WebDriverManager](https://github.com/bonigarcia/webdrivermanager) allows to automate the management of the binary drivers

Library validation
-------------
Validate java, maven, allure is setup by command `--version`, example:

mvn --version
java -- version

Project setup/Running the tests
-------------
Project run test by maven command, like:

mvn clean test -DsuiteXmlFile=ui.xml   (for the UI tests)

mvn clean test -DsuiteXmlFile=api.xml   (for the API tests)


Report generating
-------------
Allure Report is automatically generated at target/allure-results

Report viewing
-------------

To view report run command:

allure serve target/allure-results


To install allure use this [link](https://docs.qameta.io/allure/#_installing_a_commandline)

Allure Report is automatically generated at target/allure-results

The visualization of the report
![](allure-report/graphs.png)

