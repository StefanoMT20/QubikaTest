package qubika.flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import qubika.actions.LoginActions;
import qubika.validations.LoginValidations;

public class LoginFlow {

    public static void execute(WebDriver driver, WebDriverWait wait) {
        LoginActions.navigateToLogin(driver, wait);
        LoginValidations.validateLoginPageElements(driver, wait);
        LoginActions.performLogin(driver, wait);
        LoginValidations.validateLoginSuccess(driver, wait);

        System.out.println("[FLOW] Login completado correctamente.");
    }
}
