package ui.enums;

public enum NavigationBar {
    WHY_INSIDER("Why Insider"),
    PLATFORM("Platform"),
    SOLUTIONS(""),
    CUSTOMERS(""),
    RESOURCES(""),
    COMPANY("Company");

    private final String value;

    NavigationBar(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
