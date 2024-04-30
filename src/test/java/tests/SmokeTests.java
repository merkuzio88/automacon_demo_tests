package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

@Tag("automacon_tests")
public class SmokeTests extends TestBase {

    MainPage mainPage = new MainPage();
    VacanciesPage vacanciesPage = new VacanciesPage();
    CulturePage culturePage = new CulturePage();
    MediaPage mediaPage = new MediaPage();
    ReferralPage referralPage = new ReferralPage();
    FirstVacancyPage firstVacancyPage = new FirstVacancyPage();
    RespondVacancyModal respondVacancyModal = new RespondVacancyModal();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open vacancies page and check title")
    void openVacanciesPageAndCheckTitle() {
        mainPage.openMainPage()
                .openVacanciesPage();
        vacanciesPage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open corporate culture page and check title")
    void openCulturePageAndCheckTitle() {
        mainPage.openMainPage()
                .openCulturePage();
        culturePage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open media page and check title")
    void openMediaPageAndCheckTitle() {
        mainPage.openMainPage()
                .openMediaPage();
        mediaPage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open referral page and check title")
    void openReferralPageAndCheckTitle() {
        mainPage.openMainPage()
                .openReferralPage();
        referralPage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Open first vacancy page and check title")
    void openFirstVacancyPageAndCheckTitle() {
        mainPage.openMainPage();
        String vacancyTitle = mainPage.getFirstVacancyTitle();
        mainPage.openFirstVacancyPage();
        firstVacancyPage.checkPageTitle(vacancyTitle);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Open first vacancy respond modal and check error message when required fields not filled")
    void openFirstVacancyRespondModalAndCheckErrorMessage() {
        mainPage.openMainPage()
                .openFirstVacancyRespondModal();
        respondVacancyModal.pressSubmitButton()
                .checkErrorMessage();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Load all vacancies cards and check that all cards displayed")
    void loadAllVacanciesCardsAndCheckThatNumberOfCardsMatches() {
        mainPage.openMainPage();
        Integer numberOfVacancies = mainPage.getNumberOfVacancies();
        mainPage.loadAllVacanciesCards();
        mainPage.checkThatAllVacanciesCardsDisplayed(numberOfVacancies);
    }
}
