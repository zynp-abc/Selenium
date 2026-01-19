package day10_seleniumWait_exceptions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C03_WebElementScreenShot extends TestBase {

    @Test
    void screenShot01() throws IOException {

        driver.get("https://amazon.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("laptop");
        searchBox.submit();

        screenShot();

        WebElement resultText = driver.findElement(By.xpath("//*[contains(text(),'results for')]"));
        String date = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/" + date + ".jpeg";

        Files.write(Paths.get(dosyaYolu), resultText.getScreenshotAs(OutputType.BYTES));


    }
}
