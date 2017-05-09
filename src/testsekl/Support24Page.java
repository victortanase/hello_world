package testsekl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Support24Page {
	private WebDriver driver;
	
	@FindBy(how = How.CSS, using = "a.emg-fluid-logo")
	private WebElement logo;

	public Support24Page(WebDriver driver) {
		super();
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.emg-fluid-logo")));
		PageFactory.initElements(driver, this);

	}
	
	
	public HomePage returnToHome(){
		System.out.println("Support24");
		WebDriverWait wait = new WebDriverWait(driver, 30, 1000);
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		logo.click();
		return new HomePage(driver);
	}
}
