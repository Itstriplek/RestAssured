package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
       features= {"src/test/resources/feature/customer.feature"},  
       tags= {"@Scenario1"},
       glue = {"stepDefinition"}) 
public class RunnerClass {

}
