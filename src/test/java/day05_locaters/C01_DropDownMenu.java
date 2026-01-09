package day05_locaters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C01_DropDownMenu extends TestBase {

    @Test
    void dropDownMenu() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement year = driver.findElement(By.cssSelector("#year"));
        WebElement month = driver.findElement(By.cssSelector("#month"));
        WebElement day = driver.findElement(By.cssSelector("#day"));

        Select selectYear = new Select(year);
        Select selectMonth = new Select(month);
        Select selectDay = new Select(day);

        selectYear.selectByIndex(1);
        selectMonth.selectByValue("7");
        selectDay.selectByVisibleText("21");


        WebElement state = driver.findElement(By.cssSelector("#state"));
        Select selectState = new Select(state);

        List<WebElement> eyaletlerListesi = selectState.getOptions();

        for (WebElement w : eyaletlerListesi) {

            System.out.println("w = " + w.getText());
        }

        WebElement state02 = driver.findElement(By.cssSelector("#state"));
        Select selectState02 = new Select(state02);
        String actual = selectState02.getFirstSelectedOption().getText();
        String expected = "Select a State";

        Assertions.assertEquals(expected, actual);


    }

    @Test
    void dropDownMenu2() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement year = driver.findElement(By.cssSelector("#year"));
        WebElement month = driver.findElement(By.cssSelector("#month"));
        WebElement day = driver.findElement(By.cssSelector("#day"));

        year.sendKeys("2022");
        month.sendKeys("February");
        day.sendKeys("17");


    }
}
