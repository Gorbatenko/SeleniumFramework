package ua.com.rozetka.tests;

import com.codeborne.selenide.ElementsCollection;
import org.junit.After;
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

    private static Properties config = new Properties();
    private MainPage mainPage = new MainPage();

    private SearchPage searchPage = new SearchPage();

    @BeforeClass
    public static void setUp() throws IOException {
        InputStream file = new FileInputStream("src/test/java/ua/com/rozetka/config/сonfig.properties");
        config.load(file);

        String driverType = config.getProperty("driver.type");
        String driverAddress = config.getProperty("driver.address");
        String selenideBrowser = config.getProperty("selenide.browser");
        String siteAddress = config.getProperty("site.address");

        System.setProperty(driverType, driverAddress);
        System.setProperty("selenide.browser", selenideBrowser);
        open(siteAddress);
    }

    @Test
    public void shouldSearchResultsPageDisplaysSearchQueryInTitleTest() {

        //given
        HeaderBlock header = mainPage.getHeader();
        String expectedResultTitle = "Lenovo";
        String fullSearchQuery = "Мобильные телефоны";

        //when
        header.getSearchBar().setValue(expectedResultTitle);

        header.setSearch(fullSearchQuery);

        String actualResultTitle = mainPage.getHeader().getSearchPage().getHeader().getSearchResultTitle().getText();

        //then
        assertEquals("На странице результатов поиска в заголовке не отображается поисковый запрос",
                expectedResultTitle, actualResultTitle);
    }

    @Test
    public void shouldBeShowedPopupComparison() {

        //given
        HeaderBlock header = mainPage.getHeader();
        String expectedResultTitle = "Нет товаров в сравнении\nДобавляйте товары к сравнению характеристик\n" +
                "и выбирайте самый подходящий вам товар";

        //when
        header.getBtnComparison().hover();

        sleep(300);
        String actualResultTitle = header.getPopupComparison().getText();

        //then
        assertEquals("Название попапа сравнения не соответствует ожидаемому",
                expectedResultTitle, actualResultTitle);
    }

    @After
    public void postTest() {
        String siteAddress = config.getProperty("site.address");

        open(siteAddress);
    }
}
