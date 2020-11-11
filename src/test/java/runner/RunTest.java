package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/order.feature:5",
glue = "step_definition", plugin={"json:target/cucumber-parallel/reports/cucumber-json-report.json","pretty","rerun:reports/failed.txt"}, strict = true)
public class RunTest {
}

