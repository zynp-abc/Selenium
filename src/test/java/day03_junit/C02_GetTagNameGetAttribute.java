package day03_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_GetTagNameGetAttribute extends TestBase {

    @Test
    void GetTagName() {

        driver.get("https://techproeducation.com");

        WebElement searchBox = driver.findElement(By.id("searchHeaderInput"));
        String actualTagName = searchBox.getTagName();
        String expectedTagName = "input";

        Assertions.assertEquals(actualTagName, expectedTagName);

        String actualAttribute=searchBox.getAttribute("class");
        String expectedAttribute="form-input";

        Assertions.assertTrue(actualAttribute.equals(expectedAttribute));
    }
}
