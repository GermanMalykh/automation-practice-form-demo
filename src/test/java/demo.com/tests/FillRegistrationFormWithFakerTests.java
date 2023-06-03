package demo.com.tests;

import io.qameta.allure.Description;
import demo.com.config.TestBase;
import demo.com.data.TestData;
import demo.com.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Заполнение формы и проверка результатов")
public class FillRegistrationFormWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();

    @Description("Демо проект")
    @DisplayName("Успешное заполнение формы регистрации")
    @Test
    void fillFormTest() {
        registrationPage
                .openPracticeFormPage()
                .removeGarbageElements()
                .setFirstName(testData.FIRST_NAME)
                .setLastName(testData.LAST_NAME)
                .setEmail(testData.EMAIL)
                .setGender(testData.GENDER)
                .setUserNumber(testData.PHONE_NUMBER)
                .selectDateOfBirth(testData.MONTH, testData.YEAR, testData.DAY)
                .setSubject(testData.SUBJECT)
                .setHobbies(testData.HOBBIES)
                .setPicture(testData.URL_PICTURE)
                .setAddress(testData.ADDRESS)
                .setState(testData.STATE)
                .setCity(testData.CITY)
                .submitForm()
                .titleCheck(testData.TITLE_VALUE)
                .tableValueCheck(testData.FULL_NAME_COLUMN, testData.FIRST_NAME + " " + testData.LAST_NAME)
                .tableValueCheck(testData.EMAIL_COLUMN, testData.EMAIL)
                .tableValueCheck(testData.GENDER_COLUMN, testData.GENDER)
                .tableValueCheck(testData.MOBIlE_COLUMN, testData.PHONE_NUMBER)
                .tableValueCheck(testData.DATE_OF_BIRTH_COLUMN, testData.DAY + " " + testData.MONTH + "," + testData.YEAR)
                .tableValueCheck(testData.SUBJECTS_COLUMN, testData.SUBJECT)
                .tableValueCheck(testData.HOBBIES_COLUMN, testData.HOBBIES)
                .tableValueCheck(testData.PICTURE_FILE_NAME_COLUMN, testData.NAME_PICTURE)
                .tableValueCheck(testData.ADDRESS_COLUMN, testData.ADDRESS)
                .tableValueCheck(testData.STATE_AND_CITY_COLUMN, testData.STATE + " " + testData.CITY);
    }
}
