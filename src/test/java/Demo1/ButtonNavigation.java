package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class ButtonNavigation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities Capabilities = new DesiredCapabilities();
		Capabilities.setCapability("deviceName","AndroidEmulator" );
		Capabilities.setCapability("platformname", "Android");
		Capabilities.setCapability("automationName", "UiAutomator2");
		Capabilities.setCapability("platformversion", "8.1");
		
		Capabilities.setCapability("appPackage", "io.appium.android.apis");
		Capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capabilities);
		Thread.sleep(5000);
		System.out.println("applicatrion running");
		//click on view button 
				driver.findElements(By.id("android:id/text1")).get(5).click();
				Thread.sleep(3000);
				//click on control button 
				driver.findElements(By.id("android:id/text1")).get(0).click();
				//driver.findElements(By.id("android:id/text1")).get(1).click();
				
			driver.close();	
 
	}

}
