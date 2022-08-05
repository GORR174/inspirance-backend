package net.catstack.inspirance.component.enums;

public enum Categories {
    ILLUSTRATIONS("illustrations"),
    LOGOS("logos"),
    SITES("sites"),
    IDENTIFICATION("identification"),
    PACKAGE("package"),
    BANNERS("banners"),
    ;

    private final String categoryName;

    Categories(String name) {
        this.categoryName = name;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
