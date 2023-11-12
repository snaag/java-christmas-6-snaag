package christmas.service.order.day.discount;

import static christmas.utils.Constants.WEEKEND;

public class WeekendDiscountService extends DiscountService {
    @Override
    public boolean isDiscountDay(int day) {
        return super.calendar[day] == WEEKEND;
    }
}
