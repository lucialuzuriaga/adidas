package main;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;

public class StorePage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/sample-page']")
    WebElement samplePageButton;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/wp-login.php']")
    WebElement loginButton;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/wp-login.php?action=register']")
    WebElement registerButton;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/products-page/your-account/']")
    WebElement yourAccountButton;

    @FindBy(xpath = "//a[@href='http://store.demoqa.com/products-page/checkout/']")
    WebElement checkoutButton;

    @FindBy(id = "comment")
    WebElement commentsField;

    @FindBy(id = "author")
    WebElement nameField;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(xpath = "//*[@value='Post Comment']")
    WebElement postCommentButton;

    public StorePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isStorePageFullyDisplayed(){
        Assert.assertTrue(loginButton.isDisplayed());
        Assert.assertTrue(registerButton.isDisplayed());
        Assert.assertTrue(yourAccountButton.isDisplayed());
        Assert.assertTrue(checkoutButton.isDisplayed());
        Assert.assertTrue(commentsField.isDisplayed());
        Assert.assertTrue(nameField.isDisplayed());
        Assert.assertTrue(emailField.isDisplayed());
        Assert.assertTrue(postCommentButton.isDisplayed());
        return true;
    }

    public void submitComment(String comment, String name, String email){
        commentsField.clear();
        commentsField.sendKeys(comment);
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        postCommentButton.click();
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String myComment = "comment" + randInt(10000, 9999999);
}
