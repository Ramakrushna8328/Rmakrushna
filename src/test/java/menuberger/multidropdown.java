package menuberger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class multidropdown {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
	    //driver.manage().window().maximize();
		driver.get("https://www.geodatasource.com/software/country-region-dropdown-menu-demo");
		driver.manage().window().getSize();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/form/div[1]/div/select"));
		
		//Create a object for select class 
		
		Select dropdown = new Select(element);
		//dropdown.selectByVisibleText("China");
		dropdown.selectByIndex(1);
		Thread.sleep(3000);
		List<WebElement> alloption = dropdown.getOptions() ;
		System.out.println("Total country " + alloption .size() );
		for(WebElement el : alloption)
		{	
		System.out.println(el.getText());
		
		}
		driver.close();

	}

}
