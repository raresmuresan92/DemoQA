package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;
import static org.junit.Assert.*;
import java.nio.file.Paths;
import java.time.Duration;

public class UploadFileSteps {

    WebDriver driver = null;
    String projectPath = System.getProperty("user.dir");
    String filePath = Paths.get(projectPath, "src", "test", "resources", "file.txt").toString(); // Adjust the file path

    @Given("user is on the upload page")
    public void user_is_on_the_upload_page() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/upload-download");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @When("user uploads the file")
    public void user_uploads_the_file() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement chooseFileButton = driver.findElement(By.id("uploadFile"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        chooseFileButton.sendKeys(filePath);
    }

    @Then("the file should be uploaded successfully")
    public void the_file_should_be_uploaded_successfully() {
        WebElement uploadedFilePathElement = driver.findElement(By.xpath("//p[@id='uploadedFilePath']"));
        String uploadedFilePath = uploadedFilePathElement.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Uploaded file path: " + uploadedFilePath); // Log the actual uploaded file path
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String fileName = Paths.get(filePath).getFileName().toString(); // Extract the file name
        assertTrue("Uploaded file path is not displayed correctly", uploadedFilePath.contains(fileName));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
