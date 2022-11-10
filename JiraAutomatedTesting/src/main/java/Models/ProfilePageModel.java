package Models;

import Models.BaseModel.BaseModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePageModel extends BaseModel {

    @FindBy(id = "up-d-username")
    WebElement usernameData;

    public String getUsernameDataValue(){
        return usernameData.getText();
    }
}
