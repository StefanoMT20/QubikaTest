package qubika.flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qubika.actions.CategoryActions;
import qubika.validations.CategoryValidations;

import java.util.UUID;

public class CategoryFlow {

    public static void createCategoryWithSubcategory(WebDriver driver, WebDriverWait wait) {
        CategoryActions.goToCategoryPage(driver, wait);

        String categoryName = "Cat_Piero_Meza_" + UUID.randomUUID();
        CategoryActions.createCategory(driver, wait, categoryName);
        CategoryValidations.validateCategoryCreated(driver, wait, categoryName);

        String subcategoryName = "Sub_Piero_Meza_" + UUID.randomUUID();
        CategoryActions.createSubcategory(driver, wait, subcategoryName);
        CategoryValidations.validateSubcategoryCreated(driver, wait, subcategoryName);

        System.out.println("[FLOW] Categoría y subcategoría creadas correctamente.");
    }
}
