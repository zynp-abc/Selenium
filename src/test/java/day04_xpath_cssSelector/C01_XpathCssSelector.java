package day04_xpath_cssSelector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_XpathCssSelector extends TestBase {


    @Test
    void test01() {
        driver.get("https://the-internet.herokuapp.com//add_remove_elements/");

        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();

        WebElement deleteButton = driver.findElement(By.xpath("//*[@class='added-manually']"));

        Assertions.assertTrue(deleteButton.isDisplayed());

        deleteButton.click();

        WebElement removeElements = driver.findElement(By.xpath("//h3"));

        Assertions.assertTrue(removeElements.isDisplayed());

        driver.close();


    }
}
