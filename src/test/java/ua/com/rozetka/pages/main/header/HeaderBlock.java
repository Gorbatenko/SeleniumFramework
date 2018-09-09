package ua.com.rozetka.pages.main.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import ua.com.rozetka.pages.search.SearchPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderBlock {

    private static Logger logger = Logger.getLogger(HeaderBlock.class);

    private List<WebElement> headerTopMenuItems;

    public void setHeaderTopMenuItems(List<WebElement> items) {
        this.headerTopMenuItems = items;
    }

    private SelenideElement searchBar() {
        return $("input.rz-header-search-input-text").shouldBe(Condition.visible);
    }

    public SelenideElement getSearchBar() {
        logger.debug("Получение поисковой строки.");
        return searchBar();
    }

    public void setSearch(String searchCategory) {
        logger.debug("В главном меню выбор категории: " + searchCategory);

        $("div.rz-header-search-suggest-g").shouldBe(Condition.visible);
        ElementsCollection items = $$("div.rz-header-search-suggest-i");

        for (SelenideElement item : items) {
            if (item.getText().contains(searchCategory)) {
                item.click();
                break;
            }
        }
    }

    private void cleanComparison() {
        ElementsCollection closes = $$("img.list-compare-l-i-icon");

        for (SelenideElement close : closes) {
            close.click();
            close.shouldBe(Condition.hidden);
        }
    }

    @Step("Удаление товаров из сравнения.")
    public void cleanComparisonItems() {
        logger.info("Удаление товаров из сравнения.");
        cleanComparison();
    }

    public SearchPage getSearchPage() {
        logger.debug("Переход к странице результатов поиска.");
        return new SearchPage();
    }

    public SelenideElement getBtnComparison() {
        logger.debug("Получение кнопки сравнения.");
        return $("div#comparison").shouldBe(Condition.visible);
    }

    public SelenideElement getPopupComparison() {
        logger.debug("Получение попапа сравнения.");
        return $("div#comparison-popup").shouldBe(Condition.visible);
    }
}
