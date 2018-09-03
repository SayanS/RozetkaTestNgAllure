package rozetka.pages.popups;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import rozetka.pages.BasePage;
import rozetka.pages.GoogleSignInPage;
import rozetka.pages.MyOrdersPage;

public class AuthPopUp extends BasePage {
    WebDriver webDriver;

    public AuthPopUp(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }

    public String loginField1="//input[@name='login']";

    @FindBy(how=How.XPATH, xpath="//input[@name='login']")
    private WebElement loginField;

    @FindBy(how=How.XPATH, xpath="//div[@name='simple_auth']//input[@name='password']")
    private WebElement passwordField;

    @FindBy(how=How.XPATH, xpath="//div[@name='simple_auth']//input[@name='remember']/following-sibling::span")
    private WebElement rememberMeCheckbox;

    @FindBy(how=How.XPATH, xpath="//a[@name='forgot_button']")
    private WebElement forgotPasswordButton;

    @FindBy(how=How.XPATH, xpath="//button[@name='auth_submit']")
    private WebElement submitButton;

    @FindBy(how=How.XPATH, xpath="//a[@name='close']")
    private WebElement cancelButton;

    @FindBy(how=How.XPATH, xpath="//a[@class='novisited auth-f-signup-link']")
    private WebElement signUpButton;

    @FindBy(how=How.XPATH, xpath="//a[@id='social_href_facebook']")
    private WebElement facebookButton;

    @FindBy(how=How.XPATH, xpath="//a[@id='social_href_google']")
    private WebElement googleButton;

    @FindBy(how = How.XPATH, xpath = "//h5[@class='auth-title']")
    private WebElement title;

    @Step
    public MyOrdersPage signInWithValidCredentials(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MyOrdersPage(webDriver);
    }

    @Step
    public AuthPopUp signInWithInvalidCredentials(String login, String password){
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
        return this;
    }

    @Step
    public String getTitle(){
        return title.getText();
    }

    @Step
    public AuthPopUp ensureThatTitleIs(String expectedTitle) {
        Assert.assertEquals(getTitle(), expectedTitle);
        return this;
    }

    @Step
    public GoogleSignInPage clickOnGoogleSignInButton(){
        googleButton.click();
        return new GoogleSignInPage(webDriver);
    }
}
