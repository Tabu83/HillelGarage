package space.forstudy.qauto.PageObject;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.URI;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class LoginPage {
  String modalWindow = ".modal-header";
  String SignInButton = "button.btn.btn-outline-white.header_signin";
  String inputLogin = "#signinEmail";
  String inputPassword = "#signinPassword";
  String labelRememberMe = ".form-check-label";
  String inputRememberMe = "#remember";
  String loginButton = ".modal-footer.d-flex.justify-content-between > .btn.btn-primary";
  String buttonForgotPassword = "//button[@_ngcontent-nrs-c51]";
  String baseLogin = "guest";
  String basePassword ="welcome2qauto";
  String host = "qauto.forstudy.space";



  @Test
  public void testLogin(){
    String projectDir = System.getProperty("user.dir");
    String chromedriverPath = projectDir + "/src/main/WebDriver/Chrome/chromedriver";

    System.setProperty("webdriver.chrome.driver", chromedriverPath);
    WebDriver driver = new ChromeDriver();

    driver.get("https://qauto.forstudy.space/");

    driver.manage().window().maximize();

    Predicate<URI> uriPredicate = uri -> uri.getHost().contains(host);
    ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of(baseLogin, basePassword));
    driver.get("https://"+host);

    WebElement loginButtonInHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(SignInButton)));

    loginButtonInHeader.click();

    WebElement modalWindows = new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(By.cssSelector(modalWindow)));

    WebElement login = driver.findElement(By.cssSelector(inputLogin));

    login.sendKeys("testmail2022@ukr.net");

    WebElement password = driver.findElement(By.cssSelector(inputPassword));

    password.sendKeys("hb6oKJmWeouvMo2");

    WebElement buttonLogin = driver.findElement(By.cssSelector(loginButton));

    buttonLogin.click();

    assert new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.urlContains("/panel/garage"));
    assert  driver.getTitle().equals("Hillel Qauto");

    driver.close();
    driver.quit();

  }
}


