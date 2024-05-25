package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import static org.junit.Assert.*;

import java.time.Duration;

public class DatePickerSteps {

    WebDriver driver = null;
    String initialSelectedDate = null;

    @Given("user is on the date picker page")
    public void user_is_on_the_date_picker_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
        driver.get("https://demoqa.com/date-picker");

        // Retrieve the initial selected date
        WebElement datePickerInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datePickerMonthYearInput")));
        initialSelectedDate = datePickerInput.getAttribute("value");
    }

    @When("user selects a new date")
    public void user_selects_a_new_date() {
        // Click the date picker input to open the calendar
        WebElement datePickerInput = driver.findElement(By.id("datePickerMonthYearInput"));
        datePickerInput.click();

        // Select the specified day (Sunday, May 26th, 2024)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
        WebElement dateToSelect = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Choose Sunday, May 26th, 2024']")));
        dateToSelect.click();
    }

    @Then("the selected date should change to the new date")
    public void the_selected_date_should_change_to_the_new_date() {
        // Retrieve the updated selected date
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait
        WebElement datePickerInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("datePickerMonthYearInput")));
        String updatedSelectedDate = datePickerInput.getAttribute("value");

        // Verify if the selected date has changed
        assertNotEquals("Selected date has not changed", initialSelectedDate, updatedSelectedDate);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
