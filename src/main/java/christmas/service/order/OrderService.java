package christmas.service.order;

import christmas.service.order.day.DayService;
import christmas.service.order.menu.MenuService;
import christmas.utils.menu.Menu;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.Set;

public class OrderService {
    DayService dayService;
    MenuService menuService;

    public OrderService() {
//        this.dayService = new DayService();
        this.menuService = new MenuService();
    }

    public void run() {
        this.menuService.setMenus();

        int total = this.getTotalPrice(this.menuService.getMenus());
        OutputView.printTotalPrice(total);
    }

    public int getTotalPrice(HashMap<Menu, Integer> menus) {
        Set<Menu> orderMenus = menus.keySet();
        
        return orderMenus.stream()
                .map((menu) -> menu.getPrice() * menus.get(menu))
                .reduce(0, Integer::sum);
    }

}
