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


}
