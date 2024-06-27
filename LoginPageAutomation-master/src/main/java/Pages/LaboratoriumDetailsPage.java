package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaboratoriumDetailsPage {
    WebDriver driver;
    private By editButton = new By.ById("editButton");
    private By deleteButton = new By.ById("hapusButton");
    public LaboratoriumDetailsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void editPageClick(){
        driver.findElement(editButton).click();
    }

    public void deleteSubmit(){
        driver.findElement(deleteButton).submit();
    }

}
