package christmas.service.counter.discount;

import static christmas.utils.Constants.WEEKEND;

public class WeekendDiscountPolicyService extends DiscountPolicyService {

    String DISCOUNT_NAME = "특별 할인";
    int DISCOUNT_AMOUNT = 2_023;

    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKEND;
    }
}
