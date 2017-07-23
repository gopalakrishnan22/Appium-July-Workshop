package day3.session1;

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
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

public class OlaSwipe {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<WebElement> driver;
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.olacabs.customer");
		dc.setCapability("appActivity", "com.olacabs.customer.ui.SplashActivity");
		dc.setCapability("deviceName", "TA39400OCM");
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/book_a_ride")));
		driver.findElementById("com.olacabs.customer:id/book_a_ride").click();
		driver.findElementById("com.olacabs.customer:id/mobile_number").sendKeys("9578525521");
		driver.findElementById("com.olacabs.customer:id/next").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/intro_close")));
		driver.findElementById("com.olacabs.customer:id/intro_close").click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Mini']")));


		//Find Mini cars
		driver.findElementByXPath("//android.widget.TextView[@text='Mini']").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> cars = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println("Mini count:" +cars.size());

		//Swipe horizontal
		Dimension size = driver.manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int startx = (int) (size.width * 0.80);
		int endx = (int) (size.width * 0.20);
		driver.swipe(startx, starty, endx, starty, 3000);

		//Find OutStation Cars
		driver.findElementByXPath("//android.widget.TextView[@text='Outstation']").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.olacabs.customer:id/intro_close")));
		driver.findElementById("com.olacabs.customer:id/intro_close").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> suv = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println("Outstation count:"+suv.size());

		//Swipe back
		driver.swipe(endx, starty, startx, starty, 3000);

		//Find Micro Cars
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Micro']")));
		driver.findElementByXPath("//android.widget.TextView[@text='Micro']").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> Micro = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println("Micro Count:"+Micro.size());

		//Set TNagar Geo location

		Location loc = new Location(13.0405, 80.2337, 500); 
		driver.setLocation(loc);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Mini']")));

		//Find Mini cars
		driver.findElementByXPath("//android.widget.TextView[@text='Mini']").click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> cars1 = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println("Mini cars count in TNagar location:" +cars1.size());

		Activity activity = new Activity("com.testleaf.leaforg", "com.testleaf.leaforg.MainActivity");
		driver.startActivity(activity);


	}

}
