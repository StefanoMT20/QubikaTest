package qubika.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import qubika.api.CreateUserAPI;
import qubika.actions.LoginActions;
import qubika.actions.CategoryActions;
import qubika.validations.CategoryValidations;
import qubika.validations.CreateUserValidations;
import io.restassured.response.Response;

import java.time.Duration;

public class EndToEndTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(groups = "end-to-end")
    public void completeFlowTest() {
        Response response = CreateUserAPI.createUser();
        CreateUserValidations.validateUserCreatedSuccessfully(response);

        LoginActions.login(driver, wait);

        String categoryName = "Piero_Meza_Test_Category" + System.currentTimeMillis();
        CategoryActions.goToCategoryPage(driver, wait);;
        CategoryActions.createCategory(driver, wait, categoryName);
        CategoryValidations.validateCategoryCreated(driver, wait, categoryName);

        String subcategoryName = "Piero_Meza_Test_Sub_Category" + System.currentTimeMillis();
        CategoryActions.createSubcategory(driver, wait, subcategoryName);
        CategoryValidations.validateSubcategoryCreated(driver, wait, subcategoryName);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
