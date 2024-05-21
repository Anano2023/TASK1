package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasteBinPage {
    WebDriver driver;

    public PasteBinPage(WebDriver driver) {
        this.driver = driver;
    }

    public String writeTextInNewPasteField(String text) {
        driver.findElement(By.id("postform-text")).sendKeys(text);
        return driver.findElement(By.id("postform-text")).getText();
    }

    public void selectPasteExpirationDropdown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("select2-postform-expiration-container")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/span[2]/span/span[2]/ul/li[3]"))).click();
                //"//span[@id='select2-postform-expiration-container' and @title='10 Minutes']"))).click();
    }

    public void writeTextInPasteTitle(String text) {
        driver.findElement(By.id("postform-name")).sendKeys(text);
    }

    public void clickOnCreateNewPaste() {
        driver.findElement(By.xpath("//button[@class='btn -big']")).click();
    }

}
