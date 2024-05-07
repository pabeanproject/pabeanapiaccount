package id.my.pabeanapiaccount.model;

public enum ApplicationUserPermission {
    ORDER_READ_ALL("order:read_all"),
    ORDER_READ_SELF("order:read_self"),
    ORDER_CREATE("order:create"),
    ORDER_UPDATE("order:update"),
    ORDER_DELETE("order:delete");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
