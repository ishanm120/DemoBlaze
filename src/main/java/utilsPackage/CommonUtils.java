package utilsPackage;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

@SuppressWarnings("deprecation")
public class CommonUtils{
	
	public static WebDriver driver = null; 
	@SuppressWarnings("deprecation")
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();
	public static String productPrice;
	public static WebDriverWait wait;
	
	
	
	public void setUpDriverPage() {
		stepInfo("------- STARTING NEW WEB INSTANCE ------------");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait=new WebDriverWait(driver, 20);
	}
	
	@SuppressWarnings("deprecation")
	public void extentReportSetup() {
		//location of the extent report
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");
		extent = new ExtentReports();  //create object of ExtentReports
		extent.attachReporter(htmlReporter);

		htmlReporter.config().setDocumentTitle("Project Report : Demo Blaze"); // Tittle of Report
		htmlReporter.config().setReportName("Extent Report"); // Name of the report
		htmlReporter.config().setTheme(Theme.DARK);//Default Theme of Report

		// General information releated to application
		extent.setSystemInfo("Application Name", "Demo Blaze");
		extent.setSystemInfo("User Name", "Ishan Mittal");
		extent.setSystemInfo("Envirnoment", "Test Env");
	}
	
	public static void stepInfo(String message) {
	    logger.info(message);
	    test.info(message);
	}
	
	public void clearCookies() {
		stepInfo("Clear all cookies");
		driver.manage().deleteAllCookies();
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void waitForElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementNotVisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForAlertPresnet() {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForAllElementVisible(List<WebElement> lsitOfEleents) {
		wait.until(ExpectedConditions.visibilityOfAllElements(lsitOfEleents));
	}

}
