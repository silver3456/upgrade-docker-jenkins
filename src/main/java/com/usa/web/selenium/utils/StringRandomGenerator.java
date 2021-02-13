package com.usa.web.selenium.utils;

import java.util.Random;

public class StringRandomGenerator {

    public static void saveCreds() {
        generateEmail();
        provideValidPassword(9);
    }


    public static String generateEmail() {
        long timeStamp = System.currentTimeMillis();
        return String.format("AlexSomov%s@upgrade-challenge.com", timeStamp);
    }

    private static String generatePassword(int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());

        for (int i = 0; i < length; i++) {
            String charCategory = charCategories[random.nextInt(charCategories.length)];
            int position = random.nextInt(charCategory.length());
            password.append(charCategory.charAt(position));
        }

        return new String(password);
    }

    private static final String[] charCategories = new String[]{
            "abcdefghijklmnopqrstuvwxyz",
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ",
            "0123456789"
    };

    public static String provideValidPassword(int length) {

        String initPass;
        boolean flag;

        do {
            initPass = generatePassword(length);
            flag = isPasswordValid(initPass);
        } while (!flag);

        return initPass;
    }

    private static boolean isPasswordValid(String password) {
        boolean upperCase = !password.equals(password.toLowerCase());
        boolean lowerCase = !password.equals(password.toUpperCase());
        boolean isAtLeast8 = password.length() >= 8;
        boolean hasNumber = password.matches(".*\\d+.*");

        if (!isAtLeast8) {
            return false;
        } else if (!upperCase) {
            return false;
        } else if (!lowerCase) {
            return false;
        } else if (!hasNumber) {
            return false;
        } else {
            return true;
        }
    }


}
