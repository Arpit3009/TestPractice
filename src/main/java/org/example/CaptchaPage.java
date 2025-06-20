package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class CaptchaPage {

    private WebDriver driver;

    public CaptchaPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//iframe[@title='Widget containing a Cloudflare security challenge']")
    public WebElement iframeElement;

    @FindBy(xpath = "//input[@type='checkbox'")
    public WebElement checkbox;

    @FindBy(css = ".zone-name-title.h1")
    public WebElement framePage;

    public void handleCaptcha() throws InterruptedException {

        System.out.println(framePage.isDisplayed());
        System.out.println("frame size : " + driver.findElement(By.tagName("//iframe")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframeElement));
//        Thread.sleep(10);
//        driver.switchTo().frame(0);
        checkbox.click();

//        ArrayList<String> li = (ArrayList<String>) driver.getWindowHandles();

    }
}
