package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class TestBase {

    protected ExtentReports extentReports;

    protected ExtentSparkReporter extentSparkReporter;

    protected ExtentTest extentTest;

    public void createExtentReports(String testName) {

        Locale.setDefault(Locale.US);
        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String path = "target/extent-report-" + date + ".html";

        extentSparkReporter = new ExtentSparkReporter(path);

        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Automation Test Report");

        extentSparkReporter.config().setReportName("Automation Test Results");

        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Zeynep");

        extentTest = extentReports.createTest(testName, "Test Steps");
    }


    protected WebDriver driver;


    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    // @AfterEach
    //void tearDown() {
    //  driver.quit();}

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
        String path = "target/extent-report-" + date + ".html";
        try {
            Files.write(Paths.get(dosyaYolu), ts.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" + path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void screenShotOfWebElement(WebElement webElement) {

        String date = DateTimeFormatter.ofPattern("ddMMyyy_HHmmss").format(LocalDateTime.now());
        String dosyaYolu = "src/test/java/screenShots/" + date + ".jpeg";

        try {
            Files.write(Paths.get(dosyaYolu), webElement.getScreenshotAs(OutputType.BYTES));
            extentTest.addScreenCaptureFromPath(System.getProperty("user.dir") + "/" + dosyaYolu);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


    public void jsExecutorClick(WebElement webElement) {

        try {
            webElement.click();
        } catch (Exception e) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", webElement);
        }
    }

    public void jsScroll(WebElement webElement) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", webElement);

    }

    public void jsScrollEnd() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void jsScrollUp() {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    public void jsSendKeys(String value, WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].value='" + value + "'", webElement);

    }


}
