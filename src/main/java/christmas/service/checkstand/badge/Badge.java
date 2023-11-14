package christmas.service.checkstand.badge;

public enum Badge {
    STAR("별"),
    TREE("트리"),
    SANTA("산타")
    ;

    final String name;
    Badge(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
