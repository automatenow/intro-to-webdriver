package io.automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Marco A. Cruz
 */
public class SandboxPage extends BasePage {
    private By inputField = By.id("g399-inputfield");
    private By dropDown = By.id("dd");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public SandboxPage setInputFieldText(String text) {
        setText(inputField, text);
        return null;
    }

    public String getInputFieldText() {
        return getText(inputField);
    }

    /**
     * Selects a check box
     *
     * @param option Range is 1 to 3
     */
    public SandboxPage selectCheckbox(String option) {
        driver.findElement(By.xpath("//input[@value='Option " + option + "']")).click();
        return this;
    }

    public boolean checkboxIsSelected(String option) {
        return driver.findElement(By.xpath("//input[@value='Option " + option + "']")).isSelected();
    }

    /**
     * Selects drop-down option
     *
     * @param option Displayed text
     */
    public SandboxPage selectFromDropdown(String option) {
        Select dDown = new Select(driver.findElement(dropDown));
        dDown.selectByVisibleText(option);
        return this;
    }

    /**
     * @return The option that is currently selected.
     */
    public String getDropdownText() {
        Select dDown = new Select(driver.findElement(dropDown));
        return dDown.getFirstSelectedOption().getText();
    }
}
