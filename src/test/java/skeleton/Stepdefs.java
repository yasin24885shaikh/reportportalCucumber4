package skeleton;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;



public class Stepdefs {
	
	private Belly belly = new Belly();
	
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) {
        belly.eat(cukes);
    }
    
    @When("^I wait (\\d+) hour$")
    public void I_wait(int hours) {
    	belly.wait(hours);
    }
    
    @Then("^my belly should growl$")
    public void my_belly_should_growl() {
    	assertTrue(belly.growl());
    }
}
