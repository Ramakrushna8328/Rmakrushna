package Demo1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
public class DropandDrag {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities Capability = new DesiredCapabilities();
		Capability.setCapability("deviceName","AndroidEmulator" );
		Capability.setCapability("platformname", "Android");
		Capability.setCapability("automationName", "UiAutomator2");
		Capability.setCapability("platformversion", "8");
		
		Capability.setCapability("appPackage", "io.appium.android.apis");
		Capability.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		URL url=URI.create("http://127.0.0.1:4723/").toURL();
		AndroidDriver driver = new AndroidDriver(url,Capability);
		System.out.println("applicatrion running please wait for the end ");
		//driver.findElements(By.id("android:id/text1")).get(0).click();
		Thread.sleep(3000);
		//scroll on web page 
		//String Scroll= "Views";
		WebElement element1 = driver.findElement (AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Views\"))"));
		element1.click();
		Thread.sleep(3000);
		//drag and drop
		//driver.findElements(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).get(7).click();
		 driver.findElement (AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"Drag and Drop\"))")).click();
		
		//click perform
		WebElement source= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		WebElement target= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_2"));
		//By using Touch Action class
		TouchAction action = new TouchAction(driver);
		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(target)).release().perform();
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
