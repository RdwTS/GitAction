package ridwan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {
    By productTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    //    By productBackpackAddChart = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By productHomePage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    By productBackpackAddChart = By.id("add-to-cart-sauce-labs-backpack");

    By productBackpackRemoveChart = By.id("remove-sauce-labs-backpack");
//    By productBackpackRemoveChart = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");

    By imageChart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By titlePageCart = By.xpath("//*[@id=\"header_container\"]/div[2]/span");



    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void validateOnHomePage() {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
//        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }


    public void clickAddToCartBackpack() throws InterruptedException {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(productBackpackAddChart));

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(500);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", addButton);


        assertTrue(addButton.isDisplayed());

        try {
            addButton.click(); // Klik pakai Selenium
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);// Klik pakai JavaScript

        }

        // 💡 Tambahkan delay untuk menunggu reaksi JS pada tombol
        Thread.sleep(1000);

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(productBackpackAddChart));
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(productBackpackRemoveChart));
            wait.until(ExpectedConditions.presenceOfElementLocated(productBackpackRemoveChart));
            wait.until(ExpectedConditions.textToBePresentInElementLocated(productBackpackRemoveChart, "Remove"));
        }

    }


    public void validateRemoveButtonVisible() {
//        wait.until(ExpectedConditions.presenceOfElementLocated(productBackpackRemoveChart));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(productBackpackRemoveChart));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(productBackpackRemoveChart, "Remove"));

        WebElement removeButton = driver.findElement(productBackpackRemoveChart);
        assertTrue(removeButton.isDisplayed());
        assertEquals("Remove", removeButton.getText());
    }



    public void validateCartCount(int expectedCount) {
        WebElement cartBadge = driver.findElement(imageChart);
        assertTrue(cartBadge.isDisplayed());
        assertEquals(String.valueOf(expectedCount), cartBadge.getText());
    }

    public void clickCart() throws InterruptedException {
//        WebElement cartBadge = driver.findElement(imageChart);
//        assertTrue(cartBadge.isDisplayed());
//        cartBadge.click();

        WebElement cartBadge = wait.until(ExpectedConditions.elementToBeClickable(imageChart));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartBadge);

        assertTrue(cartBadge.isDisplayed());

        try {
            cartBadge.click(); // Klik pakai Selenium
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBadge);// Klik pakai JavaScript
        }

        // 💡 Tambahkan delay untuk menunggu reaksi JS pada tombol
        Thread.sleep(1000);

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(productHomePage));
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(titlePageCart));
        }


    }



}
