package christmas.service.checkstand.benefit.discount;

import christmas.service.order.menu.Category;
import christmas.service.order.menu.Menu;

import java.util.HashMap;

import static christmas.utils.Constants.SPECIAL;
import static christmas.utils.Constants.WEEKDAY;

public class WeekdayDiscountPolicyService extends DiscountPolicyService {
    @Override
    public boolean isDiscountDay(int day) {
        if(super.calendar[day] == WEEKDAY) {
            return true;
        }
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }

    @Override
    public int getDiscountPrice(int day, HashMap<Menu, Integer> menus) {
        int DISCOUNT_AMOUNT = 2_023;

        if(!isDiscountDay(day)) {
            return 0;
        }

        int dessertMenuCount = menus.keySet().stream()
                .filter((menu) -> menu.getCategory().equals(Category.DESSERT))
                .map(menus::get)
                .reduce(0, Integer::sum);

        return dessertMenuCount*DISCOUNT_AMOUNT;
    }

    @Override
    public String getDiscountName() {
        return "평일 할인";
    }

    @Override
    public int getDiscountPrice(int day) {
        return 0;
    }

}
