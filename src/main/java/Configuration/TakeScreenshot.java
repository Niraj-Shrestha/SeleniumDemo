package Configuration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    public String screenshots(WebDriver driver) throws IOException {
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File location = new File(System.getProperty("user.dir") + "/screenshots/" + "image" + ".png");
        String destination = location.getAbsolutePath();
        FileUtils.copyFile(source, location);
        return destination;
    }
}
