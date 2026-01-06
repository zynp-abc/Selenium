package day03_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_ClassWork extends TestBase {
    @Test
    void test01() throws InterruptedException {


        driver.get("https://google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
        searchBox.click();


        String actualData = driver.getTitle();
        System.out.println("actualData = " + actualData);
        String expectedData = "Google";

        Thread.sleep(3000);

        Assertions.assertTrue(actualData.contains(expectedData));

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("links = " + links.size());


        for (WebElement w : links) {
            if (!w.getText().isEmpty()) {
                System.out.println(w.getText());
            }
            System.out.println("w.getText() = " + w.getText());


        }
    }
}





