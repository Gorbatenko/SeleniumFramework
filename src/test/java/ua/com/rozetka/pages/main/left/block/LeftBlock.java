package ua.com.rozetka.pages.main.left.block;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import ua.com.rozetka.pages.catalog.CatalogPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LeftBlock {
    private static Logger logger = Logger.getLogger(LeftBlock.class);

    private SelenideElement header() {
        return $("a#fat_menu_btn");
    }

    private void categoryCatalogPopup(String mainMenuCategory) {
        ElementsCollection menuCategories = $$("a.f-menu-l-i-link");

        for (SelenideElement menuCategory : menuCategories) {
            if (menuCategory.getText().contains(mainMenuCategory)) {
                menuCategory.hover();
                break;
            }
        }

        $(byXpath("//div[@name='second_menu']")).shouldBe(Condition.visible);
    }

    private void category(String categoryMenuItem) {
        ElementsCollection categoryMenuItems = $$("a.f-menu-sub-title-link");

        for (SelenideElement menuCategory : categoryMenuItems) {
            if (menuCategory.getText().contains(categoryMenuItem)) {
                menuCategory.click();
                break;
            }
        }
    }

    private CatalogPage catalogPage() {
        return new CatalogPage();
    }

    public void setCategoryCatalogPopup(String mainMenuCategory) {
        logger.debug("В главном меню выбрана категория: " + mainMenuCategory);
        categoryCatalogPopup(mainMenuCategory);
    }

    public void setCategory(String categoryMenuItem) {
        logger.debug("В выпадающем списке главного меню выбрана категория: " + categoryMenuItem);
        category(categoryMenuItem);
    }

    public SelenideElement getHeader() {
        logger.debug("Получение верхней части экрана.");
        return header();
    }

    public CatalogPage getCatalogPage() {
        logger.debug("Переход к каталогу товаров.");
        return catalogPage();
    }



}
