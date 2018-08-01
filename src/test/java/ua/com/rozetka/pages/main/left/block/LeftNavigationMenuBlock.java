package ua.com.rozetka.pages.main.left.block;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LeftNavigationMenuBlock {

    public SelenideElement getHeader(){
        SelenideElement btn = $("a#fat_menu_btn");
        return btn;
    }

}
