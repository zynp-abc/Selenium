package day09_files_robot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownLoad extends TestBase {

    @Test
    void test01() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        driver.findElement(By.xpath("//a[.='b10 all test cases, code.docx']")).click();

        waitForSecond(5);

        String dosyaYolu = System.getProperty("user.home") + "/Downloads/b10 all test cases, code.docx";

        Assertions.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }
}

