package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement careerLink = $("[data-tooltip-menu-id='693749960']");
    private final SelenideElement vacanciesLink = $$("[role='menuitem']").findBy(text("Вакансии"));
    private final SelenideElement insideLookLink = $("[data-tooltip-menu-id='503189759']");
    private final SelenideElement cultureLink = $$("[role='menuitem']").findBy(text("Корпоративная культура"));
    private final SelenideElement mediaLink = $("[data-elem-id='1664891553931']");
    private final SelenideElement referralLink = $("[data-elem-id='1664891573598']");
    private final SelenideElement moreDetailedVacancy = $(".survey__link");
    private final SelenideElement firstVacancyTitle = $(".survey__title");
    private final SelenideElement respondVacancy = $$(".survey__footer a").get(1);
    private final SelenideElement moreButton = $(".more-btn");
    private final ElementsCollection vacanciesCards = $$(".survey");
    private final SelenideElement numberOfVacanciesField = $(".watch-more");

    @Step("Open main page")
    public MainPage openMainPage() {
        open("/");

        return this;
    }

    @Step("Open vacancies page from main page")
    public MainPage openVacanciesPage() {
        careerLink.hover();
        vacanciesLink.click();

        return this;
    }

    @Step("Open corporate culture page from main page")
    public MainPage openCulturePage() {
        insideLookLink.hover();
        cultureLink.click();

        return this;
    }

    @Step("Open media page from main page")
    public MainPage openMediaPage() {
        mediaLink.click();

        return this;
    }

    @Step("Open referral page from main page")
    public MainPage openReferralPage() {
        referralLink.click();

        return this;
    }

    @Step("Get first vacancy title on main page")
    public String getFirstVacancyTitle() {

        return firstVacancyTitle.text();
    }

    @Step("Open first vacancy page from main page")
    public MainPage openFirstVacancyPage() {
        moreDetailedVacancy.click();

        return this;
    }

    @Step("Open first vacancy respond modal from main page")
    public MainPage openFirstVacancyRespondModal() {
        respondVacancy.click();

        return this;
    }

    @Step("Load all vacancies cards")
    public MainPage loadAllVacanciesCards() {
        moreButton.click();

        return this;
    }

    @Step("Get number of vacancies")
    public Integer getNumberOfVacancies() {
        String[] vacancyInfo = numberOfVacanciesField.getText().split(" ");
        String lastWord = vacancyInfo[vacancyInfo.length - 1];
        return Integer.parseInt(lastWord);
    }

    @Step("Check that all vacancies cards displayed")
    public MainPage checkThatAllVacanciesCardsDisplayed(Integer numberOfVacancies) {
        vacanciesCards.shouldHave(size(numberOfVacancies))
                .asDynamicIterable().stream().forEach(
                card -> card.shouldNotHave(attribute("[style='display: none;']"))
        );

        return this;
    }
}
