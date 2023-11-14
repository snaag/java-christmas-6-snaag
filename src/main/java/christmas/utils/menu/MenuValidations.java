package christmas.utils.menu;

import christmas.service.order.menu.Category;
import christmas.service.order.menu.Menu;
import christmas.utils.MenuMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static christmas.utils.Constants.*;

public class MenuValidations {
    static String MENU_SYNTAX_REGEX = "^([ㄱ-ㅎ|ㅏ-ㅣ-가-힣]+[\\-][1-9]+[\\,])*([ㄱ-ㅎ|가-힣|ㅏ-ㅣ]+\\-[1-9]+)$";

    public static void checkMenuSyntax(String menu) {
        String pattern = MENU_SYNTAX_REGEX;
        if(!menu.matches(pattern)) {
            throw new IllegalArgumentException(MenuMessage.NOT_VALID.getMessage());
        }
    }

    public static void checkMenuMoreThan(String menu, int threshold) {
        int count = Integer.parseInt(menu.split(COUNT_SEPARATOR)[1]);
        if(threshold > count) {
            throw new IllegalArgumentException(MenuMessage.NOT_VALID.getMessage());
        }
    }

    public static void checkExistMenu(String givenMenu) {
        String menu = givenMenu.split(COUNT_SEPARATOR)[0];
        if(Menu.getMenu(menu) == null) {
            throw new IllegalArgumentException(MenuMessage.NOT_VALID.getMessage());
        }
    }

    public static void checkMenuDuplicate(String[] menus) {
        int menusCount = menus.length;

        String[] menusNames = Arrays.stream(menus)
                .map((menu) -> menu.split(COUNT_SEPARATOR)[0])
                .toArray(String[]::new);

        Set<String> set = new HashSet<>(Arrays.asList(menusNames));
        if(set.size() != menusCount) {
            throw new IllegalArgumentException(MenuMessage.NOT_VALID.getMessage());
        }
    }

    public static void checkTotalCountMoreThan(String[] menus, int threshold) {
        int total = Arrays.stream(menus)
                .map((menu) -> menu.split(COUNT_SEPARATOR)[1])
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);

        if(total > threshold) {
            throw new IllegalArgumentException(MenuMessage.NOT_VALID.getMessage());
        }
    }

    public static void checkOnlyBeverage(String[] menus) {
        long countNotBeverage =  Arrays.stream(menus)
                .map((menu) -> menu.split(COUNT_SEPARATOR)[0])
                .map(Menu::getMenu)
                .map((menu) -> menu.getCategory())
                .filter((category) -> !category.equals(Category.BEVERAGE))
                .count();

        if(countNotBeverage == 0) {
            throw new IllegalArgumentException(MenuMessage.NOT_VALID.getMessage());
        }
    }
}
