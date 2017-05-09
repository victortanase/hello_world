package testsekl;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2Example  {
	
	
	public TipProdus retriveOfertaProduse(){
		return null;
		
	}
	
	
	
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
    	System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("http://www.emag.ro/homepage");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        
        try {  
        	WebDriverWait wait = new WebDriverWait(driver, 10);
        	wait.until(ExpectedConditions.alertIsPresent());  
        	Alert alert = driver.switchTo().alert();  
        	alert.dismiss();} 
        catch (Exception e) {  System.out.println("Alert is not available");}
        
        // Find the text input element by its name
        //WebElement element = driver.findElement(By.name("q"));
        WebElement element = driver.findElement(By.cssSelector("a[class='gtm_31vgamc']"));
        element.click();
        Thread.sleep(5000);
     
        //element = driver.findElement(By.cssSelector("span:contains('Genti')"));
       // element = driver.findElement(By.cssSelector("a[href^='/genti-laptop']>span[class='megamenu-item-title']"));
        //element = driver.findElement(By.xpath("//span[contains(text(),'Genti laptop')]"));
        //Thread.sleep(5000);
        

       // element.click();
        System.out.println(element.isSelected());
        System.out.println(element.isEnabled());
        Thread.sleep(5000);
        
        // Enter something to search for
        //element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        //element.submit();

        // Check the title of the page
        System.out.println(driver.getCurrentUrl());
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
/*        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });*/

        // Should see: "cheese! - Google Search"

        
        //Close the browser
        for (Cookie ck : driver.manage().getCookies()){
        	System.out.println(ck.getName());
        }
        
        Cookie cookie = new Cookie("NID", "67=h88c3NpCuTQABjgZF2Ix8CJHivtpYDLFk5gc1_dtEnz1aP_UugPSWGukXUPeKPXOeTKZdkcWrw-DnqjsOEGhL7sURlkhamIAxsBUWH_Hh76MQ490jfT9pdwsMkWoYJAJ");
        driver.manage().addCookie(cookie);
        System.out.println("\n\n\n\n"+driver.manage().getCookieNamed("NID"));
        
        for(int second = 0;; second++) { 
        	if (second >= 60) {    break;  }  
        	((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400)", ""); //y value '400' can be altered 
        	Thread.sleep(3000);
        }
        
        driver.close();

    }
}
