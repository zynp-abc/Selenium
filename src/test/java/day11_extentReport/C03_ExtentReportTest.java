package day11_extentReport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_ExtentReportTest extends TestBase {


    @Test
    void amazonTest() {

        createExtentReports("Amazon Title Test");

        driver.get("https://amazon.com");
        extentTest.info("Kullanıcı amazon sayfasına gider");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("selenium", Keys.ENTER);
        extentTest.info("Arama kutusunda selenium yazılarak arama yapıldı");
        screenShot();
        waitForSecond(3);


        Assertions.assertTrue(driver.getTitle().contains("selenium"));
        extentTest.pass("Sayfa başlığı selenium içeriyor");
        screenShot();
        waitForSecond(3);

        extentReports.flush();
    }
}
