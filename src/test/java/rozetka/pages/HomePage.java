package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;

public class HomePage extends PageHeader {
    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL="https://rozetka.com.ua";
        this.webDriver=webDriver;
    }

}


