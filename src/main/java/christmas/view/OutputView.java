package christmas.view;

import java.text.NumberFormat;

public class OutputView {
    static NumberFormat numberFormat = NumberFormat.getNumberInstance();
    static String KR_CURRENCY = "원";
    static String UNIT = "개";

    public static void printBenefitGreeting(int day) {
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public static void printMenu(String[] menus, int[] counts) {
        System.out.println("<주문 메뉴>");
        for(int i=0; i<menus.length; i++) {
            System.out.println(menus[i] + " " + counts[i] + UNIT);
        }
    }

    public static void printTotalPrice(int price) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(numberFormat.format(price) + KR_CURRENCY);
    }

    public static void printPresent(String present, int count) {
        System.out.println("<증정 메뉴>");
        System.out.println(present + " " + count + UNIT);
    }

    public static void printPresentNone() {
        System.out.println("<증정 메뉴>");
        printNone();
    }

    public static void printBenefitHistory(String[] benefits, int[] price) {
        System.out.println("<혜택 내역>");

        for(int i=0; i< benefits.length; i++) {
            System.out.println(benefits[i] + ": -" + numberFormat.format(price[i]) + KR_CURRENCY);
        }
    }

    public static void printBenefitHistoryNone() {
        System.out.println("<혜택 내역>");
        printNone();
    }

    public static void printTotalBenefitPrice(int price) {
        System.out.println("<총혜택 금액>");
        System.out.println(numberFormat.format(price) + KR_CURRENCY);
    }

    public static void printExpectedPaymentAmount(int price) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(numberFormat.format(price) + KR_CURRENCY);

    }

    public static void printEventBadge(String badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    public static void printEventBadgeNone() {
        System.out.println("<12월 이벤트 배지>");
        printNone();
    }

    public static void printNewLine() {
        System.out.println();
    }

    private static void printNone() {
        System.out.println("없음");
    }

}
