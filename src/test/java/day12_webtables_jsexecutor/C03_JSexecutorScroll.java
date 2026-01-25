package day12_webtables_jsexecutor;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSexecutorScroll extends TestBase {

    @Test
    void test01() {

        driver.get("https://testpages.herokuapp.com");

        WebElement history = driver.findElement(By.xpath("//h2[.='History']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].scrollIntoView(true)", history);
    }
}
