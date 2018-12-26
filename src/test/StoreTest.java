package test;

import main.StorePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StoreTest {

    private WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://store.demoqa.com");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void verifySamplePage(){
        StorePage storePage = new StorePage(driver);
        driver.findElement(By.xpath(("//a[@href='http://store.demoqa.com/sample-page/']"))).click();
        storePage.isStorePageFullyDisplayed();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("sample-page"));
    }

    @Test
    public void verifyErrorInComments(){
        StorePage storePage = new StorePage(driver);
        driver.findElement(By.xpath(("//a[@href='http://store.demoqa.com/sample-page/']"))).click();
        storePage.submitComment("this is a comment", "Lucia", "invalid@email@gmail.com");
        WebElement errorPage = driver.findElement(By.id("error-page"));
        String error = errorPage.getText();
        Assert.assertTrue(error.contains("please enter a valid email address."));
        Assert.assertTrue(errorPage.isDisplayed());
    }

    // All 7 steps could have been done in the following test, but I decided to make three so as to add more validations.
    @Test
    public void verifyCommentIsAdded(){
        StorePage storePage = new StorePage(driver);
        driver.findElement(By.xpath(("//a[@href='http://store.demoqa.com/sample-page/']"))).click();
        storePage.submitComment("this is a comment", "Lucia", "invalid@email@gmail.com");
        driver.findElement(By.xpath("//a[@href='javascript:history.back()']")).click();
        storePage.submitComment(storePage.myComment, "Lucia", "luciatest@gmail.com");
        String currentUrl = driver.getCurrentUrl();
        String sentComment = driver.findElement(By.className("commentlist")).getText();
        Assert.assertTrue(currentUrl.contains("#comment"));
        Assert.assertTrue(sentComment.contains(storePage.myComment));
    }

}
