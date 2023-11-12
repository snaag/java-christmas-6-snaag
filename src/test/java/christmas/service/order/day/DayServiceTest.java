package christmas.service.order.day;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DayServiceTest {

    DayService dayService = new DayService();

    @ParameterizedTest
    @CsvSource({
            "1", "2",
            "8", "9",
            "15", "16",
            "22", "23",
            "29", "30"
    })
    public void 주말_테스트(int day) {
        dayService.setDay(day);
        assertThat(dayService.isWeekend()).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({
            "3", "4", "5", "6", "7",
            "10", "11", "12", "13", "14",
            "17", "18", "19", "20", "21",
            "24", "25", "26", "27", "28",
            "31"
    })
    public void 평일_테스트(int day) {
        dayService.setDay(day);
        assertThat(dayService.isWeekday()).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({
            "3", "10", "17", "24", "25", "31"
    })
    public void 스페셜_데이_테스트(int day) {
        dayService.setDay(day);
        assertThat(dayService.isSpecialDay()).isEqualTo(true);
    }

}