package org.example;

import com.microsoft.playwright.*;

public class BrowserContextConcept {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions op = new BrowserType.LaunchOptions();
        op.setHeadless(false);
        Browser browser = playwright.chromium().launch(op);

        BrowserContext brcx1 = browser.newContext();
        Page p1 = brcx1.newPage();
        //p1.setViewportSize(1920, 1080);

        p1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
        p1.fill("#Form_getForm_Name", "Naveen");
        System.out.println(p1.title());

        BrowserContext brcx2 = browser.newContext();
        Page p2 = brcx2.newPage();
        p2.navigate("https://www.facebook.com");
        p2.fill("#pass", "Dress");
        System.out.println(p2.title());

        BrowserContext brcx3 = browser.newContext();
        Page p3 = brcx3.newPage();
        p3.navigate("http://google.com/");
        System.out.println(p3.title());

        p1.close();
        brcx1.close();

        p2.close();
        brcx2.close();

        p3.close();
        brcx3.close();
    }
}