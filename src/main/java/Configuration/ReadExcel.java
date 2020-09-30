package Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadExcel {


    FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir") + "/DataSheet.xlsx"));

    XSSFWorkbook workbook = new XSSFWorkbook(file);

    XSSFSheet sheet = workbook.getSheetAt(0);

    String Username = sheet.getRow(1).getCell(0).getStringCellValue();
    String Password = sheet.getRow(1).getCell(1).getStringCellValue();
    public ReadExcel() throws IOException {
    }

    public String setUsername(){
        return Username;
    }

    public String setPassword(){
        return Password;
    }
}
