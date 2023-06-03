package demo.com.helpers;

import java.time.Month;
import java.time.Year;

public class RandomDataHelpers {

    public static String getRandomMonthName() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        int randomIndex = (int) (Math.random() * months.length);
        return months[randomIndex];
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        int randomIndex = (int) (Math.random() * genders.length);
        return genders[randomIndex];
    }

    public static String getRandomSubject() {
        String[] subjects = {"Chemistry", "English", "Computer Science", "Commerce", "Economics", "Social Studies", "Maths", "Arts", "Accounting"};
        int randomIndex = (int) (Math.random() * subjects.length);
        return subjects[randomIndex];
    }

    public static String getRandomHobbies() {
        String[] hobbies = {"Sports", "Reading", "Music"};
        int randomIndex = (int) (Math.random() * hobbies.length);
        return hobbies[randomIndex];
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        int randomIndex = (int) (Math.random() * states.length);
        return states[randomIndex];
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR":
                String[] ncrCities = {"Delhi", "Gurgaon", "Noida"};
                int ncrIndex = (int) (Math.random() * ncrCities.length);
                return ncrCities[ncrIndex];
            case "Uttar Pradesh":
                String[] upCities = {"Agra", "Lucknow", "Merrut"};
                int upIndex = (int) (Math.random() * upCities.length);
                return upCities[upIndex];
            case "Haryana":
                String[] haryanaCities = {"Karnal", "Panipat"};
                int haryanaIndex = (int) (Math.random() * haryanaCities.length);
                return haryanaCities[haryanaIndex];
            case "Rajasthan":
                String[] rajasthanCities = {"Jaipur", "Jaiselmer"};
                int rajasthanIndex = (int) (Math.random() * rajasthanCities.length);
                return rajasthanCities[rajasthanIndex];
            default:
                return "";
        }
    }

    public static String getRandomImageUrl() {
        String[] animals = {"images/cat.jpg", "images/dog.jpg"};
        int randomIndex = (int) (Math.random() * animals.length);
        return animals[randomIndex];
    }

    public static String getRandomImageFileName(String animalImage) {
        if (animalImage.equals("images/cat.jpg")) {
            return "cat.jpg";
        } else if (animalImage.equals("images/dog.jpg")) {
            return "dog.jpg";
        } else {
            return "";
        }
    }

    public static String getRandomDayOfMonth(String yearString, String monthName) {
        int year = Integer.parseInt(yearString);
        int month = Month.valueOf(monthName.toUpperCase()).getValue();
        int maxDay;
        if (month == 2) {
            if (Year.isLeap(year)) {
                maxDay = 29;
            } else {
                maxDay = 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            maxDay = 30;
        } else {
            maxDay = 31;
        }
        int randomDayOfMonth = (int) (Math.random() * maxDay) + 1;
        return randomDayOfMonth + "";
    }
}
