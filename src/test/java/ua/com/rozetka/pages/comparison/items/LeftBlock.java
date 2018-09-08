package ua.com.rozetka.pages.comparison.items;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LeftBlock {
    private static Logger logger = Logger.getLogger(LeftBlock.class);

    @Step("Переключение в режим показа только отличий.")
    public void showDifferencesOfItems() {
        logger.info("Переключение в режим показа только отличий.");
        SelenideElement onlyDifference = $(byXpath("//a[text()='Только отличия']"));
        onlyDifference.click();
    }
}
