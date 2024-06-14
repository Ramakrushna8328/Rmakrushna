package Demo1;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class Allsysntax {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
	
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability("deviceName","AndroidEmulator" );
		Capabilities.setCapability("platformname", "Android");
		Capabilities.setCapability("automationName", "UiAutomator2");
		Capabilities.setCapability("platformversion", "8");
		
		Capabilities.setCapability("appPackage", "io.appium.android.apis");
		Capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capabilities);
		//or we can do by code
		String packageName="io.appium.android.apis";
		 //terminate the App
		driver.terminateApp(packageName);
		//remove the app
		driver.removeApp(packageName);
		
		if(!driver.isAppInstalled(packageName))
		{
		//install application
		driver.installApp("location where the apk present");
		}
		else
		{
			System.out.println("App already install");
		}
		//Activate the application
		driver.activateApp(packageName);
		
		System.out.println("applicatrion running please wait for the end");
		Thread.sleep(3000);
		//get the screen size 
		Dimension size= driver.manage().window().getSize();
		//scroll on web page (views is a button which need to scroll )
		WebElement element = driver.findElement (AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()"
				+ ".scrollable(true).instance(0))"
				+ ".scrollIntoView(new UiSelector().text(\"Views\"))"));
		element.click();
		//click on control button (return web element lists )
		driver.findElements(By.id("android:id/text1")).get(04).click();
		//click on text box 
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("rama");
		//dropdown 
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		Thread.sleep(3000);
		//click perform on drop and drag
		WebElement source= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement target= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		//By using Touch Action class
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();
		//or using W3Action 
		//Open Notifications panel
		driver.openNotifications ();
	   //To toggle location services ON / OFF on the device, use the following command:
		driver.toggleLocationServices ();
	
		//To toggle mobile data ON / OFF on the device, use the following command:
		driver.toggleData ();
		//To toggle WiFi ON / OFF on the device, use the following command:
		driver.toggleWifi ();
		//Toggle Airplane Mode .To toggle Airplane mode ON / OFF on the device, use the following command:
		

	}

}
