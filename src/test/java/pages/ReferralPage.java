package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ReferralPage {

    private final SelenideElement pageTitle = $("[field='tn_text_1470210011265']");

    @Step("Check vacancies page title")
    public ReferralPage checkPageTitle() {
        pageTitle.shouldBe(visible).shouldHave(text("Реферальная программа «Автомакон Таланты»"));

        return this;
    }
}
