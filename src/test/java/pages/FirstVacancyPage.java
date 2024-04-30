package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FirstVacancyPage {

    private final SelenideElement pageTitle = $("[field='tn_text_1470233923389']");

    @Step("Check first vacancy page title")
    public FirstVacancyPage checkPageTitle(String title) {
        pageTitle.shouldBe(visible).shouldHave(text(title));

        return this;
    }
}
