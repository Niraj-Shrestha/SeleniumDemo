package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
