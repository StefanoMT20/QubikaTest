package qubika.ui.pages;

import org.openqa.selenium.By;

public class CategoryPage {
    public static final By categoryLink = By.cssSelector("a.nav-link[href*='#/category-type']");
    public static final By newCategoryButton = By.xpath("//button[contains(text(),'Adicionar')]");
    public static final By saveButton = By.xpath("//button[contains(text(),'Aceptar')]");
    public static final By categoryNameInput = By.id("input-username");
    public static final By subcategoryCheckbox = By.cssSelector(".custom-control-label");
    public static final By subcategorySelectInput = By.cssSelector("ng-select input[type='text']");
    public static final By subcategoryFirstOption = By.cssSelector(".ng-option");
    public static final By paginationButtons = By.cssSelector("li.page-item");
    public static final By tableRows = By.cssSelector("tbody tr");
}