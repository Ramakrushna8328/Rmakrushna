package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class RealdeviceAPKinstall {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("deviceName","vivo 12126" );
		Capability.setCapability("platformname", "Android");
		Capability.setCapability("automationName", "UiAutomator2");
		Capability.setCapability("app", "D:\\APPIUM.APK\\android.wdio.native.app.v1.0.8.apk");
		Capability.setCapability("platformversion", "13");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capability);
		Thread.sleep(5000);
		System.out.println("applicatrion running");
		driver.quit();
	}

}
