package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditIssueDescriptionFrameModel {

    WebDriver driver;

    @FindBy(id = "tinymce")
    WebElement descriptionField;


    public void setDescriptionField(String description){
        descriptionField.sendKeys(description);
    }


    public void changeBackToOriginalFrame(){
        driver.switchTo().defaultContent();
    }


}
