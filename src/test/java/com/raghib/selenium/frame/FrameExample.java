package com.raghib.selenium.frame;

/**
 * An HTML iframe is used to display a web page within a web page.
 * 
 */

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameExample extends BaseClass {
	
	public static WebDriver driver;
	public static String browserName = "chrome";
	public static String browserVersion = "116";
	
	public static String url = "https://www.w3schools.com/html/html_iframe.asp";
    
	public static void main(String[] args) {
		// Chrome Browser
		driver = BaseClass.getDriver(browserName, browserVersion);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
        
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='default.asp' and @title='W3Schools HTML Tutorial']"));

        // Switch to the frame by nameorid, index, and WebElement.
        //driver.switchTo().frame("frameElement");	//nameOrId
        //driver.switchTo().frame(0);	//index
        driver.switchTo().frame(frameElement);	//WebElement

        // Perform actions within the frame
        WebElement frameContent = driver.findElement(By.tagName("body"));
        System.out.println("Text in the frame: " + frameContent.getText());

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Perform actions outside the frame
        WebElement header = driver.findElement(By.tagName("h2"));
        System.out.println("Header text outside the frame: " + header.getText());
        
        BaseClass.quitDriver();
    }
}
