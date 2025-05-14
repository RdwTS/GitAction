package ridwan.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutInfoPage {

    By titleCheckoutInfoPage = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    By inputFirstName = By.id("first-name");
    By inputLastName = By.id("last-name");
    By inputZipCode = By.id("postal-code");
    By buttonContinue = By.id("continue");


    private WebDriver driver;
    private WebDriverWait wait;

    public CheckoutInfoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout 10 detik
    }

    public void validateOnCheckoutInfoPage() {
//        WebElement textCheckoutInfoPage = driver.findElement(titleCheckoutInfoPage);
        WebElement textCheckoutInfoPage = wait.until(ExpectedConditions.visibilityOfElementLocated(titleCheckoutInfoPage));
        assertTrue(textCheckoutInfoPage.isDisplayed());
        assertEquals("Checkout: Your Information", textCheckoutInfoPage.getText());
    }

    public void setInputFirstname(String firstname){
        driver.findElement(inputFirstName).sendKeys(firstname);
    }
    public void setInputLastname(String lastname){
        driver.findElement(inputLastName).sendKeys(lastname);
    }
    public void setInputZipCode(String zipCode){
        driver.findElement(inputZipCode).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(buttonContinue);
        assertTrue(continueButton.isDisplayed());
        continueButton.click();
    }

    public void validateErrorClickContinueAppear(String errorMessage) {
        assertTrue(driver.getPageSource().contains(errorMessage));
    }


}
