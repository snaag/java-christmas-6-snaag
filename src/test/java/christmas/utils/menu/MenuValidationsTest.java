package christmas.utils.menu;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MenuValidationsTest {

    @ParameterizedTest
    @ValueSource(strings = {
         "해산물파스타-2,레드와인-1초코케이크-1",
         "해산물파스타-2,레드와인-1초코케이크--1,",
         "",
         "해산물파스타-a,레드와인-1,초코케이크-1",
         "-3"
    })
    void 잘못된_메뉴형식(String menu) {
        assertThrows(IllegalArgumentException.class, () -> {
            MenuValidations.checkMenuSyntax(menu);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-2,레드와인-1,초코케이크-1",
            "해산물파스타-1",
    })
    void 옳은_메뉴형식(String menu) {
        MenuValidations.checkMenuSyntax(menu);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-0",
            "레드와인-0"
    })
    void 잘못된_메뉴갯수(String menu) {
        assertThrows(IllegalArgumentException.class, () -> {
            MenuValidations.checkMenuMoreThan(menu, 1);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "해산물파스타-1",
            "레드와인-2"
    })
    void 옳은_메뉴갯수(String menu) {
        MenuValidations.checkMenuMoreThan(menu, 1);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "토마토수프-3",
            "당근케이크-5",
            "케일주스-1"
    })
    void 없는_메뉴(String menu) {
        assertThrows(IllegalArgumentException.class, () -> {
            MenuValidations.checkExistMenu(menu);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "시저샐러드-3",
            "크리스마스파스타-5",
    })
    void 있는_메뉴(String menu) {
        MenuValidations.checkExistMenu(menu);
    }

    @ParameterizedTest
    @MethodSource("providedMenusDuplicate")
    void 중복_메뉴(String[] menus) {
        assertThrows(IllegalArgumentException.class, () -> {
            MenuValidations.checkMenuDuplicate(menus);
        });
    }

    static Stream<Arguments> providedMenusDuplicate() {
        return Stream.of(
                Arguments.of((Object) new String[]{"해산물파스타-2","해산물파스타-1","초코케이크-1"}),
                Arguments.of((Object) new String[]{"초코케이크-2","해산물파스타-1","초코케이크-1"})
        );
    }

    @ParameterizedTest
    @MethodSource("providedMenus")
    void 중복_없는_메뉴(String[] menus) {
        MenuValidations.checkMenuDuplicate(menus);
    }

    static Stream<Arguments> providedMenus() {
        return Stream.of(
                Arguments.of((Object) new String[]{"해산물파스타-2","초코케이크-1"}),
                Arguments.of((Object) new String[]{"시저샐러드-1","초코케이크-1"})
        );
    }
}