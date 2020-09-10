package Base;

import Configuration.TimeStamp;
import PageObjects.LoginPage;
import PageObjects.SearchPeople;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.*;
import java.util.Properties;

public abstract class BaseTest {

    public String BROWSER;
    public String URL;
    public WebDriver driver;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setupResourceFile() throws IOException {
        InputStream input = new FileInputStream(System.getProperty("user.dir")+ "/src/resources/config.properties" );
        Properties props = new Properties();
        props.load(input);
        BROWSER = props.getProperty("testbrowser");
        URL = props.getProperty("URL");

    }


    //Parameters("browser")
    @BeforeTest
    public void setup(){
        /*if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","chromedriver");
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver","geckodriver");
            driver= new FirefoxDriver();

        }*/

        switch (BROWSER){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver","drivers/geckodriver");

                driver= new FirefoxDriver();
                break;

            default:
                System.out.println("No Driver found");

        }
        driver.get(URL);
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
    }


}
