package day11_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class C02_ExtentReportTest extends TestBase {

    ExtentReports extentReports;

    ExtentTest extentTest;

    ExtentSparkReporter extentSparkReporter;

    @Test
    void extentReportTest() {
        Locale.setDefault(Locale.US);
        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());
        String path = "target/extent-report-" + date + ".html";

        extentSparkReporter = new ExtentSparkReporter(path);

        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("TechproEducation Test Report");
        extentSparkReporter.config().setReportName("My Extent Test");


        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Zeynep");

        extentTest = extentReports.createTest("TechproeducationTest", "Test Steps");

        driver.get("https://techproeducation.com");
        extentTest.info("Kullanıcı Texhproeducation sayfasına gider");

        WebElement icons = driver.findElement(By.xpath("//*[@class='toolbar-sl-share']"));

        Assertions.assertTrue(icons.isDisplayed());
        extentTest.pass("Kullanıcı Sosyal Medya Iconlarını doğrular");

        extentReports.flush();
    }
}
