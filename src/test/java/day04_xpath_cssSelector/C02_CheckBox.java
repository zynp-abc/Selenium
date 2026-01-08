package day04_xpath_cssSelector;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_CheckBox extends TestBase {

    @Test
    void checkBox() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));


        if (!checkbox1.isSelected()) {

            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {

            checkbox2.click();
        }

        driver.quit();


    }
}
