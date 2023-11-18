package christmas.service.checkstand.benefit.discount;

import christmas.service.order.menu.Menu;
import java.util.HashMap;

public class DiscountService {
    private final ChristmasDiscountPolicyService christmasService;
    private final SpecialdayDiscountPolicyService specialdayService;
    private final WeekdayDiscountPolicyService weekdayService;
    private final WeekendDiscountPolicyService weekendService;

    public DiscountService() {
        this.christmasService = new ChristmasDiscountPolicyService();
        this.specialdayService = new SpecialdayDiscountPolicyService();
        this.weekdayService = new WeekdayDiscountPolicyService();
        this.weekendService = new WeekendDiscountPolicyService();
    }

    public HashMap<String, Integer> getDiscountHistory(HashMap<Menu, Integer> menus, int day) {
        HashMap<String, Integer> discountHistory = new HashMap<>();

        if(this.christmasService.getDiscountPrice(day) > 0)
            discountHistory.put(this.christmasService.getDiscountName(), this.christmasService.getDiscountPrice(day));
        if(this.weekdayService.getDiscountPrice(day, menus) > 0)
            discountHistory.put(this.weekdayService.getDiscountName(), this.weekdayService.getDiscountPrice(day, menus));
        if(this.weekendService.getDiscountPrice(day, menus) > 0)
            discountHistory.put(this.weekendService.getDiscountName(), this.weekendService.getDiscountPrice(day, menus));
        if(this.specialdayService.getDiscountPrice(day) > 0)
            discountHistory.put(this.specialdayService.getDiscountName(), this.specialdayService.getDiscountPrice(day));

        return discountHistory;
    }

}
