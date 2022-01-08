package online.fortis.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import online.fortis.pages.RegistrationPage;
import online.fortis.pages.components.CalendarFilling;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormWithFaker {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String adress = faker.address().fullAddress();



    @BeforeAll
    static void beforeAll() {

        Configuration.browserSize = "1920x1080";
    }

    @Test
    void main() {
        open("https://demoqa.com/automation-practice-form");

        registrationPage.typeFirstName(firstName);
        registrationPage.typeLastName(lastName);
        registrationPage.typeEmail(userEmail);
        registrationPage.setGender();
        registrationPage.typeNumber(phoneNumber);

        CalendarFilling calendarFilling = new CalendarFilling();
        calendarFilling.setDate("12", "August", "1986");

        registrationPage.setSubject("English");
        registrationPage.setSubject("Computer Science");
        registrationPage.setHobbiesSports();
        registrationPage.setHobbiesMusic();
        registrationPage.uploadPicture("files/Glazov.txt");
        registrationPage.typeAdress(adress);
        registrationPage.setState("Haryana");
        registrationPage.setCity("Karnal");
        registrationPage.clickSubmit();

        //проверка результата
        registrationPage.checkResultValue(firstName);
        registrationPage.checkResultValue(lastName);
        registrationPage.checkResultValue(userEmail);
        registrationPage.checkResultValue("Other");
        registrationPage.checkResultValue(phoneNumber);
        registrationPage.checkResultValue("12 August,1986");
        registrationPage.checkResultValue("English, Computer Science");
        registrationPage.checkResultValue("Sports, Music");
        registrationPage.checkResultValue("Glazov.txt");
        registrationPage.checkResultValue(adress);
        registrationPage.checkResultValue("Haryana Karnal");
    }

}
