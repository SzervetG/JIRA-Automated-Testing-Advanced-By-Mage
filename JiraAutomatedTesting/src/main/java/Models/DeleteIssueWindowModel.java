package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteIssueWindowModel extends BaseModel {

    @FindBy(id = "delete-issue-submit")
    WebElement confirmDeleteButton;

    public void waitForConfirmDeleteButtonToBeClickable(){
        confirmDeleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("delete-issue-submit")));
    }


    public void clickDeleteConfirmationButton(){
        confirmDeleteButton.click();
    }
}