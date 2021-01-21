package io.automatenow.tests;

import io.automatenow.pages.BasePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends BasePage {

    @BeforeSuite
    public void setup() {
        Assert.assertTrue(goToHomepage(), "An error occurred while navigating to the the homepage");
    }

    @AfterSuite
    public void tearDown() {
        closeBrowser();
    }
}
