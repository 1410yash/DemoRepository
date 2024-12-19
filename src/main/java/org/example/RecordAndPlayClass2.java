

package org.example;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;


public class RecordAndPlayClass2 {

    //command to record and play :
    // mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="codegen https://parabank.parasoft.com/
    // Here I am traversing through 3 different tabs : parabank,facebook and amazon
    // Here, I have set environment variable to debug in this class : PWDEBUG=1

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://parabank.parasoft.com/parabank/index.htm;jsessionid=F3B1DE49BFB2B17118EF4E31D6CC9C86");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Register")).click();
            page.locator("[id=\"customer\\.firstName\"]").click();
            page.locator("[id=\"customer\\.firstName\"]").fill("yash");
            page.locator("[id=\"customer\\.firstName\"]").press("Tab");
            page.locator("[id=\"customer\\.lastName\"]").fill("chaudhari");
            page.locator("[id=\"customer\\.lastName\"]").press("Tab");
            page.locator("[id=\"customer\\.address\\.street\"]").fill("abcd");
            page.locator("[id=\"customer\\.address\\.street\"]").press("Tab");
            page.locator("[id=\"customer\\.address\\.city\"]").fill("akola");
            page.locator("[id=\"customer\\.address\\.city\"]").press("Tab");
            page.locator("[id=\"customer\\.address\\.state\"]").fill("Punjab");
            page.locator("[id=\"customer\\.address\\.state\"]").press("Tab");
            page.locator("[id=\"customer\\.address\\.zipCode\"]").fill("444829");
            page.locator("[id=\"customer\\.address\\.zipCode\"]").press("Tab");
            page.locator("[id=\"customer\\.phoneNumber\"]").fill("12434523534");
            page.locator("[id=\"customer\\.ssn\"]").click();
            page.locator("[id=\"customer\\.ssn\"]").fill("234345");
            page.locator("[id=\"customer\\.username\"]").click();
            page.locator("[id=\"customer\\.username\"]").fill("yash@12345243");
            page.locator("[id=\"customer\\.password\"]").click();
            page.locator("[id=\"customer\\.password\"]").fill("xxxxxxxxxxxx");
            Page page1 = context.newPage();
            page1.navigate("https://www.facebook.com/");
            page1.getByTestId("open-registration-form-button").click();
            page1.getByLabel("First name").click();
            page1.getByLabel("First name").fill("yash");
            page1.getByLabel("First name").press("Tab");
            page1.getByLabel("Surname").fill("chaudahri");
            page1.getByLabel("Surname").press("Tab");
            page1.locator("#birthday-help").press("Tab");
            page1.getByLabel("Day").selectOption("17");
            page1.getByLabel("Day").selectOption("14");
            page1.getByLabel("Day").press("Tab");
            page1.getByLabel("Month").selectOption("10");
            page1.getByLabel("Month").press("Tab");
            page1.getByLabel("Year").selectOption("1999");
            page1.getByLabel("Year").selectOption("1991");
            page1.getByLabel("Male", new Page.GetByLabelOptions().setExact(true)).check();
            Page page2 = context.newPage();
            page2.navigate("https://www.amazon.com/");
            page2.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue shopping")).click();
        }
    }
}