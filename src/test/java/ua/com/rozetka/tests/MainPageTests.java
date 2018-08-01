package ua.com.rozetka.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.rozetka.pages.main.MainPage;
import ua.com.rozetka.pages.main.header.HeaderBlock;
import ua.com.rozetka.pages.search.SearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class MainPageTests {
    private static InputStream file;
    private static Properties config = new Properties();

    private MainPage mainPage = new MainPage();
    private SearchPage searchPage = new SearchPage();

    private static String driverType;
    private static String driverAddress;
    private static String selenideBrowser;
    private static String siteAddress;

    @BeforeClass
    public static void setUp() throws IOException {
        file = new FileInputStream("src/test/java/ua/com/rozetka/config/сonfig.properties");
        config.load(file);

        driverType = config.getProperty("driver.type");
        driverAddress = config.getProperty("driver.address");
        selenideBrowser = config.getProperty("selenide.browser");
        siteAddress = config.getProperty("site.address");

        System.setProperty(driverType, driverAddress);
        System.setProperty("selenide.browser", selenideBrowser);
        open(siteAddress);
    }

    @Test
    public void shouldTheSearchResultsPageDisplaysTheSearchQueryInTheTitleTest() {

        //given
        HeaderBlock header = mainPage.getHeader();
        String searchQuery = "Lenovo";
        String fullSearchQuery = "Мобильные телефоны";

        //when
        header.getSearchBar()
                .setValue(searchQuery);

        ElementsCollection items = mainPage.getHeader()
                .getItemsForSearch();

        header.setSearch(items, fullSearchQuery);

        String searchResultTitle = searchPage.getHeader()
                .getSearchResultTitle().getText();

        //then
        assertEquals("На странице результатов поиска в заголовке не отображается поисковый запрос", searchQuery, searchResultTitle);
    }
}
