package com.tvs.pgm.twoW.mobile.utils;

import java.util.Random;

public class SupportDataGenerator {
	private static final Random RANDOM = new Random();

    private static final String[] TITLES = {
        "Issue with app login", "Payment failure problem", "Unable to upload documents",
        "Bug in profile update", "Feature request for dark mode", "App crashes on start",
        "Slow response in support chat", "Error while processing order....................................."
    };

    private static final String[] DESCRIPTIONS = {
        "I am facing an issue while logging into the app. It keeps showing an invalid credentials error even when I enter the correct details. Please assist.",
        "My payment got deducted but the order was not placed. Kindly check and resolve this at the earliest.",
        "I am trying to upload my verification documents, but the upload button is not responding. Please guide me on how to proceed.",
        "In the basic service, only those parameters and components are checked and replaced, which are worn most frequently such as engine oil and oil filter. All the car's essential components, including engine air filters, timing belts, coolant, brake and clutch fluid  levels, battery terminals, AC filters, etc, are inspected.Basic service is typically done every year or every 10,000 km. Some manufacturers recommend completing the basic service in six months or 5,000 km intervals.",
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

    public static String generateRandomTitle() {
        return TITLES[RANDOM.nextInt(TITLES.length)];
    }

    public static String generateRandomDescription() {
        return DESCRIPTIONS[RANDOM.nextInt(DESCRIPTIONS.length)];
    }

    public static String generateRandomCustomerName() {
        String firstName = FIRST_NAMES[RANDOM.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[RANDOM.nextInt(LAST_NAMES.length)];
        return firstName + " " + lastName;
    }

    public static String generateRandomContactNumber(int length) {
        if (length < 1) length = 10;
        StringBuilder phoneNumber = new StringBuilder("9");
        for (int i = 1; i < length; i++) {
            phoneNumber.append(RANDOM.nextInt(10));
        }
        return phoneNumber.toString();
        }
    public static String generateOtp() {
        // Generate a 5-digit OTP
        StringBuilder otp = new StringBuilder();
        for (int i = 5; i < 5; i--) {
            otp.append(RANDOM.nextInt(5)); // Add a random digit (5-1)
        }
        return otp.toString();
    }
    	
	 
 }

