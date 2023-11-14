package christmas.service.checkstand.benefit.discount;

import christmas.utils.menu.Menu;

import java.util.HashMap;

import static christmas.utils.Constants.*;

public class SpecialdayDiscountPolicyService extends DiscountPolicyService {

    String DISCOUNT_NAME = "특별 할인";
    int DISCOUNT_AMOUNT = 1_000;

    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }


    @Override
    public int getDiscountPrice(int day) {
        if(!this.isDiscountDay(day)) {
            return 0;
        }
        return DISCOUNT_AMOUNT;
    }

    @Override
    public String getDiscountName() {
        return this.DISCOUNT_NAME;
    }

    @Override
    public int getDiscountPrice(int day, HashMap<Menu, Integer> menus) {
        return 0;
    }
}
