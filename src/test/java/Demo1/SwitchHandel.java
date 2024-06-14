package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwitchHandel {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
	
		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("deviceName","AndroidEmulator" );
		Capability.setCapability("platformname", "Android");
		Capability.setCapability("automationName", "UiAutomator2");
		Capability.setCapability("platformversion", "8");
		
		Capability.setCapability("appPackage", "io.appium.android.apis");
		Capability.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capability);
		System.out.println("applicatrion running");
		Thread.sleep(3000);
		//String Scroll= "Views";
		WebElement element = driver.findElement (AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\"))"));
		element.click();
		Thread.sleep(3000);
        //click on switches
		WebElement Element = driver.findElement (AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Switches\"))"));
		Element.click();
	
		WebElement element1 =driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
		if(element1.isSelected()==true)
		{
			System.out.println("monitor on");
		}	
		
		else
		{
			System.out.println("Monitor off");
			element1.click();
		}
		
		Thread.sleep(4000);
		driver.close();
	}

}
