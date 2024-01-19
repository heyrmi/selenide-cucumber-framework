package io.github.heyrmi;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;


public class FirstTest {
    String url = "https://www.google.com";

    @Test
    public void firstTest() {
        open(url);
        $(By.name("q")).setValue("Playwright").pressEnter();
        $("div[data-attrid='title']").shouldBe(visible, text("Playwright"));
    }
}
