package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePageModel extends BaseModel {

    @FindBy(id = "edit-issue")
    WebElement editIssueButton;

    @FindBy(id = "description-val")
    WebElement descriptionValue;

    @FindBy(id = "opsbar-operations_more")
    WebElement moreButton;

    @FindBy(id = "delete-issue")
    WebElement deleteButton;


    public void clickEditIssueButton(){
        editIssueButton.click();
    }


    public void waitForMoreButtonToBeClickable(){
        moreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("opsbar-operations_more")));
    }


    public void clickMoreButton(){
        moreButton.click();
    }


    public void clickDeleteButton(){
        deleteButton.click();
    }


    public String getDescriptionValue(){
        return descriptionValue.getText();
    }


}
