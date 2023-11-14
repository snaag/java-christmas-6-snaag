package christmas.service.order.day.discount;

import christmas.service.checkstand.benefit.discount.ChristmasDiscountPolicyService;
import christmas.service.checkstand.benefit.discount.SpecialdayDiscountPolicyService;
import christmas.service.checkstand.benefit.discount.WeekdayDiscountPolicyService;
import christmas.service.checkstand.benefit.discount.WeekendDiscountPolicyService;
import christmas.utils.menu.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountPolicyServiceTest {
    static SpecialdayDiscountPolicyService specialdayDiscountService;
    static WeekendDiscountPolicyService weekendDiscountService;
    static WeekdayDiscountPolicyService weekdayDiscountService;
    static ChristmasDiscountPolicyService christmasDiscountService;

    @BeforeAll
    static void prepare() {
        weekdayDiscountService = new WeekdayDiscountPolicyService();
        weekendDiscountService = new WeekendDiscountPolicyService();
        specialdayDiscountService = new SpecialdayDiscountPolicyService();
        christmasDiscountService = new ChristmasDiscountPolicyService();
    }

    @ParameterizedTest
    @CsvSource({
            "1", "2",
            "8", "9",
            "15", "16",
            "22", "23",
            "29", "30"
    })
    public void 주말_테스트(int day) {
        assertThat(weekendDiscountService.isDiscountDay(day))
                .isEqualTo(true);
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
        assertThat(weekdayDiscountService.isDiscountDay(day))
                .isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({
            "3", "10", "17", "24", "25", "31"
    })
    public void 스페셜_데이_테스트(int day) {
        assertThat(specialdayDiscountService.isDiscountDay(day))
                .isEqualTo(true);
    }


    @MethodSource("providedMenusWeekday")
    @ParameterizedTest
    void 평일_할인(int day, HashMap<Menu, Integer> menus, int expectedDiscountPrice) {
        int discountPrice = weekdayDiscountService.getDiscountPrice(day, menus);
        assertThat(discountPrice).isEqualTo(expectedDiscountPrice);
    }

    static Stream<Arguments> providedMenusWeekday() {
        return Stream.of(
                Arguments.of(3, new HashMap<Menu, Integer>() {{
                    put(Menu.MUSHROOM_SOUP, 2);
                    put(Menu.TAPAS, 2);
                    put(Menu.BBQ_RIBS, 2);
                    put(Menu.TBONE_STEAK, 1);
                    put(Menu.CHRISTMAS_PASTA, 2);
                    put(Menu.CHOCOLATE_CAKE, 3);
                    put(Menu.ICE_CREAM, 2);
                    put(Menu.ZERO_COKE, 1);
                }}, 10_115),
                Arguments.of(18, new HashMap<Menu, Integer>() {{
                    put(Menu.SEAFOOD_PASTA, 2);
                    put(Menu.RED_WINE, 1);
                    put(Menu.CHOCOLATE_CAKE, 1);
                    put(Menu.ICE_CREAM, 5);
                }}, 12_138)
        );
    }

    @MethodSource("providedMenusWeekend")
    @ParameterizedTest
    void 주말_할인(int day, HashMap<Menu, Integer> menus, int expectedDiscountPrice) {
        int discountPrice = weekendDiscountService.getDiscountPrice(day, menus);
        assertThat(discountPrice).isEqualTo(expectedDiscountPrice);
    }

    static Stream<Arguments> providedMenusWeekend() {
        return Stream.of(
                Arguments.of(8, new HashMap<Menu, Integer>() {{
                    put(Menu.MUSHROOM_SOUP, 2);
                    put(Menu.TAPAS, 2);
                    put(Menu.BBQ_RIBS, 2);
                    put(Menu.TBONE_STEAK, 3);
                    put(Menu.CHRISTMAS_PASTA, 2);
                    put(Menu.CHOCOLATE_CAKE, 3);
                    put(Menu.ZERO_COKE, 1);
                }}, 14_161),
                Arguments.of(30, new HashMap<Menu, Integer>() {{
                    put(Menu.SEAFOOD_PASTA, 2);
                    put(Menu.TBONE_STEAK, 2);
                    put(Menu.RED_WINE, 1);
                    put(Menu.CHOCOLATE_CAKE, 1);
                    put(Menu.ICE_CREAM, 5);
                }}, 8_092)
        );
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1000",
            "2, 1100",
            "25, 3400",
            "26, 0",
            "30, 0",
            "31, 0"
    })
    void 크리스마스_할인(int day, int expectedDiscountPrice) {
        int discountPrice = christmasDiscountService.getDiscountPrice(day);
        assertThat(discountPrice).isEqualTo(expectedDiscountPrice);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 1000",
            "10, 1000",
            "17, 1000",
            "24, 1000",
            "25, 1000",
            "31, 1000",
            "2, 0",
            "4, 0",
            "18, 0",
            "19, 0",
            "29, 0"

    })
    void 특별_할인(int day, int expectedDiscountPrice) {
        int discountPrice = specialdayDiscountService.getDiscountPrice(day);
        assertThat(discountPrice).isEqualTo(expectedDiscountPrice);
    }
}