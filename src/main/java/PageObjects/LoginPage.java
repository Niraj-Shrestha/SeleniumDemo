package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "email")
    WebElement email;
    @FindBy(id = "pass")
    WebElement pass;
    @FindBy(xpath = "//*[@id=\"u_0_b\"]")
    WebElement login;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div[1]/div/img")
    WebElement Logo;

    public void setEmail(String Username){
        email.sendKeys(Username);
    }

    public void setPass(String Password) {
        pass.sendKeys(Password);
    }

    public void setLogin(){
        login.click();
    }

    public boolean verifyLogo(){
        Logo.isDisplayed();
        return true;
    }
}
