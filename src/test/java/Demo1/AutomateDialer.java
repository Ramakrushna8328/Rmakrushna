package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialer {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("deviceName","AndroidEmulator" );
		Capability.setCapability("platformname", "Android");
		Capability.setCapability("automationName", "UiAutomator2");
		Capability.setCapability("platformversion", "8");
		
		Capability.setCapability("appPackage", "com.google.android.dialer");
		Capability.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capability);
		System.out.println("Applicatrion running please wait for end");
		Thread.sleep(3000);
		
		//8328987630
		//dialer click 
		driver.findElement(By.id("com.google.android.dialer:id/floating_action_button")).click();
		//click digit 8
		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
		driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.google.android.dialer:id/five")).click();
		driver.findElement(By.id("com.google.android.dialer:id/three")).click();
		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
		driver.findElement(By.id("com.google.android.dialer:id/six")).click();
		driver.findElement(By.id("com.google.android.dialer:id/five")).click();
		driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		driver.findElement(By.id("com.google.android.dialer:id/seven")).click();
		driver.findElement(By.id("com.google.android.dialer:id/two")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.google.android.dialer:id/dialpad_floating_action_button")).click();
		Thread.sleep(6000);
		driver.findElement(By.id("com.google.android.dialer:id/incall_end_call")).click();
		System.out.println("Sucessfully connected and  ring for 5sec After End the call ");
		
		
		

	}

}
