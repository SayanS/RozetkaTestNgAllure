package rozetka.pages.customElements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import rozetka.pages.*;
import rozetka.pages.popups.AuthPopUp;

public abstract class PageHeader extends BasePage {
    private WebDriver webDriver;

    public PageHeader(WebDriver webDriver) {
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

    @FindBy(how = How.XPATH, xpath = "//a[@name='signin']")
    private WebElement headerUserTitle;

    @Step
    public FaqPage selectHeaderMenuItemFaq() {
        headerMenuItemFaq.click();
        return new FaqPage(webDriver);
    }

    @Step
    public CreditPage selectHeaderMenuCredit() {
        headerMenuItemCredit.click();
        return new CreditPage(webDriver);
    }

    @Step
    public DeliveriesAndPaymentsPage selectHeaderMenuDeliveriesAndPayments() {
        headerMenuItemDeliveriesAndPayments.click();
        return new DeliveriesAndPaymentsPage(webDriver);
    }

    @Step
    public WarrantyPage selectHeaderMenuWarranty() {
        headerMenuItemWarranty.click();
        return new WarrantyPage(webDriver);
    }

    @Step
    public ContactsPage selectHeaderMenuContacts() {
        headerMenuItemContacts.click();
        return new ContactsPage(webDriver);
    }

    @Step
    public AuthPopUp selectPreLoginHeaderMenuOrderTracking() {
        headerMenuItemOrderTracking.click();
        return new AuthPopUp(webDriver);
    }

    @Step
    public MyOrdersPage selectPostLoginHeaderMenuOrderTracking() {
        headerMenuItemOrderTracking.click();
        return new MyOrdersPage(webDriver);
    }

    @Step
    public void ensureThatHeaderUserTitleIs(String expectedText) {
        Assert.assertEquals(headerUserTitle.getText(), "войдите в личный кабинет");
    }


}
