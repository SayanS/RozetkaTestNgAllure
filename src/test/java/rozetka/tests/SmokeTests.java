package rozetka.tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import rozetka.dataProviders.DataProviders;
import rozetka.pages.FaqPage;
import rozetka.pages.HomePage;
import rozetka.utils.CustomTestListener;

import java.util.Map;
@Listeners({CustomTestListener.class})
@Test(dataProviderClass = DataProviders.class)
public class SmokeTests extends BaseTests{
    @Test(dataProvider = "headerMenuItems", enabled = true, groups = {"run"}, singleThreaded = true )
    public void checkHeaderMenuLinks(Map<String,String> headerMenuTestData){
        HomePage homePage=openHomePage();
        FaqPage faqPage=homePage.getHeader().selectMenuItem(headerMenuTestData.get("itemName"));
        faqPage.enssureThatTitleIs(headerMenuTestData.get("pageTitle"));
    }

}
