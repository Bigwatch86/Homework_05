package online.fortis.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("[for='gender-radio-3']"),
            numberInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInputSports = $("[for=hobbies-checkbox-1]"),
            hobbiesInputMusic = $("[for=hobbies-checkbox-3]"),
            pictureUpload = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");


    public void typeFirstName(String name) {

        firstNameInput.setValue(name);
    }

    public void typeLastName(String surname) {

        lastNameInput.setValue(surname);
    }

    public void typeEmail(String email){

        emailInput.setValue(email);
    }

    public void setGender(){

        genderInput.click();
    }

    public void typeNumber(String number){

        numberInput.setValue(number);
    }

    public void setSubject(String subject){
        subjectsInput.setValue(subject).pressEnter();
    }

    public void setHobbiesSports(){

        hobbiesInputSports.click();
    }

    public void setHobbiesMusic(){

        hobbiesInputMusic.click();
    }

    public void uploadPicture(String fileName){

        pictureUpload.uploadFromClasspath(fileName);
    }

    public void typeAdress(String adress){

        adressInput.setValue(adress);
    }

    public void setState(String state){

        stateInput.setValue(state).pressEnter();
    }

    public void setCity(String city){

        cityInput.setValue(city).pressEnter();
    }

    public void clickSubmit(){

        submitClick.click();
    }

    public void checkResultValue(String value){
        resultsTable.shouldHave(text(value));
    }
}