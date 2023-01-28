package Pages;

import Pages.BaseModel.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends Base {

    @FindBy(id = "up-d-username")
    WebElement usernameData;

    public String getUsernameDataValue(){
        return usernameData.getText();
    }
}
