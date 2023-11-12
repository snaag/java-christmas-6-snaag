package christmas.service.order.day;

import static christmas.utils.Constants.*;

public class DayService {
    private int day;
    private byte[] calendar;

    public DayService() {
        this.makeCalendar();
    }

    public void makeCalendar() {
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

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public boolean isWeekday(int day) {
        if(this.calendar[day] == WEEKDAY) {
            return true;
        }

        return this.calendar[day] == WEEKDAY + SPECIAL;
    }

    public boolean isWeekend(int day) {
        return this.calendar[day] == WEEKEND;
    }

    public boolean isSpecialDay(int day) {
        return this.calendar[day] == WEEKDAY + SPECIAL;
    }
}
