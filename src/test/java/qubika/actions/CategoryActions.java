package qubika.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static qubika.ui.pages.CategoryPage.*;

public class CategoryActions {

    public static void goToCategoryPage(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(categoryLink)).click();
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
