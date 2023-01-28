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


    public BaseModel(){
        WebDriverManager webDriverManager = new WebDriverManager();
        this.webDriver = webDriverManager.getWebDriver();
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        PageFactory.initElements(webDriver, this);
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
