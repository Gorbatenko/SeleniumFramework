package ua.com.rozetka.tests;

import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.com.rozetka.pages.catalog.CatalogPage;
import ua.com.rozetka.pages.catalog.CentralBlock;
import ua.com.rozetka.pages.goods.GoodsPage;
import ua.com.rozetka.pages.main.MainPage;
import ua.com.rozetka.pages.main.left.block.LeftBlock;
import ua.com.rozetka.pages.search.SearchPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.open;

public class ComparisonTests {

//    private static final Logger logger = Logger.getLogger()
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
    public void shouldBeDifferencesFilterShowsAllDifferences() {
        //given
        String mainMenuCategory = "Ноутбуки и компьютеры";
        String categoryMenuItem = "Ноутбуки";
        String categorySubItem = "Ноутбуки с SSD";
        int actualDifferentElementsCount;
        int expectedDifferentElementsCount;

        //when
        System.out.println("1. Заходим на главную страницу розетки");
        LeftBlock mainMenu = mainPage.getLeftBlock();
        mainMenu.getMainMenu();

        System.out.println("2. Наводим на 'Ноутбуки и компьютеры' в левом блоке");
        SelenideElement categoryCatalogPopup = mainMenu.getCategoryCatalogPopup(mainMenuCategory);

        System.out.println("3. В появившемся блоке выбираем 'ноутбуки'");
        mainMenu.setCategory(categoryMenuItem);
        CatalogPage catalogPage = mainMenu.getCatalogPage();

        System.out.println("4. В окне, в которое перешли, выбираем 'Ноутбуки с SSD'");
        CentralBlock centralBlock = catalogPage.getCentralBlock();
        centralBlock.setCategory(categorySubItem);
        GoodsPage goodsPage = centralBlock.getGoodsPage();
//
//        System.out.println("5. Для 1 и 2 в списке нажимаем иконку весов");
//        goodsPage.getCentralBlock().addItemToComparison(1);
//        goodsPage.getCentralBlock().addItemToComparison(2);
//
//        System.out.println("6. В шапке нажимаем 'Сравнение'");
//        ComparisonPage comparisonPage = goodsPage.getHeader.getComparisonPage();
//
//        System.out.println("7. Нажимаем кнопку 'Сравнить эти товары'");
//        ComparisonItemsPage comparisonItemsPage = comparisonPage.getCentralBlock().getComparisonItemsPage();
//
//        System.out.println("8. Считаем отличия");
//        expectedDifferentElementsCount = comparisonItemsPage.getCentralBlock().getDifferentElementsCount();
//
//        System.out.println("9. Переходим в 'Только отличия' и считаем сколько там строк отличия");
//        actualDifferentElementsCount = comparisonItemsPage.getLeftBlock()
//                .showDifferencesOfItems().getDifferentElementsCount();
//
//        //then
//        assertEquals("Количество различий между товарами, при использовании фильтра," +
//                        " не соответствует фактическому.",
//                expectedDifferentElementsCount, actualDifferentElementsCount);
    }
}
