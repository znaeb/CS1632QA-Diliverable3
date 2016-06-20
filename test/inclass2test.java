/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 *
 * @author Benjamin
 */
public class inclass2test {
    
    static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for reddit for each test
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.reddit.com");
	}

        
	// Given that I am not logged on to Reddit
        // When I go to the front page
        // Then I should see that a search textbox appears
	@Test
	public void testHasSearchBox() {
		
		WebElement search = driver.findElement(By.id("search"));
		assertTrue(search!=null);
	}
	
        /*
	// Given that I am on the main page
	// When I view the header
	// Then I see that it contains "new", "rising", and "top" links
	@Test
	public void testHasCorrectHeaderLinks() {
		
		// Check for new, rising, and top links - if any of
		// these is not found, fail the test
		
		try {
			driver.findElement(By.linkText("new"));
			driver.findElement(By.linkText("rising"));
			driver.findElement(By.linkText("top"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	*/
        /*
	// Given that I am on the main page
	// When I view the Remember Me section
	// Then I should see that it contains the phrase "remember me"
	@Test
	public void testHasRememberMe() {
		
		// Check that there is a remember-me element
		// that contains the text "remember me"
		// If it does not exist, or text is incorrect, fail test
		
		try {
			WebElement e = driver.findElement(By.id("remember-me"));
			String elementText = e.getText();
			assertTrue(elementText.contains("remember me"));
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	*/
        /*
	// Given that I am on the main page
	// When I click on the "new" link
	// Then I should be redirected to the "new" page
	@Test
	public void testSeeNewLinks() {
		
		// find the "new" link and click on it
		// The page you go to should include "newest submissions"
		// in the title
		
		driver.findElement(By.linkText("new")).click();
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("newest submissions"));
	}
	*/
        /*
	// Given that I am on the main page
	// And I am not logged in 
	// When I try to login with an valid username and invalid password
	// Then I am given the opportunity to reset the password
	@Test
	public void testBadPasswordResetLink() {
		
		// Enter username "testUserName333", password "123456"
		
		driver.findElement(By.name("user")).sendKeys("testUserName333");
		driver.findElement(By.name("passwd")).sendKeys("123456");
		
		// Look for the submit button (in the login div) and click
		// to attempt to login 
		
		WebElement loginDiv = driver.findElement(By.id("login_login-main"));
		
		WebElement submitButton = loginDiv.findElement(By.className("btn"));
		submitButton.click();
		
		// Check that there is a link to reset password and it is visible
		
		try {
			WebElement resetPw = driver.findElement(By.linkText("reset password"));
			assertTrue(resetPw.isDisplayed());
		} catch (NoSuchElementException nseex) {
			fail();
		}
	}
	*/

}