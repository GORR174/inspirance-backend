package net.catstack.inspirance.component.enums;

public enum Roles {
    ADMIN("admin"),
    USER("user")
    ;

    private final String roleName;

    Roles(String name) {
        this.roleName = name;
    }

    public String getRoleName() {
        return roleName;
    }
}
