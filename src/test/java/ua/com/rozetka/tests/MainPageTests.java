package ua.com.rozetka.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class MainPageTests {
    private static InputStream file;
    private static Properties config = new Properties();

    private static String driverType;
    private static String driverAddress;
    private static String selenideBrowser;
    private static String siteAddress;

    @BeforeClass
    public static void setUp() throws IOException {
        file = new FileInputStream("src/test/java/ua/com/rozetka/config/сonfig.properties");
        config.load(file);

        driverType = config.getProperty("driver.type");
        driverAddress = config.getProperty("driver.address");
        selenideBrowser = config.getProperty("selenide.browser");
        siteAddress = config.getProperty("site.address");

        System.setProperty(driverType, driverAddress);
        System.setProperty("selenide.browser", selenideBrowser);
        open(siteAddress);
    }

    @Test
    public void headerTest() {
        $("input.rz-header-search-input-text").setValue("lenovo");
        sleep(3000);
        ElementsCollection items = $$("div.rz-header-search-suggest-i");
        for (SelenideElement item : items) {
            if (item.getText().contains("Мобильные телефоны")) {
                item.click();
                break;
            }
        }
        sleep(8000);

        $("h1.rz-search-result-title").shouldBe(Condition.visible);
    }
}
