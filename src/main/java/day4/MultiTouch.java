package day4;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class MultiTouch {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<WebElement> driver;
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability("appPackage", "com.the511plus.MultiTouchTester");
		dc.setCapability("appActivity", "com.the511plus.MultiTouchTester.MultiTouchTester");
		dc.setCapability("deviceName", "071c47a40b3fa1f4");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);

		Dimension size =driver.manage().window().getSize();
//		int x0 = (int) (size.getHeight()*0.5);
//		int y0 = (int) (size.getWidth()*0.5);
//		System.out.println(x0);
//		System.out.println(y0);


		// press at the middle
		TouchAction touchAction = new TouchAction(driver);
		
		//touchAction.press(x0, y0).perform();
		
//		touchAction
//		.press(driver.findElementById("com.the511plus.MultiTouchTester:id/points"))
//		.waitAction(3000)
//		.release()
//		.perform();
		
//		int x1 = (int) (size.getHeight()*0.2);
//		int y1 = (int) (size.getWidth()*0.2);
//		System.out.println(x1);
//		System.out.println(y1);

		// long press
//		touchAction.longPress(driver.findElementById("com.the511plus.MultiTouchTester:id/points"),3000)
		
//		.perform();
		
//		touchAction.longPress(driver.findElementById("com.the511plus.MultiTouchTester:id/points"))
//		
//		.moveTo(x1, y1).release().perform();
		
		//touchAction.tap(x1, y1).perform();
		
	
//		driver.tap(8, driver.findElementById("com.the511plus.MultiTouchTester:id/points"), 3000);
		
//		driver.swipe(x0, y0, x1, y1, 3000);
		
//		driver.pinch(x0, y1);
		
//		driver.zoom(driver.findElementById("com.the511plus.MultiTouchTester:id/points"));
		
//	System.out.println(driver.isLocked());	
//	
//	if(!driver.isLocked())
//		driver.lockScreen(5);
//	
//	
//	System.out.println(driver.isLocked());	
//	
//	Thread.sleep(5000);
//	
//	System.out.println(driver.isLocked());	
		
		driver.navigate().back();
		
//		driver.pressKeyCode(4);
		
//	System.out.println(	driver.getNetworkConnection());
//	
//	NetworkConnectionSetting nw= new NetworkConnectionSetting(1);
//	driver.setNetworkConnection(nw);
//	
//	System.out.println(	driver.getNetworkConnection());
		
//		
//		driver.openNotifications();
//		
//		Thread.sleep(3000);
//		
//		driver.pressKeyCode(3);
		
		
		driver.startActivity("com.google.android.music", "com.android.music.activitymanagement.TopLevelActivity");
		
		System.out.println(driver.getOrientation());
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		
//		driver.findElementById("com.google.android.music:id/header_more").click();
//		
//		WebElement movie = driver.scrollTo("Sethu");
//		movie .click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		





















	}

}
