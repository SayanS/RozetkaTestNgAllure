package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PreLoginPageHeader;

public class HomePage extends BasePage {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL=getBaseUrlForCurrentLocalization();
        this.webDriver=webDriver;
        this.pageHeader =new PreLoginPageHeader(webDriver);
    }


}


