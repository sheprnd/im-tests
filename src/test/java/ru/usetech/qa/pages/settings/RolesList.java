package ru.usetech.qa.pages.settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RolesList extends Page {

    public RolesList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".groups > div:first-child .groups__line-th")
    private WebElement firstRow;

    @FindBy(css = ".groups .load")
    private WebElement loader;

    public int count() {

        wait.until(visibilityOf(firstRow));
        return getElementsCount(".groups .groups__line");

    }

    public void waitUpdatedList(){
        wait.until(visibilityOf(loader));
        wait.until(stalenessOf(driver.findElement(By.cssSelector(".groups .load"))));
    }
}
