package ua.com.rozetka.pages.search.result.central.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CentralHeaderBlock {

    public SelenideElement getSearchResultTitle() {
        return $("span#search_result_title_text").shouldBe(Condition.visible);
    }
}