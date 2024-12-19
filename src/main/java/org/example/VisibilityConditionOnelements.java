package org.example;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibilityConditionOnelements {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();

        //button:visible : this will check how many button are visible and will return a list of them.
        //button >> visible=true : this will check how many button are visible and will return a list of them.

//		page.navigate("http://127.0.0.1:5500/main/index.html");
//		//String text = page.locator("button:visible").textContent();
//		String text = page.locator("button >> visible=true").textContent();
//
//		System.out.println(text);

        page.navigate("https://www.amazon.com/");
        List<String> linksText = page.locator("a:visible").allInnerTexts();

        for(int i=0; i<linksText.size(); i++) {
            System.out.println(linksText.get(i));
        }

        int imagesCount = page.locator("xpath=//img >> visible=true").count();
        System.out.println(imagesCount);

        //text=Login >> visible=true

    }

}
