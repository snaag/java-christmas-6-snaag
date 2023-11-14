package christmas.controller;

import christmas.service.checkstand.CheckstandService;
import christmas.service.order.OrderService;
import christmas.utils.menu.Menu;
import christmas.view.OutputView;

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

        this.printBenefitOfToday();
    }

    public void order() {
        int day = this.orderService.pickDay();
        this.checkstandService.setDay(day);

        HashMap<Menu, Integer> menus = this.orderService.orderMenus();
        this.checkstandService.setMenus(menus);
    }

    private void printBenefitOfToday() {
        int day = this.checkstandService.getDay();
        OutputView.printBenefitGreeting(day);
    }
}

