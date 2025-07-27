package qubika.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qubika.utils.UserData;

import static qubika.ui.pages.LoginPage.*;

public class LoginActions {

    public static void navigateToLogin(WebDriver driver, WebDriverWait wait) {
        driver.get(LOGIN_URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageIndicator));
        System.out.println("[INFO] Página de login cargada correctamente.");
    }

    public static void performLogin(WebDriver driver, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
        driver.findElement(emailInput).sendKeys(UserData.email);
        driver.findElement(passwordInput).sendKeys(UserData.password);
        driver.findElement(loginButton).click();
    }
}
