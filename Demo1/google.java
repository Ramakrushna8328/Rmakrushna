package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class google {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("deviceName","AndroidEmulator" );
		Capability.setCapability("platformname", "Android");
		Capability.setCapability("automationName", "UiAutomator2");
		Capability.setCapability("platformversion", "8");
		
		Capability.setCapability("appPackage", "com.google.android.googlequicksearchbox");
		Capability.setCapability("appActivity", "com.google.android.googlequicksearchbox.SearchActivity");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capability);
		Thread.sleep(5000);
		System.out.println("applicatrion running");
	//	driver.get("https://www.google.co.in/");
		WebElement searchbox = driver.findElement(By.id("com.android.chrome:id/search_box_text"));
		searchbox.sendKeys("Taj mahal");
		searchbox.sendKeys(Keys.RETURN);
    
	}

}
