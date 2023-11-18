package christmas.service.order.menu;

import christmas.service.order.menu.input.MenuInputService;

import java.util.Arrays;
import java.util.HashMap;

import static christmas.utils.Constants.COUNT_SEPARATOR;

public class MenuService {

    private final MenuInputService menuInputService;
    private final HashMap<Menu, Integer> menus;


    public MenuService() {
        this.menuInputService = new MenuInputService();
        this.menus = new HashMap<>();
    }

    public void setMenus() {
        String[] givenMenus = this.menuInputService.getInputMenus();
        this.menuMapper(givenMenus);
    }

    public HashMap<Menu, Integer> getMenus() {
        return this.menus;
    }

    private void menuMapper(String[] givenMenus) {
        Arrays.stream(givenMenus).forEach((menu) -> {
            String name = menu.split(COUNT_SEPARATOR)[0];
            int count = Integer.parseInt(menu.split(COUNT_SEPARATOR)[1]);
            this.menus.put(Menu.getMenu(name), count);
        });
    }
}
