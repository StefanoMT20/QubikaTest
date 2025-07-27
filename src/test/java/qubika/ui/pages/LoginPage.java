package qubika.ui.pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final String LOGIN_URL = "https://club-administration.qa.qubika.com/#/auth/login";
    public static final String DASHBOARD_URL = "/#/dashboard";

    public static final By emailInput = By.cssSelector("[formcontrolname='email']");
    public static final By passwordInput = By.cssSelector("input[formcontrolname='password']");
    public static final By loginButton = By.cssSelector("button[type='submit']");
    public static final By loginPageIndicator = By.xpath("//small[contains(text(),'Por favor ingrese correo y contraseña')]");
    public static final By dashboardIndicator = By.xpath("//*[contains(text(),'Dashboard')]");
}
