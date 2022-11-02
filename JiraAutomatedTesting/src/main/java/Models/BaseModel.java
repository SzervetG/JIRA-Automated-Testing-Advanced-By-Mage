package Models;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseModel {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected String USERNAME = System.getProperty("jiraUser");
    protected String PASSWORD = System.getProperty("jiraPass");

    @FindBy(id = "login-form-username")
    WebElement usernameField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    WebElement profilePicture;


    public String getUSERNAME() {
        return USERNAME;
    }


    public String getPASSWORD() {
        return PASSWORD;
    }



    protected void login(){
        waitForUsernameFieldToBeClickable();
        setUsername(USERNAME);
        setPassword(PASSWORD);
        clickLoginButton();
        waitForProfilePictureToBeClickable();
    }


    protected void setUsername(String username){
        usernameField.sendKeys(username);
    }


    protected void setPassword(String password){
        passwordField.sendKeys(password);
    }


    protected void clickLoginButton(){
        loginButton.click();
    }


    protected void waitForUsernameFieldToBeClickable(){
        usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-username")));
    }


    private void waitForProfilePictureToBeClickable(){
        profilePicture = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-details-user-fullname")));
    }
}
