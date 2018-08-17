package ua.com.rozetka.pages.goods;

import org.apache.log4j.Logger;

public class GoodsPage {
    private static Logger logger = Logger.getLogger(GoodsPage.class);
    private CentralBlock centralBlock = new CentralBlock();
    private HeaderBlock headerBlock = new HeaderBlock();

    public CentralBlock getCentralBlock() {
        logger.debug("Получение центральной части страницы.");
        return centralBlock;
    }

    public HeaderBlock getHeaderBlock() {
        logger.debug("Получение верхней части страницы.");
        return headerBlock;
    }

}
