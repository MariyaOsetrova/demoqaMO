package ru.company.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;


public class TextBoxTests {
 /*  @BeforeEach
    public  void setup(){
        //определение пути до драйвера и его настройка

        //создание экземпляра драйвера
        WebDriver driver = new ChromeDriver();
        //окно разворачивается на полный экран
 //       driver.manage().window().maximize();
 //       driver.get("https://demoqa.com/text-box");
        //open ("https://demoqa.com/text-box"); //открываем сайт
        //задержка на выполнение теста = 10 сек.
 //       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }*/

    @BeforeAll
    static void beforAll(){
        Configuration.startMaximized = true; // запуск теста в развернутом окне
        Configuration.pageLoadStrategy = ("none"); // обошла то что висят методы, и у урла прелоадер
        /*pageLoadStrategy supports 3 different values as follows:
normal (full page load)
eager (interactive)
none*/
    }

    @Test
    void fillFormTest(){ // заполнить форму теста
        String permanentAddress = "Адрес2";

        open("https://demoqa.com/text-box");
        $("#userName").setValue("ВвелаИмя"); // ввели в поле имя
        $("#userEmail").setValue("mail@mail.ru"); // ввели почту
        $("input#currentAddress").setValue("Адрес1");// ввели адрес1
        $("#permanentAddress").setValue("Адрес2");// ввели адрес2
        $("#submit").click();
        $("#output #name").shouldHave(text("ВвелаИмя"));
        $("#output #email").shouldHave(text("mail@mail.ru"));
        $("#output p#currentAddress").shouldHave(text("Адрес1"));
        $("#output #permanentAddress").shouldHave(text(permanentAddress)); // пример как через переменную, String permanentAddress = "Адрес2";

    }
}
