package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/*
    Вопрос:
    Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?
    Если может - приведите пример, когда.
    Ответ:
    $("h1 div") - будет искать первый элемент h1 с div внутри
    $("h1").$("div") - будет искать первый элемент h1 и внутри этого элемента произойдёт попытка найти первый div
*/



public class SelenideWikiCheck {

    //Разработайте следующий автотест:
    //- Откройте страницу Selenide в Github
    //- Перейдите в раздел Wiki проекта
    //- Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    //- Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5

    String selenideGitHubUrl = "https://github.com/selenide/selenide";



    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1200x760";
        Configuration.browser = "firefox";
    }

    @Test
    void expectJUnitExampleAtSelenideWiki(){
        Selenide.open(selenideGitHubUrl);
        $(byId("wiki-tab")).click();
        $(byId("wiki-body")).shouldHave(text("Soft assertions"));
        $(byText("Soft assertions")).click();
        $$("h4").findBy(Condition.text("Using JUnit5 extend test class")).sibling(0)
                .shouldHave(Condition.text("@ExtendWith({SoftAssertsExtension.class})"));
    }
}


