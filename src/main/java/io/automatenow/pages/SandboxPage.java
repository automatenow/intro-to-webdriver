package io.automatenow.pages;

import io.automatenow.core.BasePage;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Marco A. Cruz
 */
public class SandboxPage extends BasePage {
    private final By spinnersBtn = By.xpath("//a[contains(text(),'Spinners')]");
    private final By formFieldsBtn = By.xpath("//a[contains(text(),'Form Fields')]");
    private final By tablesBtn = By.xpath("//a[contains(text(),'Tables')]");
    private final By calendarsBtn = By.xpath("//a[contains(text(),'Calendars')]");
    private final By gesturesBtn = By.xpath("//a[contains(text(),'Gestures')]");
    private final By popupsBtn = By.xpath("//a[contains(text(),'Popups')]");
    private final By jsDelaysBtn = By.xpath("//a[contains(text(),'JavaScript Delays')]");
    private final By modalsBtn = By.xpath("//a[contains(text(),'Modals')]");
    private final By hoverBtn = By.xpath("//a[contains(text(),'Hover')]");
    private final By windowOpsBtn = By.xpath("//a[contains(text(),'Window Operations')]");

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void switchToNewWindow() {
        // Get current window handle
        String currentWindow = driver.getWindowHandle();

        // Get all window handles
        Set<String> handles = driver.getWindowHandles();

        // Switch to new window
        Iterator<String> iter = handles.iterator();
        String newWindow;
        while (iter.hasNext()) {
            newWindow = iter.next();
            if (!currentWindow.equals(newWindow)) {
                driver.switchTo().window(newWindow);
            }
        }
    }

    public SandboxPage scrollSpinnersButtonIntoView() {
        scrollElementIntoView(spinnersBtn);
        return this;
    }

    public FormFieldsPage clickFormFields() {
        click(formFieldsBtn);
        return new FormFieldsPage();
    }

    public TablesPage clickTables() {
        scrollElementIntoView(tablesBtn);
        click(tablesBtn);
        return new TablesPage();
    }

    public CalendarsPage clickCalendars() {
        click(calendarsBtn);
        return new CalendarsPage();
    }

    public WindowOperationsPage clickWindowOperations() {
        scrollElementIntoView(windowOpsBtn);
        click(windowOpsBtn);
        return new WindowOperationsPage();
    }

    public GesturesPage clickGestures() {
        scrollElementIntoView(gesturesBtn);
        click(gesturesBtn);
        return new GesturesPage();
    }

    public PopupsPage clickPopups() {
        click(popupsBtn);
        return new PopupsPage();
    }

    public JavaScriptDelaysPage clickJavaScriptDelays() {
        click(jsDelaysBtn);
        return new JavaScriptDelaysPage();
    }

    public ModalsPage clickModals() {
        click(modalsBtn);
        return new ModalsPage();
    }

    public HoverPage clickHover() {
        scrollElementIntoView(hoverBtn);
        click(hoverBtn);
        return new HoverPage();
    }
}
