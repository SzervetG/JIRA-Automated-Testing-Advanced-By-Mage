package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Utility.WebDriverManager;

public class ProjectPage extends Base {

    @FindBy(xpath = "//div[@class=\"aui-item project-title\"]/a[contains(@title,\"project\")]")
    WebElement projectName;

    public String getProjectName(){
        return projectName.getText();
    }

    public void waitForProjectNameToBeClickable(){
        waitUntilElementIsClickable("xpath", "//div[@class=\"aui-item project-title\"]/a[contains(@title,\"project\")]");
    }

}
