package christmas.service.counter.discount;
package christmas.service.checkstand.benefit.discount;

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
}
