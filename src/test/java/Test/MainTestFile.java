package Test;

import Configuration.TimeStamp;
import PageObjects.LoginPage;
import Configuration.TakeScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class MainTestFile {

    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;

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


    @Test(priority = 1)
    public void validUsernameInvalidPassword() throws IOException {
        LoginPage login = new LoginPage(driver);
        TakeScreenshot SS = new TakeScreenshot();
        //Test Name
        logger = report.startTest("Login using invalid email and password");

        if(login.verifyLogo() == false){
            logger.log(LogStatus.PASS, "Logo Displayed");
        }else
        {
            logger.log(LogStatus.FAIL,logger.addScreenCapture(SS.screenshots(driver)));
        }

        login.setEmail("PositiveTest");
        //Test Step
        logger.log(LogStatus.PASS,"Email Entered");
        login.setPass("Pass");
        logger.log(LogStatus.PASS,"Password Entered");
        login.setLogin();
        logger.log(LogStatus.PASS,"Login Clicked");
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
}
