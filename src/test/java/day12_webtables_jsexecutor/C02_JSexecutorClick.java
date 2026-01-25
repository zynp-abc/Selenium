package day12_webtables_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSexecutorClick extends TestBase {

    @Test
    void test01() {

        driver.get("https://amazon.com");

        WebElement registry = driver.findElement(By.xpath("//a[.='Registry']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();", registry);
    }

    @Test
    void test02() {

        driver.get("https://amazon.com");

        WebElement registry = driver.findElement(By.xpath("//a[.='Registry']"));

        jsExecutorClick(registry);


    }
}
