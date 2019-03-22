package ru.usetech.qa.pages.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.usetech.qa.pages.Page;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class GeneralList extends Page {

    public GeneralList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".categories div.table__line")
    private WebElement firstRow;

    public int elementsCount() {

        wait.until(visibilityOf(firstRow));
        return getElementsCount(".categories div.table__line");

    }

}
