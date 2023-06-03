package tek.capstone.dragons.runner;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//@RunWith is a JUnit Annotation
@RunWith(Cucumber.class)
@CucumberOptions(
		tags= "@Regression",
		features = ("classpath:features"),
		glue = "tek.capstone.dragons",
		dryRun = false,
		plugin = {
				"pretty",
				"html:target/htmlReports/capston-pretty.html",
				"json:target/jsonReports/capstone.json"
		},
		snippets = CAMELCASE,
		 monochrome = true
		)
public class TestRunner {

}
