package day13_jsexecuter_log4j;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsScroll extends TestBase {

    @Test
    void test01() {
        driver.get("https://techproeducation.com");

        waitForSecond(3);

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        waitForSecond(2);

        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    @Test
    void test02() {

        driver.get("https://techproeducation.com");

        waitForSecond(2);

        jsScrollEnd();

        waitForSecond(2);

        jsScrollUp();


    }
}
