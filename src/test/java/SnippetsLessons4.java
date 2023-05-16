
package selenide;

import com.codeborne.selenide.*;
import org.openqa.selenium.*;

import java.io.*;
import java.time.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.empty;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

// this is not a full list, just the most common
public class SnippetsLessons4 {

    void browser_command_examples() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!! КОМАНДЫ БРАУЗЕРА!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        open("https://google.com");
        open("/customer/orders");
        open("/", AuthenticationType.BASIC, "user", "password");

        Selenide.back(); // назад на страницу
        Selenide.refresh(); // перезагрузка страницы

        // чистка куки
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();

        // Окна с информацией  https://the-internet.herokuapp.com/javascript_alerts
        Selenide.confirm(); // OK - in alert dialogs
        Selenide.dismiss(); // Cancel -  in alert dialogs

        //закрытия окна / браузера
        Selenide.closeWindow(); // close active tab
        Selenide.closeWebDriver(); // close browser completely

        //https://the-internet.herokuapp.com/frames
        // страничка внутри странички
        Selenide.switchTo().frame("new"); // переключаемся внутри странички
        Selenide.switchTo().defaultContent(); // возвращаемся на основную страничку

        // перепрыгивание с одной закладки на другую
        Selenide.switchTo().window("The Internet");
    }

    void selectors_examples() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!СЕЛЕКТОРЫ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        $("div").click();
        // =
        element("div").click();

        $("div", 2).click(); // нужен конкретный div

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click(); //полный текст
        $(withText("ull tex")).click(); //часть текста

        $("").parent();       // родитель
        $("").sibling(2);     // элемент одного уровня в дереве, расчет с верху вниз
        $("").preceding(0);   // элемент одного уровня в дереве, расчет с низу вверх
        $("").closest("div"); // переходим вверх в ближайшему div

        $("div").$("h1").find(byText("abc")).click(); // поиск по дереву

        // аналоги с более коротким кодом
        $(byAttribute("abc", "x")).click();
        //    =
        $("[abc=x]").click();

        $(byId("mytext")).click();
        //    =
        $("#mytext").click();

        $(byClassName("red")).click();
        //    =
        $(".red").click();
    }

    void actions_examples() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!ДЕЙСТВИЯ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        $("").click(); // выбрать
        $("").doubleClick(); // двойной клик
        $("").contextClick(); // клик ПКМ

        $("").hover();// подвести мышку

        $("").setValue("text"); // ввести текст / очищает
        $("").append("text"); // добавляет текст, не очищает
        $("").clear(); // очищение
        $("").setValue(""); // очищение


        //нажатие на кнопки на клаве
        $("div").sendKeys("c"); //
        actions().sendKeys("c").perform(); //
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform(); // Ctrl + F
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        //нажатие на кнопки на клаве
        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        // complex actions with keybord and mouse, example
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // old html actions don't work with many modern frameworks
        //https://the-internet.herokuapp.com/dropdown
        $("").selectOption("dropdown_option"); // выбор из списка
        $("").selectRadio("radio_options"); // выбор радио баттона

    }

    void assertions_examples() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!УТВЕРЖДЕНИЯ/ПРОВЕРКИ до ()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        /*
    $(“input”).should(exist) -Проверьте, что элемент должен существовать
$(“input”).shouldBe(visible) -Validation element должен быть видимым
$(“input”).shouldHave(exactText(“Some text”)) -Проверьте, что текст элемента равен Some text
$(“input”).shouldHave(value(“John”)) -Проверьте, что значение атрибута элемента равно John ""
$(“#input”).shouldHave(id(“myForm”)) -Проверьте, что атрибут id элемента равен «myForm»
$ ("# btn-Search"). shouldHave (текст ("Поиск")) -Убедитесь, что элемент содержит текст «поиск»
$ ("# btn-Search"). shouldNotHave (текст ("Поиск")) -Убедитесь, что элемент не содержит "поискового" текста
*/

        $("").shouldBe(visible); // проверка видимости
        $("").shouldNotBe(visible);// проверка НЕ видимости
        $("").shouldHave(text("abc"));// проверка видимости
        $("").shouldNotHave(text("abc"));// проверка НЕ видимости
        $("").should(appear);// проверка видимости
        $("").shouldNot(appear);// проверка НЕ видимости


        //ТАЙМАУТЫ
        $("").shouldBe(visible, Duration.ofSeconds(30));
        $("").waitUntil(visible, 30000);  //is deprecated

    }

    void conditions_examples() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!УСЛОВИЯ, которые в ()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        $("").shouldBe(visible); // visible видно
        $("").shouldBe(hidden); // hidden не видно

        $("").shouldHave(text("abc")); // текст abc
        $("").shouldHave(exactText("abc")); // точый текст
        $("").shouldHave(textCaseSensitive("abc")); // регистр
        $("").shouldHave(exactTextCaseSensitive("abc")); // и текст и регистр
        $("").should(matchText("[0-9]abc$")); // полное совпадение

        $("").shouldHave(cssClass("red")); //проверка одного из класса в длинном классе

        $("").shouldHave(cssValue("font-size", "12"));
        $("").shouldHave(cssValue("color", "12"));// проверка свойств объекта Console - Computed (полезно цвет проверять)

        $("").shouldHave(value("25")); // текста
        $("").shouldHave(exactValue("25")); // точное значение
        $("").shouldBe(empty); // ничего не находится

        // првоерка атрибутов data-csrf / value / width и тд
        $("").shouldHave(attribute("disabled")); // просто что есть
        $("").shouldHave(attribute("name", "example")); // какое-то значение
        $("").shouldHave(attributeMatching("name", "[0-9]abc$"));

        // включен или нет чекбокс
        $("").shouldBe(checked); // for checkboxes

        // Warning! Only checks if it is in DOM, not if it is visible! You don't need it in most tests!
        $("").should(exist);

        // Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
        $("").shouldBe(disabled);
        $("").shouldBe(enabled);
    }

    void collections_examples() {
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
       // “Два доллара” же может быть удобно использовать когда нужный элемент является одним из группы однотипных элементов
        //!!!!!!!!!!!!!!!!!КОЛЛЕКЦИИ $$
        // приводим к одному элементу, на коллекцию не можем кликнуть
        // Selenide позволяет вам очень удобно работать с коллекциями элементов.
        // Вы можете проверять сразу множество элементов в одной строке.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //https://habr.com/ru/articles/274071/

        $$("div"); // does nothing!

        // selections
        $$("div").filterBy(text("123")).shouldHave(size(1)); // фильтр подмножества элементов
        $$("div").excludeWith(text("123")).shouldHave(size(1)); // исключить из проверки

        $$("div").first().click();
        elements("div").first().click();
        // $("div").click();
        $$("div").last().click();

        $$("div").get(1).click(); // the second! (start with 0)
        $("div", 1).click(); // same as previous

        $$("div").findBy(text("123")).click(); //  finds first

        // assertions
        $$("").shouldHave(size(0));
        $$("").shouldBe(CollectionCondition.empty); // the same

        $$("").shouldHave(texts("Alfa", "Beta", "Gamma")); // в коллекции 3 элемента
        $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma")); // в коллекции ровно 3 таких элемента

        $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa"));
        $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));

        $$("").shouldHave(itemWithText("Gamma")); // only one text // ищем только текст

        $$("").shouldHave(sizeGreaterThan(0)); // чтобы что-то было не не 0
        $$("").shouldHave(sizeGreaterThanOrEqual(1));
        $$("").shouldHave(sizeLessThan(3)); // максимум 3 элемента
        $$("").shouldHave(sizeLessThanOrEqual(2));

    }

    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!ОПЕРАЦИИ С ФАЙЛАМИ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    void file_operation_examples() throws FileNotFoundException {

        //скачать файл
        //https://the-internet.herokuapp.com/download
        File file1 = $("a.fileLink").download(); // only for <a href=".."> links
        File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // more common options, but may have problems with Grid/Selenoid

        //https://the-internet.herokuapp.com/upload
        File file = new File("src/test/resources/readme.txt");
        $("#file-upload").uploadFile(file);
        $("#file-upload").uploadFromClasspath("readme.txt");
        // нажать на кнопку!!!!!!
        $("uploadButton").click();
    }



    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!javascript_examples!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    void javascript_examples() {
        executeJavaScript("alert('selenide')"); // вариант запуска без агрумента
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);// вариант запуска с аргументом
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7); // вариант запуска с аргументом + что бы что-то возвращало
    }
}
