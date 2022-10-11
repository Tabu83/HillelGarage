package space.forstudy.qauto.PageObject;

import io.opentelemetry.api.baggage.propagation.W3CBaggagePropagator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteUser {

    WebDriver driver;
    @FindBy(id = "userNavDropdown")
    private WebElement buttonMyProfileInHeader;
    @FindBy(linkText = "Settings")
    private WebElement textSetting;
    @FindBy(xpath = "//div[@class='user-settings_form']/button[@class='btn btn-danger-bg']")
    private WebElement buttonDelete;
    @FindBy(xpath ="//div[@class='modal-footer d-flex justify-content-end']/button[@class='btn btn-danger']")
    private WebElement buttonRemove;
    public DeleteUser(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public WebElement getButtonMyProfileInHeader() {
        return buttonMyProfileInHeader;
    }
    public WebElement getTextSetting() {
        return textSetting;
    }
    public WebElement getButtonDelete(){
        return buttonDelete;
    }
    public WebElement getButtonRemove(){
        return buttonRemove;
    }
}
