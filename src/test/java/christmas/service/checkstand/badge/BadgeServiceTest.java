package christmas.service.checkstand.badge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BadgeServiceTest {
    static BadgeService badgeService;

    @BeforeAll
    static void prepare() {
        badgeService = new BadgeService();
    }

    @ParameterizedTest
    @CsvSource({
            "30_000, '산타'",
            "20_000, '산타'",
            "19_999, '트리'",
            "10_000, '트리'",
            "5_000, '별'"
    })
    void 뱃지_성공(int totalBenefitPrice, String badgeName) {
        assertThat(badgeName)
                .isEqualTo(badgeService.getBadge(totalBenefitPrice).getName());

    }
}