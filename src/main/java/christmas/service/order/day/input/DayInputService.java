package christmas.service.order.day.input;

import christmas.dto.DayInputDto;
import christmas.utils.day.DayValidations;
import christmas.view.InputView;

public class DayInputService {
    private final DayInputDto dayInputDto;

    public DayInputService() {
        this.dayInputDto = new DayInputDto();
    }

    public int setDay() {
        while(!dayInputDto.isValid()) {
            this.checkValidDateOrError();
        }

        return Integer.parseInt(this.dayInputDto.getDay());
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
