package com.qa.hobby.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {
	private WebDriver driver;
	private static String URL = "http://localhost:8080/";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\richa\\Desktop\\projects\\Hobby_project\\Hobby_project\\HobbyProject\\src\\test\\resources\\drivers\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@Test
	public void testplanner() throws InterruptedException {
		AddRace();
		UpdateRace();
		AddDriver();
		UpdateDriver();
		DeleteDriver();
		DeleteRace();
	}

	

	@After
	public void cleanup() {
		driver.quit();
	}

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

	public void UpdateRace() throws InterruptedException {
		

		WebElement target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[3]/button[2]"));
		target.click();

		Thread.sleep(500);
		target = driver.findElement(By.xpath("//*[@id=\"UName\"]"));
		target.sendKeys("London");

		target = driver.findElement(By.xpath("//*[@id=\"UDate\"]"));
		target.sendKeys("18/06/22");
		target = driver.findElement(By.xpath("//*[@id=\"UTime\"]"));
		target.sendKeys("13.30");

		target = driver.findElement(By.xpath("//*[@id=\"updateRaceForm\"]/button[2]"));
		target.click();

		Thread.sleep(500);
		target = driver.findElement(By.xpath("//*[@id=\"output\"]/div[1]/div/div[1]"));
		assertEquals("Name: London, Date: 18/06/22, Time: 13.30", target.getText());

	}

	public void AddDriver() throws InterruptedException {
		

		WebElement target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[3]/button[3]"));
		target.click();
		Thread.sleep(500);

		target = driver.findElement(By.xpath("//*[@id=\"AName\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"TeamName\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"Points\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"DriverNum\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"DTime\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"driverNum\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"Position\"]"));
		target.sendKeys("1");

		target = driver.findElement(By.xpath("//*[@id=\"createDriverForm\"]/button[2]"));
		target.click();

		Thread.sleep(500);
		target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[2]/div/button[1]"));
		assertEquals("Name: 1, Team Name: 1, Points: 1, Driver Num: 1, Time: 1, Position 1", target.getText());

	}

	public void UpdateDriver() throws InterruptedException {
		

		WebElement target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[2]/div/button[1]"));
		target.click();
		Thread.sleep(500);

		target = driver.findElement(By.xpath("//*[@id=\"UDName\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"UTeamName\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"UPoints\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"UDriverNum\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"UDTime\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"UdriverNum\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"UPosition\"]"));
		target.sendKeys("2");

		target = driver.findElement(By.xpath("//*[@id=\"updateDriverForm\"]/button[2]"));
		target.click();

		Thread.sleep(500);
		target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[2]/div/button[1]"));
		assertEquals("Name: 2, Team Name: 2, Points: 2, Driver Num: 2, Time: 2, Position 2", target.getText());

	}

	public void DeleteDriver() throws InterruptedException {

		WebElement target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[2]/div/button[2]"));
		target.click();
	}

	public void DeleteRace() throws InterruptedException {

		WebElement target = driver.findElement(By.xpath("//*[@id=\"output\"]/div/div/div[3]/button[1]"));
		target.click();
	}

}
