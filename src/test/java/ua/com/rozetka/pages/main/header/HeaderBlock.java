package ua.com.rozetka.pages.main.header;

import org.openqa.selenium.WebElement;

import java.util.List;

public class HeaderBlock {
    private WebElement logo;
    private WebElement contacts;
    private WebElement langToggle;
    private List<WebElement> headerTopMenuItems;
    private String cityRef = "a.header-city-select-link";
    private String cityChoosePopUp = "div.header-city-choose-popup";


    public void setHeaderTopMenuItems(List<WebElement> items) {
        this.headerTopMenuItems = items;
    }
    public String getCityRef(){
        return cityRef;
    }

    public String getCityChoosePopUp(){
        return cityChoosePopUp;
    }
}
