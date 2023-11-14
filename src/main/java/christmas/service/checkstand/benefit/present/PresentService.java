package christmas.service.checkstand.benefit.present;

import christmas.service.order.menu.Menu;

public class PresentService {

    public boolean checkPresentExist(int totalPrice) {
        int PRESENT_THRESHOLD = 120_000;
        return totalPrice >= PRESENT_THRESHOLD;
    }

    public Menu getPresent(int totalPrice) {
        Menu PRESENT = Menu.CHAMPAGNE;

        if(!this.checkPresentExist(totalPrice)) {
            return null;
        }

        return PRESENT;
    }

    public String getEventName() {
        return "증정 이벤트";
    }
}
