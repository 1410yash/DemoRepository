package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchOptionsMethods {


    public static void main(String[] args) {
            Playwright playwright = Playwright.create();
            BrowserType.LaunchOptions lp = new BrowserType.LaunchOptions();
            lp.setChannel("msedge");
            lp.setHeadless(false);
            Browser browser = playwright.chromium().launch(lp);
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            System.out.print("show me the result");
        }
    }
