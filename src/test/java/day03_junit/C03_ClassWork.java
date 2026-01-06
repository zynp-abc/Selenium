package day03_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_ClassWork extends TestBase {

    @Test
    void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php");

        WebElement backToButton = driver.findElement(By.partialLinkText("Back to TechProEducation.com"));

        Assertions.assertTrue(backToButton.isEnabled());

        WebElement applications = driver.findElement(By.tagName("h1"));

        Assertions.assertTrue(applications.isDisplayed());
    }
}
