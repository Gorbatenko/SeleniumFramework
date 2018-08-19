package ua.com.rozetka.pages.catalog;

import org.apache.log4j.Logger;

import static ua.com.rozetka.utils.Utils.closeBunner;

public class CatalogPage {
    private static Logger logger = Logger.getLogger(CatalogPage.class);

    private CentralBlock centralBlock = new CentralBlock();

    public CentralBlock getCentralBlock() {
        logger.debug("Получение центральной части страницы.");
        closeBunner();
        return centralBlock;
    }
}