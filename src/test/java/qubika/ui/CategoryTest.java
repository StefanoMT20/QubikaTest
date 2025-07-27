package qubika.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import qubika.api.CreateUserAPI;
import qubika.flows.LoginFlow;
import qubika.flows.CategoryFlow;

import java.time.Duration;

public class CategoryTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        CreateUserAPI.createUser();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void createCategoryAndSubcategoryTest() {
        LoginFlow.execute(driver, wait);
        CategoryFlow.createCategoryWithSubcategory(driver, wait);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}