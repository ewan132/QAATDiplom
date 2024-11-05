package ru.netology.test;


<<<<<<< HEAD

//import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

=======
import org.junit.jupiter.api.*;
>>>>>>> eb1f68a9732130b299f44bc3bf3d7be97d71f1bd
import ru.netology.data.SQLHelper;
import ru.netology.page.PymentElement;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;
import static ru.netology.data.SQLHelper.cleanTable;
import static ru.netology.data.SQLHelper.getCreditStatus;


public class TestDiplom {
    PymentElement element = new PymentElement();
<<<<<<< HEAD
    //private int countAfter ;
    //private int countBefore ;

/*
=======

>>>>>>> eb1f68a9732130b299f44bc3bf3d7be97d71f1bd
    @AfterAll
    static void teardown() {
        cleanTable();
<<<<<<< HEAD
    }*/

=======
    }
>>>>>>> eb1f68a9732130b299f44bc3bf3d7be97d71f1bd

    @BeforeEach
    void setUp() {
        var pymentElement = open("http://localhost:8080/", PymentElement.class);
    }


    @Test
<<<<<<< HEAD
    void visibleElements(){
        element.clickBuyOnCreditButton();
=======
    @DisplayName("Отображение элементов, приобретение билета в кредит со статусом DECLINED")
    void visibleElementsAndBuyOnCreditDec() {
        element.clickBuyOnCreditButton();
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getNoValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 0; // значение = 0 означает статус DECLINED
        Assertions.assertEquals(exp, actual);


    }

    @Test
    @DisplayName("Приобретение билета в кредит со статусом APPROVED")
    void byOnCreditApp() {
        element.clickBuyOnCreditButton();
        element.getAppruveNomberq(getValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getCreditStatus();
        int exp = 1; // значение = 1 означает статус APPROVED
        Assertions.assertEquals(exp, actual);
    }

    @Test
    @DisplayName("Отображение элементов, приобретение билета покупкой со статусом APPROVED")
    void visibleElementsAndBuyApp() {
        element.clickBuyButton();
>>>>>>> eb1f68a9732130b299f44bc3bf3d7be97d71f1bd
        element.buttonVisible();
        element.elementsVisible();
        element.getAppruveNomberq(getValidCard());
        element.comledetPayVisible();
<<<<<<< HEAD

=======
        int actual = SQLHelper.getBuyStatus();
        int exp = 1;
        System.out.println(SQLHelper.getBuyStatus());
        Assertions.assertEquals(exp, actual);
>>>>>>> eb1f68a9732130b299f44bc3bf3d7be97d71f1bd
    }

    @Test
    @DisplayName("Приобретение билета покупкой со статусом DECLINED")
    void visibleElementsAndBuyDec() {
        element.clickBuyButton();
        element.getAppruveNomberq(getNoValidCard());
        element.comledetPayVisible();
        int actual = SQLHelper.getBuyStatus();
        int exp = 0;
        System.out.println(SQLHelper.getBuyStatus());
        Assertions.assertEquals(exp, actual);
    }

    @Test
    @DisplayName("Пустое поле Номер карты")
    void emptyNomberCard() {
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyNumberCard());
        element.invalidFormat();
    }

    @Test
    @DisplayName("Пустое поле Месяц")
    void emptyMonth() {
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyMonth());
        element.invalidFormat();
    }

    @Test
    @DisplayName("Пустое поле Год")
    void emptyYear() {
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyYear());
        element.invalidFormat();
    }

    @Test
    @DisplayName("Пустое поле Владелец")
    void emptyOwner() {
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyName());
        element.emptyOwner();
    }

    @Test
    @DisplayName("Пустое поле CVV")
    void emptyCVVCode() {
        element.clickBuyButton();
        element.getAppruveNomberq(getEmptyCVC());
        element.invalidFormat();
    }

    @Test
    @DisplayName("Нулевой месяц")
    void zeroMonth() {
        element.clickBuyButton();
        element.getAppruveNomberq(getZeroMonth());
        element.invalidFormat();
    }

    @Test
    @DisplayName("Месяц меньше Today")
    void monthMinToday() {
        element.clickBuyButton();
        element.getAppruveNomberq(getYearLessToday());
        element.yearLessToday();
    }


}
