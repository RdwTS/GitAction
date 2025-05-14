package ridwan.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ridwan.BaseTest;
import ridwan.page.HomePage;

public class HomeStep extends BaseTest {

    HomePage homePage;


    @Then("user will be on homepage")
    @Given("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.validateOnHomePage();
    }

    @When("user clicks {string} button for Backpack")
    public void userClicksButtonFor(String buttonText) throws InterruptedException {

//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            // path
//            File destination = new File("screenshots/userClicksButtonForBackpack" + System.currentTimeMillis() + ".png");
//            org.apache.commons.io.FileUtils.copyFile(source, destination);
//            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
//        } catch (Exception e) {
//            System.out.println("Could not take screenshot: " + e.getMessage());
//        }

            homePage.clickAddToCartBackpack();
    }

    @Then("the button should change to {string}")
    public void theButtonShouldChangeTo(String buttonTextChangeRemove) {
//        try {
//            TakesScreenshot ts = (TakesScreenshot) driver;
//            File source = ts.getScreenshotAs(OutputType.FILE);
//            // path
//            File destination = new File("screenshots/theButtonShouldChangeToRemove" + System.currentTimeMillis() + ".png");
//            org.apache.commons.io.FileUtils.copyFile(source, destination);
//            System.out.println("Screenshot taken: " + destination.getAbsolutePath());
//        } catch (Exception e) {
//            System.out.println("Could not take screenshot: " + e.getMessage());
//        }

            homePage.validateRemoveButtonVisible();
    }

    @And("cart count should increase by {int}")
    public void cartCountShouldIncreaseBy(int count) {
        homePage.validateCartCount(count);
    }


}
