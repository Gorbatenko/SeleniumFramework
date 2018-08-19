package ua.com.rozetka.pages.catalog;

import org.apache.log4j.Logger;

public class CatalogPage {
    private static Logger logger = Logger.getLogger(CatalogPage.class);

    private CentralBlock centralBlock = new CentralBlock();

    public CentralBlock getCentralBlock() {
        logger.debug("Получение центральной части страницы.");
        return centralBlock;
    }
}