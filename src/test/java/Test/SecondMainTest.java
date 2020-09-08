package Test;

import Base.BaseTest;
import org.testng.annotations.Test;

public class SecondMainTest extends BaseTest {
    @Test
    public void runTest(){
        searchPeople.doSomethingHere();
    }
}
