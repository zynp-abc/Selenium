package day07_windowHndle_basıcAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C02_WindowHandle extends TestBase {

    @Test
    void test01() {

        driver.get("https://the-internet.herokuapp.com/windows");
        String firstPageHandle = driver.getWindowHandle();

        String firstPageText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";

        Assertions.assertEquals(expectedText, firstPageText);
        Assertions.assertEquals("The Internet", driver.getTitle());

        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        Set<String> windows = driver.getWindowHandles();
        for (String w : windows) {

            if (!w.equals(firstPageHandle)) {
                driver.switchTo().window(w);
            }
        }

        String secondPageHandleDegeri = driver.getWindowHandle();
        Assertions.assertEquals("New Window", driver.getTitle());

        driver.switchTo().window(firstPageHandle);
        Assertions.assertEquals("The Internet", driver.getTitle());
        driver.switchTo().window(secondPageHandleDegeri);
        driver.switchTo().window(firstPageHandle);


    }
}
