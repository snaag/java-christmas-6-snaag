package christmas.service.checkstand.benefit.discount;

import christmas.utils.menu.Menu;

import java.util.HashMap;

import static christmas.utils.Constants.DAY_CHRISTMAS;
import static christmas.utils.Constants.DAY_UNDER_BOUND;

public class ChristmasDiscountPolicyService extends DiscountPolicyService {

    @Override
    public boolean isDiscountDay(int day) {
        if(day >= DAY_UNDER_BOUND && day <= DAY_CHRISTMAS) {
            return true;
        }
        return false;
    }

    @Override
    public int getDiscountPrice(int day) {
        int DAY_DISCOUNT_AMOUNT = 100;
        int BASE_DISCOUNT_AMOUNT = 1_000;

        if(!this.isDiscountDay(day)) {
            return 0;
        }
        return BASE_DISCOUNT_AMOUNT + (day-1)*DAY_DISCOUNT_AMOUNT;
    }

    @Override
    public String getDiscountName() {
        return "크리스마스 할인";
    }

    @Override
    public int getDiscountPrice(int day, HashMap<Menu, Integer> menus) {
        return 0;
    }
}
