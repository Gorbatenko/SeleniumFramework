package ua.com.rozetka.pages.main;

import ua.com.rozetka.pages.main.header.HeaderBlock;
import ua.com.rozetka.pages.main.left.block.LeftNavigationMenuBlock;

public class MainPage {
    private HeaderBlock header = new HeaderBlock();
    private LeftNavigationMenuBlock leftBlock = new LeftNavigationMenuBlock();

    public HeaderBlock getHeader(){
        return header;
    }

    public LeftNavigationMenuBlock getLeftBlock() {
        return leftBlock;
    }


}
