package day09_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_UploadFile extends TestBase {

    @Test
    void uploadFile() {

        driver.get("https://the-internet.herokuapp.com/upload");

        WebElement dosyaSec = driver.findElement(By.cssSelector("#file-upload")); // Tıklarsak finder çıkyor ona da müdahale edemeyiz. Onun için sendKeys ile dosya gönderdik

        String dosyaYolu = System.getProperty("user.home") + "/Downloads/b10 all test cases, code.docx";

        dosyaSec.sendKeys(dosyaYolu);

        WebElement uploadButton = driver.findElement(By.cssSelector("#file-submit"));
        uploadButton.click();

        String actualText = driver.findElement(By.xpath("//h3")).getText();

        Assertions.assertEquals("File Uploaded!", actualText);


    }


}
