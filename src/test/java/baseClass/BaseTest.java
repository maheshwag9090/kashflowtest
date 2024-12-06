package baseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Constants;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;
    public ExtentTest extentTest;

      @BeforeClass
    public void beforeTestMethod()
    {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports.setSystemInfo("HostName","RHEL8");
        extentReports.setSystemInfo("UserName","root");
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Automation Test Result By Mahesh");
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser, Method testMethod)
    {
        extentTest=extentReports.createTest(testMethod.getName());
        setDriver(browser);
        driver.manage().window().maximize();
        driver.get(Constants.baseURL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "-Test Case Failed", ExtentColor.RED));
            extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "-Test Case Failed", ExtentColor.RED));
        } else if (result.getStatus() == ITestResult.SKIP) {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "-Test Case Skipped", ExtentColor.ORANGE));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "-Test Case PASS", ExtentColor.ORANGE));
        }
        driver.quit();
    }

    @AfterTest
    public void afterTest()
    {
        extentReports.flush();
    }

    public  void setDriver(String browser1)
    {
        if(browser1.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
        }

    }
}

