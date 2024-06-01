package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BasePage 
{
  public static WebDriver driver;
  public static ExtentSparkReporter sparkreport;
  public static ExtentReports report;
  public static ExtentTest test;
  public static Properties prop;
  
  
  @BeforeSuite
  public void setUp()
  {
	  prop=new Properties();
	  try {
	  prop.load(new FileInputStream("src/main/java/conf/config.properties"));}catch(Exception e) {}
	  
	  sparkreport=new ExtentSparkReporter("./reports/flipkart.html");
	  sparkreport.config().setDocumentTitle("Flipkart Functional Testing");
	  sparkreport.config().setReportName("Flipkart");
	  sparkreport.config().setTheme(Theme.STANDARD);
	  
	  report=new ExtentReports();
	  report.setSystemInfo("TesterName", "vijay");
	  report.setSystemInfo("Environment","Test Env");
	  report.attachReporter(sparkreport);
	  
	  if(prop.getProperty("browser").matches("firefox"))	
	  {
	     driver=new FirefoxDriver();
	  }else if(prop.getProperty("browser").matches("chrome"))
	  {
		  driver=new ChromeDriver();
	  }
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
  }
  public void openUrl()
  {
	  driver.get(prop.getProperty("url"));
  }
  @AfterSuite
  public void closeBrowser()
  {
	  driver.quit();
	  report.flush();
  }
  
}
