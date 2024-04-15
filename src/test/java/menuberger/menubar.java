package menuberger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class menubar {
	
	public static void main(String[] args) throws InterruptedException 
	{
		// System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver-win64.exe");
         WebDriver driver = new ChromeDriver();
      //  driver.get("https://google.co.in");
	    // driver.manage().window().maximize();
	     driver.get("https://www.oyorooms.com/");
	     Thread.sleep(1000);
	     String ActualTitle = driver.getTitle();
	  
	   //  driver.findElement(By.xpath(""));
	 WebElement element = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/div/div[4]/a/div/h2")); 
	 WebElement element1= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/div[2]/div/div[4]/div/a[4]"));
	Actions action = new Actions(driver);
    action.moveToElement(element);
    action.moveToElement(element1);
    action.click().build().perform();
  
  String ExpectedTitle = "OYO: India's Best Online Hotel Booking Site for Sanitized Stays";
    Assert.assertEquals(ExpectedTitle, ActualTitle);
    System.out.println("Title :" + ActualTitle);
    //price range 
//    WebElement slider1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/aside/div[2]/div[1]/div/div/div/div/span[1]/div"));
//    WebElement slider2 = driver.findElement(By.xpath("//span[@class=\"input-range__slider-container\"]//following::div[@class=\"input-range__slider\"][2]"));
//    Actions ac=new Actions(driver);
//   ac.dragAndDropBy(slider1,100,0).perform();
// Thread.sleep(3000);
//    ac.dragAndDropBy(slider2,-50,0).perform();
//    //total number of fram 
//    int frame = driver.findElements(By.tagName("iframe")).size();
//    System.out.println("Total number of fram " + frame);
    
//  WebElement el=  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/aside/div[2]/div[2]/div/div/label[1]/span"));
//  Actions ac = new Actions(driver);
//  ac.moveToElement(el);

    Thread.sleep(2000);
//    WebElement checkbox = driver .findElement(By.name(""));
//    checkbox. click();
    driver.close();

	}

}
