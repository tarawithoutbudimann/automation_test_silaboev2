package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LaboratoriumPage {

    WebDriver driver;
    private By laboratoriumSidebar = new By.ById("laboratoriumSide");
    private By addLaboratoriumButton = new By.ById("addLaboratorium");
    private By detailsButton = new By.ById("1");

    public LaboratoriumPage(WebDriver driver) {
        this.driver = driver;
    }

    public void laboratoriumPageClick(){
        driver.findElement(laboratoriumSidebar).click();
    }
    public void addLaboratoriumClick(){
        driver.findElement(addLaboratoriumButton).click();
    }

    public void detailsPage(){
        driver.findElement(detailsButton).click();
    }

}
