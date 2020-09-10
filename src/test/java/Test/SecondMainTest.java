package Test;

import Base.BaseTest;
import PageObjects.LoginPage;
import PageObjects.SearchPeople;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondMainTest extends BaseTest {

    SearchPeople searchPeople;

    @BeforeTest
    public void pages(){
        searchPeople = PageFactory.initElements(driver, SearchPeople.class);
    }
    @Test
    public void runTest(){
        searchPeople.doSomethingHere();
    }
}
