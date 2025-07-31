package com.tvs.pgm.twoW.mobile.utils;

import java.util.Random;

public class SupportDataGenerator {
    private static final Random RANDOM = new Random();

    // Predefined arrays for titles, descriptions, names
    private static final String[] TITLES = {
        "Issue with app login", "Payment failure problem", "Unable to upload documents",
        "Bug in profile update", "Feature request for dark mode", "App crashes on start",
        "Slow response in support chat", "Error while processing order"
    };

    private static final String[] DESCRIPTIONS = {
        "I am facing an issue while logging into the app. It keeps showing an invalid credentials error even when I enter the correct details. Please assist.",
        "My payment got deducted but the order was not placed. Kindly check and resolve this at the earliest.",
        "I am trying to upload my verification documents, but the upload button is not responding. Please guide me on how to proceed.",
        "Basic service typically done every year or every 10,000 km. Some manufacturers recommend completing the basic service in six months or 5,000 km intervals.",
        "It would be great if you could introduce a dark mode option in the app for better readability at night.",
        "The app keeps crashing whenever I try to open it on my Android device. I have already cleared cache but the issue persists.",
        "The support chat takes too long to respond. It sometimes freezes, making it difficult to communicate with the support team.",
        "I am receiving an error message while trying to complete my order. The app is not letting me proceed with the payment."
    };

    private static final String[] FIRST_NAMES = {
        "MillerJohn", "Emma", "MichaelSmith", "Sophia", "MillerJames", "OliviaMiller", "William", "AvaGarcia", "Alexander", "Isabella"
    };

    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "BrowJohnsonn", "WilliamsGarcia", "JonesGarciaGarcia", "Miller", "Davis", "Garcia", "Martinez", "Taylor"
    };

    // Default values
    private static final String DEFAULT_PHONE_START = "9";
    private static final int DEFAULT_PHONE_LENGTH = 10;
    private static final int DEFAULT_OTP_LENGTH = 5;

    // Generate random issue title
    public static String generateRandomTitle() {
        return TITLES[RANDOM.nextInt(TITLES.length)];
    }

    // Generate random issue description
    public static String generateRandomDescription() {
        return DESCRIPTIONS[RANDOM.nextInt(DESCRIPTIONS.length)];
    }

    // Generate random customer name (first and last)
    public static String generateRandomCustomerName() {
        String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    // Generate random contact number (default length 10)
    public static String generateRandomContactNumber() {
        return generateRandomContactNumber(DEFAULT_PHONE_LENGTH);
    }

    // Generate random contact number with a specified length
    public static String generateRandomContactNumber(int length) {
        if (length < 1) length = DEFAULT_PHONE_LENGTH; // Default to 10 digits
        StringBuilder phoneNumber = new StringBuilder(DEFAULT_PHONE_START);  // Start with 9
        for (int i = 1; i < length; i++) {
            phoneNumber.append(RANDOM.nextInt(10));  // Random digit between 0-9
        }
        return phoneNumber.toString();
    }

    // Generate a random OTP (default length 5)
    public static String generateOtp() {
        return generateOtp(DEFAULT_OTP_LENGTH);
    }

    // Generate OTP with a specified length
    public static String generateOtp(int length) {
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < length; i++) {  // Loop to generate the specified length OTP
            otp.append(RANDOM.nextInt(10));  // Random digit between 0-9
        }
        return otp.toString();
    }
}