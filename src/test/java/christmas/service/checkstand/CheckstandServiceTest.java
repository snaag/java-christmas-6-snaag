package christmas.service.checkstand;

import christmas.service.order.menu.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CheckstandServiceTest {
    static CheckstandService checkstandService;

    @BeforeAll
    public static void prepare() {
        checkstandService = new CheckstandService();
    }

    @MethodSource("providedMenus")
    @ParameterizedTest
    void 총계_출력(HashMap<Menu, Integer> menus, int expectedPrice) {
        checkstandService.setMenus(menus);

        assertThat(expectedPrice)
                .isEqualTo(checkstandService.getTotalPrice());

    }

    static Stream<Arguments> providedMenus() {
        return Stream.of(
                Arguments.of(new HashMap<Menu, Integer>() {{
                    put(Menu.MUSHROOM_SOUP, 2);
                    put(Menu.CHRISTMAS_PASTA, 1);
                    put(Menu.TBONE_STEAK, 1);
                    put(Menu.ZERO_COKE, 1);
                }}, 95000),
                Arguments.of(new HashMap<Menu, Integer>() {{
                    put(Menu.SEAFOOD_PASTA, 2);
                    put(Menu.RED_WINE, 1);
                    put(Menu.CHOCOLATE_CAKE, 1);
                }}, 145000)
        );
    }

}