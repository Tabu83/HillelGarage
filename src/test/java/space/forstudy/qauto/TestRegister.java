package space.forstudy.qauto;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import space.forstudy.qauto.PageObject.AddFuelExpense;
import space.forstudy.qauto.PageObject.DeleteUser;
import space.forstudy.qauto.PageObject.PageGarage;
import space.forstudy.qauto.PageObject.RegistrationPage;
import org.openqa.selenium.UsernameAndPassword;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;
import java.util.function.Predicate;

public class TestRegister {
    public String baseLogin = "guest";
    public String basePassword ="welcome2qauto";
    public String host = "qauto.forstudy.space";

    WebDriver driver;
    @BeforeTest

    public void setup(){

        String projectDir = System.getProperty("user.dir");
        String chromedriverPath = projectDir + "/src/main/WebDriver/Chrome/chromedriver";

        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
    }

    @Test
    public void Test_001_Registration(){

        RegistrationPage page = new RegistrationPage(driver);

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains(host);
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of(baseLogin, basePassword));

        driver.manage().window().maximize();

        driver.get("https://" + host);

        page.getButtonRegistration().click();

        assert page.getModalWindowRegistration().isDisplayed();

        page.getInputName().sendKeys("MyName");

        page.getInputLastName().sendKeys("MySurname");

        long unixTime = System.currentTimeMillis() / 1000L;
        System.out.println(unixTime);

        page.getInputEmail().sendKeys("test_"+unixTime+"@test.com");

        page.getInputPassword().sendKeys("ZCDajvoNExrqc65");

        page.getInputRepeatPassword().sendKeys("ZCDajvoNExrqc65");

        page.getButtonRegistrationInModal().click();

        assert new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.urlContains("/panel/garage"));
    }

    @Test
    public void Test_002_AddNewCar() {
        PageGarage page = new PageGarage(driver);

        page.getButtonAddAutoInHeader().click();

        page.getDropDownCarBrand().click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(page.getDropDownCarBrand()));

        page.getOptionPorsche().click();

        page.getDropDownCarModel().click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(page.getDropDownCarModel()));

        page.getOptionCayenne().click();

        page.getInputMileage().sendKeys("25");

        page.getButtonAddCar().click();


    }

    @Test
    public void  Test_003_AddExpenses(){
        AddFuelExpense page= new AddFuelExpense(driver);

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(page.getButtonAddFuelExpense()));

         page.getButtonAddFuelExpense().click();

        page.getChangeInputMileage().click();

        page.getChangeInputMileage().clear();

        page.getChangeInputMileage().sendKeys("50");

        page.getInputNumberOfLiters().sendKeys("30");

        page.getInputTotalCosts().sendKeys("100");

        page.getButtonAddAnExpense().click();


    }
@Test
    public void Test_004_AddExpenses_2(){
        AddFuelExpense page= new AddFuelExpense(driver);

    assert new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(ExpectedConditions.urlContains("panel/expenses"));

    page.getButtonInExpanses().click();

    page.getChangeInputMileage().click();

    page.getChangeInputMileage().clear();

    new WebDriverWait(driver, Duration.ofSeconds(3))
            .until(ExpectedConditions.elementToBeClickable(page.getChangeInputMileage()));

    page.getChangeInputMileage().sendKeys("80");

    page.getInputNumberOfLiters().sendKeys("40");

    page.getInputTotalCosts().sendKeys("70");

    page.getButtonAddAnExpense().click();
    }
@Test
    public void Test_005_DeleteUser(){

    DeleteUser page= new DeleteUser(driver);

    page.getButtonMyProfileInHeader().click();

    page.getTextSetting().click();

    page.getButtonDelete().click();

    page.getButtonRemove().click();

    driver.quit();
    }
}


