package ua.com.rozetka.tests;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.rozetka.pages.catalog.CatalogPage;
import ua.com.rozetka.pages.catalog.CentralBlock;
import ua.com.rozetka.pages.comparison.items.ComparisonItemsPage;
import ua.com.rozetka.pages.goods.GoodsPage;
import ua.com.rozetka.pages.main.MainPage;
import ua.com.rozetka.pages.main.left.block.LeftBlock;
import ua.com.rozetka.pages.comparison.ComparisonPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertEquals;

public class ComparisonTest {

    private static Logger logger = Logger.getLogger(ComparisonTest.class);
    private static Properties config = new Properties();
    private MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUp() throws IOException {
        //given
        InputStream file = new FileInputStream("src\\test\\java\\ua\\com\\rozetka\\config\\config.properties");
        config.load(file);

        String driverType = config.getProperty("driver.type");
        String driverAddress = config.getProperty("driver.address");
        String selenideBrowser = config.getProperty("selenide.browser");
        String selenideBrowserSize = config.getProperty("selenide.browser.size");
        String siteAddress = config.getProperty("site.address");

        System.setProperty(driverType, driverAddress);
        System.setProperty("selenide.browser", selenideBrowser);
        System.setProperty("selenide.browserSize", selenideBrowserSize);

        logger.info("Заходим на главную страницу Розетки");
        open(siteAddress);
    }

    @Test
    public void shouldBeDifferencesFilterShowsAllDifferences() {
        //when
        LeftBlock mainMenu = mainPage.getLeftBlock();
        mainMenu.setCategoryCatalogPopup("Ноутбуки и компьютеры");

        mainMenu.setCategory("Ноутбуки");
        CatalogPage catalogPage = mainMenu.getCatalogPage();

        CentralBlock centralBlock = catalogPage.getCentralBlock();
        centralBlock.setCategory("Ноутбуки с SSD");

        GoodsPage goodsPage = centralBlock.getGoodsPage();
        goodsPage.getCentralBlock().setItemToComparison(1);
        goodsPage.getCentralBlock().setItemToComparison(2);

        ComparisonPage comparisonPage = goodsPage.getHeaderBlock().getComparisonPage();

        ComparisonItemsPage comparisonItemsPage = comparisonPage.getCentralBlock().getComparisonItemsPage();

        int expectedDifferentElementsCount;
        expectedDifferentElementsCount = comparisonItemsPage.getCentralBlock().getDifferentElementsCount();

        comparisonItemsPage.getLeftBlock().showDifferencesOfItems();

        int actualDifferentElementsCount;
        actualDifferentElementsCount = comparisonItemsPage.getCentralBlock().getDifferentElementsCount();

        //then
        assertEquals("Количество различий между товарами, при использовании фильтра," +
                        " не соответствует фактическому.",
                expectedDifferentElementsCount, actualDifferentElementsCount);
    }
}