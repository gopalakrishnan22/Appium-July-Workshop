package appium;


import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class SearchContactAndCallPhone {
	
	// AndroidDriver extends AppiumDriver and that in returns extends RemoteWebDriver
	private AppiumDriver driver;

	@BeforeClass
	public void setUp() throws Exception{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();		
		capabilities.setCapability("deviceName","ZX1G22RC88");
		
		// For Nexus phone
		capabilities.setCapability("appPackage", "com.google.android.dialer");
		capabilities.setCapability("appActivity", ".extensions.GoogleDialtactsActivity");

		// pointing to the local appium server
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
	}
	
	@Test
	public void searchAndCall() throws InterruptedException{


		// For Nexus 5 and Moto X
		driver.findElement(By.id("com.android.dialer:id/search_box_start_search")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id("com.android.dialer:id/search_view")).sendKeys("Testleaf"); 
		
		Thread.sleep(5000);		
		((WebElement) driver.findElements(By.id("com.android.dialer:id/cliv_name_textview")).get(0)).click();
		
		Thread.sleep(15000);

	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}