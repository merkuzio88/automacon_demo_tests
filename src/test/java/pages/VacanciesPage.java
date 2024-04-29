package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class VacanciesPage {

    private final SelenideElement pageHeader = $(".survey-h3");

    @Step("Check vacancies page header")
    public VacanciesPage checkPageHeader() {
        pageHeader.shouldBe(visible).shouldHave(text("Вакансии"));

        return this;
    }
}
