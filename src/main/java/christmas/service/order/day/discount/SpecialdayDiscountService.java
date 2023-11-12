package christmas.service.order.day.discount;

import static christmas.utils.Constants.*;

public class SpecialdayDiscountService extends DiscountService {
    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }
}
