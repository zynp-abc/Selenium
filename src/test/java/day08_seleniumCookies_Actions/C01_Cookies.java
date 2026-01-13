package day08_seleniumCookies_Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    void test01() {

        driver.get("https://www.amazon.com");

        waitForSecond(5);

        Set<Cookie> cookiesSet = driver.manage().getCookies();

        for (Cookie w : cookiesSet) {
            System.out.println("cookie = " + w);
            System.out.println("cookie name = " + w.getName());
            System.out.println("cookie value = " + w.getValue());
            System.out.println("============================================================");

        }

        int actualSize = cookiesSet.size();
        Assertions.assertTrue(actualSize > 5);

        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        Assertions.assertEquals("TRY", actualCookieValue, "Value uyumlu değil");

        Cookie myCookie = new Cookie("en sevdigim cookie", "çikolatalı");
        driver.manage().addCookie(myCookie);

        cookiesSet = driver.manage().getCookies();

        for (Cookie w : cookiesSet) {
            System.out.println("cookie = " + w);
            System.out.println("cookie name = " + w.getName());
            System.out.println("cookie value = " + w.getValue());
            System.out.println("============================================================");
        }
        Assertions.assertTrue(cookiesSet.contains(myCookie));

        driver.manage().deleteCookieNamed("skin");

        Assertions.assertNull(driver.manage().getCookieNamed("skin"));

        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();
        Assertions.assertTrue(cookiesSet.isEmpty());


    }
}
