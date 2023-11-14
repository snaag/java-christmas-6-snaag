package christmas.service.counter.discount;
package christmas.service.checkstand.benefit.discount;

import static christmas.utils.Constants.*;

public class SpecialdayDiscountPolicyService extends DiscountPolicyService {

    String DISCOUNT_NAME = "특별 할인";
    int DISCOUNT_AMOUNT = 1_000;

    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }
}
