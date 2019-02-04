package ru.usetech.qa.pages.stages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

//Incidents list page

public class IncidentsListPage extends Page {

    public IncidentsListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = ".post-incident-table")
    private WebElement incidentAtIncidentsLists;

    @FindBy(css = ".alert-success ")
    private WebElement alertSuccess;

    @FindBy(xpath = "//workflow-view-incidents/div/div[2]/incident[1]/div/div/div[3]/div[2]/div/button[3]")
    private WebElement deleteButton;

    @FindBy(xpath = "//add-remove-reason-modal/div[4]/button[1]")
    private WebElement saveDeleteReason;

    @FindBy(xpath = "//confirm-modal/div[4]/button[1]")
    private WebElement confirmIncDeletionBtn;




    public void scrollPage() {

        wait.until(visibilityOf(incidentAtIncidentsLists));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

    }

    public void alertSuccess() {
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));
    }


    public void deleteIncFromList() {

        click(deleteButton);
        click(confirmIncDeletionBtn);
        click(saveDeleteReason);
        alertSuccess();
    }
}
