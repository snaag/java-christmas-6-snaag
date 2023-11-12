package christmas.service.order.day;

import christmas.dto.DayInputDto;
import christmas.utils.day.DayValidations;
import christmas.view.InputView;

public class DayService {
    private int day;
    private final DayInputDto dayInputDto;

    public DayService() {
        this.dayInputDto = new DayInputDto();
    }

    public void setDay() {
        while(!dayInputDto.isValid()) {
            this.checkValidDateOrError();
        }

        this.day = Integer.parseInt(this.dayInputDto.getDay());
    }

    public int getDay() {
        return this.day;
    }

    private void checkValidDateOrError() {
        try {
            String day = InputView.readDate();
            this.validateDate(day);
            dayInputDto.setValid(true);
            dayInputDto.setDay(day);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void validateDate(String givenDay) {
        DayValidations.checkNumber(givenDay);

        int day = Integer.parseInt(givenDay);
        DayValidations.checkInMonthRange(day);
    }
}
