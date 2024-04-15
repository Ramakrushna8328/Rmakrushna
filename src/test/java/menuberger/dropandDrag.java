package menuberger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class dropandDrag {

	public static void main(String[] args) throws InterruptedException 
	{
		
		WebDriver driver = new ChromeDriver();

		// WebSocket$Listener onError
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/draggable/");
		
		System.out.println(driver.manage().window().getSize());
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 250)");
		Thread.sleep(4000);
		
		driver.switchTo().frame(0);
	    //WebElement on which drag and drop operation needs to be performed  
        WebElement from = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));  

       //WebElement to which the above object is dropped  
        WebElement to = driver.findElement(By.xpath("/html/body"));  
           
       //Creating object of Actions class to build composite actions  
        Actions act = new Actions(driver);  
           
      //Performing the drag and drop action  
        act.dragAndDrop(from,to).build().perform();   
	}

}
