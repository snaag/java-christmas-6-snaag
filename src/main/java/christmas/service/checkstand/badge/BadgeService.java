package christmas.service.checkstand.badge;

public class BadgeService {

    public int STAR_THRESHOLD = 5_000;
    public int TREE_THRESHOLD = 10_000;
    public int SANTA_THRESHOLD = 20_000;

    public Badge getBadge(int totalBenefitPrice) {
        if(totalBenefitPrice >= SANTA_THRESHOLD) {
            return Badge.SANTA;
        }
        if(totalBenefitPrice >= TREE_THRESHOLD) {
            return Badge.TREE;
        }
        if(totalBenefitPrice >= STAR_THRESHOLD)
            return Badge.STAR;

        return null;
    }
}
