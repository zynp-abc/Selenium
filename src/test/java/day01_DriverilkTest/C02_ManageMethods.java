package day01_DriverilkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ManageMethods {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://techproeducation.com");

        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        driver.manage().window().minimize();

        Thread.sleep(2000);

        driver.manage().window().maximize();

        Thread.sleep(2000);

        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        driver.manage().window().fullscreen();



        driver.quit();






    }


}
