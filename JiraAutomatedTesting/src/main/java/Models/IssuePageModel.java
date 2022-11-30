package Models;

import Utility.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IssuePageModel extends BaseModel {

    WebDriverManager webDriverManager = new WebDriverManager();

    @FindBy(id = "edit-issue")
    WebElement editIssueButton;

    @FindBy(id = "description-val")
    WebElement descriptionValue;

    @FindBy(id = "opsbar-operations_more")
    WebElement moreButton;

    @FindBy(id = "delete-issue")
    WebElement deleteButton;

    @FindBy(className = "issue-link")
    WebElement issueKey;


    @FindBy(xpath = "//*[@id=\"issue-content\"]/div/div/h1")
    WebElement issueNotFoundErrorMessage;


    public void clickEditIssueButton() {
        editIssueButton.click();
    }


    public void waitForMoreButtonToBeClickable() {
        moreButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("opsbar-operations_more")));
    }


    public void clickMoreButton() {
        moreButton.click();
    }


    public void clickDeleteButton() {
        deleteButton.click();
    }


    public String getDescriptionValue() {
        return descriptionValue.getText();
    }

    public String getIssueKey() {
        return issueKey.getText();
    }

    public void openExistingIssue(String projectUrl) {
        webDriverManager.openWebPage(projectUrl);
    }

    public void openNonExistingIssue(String projectUrl) {
        webDriverManager.openWebPage(projectUrl);
    }


    public void projectKeyIsVisible() {
        issueKey.isDisplayed();
    }

    public String getIssueNotFoundErrorMessageText() {
        return issueNotFoundErrorMessage.getText();
    }


}
