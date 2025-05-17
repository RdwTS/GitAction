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
    By productBackpackAddChart = By.id("add-to-cart-sauce-labs-backpack");

    By productBackpackRemoveChart = By.id("remove-sauce-labs-backpack");
//    By productBackpackRemoveChart = By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]");

    By imageChart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");



    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(180));
    }

    public void validateOnHomePage() {
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
//        WebElement productElement = driver.findElement(productTitle);
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }


    public void clickAddToCartBackpack() throws InterruptedException {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(productBackpackAddChart));
        // Scroll ke elemen untuk memastikan terlihat di layar
//        Thread.sleep(1000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);

        assertTrue(addButton.isDisplayed());

        try {
            addButton.click(); // Klik pakai Selenium
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);// Klik pakai JavaScript
        }

        wait.until(ExpectedConditions.invisibilityOfElementLocated(productBackpackAddChart));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(productBackpackRemoveChart));
    }


    public void validateRemoveButtonVisible() {
        wait.until(ExpectedConditions.presenceOfElementLocated(productBackpackRemoveChart));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productBackpackRemoveChart));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productBackpackRemoveChart, "Remove"));
        WebElement removeButton = driver.findElement(productBackpackRemoveChart);
        assertTrue(removeButton.isDisplayed());
        assertEquals("Remove", removeButton.getText());
    }



    public void validateCartCount(int expectedCount) {
        WebElement cartBadge = driver.findElement(imageChart);
        assertTrue(cartBadge.isDisplayed());
        assertEquals(String.valueOf(expectedCount), cartBadge.getText());
    }

    public void clickCart() {
        WebElement cartBadge = driver.findElement(imageChart);
        assertTrue(cartBadge.isDisplayed());
        cartBadge.click();
    }



}
