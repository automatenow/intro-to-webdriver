package io.automatenow.tests;

import io.automatenow.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomepageTests extends BaseTest {
    HomePage homePage = new HomePage();

    @Test(description = "Verify page title")
    public void testPageTile() {
        String pageTitle = homePage.getPageTitle();
        Assert.assertEquals(pageTitle, "AUTOMATENOW – A place for learning software automated testing.", "The page title did not match!");
    }

    @Test(description = "Verify welcome message")
    public void testGreeting() {
        String greeting = homePage.getWelcomeMessage();
        Assert.assertTrue(greeting.contains("Welcome"), "Welcome message did not match");
    }
}