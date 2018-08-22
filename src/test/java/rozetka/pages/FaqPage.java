package rozetka.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import rozetka.pages.customElements.Header;

public class FaqPage extends BasePage {
    private WebDriver webDriver;
    private Header header;

    public FaqPage(WebDriver webDriver) {
        super(webDriver);
        this.pageURL = "https://rozetka.com.ua";
        this.webDriver = webDriver;
        this.header = new Header(webDriver);
    }

    public Header getHeader() {
        return this.header;
    }

    @FindBy(how = How.XPATH, using = "//h1")
    private WebElement title;

    public String getTitle() {
        return title.getText();
    }

}
