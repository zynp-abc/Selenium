package day10_seleniumWait_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_ScreenShot extends TestBase {

    @Test
    void screenShot01() throws IOException {

        driver.get("https://techproeducation.com");

        String dosyaYolu = "src/test/java/screenShots/techpro.png";

        TakesScreenshot ts = (TakesScreenshot) driver;

        Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    void screenShot02() throws IOException {

        driver.get("https://google.com");

        String dosyaYolu = "src/test/java/screenShots/google.jpeg";

        TakesScreenshot ts = (TakesScreenshot) driver;

        Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
    }

    @Test
    void screenShot03() {

        driver.get("https://facebook.com");

        screenShot();


    }
}
