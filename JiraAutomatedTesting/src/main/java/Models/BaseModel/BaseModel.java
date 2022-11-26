package Models.BaseModel;

import Utility.ConstantData;
import Utility.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseModel {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected String USERNAME = ConstantData.jiraUser;
    protected String PASSWORD = ConstantData.jiraPass;

    @FindBy(id = "login-form-username")
    protected WebElement usernameField;

    @FindBy(id = "login-form-password")
    protected WebElement passwordField;

    @FindBy(id = "login")
    protected WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    protected WebElement profilePicture;


    public BaseModel(){
        WebDriverManager webDriverManager = new WebDriverManager();
        this.webDriver = webDriverManager.getWebDriver();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(webDriver, this);
    }


    public String getUSERNAME() {
        return USERNAME;
    }


    public String getPASSWORD() {
        return PASSWORD;
    }



    protected void baseLogin(){
        waitForUsernameFieldToBeClickable();
        setUsername(USERNAME);
        setPassword(PASSWORD);
        clickLoginButton();
        waitForProfilePictureToBeClickable();
    }


    protected void setUsername(String username){
        try{
            usernameField.sendKeys(username);
        } catch (StaleElementReferenceException e){
            waitForUsernameFieldToBeClickable();
            usernameField.sendKeys(username);
        }
    }


    protected void setPassword(String password){
        try {
            passwordField.sendKeys(password);
        } catch (StaleElementReferenceException e){
            passwordField = waitUntilElementIsClickable("id", "login-form-password");
            passwordField.sendKeys(password);
        }
    }


    protected void clickLoginButton(){
        loginButton.click();
    }


    protected void waitForUsernameFieldToBeClickable(){
        usernameField = waitUntilElementIsClickable("id", "login-form-username");
    }


    private void waitForProfilePictureToBeClickable(){
        profilePicture = waitUntilElementIsClickable("id", "header-details-user-fullname");
    }


    public WebElement waitUntilElementIsClickable(String searchElementBy, String searchValue) {
        WebElement result = null;
        switch (searchElementBy) {
            case "id":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.id(searchValue)));
                break;
            case "xpath":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchValue)));
                break;
            case "cssSelector":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchValue)));
                break;
            case "className":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.className(searchValue)));
                break;
        }
        return result;
    }


    protected void overWriteFieldToSpecifiedValue(WebElement field, String specifiedValue){
        field.click();
        field.sendKeys(Keys.CONTROL, "a");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(specifiedValue);
        field.sendKeys(Keys.TAB);
    }
}
