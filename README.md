Coverage: 80% ish
Jira link: https://rredman.atlassian.net/jira/software/projects/HP/boards/6
Git repo : https://github.com/sgtnamder/sgtnamder_assessment
Hobby project

The project was to create a font-end back-end and db to create a list of races and populate each race with the drivers participating

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
ensure instillation of SQL

### Prerequisites
To Run this project you will need 
-- java vesrion 8/1.8 to 14 
-- MYSQL or equivelent SQL server
--Google Chrome(should work with other browsers)


What things you need to install the software and how to install them
installing MYSQL
1. Get the file from [SQL](https://dev.mysql.com/downloads/installer/)

2.Install the files ensuring that MYSQL sever and MYSQL workbench are present

3.open the command prompt and run
cd C:\Program Files\MySQL\MySQL Server 8.0\bin
then
mysqld --console --initialize
4. you should see a temp passwword at the bottom make not of this
now enter
 mysqld --console
5. oepn a new window and enter
cd C:\Program Files\MySQL\MySQL Server 8.0\bin
then
mysql -u root -p
6. enter the temp password from before
7. you should see mysql> only on the command line now
now reset your password throught entering the command:
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
paswword for sql is now root

installing java
1. get install from [java](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)
2. run install file to completion
3. jaba programe will be lacated in C:/Program Files/Java
4. in the windows menu serch for Edit the system environment variables
5. go to advanced and click on environment variables
6. in system variables create a new call JAVA_HOME, with value being C:\Program Files\Java\jdk-14.0.2
7. you should see a new JAVA_HOME variable
8. find parth and edit it, then add a new variable called %JAVA_HOME%\bin
7. to test is the java has been installed open cmmand prompt and enter java -version




### Installing

Due to this being a front-end programe type it cannot be run throught the .jar 

Instead open the project within an eclipeIDE.

Ensure that you have gooten SpringBoot from the eclipes store located in the help tab and called eclipe marketplace

From here you can run a live version through the Boot dashboard, simply click on local, then the project you want to run e.g. HobbyProject and then at the top click on start/restart button

Now open your internet browser and type http://localhost:8080/. you should see a webpage for the application


## Running the tests

Explains how to run the automated tests for this system. Broken down into which tests and what they do
before running the test ensure to switch the data in application.properties to the data in application-test.properties

### Unit Tests 

Unit Testing is where a number of tests are run on the systems code to ensure that the part is returning the correct values. 
The testing for Java project have been done using Junit and Mickto  and are located in the src/test/java/com/qa/ims and are split by DAO using Junit and controller using Mockito
some exapmle fo each test can be seen below.
To run the tests in elipcse right click on the file HobbyProject\src\test\resources the coverage then Junit

#### Mockito test example
@Test
	void testAddDriver(){
		//given
		Driver driver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
		DriverDTO driverDTO = new DriverDTO("S.Perez","Redbull",25,11,"2:13:36:410",1);
		//when
		Mockito.when(this.repo.save(driver)).thenReturn(driver);
		//then
		assertThat(this.service.addDriver(driver)).usingRecursiveComparison().isEqualTo(driverDTO);
		
		
		Mockito.verify(this.repo,Mockito.times(1)).save(driver);
	}
This tests to see if the mocked driver is added to the list and then the function addDriver will return a driverDTO

### Integration Tests 
Integration tests are used to test Post Put Get and Delete and are testing the responses from the fontend and checking that what is sent back it what is expected.

#### JUnit test example
@Test
	void testDriverCreate() throws Exception {
	Driver testDriver = new Driver("S.Perez","Redbull",25,11,"2:13:36:410",1);
	String testDriverJson = this.mapper.writeValueAsString(testDriver);
	DriverDTO savedDriver = new DriverDTO("S.Perez","Redbull",25,11,"2:13:36:410",1);
	savedDriver.setId(2);
	String SavedDriverJson = this.mapper.writeValueAsString(savedDriver);
	
	RequestBuilder mockRequest = post("/driver/add").content(testDriverJson).contentType(MediaType.APPLICATION_JSON);
	ResultMatcher checkStatus = status().isOk();
	ResultMatcher checkbody = content().json(SavedDriverJson);
	
	this.mvc.perform(mockRequest).andExpect(checkStatus).andExpect(checkbody);
	}

This tests to see if the Post works by sending a JSON request to the and checking it recives a 200 response code and if the body of the response is what is expected.

### User-acceptance Tests
to run this test you must ensure that you have the correct file destination for the chrome driver in :
System.setProperty("webdriver.chrome.driver",
				"file parth fo the chrom driver");
it should be located in \HobbyProject\src\test\resources\drivers\chrome\chromedriver.exe

Selenium Tests the front-end HTML and CSS to ensure that the feature interact correctly with the backend

to run selenium ensure that programe is running on local host 8080, or change
private static String URL = "correct url";

#### Selenium Example 
@test
public void AddRace() throws InterruptedException {
		driver.get(URL);

		WebElement target = driver.findElement(By.xpath("//*[@id=\"Name\"]"));
		target.sendKeys("Monaco");

		target = driver.findElement(By.xpath("//*[@id=\"Date\"]"));
		target.sendKeys("18/06/21");

		target = driver.findElement(By.xpath("//*[@id=\"Time\"]"));
		target.sendKeys("12.30");

		target = driver.findElement(By.xpath("//*[@id=\"createRaceForm\"]/button[2]"));
		target.click();

		Thread.sleep(500);
		target = driver.findElement(By.xpath("//*[@id=\"output\"]/div[1]/div/div[1]"));
		assertEquals("Name: Monaco, Date: 18/06/21, Time: 12.30", target.getText());
	}
This will test to see if a Race has been added using the frontend text and ensure that the response is shown on the page.

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

I used [Git](https://github.com) for versioning 


## Authors

* **Richard Redman** -[sgtnamder](https://github.com/sgtnamder)

## License
Project not lincesed 

## Acknowledgments
Thank you to Jordan Harrison and Alan Davis for help sorting out bugs and blocker issues

* Hat tip to anyone whose code was used
* Inspiration
* etc