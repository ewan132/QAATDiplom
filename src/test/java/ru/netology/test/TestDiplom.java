package ru.netology.test;



import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;

import ru.netology.data.SQLHelper;
import ru.netology.page.PymentElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.data.DataHelper.*;
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
    @DisplayName("Отображение элементов, приобретение билета в кредит со статусом DECLINED")
    void visibleElementsAndBuyOnCreditDec(){
        element.clickBuyOnCreditButton();
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getNoValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 0; // значение = 0 означает статус DECLINED
        Assertions.assertEquals(exp,actual);


    }
    @Test
    @DisplayName("Приобретение билета в кредит со статусом APPROVED")
    void byOnCreditApp(){
        element.clickBuyOnCreditButton();
        element.getAppruveNomberq(getValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 1; // значение = 1 означает статус APPROVED
        Assertions.assertEquals(exp,actual);
    }
    @Test
    @DisplayName("Отображение элементов, приобретение билета покупкой со статусом APPROVED")
    void visibleElementsAndBuyApp(){
        element.clickBuyButton();
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getBuyStatus();
        int exp = 1;
        System.out.println(SQLHelper.getBuyStatus());
        Assertions.assertEquals(exp,actual);
    }

    @Test
    @DisplayName("Приобретение билета покупкой со статусом DECLINED")
    void visibleElementsAndBuyDec(){
        element.clickBuyButton();
        element.getAppruveNomberq(getNoValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getBuyStatus();
        int exp = 0;
        System.out.println(SQLHelper.getBuyStatus());
        Assertions.assertEquals(exp,actual);
    }
    @Test
    @DisplayName("Пустое поле Номер карты")
    void emptyNomberCard(){
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyNumberCard());
        element.emptyNomberCArdAndMoth();
    }
    @Test
    @DisplayName("Пустое поле Месяц")
    void emptyMonth(){
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyMonth());
        element.emptyNomberCArdAndMoth();
    }
    @Test
    @DisplayName("Пустое поле Год")
    void emptyYear(){
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyYear());
        element.emptyNomberCArdAndMoth();
    }
    @Test
    @DisplayName("Пустое поле Владелец")
    void emptyOwner(){
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyName());
        element.emptyOwner();
    }
    @Test
    @DisplayName("Пустое поле CVV")
    void emptyCVVCode(){
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyCVC());
        element.emptyNomberCArdAndMoth();
    }

}
