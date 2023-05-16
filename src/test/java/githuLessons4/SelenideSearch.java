package githuLessons4;

/*
УРОК 4
1. открыть страницу github.com
2. ввести в поиск selenide
 3. нажать Enter
4. нажимаем на линк от первого результатат поиска
5. проверка: в заголовке встречается selenide/selenide
* */
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {

    @Test
    void shouldFineSelinideRepositiryPage() { // поиск нужного репозитория на сайте
        // 1. открыть страницу github.com
         open("https://github.com");
        // 2. ввести в поиск selenide
        // 3. нажать Enter
        $(byClassName("header-search-input")).setValue("selenide").pressEnter();
        // 4. нажимаем на линк от первого результатат поиска
        /*$$ (css-селектор)
При работе с отдельным элементом в Selenide мы используем знак $, который возвращает нам один элемент. Для работы с несколькими элементами нам нужно использовать знак $$, чтобы вернуть коллекцию элементов. */
        $$(".repo-list").first().$("a").click();// поиск в листе первого элемента и внутри ищем элемент a -  выбор
        // 5. проверка: в заголовке встречается selenide/selenide
        $(byClassName("fn")).should(text("selenide"));
        $(byClassName("mx-1")).should(text("/"));
        $("[href='/selenide/selenide']").should(text("selenide"));

        //arrange подготовка
        //act действие
        //assert проверка
        //act действие
        //act действие
        //act действие
        //assert проверка
        //act действие
        //assert проверка

    }
}