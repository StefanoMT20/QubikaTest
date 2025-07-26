package qubika.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qubika.utils.UserData;

public class LoginActions {

    private static final String LOGIN_URL = "https://club-administration.qa.qubika.com/#/auth/login";
    private static final By emailInput = By.cssSelector("[formcontrolname='email']");
    private static final By passwordInput = By.cssSelector("input[formcontrolname='password']");
    private static final By loginButton = By.cssSelector("button[type='submit']");
    private static final By loginPageIndicator = By.xpath("//small[contains(text(),'Por favor ingrese correo y contraseña')]");

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

    public static void login(WebDriver driver, WebDriverWait wait) {
        navigateToLogin(driver, wait);
        performLogin(driver, wait);
    }
}
