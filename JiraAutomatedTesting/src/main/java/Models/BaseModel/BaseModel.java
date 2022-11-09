package Models;

import Utility.ConstantData;
import Utility.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    WebElement usernameField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;

    @FindBy(id = "login")
    WebElement loginButton;

    @FindBy(id = "header-details-user-fullname")
    WebElement profilePicture;


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
        usernameField.sendKeys(username);
    }


    protected void setPassword(String password){
        passwordField.sendKeys(password);
    }


    protected void clickLoginButton(){
        loginButton.click();
    }


    protected void waitForUsernameFieldToBeClickable(){
//        usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-form-username")));
        usernameField = waitUntilElementIsClickable("id", "login-form-username");
    }


    private void waitForProfilePictureToBeClickable(){
//        profilePicture = wait.until(ExpectedConditions.elementToBeClickable(By.id("header-details-user-fullname")));
        profilePicture = waitUntilElementIsClickable("id", "header-details-user-fullname");
    }


    public WebElement waitUntilElementIsClickable(String searchType, String searchElementBy) {
        WebElement result = null;
        switch (searchType) {
            case "id":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.id(searchElementBy)));
                break;
            case "xpath":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(searchElementBy)));
                break;
            case "cssSelector":
                result = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(searchElementBy)));
                break;
        }
        return result;
    }
}
