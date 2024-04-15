package TestNG;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Facebook 

{
	@Test
	
	public void login()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		//driver.findElement(By.name("email")).sendKeys("ramakrus" ,Keys.ENTER);
		 
		SoftAssert softassert = new SoftAssert();
		
		 //Title assertion
		 String expectedTital="Facebook – log in or sign up ";
        String  Actualtital =driver.getTitle();
	     System.out.println("actual tital = "+ Actualtital);
	     softassert.assertEquals(expectedTital,Actualtital,"Title is miss match" );
	
		 //URL Assertion
		 String expectedURL=driver.getCurrentUrl();
	     String  ActualURL ="https://www.facebook.com/";
	     softassert. assertEquals(expectedURL,ActualURL,"url is miss match" );
		 
		 //Text Assertion
		 String expectedTEXT=driver.findElement(By.name("email")).getAttribute("value");
	     String  ActualTEXT ="";
	     softassert. assertEquals(expectedTEXT,ActualTEXT,"Text is miss match" );
		 
		 //bORDER ASSERTION
		 String expectedboarder=driver.findElement(By.name("email")).getCssValue("border");
	     String  Actualboarder ="1px solid rgb(240,40,73)";
	     softassert. assertEquals(expectedboarder,Actualboarder,"Title is miss match" );
		
		
		 //errorMessage Assertion
		 String expectemessage =driver.findElement(By.xpath("(//div[@id=\"email_container\"]/div[2])[last()]")).getText();
	     String  Actualmessage ="The email address or mobile number you entered isn't connected to an account. ";
		 assertEquals(expectemessage,Actualmessage ,"error message  is miss match" );
		 driver.quit();
		 
	}

}
