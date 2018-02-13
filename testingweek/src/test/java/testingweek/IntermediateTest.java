package testingweek;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntermediateTest {
/*
Login Test -
Set up a test that will go to this website - http://thedemosite.co.uk – and create a user then log in as that user and assert it was successful.
*/
	private WebDriver webDriver;
	private static final String TEST_URL = "http://thedemosite.co.uk/";
	
	@BeforeClass
	public static void init() {
	}
	@Before
	public void setUp() {
		System.out.println("Before");
		webDriver = new ChromeDriver();
		webDriver.navigate().to(TEST_URL);
	}
	@Test
	public void loginTest() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement element = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)")); 
		element.click();
		WebElement userName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		userName.sendKeys("user1");
		WebElement userPassword = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		userPassword.sendKeys("password");
		WebElement saveUser = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		saveUser.click();
		WebElement login = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)")); 
		login.click();
		WebElement userNameLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
		userNameLogin.sendKeys("user1");
		WebElement userPasswordLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
		userPasswordLogin.sendKeys("password");
		WebElement loginUser = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
		loginUser.click();
		WebElement successText = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center > b"));
		Assert.assertTrue("Was not equal",successText.getText().equals("**Successful Login**"));
		
	}
	@After
	public void cleanup() {
		System.out.println("After");
		webDriver.quit();
	}
	@AfterClass
	public static void teardown() {
		System.out.println("Tear down");
	}
/*
Extent Reporting –
Incorporate into the previous exercise an implementation of Extent reports.
*/
	
/*
Input Data-
Using Apache POI incorporate a spreadsheet that has the user details and what the expected result should be into the previous exercise.
*/
	
/*
Alternate browser –
Using the spreadsheet you have created add the ability to change what browser is being used to run the test.
*/
	
/*
Mouse actions –
Using this website http://demoqa.com create a series of tests that successfully complete each tab in the side bar.

 */
}
