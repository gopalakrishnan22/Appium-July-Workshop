package day2.session3;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

public class OlaCabs {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver;
		DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("appPackage", "com.olacabs.customer");
		dc.setCapability("appActivity", "com.olacabs.customer.ui.SplashActivity");
		dc.setCapability("deviceName", "ZX1G22RC88");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		WebDriverWait wait= new WebDriverWait(driver, 100);
		
/*		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/book_a_ride")));
		driver.findElementById("com.olacabs.customer:id/book_a_ride").click();
		driver.findElementById("com.olacabs.customer:id/mobile_number").sendKeys("9578525521");
		driver.findElementById("com.olacabs.customer:id/next").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/renew_intro_close")));
		driver.findElementById("com.olacabs.customer:id/renew_intro_close").click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Mini']")));
		*/
	
		//Set TNagar Geo location

		Location loc = new Location(13.0405, 80.2337, 500); 
		driver.setLocation(loc);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Mini']")));
		
		//Find Mini cars
		driver.findElementByXPath("//android.widget.TextView[@text='Mini']").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> cars1 = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println("Mini count in TNagar location:" +cars1.size());
		
	}

}
