package christmas.service.checkstand.benefit;

import christmas.service.checkstand.benefit.discount.DiscountService;
import christmas.service.checkstand.benefit.present.PresentService;
import christmas.service.order.menu.Menu;

import java.util.HashMap;

public class BenefitService {

    private final DiscountService discountService;
    private final PresentService presentService;

    public BenefitService() {
        this.discountService = new DiscountService();
        this.presentService = new PresentService();
    }


    public HashMap<String, Integer> getBenefitHistory(HashMap<Menu, Integer> menus, int day, int totalPrice) {
        HashMap<String, Integer> benefitHistory = this.discountService.getDiscountHistory(menus, day);

        Menu present = this.presentService.getPresent(totalPrice);
        if(present != null) {
            benefitHistory.put(this.presentService.getEventName(), present.getPrice());
        }

        return benefitHistory;
    }

    public int getTotalBenefitPrice(HashMap<String, Integer> benefitHistory) {
        return benefitHistory.keySet().stream()
                .map(benefitHistory::get)
                .reduce(0, Integer::sum);
    }

    public Menu getPresent(int totalPrice) {
        return this.presentService.getPresent(totalPrice);
    }

    public int getDiscountPrice(HashMap<Menu, Integer> menus, int day) {
        HashMap<String, Integer> benefitHistory = this.discountService.getDiscountHistory(menus, day);

        return benefitHistory.keySet().stream()
                .map(benefitHistory::get)
                .reduce(0, Integer::sum);

    }
}
