package christmas.utils.day;

import static christmas.utils.Constants.ERROR_PREFIX;

public enum DayMessage {
    NOT_RANGE(ERROR_PREFIX + " 유효하지 않은 날짜입니다. 다시 입력해 주세요.");

    private final String message;
    DayMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
