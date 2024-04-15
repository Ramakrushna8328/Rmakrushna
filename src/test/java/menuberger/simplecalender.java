package menuberger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class simplecalender {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver .get("https://www.makemytrip.com");
		driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div/div/nav/ul/li[5]/span/a/span[1]/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='travelDate']")).click();
		//driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Mar 13 2024')]")).click();
		
String checkmonth="Apr 18 2024";
String flag="false";
while(flag=="flase")
  {
	String month= driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Apr 18 2024')]")).getText();
	if(month.equals(checkmonth))
	{
		driver.findElement(By.xpath("//div[@class=\"DayPicker-Day\"][contains(@aria-label,'Apr 18 2024')]")).click();
		flag="True";
		Thread.sleep(5000);
	}
	else {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class=\"DayPicker-NavButton DayPicker-NavButton--next\"]")).click();
	}
	System.out.println("test pass");
	driver.close();
	
	}

	}


}
