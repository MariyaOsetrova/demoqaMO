package ru.company.lessons2;

import org.junit.jupiter.api.*;

public class DemoQATest {

    @BeforeAll // обернет разом все тесты
    static void beforAll(){
        System.out.println("Первый самы и обернем ВСЕ тесты\n");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("Самый последний после всех ТЕСТОВ\n");
    }

    @BeforeEach // обернет каждый тест
    void beforEach(){
        System.out.println("Выводим ПЕРЕД текстом\n");
    }

    @AfterEach // обернет каждый тест, стр 20-23 и потом еще 25-28
    void AfterEach(){
        System.out.println("Выводим ПОСЛЕ теста\n");

    }

    @Test // аннотация 1
    void ferstTest(){
        System.out.println("ПЕрвый тест, без MAIN, т.к поиск методов @Test по имени вызывает их\n");
    }

    @Test // аннотация 2
    void secondTest(){
        System.out.println("Второй тест, без MAIN, т.к поиск методов @Test по имени вызывает их\n");
    }
}
