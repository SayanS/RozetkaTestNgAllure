package rozetka.pages.customElements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import rozetka.pages.BasePage;
import rozetka.pages.FaqPage;

import java.util.List;

public class Header extends BasePage {
    private WebDriver webDriver;

    public Header(WebDriver webDriver) {
        super(webDriver);
        this.webDriver = webDriver;
    }

    @FindBy(how = How.XPATH, using = "//ul[@name='header-top-menu']/li/a")
    private List<WebElement> menuItems;

    @Step
    public <T extends BasePage> T selectMenuItem(String itemName) {
        menuItems.stream().filter(menuItem -> menuItem.getText().equals(itemName)).findFirst().orElse(null).click();
        return (T) new FaqPage(webDriver);
    }


}
