package ua.com.rozetka.pages.comparison;

import org.apache.log4j.Logger;

public class ComparisonPage {
    private static Logger logger = Logger.getLogger(ComparisonPage.class);

    public CentralBlock getCentralBlock() {
        logger.debug("Получение центральной части страницы.");
        return centralBlock;
    }

    private CentralBlock centralBlock = new CentralBlock();
}