package ru.netology.test;



import com.codeborne.selenide.Condition;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.data.DataHelper;
import ru.netology.page.PymentElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;

import static com.codeborne.selenide.Selenide.*;
import static ru.netology.data.DataHelper.getValidCard;
import static ru.netology.data.SQLHelper.cleanTable;

public class TestDiplom {
    PymentElement element = new PymentElement();




    @AfterAll
    static void teardown(){
        cleanTable();
    }
    @BeforeEach
    void setUp(){
        var pymentElement = open("http://localhost:8080/", PymentElement.class);
    }


    @Test
    void visibleElements(){
        //$(byText("Купить")).click();
        element.clickBuyButton();
        element.buttonVisible();
        element.getAppruveNomber(getValidCard());
       // $("[placeholder='0000 0000 0000 0000']").setValue("444");



    }

}
