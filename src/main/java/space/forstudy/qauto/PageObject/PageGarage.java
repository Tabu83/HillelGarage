package space.forstudy.qauto.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageGarage {
    WebDriver driver;
    @FindBy(css = ".btn.btn-primary")
    private WebElement buttonAddAutoInHeader;
    @FindBy(css = ".btn.btn-primary")
    private WebElement modalWindowAddCar;
    @FindBy(id = "addCarBrand")
    private WebElement dropDownCarBrand;
    @FindBy(xpath = "//select[@id='addCarBrand']/option[4]")
    private WebElement optionPorsche;
    @FindBy(id = "addCarModel")
    private WebElement dropDownCarModel;
    @FindBy(xpath = "//select[@id='addCarModel']/option[2]")
    private WebElement optionCayenne;
    @FindBy(id = "addCarMileage")
    private WebElement inputMileage;
    @FindBy(xpath = "//div[@class='modal-content']//button[@class='btn btn-primary']")
    private WebElement buttonAddCar;


    public PageGarage(WebDriver driver){

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    public WebElement getModalWindowAddCar(){
        return modalWindowAddCar;
    }
    public WebElement getButtonAddAutoInHeader(){
        return buttonAddAutoInHeader;
    }
    public WebElement getDropDownCarBrand(){
        return dropDownCarBrand;
    }
    public WebElement getDropDownCarModel() {
        return dropDownCarModel;
    }
    public WebElement getInputMileage() {
        return inputMileage;
    }
    public WebElement getButtonAddCar() {
        return buttonAddCar;
    }
    public WebElement getOptionPorsche() {
        return optionPorsche;
    }
    public WebElement getOptionCayenne() {
        return optionCayenne;
    }
}

