

package org.example;
import com.microsoft.playwright.*;

public class RecordAndPlayAndModify{

    public static void main(String[] args) {

        //command to record and play :
        //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen www.facebook.com"

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.facebook.com/");
            page.getByTestId("open-registration-form-button").click();
            page.getByLabel("First name").click();
            page.getByLabel("First name").fill("yash");
            page.getByLabel("First name").press("Tab");
            page.getByLabel("Surname").fill("chaudhari");
            page.getByLabel("Surname").press("Tab");
            page.locator("#birthday-help").press("Tab");
            page.getByLabel("Day").press("ArrowDown");
            page.getByLabel("Day").selectOption("14");
            page.getByLabel("Day").press("Tab");
            page.getByLabel("Month").press("ArrowUp");
            page.getByLabel("Month").selectOption("10");
            page.getByLabel("Month").press("Tab");
            page.getByLabel("Year").press("ArrowDown");
            page.getByLabel("Year").selectOption("1991");
            page.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
            page.getByLabel("Mobile number or email address").click();
            page.getByLabel("Mobile number or email address").fill("8208009582");
            page.getByLabel("New password").click();
            page.getByLabel("New password").fill("xxxxxxxxxx");
        }
    }
}