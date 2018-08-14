package ua.com.rozetka.pages.comparison.items;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CentralBlock {

    private int differentElementsCount() {
        ElementsCollection differences = $$(byXpath("//div[@name='different']"));

        int size = differences.size();

        return size;
    }

    public int getDifferentElementsCount() {
        return differentElementsCount();
    }
}
