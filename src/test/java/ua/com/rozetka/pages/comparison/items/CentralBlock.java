package ua.com.rozetka.pages.comparison.items;

import com.codeborne.selenide.ElementsCollection;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CentralBlock {

    private static Logger logger = Logger.getLogger(CentralBlock.class);

    private int differentElementsCount() {
        ElementsCollection differences = $$(byXpath("//div[@name='different']"));

        return differences.size();
    }

    public int getDifferentElementsCount() {
        logger.debug("Получение количества различий товаров.");
        return differentElementsCount();
    }
}
