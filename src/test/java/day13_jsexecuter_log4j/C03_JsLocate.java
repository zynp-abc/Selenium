package day13_jsexecuter_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsLocate extends TestBase {

    @Test
    void test01() {

        driver.get("https://amazon.com");

        waitForSecond(2);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement searchBox = (WebElement) jse.executeScript("return document.getElementById('twotabsearchtextbox')");

        searchBox.sendKeys("selenium");

        String searchBoxValue = jse.executeScript("return document.getElementById('twotabsearchtextbox').value").toString();
        System.out.println("searchBoxValue = " + searchBoxValue);
        String searchBoxName = jse.executeScript("return document.getElementById('twotabsearchtextbox').name").toString();
        System.out.println("searchBoxName = " + searchBoxName);

    }

    @Test
    void tes02() {


        driver.get("https://techproeducation.com");

        WebElement blogText = driver.findElement(By.xpath("//h2[.='Blog']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].textContent='BATCH 210'", blogText);
    }
}
