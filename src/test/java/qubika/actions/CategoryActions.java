package qubika.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategoryActions {

    private static final String CATEGORY_URL = "https://club-administration.qa.qubika.com/#/category-type";

    private static final By newCategoryButton = By.xpath("//button[contains(text(),'Adicionar')]");
    private static final By saveButton = By.xpath("//button[contains(text(),'Aceptar')]");
    private static final By categoryNameInput = By.id("input-username");
    private static final By subcategoryCheckbox = By.cssSelector(".custom-control-label");
    private static final By subcategorySelectInput = By.cssSelector("ng-select input[type='text']");
    private static final By subcategoryFirstOption = By.cssSelector(".ng-option");

    public static void goToCategoryPage(WebDriver driver, WebDriverWait wait) {
        driver.get(CATEGORY_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(newCategoryButton));
        System.out.println("[INFO] Página de categorías cargada correctamente.");
    }

    public static void createCategory(WebDriver driver, WebDriverWait wait, String categoryName) {
        wait.until(ExpectedConditions.presenceOfElementLocated(newCategoryButton));
        wait.until(ExpectedConditions.refreshed(
                ExpectedConditions.elementToBeClickable(newCategoryButton)
        )).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryNameInput)).sendKeys(categoryName);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        System.out.println("[ACTION] Categoría creada: " + categoryName);
    }

    public static void createSubcategory(WebDriver driver, WebDriverWait wait, String categoryName) {
        wait.until(ExpectedConditions.elementToBeClickable(newCategoryButton)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(categoryNameInput)).sendKeys(categoryName);

        wait.until(ExpectedConditions.elementToBeClickable(subcategoryCheckbox)).click();

        wait.until(ExpectedConditions.elementToBeClickable(subcategorySelectInput)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(subcategoryFirstOption));
        driver.findElements(subcategoryFirstOption).get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        System.out.println("[ACTION] Subcategoría creada: " + categoryName);
    }
}
