package ridwan.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import ridwan.BaseTest;
import ridwan.page.LoginPage;

public class LoginStep extends BaseTest{

    LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage(){
        loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
    }

    @When("user click login button")
    public void userClickLogInButton(){
        loginPage.clickLoginButton();
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.inputPassword(password);
    }

    @And("user able to see error message {string}")
    public void userSeeErrorMessage(String errorMessage) {
        loginPage.validateErrorAppear(errorMessage);
    }
}
