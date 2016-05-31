package android;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class HybridApp {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AndroidDriver<WebElement> driver;
		//WebView.setWebContentsDebuggingEnabled(true);

	
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", "com.ionicframework.alpha823162");
		capabilities.setCapability("appActivity", "com.ionicframework.alpha823162.MainActivity");
		capabilities.setCapability("deviceName", "ZX1G22RC88");
		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.2:4724/wd/hub"), capabilities);

		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
			//driver.context(context);
		}
		Thread.sleep(60000);
		
		driver.findElementByXPath("//android.widget.Button[@content-desc='Sign Up ']").click();
		Thread.sleep(120000);

		contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
			if(context.contains("WEBVIEW")){
				driver.context(context);
			}
		}


		
		List<WebElement> inputs = driver.findElementsByTagName("input");
		System.out.println(inputs.size());
		for (WebElement input : inputs) {
			System.out.println(input);
		}
		
		//driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Babu");
		
		
	}


}
