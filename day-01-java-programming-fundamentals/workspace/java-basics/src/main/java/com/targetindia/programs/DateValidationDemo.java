package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class DateValidationDemo {

    static boolean isLeap(int year){
        return (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0));
    }


    private static boolean isValidDate(int day, int month, int year) {

        if (year < 0) {
            // System.out.println("Invalid year. Must be >= 0.");
            return false;
        }

        if (month < 1 || month > 12) {
            // System.out.println("Invalid month. Must be between 1 and 12.");
            return false;
        }

        int maxDays = getMaxDays(month, year);

        if(day <1 || day >maxDays){
            // System.out.println("Invalid day. Must be between 1 and " + maxDays);
            return false;
        }

        return true;
    }

    private static int getMaxDays(int month, int year) {
        int maxDays = 31;

        switch (month) {
            case 2:
                maxDays = isLeap(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDays = 30;
        }
        return maxDays;
    }


    public static void main(String[] args) {
        int day, month, year;

        String name;
        name = KeyboardUtil.getString("Enter your name: ");
        System.out.printf("Hello, %s\n", name);

        day = KeyboardUtil.getInt("Enter day: ");
        month = KeyboardUtil.getInt("Enter month: ");
        year = KeyboardUtil.getInt("Enter year: ");

        boolean isValid = isValidDate(day, month, year);

        if(isValid){
            System.out.printf("%d/%d/%d represents a valid date\n", day, month, year);
        }
        else {
            System.out.printf("Combination of %d, %d and %d as day, month and year does not represent a valid date\n", day, month, year);
        }

    }
}
