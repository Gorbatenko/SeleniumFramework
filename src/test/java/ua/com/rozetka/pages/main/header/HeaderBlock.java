package ua.com.rozetka.pages.main.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import ua.com.rozetka.pages.search.SearchPage;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderBlock {
    private List<WebElement> headerTopMenuItems;

    public void setHeaderTopMenuItems(List<WebElement> items) {
        this.headerTopMenuItems = items;
    }

    public SelenideElement getSearchBar(){
        return $("input.rz-header-search-input-text").shouldBe(Condition.visible);
    }

    public ElementsCollection getItemsForSearch(){
        $("div.rz-header-search-suggest-g").shouldBe(Condition.visible);
        return $$("div.rz-header-search-suggest-i");
    }

    public void setSearch(ElementsCollection items, String searchCategory){
        for (SelenideElement item : items) {
            if (item.getText().contains(searchCategory)) {
                item.click();
                break;
            }
        }
    }

    public SearchPage getSearchPage() {
        return new SearchPage();
    }

    public SelenideElement getBtnComparison() {
        return $("div#comparison").shouldBe(Condition.visible);
    }

    public SelenideElement getPopupComparison() {
        return $("div#comparison-popup").shouldBe(Condition.visible);
    }
}
