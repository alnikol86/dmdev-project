package src.homeWorkNine.parser;

public class PhoneNumberFormatter {
    private static final String PATTERN_NUMBER = "(\\d{3})(\\d{2})(\\d{3})(\\d{2})(\\d{2})";

    public static String format(String phoneNumber) {
        String phoneNumberOnlyDigits = phoneNumber.replaceAll("\\D", "");
        if (phoneNumberOnlyDigits.length() < 12) {
            phoneNumberOnlyDigits = 375 + phoneNumberOnlyDigits;
        }
        return phoneNumberOnlyDigits.replaceAll("\\D", "").
                replaceFirst(PATTERN_NUMBER, "+375 ($2) $3-$4-$5");
    }
}
