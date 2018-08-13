package ua.com.rozetka.pages.catalog;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ua.com.rozetka.pages.goods.GoodsPage;

import static com.codeborne.selenide.Selenide.$$;

public class CentralBlock {

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

    public void setCategory(String categorySubItem) {
        category(categorySubItem);
    }

    public GoodsPage getGoodsPage() {
        return goodsPage;
    }
}
