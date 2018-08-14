package ua.com.rozetka.pages.goods;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class CentralBlock {

    private void addItemToComparison(int itemNumber) {
        ElementsCollection itemBoards = $$("div.g-i-tile-i-box-desc");
        SelenideElement itemBoard = itemBoards.get(itemNumber-1);
        itemBoard.hover();

        itemBoard.$("span.g-compare").shouldBe(Condition.visible).click();
        sleep(500);
//        itemBoard.$("span.g-compare-added").shouldBe(Condition.visible);
    }

    public void setItemToComparison(int itemNumber) {
        addItemToComparison(itemNumber);
    }
}
