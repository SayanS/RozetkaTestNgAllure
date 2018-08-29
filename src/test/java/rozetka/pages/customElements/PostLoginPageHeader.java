package rozetka.pages.customElements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import rozetka.pages.*;

public class PostLoginPageHeader extends BasePage implements BasePageHeader {
    private WebDriver webDriver;

    public PostLoginPageHeader(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @FindBy(how = How.XPATH, using = "(//ul[@name='header-top-menu']/li/a)[1]")
    private WebElement headerMenuItemFaq;

    @FindBy(how = How.XPATH, using = "(//ul[@name='header-top-menu']/li/a)[2]")
    private WebElement headerMenuItemCredit;

    @FindBy(how = How.XPATH, using = "(//ul[@name='header-top-menu']/li/a)[3]")
    private WebElement headerMenuItemDeliveriesAndPayments;

    @FindBy(how = How.XPATH, using = "(//ul[@name='header-top-menu']/li/a)[4]")
    private WebElement headerMenuItemWarranty;

    @FindBy(how = How.XPATH, using = "(//ul[@name='header-top-menu']/li/a)[5]")
    private WebElement headerMenuItemContacts;

    @FindBy(id = "status_orders")
    private WebElement headerMenuItemOrderTracking;

    @FindBy(how = How.XPATH, using = "(//ul[@name='header-top-menu']/li/a)[7]")
    private WebElement headerMenuItemNewSeller;

    @FindBy(how = How.XPATH, xpath = "//a[@name='profile']")
    private WebElement headerPostloginUserTitle;


    @Step
    public FaqPreLoginPage selectHeaderMenuItemFaq() {
        headerMenuItemFaq.click();
        return new FaqPreLoginPage(webDriver);
    }

    @Step
    public CreditPreLoginPage selectHeaderMenuCredit() {
        headerMenuItemCredit.click();
        return new CreditPreLoginPage(webDriver);
    }

    @Step
    public DeliveriesAndPaymentsPreLoginPage selectHeaderMenuDeliveriesAndPayments() {
        headerMenuItemDeliveriesAndPayments.click();
        return new DeliveriesAndPaymentsPreLoginPage(webDriver);
    }

    @Step
    public WarrantyPreLoginPage selectHeaderMenuWarranty() {
        headerMenuItemWarranty.click();
        return new WarrantyPreLoginPage(webDriver);
    }

    @Step
    public ContactsPreLoginPage selectHeaderMenuContacts() {
        headerMenuItemContacts.click();
        return new ContactsPreLoginPage(webDriver);
    }

    @Step
    public MyOrdersPage selectHeaderMenuItemOrderTracking() {
        headerMenuItemOrderTracking.click();
        return new MyOrdersPage(webDriver);
    }

    @Step
    public PostLoginPageHeader ensureThatPostloginHeaderUserTitleIs(String expectedText) {
        Assert.assertEquals(headerPostloginUserTitle.getText(), expectedText);
        return this;
    }



}
