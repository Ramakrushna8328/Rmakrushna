package menuberger;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Extent1
{
	 ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("target/report.html");
	  WebDriver driver;
  
  @BeforeTest
  public void beforeTest()
  {
	  spark.config().setTheme(Theme.DARK);
	  spark.config().setDocumentTitle("MyReport");
	  extent.attachReporter(spark); 
	  driver=new ChromeDriver(); 
	  driver.get("https://jqueryui.com/checkboxradio/");
	 // driver.manage().window().maximize();
	 // driver.get("https://www.google.com");
	 // driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  
	extent.flush();  
	 driver.quit();
  }
  @Test(priority = 1)
public void Testcase1() throws InterruptedException
{
	ExtentTest test =extent.createTest("verify the pagetitle").assignAuthor("Ramakrushna")
			.assignCategory("Resting");
	test.info("i am going to capture title");
	//System.out.println(driver.manage().window().getSize());
	test.pass("Total size of the page :" +driver.manage().window().getSize());
	String pagetitle =driver.getTitle();
	test.info("pageTitle = " +pagetitle);
	Thread.sleep(3000);
	
}
  @Test()
  public void Testcase2() throws InterruptedException
  {
	  ExtentTest test1 =extent.createTest("Switch to frame and click Action").assignAuthor("Rama")
				.assignCategory("Regression Testing").assignDevice("Chrome");
	  Dimension initial_size = driver.manage().window().getSize();
		int height = initial_size.getHeight();
		int width = initial_size.getWidth();
		test1.info("height=" + initial_size);
		
		//number of  link 
		List <WebElement> linklist =driver.findElements(By.tagName("a")); 
		//System.out.println(" Total links " + linklist.size());
		test1.info(" Total links =" + linklist.size());
		for(WebElement el:linklist)
		{
		//System.out.println( el.getText());
		//	test1.pass(el.getText());
		}
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 250)");
		Thread.sleep(4000);
		test1.info("Tital of the current Page " + driver.getTitle());

		driver.switchTo().frame(0);
		test1.pass("verify page  switch to frame ");
		test1.warning("page Swiched to frame sucessfully please wait .... ");

		WebElement radiobutton = driver.findElement(By.xpath("/html/body/div/fieldset[1]/label[1]"));
		radiobutton.click();
        test1.pass("click on 1st radio button = " +radiobutton);
		WebElement button2 = driver.findElement(By.xpath("/html/body/div/fieldset[2]/label[2]"));
		test1.pass("click on 2st radio button"+button2);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("scrollBy(0, 900)");
		test1.info("Page scroll down ");
		Thread.sleep(4000);
		WebElement button3 = driver.findElement(By.xpath("/html/body/div/fieldset[3]/label[2]"));
        test1.pass("click on 3rd button"+button3);
		Actions action = new Actions(driver);
		action.moveToElement(button2).click();
		action.moveToElement(button3);
		action.click().build().perform();
         Thread.sleep(3000);
         test1.info("Test sucessfully execution ");
  }
  @Test()
  public void Testcase3() throws Exception
  {
	 
	  ExtentTest test =extent.createTest("Chapcter screenshot").assignAuthor("hari")
				.assignCategory("smoke Testing").assignDevice("Chrome");
	  
	  test.info("capture the radio button page ");
	  try {
		test.pass("capcute snapshot");
	} catch (Exception e) {
		test.fail("not capctureTHE SNAPSHOT");
		test.addScreenCaptureFromPath(Capturescreenshot(driver));

	
	}
 }

  public static String Capturescreenshot(WebDriver driver ) throws IOException 
  {
	  File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Ram\\eclipse-workspace\\menuberger\\Screenshort.png" +System.currentTimeMillis() );

		FileUtils.copyFile(f, dest);
		String destpath =dest.getAbsolutePath();
		return destpath;
		
  }

		
 
 public void Testcase4() throws Exception
{
	 
	  ExtentTest test =extent.createTest("Chapcter screenshot").assignAuthor("RAMAKRUSGNA DAS")
				.assignCategory("sanity Testing").assignDevice("Chrome");
	  test.info("capture the radio button page ");
	
	 
  
}
}