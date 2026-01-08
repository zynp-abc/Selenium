package day04_xpath_cssSelector;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_RadioButton extends TestBase {

    @Test
    void radioButton() throws InterruptedException {

        driver.get("https://www.facebook.com");

        WebElement createAccount = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccount.click();

        Thread.sleep(3000);

        WebElement kadın = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement erkek = driver.findElement(By.xpath("//input[@value='2']"));


        if (!kadın.isSelected()) {
            kadın.click();
        }


    }
}
