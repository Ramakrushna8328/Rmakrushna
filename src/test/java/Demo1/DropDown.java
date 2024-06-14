package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DropDown {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability("deviceName","AndroidEmulator" );
		Capabilities.setCapability("platformname", "Android");
		Capabilities.setCapability("automationName", "UiAutomator2");
		Capabilities.setCapability("platformversion", "8");
		
		Capabilities.setCapability("appPackage", "io.appium.android.apis");
		Capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capabilities);
		System.out.println("applicatrion running");
		Thread.sleep(3000);
		//scroll on web page 
		//String Scroll= "Views";
		WebElement element = driver.findElement (AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\"))"));
		element.click();
		Thread.sleep(3000);

		//click on control button 
		driver.findElements(By.id("android:id/text1")).get(04).click();
		//click on LightThem button 
		driver.findElements(By.id("android:id/text1")).get(0).click();
		//click on text box 
		driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("rama");
		Thread.sleep(3000);
		//click on check box 1
		driver.findElement(By.id("io.appium.android.apis:id/check1")).click();
		//radio button 
		driver.findElement(By.id("io.appium.android.apis:id/radio1")).click();
		//dropdown 
		driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		Thread.sleep(3000);
		driver.findElements(By.id("android:id/text1")).get(3).click();
		
		

	}

}
