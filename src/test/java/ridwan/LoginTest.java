package ridwan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ridwan.page.LoginPage;

public class LoginTest {

    @Test
    public void loginTest(){
        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.get("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();


    }
}
