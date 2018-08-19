package ua.com.rozetka.pages.main;

import org.apache.log4j.Logger;
import ua.com.rozetka.pages.main.header.HeaderBlock;
import ua.com.rozetka.pages.main.left.block.LeftBlock;

import static ua.com.rozetka.utils.Utils.closeBunner;

public class MainPage {

    private static Logger logger = Logger.getLogger(MainPage.class);

    private HeaderBlock header = new HeaderBlock();
    private LeftBlock leftBlock = new LeftBlock();

    public HeaderBlock getHeader() {
        logger.debug("Получение верхней части страницы.");
        closeBunner();
        return header;
    }

    public LeftBlock getLeftBlock() {
        logger.debug("Получение левой части страницы.");
        closeBunner();
        return leftBlock;
    }
}