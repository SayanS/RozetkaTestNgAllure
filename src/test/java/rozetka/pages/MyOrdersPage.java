package rozetka.pages;

import org.openqa.selenium.WebDriver;
import rozetka.pages.customElements.PageHeader;

public class MyOrdersPage extends PageHeader {
    WebDriver webDriver;
    public MyOrdersPage(WebDriver webDriver){
        super(webDriver);
        this.webDriver=webDriver;
    }
}
