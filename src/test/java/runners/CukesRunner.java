package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {

        },
        features = {},
        glue = {},
        dryRun = false,
        tags = ""
)

public class CukesRunner {
}
