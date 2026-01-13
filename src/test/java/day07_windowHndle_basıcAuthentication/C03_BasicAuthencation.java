package day07_windowHndle_basıcAuthentication;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

public class C03_BasicAuthencation extends TestBase {


    @Test
    void test01() {

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
