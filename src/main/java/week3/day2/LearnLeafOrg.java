package week3.day2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LearnLeafOrg {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G22RC88");
		dc.setCapability("platformName", "Android");
		dc.setCapability("appPackage", "com.testleaf.leaforg");
		dc.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");
		dc.setCapability("nativeWebScreenshot", "true");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);

		System.out.println(driver.getContext());
		
		File srcFile = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./snaps/snap1.jpg"));
		
		

		Set<String> contexts = driver.getContextHandles();
		for (String context : contexts) {
			System.out.println(context);
			if(context.contains("WEBVIEW"))
				driver.context(context);

		}
		System.out.println(driver.getContext());
		
		
		driver.findElementByLinkText("Create an Account").click();		
		driver.findElementByXPath("//input[@formcontrolname='dob']").click();
				
		
		File srcFile1 = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile1, new File("./snaps/snap2.jpg"));
		
		driver.context("NATIVE_APP");		
		driver.findElementByXPath("//android.view.View[@text='2']").click();		
		driver.findElementByXPath("//android.widget.Button[@text='SET']").click();
		
		for (String context : contexts) {
			System.out.println(context);
			if(context.contains("WEBVIEW"))
				driver.context(context);
		}
		
		driver.findElementByXPath("//input[@formcontrolname='fname']").sendKeys("Babu");

				
		
		
		
		
		
		
		
		
		








	}

}
