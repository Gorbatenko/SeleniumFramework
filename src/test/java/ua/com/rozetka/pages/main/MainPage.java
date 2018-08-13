package ua.com.rozetka.pages.main;

import ua.com.rozetka.pages.main.header.HeaderBlock;
import ua.com.rozetka.pages.main.left.block.LeftBlock;

public class MainPage {
    private HeaderBlock header = new HeaderBlock();
    private LeftBlock leftBlock = new LeftBlock();

    public HeaderBlock getHeader(){
        return header;
    }

    public LeftBlock getLeftBlock() {
        return leftBlock;
    }


}
