package Test;

import Base.BaseTest;
import Configuration.ReadExcel;
import Configuration.TakeScreenshot;
import PageObjects.LoginPage;
import PageObjects.SearchPeople;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainTestFile extends BaseTest{

    LoginPage loginPage;

    @BeforeTest
    public void pages(){
       loginPage = PageFactory.initElements(driver,LoginPage.class);
    }

    @Test(priority = 1)
    public void validUsernameInvalidPassword() throws IOException {
        //LoginPage login = new LoginPage(driver);
        TakeScreenshot SS = new TakeScreenshot();
        ReadExcel excelval = new ReadExcel();
        //Test Name
        logger = report.startTest("Login using invalid email and password");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        if(loginPage.verifyLogo() == false){
            logger.log(LogStatus.PASS, "Logo Displayed");
        }else
        {
            logger.log(LogStatus.FAIL,logger.addScreenCapture(SS.screenshots(driver)));
        }

        loginPage.setEmail(excelval.setUsername());
        //Test Step
        logger.log(LogStatus.PASS,"Email Entered");
        loginPage.setPass(excelval.setPassword());
        logger.log(LogStatus.PASS,"Password Entered");
        loginPage.setLogin();
        logger.log(LogStatus.PASS,"Login Clicked");
        System.out.println("This sis test line");
    }

    /*@Test(priority = 1)
    public void invalidUsernameInvalidPassword() throws IOException {
        //LoginPage login = new LoginPage(driver);
        TakeScreenshot SS = new TakeScreenshot();
        //Test Name
        logger = report.startTest("Login using invalid email and password");

        if(loginPage.verifyLogo() == false){
            logger.log(LogStatus.PASS, "Logo Displayed");
        }else
        {
            logger.log(LogStatus.FAIL,logger.addScreenCapture(SS.screenshots(driver)));
        }

        loginPage.setEmail("PositiveTest");
        //Test Step
        logger.log(LogStatus.PASS,"Email Entered");
        loginPage.setPass("Pass");
        logger.log(LogStatus.PASS,"Password Entered");
        loginPage.setLogin();
        logger.log(LogStatus.PASS,"Login Clicked");
    }*/
}
