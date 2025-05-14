package ridwan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutOverviewPage {
    By titleCheckoutInfoPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");

    By buttonFinish = By.id("finish");

    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout 10 detik
    }

    public void validateOnCheckoutOverviewPage() {
        WebElement textCheckoutOverview = wait.until(ExpectedConditions.visibilityOfElementLocated(titleCheckoutInfoPage));
//        WebElement textCheckoutOverview = driver.findElement(titleCheckoutInfoPage);
        assertTrue(textCheckoutOverview.isDisplayed());
        assertEquals("Checkout: Overview", textCheckoutOverview.getText());
    }

    public void clickFinishButton() {
        WebElement finishButton = driver.findElement(buttonFinish);
        assertTrue(finishButton.isDisplayed());
        finishButton.click();
    }

    public void validateSuccessClickFinishAppear(String succesMessage) {
        assertTrue(driver.getPageSource().contains(succesMessage));
    }



}
