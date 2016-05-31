package day4;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class OlaCab {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<WebElement> driver;
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("appPackage", "com.olacabs.customer");
		dc.setCapability("appActivity", "com.olacabs.customer.ui.SplashActivity");
		dc.setCapability("deviceName", "071c47a40b3fa1f4");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Mini']")));

		driver.findElementByXPath("//android.widget.TextView[@text='Mini']").click();
		//	WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> cars = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println(cars.size());

		driver.findElementByXPath("//android.widget.TextView[@text='Auto']").click();
		//	WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> auto = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println(auto.size());

		driver.findElementByXPath("//android.widget.TextView[@text='SUV']").click();
		//	WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.View[@content-desc='Google Map']")));
		List<WebElement> suv = driver.findElementsByXPath("//android.view.View[@content-desc='Google Map']/android.view.View");
		System.out.println(suv.size());























	}

}
