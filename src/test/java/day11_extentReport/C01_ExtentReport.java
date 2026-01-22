package day11_extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ExtentReport {

    ExtentReports extentReports;

    ExtentSparkReporter extentSparkReporter;

    ExtentTest extentTest;

    @Test
    void extentReportTemplate() {

        Locale.setDefault(Locale.US);
        extentReports = new ExtentReports();

        String date = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss").format(LocalDateTime.now());

        String path = "target/extent-report-" + date + ".html";

        extentSparkReporter = new ExtentSparkReporter(path);

        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setDocumentTitle("Batch 210 Test Reports");

        extentSparkReporter.config().setReportName("My Extent Report");

        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", "Zeynep");

        extentTest = extentReports.createTest("AmazonTest", "Test Steps");

        extentTest.pass("PASS");
        extentTest.info("Bilgilendirme Notu");
        extentTest.fail("FAIL");

        extentReports.flush(); // bunu yazmazsak çalışmaz


    }

}
