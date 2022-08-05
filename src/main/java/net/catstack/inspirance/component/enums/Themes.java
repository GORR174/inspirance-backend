package net.catstack.inspirance.component.enums;

public enum Themes {
    TECHNOLOGIES("technologies"),
    FOOD("food"),
    FASHION("fashion"),
    SPORT("sport"),
    EDUCATION("education"),
    ;

    private final String themeName;

    Themes(String name) {
        this.themeName = name;
    }

    public String getThemeName() {
        return themeName;
    }
}
