package StepDefinitions;

import io.cucumber.java.en.Given;

import static org.junit.Assert.assertEquals;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DynamicButtonClickSteps {

	WebDriver driver = null;

	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@And("user is on the buttons page")
	public void userIsOnTheButtonsPage() {
		// Open the buttons page
		driver.get("https://demoqa.com/buttons");
		System.out.println("Inside Step - user is on the Buttons Page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("user clicks on the {string} button")
	public void userClicksOnTheButton(String buttonText) {
		// Locate the button by its text and click it
		WebElement button = driver.findElement(By.xpath("//button[text()='" + buttonText + "']"));
		button.click();
		System.out.println("Inside Step - click on the " + buttonText + " button");
	}

    @Then("the message {string} should be displayed")
    public void theMessageShouldBeDisplayed(String expectedMessage) {
        // Locate the message element
        WebElement messageElement = driver.findElement(By.id("dynamicClickMessage"));
         
        // Assert the message text
        assertEquals(expectedMessage, messageElement.getText());
        System.out.println("Inside Step - the message " + expectedMessage + " should be displayed");
    }
    
    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
