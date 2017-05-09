package testsekl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickOnWebElement{
	  public static void main(String... args) {
	    String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
	    System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
	    WebDriver driver = new FirefoxDriver();
	    driver.get("file:///home/victor/Downloads/8850OS_Code/Chapter 3/HTML/Frames.html");

      Actions action = new Actions(driver);

      driver.switchTo().frame(0);
      WebElement txt = driver.findElement(By.name("1"));
      txt.sendKeys("I'm Frame One");

      driver.switchTo().defaultContent();

      driver.switchTo().frame(1);
      txt = driver.findElement(By.name("2"));
      txt.sendKeys("I'm Frame Two");
  }
	}
