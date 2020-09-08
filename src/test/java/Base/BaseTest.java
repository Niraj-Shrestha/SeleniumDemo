package Base;

import Configuration.TimeStamp;
import PageObjects.LoginPage;
import PageObjects.SearchPeople;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public abstract class BaseTest {

    public WebDriver driver;
    public ExtentReports report;
    public ExtentTest logger;
    protected LoginPage loginPage;
    protected SearchPeople searchPeople;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @BeforeTest
    public void setupReport(){
        TimeStamp time = new TimeStamp();
        report = new ExtentReports(System.getProperty("user.dir") + "/Reports/File_" + time.timeStamp() +".html" );

        report.addSystemInfo("Username", "Niraj").addSystemInfo("Environment","QA");
        report.loadConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
    }

    @BeforeTest
    public void startReport(){
        logger = report.startTest("Starting Test Execution");
    }

    @AfterTest
    public void endReport(){
        report.flush();
    }

    @AfterTest
    public void exit(){
        driver.close();
        driver.quit();
    }

   @BeforeTest
    public void pages(){
        loginPage = PageFactory.initElements(driver,LoginPage.class);
        searchPeople = PageFactory.initElements(driver,SearchPeople.class);
    }
}
