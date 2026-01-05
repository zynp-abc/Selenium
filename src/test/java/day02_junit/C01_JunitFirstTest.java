package day02_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C01_JunitFirstTest extends TestBase {


    @Test
    void test01() {

        driver.get("https://www.google.com");

        String expected = "Google";
        String actual = driver.getTitle();

        String expectedUrl = "https://www.google.com/";
        String actualUrl = driver.getCurrentUrl();

        Assertions.assertEquals(expected, actual);
        Assertions.assertEquals(expectedUrl, actualUrl);




    }
}
