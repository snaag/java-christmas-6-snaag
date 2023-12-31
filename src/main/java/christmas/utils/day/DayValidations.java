package christmas.utils.day;

import static christmas.utils.Constants.DAY_UNDER_BOUND;
import static christmas.utils.Constants.DAY_UPPER_BOUND;

public class DayValidations {
    static String NUMBER_REGEX = "^[0-9]+$";

    public static void checkNumber(String number) {
        boolean matches = number.matches(NUMBER_REGEX);

        if(!matches) {
            throw new IllegalArgumentException(DayMessage.NOT_RANGE.getMessage());
        }
    }

    public static void checkInMonthRange(int day) {
        if(day < DAY_UNDER_BOUND || day > DAY_UPPER_BOUND) {
            throw new IllegalArgumentException(DayMessage.NOT_RANGE.getMessage());
        }
    }
}
