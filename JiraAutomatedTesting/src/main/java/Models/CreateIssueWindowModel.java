package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.UUID;

public class CreateIssueWindowModel extends BaseModel {

    @FindBy(id = "project-field")
    WebElement projectField;

    @FindBy(xpath = "//input[@id=\"issuetype-field\"]")
    WebElement issueTypeField;

    @FindBy(id = "summary")
    WebElement summaryField;

    @FindBy(id = "create-issue-submit")
    WebElement createIssueButton;

    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    WebElement cancelButton;


    @FindBy(xpath = "//iframe")
    WebElement descriptionFrame;


    WebDriver driver;

    private String randomUuid;


    public CreateIssueWindowModel(){
        randomUuid = setRandomUuid();
    }


    public String getRandomUuid(){
        return this.randomUuid;
    }


    public void waitForProjectFieldToBeClickable(){
        projectField = wait.until(ExpectedConditions.elementToBeClickable(By.id("project-field")));
    }


    public void setProjectField(String projectName){
        projectField.sendKeys(projectName);
    }


    public void setIssueTypeField(String issueType){
        issueTypeField.sendKeys(issueType);
    }


    public void setSummaryField(String summary){
        summaryField.sendKeys(summary);
    }


    public void clickCreateIssueButton(){
        createIssueButton.click();
    }


    public void clickCancelButton(){
        cancelButton.click();
    }


    public void changeToDescriptionFrame(){
        driver.switchTo().frame(descriptionFrame);
    }

    public String setRandomUuid(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
