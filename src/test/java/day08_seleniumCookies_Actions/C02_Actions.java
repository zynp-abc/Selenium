package day08_seleniumCookies_Actions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    void actions() {

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement kutu = driver.findElement(By.cssSelector("#hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(kutu).perform();

        String actualAlertText = driver.switchTo().alert().getText();
        String expectedAlertText = "You selected a context menu";

        Assertions.assertEquals(expectedAlertText, actualAlertText);

        driver.switchTo().alert().accept();


    }

    @Test
    void actions02() {

        driver.get("https://www.amazon.com");

        WebElement accountList = driver.findElement(By.xpath("//*[@data-nav-ref='nav_ya_signin']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(accountList).perform();

        driver.findElement(By.xpath("//span[.='Account']")).click();

        Assertions.assertTrue(driver.getTitle().contains("Your Account"));

    }

    @Test
    void actions03() {

        driver.get("https://techproeducation.com");

        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        waitForSecond(2);

        actions.sendKeys(Keys.PAGE_UP, Keys.PAGE_UP, Keys.PAGE_UP).perform();


    }

    @Test
    void action04() {

        driver.get("https://techproeducation.com");

        Actions actions = new Actions(driver);

        WebElement blogText = driver.findElement(By.xpath("//h2[@class='react__tittle blogsTitleIndex']"));

        actions.scrollToElement(blogText).perform();


    }

    @Test
    void actions05() {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        WebElement dragTarget = driver.findElement(By.xpath("//*[.='Drag me to my target']"));
        WebElement dropHere = driver.findElement(By.xpath("//*[.='Drop here']"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragTarget, dropHere).perform();


    }

    @Test
    void actions06() {

        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0);

        WebElement dragTarget = driver.findElement(By.xpath("//*[.='Drag me to my target']"));
        WebElement dropHere = driver.findElement(By.xpath("//*[.='Drop here']"));

        Actions actions = new Actions(driver);

        actions.clickAndHold(dragTarget).
                moveByOffset(187, 50).
                release().
                perform();

        String dropped = dropHere.getText();
        Assertions.assertEquals("Dropped!", dropped);

    }

    @Test
    void actions07() {


        driver.get("https://google.com");

        Actions actions = new Actions(driver);

        WebElement searchBox = driver.findElement(By.cssSelector("#APjFqb"));

        actions.keyDown(searchBox, Keys.SHIFT).
                sendKeys("selenium").keyUp(Keys.SHIFT).
                sendKeys(" - java", Keys.ENTER).perform();


    }
}
