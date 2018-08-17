package ua.com.rozetka.pages.comparison;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;
import ua.com.rozetka.pages.comparison.items.ComparisonItemsPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CentralBlock {
    private static Logger logger = Logger.getLogger(CentralBlock.class);
    private ComparisonItemsPage comparisonItemsPage = new ComparisonItemsPage();

    private ComparisonItemsPage comparisonItemsPage() {
        SelenideElement btnComparison = $(byXpath("//span[text()='Сравнить эти товары']"));
        btnComparison.shouldBe(Condition.visible).click();
        return comparisonItemsPage;
    }

    public ComparisonItemsPage getComparisonItemsPage() {
        logger.debug("Переход к непосредственному сравнению товаров.");
        return comparisonItemsPage();
    }





}
