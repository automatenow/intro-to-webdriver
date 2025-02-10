package io.automatenow.pages;

import io.automatenow.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Marco A. Cruz
 */
public class NavigationBar extends BasePage {
    private final By sandbox = By.xpath("//span[normalize-space()='Sandbox']");
    private final By vlog = By.xpath("//a[text()='Vlog']");
    private final By webdriverIntro = By.xpath("//a[text()='Intro to Selenium WebDriver']");
    private final By cookiesOk = By.id("cookie_action_close_header");

    public SandboxPage selectSandbox() {
        click(sandbox);
        // Accept cookies
        click(cookiesOk);
        return new SandboxPage();
    }

    public void selectIntroToSeleniumWebDriver() {
        hoverElement(vlog);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(webdriverIntro)).click();
    }
}
