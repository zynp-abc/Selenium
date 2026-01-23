package day12_webtables_excel;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {

    @Test
    void test01() {

        driver.get("https://the-internet.herokuapp.com/tables");

        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        System.out.println(table1.getText());
        System.out.println("===================================================================");

        WebElement thirdRow = driver.findElement(By.xpath("//table[1]/tbody/tr[3]"));
        System.out.println(thirdRow.getText());
        System.out.println("===================================================================");

        WebElement tableLast = driver.findElement(By.xpath("//table[1]/tbody/tr[last()]"));
        System.out.println(tableLast.getText());
        System.out.println("===================================================================");

        List<WebElement> webSite = driver.findElements(By.xpath("//table[1]/tbody/tr/td[5]"));
        for (WebElement w : webSite) {
            System.out.println(w.getText());
        }
        System.out.println("===================================================================");

        printData(2, 3);
    }

    private void printData(int satir, int sutun) {

        WebElement webElement = driver.findElement(By.xpath("//table[1]/tbody/tr[" + satir + "]/td[" + sutun + "]"));
        System.out.println(webElement.getText());
    }


}
