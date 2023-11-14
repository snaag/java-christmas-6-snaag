package christmas.service.checkstand.benefit.present;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PresentServiceTest {

    static PresentService presentService;

    @BeforeAll
    static void prepare() {
        presentService = new PresentService();
    }

    @ParameterizedTest
    @CsvSource({
            "150_000, true",
            "180_000, true",
            "120_000, true",
    })
    void 증정이벤트_존재(int totalPrice, boolean expectedEventExist) {
        assertThat(expectedEventExist)
                .isEqualTo(presentService.checkPresentExist(totalPrice));

    }

    @ParameterizedTest
    @CsvSource({
            "100_000, false",
            "119_999, false",
    })
    void 증정이벤트_없음(int totalPrice, boolean expectedEventExist) {
        assertThat(expectedEventExist)
                .isEqualTo(presentService.checkPresentExist(totalPrice));

    }


    @ParameterizedTest
    @CsvSource({
            "150_000, '샴페인'",
            "180_000, '샴페인'",
            "120_000, '샴페인'",
    })
    void 증정이벤트_샴페인(int totalPrice, String expectedPresentName) {
        assertThat(expectedPresentName)
                .isEqualTo(presentService.getPresent(totalPrice).getName());
    }

    @ParameterizedTest
    @CsvSource({
            "100_000",
            "119_999",
    })
    void 증정이벤트_없음(int totalPrice) {
        assertThat(presentService.getPresent(totalPrice)).isNull();
    }

}