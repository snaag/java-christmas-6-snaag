package christmas.service.counter.discount;

import static christmas.utils.Constants.SPECIAL;
import static christmas.utils.Constants.WEEKDAY;

public class WeekdayDiscountService extends DiscountService {
    @Override
    public boolean isDiscountDay(int day) {
        if(super.calendar[day] == WEEKDAY) {
            return true;
        }
        return super.calendar[day] == WEEKDAY + SPECIAL;
    }
}
