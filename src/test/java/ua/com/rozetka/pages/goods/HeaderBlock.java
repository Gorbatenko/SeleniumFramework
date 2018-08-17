package ua.com.rozetka.pages.goods;

import com.codeborne.selenide.SelenideElement;
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

    public ComparisonPage getComparisonPage() {
        logger.debug("Переход на страницу сравнения товаров.");
        return comparisonPage();
    }
}
