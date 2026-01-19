package utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBase {

    protected WebDriver driver;


    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void waitForSecond(int second) {

        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void selectVisible(WebElement ddm, String option) {
        Select select = new Select(ddm);
        select.selectByVisibleText(option);
    }

    public void selectIndex(WebElement ddm, int idx) {
        Select select = new Select(ddm);
        select.selectByIndex(idx);
    }

    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);

    }

    public void switchToWindow(int index) {
        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());
    }


    public void screenShot() {
        String date = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss").format(LocalDateTime.now());

        TakesScreenshot ts = (TakesScreenshot) driver;

        String dosyaYolu = "src/test/java/screenShots/" + date + ".jpeg";

        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void screenShotOfWebElement(WebElement webElement) {

        String date = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/" + date + ".jpeg";

        try {
            Files.write(Paths.get(dosyaYolu), webElement.getScreenshotAs(OutputType.BYTES));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    // @AfterEach
    //void tearDown() {
    //  driver.quit();}


}
