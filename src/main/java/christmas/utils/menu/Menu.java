package christmas.utils.menu;

import java.util.Arrays;

public enum Menu {
    MUSHROOM_SOUP(Category.APPETIZER, "양송이수프", 6_000),
    TAPAS(Category.APPETIZER, "타파스", 5_500),
    CAESAR_SALAD(Category.APPETIZER, "시저샐러드", 8_000),

    TBONE_STEAK(Category.MAIN, "티본스테이크", 55_000),
    BBQ_RIBS(Category.MAIN, "바비큐립", 54_000),
    SEAFOOD_PASTA(Category.MAIN, "해산물파스타", 35_000),
    CHRISTMAS_PASTA(Category.MAIN, "크리스마스파스타", 25_000),

    CHOCOLATE_CAKE(Category.DESSERT, "초코케이크", 15_000),
    ICE_CREAM(Category.DESSERT, "아이스크림", 5_000),

    ZERO_COKE(Category.BEVERAGE, "제로콜라", 3_000),
    RED_WINE(Category.BEVERAGE, "레드와인", 60_000),
    CHAMPAGNE(Category.BEVERAGE, "샴페인", 25_000);

    private final Category category;
    private final String name;
    private final int price;

    Menu(Category category, String name, int price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    public static Menu getMenu(String name) {
        Menu[] menus = Arrays.stream(Menu.values())
                .filter((menu) -> menu.getName().equals(name))
                .toArray(Menu[]::new);

        if(menus.length == 0) {
            return null;
        }

        return menus[0];
    }
}
