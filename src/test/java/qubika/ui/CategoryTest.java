package qubika.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import qubika.api.CreateUserAPI;
import qubika.actions.LoginActions;
import qubika.actions.CategoryActions;
import qubika.validations.CategoryValidations;

import java.time.Duration;
import java.util.UUID;

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
    public void createCategoryAndSubcategoryTest() throws InterruptedException {
        LoginActions.login(driver,wait);
        Thread.sleep(2000);

        CategoryActions.goToCategoryPage(driver, wait);

        String categoryName = "Cat_Piero_Meza" + UUID.randomUUID();
        CategoryActions.createCategory(driver, wait, categoryName);
        CategoryValidations.validateCategoryCreated(driver, wait, categoryName);

        String subcategoryName = "Sub_Piero_Meza" + UUID.randomUUID();
        CategoryActions.createSubcategory(driver, wait, subcategoryName);
        CategoryValidations.validateSubcategoryCreated(driver, wait, subcategoryName);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
