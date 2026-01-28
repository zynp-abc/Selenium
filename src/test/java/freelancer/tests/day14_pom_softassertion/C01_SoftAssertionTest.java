package freelancer.tests.day14_pom_softassertion;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C01_SoftAssertionTest {


    @Test
    public void test01() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://amazon.com");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().contains("Amazon.com"), "title amazon içermiyor");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        softAssert.assertTrue(aramaKutusu.isEnabled(), "Sonuç yazısı erişilebilir değil");

        aramaKutusu.sendKeys("selenium" + Keys.ENTER);

        WebElement sonucYazısı = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

        softAssert.assertTrue(sonucYazısı.getText().contains("selenium"), "sonuc yazısı selenium içermiyor");

        softAssert.assertAll();


    }

}
