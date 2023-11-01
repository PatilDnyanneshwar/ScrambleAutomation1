package com.scramble.utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {

    private static Faker faker = new Faker();

    public static String numericValues(int count) {
        return RandomStringUtils.randomNumeric(count);
    }

    public static String generateUsername() { return "DP" + numericValues(4); }

    public static String generateFirstName() {
        return faker.name().firstName();
    }

    public static String generateLastName() {
        return faker.name().lastName();
    }

    public static String generateOrgEmailId() {
        return "dp" + numericValues(4) + "@demo.com";
    }

    public static String generateEmailId() {
        return "dp" + numericValues(4) + "+1@gmail.com";
    }

    public static String generateLdapId() { return "l_dp" + numericValues(3); }

    public static String generateWindowsId() { return "w_dp" + numericValues(3); }

    public static String generateMobileNumber() {return "+1943" + RandomStringUtils.randomNumeric(7);}

    public static String activationCode(int count) {
        return RandomStringUtils.randomNumeric(6);
    }

    public static String generateFullName() {
        return faker.name().fullName();
    }

    public static String generateCity() {
        return faker.address().city();
    }

    public static String generateAddress() {
        return faker.address().streetAddress();
    }

    public static String generatePostalCode(int count) {
        return RandomStringUtils.randomNumeric(count);
    }


    public static String generateUserRole() {
        return "USER ROLE " + numericValues(5);
    }

    public static String generateCountry() {
        return faker.address().country();
    }

    public static String alphabetic(int count) {
        return RandomStringUtils.randomAlphabetic(count).toUpperCase();
    }

    public static String alphaNumeric(int count) {
        return RandomStringUtils.randomAlphanumeric(count).toUpperCase();
    }

    public static String generatePassword() {
        return generateFirstName() + "@" + numericValues(3);
    }

    public static String generateConfirmPassword() {
        return "confirm" + numericValues(3);
    }

    public static String generateCompanyName() {
        return generateFirstName() + " Company";
    }
}