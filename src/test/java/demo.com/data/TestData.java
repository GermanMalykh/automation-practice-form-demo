package demo.com.data;

import com.github.javafaker.Faker;

import static demo.com.helpers.RandomDataHelpers.*;

public class TestData {
    Faker faker = new Faker();
    public String FIRST_NAME = faker.name().firstName(),
            LAST_NAME = faker.name().lastName(),
            EMAIL = faker.internet().emailAddress(),
            GENDER = getRandomGender(),
            PHONE_NUMBER = faker.number().numberBetween(7906000000L, 7906999999L) + "",
            MONTH = getRandomMonthName(),
            YEAR = faker.number().numberBetween(1900, 2022) + "",
            DAY = getRandomDayOfMonth(YEAR, MONTH),
            SUBJECT = getRandomSubject(),
            HOBBIES = getRandomHobbies(),
            URL_PICTURE = getRandomImageUrl(),
            NAME_PICTURE = getRandomImageFileName(URL_PICTURE),
            ADDRESS = faker.address().fullAddress(),
            STATE = getRandomState(),
            CITY = getRandomCity(STATE),
            TITLE_VALUE = "Thanks for submitting the form",
            FULL_NAME_COLUMN = "Student Name",
            EMAIL_COLUMN = "Student Email",
            GENDER_COLUMN = "Gender",
            MOBIlE_COLUMN = "Mobile",
            DATE_OF_BIRTH_COLUMN = "Date of Birth",
            SUBJECTS_COLUMN = "Subjects",
            HOBBIES_COLUMN = "Hobbies",
            PICTURE_FILE_NAME_COLUMN = "Picture",
            ADDRESS_COLUMN = "Address",
            STATE_AND_CITY_COLUMN = "State and City";
}
