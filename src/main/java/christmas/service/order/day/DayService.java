package christmas.service.order.day;

import christmas.service.order.day.input.DayInputService;

public class DayService {

    private final DayInputService dayInputService;
    private int day;

    public DayService() {
        this.dayInputService = new DayInputService();
    }

    public void setDay() {
        this.day = this.dayInputService.setDay();
    }
    public int getDay() {
        return this.day;
    }

}
