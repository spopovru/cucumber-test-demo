package local.home.demo.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = { "local.home.demo.test.steps" },
        tags = "@arena",
        plugin = { "pretty", "html:target/arena_test.html" }
)
public class ArenaTest extends AbstractTestNGCucumberTests {
}
