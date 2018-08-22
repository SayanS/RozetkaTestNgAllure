package rozetka.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import rozetka.dataProviders.DataProviders;
import rozetka.pages.FaqPage;
import rozetka.pages.HomePage;

import java.util.Map;

@Test(dataProviderClass = DataProviders.class)
public class SmokeTests extends BaseTests{
    @Test(dataProvider = "headerMenuItems", enabled = true, groups = {"run"})
    public void checkHeaderMenuLinks(Map<String,String> headerMenuTestData){
        HomePage homePage=openHomePage();
        FaqPage faqPage=openHomePage().getHeader().selectMenuItem(headerMenuTestData.get("itemName"));
        Assert.assertEquals(faqPage.getTitle(),headerMenuTestData.get("pageTitle"));

    }

}
