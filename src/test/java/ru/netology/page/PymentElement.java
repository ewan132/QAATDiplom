package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PymentElement {
    private SelenideElement buyButton = $(byText("Купить"));
    private SelenideElement buyOnCredit = $(byText("Купить в кредит"));
    private SelenideElement continueButton = $(byText("Продолжить"));

    private SelenideElement nomberCard = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement month = $("[placeholder='08']");
    private SelenideElement year = $("[placeholder='22']");
    private SelenideElement owner = $$("[class=input__inner]").findBy(text("Владелец")).$("[class=input__control]");
    private SelenideElement cvvCode = $("[placeholder='999']");

    private SelenideElement cardIncorrect = $$("[class=input__inner]").findBy(text("Номер карты"))
            .$(withText("Неверный формат"));
    private SelenideElement monthIncorrect = $$("[class=input__inner]").findBy(text("Месяц"))
            .$(withText("Неверный формат"));
    private SelenideElement yearIncorrect = $$("[class=input__inner]").findBy(text("Год"))
            .$(withText("Неверный формат"));
    private SelenideElement nameIncorrect = $$("[class=input__inner]").findBy(text("Владелец"))
            .$(withText("Поле обязательно для заполнения"));
    private SelenideElement cvcIncorrect = $$("[class=input__inner]").findBy(text("CVC/CVV"))
            .$(withText("Неверный формат"));

    private SelenideElement completedPay = $(byText("Операция одобрена Банком."));

//добавить табличку "Одобрение платежа"

    public void buttonVisible(){
        buyButton.shouldBe(visible);
        buyOnCredit.shouldBe(visible);
    }
    public void elementsVisible(){
        nomberCard.shouldBe(visible);
        month.shouldBe(visible);
        year.shouldBe(visible);
        owner.shouldBe(visible);
        cvvCode.shouldBe(visible);
        continueButton.shouldBe(visible);


    }

    public void comledetPayVisible(){
        completedPay.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void clickBuyButton(){
        buyButton.click();
    }
    public void clickBuyOnCreditButton(){
        buyOnCredit.click();
    }

    public void getAppruveNomberq(DataHelper.cardInfo cardInfo) {
        nomberCard.setValue(cardInfo.getCardNubmer());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYars());
        owner.setValue(cardInfo.getNameOwner());
        cvvCode.setValue(cardInfo.getCvc());
        continueButton.click();
    }

}
