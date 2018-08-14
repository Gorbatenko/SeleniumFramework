package ua.com.rozetka.pages.comparison;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ua.com.rozetka.pages.comparison.items.ComparisonItemsPage;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CentralBlock {

    private ComparisonItemsPage comparisonItemsPage = new ComparisonItemsPage();

    public ComparisonItemsPage getComparisonItemsPage() {
        SelenideElement btnComparison = $(byXpath("//span[text()='Сравнить эти товары']"));
        btnComparison.shouldBe(Condition.visible).click();
        return comparisonItemsPage;
    }
}
