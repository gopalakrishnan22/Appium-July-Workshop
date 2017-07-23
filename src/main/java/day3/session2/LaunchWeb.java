package day3.session2;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LaunchWeb {


	public static void main(String[] args) throws InterruptedException, IOException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("deviceName", "ZX1G22RC88");
		dc.setCapability("browserName", "chrome");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// load the URL
		driver.get("http://www.leaforg.com/public/index.html#/admin/login");
		
		// Enter the User Name

		driver.findElementByXPath("//input[@formcontrolname='usrmail']").sendKeys("Appium")	;
		
		
		
		
		
		
		
		
		








	}

}
