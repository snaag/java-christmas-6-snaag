package christmas.service.counter;

import christmas.utils.menu.Menu;

import java.util.HashMap;
import java.util.Set;

public class CounterService {

    public int getTotalPrice(HashMap<Menu, Integer> menus) {
        Set<Menu> orderMenus = menus.keySet();

        return orderMenus.stream()
                .map((menu) -> menu.getPrice() * menus.get(menu))
                .reduce(0, Integer::sum);
    }

}
