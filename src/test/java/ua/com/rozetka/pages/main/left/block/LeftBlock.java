package ua.com.rozetka.pages.main.left.block;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ua.com.rozetka.pages.catalog.CatalogPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LeftBlock {

    private SelenideElement header() {
        SelenideElement btn = $("a#fat_menu_btn");
        return btn;
    }

    private SelenideElement mainMenu() {
        SelenideElement menu = $("ul#m-main-ul");
        menu.shouldBe(Condition.visible);
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
        popupMenu.shouldBe(Condition.visible);
        return popupMenu;
    }

    private void category(String categoryMenuItem) {
        ElementsCollection categoryMenuItems = $$("li.f-menu-sub-l-i");

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
        return mainMenu();
    }

    public SelenideElement getHeader() {
        return header();
    }

    public SelenideElement getCategoryCatalogPopup(String mainMenuCategory) {
        return categoryCatalogPopup(mainMenuCategory);
    }

    public void setCategory(String categoryMenuItem) {
        category(categoryMenuItem);
    }

    public CatalogPage getCatalogPage() {
        return catalogPage();
    }



}
