package ua.com.rozetka.tests;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ua.com.rozetka.pages.catalog.CatalogPage;
import ua.com.rozetka.pages.catalog.CentralBlock;
import ua.com.rozetka.pages.comparison.items.ComparisonItemsPage;
import ua.com.rozetka.pages.goods.GoodsPage;
import ua.com.rozetka.pages.main.MainPage;
import ua.com.rozetka.pages.main.left.block.LeftBlock;
import ua.com.rozetka.pages.search.SearchPage;
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

    private SearchPage searchPage = new SearchPage();

    @BeforeClass
    public static void setUp() throws IOException {
        logger.info("Запуск тестов класса: ComparisonTest");

        InputStream file = new FileInputStream("src\\test\\java\\ua\\com\\rozetka\\config\\config.properties");
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
    public void shouldBeDifferencesFilterShowsAllDifferences() {
    logger.info("Запуск теста shouldBeDifferencesFilterShowsAllDifferences");
        //given
        String mainMenuCategory = "Ноутбуки и компьютеры";
        String categoryMenuItem = "Ноутбуки";
        String categorySubItem = "Ноутбуки с SSD";
        int actualDifferentElementsCount;
        int expectedDifferentElementsCount;

        //when
        logger.info("Заходим на главную страницу Розетки");
        LeftBlock mainMenu = mainPage.getLeftBlock();

        logger.info("Наводим на 'Ноутбуки и компьютеры' в левом блоке");
        mainMenu.setCategoryCatalogPopup(mainMenuCategory);

        logger.info("Выбираем 'ноутбуки' в появившемся блоке");
        mainMenu.setCategory(categoryMenuItem);
        CatalogPage catalogPage = mainMenu.getCatalogPage();

        logger.info("Выбираем 'Ноутбуки с SSD'");
        CentralBlock centralBlock = catalogPage.getCentralBlock();
        centralBlock.setCategory(categorySubItem);

        logger.info("Для 1 и 2 в списке нажимаем иконку весов");
        GoodsPage goodsPage = centralBlock.getGoodsPage();
        goodsPage.getCentralBlock().setItemToComparison(1);
        goodsPage.getCentralBlock().setItemToComparison(2);

        logger.info("В шапке нажимаем 'Сравнение'");
        ComparisonPage comparisonPage = goodsPage.getHeaderBlock().getComparisonPage();

        logger.info("Нажимаем кнопку 'Сравнить эти товары'");
        ComparisonItemsPage comparisonItemsPage = comparisonPage.getCentralBlock().getComparisonItemsPage();

        logger.info("Считаем отличия");
        expectedDifferentElementsCount = comparisonItemsPage.getCentralBlock().getDifferentElementsCount();

        logger.info("Переходим в 'Только отличия'");
        comparisonItemsPage.getLeftBlock().showDifferencesOfItems();

        logger.info("Считаем сколько строк отличий");
        actualDifferentElementsCount = comparisonItemsPage.getCentralBlock().getDifferentElementsCount();

        //then
        assertEquals("Количество различий между товарами, при использовании фильтра," +
                        " не соответствует фактическому.",
                expectedDifferentElementsCount, actualDifferentElementsCount);
    }

    @AfterClass
    public static void off() {
        logger.info("Конец тестов класса: ComparisonTest\n");
    }
}
