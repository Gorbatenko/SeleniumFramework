package ua.com.rozetka.utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class Utils {
    public static void closeBunner() {
        SelenideElement bunnerPopup = $("a.exponea-banner.exponea-popup-banner.exponea-animate");
        SelenideElement closeCross = $("span.exponea-close-cross");

        if (bunnerPopup.has(Condition.visible)) {
            closeCross.click();
        }
    }
}