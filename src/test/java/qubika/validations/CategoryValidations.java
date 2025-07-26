package qubika.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CategoryValidations {

    private static final By paginationButtons = By.cssSelector("li.page-item");
    private static final By tableRows = By.cssSelector("tbody tr");

    private static void goToLastPageFromPagination(WebDriver driver, WebDriverWait wait) {
        wait.until(driver1 -> driver1.findElements(paginationButtons).stream()
                .anyMatch(e -> {
                    String text = e.getText().trim();
                    return !text.isEmpty() && text.matches("\\d+");
                }));

        List<WebElement> pages = driver.findElements(paginationButtons);

        List<WebElement> numberedPages = pages.stream()
                .filter(e -> {
                    try {
                        String text = e.getText().trim();
                        Integer.parseInt(text);
                        return true;
                    } catch (NumberFormatException ex) {
                        return false;
                    }
                })
                .toList();

        if (!numberedPages.isEmpty()) {
            WebElement lastPage = numberedPages.get(numberedPages.size() - 1).findElement(By.tagName("a"));
            wait.until(ExpectedConditions.elementToBeClickable(lastPage)).click();
            System.out.println("[INFO] Navegado al último número visible del paginador.");
        } else {
            System.out.println("[WARN] No se encontraron botones numéricos de paginación.");
        }
    }


    private static boolean isTextPresentInTable(WebDriver driver, String text) {
        List<WebElement> rows = driver.findElements(tableRows);
        for (WebElement row : rows) {
            if (row.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }

    public static void validateCategoryCreated(WebDriver driver, WebDriverWait wait, String categoryName) {
        goToLastPageFromPagination(driver, wait);
        wait.until(d -> isTextPresentInTable(d, categoryName));
        Assert.assertTrue(isTextPresentInTable(driver, categoryName), "Categoría no encontrada: " + categoryName);
        System.out.println("[SUCCESS] Categoría encontrada en la tabla: " + categoryName);
    }

    public static void validateSubcategoryCreated(WebDriver driver, WebDriverWait wait, String subcategoryName) {
        goToLastPageFromPagination(driver, wait);
        wait.until(d -> isTextPresentInTable(d, subcategoryName));
        Assert.assertTrue(isTextPresentInTable(driver, subcategoryName), "Subcategoría no encontrada: " + subcategoryName);
        System.out.println("[SUCCESS] Subcategoría encontrada en la tabla: " + subcategoryName);
    }
}
