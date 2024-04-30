package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VacanciesPage {

    private final SelenideElement pageTitle = $(".survey-h3");

    @Step("Check vacancies page title")
    public VacanciesPage checkPageTitle() {
        pageTitle.shouldBe(visible).shouldHave(text("Вакансии"));

        return this;
    }
}
