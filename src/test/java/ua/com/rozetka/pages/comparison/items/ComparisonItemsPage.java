package ua.com.rozetka.pages.comparison.items;

import org.apache.log4j.Logger;

public class ComparisonItemsPage {
    private static Logger logger = Logger.getLogger(ComparisonItemsPage.class);

    private CentralBlock centralBlock = new CentralBlock();
    private LeftBlock leftBlock = new LeftBlock();

    public LeftBlock getLeftBlock() {
        logger.debug("Получение левой части страницы.");
        return leftBlock;
    }

    public CentralBlock getCentralBlock() {
        logger.debug("Получение центральной части страницы.");
        return centralBlock;
    }
}
