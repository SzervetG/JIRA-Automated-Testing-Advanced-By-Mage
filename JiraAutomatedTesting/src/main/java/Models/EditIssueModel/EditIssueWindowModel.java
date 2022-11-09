package Models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditIssueWindowModel {

    @FindBy(id = "edit-issue-submit")
    WebElement editIssueButton;

    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    WebElement cancelButton;


    @FindBy(xpath = "//iframe")
    WebElement descriptionFrame;


    WebDriver driver;


    public void clickEditIssueButton(){
        editIssueButton.click();
    }


    public void clickCancelButton(){
        cancelButton.click();
    }


    public void changeToDescriptionFrame(){
        driver.switchTo().frame(descriptionFrame);
    }
}
