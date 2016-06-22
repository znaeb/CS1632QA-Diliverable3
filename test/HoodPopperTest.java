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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class HoodPopperTest {
    
    static WebDriver driver = new HtmlUnitDriver();
	
	// Start at the home page for hoodpopper for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}

	// Given that I am on the main page
	// When I view the title
	// Then I see that it contains the word "hoodpopper"
	@Test
	public void testShowsCorrectTitle() {
		
		// Simply check that the title contains the word "hoodpopper"
		
		String title = driver.getTitle();
		assertTrue(title.contains("Hoodpopper"));
	}
	
        //story1: user wishes to test the hoodpopper's tokinization.
        // Given that I am on the main page
	// When input some code to the textBox and Tokenize
	// Then I see Properly Tokenized spaces
	@Test
	public void testTokenizeSpaces() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(0).click();
                //String page=driver.getPageSource();
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int spaces=page.split(":on_sp").length-1;
                System.out.println("spacesCount: "+spaces);
                assertTrue(spaces==10);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story1: user wishes to test the hoodpopper's tokinization.
        // Given that I am on the main page
	// When input some code to the textBox and Tokenize
	// Then I see Properly Tokenized identifiers
	@Test
	public void testTokenizeIdent() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(0).click();
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int idents=page.split(":on_ident").length-1;
                System.out.println("identCount: "+idents);
                assertTrue(idents==7);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story1: user wishes to test the hoodpopper's tokinization.
        // Given that I am on the main page
	// When input some code to the textBox and Tokenize
	// Then I see Properly Tokenized newlines
	@Test
	public void testTokenizeNewLine() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(0).click();
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int newLines=page.split(":on_nl").length-1;
                System.out.println("NewLineCount: "+newLines);
                assertTrue(newLines==3);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story1: user wishes to test the hoodpopper's tokinization.
        // Given that I am on the main page
	// When input some code to the textBox and Tokenize
	// Then I see Properly Tokenized operators
	@Test
	public void testTokenizeOperator() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(0).click();
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int operators=page.split(":on_op").length-1;
                System.out.println("operators: "+operators);
                assertTrue(operators==5); //=, =, =, +, *

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story2: user wishes to test the hoodpopper's parsing.
        // Given that I am on the main page
	// When input some code to the textBox and Parse
	// Then I see Properly Parsed identifiers
	@Test
	public void testParseIdent() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(1).click();//press parse
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int identifiers=page.split("@ident").length-1;
                System.out.println("Parse identifiers: "+identifiers);
                assertTrue(identifiers==7);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story2: user wishes to test the hoodpopper's parsing.
        // Given that I am on the main page
	// When input some code to the textBox and Parse
	// Then I see Properly Parsed integer declarations
	@Test
	public void testParseInt() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(1).click();//press parse
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int parseInts=page.split("@int").length-1; // 5, 6, 4
                System.out.println("Parse ints: "+parseInts);
                assertTrue(parseInts==3);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story2: user wishes to test the hoodpopper's parsing.
        // Given that I am on the main page
	// When input some code to the textBox and Parse
	// Then I see Properly Parsed identifiers, and equals declarations, eg. *,+,=
	@Test
	public void testParseIdentifiers() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(1).click();//press parse
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int identifiers=page.split("@ident").length-1; 
                System.out.println("Parse identifiers: "+identifiers);
                assertTrue(identifiers==7);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story2: user wishes to test the hoodpopper's parsing.
        // Given that I am on the main page
	// When input some code to the textBox and Parse
	// Then I see Properly Parsed operators (including equals declarations), eg. *,+,=
	@Test
	public void testParseOperators() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(1).click();//press parse
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int equals=page.split(":assign").length-1; 
                int times=page.split("\\*").length-1;//not sure whether a(b+c) is valid in ruby for multiplication or not 
                int minus=page.split("\\-").length-1;
                int plus=page.split("\\+").length-1;
                int devide=page.split("\\/").length-1;
                int operators=equals+times+minus+devide+plus;
                System.out.println("=: "+equals+" +: "+plus+" *: "+times+" -: "+minus+" /: "+devide);
                System.out.println("Parse operators: "+operators);
                assertTrue(operators==5);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        
        //story3: user wishes to test the hoodpopper's compiling.
        // Given that I am on the main page
	// When input some code to the textBox and compile
	// Then I see Properly compiled putstrings
	@Test
	public void testCompilePuts() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(2).click();//press compile
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                //int puts=page.split("putstring").length-1;
                int puts=page.split("opt_send").length-1;
                System.out.println("Compile puts: "+puts);
                assertTrue(puts==1);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story3: user wishes to test the hoodpopper's compiling.
        // Given that I am on the main page
	// When input some code to the textBox and compile
	// Then I see Properly compiled plusses
	@Test
	public void testCompilePlus() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(2).click();//press compile
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int plus=page.split("opt_plus").length-1;
                System.out.println("Compile plus: "+plus);
                assertTrue(plus==1);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story3: user wishes to test the hoodpopper's compiling.
        // Given that I am on the main page
	// When input some code to the textBox and compile
	// Then I see Properly compiled minuses
	@Test
	public void testCompileMinus() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a - (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(2).click();//press compile
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int minus=page.split("opt_minus").length-1;
                System.out.println("Compile minus: "+minus);
                assertTrue(minus==1);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story3: user wishes to test the hoodpopper's compiling.
        // Given that I am on the main page
	// When input some code to the textBox and compile
	// Then I see Properly compiled division operations
	@Test
	public void testCompileDivision() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b / 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(2).click();//press compile
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int devides=page.split("opt_div").length-1;
                System.out.println("Compile devides: "+devides);
                assertTrue(devides==1);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
	}
        
        //story3: user wishes to test the hoodpopper's compiling.
        // Given that I am on the main page
	// When input some code to the textBox and compile
	// Then I see Properly compiled Multiplication operations
	@Test
	public void testCompileMultiplication() {
		
            // Check for new, rising, and top links - if any of
            // these is not found, fail the test
            int line=0;
            try {
                WebElement box=driver.findElement(By.xpath("/html/body/form/p[1]/textarea"));
                line=1;
                String keysToSend="a = 5\n" +
                    "b = 6\n" +
                    "c = a + (b * 4)"
                        + "\nput c";
                box.sendKeys(keysToSend);
                line=2;
                driver.findElements(By.name("commit")).get(2).click();//press compile
                String page=driver.findElement(By.xpath("/html/body/p[1]/code")).getText();
                line=3;
                int multiplys=page.split("opt_mult").length-1;
                System.out.println("Compile multiplications: "+multiplys);
                assertTrue(multiplys==1);

            } catch (NoSuchElementException nseex) {
                System.out.println("NoElement: "+line);
                    fail();
            }
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
		
		// Enter username "meow", password "meow"
		
		driver.findElement(By.name("user")).sendKeys("meow");
		driver.findElement(By.name("passwd")).sendKeys("meow");
		
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
