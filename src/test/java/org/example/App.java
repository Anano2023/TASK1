package org.example;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class App
{
    private WebDriver driver;
    private final String LINK = "https://pastebin.com/";
    PasteBinPage mainPage;
    PasteListPage myPastes;

    @BeforeClass
    public void setup() {

        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
       // driver.manage().window().maximize();
       // options.addArguments("--start-maximized");

        driver = new EdgeDriver(options);
        driver.get(LINK);

        mainPage = new PasteBinPage(driver);
        myPastes = new PasteListPage(driver);
    }

    @Test(priority = 4)
    public void createNewPaste() {
        mainPage.writeTextInNewPasteField("Hello from WebDriver");
        mainPage.selectPasteExpirationDropdown();
        mainPage.writeTextInPasteTitle("helloweb");
        mainPage.clickOnCreateNewPaste();
        Assert.assertTrue(myPastes.getNoteMessage().contains("NOTE: Your guest paste has been posted"));
        driver.quit();
    }
}