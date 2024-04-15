package TestNG;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class fbsearchname 

{
	WebDriver driver;
	
	@BeforeTest
	public void landing()
	{	
		ChromeOptions options = new ChromeOptions();
	//Add chrome switch to disable notification - "**--disable-notifications**"
	options.addArguments("--disable-notifications");
	
		driver=new ChromeDriver(options); 
		driver.manage().window().maximize();
	
	}
	@Test(priority = 1)
	public void loginfb() throws InterruptedException
	{
		
		driver.get("https://www.facebook.com");
		
		SoftAssert softassert = new SoftAssert();
		//Title assertion
		String expectedTital="Facebook – log in or sign up ";
		String  Actualtital =driver.getTitle();
		System.out.println("actual tital = "+ Actualtital);
		softassert.assertEquals(expectedTital,Actualtital,"Title is miss match" );
		
		driver.findElement(By.name("email")).sendKeys("ramakrushna@citytechcorp.com" );
		driver.findElement(By.id("pass")).sendKeys("C1tytech@123");
		driver.findElement(By.name("login")).click();
		System.out.println("Fb loging sucessfully ,Welcome to fb");
		Thread.sleep(4000);
		Actions action = new Actions(driver); 
	     WebElement inputsearch=	driver.findElement(By.xpath("//input[@placeholder='Search Facebook']"));
	       //   inputsearch.click();
	 inputsearch.sendKeys("Ramakrushna Das" ,Keys.ENTER);
	 action.moveToElement(inputsearch).click().perform();
	
	 Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 400)");
		Thread.sleep(3000);
		js.executeScript("scrollBy(0, 800)");
		Thread.sleep(3000);
		js.executeScript("scrollBy(0, 800)");
		Thread.sleep(3000);
		js.executeScript("scrollBy(0, 800)");
		Thread.sleep(3000);
		js.executeScript("scrollBy(0, 800)");
		Thread.sleep(3000);
		js.executeScript("scrollBy(0, 800)");
	 
	}	

	@AfterTest
	public void end()
	{
	     driver.close();
		 driver.quit();
	}


}
