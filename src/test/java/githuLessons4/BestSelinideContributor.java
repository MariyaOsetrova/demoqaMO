package githuLessons4;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// првоерка на сайте иконки пользователя
public class BestSelinideContributor {
    @Test
    void andreiSolntsevShouldBeTheBestContributor(){
// 1. Открыть страницу selenide
        open ("https://github.com/selenide/selenide");
// 2. Подвести мышку к первому элементу в области Contributor
        $(".BorderGrid ").$(byText("Contributors"))
        .closest("div")/*переходим вверх в ближайшему div*/.$("ul li")/*спускаемся вниз сначала к ul. потом к li*/.hover()/*подвести мышку и удержать*/; // идем по дереву ВВЕРХ
// 3. Проверка: в появившемся окошечке (overlay) текст     Andrei Solntsev
        sleep(5000);
        $(".Popover-message").shouldHave(text("Andrei Solntsev"));
        // если будет несколько .Popover-message, то можно отфильтровать видимые толкьо
    //    $$(".Popover-message").findBy(visible).shouldHave(text("Andrei Solntsev"));
    }
}
