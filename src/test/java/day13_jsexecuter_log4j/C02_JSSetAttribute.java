package day13_jsexecuter_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSSetAttribute extends TestBase {

    @Test
    void sendKeys() {

        driver.get("https://amazon.com");

        waitForSecond(3);

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].value='selenium'", searchBox);
    }

    @Test
    void sendKeys02() {

        driver.get("https://amazon.com");

        waitForSecond(2);

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        jsSendKeys("selenium", searchBox);
    }

    @Test
    void test01() {

        driver.get("https://amazon.com");
        waitForSecond(2);

        WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].setAttribute('id','zeze')", searchBox);

        driver.findElement(By.id("zeze")).sendKeys("java");


    }
}
