package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;
import rozetka.utils.FilesUtils;

public class CreditPage extends PageHeader {
    private WebDriver webDriver;

    public CreditPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = FilesUtils.getBaseUrl() + "/credit/";
        this.webDriver = webDriver;
    }
}
