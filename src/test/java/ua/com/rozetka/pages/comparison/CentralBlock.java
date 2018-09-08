package ua.com.rozetka.pages.comparison;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Нажимаем кнопку 'Сравнить эти товары'.")
    public ComparisonItemsPage getComparisonItemsPage() {
        logger.info("Нажимаем кнопку 'Сравнить эти товары'");
        return comparisonItemsPage();
    }
}