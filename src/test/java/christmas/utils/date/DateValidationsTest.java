package christmas.utils.date;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DateValidationsTest {

    @ParameterizedTest
    @CsvSource({
            "a",
            "z09",
            "abicl",
            "9a!",
            "31.5"
    })
    public void 숫자가_아닌_경우(String number) {
        assertThrows(IllegalArgumentException.class, () -> {
           DateValidations.checkNumber(number);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "10",
            "100"
    })
    public void 숫자인_경우(String number) {
        DateValidations.checkNumber(number);
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "32",
            "45",
            "-1"
    })
    public void 범위_내_아닌_경우(int day) {
        assertThrows(IllegalArgumentException.class, () -> {
            DateValidations.checkInMonthRange(day);
        });
    }

    @ParameterizedTest
    @CsvSource({
            "1",
            "30",
            "9",
            "15"
    })
    public void 범위_내_경우(int day) {
        DateValidations.checkInMonthRange(day);
    }
}