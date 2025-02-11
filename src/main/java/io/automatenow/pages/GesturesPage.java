package io.automatenow.pages;

import io.automatenow.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Marco A. Cruz
 */
public class GesturesPage extends BasePage {
    private final By map = By.cssSelector(".mk-map-node-element");

    public GesturesPage dragMap(int x, int y) {
        scrollElementIntoView(map);
        pause(2);
        dragAndDropByOffset(map, x, y);
        pause(2);
        return this;
    }
}
