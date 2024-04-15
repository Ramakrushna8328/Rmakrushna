package menuberger;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getwindowhandels {

	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate() .to("https://www.irctc.co.in/nget/train-search");
	
		System.out.println(driver.manage().window().getSize());
		
		//Create a instance of ChromeOptions class
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");
		
		//driver.switchTo().alert().accept();
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("scrollBy (0, 650)");
		
	driver.findElement(By.xpath("//span[@class='allcircle circletwo']")).click();
	Set<String> handles=driver.getWindowHandles();
	Iterator it =handles.iterator();
	String parentid=(String)it.next();
	String childid=(String)it.next();
	driver.switchTo().window(childid);
	driver.findElement(By.xpath("/html/body/app-root/app-home/div[1]/div[3]/div/div/div/ul/li[3]/a/i")).click();
	
	driver.findElement(By.xpath("//div[@class='Nav-icons Lounge']")).click();
		//driver.close();
		

	}
}
	