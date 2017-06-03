package week3.day1;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LearnRotate {

	/**
	 * @param args
	 * @throws MalformedURLException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G22RC88");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		 
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		
		// find out what is the present rotation type
		ScreenOrientation orientation = driver.getOrientation();
		System.out.println("The present orientation is "+orientation);
		
		
		// change to landscape
		//driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);
		
		
		
		
		
		
		
		
		
		
		
	}

}
