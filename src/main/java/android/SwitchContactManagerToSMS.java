package android;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import io.appium.java_client.DeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;

public class SwitchContactManagerToSMS {

	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException{

		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","071c47a40b3fa1f4");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("rotatable", true);
		capabilities.setCapability("appPackage", "com.android.dialer");
		capabilities.setCapability("appActivity", ".DialtactsActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}
	@Test
	public void addContact() throws InterruptedException{

		((WebElement)driver.findElements(By.className("android.view.View")).get(2)).click();		
		driver.findElement(By.id("com.android.dialer:id/floating_action_button")).click();
		Thread.sleep(5000);	
/*
		List<WebElement> textFieldsList = driver.findElements(By.className("android.widget.EditText"));
		textFieldsList.get(0).sendKeys("Android2");

		try {
			((DeviceActionShortcuts) driver).hideKeyboard();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Thread.sleep(5000);


		driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("9999999777");

		try {
			((DeviceActionShortcuts) driver).hideKeyboard();
		} catch (Exception e) {
			// TODO: handle exception
		}	

		Thread.sleep(5000);

		driver.findElement(By.xpath("//android.widget.EditText[@text='Email']")).sendKeys("Android2@example.com");

		try {
			((DeviceActionShortcuts) driver).hideKeyboard();
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Thread.sleep(5000);		

		driver.findElement(By.id("com.android.contacts:id/menu_save")).click()	;
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.android.contacts:id/header")).click();
		Thread.sleep(20000);
		
		driver.findElement(By.id("com.android.dialer:id/dialpad_floating_action_button")).click();	
		
	*/		
			
		((StartsActivity) driver).startActivity("com.android.mms",".ui.ConversationList", null, null);
		
		driver.findElement(By.id("com.android.mms:id/action_compose_new")).click();
		
		driver.findElement(By.id("com.android.mms:id/recipients_editor")).sendKeys("9597704568");
		
		driver.findElement(By.id("com.android.mms:id/embedded_text_editor")).sendKeys("Hi");
		
//		driver.findElement(By.id("com.android.mms:id/send_button_sms")).click();
		
		((StartsActivity) driver).startActivity("com.google.android.music","com.android.music.activitymanagement.TopLevelActivity", null, null);
		Thread.sleep(5000);
		driver.findElement(By.id("com.google.android.music:id/search")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("com.google.android.music:id/search_src_text")).sendKeys("Naan Aval");
		Thread.sleep(15000);
	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}