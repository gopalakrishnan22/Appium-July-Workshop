package webinar;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebViewAmazon {
	private AppiumDriver driver;

	@Test
	public void setUp() throws Exception {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","071c47a40b3fa1f4");
		capabilities.setCapability("browserName", "Chrome");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		WebDriverWait wait = new WebDriverWait(driver, 30);


		driver.get("https://www.amazon.in/");

		WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-logobar-greeting")));
		signIn.click();

		WebElement eMail = wait.until(ExpectedConditions.elementToBeClickable(By.id("ap_email")));
		eMail.sendKeys("appium.testleaf@gmail.com");
		driver.findElementById("ap_password").sendKeys("appium@123");
		driver.findElementById("signInSubmit").click();
		
		WebElement loginName = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-greeting-name")));
		System.out.println(loginName.getText());
		
		driver.findElementByXPath("//*[@id='nav-search-keywords']").sendKeys("Books");
		driver.findElementByXPath("//input[@type='submit']").click();
		driver.findElementByXPath("(//img[@class='sx-product-image'])[1]").click();
		
		System.out.println(driver.findElementByXPath("//i[contains(@class,'a-star')]").getAttribute("class"));

	}



}