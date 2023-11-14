package christmas.service.checkstand.benefit.discount;

import christmas.utils.menu.Menu;

import java.util.HashMap;

import static christmas.utils.Constants.*;

public class SpecialdayDiscountPolicyService extends DiscountPolicyService {

    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }


    @Override
    public int getDiscountPrice(int day) {
        int DISCOUNT_AMOUNT = 1_000;

        if(!this.isDiscountDay(day)) {
            return 0;
        }
        return DISCOUNT_AMOUNT;
    }

    @Override
    public String getDiscountName() {
        return "특별 할인";
    }

    @Override
    public int getDiscountPrice(int day, HashMap<Menu, Integer> menus) {
        return 0;
    }
}
