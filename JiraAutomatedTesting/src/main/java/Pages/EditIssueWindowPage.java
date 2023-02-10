package Pages;

import Utility.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class EditIssueWindowPage extends Base {

    WebDriverManager webDriverManager = new WebDriverManager();
    IssuePage issuePage = new IssuePage();

    @FindBy(id = "edit-issue-submit")
    WebElement confirmEditIssueButton;

    @FindBy(id = "summary")
    WebElement summaryField;

    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    WebElement cancelButton;


    private String edited = " Edited";


    public String getSummaryFieldValue(){
        try {
            return summaryField.getAttribute("value");
        } catch (StaleElementReferenceException e){
            By newSummary = By.id("summary");
            return webDriver.findElement(newSummary).getAttribute("value");
        }
    }


    public String getEdited(){
        return edited;
    }


    public void waitForEditButtonToBeClickable(){
        confirmEditIssueButton = waitUntilElementIsClickable("id", "edit-issue-submit");
    }


    public void waitForSummaryFieldToBeClickable(){
        summaryField = waitUntilElementIsClickable("id", "summary");
    }


    public void waitForCancelButtonToBeClickable(){
        cancelButton = waitUntilElementIsClickable("xpath", "//button[text()=\"Cancel\"]");
    }

    public void clickEditIssueButton(){
        try {
            confirmEditIssueButton.click();
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e){
            waitForEditButtonToBeClickable();
            confirmEditIssueButton.click();
        }
    }


    public void clickCancelButton(){
        try {
            cancelButton.click();
        } catch (NoSuchElementException | StaleElementReferenceException | ElementNotInteractableException e){
            waitForCancelButtonToBeClickable();
            cancelButton.click();
        }
    }


    public void editIssue(String issueUrl){
        webDriverManager.openWebPage(issueUrl);
        issuePage.waitForEditButtonToBeClickable();
        issuePage.clickEditIssueButton();
        waitForSummaryFieldToBeClickable();
        String editedSummary = getSummaryFieldValue() + edited;
        overWriteFieldToSpecifiedValue(summaryField, editedSummary);
        clickEditIssueButton();
    }


    public void resetEditedIssueToOriginal(){
        issuePage.waitForEditButtonToBeClickable();
        issuePage.clickEditIssueButton();
        waitForSummaryFieldToBeClickable();
        summaryField.click();
        deleteLastXCharactersOfFieldText(summaryField, edited.length());
        waitForEditButtonToBeClickable();
        clickEditIssueButton();
    }


    private void deleteLastXCharactersOfFieldText(WebElement field, int X){
        field.sendKeys(Keys.CONTROL, Keys.ARROW_DOWN);
        for (int time = 0; time < X; time++){
            field.sendKeys(Keys.BACK_SPACE);
        }
    }

}
