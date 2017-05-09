package testsekl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Teste {


		  public static void main(String[] args){
		    	String marionetteDriverLocation = "/home/victor/Downloads/geckodriver";
		    	System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
		    WebDriver driver = new FirefoxDriver();
		    driver.get("http://www.google.com");
		    WebElement searchButton = driver.findElement(By.name("btnK"));
		    System.out.println(searchButton.isEnabled());
		  }
	}
