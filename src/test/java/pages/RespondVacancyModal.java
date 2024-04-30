package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        String[] expectedTexts = {"Please fill out all required fields", "Пожалуйста, заполните все обязательные поля"};

        assertTrue(Arrays.stream(expectedTexts)
                        .anyMatch(text -> errorMessage.getText().equals(text)),
                "Error message doesn't match any expected text");

        return this;
    }
}
