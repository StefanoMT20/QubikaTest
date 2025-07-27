package qubika.validations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static qubika.ui.pages.LoginPage.*;

public class LoginValidations {

    public static void validateLoginSuccess(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIndicator));
        wait.until(ExpectedConditions.urlContains(DASHBOARD_URL));

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(DASHBOARD_URL), "Redirección fallida post-login.");
        Assert.assertTrue(driver.getPageSource().contains("Dashboard"), "Texto 'Dashboard' no encontrado.");
        System.out.println("[SUCCESS] Login exitoso y redirigido correctamente a: " + currentUrl);
    }

    public static void validateLoginPageElements(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageIndicator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));

        Assert.assertTrue(driver.findElement(loginPageIndicator).isDisplayed(), "Indicador de página de login no visible.");
        Assert.assertTrue(driver.findElement(emailInput).isDisplayed(), "Campo de email no visible.");
        Assert.assertTrue(driver.findElement(passwordInput).isDisplayed(), "Campo de contraseña no visible.");
        Assert.assertTrue(driver.findElement(loginButton).isDisplayed(), "Botón de login no visible.");

        System.out.println("[VALIDATION] Todos los elementos de la página de login están visibles.");
    }
}
