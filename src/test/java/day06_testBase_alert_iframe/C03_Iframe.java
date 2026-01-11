package day06_testBase_alert_iframe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_Iframe extends TestBase {

    @Test
    void iframe() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        String actualText = driver.findElement(By.xpath("//*[.='An iframe with a thin black border:']")).getText();
        Assertions.assertTrue(actualText.contains("black border"));

        driver.switchTo().frame(0);

        WebElement applicationList = driver.findElement(By.xpath("//*[.='Applications lists']"));
        Assertions.assertTrue(applicationList.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement iframeText = driver.findElement(By.xpath("//h3"));
        Assertions.assertTrue(iframeText.isDisplayed());


    }
}
