package day06_testBase_alert_iframe;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_ClassWork extends TestBase {
    @Test
    void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement year = driver.findElement(By.cssSelector("#year"));
        WebElement month = driver.findElement(By.cssSelector("#month"));
        WebElement day = driver.findElement(By.cssSelector("#day"));

        selectIndex(year, 1);
        selectIndex(day, 7);
        selectIndex(month, 5);

        selectVisible(year, "2000");
        selectVisible(month, "May");
        selectVisible(day, "17");

    }
}
