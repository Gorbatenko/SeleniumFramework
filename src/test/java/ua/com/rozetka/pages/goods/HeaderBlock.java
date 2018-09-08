package ua.com.rozetka.pages.goods;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import ua.com.rozetka.pages.comparison.ComparisonPage;

import static com.codeborne.selenide.Selenide.$;

public class HeaderBlock {
    private static Logger logger = Logger.getLogger(HeaderBlock.class);
    private ComparisonPage comparisonPage = new ComparisonPage();

    private ComparisonPage comparisonPage() {
        SelenideElement comparison = $("div#comparison");
        comparison.click();

        return comparisonPage;
    }

    @Step("Переход к сравнению товаров.")
    public ComparisonPage getComparisonPage() {
        logger.info("Переход к сравнению товаров.");
        return comparisonPage();
    }
}