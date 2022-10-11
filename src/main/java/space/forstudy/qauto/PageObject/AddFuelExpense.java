package space.forstudy.qauto.PageObject;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddFuelExpense {
    WebDriver driver;
    @FindBy(css=".car.jumbotron")
    private WebElement CarCard;
    @FindBy(css = ".btn-success")
    private WebElement buttonAddFuelExpense;
    @FindBy(id = "addExpenseLiters")
    private WebElement inputNumberOfLiters;
    @FindBy(id = "addExpenseTotalCost")
    private WebElement inputTotalCosts;
    @FindBy(id = "addExpenseMileage")
    private WebElement changeInputMileage;
    @FindBy(xpath = "//div[@class='modal-footer d-flex justify-content-end']/button[@class='btn btn-primary']")
    private WebElement buttonAddAnExpense;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonInExpanses;
    public AddFuelExpense(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }
    public WebElement getChangeInputMileage() {

        return changeInputMileage;
    }
    public WebElement getInputNumberOfLiters(){
        return inputNumberOfLiters;
    }
    public WebElement getButtonAddAnExpense(){
        return buttonAddAnExpense;
    }
    public WebElement getInputTotalCosts(){
        return inputTotalCosts;
    }
    public WebElement getButtonAddFuelExpense(){
        return buttonAddFuelExpense;
    }

    public WebElement getCarCard(){
        return CarCard;
    }
    public WebElement getButtonInExpanses(){return buttonInExpanses;}
}
