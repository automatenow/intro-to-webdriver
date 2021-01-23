package io.automatenow.pages;

import org.openqa.selenium.By;

/**
 * @author Marco A. Cruz
 */
public class NavigationBar extends BasePage {
    By sandbox = By.xpath("//a[contains(text(),'Sandbox')]");

    public SandboxPage selectSandbox() {
        driver.findElement(sandbox).click();
        return new SandboxPage();
    }
}
