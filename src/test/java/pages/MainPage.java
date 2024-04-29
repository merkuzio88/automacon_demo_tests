package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
    private final SelenideElement respondVacancy = $$(".survey__footer a").get(1);
    private final SelenideElement moreButton = $(".more-btn");

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
}
