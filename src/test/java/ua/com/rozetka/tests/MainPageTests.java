package ua.com.rozetka.tests;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.com.rozetka.pages.main.MainPage;

import java.io.*;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class MainPageTests {
    private static WebDriver driver;
    private MainPage page = new MainPage();
    private String cityRef;
    private static Properties properties = new Properties();


    @BeforeClass
    public static void setUp() throws IOException {
        try {
            properties.load(new FileInputStream("W:/GIT projects/SeleniumFramework/src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty(properties.getProperty("driver.type"), properties.getProperty("driver.address"));
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void shouldAppearCityPopUpOnCityRefClick(){
        //given
        driver.get("https://rozetka.com.ua");
        String CityBlock = page.getHeader().getCityRef();
        WebElement cityRefElement = driver.findElement(By.cssSelector(cityRef));

        //when
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cityRefElement.click();

        //then
        String cityChoosePopUp = page.getHeader().getCityChoosePopUp();
        WebElement popUpElement = driver.findElement(By.cssSelector(cityChoosePopUp));

        assertTrue("Блок с названием городов не появился", popUpElement.isDisplayed());
    }
}
