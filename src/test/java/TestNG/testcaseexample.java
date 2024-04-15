package TestNG;


import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert.*;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class testcaseexample 

{
	@Test(priority =  0)
	public void irctc() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.navigate() .to("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
		System.out.println("The Tital of the page = "+driver.getTitle() +" =this is irctc");
		Thread.sleep(4000);
		driver.close();
		driver.quit();

		//Assert.assertTrue(true);//pass
	}
@Test(priority = -1)
	public void google()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("OrangeHRM" ,Keys.ENTER);
		 String expectedTital="OrangeHRM - Google Search";
	     String  Actualtital =driver.getTitle();
		 assertEquals(expectedTital,Actualtital,"Title is miss match" );
		 driver.quit();
	}

	public void method3()
	{
		System.out.println("This is 3st method....");
		assertTrue(true);//pass
	}

	public void method4()
	{
		System.out.println("This is 4st method....");
		throw new SkipException("Skip this medthod4");//skip
	}
}
