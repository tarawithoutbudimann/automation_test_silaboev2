package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EditLaboratoriumPage {
    WebDriver driver;
    private By nameInput = new By.ByName("name");
    private By descInput = new By.ByName("description");
    private By typeSelect = new By.ByName("type");
    private By updateButton = new By.ById("updateButton");

    public EditLaboratoriumPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFieldEdit(String name, String desc, String type) {
        if (this.driver == null) {
            throw new IllegalStateException("WebDriver instance is null");
        }

        driver.findElement(nameInput).clear();
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(descInput).clear();
        driver.findElement(descInput).sendKeys(desc);

        WebElement typeDropdown = driver.findElement(typeSelect);
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText(type);
    }

    public void editFormSubmit(){
        driver.findElement(updateButton).submit();
    }
}
