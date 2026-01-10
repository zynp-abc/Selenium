package day06_testBase_alert_iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {

    @Test
    void acceptAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        WebElement accept = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        accept.click();

        driver.switchTo().alert().accept();
    }


    @Test
    void dismissAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        WebElement dismiss = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        dismiss.click();

        driver.switchTo().alert().dismiss();
    }

    @Test
    void sendKeysAlert() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Zeze");
        driver.switchTo().alert().accept();

        String resultMessage = driver.findElement(By.cssSelector("#result")).getText();
        Assertions.assertTrue(resultMessage.contains("Zeze"));


    }
}
