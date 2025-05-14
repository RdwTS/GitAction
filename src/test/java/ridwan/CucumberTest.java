package ridwan;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = ("ridwan"),
        features = ("src/test/resources/checkout.feature"),
        plugin = {"pretty","html:reports/checkoutCucumber.html", "json:reports/checkoutCucumber.json"}
)

public class CucumberTest {


}
