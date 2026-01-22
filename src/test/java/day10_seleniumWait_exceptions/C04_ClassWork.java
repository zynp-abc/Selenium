package day10_seleniumWait_exceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_ClassWork extends TestBase {

    @Test
    void test01() throws IOException {

        driver.get("https://techproeducation.com");

        Assertions.assertEquals("https://www.techproeducation.com/", driver.getCurrentUrl());

        screenShot();

        WebElement phone = driver.findElement(By.xpath("(//*[.='+1 587 330 79 59'])[1]"));

        Assertions.assertEquals("+1 587 330 79 59", phone.getText());

        String dosyaYolu = "src/test/java/screenShots/resim.jpeg";

        Files.write(Paths.get(dosyaYolu), phone.getScreenshotAs(OutputType.BYTES));

        WebElement searchBox = driver.findElement(By.cssSelector("#searchHeaderInput"));
        searchBox.sendKeys("selenium");

        Files.write(Paths.get(dosyaYolu), searchBox.getScreenshotAs(OutputType.BYTES));

    }

    @Test
    void test02() {

        driver.get("https://facebook.com");

        WebElement password = driver.findElement(By.xpath("//*[.='Şifreni mi Unuttun?']"));

        screenShotOfWebElement(password);
    }
}
