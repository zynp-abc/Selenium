package day09_files_robot;

import org.junit.jupiter.api.Test;
import utilities.TestBase;

import java.awt.*;
import java.awt.event.KeyEvent;

public class C04_Robot extends TestBase {


    @Test
    void robot() throws AWTException {

        driver.get("https://ilovepdf.com/compress_pdf");

        Robot robot = new Robot();

        robot.keyPress(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_META);
        robot.delay(3000);

        robot.keyPress(KeyEvent.VK_N);
        robot.keyRelease(KeyEvent.VK_N);
        robot.delay(3000);


    }


}
