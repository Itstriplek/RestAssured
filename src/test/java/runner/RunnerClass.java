package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
       features= {"src/test/resources/features/customer.feature"}, 
       glue = {"stepDefinition"},
       plugin = {"pretty", "html:target/Destination"} ) 
		
public class RunnerClass {

}
