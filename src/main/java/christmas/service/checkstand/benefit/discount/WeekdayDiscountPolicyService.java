package christmas.service.checkstand.benefit.discount;

import christmas.utils.menu.Category;
import christmas.utils.menu.Menu;

import java.util.HashMap;

import static christmas.utils.Constants.SPECIAL;
import static christmas.utils.Constants.WEEKDAY;

public class WeekdayDiscountPolicyService extends DiscountPolicyService {

    String DISCOUNT_NAME = "평일 할인";

    int DISCOUNT_AMOUNT = 2_023;

    @Override
    public boolean isDiscountDay(int day) {
        if(super.calendar[day] == WEEKDAY) {
            return true;
        }
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }

    // TODO 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인  (동일 메뉴가 여러개면 여러번 할인)
    @Override
    public int getDiscountPrice(int day, HashMap<Menu, Integer> menus) {
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
        return this.DISCOUNT_NAME;
    }

    @Override
    public int getDiscountPrice(int day) {
        return 0;
    }

}
