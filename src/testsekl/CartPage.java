package testsekl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CartPage {
	
	WebDriver driver;
	private By emptyBasketText = By.xpath("//div[contains(text(),'Cosul')]");
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}

	public boolean isCartEmpty(){
		
		//WebElement element = driver.findElement(By.cssSelector("div:contains('Cosul')"));
		WebElement element = driver.findElement(emptyBasketText);
		System.out.println("test:  "+element.getText());
		
		if(element!=null){
			return true;
		}else{
			return false;
		}
	}

    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
    	System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://www.emag.ro/cart/products?ref=cart");
        CartPage cart =new CartPage(driver);
        boolean b=cart.isCartEmpty();
        System.out.println(b);
        // Check the title of the page
        System.out.println(driver.getCurrentUrl());
        System.out.println("Page title is: " + driver.getTitle());
       
        driver.quit();

    }
}


