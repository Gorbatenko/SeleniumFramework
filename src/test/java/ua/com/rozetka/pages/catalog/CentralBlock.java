package ua.com.rozetka.pages.catalog;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import ua.com.rozetka.pages.goods.GoodsPage;
import ua.com.rozetka.tests.ComparisonTest;

import static com.codeborne.selenide.Selenide.$$;
import static ua.com.rozetka.utils.Utils.closeBunner;

public class CentralBlock {

    private static Logger logger = Logger.getLogger(ComparisonTest.class);

    private GoodsPage goodsPage = new GoodsPage();

    private void category(String categorySubItem) {
        ElementsCollection categoryMenuItems = $$("a.pab-h4-link");

        for (SelenideElement menuCategory : categoryMenuItems) {
            if (menuCategory.getText().contains(categorySubItem)) {
                menuCategory.click();
                break;
            }
        }
    }

    @Step("Выбор категории.")
    public void setCategory(String categorySubItem) {
        logger.info("Выбор категории: " + categorySubItem);
        closeBunner();
        category(categorySubItem);
    }

    public GoodsPage getGoodsPage() {
        logger.debug("Переход к просмотру товаров.");
        return goodsPage;
    }
}
