package christmas.controller;

import christmas.service.checkstand.CheckstandService;
import christmas.service.order.OrderService;
import christmas.utils.menu.Menu;

import java.util.HashMap;


public class ChristmasController {
    private final OrderService orderService;
    private final CheckstandService checkstandService;

    public ChristmasController() {
        this.orderService = new OrderService();
        this.checkstandService = new CheckstandService();
    }

    public void run() {
        this.order();
    }

    public void order() {
        int day = this.orderService.pickDay();
        this.checkstandService.setDay(day);

        HashMap<Menu, Integer> menus = this.orderService.orderMenus();
        this.checkstandService.setMenus(menus);
    }
}

