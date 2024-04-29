package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.*;

public class SmokeTests extends TestBase {

    MainPage mainPage = new MainPage();
    VacanciesPage vacanciesPage = new VacanciesPage();
    CulturePage culturePage = new CulturePage();
    MediaPage mediaPage = new MediaPage();
    ReferralPage referralPage = new ReferralPage();

    @Test
    @Tag("automacon_tests")
    void openVacanciesPageAndCheckHeader() {
        mainPage
                .openMainPage()
                .openVacanciesPage();
        vacanciesPage
                .checkPageHeader();
    }

    @Test
    @Tag("automacon_tests")
    void openCulturePageAndCheckHeader() {
        mainPage
                .openMainPage()
                .openCulturePage();
        culturePage
                .checkPageHeader();
    }

    @Test
    @Tag("automacon_tests")
    void openMediaPageAndCheckHeader() {
        mainPage
                .openMainPage()
                .openMediaPage();
        mediaPage
                .checkPageHeader();
    }

    @Test
    @Tag("automacon_tests")
    void openReferralPageAndCheckHeader() {
        mainPage
                .openMainPage()
                .openReferralPage();
        referralPage
                .checkPageHeader();
    }
}
