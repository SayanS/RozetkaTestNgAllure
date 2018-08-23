package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.BasePageHeader;

public class HomePage extends BasePage {
    private WebDriver webDriver;
    private BasePageHeader basePageHeader;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL="https://rozetka.com.ua";
        this.webDriver=webDriver;
        this.basePageHeader =new BasePageHeader(webDriver);
    }

    public BasePageHeader getBasePageHeader(){
        return this.basePageHeader;
    }

}


