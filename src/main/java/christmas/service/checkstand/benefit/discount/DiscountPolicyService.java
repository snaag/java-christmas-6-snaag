package christmas.service.counter.discount;

import static christmas.utils.Constants.*;

public abstract class DiscountPolicyService {
    protected byte[] calendar;

    public DiscountPolicyService() {
        this.makeCalendar();
    }

    private void makeCalendar() {
        this.calendar = new byte[]{
                0,                                      WEEKEND,WEEKEND, // 1~2
                WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKEND,WEEKEND, // 3~9
                WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKEND,WEEKEND, // 10~16
                WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKEND,WEEKEND, // 17~23
                WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKDAY,WEEKEND,WEEKEND, // 24~30
                WEEKDAY                                                  // 31
        };

        byte[] specialDays = new byte[]{3, 10, 17, 24, 25, 31};
        for(byte specialDay: specialDays) {
            this.calendar[specialDay] += SPECIAL;
        }
    }

    public abstract boolean isDiscountDay(int day);
}
