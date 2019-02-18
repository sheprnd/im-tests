package ru.usetech.qa.pages.stages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import java.sql.SQLOutput;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Posts list page

public class PostsListPage extends Page {

    public PostsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".post")
    private WebElement postAtPostsLists;

    @FindBy(css = ".post > p")
    private WebElement postId;

    @FindBy(css = ".wokflow-grid-1 > post:first-child .post__buttons > button:last-child")
    private WebElement deleteButton;

    @FindBy(css = ".wokflow-grid-1 > post:first-child .post__buttons > button:first-child")
    private WebElement moveToSelectedButton;

    @FindBy(css = "add-remove-reason-modal button:first-child")
    private WebElement saveDeleteReasonButton;

    @FindBy(css = "confirm-modal button.btn__blue")
    private WebElement deleteCurrentButton;


    public void scrollPage() {

        wait.until(visibilityOf(postAtPostsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }


    public void moveToSelected() {

        click(moveToSelectedButton);

    }

    public void moveToDeleted() {

        wait.until(visibilityOf(deleteButton));
        click(deleteButton);

    }

    public void deleteCurrent() {
        click(deleteCurrentButton);
    }

    public void setupDeleteReason() {
        click(saveDeleteReasonButton);
    }

    public String getId(){

        String ids = postId.getAttribute("innerText");
        String id = ids.substring(9, ids.indexOf(",",9));

        return id;
    }

}
