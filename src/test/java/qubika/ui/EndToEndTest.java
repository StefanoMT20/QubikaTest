package qubika.ui;

import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import qubika.api.CreateUserAPI;
import qubika.flows.LoginFlow;
import qubika.flows.CategoryFlow;
import qubika.validations.CreateUserValidations;

import java.time.Duration;

public class EndToEndTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(groups = "end-to-end")
    public void completeFlowTest() {
        Response response = CreateUserAPI.createUser();
        CreateUserValidations.validateUserCreatedSuccessfully(response);

        LoginFlow.execute(driver, wait);
        CategoryFlow.createCategoryWithSubcategory(driver, wait);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
