package io.automatenow.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Marco A. Cruz
 */
public class SandboxTests extends BaseTest {

    @BeforeClass
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
        sandboxPage.setInputFieldText(myText);
        String displayedText = sandboxPage.getInputFieldText();
        assertEquals(displayedText, myText, "Unable to verify entered text");
    }

    @Test(description = "Checks a checkbox")
    public void testCheckbox() {
        sandboxPage.selectCheckbox("1");
        assertTrue(sandboxPage.checkboxIsSelected("1"), "Checkbox is not selected");
        assertFalse(sandboxPage.checkboxIsSelected("2"), "Checkbox is selected");
    }
}
