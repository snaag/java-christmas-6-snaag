package christmas.service.order;

import christmas.service.order.day.DayService;
import christmas.service.order.menu.MenuService;
import christmas.utils.menu.Menu;

import java.util.HashMap;

public class OrderService {
    DayService dayService;
    MenuService menuService;

    public OrderService() {
        this.dayService = new DayService();
        this.menuService = new MenuService();
    }

    public int pickDay() {
        return this.dayService.pickDay();
    }

    public HashMap<Menu, Integer> orderMenus() {
        this.menuService.setMenus();
        return this.menuService.getMenus();
    }


}
