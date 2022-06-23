package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {



     @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1400x760";
        Configuration.browserPosition = "-10x0"; // экран был не по центру
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browser = "firefox";
    }
    @Test
    void dragAndDrop() {

        open("/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));
    }
}

