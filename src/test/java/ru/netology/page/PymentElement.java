package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PymentElement {
    private SelenideElement buyButton = $(byText("купить"));
    private SelenideElement byOnCredit = $(byText("Купить в кредит"));

    private SelenideElement nomberCard = $("[placeholder='0000 0000 0000 0000'] input");
    private SelenideElement month = $("[placeholder='08'] input");
    private SelenideElement year = $("[placeholder='22'] input");
    private SelenideElement owner = $("[input__control] input");
    private SelenideElement cvvCode = $("[placeholder='999'] input");

    public void nomberCardVisible(){
        nomberCard.shouldBe(visible);
    }

}
