package rozetka.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import rozetka.pages.customElements.PostLoginPageHeader;

public class MyOrdersPage extends BasePage {
    private WebDriver webDriver;

    public MyOrdersPage(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
        pageHeader =new PostLoginPageHeader(webDriver);
        pageURL=getBaseUrlForCurrentLocalization().replace("://","://my.")+"/profile/account/#details";
    }

    @FindBy(how = How.XPATH, xpath = "//h1")
    private WebElement title;

    @Step
    public MyOrdersPage ensureThatTitleIs(String expectedTitle) {
        Assert.assertEquals(title.getText(), expectedTitle);
        return this;
    }


}
