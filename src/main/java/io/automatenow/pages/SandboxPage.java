package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class SandboxPage extends BasePage {
    private By inputField = By.id("g399-inputfield");

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
}
