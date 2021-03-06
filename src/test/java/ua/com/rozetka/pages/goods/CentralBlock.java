package ua.com.rozetka.pages.goods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;


import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class CentralBlock {

    private static Logger logger = Logger.getLogger(CentralBlock.class);

    private void addItemToComparison(int itemNumber) {
        ElementsCollection itemBoards = $$("div.g-i-tile-i-box-desc");
        SelenideElement itemBoard = itemBoards.get(itemNumber - 1);
        itemBoard.hover();

        itemBoard.$("span.g-compare").shouldBe(Condition.visible).click();
        sleep(600);
    }

    @Step("Добавление товара к сравнению.")
    public void setItemToComparison(int itemNumber) {
        logger.info("Добавление к сравнению товара №" + itemNumber);
        addItemToComparison(itemNumber);
    }
}