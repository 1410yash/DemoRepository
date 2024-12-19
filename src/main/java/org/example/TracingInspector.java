package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;

import java.nio.file.Paths;

public class TracingInspector {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            //after runing this class,trace.zip will be created inside project
            //conti.. root directory then we can open that zip file using cmd or by going
            //conti.. on one URL given in documnetation and uploading the trace.zip file.
            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://academy.naveenautomationlabs.com/");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();
            page.locator("#microfe-popup-login").contentFrame().getByText("Sign up").click();
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").click();
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").fill("yash");
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Name").press("Tab");
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Email address").fill("yash.chaudhari@gmail.com");
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Email address").press("Tab");
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Password").fill("xxxxxxxxxx");
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Password").press("Tab");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("India: +")).click();
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.OPTION, new FrameLocator.GetByRoleOptions().setName("India+")).click();
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Enter your number").click();
            page.locator("#microfe-popup-login").contentFrame().getByPlaceholder("Enter your number").fill("+91 98765-43210");
            page.locator("#microfe-popup-login").contentFrame().getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
            page.locator("#microfe-popup-login").contentFrame().locator("#loginPopupCloseBtn svg").click();

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));


        }
    }
}