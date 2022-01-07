package online.fortis.tests;

import com.codeborne.selenide.Configuration;
import online.fortis.pages.RegistrationPage;
import online.fortis.pages.components.CalendarFilling;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
    }

    @Test
    void main() {
        open("https://demoqa.com/automation-practice-form");

        registrationPage.typeFirstName("Igor");
        registrationPage.typeLastName("Glazov");
        registrationPage.typeEmail("test@test.ru");
        registrationPage.setGender();
        registrationPage.typeNumber("9991234567");

        CalendarFilling calendarFilling = new CalendarFilling();
        calendarFilling.setDate("12", "August", "1986");

        registrationPage.setSubject("English");
        registrationPage.setSubject("Computer Science");
        registrationPage.setHobbiesSports();
        registrationPage.setHobbiesMusic();
        registrationPage.uploadPicture("files/Glazov.txt");
        registrationPage.typeAdress("Any Address");
        registrationPage.setState("Haryana");
        registrationPage.setCity("Karnal");
        registrationPage.clickSubmit();

        //проверка результата
        registrationPage.checkResultValue("Igor");
        registrationPage.checkResultValue("Glazov");
        registrationPage.checkResultValue("test@test.ru");
        registrationPage.checkResultValue("Other");
        registrationPage.checkResultValue("9991234567");
        registrationPage.checkResultValue("12 August,1986");
        registrationPage.checkResultValue("English, Computer Science");
        registrationPage.checkResultValue("Sports, Music");
        registrationPage.checkResultValue("Glazov.txt");
        registrationPage.checkResultValue("Any Address");
        registrationPage.checkResultValue("Haryana Karnal");
    }

}
