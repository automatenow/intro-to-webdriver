package io.automatenow.tests;

import io.automatenow.pages.NavigationBar;
import io.automatenow.pages.SandboxPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Marco A. Cruz
 */
public class SandboxTests extends BaseTest {
    SandboxPage sandbox = new SandboxPage();

    @BeforeClass
    public void testNavigateToSandboxPage() {
        new NavigationBar().selectSandbox();
    }

    @Test(description = "Verify the page title")
    public void testPageTitle() {
        String title = sandbox.getPageTitle();
        Assert.assertEquals(title, "Sandbox – AUTOMATENOW", "Page title did not match");
    }

    @Test(description = "Enters text in an input field")
    public void testEnterText() {
        String myText = "hello";
        sandbox.setInputFieldText(myText);
        String displayedText = sandbox.getInputFieldText();
        Assert.assertEquals(displayedText, myText, "Unable to verify entered text");
    }
}
