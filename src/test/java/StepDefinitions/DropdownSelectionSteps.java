package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

import java.time.Duration;

public class DropdownSelectionSteps {


	WebDriver driver = null;
	
    @Given("user is on the elements page")
    public void user_is_on_the_elements_page() {
		System.out.println("Inside Step - browser is open");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/elements");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user selects the 'Text Box' tab")
    public void user_selects_the_text_box_tab() {
        WebElement textBoxTab = driver.findElement(By.id("item-0")); // Update the locator if necessary
        textBoxTab.click();
    }

    @Then("the selected term should be 'Text Box' tab")
    public void the_selected_term_should_be_text_box_tab() {
    	WebElement textBoxHeader = driver.findElement(By.xpath("//h1[contains(text(),'Text Box')]"));
        assertNotNull("Text Box tab was not selected correctly.", textBoxHeader);
        driver.quit();
    }
    
    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
    
}
