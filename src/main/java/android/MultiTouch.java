package android; 
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchShortcuts;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class MultiTouch { 

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppiumDriver<?> driver;
		Dimension size;

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "071c47a40b3fa1f4");
//		capabilities.setCapability("appPackage","com.the511plus.MultiTouchTester");
//		capabilities.setCapability("appActivity",".MultiTouchTester");
		capabilities.setCapability("unicodeKeyboard", true);

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		size = driver.manage().window().getSize();
		//Get X Y Coordinates for touch action 1(Top left side).
		int x1 = (int) (size.width * 0.20);
		int y1 = (int) (size.height * 0.20);
		//Get X Y Coordinates for touch action 2(Top right side). 
		int x2 = (int) (size.width * 0.80);
		int y2 = (int) (size.height * 0.20);
		//Get X Y Coordinates for touch action 3(Bottom left side). 
		int x3 = (int) (size.width * 0.20);
		int y3 = (int) (size.height * 0.80);
		//Get X Y Coordinates for touch action 4(Bottom right side). 
		int x4 = (int) (size.width * 0.80);
		int y4 = (int) (size.height * 0.80);
		//Get X Y Coordinates for touch action 5(middle of the screen). 
		int x5 = size.width / 2;
		int y5 = size.height / 2;
		// Create object of MultiTouchAction class. 
		MultiTouchAction maction = new MultiTouchAction(driver);
/*
		//	 Set touch action1 on given X Y Coordinates of screen. 
		TouchAction action1 = new TouchAction(driver).longPress(x1, y1).waitAction(1500);
		// Set touch action2 on given X Y Coordinates of screen. 
		TouchAction action2 = new TouchAction(driver).longPress(x2, y2).waitAction(1500);
		// Set touch action3 on given X Y Coordinates of screen. 
		TouchAction action3 = new TouchAction(driver).longPress(x3, y3).waitAction(1500);
		// Set touch action4 on given X Y Coordinates of screen.
		TouchAction action4 = new TouchAction(driver).longPress(x4, y4).waitAction(1500);
		// Set touch action5 on given X Y Coordinates of screen. 
		TouchAction action5 = new TouchAction(driver).longPress(x5, y5).waitAction(1500);
		// Generate multi touch action chain using different actions and perform It. 
		maction.add(action1).add(action2).add(action3).add(action4).add(action5).perform();
	*/	
		TouchAction action6 = new TouchAction(driver).tap(x1, y1);
		TouchAction action7 = new TouchAction(driver).longPress(x4, y4).waitAction(1000);
		maction.add(action6).add(action7).perform();	

		driver.swipe(x1, y1, x4, y4, 5000);

		driver.pinch(x1, y4);
		Thread.sleep(15000);

		driver.tap(5, x1, y1, 5000);


		// Written For Swipe
		TouchAction action = new TouchAction(driver).longPress(x4,y4).moveTo(x1, y1).release().waitAction(5000);
		action.perform();	

		
		 




	}

}

