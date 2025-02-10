package io.automatenow.pages;

import io.automatenow.core.BasePage;
import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class PopupsPage extends BasePage {
    private final By alertBtn = By.id("alert");
    private final By confirmBtn = By.id("confirm");
    private final By confirmPopupResult = By.id("confirmResult");
    private final By promptBtn = By.id("prompt");
    private final By promptPopupResult = By.id("promptResult");

    public void clickAlertPopup() {
        click(alertBtn);
    }

    public void clickConfirmPopup() {
        click(confirmBtn);
    }

    public String getConfirmPopupSelection() {
        return getText(confirmPopupResult);
    }

    public void clickPromptPopup() {
        click(promptBtn);
    }

    public void waitForPromptPopupResult(String expectedText) {
        waitForElementText(promptPopupResult, expectedText);
    }
}
