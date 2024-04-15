package menuberger;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Exten {
	 ExtentReports extent = new ExtentReports();
	  ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Ram\\eclipse-workspace\\menuberger\\target\\extentreport.html");
  @Test(priority = 1)
  public void f1() 
  {
	 ExtentTest test= extent.createTest("Lunch Browser and Website").assignAuthor("ramakrushna")
			 .assignDevice("Chrome").assignCategory("Regression testing");
	 test.log(Status.PASS, "user lunched");
	 test.pass("user luinch verify");
   System.out.println("1st");
  }
  @Test(priority = 3)
  public void f2()
  {
	  ExtentTest test= extent.createTest("verify ").assignCategory("smoke testing");
	  test.info("login alert");
	  test.pass("user logged into app");
	  test.warning("Reset passwaed");
	  System.out.println("3st");
  }
  @Test(priority = 2)
  public void f3() 
  {
	  ExtentTest test= extent.createTest("verify reports");
	  test.skip("verify").assignCategory("Re- testing");
	  System.out.println("2st");
  }
  @Test(priority = 4)
  public void f4() 
  {
	  ExtentTest test= extent.createTest("logout");
	  test.pass("logout");
	  System.out.println("4st");
  }
  @BeforeTest
  public void beforeTest() 
  {
	
	  extent.attachReporter(spark);   
  }

  @AfterTest
  public void afterTest()
  {
	  extent.flush();//after test will be post condition
  }

}
