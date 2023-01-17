package automation;

import org.junit.Test;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports" }, features = "src/main/resources/features")
public class RunTests {
	@Test
	public void tests() {
	}
}
