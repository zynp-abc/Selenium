package day03_junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Xpath extends TestBase {

    @Test
    void xpath() {

        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("city bike", Keys.ENTER);

        WebElement aramaSonucu = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        System.out.println("aramaSonucu.getText() = " + aramaSonucu.getText());

        System.out.println("Sadece sonuc sayısı " + aramaSonucu.getText().split(" ")[2]);

        driver.findElement(By.xpath("(//h2)[5]")).click();


    }
}
