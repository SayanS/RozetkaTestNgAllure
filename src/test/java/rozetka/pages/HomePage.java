package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.Header;

public class HomePage extends BasePage {
    private WebDriver webDriver;
    private Header header;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL="https://rozetka.com.ua";
        this.webDriver=webDriver;
        this.header=new Header(webDriver);
    }

    public Header getHeader(){
        return this.header;
    }

}


