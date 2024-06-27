package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddFormLaboratoriumPage {
    WebDriver driver;

    private By nameInput = new By.ByName("name");
    private By descInput = new By.ByName("description");
    private By typeSelect = new By.ByName("type");
    private By addButton = new By.ById("tambahButton");

    public AddFormLaboratoriumPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillField(String name, String desc, String type) {
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(descInput).sendKeys(desc);
        WebElement typeDropdown = driver.findElement(typeSelect);
        Select selectType = new Select(typeDropdown);
        selectType.selectByVisibleText(type);
    }

    public void clickSubmit(){
        driver.findElement(addButton).submit();
    }


}
