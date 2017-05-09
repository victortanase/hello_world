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

public class SubMenuCategory {
	
	WebDriver driver;
	

	@FindBy(how = How.CSS, using="span.megamenu-item-title")
	private List<WebElement> catLaptopTableteTelefoane;
	private By menuVisible = By.cssSelector( "span.megamenu-item-title");
	
	
	public SubMenuCategory(WebDriver driver){
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(menuVisible));	
		PageFactory.initElements(driver, this);
	}
	
	public void listMenuItems(){
		for(WebElement e:catLaptopTableteTelefoane){
			System.out.println(e.getText());
		}
	}

	public TipProdus getSubCategoryPage(String categoryName) throws InterruptedException{
		
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		By gentiLaptop = By.xpath("//span[text() = 'Genti laptop']");
        wait.until(ExpectedConditions.elementToBeClickable(gentiLaptop));
        driver.findElement(gentiLaptop).click();
        Thread.sleep(5000);
		return new TipProdus(driver);
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
	        System.out.println("HERE");
	        
	        
	        //Thread.sleep(5000);
	        SubMenuCategory subcateg =new SubMenuCategory(driver);
	        subcateg.listMenuItems();
	        TipProdus tp = subcateg.getSubCategoryPage("Genti laptop");
	        tp.getProductPrice("Geanta laptop ASUS Nereus");
	        tp.buyProduct("Geanta laptop ASUS Nereus");
	        driver.quit();

	    }
}
