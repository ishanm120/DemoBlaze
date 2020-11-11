package baseTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import cucumber.api.Scenario;
import utilsPackage.CommonUtils;

public class BaseUtils extends CommonUtils {
	public static Properties properties;
	public static String propertiesFilePath = "/src/test/resources/configuration.properties";

	public BaseUtils() {
		try {
			readPropertiesFile(System.getProperty("user.dir") + propertiesFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void setUpDriver(Scenario scenario) {
		extentReportSetup();
		test = extent.createTest(scenario.getName());
		setUpDriverPage();
		stepInfo("<-------START TEST CASE :  " + scenario.getName() + " ----------->");
	}

	public void tearDown(Scenario scenario) throws Exception {
		if (scenario.isFailed()) {
			stepInfo("-------Test Case with name " + scenario.getName() + " is [ FAILED ] ------------------");
			test.log(Status.FAIL, MarkupHelper.createLabel(scenario.getName() + " - Test Case Failed", ExtentColor.RED));
			test.log(Status.FAIL,
			MarkupHelper.createLabel(" Test Case Failed", ExtentColor.RED));
			String screenshotPath = TakeScreenshot(driver, scenario.getName());
			test.fail("Test Case Failed Snapshot is below " + test.addScreenCaptureFromPath(screenshotPath));
		} else if (!scenario.isFailed()) {
			stepInfo("-------Test Case with name " + scenario.getName() + " is  [ PASSED ] --------------------");
			test.log(Status.PASS, MarkupHelper.createLabel(scenario.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
		clearCookies();
		stepInfo("Closing all Browsers Instances");
		driver.quit();
		extent.flush();
	}

	public void readPropertiesFile(String filePath) throws FileNotFoundException {
		FileReader reader = new FileReader(filePath);
		properties = new Properties();
		try {
			properties.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String TakeScreenshot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
}
