package io.automatenow.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Marco A. Cruz
 */
public class SandboxPage extends BasePage {
    private By inputField = By.id("g399-inputfield");
    private By dropDown = By.id("dd");
    private By calendarYear = By.xpath("//span[@class='ui-datepicker-year']");
    private By calendarMonth = By.xpath("//span[@class='ui-datepicker-month']");
    private By calendarField = By.id("g399-date");
    private By calendarRightArrow = By.xpath("//a[@title='Next']");
    private By searchBox = By.id("wp-block-search__input-1");
    private By searchBtn = By.xpath("//button[text()='Search']");
    private By noSearchResults = By.xpath("//h1[text()='Nothing Found']");

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
        click(By.xpath("//input[@value='Option " + option + "']"));
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

    /**
     * Selects a radio button
     *
     * @param option Case sensitive value
     */
    public SandboxPage selectRadioButton(String option) {
        click(By.cssSelector("input[value='" + option + "']"));
        return this;
    }

    public boolean radioButtonIsSelected(String option) {
        return driver.findElement(By.cssSelector("input[value='" + option + "']")).isSelected();
    }

    public String getItemPrice(String item) {
        return driver.findElement(By.xpath("//td[text()='" + item + "']/following-sibling::td")).getText();
    }

    public SandboxPage setDate(String month, String day, String year) {
        click(calendarField);

        while (true) {
            String currentMonth = getText(calendarMonth);
            String currentYear = getText(calendarYear);
            if (currentMonth.equals(month) && currentYear.equals(year)) {
                break;
            }
            click(calendarRightArrow);
        }

        click(By.xpath("//table//a[text()='" + day + "']"));
        return this;
    }

    public String getDate() {
        return getText(calendarField);
    }

    public boolean search(String text) {
        setText(searchBox, text);
        click(searchBtn);

        if (driver.findElements(noSearchResults).size() > 0) {
            goBack();
            return false;
        }
        return true;
    }
}
