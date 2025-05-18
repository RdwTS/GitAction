package ridwan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartPage {

    By titlePageCart = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By buttonCheckout = By.id("checkout");

    By titleCheckoutInfoPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void validateOnCartPage() {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(titlePageCart, "Your Cart"));
        WebElement textCart = driver.findElement(titlePageCart);
//        WebElement textCart = wait.until(ExpectedConditions.visibilityOfElementLocated(titlePageCart));
        assertTrue(textCart.isDisplayed());
        assertEquals("Your Cart", textCart.getText());
    }

    public void clickCheckoutButton() throws InterruptedException {
//        WebElement checkoutButton = driver.findElement(buttonCheckout);
//        assertTrue(checkoutButton.isDisplayed());
//        checkoutButton.click();

        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(buttonCheckout));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutButton);

        assertTrue(checkoutButton.isDisplayed());

        try {
            checkoutButton.click(); // Klik pakai Selenium
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutButton);// Klik pakai JavaScript
        }

        Thread.sleep(1000);

        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(buttonCheckout));
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(titleCheckoutInfoPage));
        }


    }


}
