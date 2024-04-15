package menuberger;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ScrollBy_radiobutton {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		// WebSocket$Listener onError
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		
		driver.get("https://jqueryui.com/checkboxradio/");
		driver.manage().window().maximize();
		// System.out.println(driver.manage().window().getSize());

		Dimension initial_size = driver.manage().window().getSize();
		int height = initial_size.getHeight();
		int width = initial_size.getWidth();
		System.out.println("height" + initial_size);
		
		//number of  link 
		List <WebElement> linklist =driver.findElements(By.tagName("a")); 
		System.out.println(" Total links " + linklist.size());
		for(WebElement el:linklist)
		{
		System.out.println( el.getText());
		}

		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 250)");
		Thread.sleep(4000);
		System.out.println("Tital of the Page " + driver.getTitle());

		driver.switchTo().frame(0);

		WebElement radiobutton = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]"));
		radiobutton.click();

		WebElement button2 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]"));

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("scrollBy(0, 900)");
		Thread.sleep(4000);
		WebElement button3 = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[2]"));

		Actions action = new Actions(driver);
		action.moveToElement(button2).click();
		action.moveToElement(button3);
		action.click().build().perform();
        Thread.sleep(3000);
        System.out.println("Test pass ");
       
		driver.close();

	}

}
