package christmas.controller;

import christmas.service.checkstand.CheckstandService;
import christmas.service.checkstand.badge.Badge;
import christmas.service.order.OrderService;
import christmas.service.order.menu.Menu;
import christmas.view.OutputView;

import java.util.HashMap;

import static christmas.utils.Constants.PRESENT_COUNT;


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
        this.printMenu();

        this.printBenefits();
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

    private void printMenu() {
        HashMap<Menu, Integer> menus = this.checkstandService.getMenus();

        String[] names = menus.keySet().stream()
                .map(Menu::getName)
                .toArray(String[]::new);

        int[] counts = menus.keySet().stream()
                .map(menus::get)
                .mapToInt(a -> a).toArray();

        OutputView.printMenu(names, counts);
    }

    public void printBenefits() {
        this.printTotalPrice();
        this.printPresent();
        this.printBenefitHistory();
        this.printTotalBenefitPrice();
        this.printExpectedPaymentAmount();
        this.printEventBadge();
    }


    private void printTotalPrice() {
        int totalPrice = this.checkstandService.getTotalPrice();
        OutputView.printTotalPrice(totalPrice);
    }

    private void printPresent() {
        Menu present = this.checkstandService.getPresent();

        if(present == null) {
            OutputView.printPresentNone();
            return;
        }

        OutputView.printPresent(present.getName(), PRESENT_COUNT);
    }



    private void printBenefitHistory() {
        HashMap<String, Integer> benefitHistory = this.checkstandService.getBenefitHistory();

        String[] benefits = benefitHistory.keySet().toArray(String[]::new);
        if(benefits.length == 0) {
            OutputView.printBenefitHistoryNone();
            return;
        }

        int[] price = benefitHistory.keySet().stream()
                .map(benefitHistory::get)
                .mapToInt(n -> n)
                .toArray();

        OutputView.printBenefitHistory(benefits, price);
    }

    private void printTotalBenefitPrice() {
        int totalBenefitPrice = this.checkstandService.getTotalBenefitPrice();

        OutputView.printTotalBenefitPrice(totalBenefitPrice);
    }

    private void printExpectedPaymentAmount() {
        int totalPrice = this.checkstandService.getTotalPrice();
        int discountPrice = this.checkstandService.getDiscountPrice();

        OutputView.printExpectedPaymentAmount(totalPrice - discountPrice);
    }

    private void printEventBadge() {
        Badge badge = this.checkstandService.getBadge();

        if(badge == null) {
            OutputView.printEventBadgeNone();
            return;
        }

        OutputView.printEventBadge(badge.getName());
    }
}

