package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Apkinstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
	//gather desired Capabilities Create cp variable
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","AndroidEmulator" );
		capabilities.setCapability("platformname", "Android");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("app", "D:\\APPIUM.APK\\android.wdio.native.app.v1.0.8.apk");
		capabilities.setCapability("platformversion", "8");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,capabilities);
		Thread.sleep(5000);
		System.out.println("applicatrion running");
		driver.quit();
	}

}

	//capabilities.setCapability(“BROWSER_NAME”, “Android”)
	// ‘automationName=UiAutomator1’ t