package ua.com.rozetka.pages.comparison.items;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LeftBlock {

    public void showDifferencesOfItems() {
        SelenideElement onlyDifference = $(byXpath("//a[text()='Только отличия']"));
        onlyDifference.click();
    }
}
