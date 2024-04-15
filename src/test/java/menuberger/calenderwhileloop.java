package menuberger;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class calenderwhileloop {

	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.makemytrip.com");

		String ActualTital = driver.getTitle();
		System.out.println("Tital of this page = " + ActualTital);
		String ExpectedTital = "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
		Assert.assertEquals(ActualTital, ExpectedTital);
        //driver.findElement(By.xpath("//*[@id=\"fromCity\"]")).click();

        //for train
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[5]/span/a/span[1]/span")).click();
		Thread.sleep(3000);

        //for 1st form
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[1]/label/span")).click();
		Thread.sleep(3000);

        //Input the city name 
		driver.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-1\"]/div/div/p[1]/span")).click();

		Thread.sleep(3000);
        //iput destination

		WebElement element = driver.findElement(
				By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/input"));
		Thread.sleep(2000);
		element.sendKeys("mumbai");
		Thread.sleep(2000);
		element.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		element.sendKeys(Keys.ENTER);
        //driver.findElement(By.xpath("//a[@class=\"primaryBtn font24 latoBold widgetSearchBtn\"]")).click();

        //click on calendar 
		driver.findElement(By.xpath("//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[3]/label/p[2]"))
				.click();
		Thread.sleep(3000);
		String Expmonth = "April 2024";
		String Expdate = "15";
		while (true)
		{// for month
			String month = driver.findElement(By.xpath(
					"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[1]/div"))
					.getText();
			if (month.equals(Expmonth))
			{
				break;
			} 
			
			else 
			{// calendar arrow
				driver.findElement(By.xpath(
						"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[1]/span[2]"))
						.click();
			}
			// Selecting date
			List<WebElement> days = driver.findElements(By.xpath(
					"//*[@id=\"top-banner\"]/div[2]/div/div/div/div[2]/div[1]/div[3]/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div[3]/div[3]/div[2]"));
			Thread.sleep(4000);
			for (WebElement element1 : days) {

				String date = element1.getText();

				if (date.equals(Expdate))

				{
					element1.click();
					Thread.sleep(3000);
					System.out.println("Test pass ");
					break;
				}
			}
		}

		driver.close();
		}
}
