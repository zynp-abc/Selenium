package day01_DriverilkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ImplicitlyWait {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com");
        String tecproedTitle = driver.getTitle();
        System.out.println("tecproedTitle = " + tecproedTitle);

        driver.get("https://www.facebook.com");
        String faceUrl = driver.getCurrentUrl();
        System.out.println("faceUrl = " + faceUrl);

        driver.navigate().back();

        Thread.sleep(2000);

        driver.quit();


    }


}
