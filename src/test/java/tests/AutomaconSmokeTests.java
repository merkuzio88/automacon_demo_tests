package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

@Tag("automacon_tests")
public class AutomaconSmokeTests extends TestBase {

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
    void openVacanciesPageAndCheckTitleTest() {
        mainPage.openMainPage()
                .openVacanciesPage();
        vacanciesPage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open corporate culture page and check title")
    void openCulturePageAndCheckTitleTest() {
        mainPage.openMainPage()
                .openCulturePage();
        culturePage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open media page and check title")
    void openMediaPageAndCheckTitleTest() {
        mainPage.openMainPage()
                .openMediaPage();
        mediaPage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Open referral page and check title")
    void openReferralPageAndCheckTitleTest() {
        mainPage.openMainPage()
                .openReferralPage();
        referralPage.checkPageTitle();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Open first vacancy page and check title")
    void openFirstVacancyPageAndCheckTitleTest() {
        mainPage.openMainPage();
        String vacancyTitle = mainPage.getFirstVacancyTitle();
        mainPage.openFirstVacancyPage();
        firstVacancyPage.checkPageTitle(vacancyTitle);
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Open first vacancy respond modal and check error message when required fields not filled")
    void openFirstVacancyRespondModalAndCheckErrorMessageTest() {
        mainPage.openMainPage()
                .openFirstVacancyRespondModal();
        respondVacancyModal.pressSubmitButton()
                .checkErrorMessage();
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Load all vacancies cards and check that all cards displayed")
    void loadAllVacanciesCardsAndCheckThatNumberOfCardsMatchesTest() {
        mainPage.openMainPage();
        Integer numberOfVacancies = mainPage.getNumberOfVacancies();
        mainPage.loadAllVacanciesCards();
        mainPage.checkThatAllVacanciesCardsDisplayed(numberOfVacancies);
    }
}
