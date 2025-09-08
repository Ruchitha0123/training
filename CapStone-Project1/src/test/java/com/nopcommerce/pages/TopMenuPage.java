package com.nopcommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class TopMenuPage {
    WebDriver driver;

    private By topMenuLinks = By.cssSelector("ul.top-menu > li > a");
    private By pageTitle = By.cssSelector("div.page-title h1");

    public TopMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Return visible names of top menu items */
    public List<String> getTopMenuNames() {
        List<WebElement> els = driver.findElements(topMenuLinks);
        return els.stream().map(e -> e.getText().trim()).collect(Collectors.toList());
    }

    /** Click the top menu item whose visible text matches (case-insensitive). */
    public void clickMenuByName(String name) {
        List<WebElement> els = driver.findElements(topMenuLinks);
        for (WebElement el : els) {
            if (el.getText().trim().equalsIgnoreCase(name)) {
                el.click();
                return;
            }
        }
        // If not found, try contains match
        for (WebElement el : els) {
            if (el.getText().toLowerCase().contains(name.toLowerCase())) {
                el.click();
                return;
            }
        }
        throw new RuntimeException("Top menu item not found: " + name);
    }

    /** Returns H1 page title if present, otherwise empty string */
    public String getPageH1() {
        try {
            return driver.findElement(pageTitle).getText().trim();
        } catch (Exception e) {
            return "";
        }
    }
}
