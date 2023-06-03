package demo.com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final static String
            URL = "/automation-practice-form",
            ARIAL = "aria-label";

    private final static SelenideElement
            FIRST_NAME = $("#firstName"),
            LAST_NAME = $("#lastName"),
            EMAIL = $("#userEmail"),
            GENDER = $("#genterWrapper"),
            NUMBER = $("#userNumber"),
            DATE_INPUT = $("#dateOfBirthInput"),
            MONTH = $(".react-datepicker__month-select"),
            YEAR = $(".react-datepicker__year-select"),
            SUBJECT = $("#subjectsInput"),
            HOBBIES = $("#hobbiesWrapper"),
            PICTURE = $("#uploadPicture"),
            ADDRESS = $("#currentAddress"),
            STATE = $("#state"),
            CITY = $("#city"),
            SUBMIT_BUTTON = $("#submit"),
            TITLE = $(".modal-title");

    private final static ElementsCollection
            DAY = $$(".react-datepicker__day"),
            TABLE_VALUE = $$("tr td");

    @Step("Переходим к форме регистрации")
    public RegistrationPage openPracticeFormPage() {
        open(URL);
        return this;
    }

    @Step("Указываем имя: {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        FIRST_NAME.setValue(firstName);
        return this;
    }

    @Step("Указываем фамилию: {lastName}")
    public RegistrationPage setLastName(String lastName) {
        LAST_NAME.setValue(lastName);
        return this;
    }

    @Step("Указываем email: {email}")
    public RegistrationPage setEmail(String email) {
        EMAIL.setValue(email);
        return this;
    }

    @Step("Указываем пол: {gender}")
    public RegistrationPage setGender(String gender) {
        GENDER.$(byText(gender)).click();
        return this;
    }

    @Step("Указываем номер телефона: {number}")
    public RegistrationPage setUserNumber(String number) {
        NUMBER.setValue(number);
        return this;
    }

    @Step("Нажимаем на календарь")
    public RegistrationPage selectDateOfBirthInput() {
        DATE_INPUT.click();
        return this;
    }

    @Step("Переходим к выбору месяца")
    public RegistrationPage selectMonth(String month) {
        MONTH.$(byText(month)).click();
        return this;
    }

    @Step("Переходим к выбору года")
    public RegistrationPage selectYear(String year) {
        YEAR.$(byText(year)).click();
        return this;
    }

    @Step("Переходим к выбору дня")
    public RegistrationPage selectDay(String month, String dayNumber) {
        DAY.filterBy(Condition.attributeMatching(ARIAL, ".*" + month + ".*")).findBy(text(dayNumber)).click();
        return this;
    }

    @Step("Указываем дату рождения: {dayNumber}.{month}.{year}")
    public RegistrationPage selectDateOfBirth(String month, String year, String dayNumber) {
        selectDateOfBirthInput();
        selectMonth(month);
        selectYear(year);
        selectDay(month, dayNumber);
        return this;
    }

    @Step("Указываем предмет: {subject}")
    public RegistrationPage setSubject(String subject) {
        SUBJECT.setValue(subject).pressEnter();
        return this;
    }

    @Step("Указываем хобби: {hobbies}")
    public RegistrationPage setHobbies(String hobbies) {
        HOBBIES.$(byText(hobbies)).click();
        return this;
    }

    @Step("Загружаем фотографию: {picturePathName}")
    public RegistrationPage setPicture(String picturePathName) {
        PICTURE.uploadFromClasspath(picturePathName);
        return this;
    }

    @Step("Указываем адрес: {address}")
    public RegistrationPage setAddress(String address) {
        ADDRESS.setValue(address);
        return this;
    }

    @Step("Указываем штат: {state}")
    public RegistrationPage setState(String state) {
        STATE.click();
        $(byText(state)).click();
        return this;
    }

    @Step("Указываем город: {city}")
    public RegistrationPage setCity(String city) {
        CITY.click();
        $(byText(city)).click();
        return this;
    }

    @Step("Отправляем заполненную форму")
    public RegistrationPage submitForm() {
        SUBMIT_BUTTON.click();
        return this;
    }

    @Step("Проверяем наличие заголовка {title} в форме результатов")
    public RegistrationPage titleCheck(String title) {
        TITLE.shouldHave(text(title));
        return this;
    }

    @Step("Проверяем, что в колонке {key} отображается переданное значение {value}")
    public RegistrationPage tableValueCheck(String key, String value) {
        TABLE_VALUE.filterBy(text(key)).first().sibling(0).shouldHave(text(value));
        return this;
    }

}
