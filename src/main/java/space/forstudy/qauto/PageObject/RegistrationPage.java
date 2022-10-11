package space.forstudy.qauto.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='hero-descriptor']/button[@class='hero-descriptor_btn btn btn-primary']")
    private WebElement ButtonRegistration;
    @FindBy(xpath = "//div[@class='modal-content']")
    private WebElement modalWindowRegistration;
    @FindBy(id = "signupName")
    private WebElement inputName;
    @FindBy(id = "signupLastName")
    private WebElement inputLastName;
    @FindBy(id = "signupEmail")
    private WebElement inputEmail;
    @FindBy(id = "signupPassword")
    private WebElement inputPassword;
    @FindBy(id = "signupRepeatPassword")
    private WebElement inputRepeatPassword;
    @FindBy(xpath = "//div[@class='modal-content']//button[@class='btn btn-primary']")
    private WebElement buttonRegistrationInModal;
    public RegistrationPage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public WebElement getInputName(){return inputName;}
    public WebElement getInputLastName(){return inputLastName;}
    public WebElement getInputEmail(){return inputEmail;}
    public WebElement getInputPassword(){
        return inputPassword;
    }
    public WebElement getInputRepeatPassword(){
        return inputRepeatPassword;
    }
    public WebElement getButtonRegistrationInModal(){
        return buttonRegistrationInModal;
    }
    public WebElement getModalWindowRegistration(){
        return modalWindowRegistration;
    }
    public WebElement getButtonRegistration(){
        return ButtonRegistration;
    }
}

