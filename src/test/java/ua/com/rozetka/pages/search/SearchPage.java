package ua.com.rozetka.pages.search;

import org.apache.log4j.Logger;
import ua.com.rozetka.pages.search.result.central.header.CentralHeaderBlock;

public class SearchPage {

    private static Logger logger = Logger.getLogger(SearchPage.class);

    private CentralHeaderBlock header = new CentralHeaderBlock();

    public CentralHeaderBlock getHeader() {
        logger.debug("Получение верхней части страницы.");
        return header;
    }
}