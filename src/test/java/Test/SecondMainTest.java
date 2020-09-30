package Test;

import Base.BaseTest;
import Configuration.ReadExcel;
import PageObjects.LoginPage;
import PageObjects.SearchPeople;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SecondMainTest extends BaseTest {

    SearchPeople searchPeople;
    ReadExcel readExcel;

    @BeforeTest
    public void pages(){
        searchPeople = PageFactory.initElements(driver, SearchPeople.class);
        readExcel = PageFactory.initElements(driver,ReadExcel.class);
    }
    @Test
    public void runTest(){
        searchPeople.doSomethingHere();
    }

}
