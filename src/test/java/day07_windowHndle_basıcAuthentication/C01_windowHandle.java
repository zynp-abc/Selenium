package day07_windowHndle_basıcAuthentication;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_windowHandle extends TestBase {


    @Test
    void test01() {

        driver.get("https://www.techproeducation.com");

        String techproTitle = driver.getTitle();
        String techproedHandleDeger = driver.getWindowHandle();
        Assertions.assertTrue(techproTitle.contains("TechPro Education IT Programs"));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeHandleDegeri = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.facebook.com");
        String facebookHandleDegeri = driver.getWindowHandle();

        driver.switchTo().window(techproedHandleDeger);
        waitForSecond(2);
        driver.switchTo().window(youtubeHandleDegeri);
        waitForSecond(2);
        driver.switchTo().window(facebookHandleDegeri);


    }
}
