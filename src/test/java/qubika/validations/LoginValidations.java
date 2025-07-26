package qubika.validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginValidations {

    private static final By dashboardIndicator = By.xpath("//*[contains(text(),'Dashboard')]");
    private static final String DASHBOARD_URL = "/#/dashboard";

    public static void validateLoginSuccess(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIndicator));
        wait.until(ExpectedConditions.urlContains(DASHBOARD_URL));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(DASHBOARD_URL), "Redirección fallida post-login.");
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"), "Texto 'Dashboard' no encontrado.");
        System.out.println("[SUCCESS] Login exitoso y redirigido correctamente a: " + currentUrl);
    }
}
