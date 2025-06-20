package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Function;
import java.util.logging.FileHandler;

public class LandingPage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[alt='nopCommerce demo store']")
    public WebElement landingElement;

    @FindBy(css = ".search-box-text")
    public WebElement inputBox;

    @FindBy(css = "button[type='submit']")
            public WebElement searchBox;



    By elementBy = By.cssSelector(".swiper.nop-slider");

    public void waitForElement(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ele));

    }

    public boolean isBothElementDisplayed(){
        WebElement eee = driver.findElement(elementBy);
        fluentWaitExample(eee);
//        waitForElement(eee);
        waitForElement(landingElement);
        return landingElement.isDisplayed() && eee.isDisplayed();
    }

    public void fluentWaitExample(WebElement ele) {
        Wait wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(10)).ignoring(Exception.class);
        wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver webDriver) {
                return ele;
            }
        });
    }

    public boolean refreshBrowserUsingActionClass(){
        String window1 = driver.getWindowHandle();
        inputBox.sendKeys("sjfk");
        Actions action = new Actions(driver);
        action.moveToElement(searchBox).click().perform();
//        Action act = action.build();
//        act.perform();

//        driver.navigate().refresh();
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> winHand = new ArrayList<>( driver.getWindowHandles());
        System.out.println(driver.manage().timeouts().getPageLoadTimeout());
        System.out.println(winHand.get(0));
        for(String st : windowHandles){
            System.out.println(st);
        }
        return true;
    }

    public void takeScreenshot() throws IOException {
        File src = landingElement.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/screenshot/cap.png";
        FileUtils.copyFile(src, new File(path));
    }

    public void takeCompleteScreenshot() throws IOException {
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/screenshot/cap2.png";
        FileUtils.copyFile(file, new File(path));
    }



}
