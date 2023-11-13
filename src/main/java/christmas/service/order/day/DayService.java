package christmas.service.order.day;

import christmas.service.order.day.input.DayInputService;

public class DayService {

    private final DayInputService dayInputService;
    private int day;

    public DayService() {
        this.dayInputService = new DayInputService();
    }

    public int pickDay() {
        this.day = this.dayInputService.getInputDay();
        return this.day;
    }
    public int getDay() {
        return this.day;
    }

}
