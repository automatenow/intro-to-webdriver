package io.automatenow.tests;

import io.automatenow.pages.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Marco A. Cruz
 */
public class SandboxTests extends BaseTest {

    @BeforeTest
    public void testNavigateToSandboxPage() {
        navBar.selectSandbox();
    }

    @Test(description = "Verify the page title")
    public void testPageTitle() {
        String title = sandboxPage.getPageTitle();
        assertEquals(title, "Sandbox – AUTOMATENOW", "Page title did not match");
    }

    @Test(description = "Enters text in an input field")
    public void testEnterText() {
        String myText = "hello";

        FormFieldsPage formFields = sandboxPage.clickFormFields();
        formFields.setInputFieldText(myText);
        String displayedText = formFields.getInputFieldText();
        assertEquals(displayedText, myText, "Unable to verify entered text");
    }

    @Test(description = "Checks a checkbox")
    public void testCheckbox() {
        FormFieldsPage formFields = sandboxPage.clickFormFields();
        formFields.selectCheckbox("1");
        assertTrue(formFields.checkboxIsSelected("1"), "Checkbox is not selected");
        assertFalse(formFields.checkboxIsSelected("2"), "Checkbox is selected");
    }

    @Test(description = "Selects from a drop-down")
    public void testSelectFromDropdown() {
        String myOption = "Binary";

        FormFieldsPage formFields = sandboxPage.clickFormFields();
        formFields.selectFromDropdown(myOption);
        assertEquals(formFields.getDropdownText(), myOption, "Dropdown option not selected");
    }

    @Test(description = "Selects radio buttons")
    public void testSelectRadioButton() {
        String radio = "White";
        String radio2 = "Blue";

        FormFieldsPage formFields = sandboxPage.clickFormFields();
        formFields.selectRadioButton(radio);
        assertTrue(formFields.radioButtonIsSelected(radio), "White option was not selected");

        formFields.selectRadioButton(radio2);
        assertTrue(formFields.radioButtonIsSelected(radio2), "Blue option was not selected");
        assertFalse(formFields.radioButtonIsSelected(radio), "White option was selected");
    }

    @Test(description = "Finds the price of an item in a table")
    public void testItemPrice() {
        TablesPage tables = sandboxPage.clickTables();
        String itemPrice = tables.getItemPrice("Laptop");
        assertEquals(itemPrice, "$1200.00", "Laptop price was incorrect");

        itemPrice = tables.getItemPrice("Oranges");
        assertEquals(itemPrice, "$3.99", "Oranges price was incorrect");
    }

    @Test(description = "Selects a date from a date picker")
    public void testSelectFromDatePicker() {
        CalendarsPage calendars = sandboxPage.clickCalendars();
        calendars.setDate("July", "4", "2024");
        String date = calendars.getDate();
        assertEquals(date, "July 4, 2024", "The date was not properly set");
    }

    @Test(description = "Searches for a blog article")
    public void testBlogSearch() {
        boolean searchSuccess;

        SearchBoxesPage searchPg = sandboxPage.clickSearchBoxes();
        searchSuccess = searchPg.search("aaaa");
        assertFalse(searchSuccess, "Did not expect to find a search result");
        searchSuccess = searchPg.search("jmeter");
        assertTrue(searchSuccess, "Expected to find a search result");
    }

    @Test(description = "Working with multiple open windows")
    public void testMultipleOpenWindows() {
        sandboxPage.clickTwitterButton();
        sandboxPage.switchToNewWindow();
        assertTrue(waitForPageTitle("Twitter"), "The new window's tile does not match");
    }

    @Test(description = "Closes a second open window")
    public void testCloseSecondWindow() {
        sandboxPage.clickTwitterButton();
        sandboxPage.switchToNewWindow();
        closeWindow();
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 1, "Found more than one open window");
    }

    @Test(description = "Working with multiple tabs")
    public void testMultipleTabs() {
        openNewTab();
        sandboxPage.switchToNewWindow();
        goToUrl("https://www.nasa.gov");
        assertTrue(waitForPageTitle("NASA"), "The page title for the new window did not match");
        closeWindow();
        int numberOfOpenWindows = getNumberOfOpenWindows();
        assertEquals(numberOfOpenWindows, 1, "Found more than one open window");
    }

    @Test(description = "Test click and drag operation on a map")
    public void testClickAndDrag() {
        int x_coordinate = -300;
        int y_coordinate = 100;

        GesturesPage gestures = sandboxPage.clickGestures();
        gestures.dragMap(x_coordinate, y_coordinate);
    }

    @Test(description = "Tests a JavaScript alert and a confirmation box")
    public void testPopups() {
        PopupsPage popups = sandboxPage.clickPopups();
        popups.clickAlertPopup();
        dismissPopup();

        popups.clickConfirmPopup();
        acceptPopup();
        String selectionResult = popups.getConfirmPopupSelection();
        assertEquals(selectionResult, "OK it is!", "The popup selection result does not match");
    }

    @Test(description = "Tests a JavaScript prompt box")
    public void testPromptPopup() {
        String name = "Marco";

        PopupsPage popups = sandboxPage.clickPopups();
        popups.clickPromptPopup();
        setAlertText(name);
        acceptPopup();
        popups.waitForPromptPopupResult(String.format("Nice to meet you %s!", name));
    }

    @Test(description = "Tests a JavaScript modal")
    public void testModal() {
        String name = "Marco";
        String email = "info@automatenow.io";
        String message = "Test Message";

        ModalsPage modals = sandboxPage.clickModals();
        modals.openModal()
                .modalSendMessage(name, email, message);
    }

    @Test(description = "Test mouse over")
    public void testHovering() {
        HoverPage hover = sandboxPage.clickHover();
        hover.doHover();
        String hoverText = hover.getHoverText();
        assertEquals(hoverText, "You did it!", "Hover text did not match expected value");
    }

    @Test(description = "Tests scrolling an element into view")
    public void testScrollElementIntoView() {
        sandboxPage.scrollAdsButtonIntoView();
    }

    @Test(description = "Tests scrolling a webpage")
    public void testScrollPage() {
        // Scroll down
        scrollPage(0, 500);
        // Scroll up
        scrollPage(0,-500);
    }
}
