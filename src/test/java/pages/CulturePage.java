package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CulturePage {

    private final SelenideElement pageHeader = $("[field='tn_text_1470210011265']");

    @Step("Check corporate culture page header")
    public CulturePage checkPageHeader() {
        pageHeader.shouldBe(visible).shouldHave(text("Корпоративная культура"));

        return this;
    }
}
