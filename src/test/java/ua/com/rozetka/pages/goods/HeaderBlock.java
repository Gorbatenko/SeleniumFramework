package ua.com.rozetka.pages.goods;

import com.codeborne.selenide.SelenideElement;
import ua.com.rozetka.pages.comparison.СomparisonPage;

import static com.codeborne.selenide.Selenide.$;

public class HeaderBlock {

    private СomparisonPage comparisonPage = new СomparisonPage();


    public СomparisonPage getComparisonPage() {
        SelenideElement comparison = $("div#comparison");
        comparison.click();

        return comparisonPage;
    }
}
