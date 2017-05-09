package testsekl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFooter {

	
	@FindBy(how = How.CSS, using= "ul li a[title='Suport 24/7']")
	private WebElement supportLink;
	private WebDriver driver;
	
	
	public PageFooter(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public Support24Page goToSupport24Page(){
		supportLink.click();
		return new Support24Page(driver);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String [] args) throws InterruptedException, IOException{
		String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
		System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
		System.setProperty("webdriver.chrome.driver", "/home/victor/Downloads/chromedriver");
		
		FirefoxProfile profile = new FirefoxProfile();
		//explicitly enable native events(this is mandatory on Linux system, since they
		//are not enabled by default
		profile.setEnableNativeEvents(true);

		WebDriver driver = new FirefoxDriver();
		//ChromeOptions chromeProfile = new ChromeOptions();
		//WebDriver driver2= new ChromeDriver(chromeProfile);
		driver.get("http://www.emag.ro/");

//		PageFooter pf = new PageFooter(driver);
//		pf.goToSupport24Page()
//		.returnToHome();
/*		Thread.sleep(5000);
		List<WebElement> anElement = driver.findElements(
				By.cssSelector("div#benefit-1 p"));
		for(WebElement e :anElement){
			System.out.println(e.getText()+e.getTagName());

		}*/
		
		
		Actions advancedActions = new Actions(driver);
		Thread.sleep(5000);	
		advancedActions.moveToElement(driver.findElement(By.xpath("//span[text() = 'PC, Periferice & Software']"))).click().perform();

		WebDriverWait wait = new WebDriverWait(driver, 3);

		try{
			Thread.sleep(3000);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert redAlert = driver.switchTo().alert();
			System.out.println("Alert is present");
			redAlert.accept();

		}catch (Exception e){
			System.out.println("Alert is not present");
			WebDriver augmentedDriver = new Augmenter().augment(driver);
			File screenshot = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
			String path = "/home/victor/Desktop" + screenshot.getName();
			FileUtils.copyFile(screenshot, new File(path));
		}
		driver.quit();
		//
		//
	}
}
