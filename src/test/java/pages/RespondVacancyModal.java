package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RespondVacancyModal {

    private final SelenideElement modalTitle = $("[id='popuptitle_735511805']");
    private final SelenideElement submitButton = $(".t-submit");
    private final SelenideElement errorMessage = $(".t-form__errorbox-link");

    @Step("Press submit button in respond vacancy modal")
    public RespondVacancyModal pressSubmitButton() {
        modalTitle.shouldBe(visible);
        submitButton.click();

        return this;
    }

    @Step("Check error message when required fields are not filled")
    public RespondVacancyModal checkErrorMessage() {
        errorMessage.shouldBe(visible).shouldHave(text("Пожалуйста, заполните все обязательные поля"));

        return this;
    }
}
