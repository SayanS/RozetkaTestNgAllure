package rozetka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import rozetka.pages.customElements.BasePageHeader;
import rozetka.utils.FilesUtils;

public class FaqPage extends BasePage {
    private WebDriver webDriver;
    private BasePageHeader basePageHeader;

    public FaqPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/faq/";
        this.webDriver = webDriver;
        this.basePageHeader = new BasePageHeader(webDriver);
    }

    public BasePageHeader getBasePageHeader() {
        return this.basePageHeader;
    }

    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement title;

    @Step
    public String getTitle() {
        return title.getText();
    }

    @Step
    public void enssureThatTitleIs(String expectedPageTitle) {
        Assert.assertEquals(getTitle(),expectedPageTitle);
    }
}
