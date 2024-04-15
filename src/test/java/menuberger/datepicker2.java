package menuberger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class datepicker2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/datepicker/");
		System.out.println("Tital of the Page " + driver.getTitle());

		String Exdate = "16";
		String ExMonth = "March";
		String Exyear = "2024";
        driver.switchTo().frame(0);
		// click to calender
		WebElement datepicker = driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		datepicker.click();
		Thread.sleep(3000);
		// Fetch the month and year in while loop
		while (true) 
		{
			String month = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();
			String Year = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();

			if (ExMonth.equals(month) && Exyear.equals(Year))
			{
				List<WebElement> days = driver.findElements(By.xpath("//table/tbody/tr/td"));

				for (WebElement e : days)
				{
					String caldate = e.getText();
					if (caldate.equals(Exdate))
					{
						e.click();
						break;
					}
				}
				break;
			}
			else 
			{
				// Calendar Arrow to forward the month
				driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();
			}	
		}
		System.out.println("test pass");
		driver.close();
	}
}

	


