package testsekl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TipProdus {
	
	WebDriver driver;
	
	//private By allProducts = By.cssSelector( "div#products-holder div.product-holder-grid");
	
	
	@FindBy(how = How.CSS, using ="div#products-holder div.product-holder-grid")
	private List<WebElement> allProducts;
	
	private By productPrice = By.cssSelector( "span.money-int");
	private By productName = By.cssSelector( "div.middle-container");
	private By productBuyButton = By.cssSelector("button.add-to-cart-new");
	public By categProduse = By.xpath("//span[text() = 'Laptop, Tablete & Telefoane']");
	public By gentiLaptop = By.xpath("//span[text() = 'Genti laptop']");

	
	public TipProdus(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean buyProduct(String productToBuy) throws InterruptedException{
		
		for(WebElement e:allProducts){
			String sucht = e.findElement(productName).getText();

			if(sucht.contains(productToBuy)){
				System.out.println("Text ist: "+sucht);
				//Thread.sleep(20000);
				WebDriverWait wait = new WebDriverWait(driver, 15, 100);
				//wait.until(ExpectedConditions.visibilityOfElementLocated(productBuyButton));
				System.out.println("my test buyProd : "+ e.findElement(productBuyButton).getText());
				e.findElement(productBuyButton).click();	
				return true;
			}			
		}
		return false;
		
	}
	
	public String getProductPrice(String productToBuy){
		String Price=null;        
		for(WebElement e:allProducts){
			String sucht = e.findElement(productName).getText();

			if(sucht.contains(productToBuy)){
				System.out.println("Text ist: "+sucht);
				Price = e.findElement(productPrice).getText();
				System.out.println("my test 2:"+ Price);
				break;
			}			
		}
		return Price;
	}
	
	

	
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
    	System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        //driver.get("http://www.emag.ro/genti-laptop/c?ref=hp_menu_link_1_3&tree_ref=5&type=menu_tree");
        driver.get("http://www.emag.ro/");
        
        
        TipProdus cart =new TipProdus(driver);
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(cart.categProduse));
        driver.findElement(cart.categProduse).click();
        wait.until(ExpectedConditions.elementToBeClickable(cart.gentiLaptop));
        driver.findElement(cart.gentiLaptop).click();
        
        
        //driver.switchTo().alert().dismiss();  //not good it works for windows alert
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler); // switch to popup window
                                                    // perform operations on popup
        System.out.println("Parent: "+parentWindowHandler);
        System.out.println("Son:"+driver.getWindowHandle());
        Thread.sleep(10000);
        
        //driver.findElement(By.cssSelector("i.icon-i17-close")).click();
        driver.switchTo().window(parentWindowHandler);        
        cart.getProductPrice("Geanta laptop ASUS Nereus");
        cart.buyProduct("Geanta laptop ASUS Nereus");
        //System.out.println(b);
        // Check the title of the page
        //System.out.println(driver.getCurrentUrl());
        driver.quit();

    }

}
