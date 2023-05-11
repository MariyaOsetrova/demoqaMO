package ru.company.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {
    @Test
    void fillFormTest(){ // заполнить форму теста
        open ("https://demoqa.com/text-box"); //открываем сайт
     //   sleep(30000);
        $("#userName").setValue("ВвелаИмя"); // ввели в поле имя
        $("#userEmail").setValue("mail@mail.ru"); // ввели почту
        $("#currentAddress").setValue("Адрес1");// ввели адрес1
        $("#permanentAddress").setValue("Адрес2");// ввели адрес2
        $("#submit").click();

    }
}
