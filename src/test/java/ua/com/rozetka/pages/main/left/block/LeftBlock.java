package ua.com.rozetka.pages.main.left.block;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import ua.com.rozetka.pages.catalog.CatalogPage;
import ua.com.rozetka.tests.ComparisonTests;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class LeftBlock {
    private static Logger logger = Logger.getLogger(LeftBlock.class);

    private SelenideElement header() {
        SelenideElement btn = $("a#fat_menu_btn");
        return btn;
    }

    private SelenideElement mainMenu() {
        SelenideElement menu = $("ul#m-main-ul");
        menu.shouldBe(Condition.appear);
        return menu;
    }

    private SelenideElement categoryCatalogPopup(String mainMenuCategory) {
        ElementsCollection menuCategories = $$("li.f-menu-l-i");

        for (SelenideElement menuCategory : menuCategories) {
            if (menuCategory.getText().contains(mainMenuCategory)) {
                menuCategory.hover();
                break;
            }
        }

        SelenideElement popupMenu = $(byXpath("//div[@name='second_menu']"));
        popupMenu.shouldBe(Condition.appear);
        return popupMenu;
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
        CatalogPage catalogPage = new CatalogPage();
        return catalogPage;
    }

    public SelenideElement getMainMenu() {
        logger.debug("Возвращаю главное меню.");
        return mainMenu();
    }

    public SelenideElement getCategoryCatalogPopup(String mainMenuCategory) {
        logger.debug("Перехожу на категорию в главном меню.");
        return categoryCatalogPopup(mainMenuCategory);
    }

    public void setCategory(String categoryMenuItem) {
        logger.debug("Перехожу на категорию в выпадающем списке главного меню.");
        category(categoryMenuItem);
    }

    public SelenideElement getHeader() {
        return header();
    }

    public CatalogPage getCatalogPage() {
        return catalogPage();
    }



}
