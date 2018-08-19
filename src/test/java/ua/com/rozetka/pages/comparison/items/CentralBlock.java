package ua.com.rozetka.pages.comparison.items;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CentralBlock {

    private static Logger logger = Logger.getLogger(CentralBlock.class);

    private int differentElementsAutomatic() {
        ElementsCollection differences = $$(byXpath("//div[@name='different']"));

        return differences.size();
    }

    private int differentElementsHandMade() {
        logger.debug("Создаю перечень строк.");
        ElementsCollection rows = $$("div.comparison-t-row");
        ElementsCollection comparisonItems;
        int counterDifferent = 0;

        logger.debug("Приступаю к перебору строк.");
        for (SelenideElement row : rows) {
            comparisonItems = row.$$("div.comparison-t-cell");

            if (!comparisonItems.get(0).getText().equals(comparisonItems.get(1).getText())) {
                counterDifferent++;
                logger.debug("Счетчик различий изменён = " + counterDifferent);
            }
        }
        return counterDifferent;
    }

    public int getDifferentElementsCount() {
        logger.info("Считаем строки с отличиями");
        return differentElementsHandMade();
    }
}