package christmas.utils;

import static christmas.utils.Constants.ERROR_PREFIX;

public enum MenuMessage {
    NOT_VALID(ERROR_PREFIX + " 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    MenuMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
