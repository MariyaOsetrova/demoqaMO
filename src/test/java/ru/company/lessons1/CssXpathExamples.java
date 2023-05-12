package ru.company.lessons1;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$x;

public class CssXpathExamples {
/*
    Css - поиск локатора
   Xpath - поиск локатора

   $("h1")           Css
   $x("h1//")        Xpath


 */
 /*   void cssXpathExamples(){
        // <input type="email" class="inputtext login_form_input_box" name="email" id="email" data-testid="email">
        //обращение к элементу разными способами:
        // хорошо когда есть id и data-testid
        $("[data-testid=email]");
        $(by("data-testid", "email"));

        // <input type="email" class="inputtext login_form_input_box" name="email" id="email"
        // нет data-testid

        //CSS
        $("#email");
        $(byId("email"));
        $(By.id("email"));
        $("[id=email]");
        $("[id='email']");
        $("[id=\"email\"]");
        $(by("id", "email"));
        $("input#email");
        $("input[id=email]");

        //XPATH
        $x("//*[@id='email']");
        $(byXpath("//*[@id='email']"));

        // <input type="email" class="inputtext login_form_input_box" name="email"
        // нет id и data-testid
        $("[name='email']");
        $(byName("email"));

        // <input type="email" class="inputtext login_form_input_box"
        // нет id и data-testid и name
        $(byClassName("login_form_input_box"));
        $(".login_form_input_box");
        $(".inputtext.login_form_input_box");
        $x("//*[@class='login_form_input_box']");

        // как в 48, но в class только inputtext
        // <div type="email" class="inputtext">
        //      <input class="login_form_input_box">
        // </div>
        $(".inputtext .login_form_input_box"); // !!!!!!!!!!!!ставим ПРОБЕЛ после inputtext

        //<div>Привет</div>
        $(byText("Привет"));
        $(withText("При"));

        // календарь-дата
        <div class="react-datepicker__day react-datepicker__day--016 react-datepicker__day--weekend" tabindex="-1" aria-label="Choose Sunday, April 16th, 1989" role="option" aria-disabled="false">16</div>

                $("div[aria-label='Choose Sunday, April 16th, 1989']").click();


  // выбор из выпадающего списка
        $("#subjectsInput").setValue("English");
        $(byClassName("subjects-auto-complete__menu")).click();

 // загрузка файла по кнопке
        $("#uploadPicture").uploadFile(new File("src/test/data/Снимок.JPG"));

    }
*/
}

