package org.example;

public class ReversedDate {

    public static void main(String[] args) {
        int fromYear = 2000;
        int toYear = 2080;

        printBonusDatesBetween(fromYear, toYear);
    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {
        for (int year = fromYear; year <= toYear; year++) {

            String extractedMonthAsString = String.format("%02d", year % 100);
            String extractedDayAsString = String.format("%02d", year / 100);

            String reversedMonthAsString = reverseDigits(extractedMonthAsString);
            String reversedDayAsString = reverseDigits(extractedDayAsString);

            int formattedMonth = Integer.parseInt(reversedMonthAsString);
            int formattedDay = Integer.parseInt(reversedDayAsString);

            if (isValidDate(year, formattedDay, formattedMonth)) {
                System.out.println(String.format("%04d-%02d-%02d", year, formattedMonth, formattedDay));
            }
        }
    }

    public static String reverseDigits(String number) {

        StringBuilder reversedDigits = new StringBuilder(number);
        reversedDigits.reverse();

        return reversedDigits.toString();
    }

    public static boolean isValidDate(int year, int formattedDay, int formattedMonth) {
        if (formattedMonth <= 0 || formattedMonth > 12 || formattedDay <= 0) {
            return false;
        }

        if (formattedMonth == 1 || formattedMonth == 3 || formattedMonth == 5 ||
                formattedMonth == 7 || formattedMonth == 8 || formattedMonth == 10 ||
                formattedMonth == 12) {
            return formattedDay <= 31;
        }

        if (formattedMonth == 4 || formattedMonth == 6 || formattedMonth == 9 ||
                formattedMonth == 11) {
            return formattedDay <= 30;
        }

        if (formattedMonth == 2) {
            if (formattedDay > 29) {
                return false;
            } else if (formattedDay == 29) {
                return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            }
            return formattedDay <= 28;
        }
        return true;
    }
}
