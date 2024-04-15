package menuberger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Screenshot {

	public static void main(String[] args) throws IOException, InterruptedException
	
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/checkboxradio/");
		System.out.println("Tital of the Page " + driver.getTitle());
		Thread.sleep(3000);
		
		//get full page screenshot 
		
	/*	File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Ram\\eclipse-workspace\\menuberger\\Screenshort\\fullpage.png");
		FileUtils.copyFile(f, dest);
	*/	
		//Get a particular ScreenShot

		
		WebElement element =driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1] "));
		//element.click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("scrollBy(0, 900)");
		File src= element.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Ram\\eclipse-workspace\\menuberger\\Screenshort\\radiobutton.png");
	
		driver.close();
	}
}
