package christmas.service.checkstand.benefit.discount;

import christmas.service.order.menu.Category;
import christmas.service.order.menu.Menu;

import java.util.HashMap;

import static christmas.utils.Constants.WEEKEND;

public class WeekendDiscountPolicyService extends DiscountPolicyService {

    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKEND;
    }

    @Override
    public int getDiscountPrice(int day, HashMap<Menu, Integer> menus) {
        int DISCOUNT_AMOUNT = 2_023;

        if(!this.isDiscountDay(day)) {
            return 0;
        }

        int mainMenuCount = menus.keySet().stream()
                .filter((menu) -> menu.getCategory().equals(Category.MAIN))
                .map(menus::get)
                .reduce(0, Integer::sum);

        return mainMenuCount*DISCOUNT_AMOUNT;
    }

    @Override
    public String getDiscountName() {
        return "특별 할인";
    }

    @Override
    public int getDiscountPrice(int day) {
        return 0;
    }

}
