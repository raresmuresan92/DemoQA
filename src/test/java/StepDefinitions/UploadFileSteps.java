package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import java.nio.file.Paths;
import java.time.Duration;

public class UploadFileSteps {

    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");
    String filePath = Paths.get(projectPath, "src", "test", "resources", "file.txt").toString(); 

    @Given("user is on the upload page")
    public void user_is_on_the_upload_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        driver.get("https://demoqa.com/upload-download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user uploads the file")
    public void user_uploads_the_file() {
        WebElement uploadInput = driver.findElement(By.id("fileInput")); // Replace with the ID of your file input element
        uploadInput.sendKeys(filePath);
    }

    @Then("the file should be uploaded successfully")
    public void the_file_should_be_uploaded_successfully() {
        WebElement uploadedFileName = driver.findElement(By.id("uploadedFileName")); // Replace with the ID of the element displaying uploaded file name
        String actualFileName = uploadedFileName.getText();
        assertTrue("File was not uploaded successfully", actualFileName.contains("file.txt")); // Adjust based on your actual file name
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
