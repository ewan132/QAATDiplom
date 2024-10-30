package ru.netology.test;



import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.netology.data.SQLHelper;
import ru.netology.page.PymentElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.getNoValidCard;
import static ru.netology.data.DataHelper.getValidCard;
import static ru.netology.data.SQLHelper.cleanTable;

public class TestDiplom {
    PymentElement element = new PymentElement();




/*
    @AfterAll
    static void teardown(){
        cleanTable();
    }
*/

    @BeforeEach
    void setUp(){
        var pymentElement = open("http://localhost:8080/", PymentElement.class);
    }


    @Test
    void visibleElements(){
        element.clickBuyOnCreditButton();
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getNoValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 0;
        System.out.println(SQLHelper.getCreditStatus());
        Assertions.assertEquals(exp,actual);


    }
    @Test
    void visibleElementsq(){
        element.clickBuyOnCreditButton();
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 1;
        System.out.println(SQLHelper.getCreditStatus());
        Assertions.assertEquals(exp,actual);
    }
    @Test
    void visibleElementsw(){
        element.clickBuyOnCreditButton();
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 1;
        System.out.println(SQLHelper.getCreditStatus());
        Assertions.assertEquals(exp,actual);
    }
}
