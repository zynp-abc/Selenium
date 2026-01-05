package day01_DriverilkTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_Driver {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");

        String title = driver.getTitle();
        System.out.println("title = " + title);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        String handleDeğeri = driver.getWindowHandle();
        System.out.println("handleDeğeri = " + handleDeğeri);

        driver.get("https://techproeducation.com");

        String techproTitle = driver.getTitle();
        System.out.println("techproTitle = " + techproTitle);

        String techproUrl = driver.getCurrentUrl();
        System.out.println("techproUrl = " + techproUrl);

        // String pageSource = driver.getPageSource();
        // System.out.println("pageSource = " + pageSource);

        driver.quit();


    }
}
