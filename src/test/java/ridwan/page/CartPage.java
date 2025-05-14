package ridwan.page;

import org.openqa.selenium.By;
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

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void validateOnCartPage() {

        wait.until(ExpectedConditions.textToBePresentInElementLocated(titlePageCart, "Your Cart"));
        WebElement textCart = driver.findElement(titlePageCart);
//        WebElement textCart = wait.until(ExpectedConditions.visibilityOfElementLocated(titlePageCart));
//        WebElement textCart = driver.findElement(titlePageCart);
        assertTrue(textCart.isDisplayed());
        assertEquals("Your Cart", textCart.getText());
    }

    public void clickCheckoutButton() {
        WebElement checkoutButton = driver.findElement(buttonCheckout);
        assertTrue(checkoutButton.isDisplayed());
        checkoutButton.click();
    }


}
