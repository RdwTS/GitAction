package ridwan.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ridwan.BaseTest;
import ridwan.page.CartPage;
import ridwan.page.CheckoutInfoPage;
import ridwan.page.CheckoutOverviewPage;
import ridwan.page.HomePage;

public class CheckoutCartStep extends BaseTest {

    CartPage cartPage;

    HomePage homePage;

    CheckoutInfoPage checkoutInfoPage;

    CheckoutOverviewPage checkoutOverviewPage;

    @Given("user clicks the cart icon")
    public void userClickCartPage() {
        homePage = new HomePage(driver);
        homePage.clickCart();
    }
    @Given("user is on the cart page")
    @Then("user should be on the cart page")
    public void userOpenTheCartPage() {
        System.out.println("Current URL before validating Cart Page: " + driver.getCurrentUrl());

//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            // path
//            File destination = new File("screenshots/before_cart_validation_" + System.currentTimeMillis() + ".png");
//            org.apache.commons.io.FileUtils.copyFile(source, destination);
//            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
//        } catch (Exception e) {
//            System.out.println("Could not take screenshot: " + e.getMessage());
//        }

        cartPage = new CartPage(driver);
        cartPage.validateOnCartPage();
    }


    @When("user clicks the Checkout button")
    public void userClicksTheCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @Then("user should be on the checkout information page")
    @Given("user is on the checkout information page")
    public void userShouldBeOnTheCheckoutInformationPage() {
        checkoutInfoPage = new CheckoutInfoPage(driver);
        checkoutInfoPage.validateOnCheckoutInfoPage();
    }

    @And("user enters first name {string}")
    public void userEntersFirstName(String firstname) {
        checkoutInfoPage.setInputFirstname(firstname);
    }

    @And("user enters last name {string}")
    public void userEntersLastName(String lastname) {
        checkoutInfoPage.setInputLastname(lastname);
    }

    @And("user enters postal code {string}")
    public void userEntersPostalCode(String zipcode) {
        checkoutInfoPage.setInputZipCode(zipcode);
    }

    @When("user clicks the Continue button")
    public void userClicksTheContinueButton() {
        checkoutInfoPage.clickContinueButton();
    }

    @Then("user should be on the checkout overview page")
    @Given("user is on the checkout overview page")
    public void userShouldBeOnTheCheckoutOverviewPage() {
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.validateOnCheckoutOverviewPage();

    }

    @Then("user should see a error message {string}")
    public void userShouldSeeAErrorMessage(String errorMessage) {
        checkoutInfoPage.validateErrorClickContinueAppear(errorMessage);
    }

    @When("user clicks the Finish button")
    public void userClicksTheFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }

    @Then("user should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String successMessage) {
        checkoutOverviewPage.validateSuccessClickFinishAppear(successMessage);
    }
}
