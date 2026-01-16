package day10_seleniumWait_exceptions;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait_WebdriverWait extends TestBase {

    @Test
    void explicitWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button")).click();

        WebElement helloWorldText = driver.findElement(By.xpath("//*[.='Hello World!']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));


        Assertions.assertEquals("Hello World!", helloWorldText.getText());
    }

    @Test
    void fluentWait() {

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.xpath("//button")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver);

        WebElement helloWorldText = driver.findElement(By.xpath("//*[.='Hello World!']"));

        wait.withTimeout(Duration.ofSeconds(20)).
                pollingEvery(Duration.ofMillis(200)).
                withMessage("Süreyi kontrol et").
                until(ExpectedConditions.visibilityOf(helloWorldText));

        Assertions.assertEquals("Hello World!", helloWorldText.getText());


    }

}
