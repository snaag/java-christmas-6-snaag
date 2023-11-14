package christmas.service.checkstand;

import christmas.service.checkstand.badge.Badge;
import christmas.service.checkstand.badge.BadgeService;
import christmas.service.checkstand.benefit.BenefitService;
import christmas.utils.menu.Menu;

import java.util.HashMap;
import java.util.Set;

public class CheckstandService {

    private int day;
    private int totalPrice;
    private HashMap<Menu, Integer> menus;

    private final BenefitService benefitService;
    private final BadgeService badgeService;

    public CheckstandService() {
        this.benefitService = new BenefitService();
        this.badgeService = new BadgeService();
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setTotalPrice(HashMap<Menu, Integer> givenMenus) {
        Set<Menu> orderMenus = givenMenus.keySet();

        this.totalPrice = orderMenus.stream()
                .map((menu) -> menu.getPrice() * givenMenus.get(menu))
                .reduce(0, Integer::sum);
    }

    public void setMenus(HashMap<Menu, Integer> menus) {
        this.menus = menus;
        this.setTotalPrice(menus);
    }

    public HashMap<Menu, Integer> getMenus() {
        return this.menus;
    }

    public int getTotalPrice() {
        return this.totalPrice;
    }

    public Menu getPresent() {
        return this.benefitService.getPresent(this.totalPrice);
    }

    public HashMap<String, Integer> getBenefitHistory() {
        return this.benefitService.getBenefitHistory(this.menus, this.day, this.totalPrice);
    }

    public int getDiscountPrice() {
        return this.benefitService.getDiscountPrice(this.menus, this.day);
    }

    public int getTotalBenefitPrice() {
        return this.benefitService.getTotalBenefitPrice(this.getBenefitHistory());
    }

    public Badge getBadge() {
        return this.badgeService.getBadge(this.getTotalBenefitPrice());
    }

    public int getDay() {
        return day;
    }
}
