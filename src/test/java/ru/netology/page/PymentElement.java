package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PymentElement {
    private SelenideElement buyButton = $(byText("купить"));
    private SelenideElement buyOnCredit = $(byText("Купить в кредит"));
    private SelenideElement continueButton = $(byText("Продолжить"));

    private SelenideElement nomberCard = $("[placeholder='0000 0000 0000 0000'] input");
    private SelenideElement month = $("[placeholder='08'] input");
    private SelenideElement year = $("[placeholder='22'] input");
    private SelenideElement owner = $("[input__control] input");
    private SelenideElement cvvCode = $("[placeholder='999'] input");
//Добавить элементы ошибок каждого поля
//добавить табличку "Одобрение платежа"

    public void elementsVisible(){
        nomberCard.shouldBe(visible);
        month.shouldBe(visible);
        year.shouldBe(visible);
        owner.shouldBe(visible);
        cvvCode.shouldBe(visible);
        buyButton.shouldBe(visible);
        buyOnCredit.shouldBe(visible);
    }

    public void clickBuyButton(){
        buyButton.click();
    }
    public void clickBuyOnCreditButton(){
        buyOnCredit.click();
    }

    public void getAppruveNomberCArd(DataHelper.cardInfo cardInfo) {
        nomberCard.setValue(cardInfo.getCardNubmer());
        month.setValue(cardInfo.getMonth());
        year.setValue(cardInfo.getYars());
        owner.setValue(cardInfo.getNameOwner());
        cvvCode.setValue(cardInfo.getCvc());
        continueButton.click();
    }
}
