package local.home.demo.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "local.home.demo.test.steps" },
        tags = "@robot",
        plugin = { "pretty", "html:target/robot_test.html" }
)
public class RobotTest extends AbstractTestNGCucumberTests {
}
