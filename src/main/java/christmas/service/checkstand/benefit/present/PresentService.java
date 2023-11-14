package christmas.service.checkstand.benefit.present;

import christmas.utils.menu.Menu;

public class PresentService {
    int PRESENT_THRESHOLD = 120_000;
    Menu PRESENT = Menu.CHAMPAGNE;
    String EVENT_NAME = "증정 이벤트";


    public boolean checkPresentExist(int totalPrice) {
        return totalPrice >= PRESENT_THRESHOLD;
    }

    public Menu getPresent(int totalPrice) {
        if(!this.checkPresentExist(totalPrice)) {
            return null;
        }

        return PRESENT;
    }

    public String getEventName() {
        return EVENT_NAME;
    }
}
