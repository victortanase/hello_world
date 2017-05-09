package testsekl;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	@FindBy(how = How.XPATH, using="//span[text() = 'Laptop, Tablete & Telefoane']")
	private WebElement catLaptopTableteTelefoane;
	
	@FindBy(how = How.XPATH, using = "//span[text() = 'PC, Periferice & Software']")
	private WebElement pcPerifericeSoftware;
	
	
	@FindBy(how = How.CSS, using = "span.megamenu-list-department__department-name")
	private List<WebElement> allCategoriesList;

	private WebDriver driver;
	//
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	Consumer <WebElement> printer = (e) ->System.out.println(e.getText());
	
	public void listAllCategoriesNames(){
		for(WebElement e: allCategoriesList){
			printer.accept(e);
		}
	}
	
	public SubMenuCategory selectCategory(Enum name){
	
		List<WebElement> categoryWeNeed = allCategoriesList.stream()
			    .filter(p -> p.getText().equals(name.toString()) ).collect(Collectors.toList());
		System.out.println(categoryWeNeed.size());
		WebElement my = categoryWeNeed.get(0);
		printer.accept(my);
		my.click();
		return new SubMenuCategory(driver);
		
	}
	
	public static void main(String [] args) throws InterruptedException{
		String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
    	System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        //driver.get("http://www.emag.ro/genti-laptop/c?ref=hp_menu_link_1_3&tree_ref=5&type=menu_tree");
        driver.get("http://www.emag.ro/");
		HomePage home = new HomePage(driver);
		home.listAllCategoriesNames();
		TipProdus tp = home
				.selectCategory(CategoryTypesEnum.LAPTOPS)
				.getSubCategoryPage(LaptopsEnum.Genti.toString());
        tp.getProductPrice("Geanta laptop ASUS Nereus");
        tp.buyProduct("Geanta laptop ASUS Nereus");
		driver.quit();
		
	}

}
