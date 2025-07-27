package qubika.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import qubika.api.CreateUserAPI;
import qubika.flows.LoginFlow;
import qubika.validations.CreateUserValidations;

import java.time.Duration;

public class LoginTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        Response response = CreateUserAPI.createUser();
        CreateUserValidations.validateUserCreatedSuccessfully(response);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void loginWithNewUser() {
        LoginFlow.execute(driver, wait);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}