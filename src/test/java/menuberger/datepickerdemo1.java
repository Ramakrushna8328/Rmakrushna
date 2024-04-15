package menuberger;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class datepickerdemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// WebDriver driver1 = new ChromeDriver(options);
		driver.get("https://www.goindigo.in/");

		String expectedday = "20";
		String expectedmonthYear = "march 2024";
		// String expectedyr="2024";
		
		driver.switchTo().frame(0);

		// find the date picker webelement to perform click action
		Thread.sleep(3000);
		WebElement datepicker = driver.findElement(By.xpath("//input[@placeholder='Travel Dates']"));
		datepicker.click();

		// featch the month and yr in while loop

		while (true) {
			String calendermonthYear = driver
					.findElement(By.xpath(
							"//*[@id=\"travel-dates-container\"]/div[1]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]"))
					.getText();
			// String calenderyr=driver.findElement(By.xpath("")).getText();

			if (calendermonthYear.equals(expectedmonthYear)) {
				// then capture all the day
				List<WebElement> dayList = driver
						.findElements(By.xpath("//div[@class=\"react-datepicker__day react-datepicker__day--020\"]"));

				for (WebElement e : dayList) {
					String calenderday = e.getText();
					if (calenderday.equals(expectedday)) {

						e.click();
						// driver.findElement(By.xpath("")).click();
						break;
					}
				}
				break;
			} else {// next arrow of calender
				driver.findElement(By.xpath("//span[contains(text(),'Next Month')]")).click();
			}

		}

	}
}
